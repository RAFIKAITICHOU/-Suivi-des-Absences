package beans;

import beans.Seance;
import beans.Etudiant;

public class Absence {

    private Seance seance;
    private Etudiant etudiant;
    private String justification;
    private String date;
    private String heure;

    public Absence(String justification, Etudiant etudiant, Seance seance) {
        this.seance = seance;
        this.etudiant = etudiant;
        this.justification = justification;
        if (seance != null) {
            this.date = seance.getDate() != null ? seance.getDate().toString() : "";
            this.heure = seance.getHeure();
        }
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return "Absence { Étudiant: " + etudiant.getNom() + " " + etudiant.getPrenom()
                + ", Matière: " + seance.getMatiere()
                + ", Date: " + date
                + ", Heure: " + heure
                + ", Justification: " + justification + " }";
    }

    public int getId() {
        return this.etudiant.getId();
    }
}
