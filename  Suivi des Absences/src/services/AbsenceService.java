package services;

import beans.Absence;
import connexion.Connexion;
import dao.IDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbsenceService implements IDao<Absence> {

    private Connexion connexion;
    private SeanceService seanceService;
    private EtudiantService etudiantService;

    public AbsenceService() {
        connexion = Connexion.getInstance();
        seanceService = new SeanceService();
        etudiantService = new EtudiantService();
    }

    @Override
    public boolean create(Absence o) {
        String req = "INSERT INTO Absence (seance_id, etudiant_id, justification) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getSeance().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.setString(3, o.getJustification());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur ajout absence : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Absence o) {
        String req = "DELETE FROM Absence WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur suppression absence : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Absence o) {
        String req = "UPDATE Absence SET seance_id = ?, etudiant_id = ?, justification = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getSeance().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.setString(3, o.getJustification());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur modification absence : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Absence findById(int id) {
        String req = "SELECT * FROM Absence WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Absence(
                    rs.getInt("id"),
                    seanceService.findById(rs.getInt("seance_id")),
                    etudiantService.findById(rs.getInt("etudiant_id")),
                    rs.getString("justification")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Erreur recherche absence : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Absence> findAll() {
        List<Absence> absences = new ArrayList<>();
        String req = "SELECT * FROM Absence";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                absences.add(new Absence(
                    rs.getInt("id"),
                    seanceService.findById(rs.getInt("seance_id")),
                    etudiantService.findById(rs.getInt("etudiant_id")),
                    rs.getString("justification")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur récupération absences : " + ex.getMessage());
        }
        return absences;
    }

    // Méthode pour filtrer les absences par matière
    public List<Absence> findByMatiere(String matiere) {
        List<Absence> absences = new ArrayList<>();
        String req = "SELECT a.* FROM Absence a JOIN Seance s ON a.seance_id = s.id WHERE s.matiere = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, matiere);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                absences.add(new Absence(
                    rs.getInt("id"),
                    seanceService.findById(rs.getInt("seance_id")),
                    etudiantService.findById(rs.getInt("etudiant_id")),
                    rs.getString("justification")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur récupération absences par matière : " + ex.getMessage());
        }
        return absences;
    }
}
