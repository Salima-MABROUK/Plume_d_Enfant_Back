package com.poec.plumedenfant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poec.plumedenfant.dao.model.Utilisateur;
import com.poec.plumedenfant.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;
	
	// Récupération d'un utilisateur
	@GetMapping("/{idUtilisateur}")
	public Optional<Utilisateur> getUtilisateurById(@PathVariable int idUtilisateur) {
		return utilisateurService.getUtilisateurById(idUtilisateur);
	}
	
	// Récupération de la liste des utilisateurs
	@GetMapping("")
	public List<Utilisateur> getAllUtilisateur() {
		return (List<Utilisateur>) utilisateurService.getAllUtilisateur();
	}
	
	// Création d'un utilisateur
	@PostMapping("inscription")
	public void insertUtilisateur(Utilisateur utilisateur) {
		utilisateurService.insertUtilisateur(utilisateur);
	}
	
	// Modification d'un utilisateur
	@PutMapping("modification")
	public void updateUtilisateur(Utilisateur utilisateur) {
		utilisateurService.updateUtilisateur(utilisateur);
	}
	
	// Suppression d'un utilisateur
	@DeleteMapping("/{idUtilisateur}")
	public void deleteUtilisateurById(int idUtilisateur) {
		utilisateurService.deleteUtilisateurById(idUtilisateur);
	}
	
	
	
	
	
	
	
	
	
}
