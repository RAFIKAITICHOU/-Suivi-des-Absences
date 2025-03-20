package test;

import beans.Absence;
import beans.Etudiant;
import beans.Seance;
import java.util.Date;
import services.AbsenceService;
import services.EtudiantService;
import services.SeanceService;

public class Test {
    public static void main(String[] args) {
        EtudiantService etudiantService = new EtudiantService();
        SeanceService seanceService = new SeanceService();
        AbsenceService absenceService = new AbsenceService();

        System.out.println("Ajout d'un étudiant");
        Etudiant etudiant = new Etudiant("AIT ICHOU", "Rafik", "rafikaitichou@email.com");
        etudiantService.create(etudiant);

        System.out.println("Ajout d'une séance");
        Seance seance = new Seance("Informatique", new Date(), "08:30", "Salle B1");
        seanceService.create(seance);

        System.out.println("Ajout d'une absence");
        Absence absence = new Absence("Maladie", etudiant,seance);
        absenceService.create(absence);

        System.out.println("Liste des étudiants");
        for (Etudiant e : etudiantService.findAll()) {
            System.out.println(e);
        }

        System.out.println("Liste des séances");
        for (Seance s : seanceService.findAll()) {
            System.out.println(s);
        }

        System.out.println("Liste des absences");
        for (Absence a : absenceService.findAll()) {
            System.out.println(a);
        }
    }
}
