package fr.afcepf.atod19.jspServlet.struts.actionForm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.afcepf.atod19.jspServlet.entity.Client;
import fr.afcepf.atod19.jspServlet.entity.TypeCompte;
import fr.afcepf.atod19.jspServlet.miniBank.iService.IServiceClient;
import fr.afcepf.atod19.jspServlet.miniBank.service.ServiceClient;


public class AjoutClientActionForm extends ActionForm {

	private Client client;
	
	private List<TypeCompte>listeTypeCompte;
	
	private String solde;

	public String getSolde() {
		return solde;
	}

	public void setSolde(String solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<TypeCompte> getListeTypeCompte() {
		return listeTypeCompte;
	}

	public void setListeTypeCompte(List<TypeCompte> listeTypeCompte) {
		this.listeTypeCompte = listeTypeCompte;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) 
	{
		ActionErrors ae = new ActionErrors();
		ActionMessages am = new ActionMessages();
		
		if(client.getNom() !="")
		{
			am.add("error",new ActionMessage("error.nom.vide"));
		}
		if(client.getPrenom()!="")
		{
			am.add("error2",new ActionMessage("error.prenom.vide"));
		}
		try {
		Double.parseDouble(solde);
		}
		catch(Exception e)
		{
			am.add("error3",new ActionMessage("error.solde.double"));
		}
		ae.add(am);
		
		return ae;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	
		IServiceClient serviceClient = new ServiceClient();
		listeTypeCompte = serviceClient.getAllTypeCompte();
		
	}
	
}
