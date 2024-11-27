package com.poec.plumedenfant;

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
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class}) // Exclure la configuration de la source de données
class PlumedenfantApplicationTests {
	
	Utilisateur utilisateurPass;
	Utilisateur utilisateurFail;
	Utilisateur utilisateurPwdEmpty;
	Utilisateur utilisateurMailEmpty;
	
	@BeforeAll
	void initAll() {
		System.out.println("before All");
		utilisateurPass = new Utilisateur("absc356@provider.com","absc35#Acom");
		utilisateurFail = new Utilisateur("absc35rovidercom","abscom");
	}

	@Test
	@DisplayName("Test Mail Validity Pass")
	void testMailValidityPass() {
		System.out.println("Test Mail Validity Pass");
		assertTrue(utilisateurPass.checkMailValidity());
	}
	
	@Test
	@DisplayName("Test Mail Validity Fail")
	void testMailValidityFail() {
		System.out.println("Test Mail Validity Fail");
		assertFalse(utilisateurFail.checkMailValidity());
	}
	
	@Test
	@DisplayName("Test Password Pass")
	void testPasswordPass() {
		System.out.println("Test Password  Pass");
		assertTrue(utilisateurPass.checkPassword());
	}
	
	@Test
	@DisplayName("Test Password Fail")
	void testPasswordFail() {
		System.out.println("Test Password Fail");
		assertFalse(utilisateurFail.checkPassword());
	}

	@Test
	@DisplayName("Test Mail Not Null Pass")
	void testMailNotNullPass() {
		assertTrue(utilisateurPass.checkMailNotNull());
	}
	
	@Test
	@DisplayName("Test Mail Not Null Fail")
	void testMailNotNullFail() {
		Utilisateur utilisateurMailNull = new Utilisateur("","xxxxxx");
		assertFalse(utilisateurMailNull.checkMailNotNull());
	}
	
	@Test
	@DisplayName("Test Password Not Null Pass")
	void testPasswordNotNullPass() {
		assertTrue(utilisateurPass.checkPasswordNotNull());
	}
	
	@Test
	@DisplayName("Test Password Not Null Fail")
	void testPasswordNotNullFail() {
		Utilisateur utilisateurPasswordNull = new Utilisateur("mal@cccc.com","");
		assertFalse(utilisateurPasswordNull.checkPasswordNotNull());
	}
}
