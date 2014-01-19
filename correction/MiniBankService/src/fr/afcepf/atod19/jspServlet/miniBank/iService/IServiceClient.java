package fr.afcepf.atod19.jspServlet.miniBank.iService;

import java.util.List;

import fr.afcepf.atod19.jspServlet.entity.Client;
import fr.afcepf.atod19.jspServlet.entity.TypeCompte;

public interface IServiceClient {

	
	void ajouterClient(Client client);
	
	List<Client> recherche(String nom);

	List<TypeCompte> getAllTypeCompte();
}
