package com.poec.plumedenfant.dao.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Histoire implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String titre;
	
	@Column(columnDefinition ="LONGTEXT")
	private String corps;
	
	@Column
	@Enumerated(EnumType.STRING)
	private CategorieHistoire categorieHistoire;
	
	@Column
	@Enumerated(EnumType.STRING)
	private CategorieAge categorieAge;
	
	@Column
	private String urlImage;
	
	@Column
	private Integer nbLike;
	
	@ManyToOne
	@JoinColumn(name = "idCreateur")
	private Utilisateur Createur;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	public CategorieHistoire getCategorieHistoire() {
		return categorieHistoire;
	}

	public void setCategorieHistoire(CategorieHistoire categorieHistoire) {
		this.categorieHistoire = categorieHistoire;
	}

	public CategorieAge getCategorieAge() {
		return categorieAge;
	}

	public void setCategorieAge(CategorieAge categorieAge) {
		this.categorieAge = categorieAge;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Integer getNbLike() {
		return nbLike;
	}

	public void setNbLike(Integer nbLike) {
		this.nbLike = nbLike;
	}

	public Utilisateur getCreateur() {
		return Createur;
	}

	public void setCreateur(Utilisateur createur) {
		Createur = createur;
	}
	
	
	
}
