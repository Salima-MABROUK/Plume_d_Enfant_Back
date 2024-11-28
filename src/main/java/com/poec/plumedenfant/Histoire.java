package com.poec.plumedenfant;

public class Histoire {
	
	static private int id;
	
	private String Title;
	private String Texte;
	private String image;
	private int nbLike = 0;
	private int idCreateur;
	private Genre Genre;
	
	public Histoire() {}
	
	public Histoire(String title, String texte, String image, int idCreateur, Genre genre) {
		super();
		Title = title;
		Texte = texte;
		this.image = image;
		this.idCreateur = idCreateur;
		this.Genre = genre;
	}
	
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Histoire.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNbLike() {
		return nbLike;
	}

	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}

	public void setTexte(String texte) {
		Texte = texte;
	}

	public void setIdCreateur(int idCreateur) {
		this.idCreateur = idCreateur;
	}

	String getTitre() {
		return "test";
	}
	
	String getTexte() {
		return "Texte";
	}
	
	String getImagePath() {
		return "image path";
	}
	
	void addLike() {
		nbLike++;
	}
	
	int getNbLikes() {
		return nbLike;
	}
	
	int getIdCreateur() {
		return 1;
	}
	
	void delete(int id) {
		
	}
}
