package com.poec.plumedenfant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poec.plumedenfant.dao.HistoireDao;
import com.poec.plumedenfant.dao.model.FormulaireHistoire;
import com.poec.plumedenfant.dao.model.Histoire;


@Service
public class HistoireService {

	@Autowired
	private HistoireDao histoireDao;
	
	@Autowired
	private IAService iaService;
	
	// Création de la requete
	public String creationRequete(FormulaireHistoire formulaire) {
		return "Ecris moi une histoire sur le thème " + formulaire.getCategorieHistoire().getValeur() +
				" pour un enfant de " + formulaire.getCategorieAge().getValeur() ;
	}
	
	// Creation de l'histoire
	public void insertHistoire(Histoire histoire, String request) {
		histoire.setId(null);
		String contenuHistoire = iaService.faireRequete(request);
		if(!contenuHistoire.equals("error")) {
			histoire.setCorps(contenuHistoire);
		}
		histoireDao.save(histoire);
	}
	
	// Récupération d'une histoire
	public Optional<Histoire> getHistoireById(int idHistoire) {
		return histoireDao.findById(idHistoire);
	}
	
	// Récupération de la liste d'histoire
	public List<Histoire> getAllHistoire() {
		return (List<Histoire>) histoireDao.findAll();
	}
	
	// Modification d'une histoire
	public void updateHistoire(Histoire histoire) {
		if(histoireDao.findById(histoire.getId()) != null) {
			histoireDao.save(histoire);
		} else {
			System.out.println("Update impossible : L'histoire n'est pas reconnue");
		}
	}
	
	// Suppression d'une histoire
	public void deleteHistoireById(int idHistoire) {
		if(histoireDao.findById(idHistoire) != null) {
			histoireDao.deleteById(idHistoire);
		} else {
			System.out.println("Suppression impossible : L'id de l'histoire n'est pas reconnu");
		}
		
	}
	
}
