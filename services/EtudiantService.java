package services;

import beans.Etudiant;
import connexion.Connexion;
import dao.IDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantService implements IDao<Etudiant> {

    private Connexion connexion;

    public EtudiantService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Etudiant o) {
        String req = "INSERT INTO Etudiant (nom, prenom, email) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    o.setId(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Etudiant o) {
        if (o.getId() <= 0) {
            System.out.println("ID invalide pour suppression");
            return false;
        }
        String req = "DELETE FROM Etudiant WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Etudiant o) {
        if (o.getId() <= 0) {
            System.out.println("ID invalide pour modification");
            return false;
        }
        String req = "UPDATE Etudiant SET nom = ?, prenom = ?, email = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Etudiant findById(int id) {
        if (id <= 0) {
            System.out.println("ID invalide pour recherche");
            return null;
        }
        String req = "SELECT * FROM Etudiant WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        String req = "SELECT * FROM Etudiant ORDER BY nom ASC";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                etudiants.add(new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return etudiants;
    }

    public List<Etudiant> findByNom(String nom) {
        List<Etudiant> etudiants = new ArrayList<>();
        String req = "SELECT * FROM Etudiant WHERE nom LIKE ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, nom + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                etudiants.add(new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return etudiants;
    }

    public List<Etudiant> getAllEtudiants() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
