/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import beans.Absence;
import beans.Etudiant;
import beans.Seance;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.AbsenceService;
import services.EtudiantService;
import services.SeanceService;

/**
 *
 * @author ichou
 */
public class AbsenceForm extends javax.swing.JInternalFrame {

    private AbsenceService as;
    private DefaultTableModel model;
    private int id;

    /**
     * Creates new form AbsenceForm
     */
    public AbsenceForm() {
        initComponents();
        this.setTitle("Gestion des Absences");
        as = new AbsenceService();
        model = (DefaultTableModel) listeAbsences.getModel();
        load();

        /*txtSeanceActionPerformed(null);
        txtEtudiantActionPerformed(null);*/
        remplirComboSeance();
        remplirComboEtudiant();
    }

    private void remplirComboSeance() {
        try {
            txtSeance.removeAllItems();
            for (Seance s : new SeanceService().findAll()) {
                txtSeance.addItem(s.getMatiere()); // Ajoute le nom de la matière
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur de chargement des séances !");
        }
    }

    private void remplirComboEtudiant() {
        txtEtudiant.removeAllItems();

        for (Etudiant e : new EtudiantService().findAll()) {
            txtEtudiant.addItem(e.getNom());
        }
    }

    public void load() {
        model.setRowCount(0);
        for (Absence a : as.findAll()) {
            model.addRow(new Object[]{a.getId(), a.getSeance().getMatiere(), a.getEtudiant().getNom(), a.getEtudiant().getPrenom(), a.getJustification()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtJustification = new javax.swing.JTextField();
        bnAdd = new javax.swing.JButton();
        bnDelete = new javax.swing.JButton();
        bnUpdate = new javax.swing.JButton();
        txtSeance = new javax.swing.JComboBox<>();
        txtEtudiant = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeAbsences = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Suivi des absences"));

        jLabel1.setText("seance");

        jLabel2.setText("etudiant");

        jLabel3.setText("Justification");

        txtJustification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJustificationActionPerformed(evt);
            }
        });

        bnAdd.setBackground(new java.awt.Color(0, 255, 0));
        bnAdd.setText("Ajouter");
        bnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAddActionPerformed(evt);
            }
        });

        bnDelete.setBackground(new java.awt.Color(255, 0, 0));
        bnDelete.setText("supprimer");
        bnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDeleteActionPerformed(evt);
            }
        });

        bnUpdate.setBackground(new java.awt.Color(51, 153, 255));
        bnUpdate.setText("Modifier");
        bnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnUpdateActionPerformed(evt);
            }
        });

        txtSeance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtSeance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeanceActionPerformed(evt);
            }
        });

        txtEtudiant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEtudiantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtJustification, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(txtSeance, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEtudiant, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(181, 181, 181)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtSeance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtJustification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bnUpdate)
                        .addGap(29, 29, 29)
                        .addComponent(bnAdd)
                        .addGap(29, 29, 29)))
                .addComponent(bnDelete)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des absences"));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        listeAbsences.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Seance", "Etudaint Nom", "Etudaint Prenom", "Justification"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        listeAbsences.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeAbsencesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeAbsences);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJustificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJustificationActionPerformed
        // TODO add your handling code here:
        String justification = txtJustification.getText();
        JOptionPane.showMessageDialog(this, "Justification saisie : " + justification);
    }//GEN-LAST:event_txtJustificationActionPerformed

    private void bnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddActionPerformed
        // TODO add your handling code here:
        Seance seance = (Seance) txtSeance.getSelectedItem();
        Etudiant etudiant = (Etudiant) txtEtudiant.getSelectedItem();
        String justification = txtJustification.getText();

        if (seance == null || etudiant == null) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un étudiant et une séance !");
            return;
        }

        if (as.create(new Absence(justification, etudiant, seance))) {
            JOptionPane.showMessageDialog(this, "Absence ajoutée !");
            load();
        } else {
            JOptionPane.showMessageDialog(this, "Erreur d'ajout !");
        }

    }//GEN-LAST:event_bnAddActionPerformed

    private void listeAbsencesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeAbsencesMouseClicked
        // TODO add your handling code here:
        id = Integer.parseInt(model.getValueAt(listeAbsences.getSelectedRow(), 0).toString());

        // Récupérer les infos de la ligne sélectionnée
        String seanceMatiere = model.getValueAt(listeAbsences.getSelectedRow(), 1).toString();
        String etudiantNom = model.getValueAt(listeAbsences.getSelectedRow(), 2).toString();
        String etudiantPrenom = model.getValueAt(listeAbsences.getSelectedRow(), 3).toString();
        String justification = model.getValueAt(listeAbsences.getSelectedRow(), 4).toString();

        // Sélectionner la Seance dans le ComboBox
        // Remplir la justification
        txtJustification.setText(justification);
    }//GEN-LAST:event_listeAbsencesMouseClicked

    private void bnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnUpdateActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment modifier ?");
        if (response == 0) {
            Seance seance = (Seance) txtSeance.getSelectedItem();
            Etudiant etudiant = (Etudiant) txtEtudiant.getSelectedItem();
            String justification = txtJustification.getText();

            Absence a = new Absence(justification, etudiant, seance); // Garde l'id de l'absence
            if (as.update(a)) {
                JOptionPane.showMessageDialog(this, "Absence modifiée !");
                load();
            } else {
                JOptionPane.showMessageDialog(this, "Erreur de modification !");
            }
        }
    }//GEN-LAST:event_bnUpdateActionPerformed

    private void bnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer ?");
        if (res == 0) {
            String nomEtudiant = model.getValueAt(listeAbsences.getSelectedRow(), 2).toString();

            List<Absence> absences = as.findByEtudiantNom(nomEtudiant);

            if (!absences.isEmpty()) {
                Absence a = absences.get(0);
                if (as.delete(a)) {
                    JOptionPane.showMessageDialog(this, "Absence supprimée !");
                    load();
                } else {
                    JOptionPane.showMessageDialog(this, "Erreur de suppression !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Aucune absence trouvée pour cet étudiant !");
            }
        }
    }//GEN-LAST:event_bnDeleteActionPerformed

    private void txtSeanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeanceActionPerformed
        // TODO add your handling code here:
        try {
            txtSeance.removeAllItems();

            for (Seance s : new SeanceService().findAll()) {
                txtSeance.addItem(s.getMatiere());
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur de chargement des séances !");
        }
    }//GEN-LAST:event_txtSeanceActionPerformed

    private void txtEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEtudiantActionPerformed
        // TODO add your handling code here:
        try {
            txtEtudiant.removeAllItems();

            for (Etudiant e : new EtudiantService().findAll()) {
                txtEtudiant.addItem(e.getNom());
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur de chargement des étudiants !");
        }
    }//GEN-LAST:event_txtEtudiantActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAdd;
    private javax.swing.JButton bnDelete;
    private javax.swing.JButton bnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeAbsences;
    private javax.swing.JComboBox<String> txtEtudiant;
    private javax.swing.JTextField txtJustification;
    private javax.swing.JComboBox<String> txtSeance;
    // End of variables declaration//GEN-END:variables

}
