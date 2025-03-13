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
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Absence o) {
        String req = "DELETE FROM Absence WHERE seance_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getSeance().getId());
            ps.setInt(2, o.getEtudiant().getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Absence o) {
        String req = "UPDATE Absence SET justification = ? WHERE seance_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getJustification());
            ps.setInt(2, o.getSeance().getId());
            ps.setInt(3, o.getEtudiant().getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Absence findById(int id) {
        return null; // Supprimé car on ne gère plus `id`
    }

    @Override
    public List<Absence> findAll() {
        List<Absence> absences = new ArrayList<>();
        String req = "SELECT seance_id, etudiant_id, justification FROM Absence";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                absences.add(new Absence(
                    seanceService.findById(rs.getInt("seance_id")),
                    etudiantService.findById(rs.getInt("etudiant_id")),
                    rs.getString("justification")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return absences;
    }

    public List<Absence> findByMatiere(String matiere) {
        List<Absence> absences = new ArrayList<>();
        String req = "SELECT a.seance_id, a.etudiant_id, a.justification FROM Absence a " +
                     "JOIN Seance s ON a.seance_id = s.id WHERE s.matiere = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, matiere);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                absences.add(new Absence(
                    seanceService.findById(rs.getInt("seance_id")),
                    etudiantService.findById(rs.getInt("etudiant_id")),
                    rs.getString("justification")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return absences;
    }
}
