package com.poec.plumedenfant.config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.poec.plumedenfant.dao.RoleDao;
import com.poec.plumedenfant.dao.UtilisateurDao;
import com.poec.plumedenfant.dao.model.Role;
import com.poec.plumedenfant.dao.model.RoleEnum;
import com.poec.plumedenfant.dao.model.Utilisateur;

@Component
public class DataInitializer implements CommandLineRunner {
	
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Get all existing role from RoleEnum
		for(RoleEnum roleEnum: RoleEnum.values()) {
			// Check si le role existe
			if(roleDao.findByName(roleEnum.toString()).isEmpty()) {
				// Créer et save un nouveau role s'il n'existe pas
				Role newRole = new Role();
				newRole.setName(roleEnum.toString());
				roleDao.save(newRole);
			}
		}
		
		// Créer l'admin s'il n'existe pas
		if(utilisateurDao.findByEmail("admin@admin.com").isEmpty()) {
			Utilisateur admin = new Utilisateur();
			admin.setEmail("admin@admin.com");
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode("admin");
			admin.setMdp(encodedPassword);
			admin = utilisateurDao.save(admin);
			Role adminRole = roleDao.findByName(RoleEnum.ADMIN.toString()).get();
			admin.setRoles(Set.of(adminRole));
			admin = utilisateurDao.save(admin);
		}
		
		// Créer un utilisateur par défaut s'il n'existe pas
		if(utilisateurDao.findByEmail("utilisateur@utilisateur.com").isEmpty()) {
			Utilisateur user = new Utilisateur();
			user.setEmail("utilisateur@utilisateur.com");
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode("user");
			user.setMdp(encodedPassword);
			user = utilisateurDao.save(user);
			Role userRole = roleDao.findByName(RoleEnum.USER.toString()).get();
			user.setRoles(Set.of(userRole));
			user = utilisateurDao.save(user);
			
		}
	}

}
