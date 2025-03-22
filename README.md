# Gestion des Absences des Étudiants

<p align="center">
  <img src="Gestion%20ABS.png" alt="Logo de l'application" width="300">
</p>

Ce projet est une application de **gestion des absences des étudiants**.  
Elle permet de gérer les **séances**, les **étudiants** et leurs **absences** de manière simple et efficace.  
L'application est développée en **Java (Swing)** avec une base de données **MySQL**.

---

## 🎯 Objectif du Projet

Faciliter la gestion des absences des étudiants dans un établissement scolaire ou universitaire en automatisant :
- L’enregistrement des absences,
- Le suivi des étudiants,
- La génération de rapports.

---

## ✅ Fonctionnalités Principales
- **Gestion des Séances** : Ajout et suppression des séances (matière, date, heure, salle).
- **Gestion des Étudiants** : Inscription des étudiants avec photo ou logo.
- **Gestion des Absences** : Enregistrement des absences avec justification.
- **Filtrage par Matière** : Liste des absences par matière donnée.
- **Recherche Étudiant** : Recherche rapide par nom ou email.

---

## 📄 Structure de la Base de Données

| Table           | Description                                        |
| --------------- | -------------------------------------------------- |
| **Seance**      | Contient les informations des séances.             |
| **Etudiant**    | Informations des étudiants et leur logo.           |
| **Absence**     | Enregistre les absences des étudiants aux séances. |
| **Utilisateur** | Gestion des utilisateurs et rôles.                 |

---

## 📊 Schéma SQL de la Base de Données

```sql
CREATE TABLE Seance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    matiere VARCHAR(100) NOT NULL,
    date DATE NOT NULL,
    heure TIME NOT NULL,
    salle VARCHAR(50) NOT NULL
);

CREATE TABLE Etudiant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    logo VARCHAR(255)
);

CREATE TABLE Absence (
    seance_id INT NOT NULL,
    etudiant_id INT NOT NULL,
    justification TEXT,
    PRIMARY KEY (seance_id, etudiant_id),
    FOREIGN KEY (seance_id) REFERENCES Seance(id),
    FOREIGN KEY (etudiant_id) REFERENCES Etudiant(id)
);

CREATE TABLE Utilisateur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin', 'enseignant', 'etudiant') NOT NULL
);
---
## 🖥️ Technologies et Bibliothèques Utilisées
Java (Swing) : Développement de l'interface graphique.

MySQL : Base de données relationnelle.

MySQL Connector/J : Connexion Java-MySQL (JDBC).

JCalendar : Gestion des dates dans les formulaires.

JFreeChart (optionnel) : Visualisation graphique (absences par matière).


