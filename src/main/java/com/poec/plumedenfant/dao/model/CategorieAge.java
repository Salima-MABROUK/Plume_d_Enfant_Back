package com.poec.plumedenfant.dao.model;

public enum CategorieAge {
	
	DEUX_TROIS_ANS("deux à trois ans"),
	QUATRE_CINQ_ANS("quatre à cinq ans"),
	SIX_SEPT_ANS("six à sept ans"),
	HUIT_NEUF_ANS("huit à neuf ans"),
	DIX_ONZE_ANS("dix à onze ans");
	
	private String valeur;
	
	// Constructeur
	private CategorieAge(String valeur) {

	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
}
