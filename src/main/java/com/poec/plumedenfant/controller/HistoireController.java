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

import com.poec.plumedenfant.dao.model.Histoire;
import com.poec.plumedenfant.dao.model.Utilisateur;
import com.poec.plumedenfant.service.HistoireService;

@RestController
@RequestMapping("/histoires")
public class HistoireController {
	
	@Autowired
	private HistoireService histoireService;

	// Récupération d'une histoire
	@GetMapping("/{idHistoire}")
	public Optional<Histoire> getHistoireById(@PathVariable int idHistoire) {
		return histoireService.getHistoireById(idHistoire);
	}
	
	// Récupération de la liste d'histoire
	@GetMapping("")
	public List<Histoire> getAllHistoire() {
		return histoireService.getAllHistoire();
	}
	
	// Création d'une histoire
	@PostMapping("/creation")
	public void insertHistoire(Histoire histoire, String request) {
		histoireService.insertHistoire(histoire, request);
	}
	
	// Modification d'une histoire
	@PutMapping("/modification")
	public void updateHistoire(Histoire histoire) {
		histoireService.updateHistoire(histoire);
	}
	
	@DeleteMapping("/{idHistoire}")
	public void deleteHistoire(@PathVariable int idHistoire) {
		histoireService.deleteHistoireById(idHistoire);
	}
	
}
