/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import beans.Absence;
import beans.Etudiant;
import services.AbsenceService;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ichou
 */
public class BarChartAbsence extends javax.swing.JInternalFrame {

    private AbsenceService absenceService;

    /**
     * Creates new form BarChartAbsence
     */
    public BarChartAbsence() {
        initComponents();
        this.setTitle("Graphe : Nombre d'absences par étudiant");
        absenceService = new AbsenceService();
        displayChart();
    }

    private void displayChart() {
        DefaultCategoryDataset dataset = createDataset();
        JFreeChart barChart = ChartFactory.createBarChart(
                "Nombre d'absences par étudiant",
                "Étudiant",
                "Nombre d'absences",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false // Légende désactivée
        );

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.revalidate();
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Absence> absences = absenceService.findAll();

        Map<String, Integer> absenceCount = new HashMap<>();
        for (Absence absence : absences) {
            Etudiant etudiant = absence.getEtudiant();
            String nomEtudiant = etudiant.getNom() + " " + etudiant.getPrenom();
            absenceCount.put(nomEtudiant, absenceCount.getOrDefault(nomEtudiant, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : absenceCount.entrySet()) {
            dataset.addValue(entry.getValue(), "Absences", entry.getKey());
        }

        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barRenderer1 = new org.jfree.chart.renderer.category.BarRenderer();
        jPanel1 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Graphe : Nombre d'absences par étudiant  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 0, 51))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 879, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jfree.chart.renderer.category.BarRenderer barRenderer1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
