package com.poec.plumedenfant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class}) 
public class HistoireTest {
	
	Histoire histoirePass;
	
	@BeforeAll
	void initAll() {
		histoirePass = new Histoire();
	}
	
	@Test
	@DisplayName("Test Titre Not Null")
	void testTitreNotNull() {
		assertNotNull(histoirePass.getTitre());
	}
	
	@Test
	@DisplayName("Test Texte Not Null")
	void testTexteNotNull() {
		assertNotNull(histoirePass.getTexte());
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
