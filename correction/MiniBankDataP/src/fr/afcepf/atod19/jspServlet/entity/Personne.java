package fr.afcepf.atod19.jspServlet.entity;

public class Personne {

	private int idPersonne;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	
	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Personne(String nom, String prenom, String login, String mdp) {

		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
	}

	public Personne()
	{
	}
	
	@Override
	public String toString() {
		return "Personne : "+nom+" "+prenom+" de login :"+login;
	}
}
