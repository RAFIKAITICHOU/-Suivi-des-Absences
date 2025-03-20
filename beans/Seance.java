
package beans;

import java.util.Date;

public class Seance {
    private int id;
    private String matiere;
    private Date date;
    private String heure;
    private String salle;

    public Seance(int id, String matiere, Date date, String heure, String salle) {
        this.id = id;
        this.matiere = matiere;
        this.date = date;
        this.heure = heure;
        this.salle = salle;
    }

    public Seance(String matiere, Date date, String heure, String salle) {
        this.matiere = matiere;
        this.date = date;
        this.heure = heure;
        this.salle = salle;
    }

    public int getId() { return id; }
    
    public void setId(int id) { this.id = id; }
    
    
    public String getMatiere() { return matiere; }
    
    public void setMatiere(String matiere) { this.matiere = matiere; }
    
    
    public Date getDate() { return date; }
    
    public void setDate(Date date) { this.date = date; }
    
    
    public String getHeure() { return heure; }
    
    public void setHeure(String heure) { this.heure = heure; }
    
    
    public String getSalle() { return salle; }
    public void setSalle(String salle) { this.salle = salle; }
    
    @Override
    public String toString() {
        return matiere;
    }
}
