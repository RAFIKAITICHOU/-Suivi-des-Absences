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

        System.out.println("=== Ajout d'un étudiant ===");
        Etudiant etudiant = new Etudiant("Dupont", "Jean", "jean.dupont@email.com");
        if (etudiantService.create(etudiant)) {
            System.out.println("✔ Étudiant ajouté !");
        } else {
            System.out.println("✖ Erreur lors de l'ajout de l'étudiant !");
        }

        System.out.println("\n=== Ajout d'une séance ===");
        Seance seance = new Seance("Mathématiques", new Date(), "10:00", "Salle A1");
        if (seanceService.create(seance)) {
            System.out.println("✔ Séance ajoutée !");
        } else {
            System.out.println("✖ Erreur lors de l'ajout de la séance !");
        }

        System.out.println("\n=== Ajout d'une absence ===");
        Absence absence = new Absence(seance, etudiant, "Maladie");
        if (absenceService.create(absence)) {
            System.out.println("✔ Absence ajoutée !");
        } else {
            System.out.println("✖ Erreur lors de l'ajout de l'absence !");
        }

        System.out.println("\n=== Liste des étudiants ===");
        for (Etudiant e : etudiantService.findAll()) {
            System.out.println(e);
        }

        System.out.println("\n=== Liste des séances ===");
        for (Seance s : seanceService.findAll()) {
            System.out.println(s);
        }
        System.out.println("\n=== Liste des absences ===");
        for (Absence a : absenceService.findAll()) {
            System.out.println(a);
        }

        System.out.println("\n=== Recherche d'un étudiant par ID ===");
        Etudiant etu = etudiantService.findById(1);
        if (etu != null) {
            System.out.println("✔ Étudiant trouvé : " + etu);
        } else {
            System.out.println("✖ Étudiant introuvable !");
        }

        System.out.println("\n=== Recherche d'une séance par ID ===");
        Seance se = seanceService.findById(1);
        if (se != null) {
            System.out.println("✔ Séance trouvée : " + se);
        } else {
            System.out.println("✖ Séance introuvable !");
        }

        System.out.println("\n=== Recherche d'une absence par ID ===");
        Absence abs = absenceService.findById(1);
        if (abs != null) {
            System.out.println("✔ Absence trouvée : " + abs);
        } else {
            System.out.println("✖ Absence introuvable !");
        }

        if (etu != null) {
            System.out.println("\n=== Modification d'un étudiant ===");
            etu.setNom("Durand");
            if (etudiantService.update(etu)) {
                System.out.println("✔ Étudiant modifié !");
            } else {
                System.out.println("✖ Erreur lors de la modification !");
            }
        }
        if (se != null) {
            System.out.println("\n=== Modification d'une séance ===");
            se.setMatiere("Physique");
            if (seanceService.update(se)) {
                System.out.println("✔ Séance modifiée !");
            } else {
                System.out.println("✖ Erreur lors de la modification !");
            }
        }

        if (abs != null) {
            System.out.println("\n=== Modification d'une absence ===");
            abs.setJustification("Retard");
            if (absenceService.update(abs)) {
                System.out.println("✔ Absence modifiée !");
            } else {
                System.out.println("✖ Erreur lors de la modification !");
            }
        }

        if (abs != null) {
            System.out.println("\n=== Suppression d'une absence ===");
            if (absenceService.delete(abs)) {
                System.out.println("✔ Absence supprimée !");
            } else {
                System.out.println("✖ Erreur lors de la suppression !");
            }
        }

        if (se != null) {
            System.out.println("\n=== Suppression d'une séance ===");
            if (seanceService.delete(se)) {
                System.out.println("✔ Séance supprimée !");
            } else {
                System.out.println("✖ Erreur lors de la suppression !");
            }
        }

        if (etu != null) {
            System.out.println("\n=== Suppression d'un étudiant ===");
            if (etudiantService.delete(etu)) {
                System.out.println("✔ Étudiant supprimé !");
            } else {
                System.out.println("✖ Erreur lors de la suppression !");
            }
        }

        System.out.println("\n=== Fin des tests ===");
    }
}
