package com.poec.plumedenfant.dao.model;

public enum CategorieHistoire {
	
	PIRATE,
	FANTASTIQUE,
	FARWEST,
	MEDIEVAL,
	SPACIAL,
	FUTURISTE;

	public String getValeur() {
		switch(this) {
			case PIRATE:
				return "de la piraterie";
			case FANTASTIQUE:
				return "fantastique";
			case FARWEST:
				return "du far-west";
			case MEDIEVAL:
				return "médieval";
			case SPACIAL:
				return "de l'espace";
			case FUTURISTE:
				return "futuriste";
			default: return "que tu veux";
		}
	}
}
