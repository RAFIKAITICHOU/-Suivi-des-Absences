package services;

import beans.Seance;
import connexion.Connexion;
import dao.IDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeanceService implements IDao<Seance> {
    private Connexion connexion;

    public SeanceService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Seance o) {
        String req = "INSERT INTO Seance (matiere, date, heure, salle) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getMatiere());
            ps.setDate(2, new Date(o.getDate().getTime()));
            ps.setString(3, o.getHeure());
            ps.setString(4, o.getSalle());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur ajout séance : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Seance o) {
        String req = "DELETE FROM Seance WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur suppression séance : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Seance o) {
        String req = "UPDATE Seance SET matiere = ?, date = ?, heure = ?, salle = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getMatiere());
            ps.setDate(2, new Date(o.getDate().getTime()));
            ps.setString(3, o.getHeure());
            ps.setString(4, o.getSalle());
            ps.setInt(5, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur modification séance : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Seance findById(int id) {
        String req = "SELECT * FROM Seance WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Seance(
                    rs.getInt("id"), 
                    rs.getString("matiere"), 
                    rs.getDate("date"), 
                    rs.getString("heure"), 
                    rs.getString("salle")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Erreur recherche séance : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Seance> findAll() {
        List<Seance> seances = new ArrayList<>();
        String req = "SELECT * FROM Seance";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                seances.add(new Seance(
                    rs.getInt("id"), 
                    rs.getString("matiere"), 
                    rs.getDate("date"), 
                    rs.getString("heure"), 
                    rs.getString("salle")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur récupération séances : " + ex.getMessage());
        }
        return seances;
    }
}
