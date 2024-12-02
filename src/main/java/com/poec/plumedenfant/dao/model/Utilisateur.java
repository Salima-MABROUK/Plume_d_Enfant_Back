package com.poec.plumedenfant.dao.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String email;
	
	@Column
	private String mdp;
	
	@OneToMany
	private List<Histoire> listeFavori;
	
	@OneToMany
	private List<Histoire> listeVue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Histoire> getListeFavori() {
		return listeFavori;
	}

	public void setListeFavori(List<Histoire> listeFavori) {
		this.listeFavori = listeFavori;
	}

	public List<Histoire> getListeVue() {
		return listeVue;
	}

	public void setListeVue(List<Histoire> listeVue) {
		this.listeVue = listeVue;
	}
	
	
	
	
}
