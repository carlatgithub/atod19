package fr.afcepf.atod19.jspServlet.idao;

import fr.afcepf.atod19.jspServlet.entity.Personne;

public interface IDaoPersonne {

	Personne connexion(String login, String mdp);
	
}
