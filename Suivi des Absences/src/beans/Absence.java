package beans;

public class Absence {
    private Seance seance;
    private Etudiant etudiant;
    private String justification;

    public Absence(Seance seance, Etudiant etudiant, String justification) {
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
        return "Absence { 
               "Étudiant: " + etudiant.getNom() + " " + etudiant.getPrenom() + 
               ", Matière: " + seance.getMatiere() + 
               ", Justification: " + justification + " }";
    }
}
