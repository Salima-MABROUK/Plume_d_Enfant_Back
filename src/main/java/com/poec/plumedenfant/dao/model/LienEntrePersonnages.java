package com.poec.plumedenfant.dao.model;

public enum LienEntrePersonnages {
	
	FRERE_SOEUR("un frère ou une soeur"),
	PARENT("un parent"),
	ENFANT("un enfant"),
	GRAND_PARENT("un grand-parent"),
	PETIT_ENFANT("un petit enfant"),
	COUSIN("un cousin"),
	AMI("un ami"),
	AMOUREUX("un amoureux ou amoureuse"),
	MEILLEUR_AMI("le meilleur ami ou la meilleure amie"),
	INCONNU("un inconnu"),
	VOISIN("un voisin"),
	CAMARADE("un camarade de classe"),
	ANIMAL("un animal de compagnie");
	
	
	private String valeur;
	
	// Constructeur pour determiner la valeur en String
	private LienEntrePersonnages(String valeur) {
		this.valeur = valeur;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	

}
