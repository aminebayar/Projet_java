package projet.service;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.Salarie;
import connexion.connexion;
import projet.dao.Idao;

public class EmployeeService implements Idao<Salarie> {

	@Override
	public boolean create(Salarie s) {
        try {
          
            String req = "insert into salarie (matricule,nom,email,annee,salaire,categorie) values ('" + s.getMatricule() + "', '" + s.getNom() + "', '" + s.getEmail() + "', '" + s.getAnnee() + "' , '" + s.getSalaire() + "', '" + s.getCategorie() + "')";
            Statement stmt = connexion.getCon().createStatement();
            if (stmt.executeUpdate(req) == 1) {
                return true;
             }
         } catch (SQLException ex) {
             System.out.println("Erreur");
         }
         return false;
     }

	@Override
	public boolean ajouter(Salarie s) {
        try {
          
            String req = "insert into salarie (matricule,nom,email,annee,salaire,categorie) values (?,?,?,?,?,?)";
            Statement stmt = connexion.getCon().createStatement();
            if (stmt.executeUpdate(req) == 1) {
                return true;
             }
         } catch (SQLException ex) {
             System.out.println("Erreur");
         }
         return false;
     }
	@Override
	public boolean delete(Salarie s) {
		try {
            PreparedStatement pstmt = connexion.getCon().prepareStatement("delete from salarie where matricule=?");
            pstmt.setInt(1,s.getMatricule());
            if (pstmt.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur ");
        }
        return false;
    }

	@Override
	public boolean update(Salarie s) {
        try {
            String req = "update salarie set nom ='"+s.getNom()+"', email ='"+s.getEmail()+"' , annee ='"+s.getAnnee()+"',salaire ='"+s.getSalaire()+"',categorie ='"+s.getCategorie()+"' where matricule = "+s.getMatricule();
            Statement stmt = connexion.getCon().createStatement();
            if(stmt.executeUpdate(req) == 1)
                return true;
        } catch (SQLException ex) {
            System.out.println("Erreur ");
        }
        return false;
    }

	
	@Override
	public Salarie findByMatricule(int mat) {
		try {
            String req = "select * from salarie where matricule=" + mat;
            Statement stmt = connexion.getCon().createStatement();
            ResultSet r = stmt.executeQuery(req);
            if (r.next()) {
                return new Salarie(r.getInt("matricule"), r.getString("nom"), r.getString("email"), r.getDouble("annee"), r.getDouble("salaire"), r.getString("categorie"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur");
        }
        return null;
    }




	 @Override
	    public List<Salarie> findAll() {
	        List<Salarie> salaries = new ArrayList<>();
	        try {
	            String req = "select * from salarie";
	            Statement st = connexion.getCon().createStatement();
	            ResultSet r = st.executeQuery(req);
	            while (r.next()) {
	                salaries.add( new Salarie(r.getInt("matricule"), r.getString("nom"), r.getString("email"), r.getDouble("annee"), r.getDouble("salaire"), r.getString("categorie")));
	            }
	 
	        } catch (SQLException ex) {
	            System.out.println("Erreur SQL");
	        }
	        return salaries;
	    }
	

}