package fr.afcepf.atod19.jspServlet.miniBank.service;

import fr.afcepf.atod19.jspServlet.dao.DaoPersonne;
import fr.afcepf.atod19.jspServlet.entity.Personne;
import fr.afcepf.atod19.jspServlet.idao.IDaoPersonne;
import fr.afcepf.atod19.jspServlet.miniBank.iService.IServicePersonne;

public class ServicePersonne implements IServicePersonne {
	private IDaoPersonne dao = new DaoPersonne();
	
	@Override
	public Personne authentification(String login, String mdp) {
		
		Personne personne =
				dao.connexion(login, mdp);
		return personne;
	}

}
