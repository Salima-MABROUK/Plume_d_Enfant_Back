package com.poec.plumedenfant.dao.model;

public enum CategorieHistoire {
	
	PIRATE("de la piraterie"),
	FANTASTIQUE("fantastique"),
	FARWEST("du Far-West"),
	MEDIEVAL("médieval"),
	SPACIAL("spacial"),
	FUTURISTE("futuriste");
	
	private String valeur;
	
	// Constructeur
	private CategorieHistoire(String valeur) {

	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	

}
