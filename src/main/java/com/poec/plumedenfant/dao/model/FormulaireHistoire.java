package com.poec.plumedenfant.dao.model;

import java.util.ArrayList;
import java.util.List;

public class FormulaireHistoire {
	
	class PersonnageSecondaire{
		private String nom;
		private String details;
		private LienEntrePersonnages lien;
	}

	private CategorieHistoire categorieHistoire;
	private CategorieAge categorieAge;
	
	private String nomPersoPrincipal;
	private String detailPersoPrincipal;
	
	// Les deux listes sont facultatives
	private List<PersonnageSecondaire> listePersoSecondaire = new ArrayList<PersonnageSecondaire>();
	private List<String> detailsSupplementaires = new ArrayList<String>();
	
	
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
		return detailPersoPrincipal;
	}
	public void setDetailPersoPrincipal(String detailPersoPrincipal) {
		this.detailPersoPrincipal = detailPersoPrincipal;
	}
	public List<PersonnageSecondaire> getListePersoSecondaire() {
		return listePersoSecondaire;
	}
	public void setListePersoSecondaire(List<PersonnageSecondaire> listePersoSecondaire) {
		this.listePersoSecondaire = listePersoSecondaire;
	}
	public List<String> getDetailsSupplementaires() {
		return detailsSupplementaires;
	}
	public void setDetailsSupplementaires(List<String> detailsSupplementaires) {
		this.detailsSupplementaires = detailsSupplementaires;
	}

	
}
