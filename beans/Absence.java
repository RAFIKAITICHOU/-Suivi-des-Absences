package beans;

import beans.Seance;
import beans.Etudiant;

public class Absence {
    private Seance seance;
    private Etudiant etudiant;
    private String justification;

    public Absence(String justification, Etudiant etudiant, Seance seance) {
        this.seance = seance;
        this.etudiant = etudiant;
        this.justification = justification;
    }


    public Seance getSeance() { return seance; }
    public void setSeance(Seance seance) { this.seance = seance; }

    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }

    public String getJustification() { return justification; }
    public void setJustification(String justification) { this.justification = justification; }

    @Override
    public String toString() {
        return "Absence { Étudiant: " + etudiant.getNom() + " " + etudiant.getPrenom() + 
               ", Matière: " + seance.getMatiere() + ", Justification: " + justification + " }";
    }

    public int getId() {
        return this.etudiant.getId();
    }
}
