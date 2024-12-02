package com.poec.plumedenfant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poec.plumedenfant.dao.model.Utilisateur;
import com.poec.plumedenfant.dto.AuthResponseDto;
import com.poec.plumedenfant.dto.InscriptionDto;
import com.poec.plumedenfant.dto.LoginDto;
import com.poec.plumedenfant.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	// Login d'un utilisateur
	@PostMapping("/login")
	public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
		
		//01 - Receive the token from AuthService
		String token = authService.login(loginDto);
		
		//02 - Set the token as a response using JwtAuthResponse Dto class
		AuthResponseDto authResponseDto = new AuthResponseDto();
		authResponseDto.setAccessToken(token);
		
		//03 - Return the response to the user
		return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
	}
	
	
	@PostMapping("/inscription")
	public ResponseEntity<Utilisateur> register(@RequestBody InscriptionDto inscriptionDto) {
		Utilisateur utilisateur = authService.register(inscriptionDto);
		return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
	}
	
	

}
