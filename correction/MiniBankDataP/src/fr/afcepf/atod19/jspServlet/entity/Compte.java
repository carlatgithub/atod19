package fr.afcepf.atod19.jspServlet.entity;

public class Compte {

	private int idCompte;
	private TypeCompte type;
	private double solde;
	
	
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public TypeCompte getType() {
		return type;
	}
	public void setType(TypeCompte type) {
		this.type = type;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Compte(TypeCompte type, double solde) {
		this.type = type;
		this.solde = solde;
	}
	public Compte()
	{
		
	}
}
