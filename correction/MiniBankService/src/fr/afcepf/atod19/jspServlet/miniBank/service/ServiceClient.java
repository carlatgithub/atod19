package fr.afcepf.atod19.jspServlet.miniBank.service;

import java.util.List;

import fr.afcepf.atod19.jspServlet.dao.DaoClient;
import fr.afcepf.atod19.jspServlet.dao.DaoCompte;
import fr.afcepf.atod19.jspServlet.entity.Client;
import fr.afcepf.atod19.jspServlet.entity.Compte;
import fr.afcepf.atod19.jspServlet.entity.TypeCompte;
import fr.afcepf.atod19.jspServlet.idao.IDaoClient;
import fr.afcepf.atod19.jspServlet.idao.IDaoCompte;
import fr.afcepf.atod19.jspServlet.miniBank.iService.IServiceClient;

public class ServiceClient implements IServiceClient {

	private IDaoClient daoClient = new DaoClient();
	private IDaoCompte daoCompte = new DaoCompte();
	
	@Override
	public void ajouterClient(Client client) {
		//ajout client

		int idClientAjout = daoClient.ajouterClient(client);
		
		for(Compte cpt : client.getListeComptes())
		{
			daoCompte.ajouterCompte(cpt, idClientAjout);
		}
	}

	@Override
	public List<Client> recherche(String nom) {
		List<Client> listeClient = daoClient.recherche(nom);
		return listeClient;
	}

	@Override
	public List<TypeCompte> getAllTypeCompte() {
		List<TypeCompte> listeTypeCompte = daoCompte.getAllTypeCompte();
		return listeTypeCompte;
	}

}
