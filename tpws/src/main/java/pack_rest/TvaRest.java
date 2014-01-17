package pack_rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/calculTva")
public class TvaRest {
	
	@GET
	@Path("/tva")
	@Produces("text/plain")
	//http://localhost:8080/tpws/services/rest/calculTva/tva?ht=250&taux=20
	public double tva(@QueryParam("ht")double ht,
			          @QueryParam("taux")double taux){
		return ht*taux/100;
	}

}
