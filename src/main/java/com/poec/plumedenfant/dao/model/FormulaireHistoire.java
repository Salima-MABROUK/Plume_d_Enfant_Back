package com.poec.plumedenfant.dao.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class FormulaireHistoire {
	
	private int idCreateur;

	@Enumerated(EnumType.STRING)
	private CategorieHistoire categorieHistoire; // Champs requis
	
	@Enumerated(EnumType.STRING)
	private CategorieAge categorieAge; // Champs requis
	
	private String nomPersoPrincipal; // Champs requis
	private String detailPersoPrincipal; 
	
	
	
	// Les deux listes sont facultatives
	private List<PersonnageSecondaire> listePersoSecondaire = new ArrayList<PersonnageSecondaire>();
	private List<String> detailsSupplementaires = new ArrayList<String>();
	
	
	public int getIdCreateur() {
		return idCreateur;
	}
	public void setIdCreateur(int idCreateur) {
		this.idCreateur = idCreateur;
	}
	public CategorieHistoire getCategorieHistoire() {
		return categorieHistoire;
	}
	public void setCategorieHistoire(CategorieHistoire categorieHistoire) {
		this.categorieHistoire = categorieHistoire;
	}
	public CategorieAge getCategorieAge() {
		return categorieAge;
	}
	public void setCategorieAge(CategorieAge categorieAge) {
		this.categorieAge = categorieAge;
	}
	public String getNomPersoPrincipal() {
		return nomPersoPrincipal;
	}
	public void setNomPersoPrincipal(String nomPersoPrincipal) {
		this.nomPersoPrincipal = nomPersoPrincipal;
	}
	public String getDetailPersoPrincipal() {
		if(detailPersoPrincipal != null) {
			return "Detail sur ce personnage : " + detailPersoPrincipal + ". ";
		} else {
			return "";
		}
		
	}
	public void setDetailPersoPrincipal(String detailPersoPrincipal) {
		this.detailPersoPrincipal = detailPersoPrincipal;
	}
	
	public void setListePersoSecondaire(List<PersonnageSecondaire> listePersoSecondaire) {
		this.listePersoSecondaire = listePersoSecondaire;
	}
	
	public List<PersonnageSecondaire> getListePersoSecondaire() {
		return listePersoSecondaire;
	}
	public List<String> getDetailsSupplementaires() {
		return detailsSupplementaires;
	}
	public void setDetailsSupplementaires(List<String> detailsSupplementaires) {
		this.detailsSupplementaires = detailsSupplementaires;
	}
	
	
	public String getPhraseListePersoSecondaire() {
		String phrase = "Les personnage secondaires sont : ";
		if(listePersoSecondaire.size() != 0) {
			for(PersonnageSecondaire personnageSecondaire : listePersoSecondaire) {
				phrase += personnageSecondaire.getNom() + " qui est " 
						+ personnageSecondaire.getLien().getValeur() + " du personnage principal. " +
						personnageSecondaire.getDetails();
			}
			return phrase;
		} else {
			return "";
		}
	}
	
	public String getPhraseDetailsSupplementaires() {
		String phrase = "Details supplémentaires : ";
		if(detailsSupplementaires.size() != 0) {
			for(String detail : detailsSupplementaires) {
				phrase += detail + ". ";
			}
			return phrase;
		} else {
			return "";
		}
	}

	
}
