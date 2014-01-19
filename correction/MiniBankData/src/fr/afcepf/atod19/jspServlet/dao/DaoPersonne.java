package fr.afcepf.atod19.jspServlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.afcepf.atod19.jspServlet.entity.Personne;
import fr.afcepf.atod19.jspServlet.idao.IDaoPersonne;
import fr.afcepf.atod19.jspServlet.jdbc.UtilAtod;

public class DaoPersonne implements IDaoPersonne{

	@Override
	public Personne connexion(String login, String mdp) {
		UtilAtod jdbc = new UtilAtod();
		Connection cnx = jdbc.connection();
		
		Personne personne = null;
		
		String request ="SELECT * FROM personne "
				+ "WHERE login = ? AND mdp= ?";
		
		try {
			PreparedStatement prstmt = 
					cnx.prepareStatement(request);
			
			prstmt.setString(1, login);
			prstmt.setString(2, mdp);
			
			ResultSet result = prstmt.executeQuery();
			
			if(result.next())
			{
				personne = new Personne();
				personne.setIdPersonne(result.getInt("id_personne"));
				personne.setLogin(result.getString("login"));
				personne.setMdp(result.getString("mdp"));
				personne.setNom(result.getString("nom"));
				personne.setPrenom(result.getString("prenom"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		try {
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return personne;
	}

}
