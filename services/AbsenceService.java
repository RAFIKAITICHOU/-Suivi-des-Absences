package services;

import beans.Absence;
import beans.Etudiant;
import beans.Seance;
import connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbsenceService {

    private Connexion connexion;
    private SeanceService seanceService;
    private EtudiantService etudiantService;

    public AbsenceService() {
        connexion = Connexion.getInstance();
        seanceService = new SeanceService();
        etudiantService = new EtudiantService();
    }

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

    public boolean delete(Absence o) {
        String req = "DELETE FROM Absence WHERE seance_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getSeance().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur suppression absence : " + ex.getMessage());
        }
        return false;
    }

    public boolean update(Absence o) {
        String req = "UPDATE Absence SET justification = ? WHERE seance_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getJustification());
            ps.setInt(2, o.getSeance().getId());
            ps.setInt(3, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur modification absence : " + ex.getMessage());
        }
        return false;
    }

    public List<Absence> findAll() {
        List<Absence> absences = new ArrayList<>();
        String req = "SELECT * FROM Absence";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Etudiant e = etudiantService.findById(rs.getInt("etudiant_id"));
                Seance s = seanceService.findById(rs.getInt("seance_id"));
                absences.add(new Absence(rs.getString("justification"), e, s));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur récupération absences : " + ex.getMessage());
        }
        return absences;
    }

    public List<Absence> findByEtudiantNom(String nom) {
        List<Absence> absences = new ArrayList<>();
        String req = "SELECT a.justification, e.id AS etuId, e.nom, e.prenom, s.id AS seanceId, s.matiere "
                + "FROM Absence a "
                + "JOIN Etudiant e ON a.etudiant_id = e.id "
                + "JOIN Seance s ON a.seance_id = s.id "
                + "WHERE e.nom LIKE ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, "%" + nom + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Etudiant e = new Etudiant(rs.getInt("etuId"), rs.getString("nom"), rs.getString("prenom"), "");
                Seance s = new Seance(rs.getInt("seanceId"), rs.getString("matiere"), null, "", "");
                absences.add(new Absence(rs.getString("justification"), e, s));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur recherche par nom : " + ex.getMessage());
        }
        return absences;
    }
}
