package com.poec.plumedenfant.dao.model;

public class PersonnageSecondaire {
	
		private String nom; // Champs requis
		private String details; // Champs facultatif
		private LienEntrePersonnages lien; // Champs requis
		
		
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getDetails() {
			if(details != null) {
				return "Detail : " + details + ". ";
			} else {
				return "";
			}
		}
		public void setDetails(String details) {
			this.details = details;
		}
		public LienEntrePersonnages getLien() {
			return lien;
		}
		public void setLien(LienEntrePersonnages lien) {
			this.lien = lien;
		}
}
