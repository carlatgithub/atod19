package fr.afcepf.atod19.jspServlet.idao;

import java.util.List;

import fr.afcepf.atod19.jspServlet.entity.Client;

public interface IDaoClient {

	int ajouterClient(Client client);
	
	List<Client> recherche(String nom);
}
