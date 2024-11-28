package com.poec.plumedenfant;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poec.plumedenfant.service.IAService;


@SpringBootApplication
public class PlumedenfantApplication implements CommandLineRunner {
	
	private final IAService ia;
	
	public PlumedenfantApplication(IAService ia) {
		this.ia = ia;
	}

	public static void main(String[] args) {
		SpringApplication.run(PlumedenfantApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ia.faireRequete("Donne moi la capital de l'italie");
		
	}

}
