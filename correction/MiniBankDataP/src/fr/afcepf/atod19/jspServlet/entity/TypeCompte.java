package fr.afcepf.atod19.jspServlet.entity;

public class TypeCompte {

	private int idType;
	private String libelle;
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public TypeCompte(String libelle) {
		this.libelle = libelle;
	}
	public TypeCompte() {
	}
	public TypeCompte(int idType, String libelle) {
		this.idType = idType;
		this.libelle = libelle;
	}
	
	
}
