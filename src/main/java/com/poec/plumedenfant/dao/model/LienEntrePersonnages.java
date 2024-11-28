package com.poec.plumedenfant.dao.model;

public enum LienEntrePersonnages {
	
	FRERE_SOEUR,
	PARENT,
	ENFANT,
	GRAND_PARENT,
	PETIT_ENFANT,
	COUSIN,
	AMI,
	AMOUREUX,
	MEILLEUR_AMI,
	INCONNU,
	VOISIN,
	CAMARADE,
	ANIMAL;
	
	
	public String getValeur() {
		switch(this) {
			case FRERE_SOEUR:
				return "un frère ou une soeur";
			case PARENT:
				return "un parent";
			case ENFANT:
				return "un enfant";
			case GRAND_PARENT:
				return "un grand-parent";
			case PETIT_ENFANT:
				return "un petit enfant";
			case COUSIN:
				return "un cousin";
			case AMI:
				return "un ami";
			case AMOUREUX:
				return "un amoureux ou amoureuse";
			case MEILLEUR_AMI:
				return "le meilleur ami ou la meilleure amie";
			case INCONNU:
				return "un inconnu";
			case VOISIN:
				return "un voisin";
			case CAMARADE:
				return "un camarade de classe";
			case ANIMAL:
				return "un animal de compagnie";
			default: return "ce que tu veux";
		}
	}
	
	

}
