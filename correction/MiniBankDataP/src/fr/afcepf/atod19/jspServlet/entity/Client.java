package fr.afcepf.atod19.jspServlet.entity;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private int idClient;
	private String nom;
	private String prenom;
	private List<Compte> listeComptes 
	= new ArrayList<Compte>();
	
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public List<Compte> getListeComptes() {
		return listeComptes;
	}
	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}
	public Client(String nom, String prenom) {
	
		this.nom = nom;
		this.prenom = prenom;
	}
	public Client() {

	}
	
	
 }
