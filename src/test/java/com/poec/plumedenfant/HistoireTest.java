package com.poec.plumedenfant;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
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
	
	final int nbLike = 10;
	
	@Test
	@DisplayName("Test Image Not Null")
	void testImageNotNull() {
		Histoire histoirePass = new Histoire();
		System.out.println("Test Image Not Null" + histoirePass.getImagePath());
	}
	
	@Test
	@DisplayName("Test Nombre Like")
	void testNombreLike() {
		System.out.println("Test Nombre Like");
		Histoire histoirePass = new Histoire();
		for (int i = 0; i < nbLike; i++) {
			histoirePass.addLike();
		}
		assertEquals(nbLike, histoirePass.getNbLikes());
	}
	
	@Test
	@DisplayName("Test Nombre Like")
	@RepeatedTest(nbLike)
	void testNombreLikeRepeatedTest() {
		Histoire histoire = new Histoire();
		System.out.println("Test Nombre Like");
		histoire.addLike();
		assertEquals(nbLike, histoire.getNbLikes());
	}
	
	@Test
	@DisplayName("Test Générer une histoire")
	void testGenererHistoire() {
		System.out.println("Test Générer une histoire");
		Histoire histoire = new Histoire();
		
	}
	
	@Test
	@DisplayName("Test tri par genre")
	void testTriParGenre() {
		
	}
	
	@Test
	@DisplayName("Test Suppression histoire")
	void testSuppression() {
		
	}
	

	

}
