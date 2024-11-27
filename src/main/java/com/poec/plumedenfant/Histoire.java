package com.poec.plumedenfant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Histoire {


	String getTitre() {
		return "test";
	}
	
	String getTexte() {
		return "Texte";
	}
	
	@Test
	@DisplayName("Test Image Not Null")
	void testImageNotNull() {
		assertNotNull(histoirePass.getImage());
	}
	
	@Test
	@DisplayName("Test Nombre Like")
	void testNombreLike() {
		int nbLike = 10;
		for (int i = 0; i < nbLike; i++) {
			histoirePass.addLike();
		}
		assertEquals(nbLike, histoirePass.getNbLikes());
	}
	
	@Test
	@DisplayName("Test Image Not Null")
	void testIdCreateurNotNull() {
		assertNotNull(histoirePass.getIdCreateur());
	}
}
