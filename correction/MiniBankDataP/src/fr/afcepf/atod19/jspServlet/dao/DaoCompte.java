package fr.afcepf.atod19.jspServlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import fr.afcepf.atod19.jspServlet.entity.Client;
import fr.afcepf.atod19.jspServlet.entity.Compte;
import fr.afcepf.atod19.jspServlet.entity.TypeCompte;
import fr.afcepf.atod19.jspServlet.idao.IDaoCompte;
import fr.afcepf.atod19.jspServlet.jdbc.UtilAtod;

public class DaoCompte implements IDaoCompte {

	@Override
	public void ajouterCompte(Compte compte, int idclient) {
		UtilAtod jdbc = new UtilAtod();
		Connection cnx = jdbc.connection();

		String request ="INSERT INTO compte "
				+ "(id_type,solde,id_client) "
				+ "VALUES (?,?,?)";

		try {
			PreparedStatement prstmt = 
cnx.prepareStatement(
		request);
			
			prstmt.setInt(1, compte.getType().getIdType());
			prstmt.setDouble(2, compte.getSolde());
			prstmt.setInt(3, idclient);
			
			int nbLigne = prstmt.executeUpdate();

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
	}

	@Override
	public List<TypeCompte> getAllTypeCompte() {
		
		List<TypeCompte> listeTypeCompte = new ArrayList<TypeCompte>();
		
		UtilAtod jdbc = new UtilAtod();
		Connection cnx = jdbc.connection();
		
		String request ="SELECT * FROM type_compte ";
		
		try {
			PreparedStatement prstmt = 
					cnx.prepareStatement(request);
			
			

			
			ResultSet result = prstmt.executeQuery();
			
			while(result.next())
			{
			
			int idType= result.getInt("id_type");
			String libelle = result.getString("label");
			TypeCompte type = new TypeCompte(idType, libelle);
			listeTypeCompte.add(type);
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
		return listeTypeCompte;
	}

}
