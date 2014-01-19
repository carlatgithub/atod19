package fr.afcepf.atod19.jspServlet.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.afcepf.atod19.jspServlet.entity.Client;
import fr.afcepf.atod19.jspServlet.miniBank.iService.IServiceClient;
import fr.afcepf.atod19.jspServlet.miniBank.service.ServiceClient;
import fr.afcepf.atod19.jspServlet.struts.actionForm.AjoutClientActionForm;

public class AjoutClientAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AjoutClientActionForm monForm = (AjoutClientActionForm)form;
		
		Client client = monForm.getClient();
		
		IServiceClient serviceClient = new ServiceClient();
		serviceClient.ajouterClient(client);
		
		String direction ="ok";
		
		
		return mapping.findForward(direction);
	}
}
