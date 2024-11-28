package com.poec.plumedenfant.dao.model;

public enum CategorieAge {
	
	DEUX_TROIS_ANS,
	QUATRE_CINQ_ANS,
	SIX_SEPT_ANS,
	HUIT_NEUF_ANS,
	DIX_ONZE_ANS;
	
	public String getValeur() {
		switch(this) {
			case DEUX_TROIS_ANS:
				return "deux à trois ans";
			case QUATRE_CINQ_ANS:
				return "quatre à cinq ans";
			case SIX_SEPT_ANS:
				return "six à sept ans";
			case HUIT_NEUF_ANS:
				return "huit à neuf ans";
			case DIX_ONZE_ANS:
				return "dix à onze ans";
			default: return "l'âge que tu veux";
		}
	}

	
	
}
