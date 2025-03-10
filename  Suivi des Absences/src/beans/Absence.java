package beans;

// ✅ Import des classes Seance et Etudiant

public class Absence {
    private int id;
    private Seance seance;
    private Etudiant etudiant;
    private String justification;

    public Absence(int id, Seance seance, Etudiant etudiant, String justification) {
        this.id = id;
        this.seance = seance;
        this.etudiant = etudiant;
        this.justification = justification;
    }

    public Absence(Seance seance, Etudiant etudiant, String justification) {
        this.seance = seance;
        this.etudiant = etudiant;
        this.justification = justification;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Seance getSeance() { return seance; }
    public void setSeance(Seance seance) { this.seance = seance; }

    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }

    public String getJustification() { return justification; }
    public void setJustification(String justification) { this.justification = justification; }

    @Override
    public String toString() {
        return "Absence { ID: " + id + 
               ", Étudiant: " + etudiant.getNom() + " " + etudiant.getPrenom() + 
               ", Matière: " + seance.getMatiere() + 
               ", Justification: " + justification + " }";
    }
}
