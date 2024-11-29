package com.poec.plumedenfant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
		Optional<Utilisateur> utilisateurRecup = utilisateurService.getUtilisateurById(idUtilisateur);
		if(!utilisateurRecup.isEmpty()) {
			return utilisateurRecup;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
		}
	}
	
	// Récupération de la liste des utilisateurs
	@GetMapping("")
	public List<Utilisateur> getAllUtilisateur() {
		List<Utilisateur> listeRecup = (List<Utilisateur>) utilisateurService.getAllUtilisateur();
		if(!listeRecup.isEmpty()) {
			return listeRecup;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Liste d'utilisateur vide");
		}
	}
	
	// Création d'un utilisateur
	@PostMapping("/inscription")
	public ResponseEntity<String> insertUtilisateur(@RequestBody Utilisateur utilisateur) {
		try {
			utilisateurService.insertUtilisateur(utilisateur);
			return ResponseEntity
	                .status(HttpStatus.CREATED)
	                .body("L'utilisateur a été créé avec succès");
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}		
	}
	
	// Modification d'un utilisateur
	@PatchMapping("/modification/{idUtilisateur}")
	public ResponseEntity<String> updateUtilisateur(@RequestBody Utilisateur utilisateur, @PathVariable int idUtilisateur) {
		try {
			utilisateurService.updateUtilisateur(utilisateur, idUtilisateur);
			return ResponseEntity
	                .status(HttpStatus.NO_CONTENT)
	                .body("L'utilisateur a été modifié avec succès");
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}
	}
	
	// Suppression d'un utilisateur
	@DeleteMapping("/{idUtilisateur}")
	public ResponseEntity<String> deleteUtilisateurById(@PathVariable int idUtilisateur) {
		try {
			utilisateurService.deleteUtilisateurById(idUtilisateur);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("L'utilisateur a été supprimé");
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
}
