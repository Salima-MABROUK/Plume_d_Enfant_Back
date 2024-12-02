package com.poec.plumedenfant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poec.plumedenfant.dao.model.CategorieAge;
import com.poec.plumedenfant.dao.model.CategorieHistoire;
import com.poec.plumedenfant.dao.model.FormulaireHistoire;
import com.poec.plumedenfant.dao.model.Histoire;
import com.poec.plumedenfant.service.HistoireService;

@RestController
@RequestMapping("/histoires")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HistoireController {
	
	@Autowired
	private HistoireService histoireService;
	
	@Autowired
	ObjectMapper objectMapper;

	// Récupération d'une histoire
	@GetMapping("/{idHistoire}")
	public Optional<Histoire> getHistoireById(@PathVariable int idHistoire) {
		Optional<Histoire> histoireRecup = histoireService.getHistoireById(idHistoire);
		if(!histoireRecup.isEmpty()) {
			return histoireRecup;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Histoire non trouvée");
		}
	}
	
	// Récupération de la liste d'histoire
	@GetMapping("")
	public List<Histoire> getAllHistoireSortedByLike() {
		List<Histoire> listeRecup = (List<Histoire>) histoireService.getAllHistoireSortedByLike();
		if(!listeRecup.isEmpty()) {
			return listeRecup;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Liste d'histoire vide");
		}
	}
	
	// Création d'une histoire
	@PostMapping("/creation")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<String> insertHistoire(@RequestBody FormulaireHistoire formulaireHistoire) {
		try {
			System.out.println(formulaireHistoire);
			
			int idCreateur = formulaireHistoire.getIdCreateur();
			CategorieHistoire categorieHistoire = formulaireHistoire.getCategorieHistoire();
			CategorieAge categorieAge = formulaireHistoire.getCategorieAge();
			String request = histoireService.creationRequete(formulaireHistoire);
			histoireService.insertHistoire(request, idCreateur, categorieHistoire, categorieAge);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body("L'histoire a été créée avec succès");
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}
	}
	
	// Modification d'une histoire
	@PatchMapping("/modification/{idHistoire}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<String> updateHistoire(@RequestBody Histoire histoire, @PathVariable int idHistoire) {
		try {
			histoireService.updateHistoire(histoire, idHistoire);
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body("L'histoire a été modifié avec succès");
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{idHistoire}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<String> deleteHistoire(@PathVariable int idHistoire) {
		try {
			histoireService.deleteHistoireById(idHistoire);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("L'histoire a été supprimée avec succès");
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}
	}
	
}
