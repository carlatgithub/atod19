package fr.afcepf.atod19.jspServlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import fr.afcepf.atod19.jspServlet.entity.Client;
import fr.afcepf.atod19.jspServlet.entity.Personne;
import fr.afcepf.atod19.jspServlet.idao.IDaoClient;
import fr.afcepf.atod19.jspServlet.jdbc.UtilAtod;

public class DaoClient implements IDaoClient {

	@Override
	public int ajouterClient(Client client) {
		UtilAtod jdbc = new UtilAtod();
		Connection cnx = jdbc.connection();

		String request ="INSERT INTO client (nom,prenom) VALUES (?, ?)";
		int idClient=0;

		
		try {
			PreparedStatement prstmt = 
cnx.prepareStatement(
		request,Statement.RETURN_GENERATED_KEYS);
			
			prstmt.setString(1, client.getNom());
			prstmt.setString(2, client.getPrenom());
			
			int nbLigne = prstmt.executeUpdate();

			if(nbLigne ==1)
			{
				ResultSet rs = prstmt.getGeneratedKeys();
				if(rs.next())
				{
					idClient = rs.getInt(1);
				}
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
		return idClient;
	}

	@Override
	public List<Client> recherche(String nom) {
		
		List<Client> listeClient = new ArrayList<Client>();
		
		UtilAtod jdbc = new UtilAtod();
		Connection cnx = jdbc.connection();
		
		String request ="SELECT * FROM client "
				+ "WHERE nom like ?";
		
		try {
			PreparedStatement prstmt = 
					cnx.prepareStatement(request);
			
			prstmt.setString(1,"%"+nom+"%");

			
			ResultSet result = prstmt.executeQuery();
			
			while(result.next())
			{
			
			String nomClient = result.getString("nom");
			String prenomClient = result.getString("prenom");
			Client client = new Client(nomClient,prenomClient);
			listeClient.add(client);
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
		
		
		return listeClient;
	}



}
