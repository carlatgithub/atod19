package fr.afcepf.atod19.soa.service;

import javax.jws.WebService;

//+@Stateless si CalculTvaImpl serait un EJB3
@WebService(endpointInterface="fr.afcepf.atod19.soa.service.CalculTva")
public class CalculTvaImpl implements CalculTva {

	@Override
	public String getAuteur() {
		return "didier (formateur fou)";
	}

	@Override
	public double tva(double ht, double taux) {
		return ht*taux/100;
	}

	@Override
	public double ttc(double ht, double taux) {
		return ht*(1+taux/100);
	}

}
