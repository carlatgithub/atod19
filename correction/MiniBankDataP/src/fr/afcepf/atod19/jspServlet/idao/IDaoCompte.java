package fr.afcepf.atod19.jspServlet.idao;

import java.util.List;

import fr.afcepf.atod19.jspServlet.entity.Compte;
import fr.afcepf.atod19.jspServlet.entity.TypeCompte;

public interface IDaoCompte {

	void ajouterCompte(Compte compte, int idClient);

	List<TypeCompte> getAllTypeCompte();
}
