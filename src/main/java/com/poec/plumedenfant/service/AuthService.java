package com.poec.plumedenfant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.poec.plumedenfant.config.JwtTokenProvider;
import com.poec.plumedenfant.dao.RoleDao;
import com.poec.plumedenfant.dao.UtilisateurDao;
import com.poec.plumedenfant.dao.model.Role;
import com.poec.plumedenfant.dao.model.RoleEnum;
import com.poec.plumedenfant.dao.model.Utilisateur;
import com.poec.plumedenfant.dto.InscriptionDto;
import com.poec.plumedenfant.dto.LoginDto;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Autowired
	private RoleDao roleDao;
	
	public String login(LoginDto loginDto) {
		
		// 01 - AuthenticationManager is used to authenticate the user
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDto.getEmail(), 
				loginDto.getMdp()
		));
		
		/* 02 - SecurityContextHolder is used to allows the rest of the application to know
        that the user is authenticated and can use user data from Authentication object */
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// 03 - Generate the token based on username and secret key
		String token = jwtTokenProvider.generateToken(authentication);
		
		// 04 - Return the token to controller
		return token;
	}
	
	public Utilisateur register(InscriptionDto inscriptionDto) {
		// Créer un nouvel utilisateur depuis l'inscription DTO
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(inscriptionDto.getEmail());
		utilisateur.setMdp(inscriptionDto.getMdp());
		
		// Encoder le mot de passe
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(inscriptionDto.getMdp());
		utilisateur.setMdp(encodedPassword);
		
		// Save l'utilisateur dans la BDD
		Utilisateur savedUtilisateur = utilisateurDao.save(utilisateur);
		
		// Set le role par defaut
		Role utilisateurRole = roleDao.findByName(RoleEnum.USER.toString()).get();
		savedUtilisateur.getRoles().add(utilisateurRole);
		savedUtilisateur = utilisateurDao.save(savedUtilisateur);
		
		return savedUtilisateur;
		}
	
}
