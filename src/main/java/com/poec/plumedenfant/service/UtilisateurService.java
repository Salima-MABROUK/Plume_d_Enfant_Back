package com.poec.plumedenfant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poec.plumedenfant.dao.UtilisateurDao;
import com.poec.plumedenfant.dao.model.Utilisateur;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurDao utilisateurDao;
	
	// Création d'un utilisateur
	public void insertUtilisateur(Utilisateur utilisateur) {
		utilisateur.setId(null);
		utilisateurDao.save(utilisateur);
	}
	
	// Récupération d'un utilisateur
	public Optional<Utilisateur> getUtilisateurById(int idUtilisateur) {
		return utilisateurDao.findById(idUtilisateur);
	}
	
	// Récupération de la liste des utilisateurs
	public List<Utilisateur> getAllUtilisateur() {
		return (List<Utilisateur>) utilisateurDao.findAll();
	}
	
	// Modification d'un utilisateur
	public void updateUtilisateur(Utilisateur utilisateur, int idUtilisateur) {
		utilisateur.setId(idUtilisateur);
		utilisateurDao.save(utilisateur);
	}
	
	// Suppression d'un utilisateur
	public void deleteUtilisateurById(int idUtilisateur) {
		utilisateurDao.deleteById(idUtilisateur);
	}
	
	
}
