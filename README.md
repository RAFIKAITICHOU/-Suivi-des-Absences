# Gestion des Absences des Étudiants

<p align="center">
  <img src="Gestion%20ABS.png" alt="Logo de l'application" width="600">
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
## 🖥️ Technologies et Bibliothèques Utilisées
Java (Swing) : Développement de l'interface graphique.

MySQL : Base de données relationnelle.

MySQL Connector/J : Connexion Java-MySQL (JDBC).

JCalendar : Gestion des dates dans les formulaires.

JFreeChart (optionnel) : Visualisation graphique (absences par matière).

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
```
---
## 🏢 Architecture du Projet
```
GestionAbsencesEtudiants/
├── src/
│   ├── beans/                # Modèles (Seance, Etudiant, Absence, Utilisateur)
│   ├── connexion/            # Connexion MySQL
│   ├── dao/                  # Data Access Object (DAO)
│   ├── gui/                  # Interfaces Swing (JInternalFrame)
│   │   ├── SeanceForm.java
│   │   ├── EtudiantForm.java
│   │   ├── AbsenceForm.java
│   │   ├── RechercheAbsenceForm.java
│   │   ├── MDIApplication.java
│   │   └── Main.java
│   ├── services/             # Logique métier
│   └── test/                 # Tests unitaires
├── lib/                      # Librairies externes (JCalendar, Connector/J)
├── resources/                # Images et fichiers de config
└── README.md                 # Documentation
```
---
## 🗂️ Diagrammes UML
📌 **Diagramme de Cas d'Utilisation**
![image](https://github.com/RAFIKAITICHOU/-Suivi-des-Absences/blob/main/diagramme%20de_classe.png)


📌 **Diagramme de Classe**
![image](https://github.com/RAFIKAITICHOU/-Suivi-des-Absences/blob/main/use%20cas.png)


---
## 📽️ Démonstration Vidéo
👉 ▶️ Cliquez ici pour voir <a href="https://drive.google.com/file/d/1o0jCbQJ85ejwcPmp3jGhBefYCbPubOeF/view?usp=sharing">la démo vidéo</a> :
[Démonstration](https://github.com/RAFIKAITICHOU/-Suivi-des-Absences/blob/main/Enregistrement%20de%20l%E2%80%99e%CC%81cran%202025-03-23%20a%CC%80%2012.02.37.mp4)
La vidéo montre le fonctionnement complet de l'application.

---
## 🔒 Gestion des Utilisateurs
L'application gère plusieurs rôles :

**Administrateur**

**Enseignant**

**Étudiant**

Chaque utilisateur a un accès spécifique selon son rôle.

---
## ⚙️ Visualisation de l'Architecture - MVC (Modèle - Vue - Contrôleur)
**Modèle (beans/dao)** : Représente la base de données et la logique de persistance.

**Vue (gui/)** : Formulaires Swing pour interagir avec l'utilisateur.

**Contrôleur (services/)** : Gère la logique métier et les traitements.

---
## 📈 Évolutions Futures Possibles

1.Ajout de graphiques statistiques (par matière, par étudiant).

2.Envoi automatique des rapports d’absences par mail.

3.Accès distant à l’application.

---
## 🤝 Contributeurs
AIT ICHOU RAFIK

Encadrant: **LACHGAR Mohamed**

---
