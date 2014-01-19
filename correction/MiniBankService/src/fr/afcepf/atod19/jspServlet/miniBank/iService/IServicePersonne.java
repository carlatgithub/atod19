package fr.afcepf.atod19.jspServlet.miniBank.iService;

import fr.afcepf.atod19.jspServlet.entity.Personne;

public interface IServicePersonne {

	Personne authentification(String login, String mdp);
	
}
