package com.poec.plumedenfant;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class}) // Exclure la configuration de la source de données
class PlumedenfantApplicationTests {

	@Test
	void contextLoads() {
	}
	
	private void checkRegEx(String str, String RegEx) {
		System.out.println(("checkRegEx"));
	    assertTrue(str.matches(RegEx));
	}
	
	@Test
	void testMailValidity() {
		System.out.println("Test Mail Validity");
		checkRegEx("absc356@provider.com",".+@.+\\.[a-z]+");
	}

	@Test
	void testMotDePasse() {
		System.out.println("Test Mot De Passe");
		checkRegEx("absc35#Acom","^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
	}
}
