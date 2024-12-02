package com.poec.plumedenfant.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.poec.plumedenfant.dao.UtilisateurDao;
import com.poec.plumedenfant.dao.model.Utilisateur;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UtilisateurDao utilisateurDao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


		Utilisateur utilisateur = utilisateurDao.findByEmail(email).orElseThrow(() -> 
					new UsernameNotFoundException("L'email renseigné n'existe pas"));
		
		Set<GrantedAuthority> authorities = utilisateur.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toSet());
		
		return new User(utilisateur.getEmail(), utilisateur.getMdp(), authorities);
	}

}
