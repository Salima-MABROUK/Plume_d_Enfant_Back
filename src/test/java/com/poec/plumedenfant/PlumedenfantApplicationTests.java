package com.poec.plumedenfant;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlumedenfantApplicationTests {

	@Test
	void contextLoads() {
	}
//	
//	private void checkRegEx(String str, String RegEx) {
//		assertTrue()
//	}
//	
	@Test
	void testMailValidity() {
		System.out.println("Test 1");
//		String email = "absc356@provider.com";
//	    assertTrue(email.matches(".+@.+\\.[a-z]+"));
	}

	@Test
	void testMotDePasse() {
		System.out.println("Test 2");
//		String motDePasse = "absc35#r.com";
//	    assertTrue(motDePasse.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"));
	}
}
