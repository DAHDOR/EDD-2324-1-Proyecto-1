/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import App.Utilities;

/**
 *
 * @author Admin
 */
public class Interface extends javax.swing.JFrame {
    
    /**
     * Creates new form Interfaz
     */
    public Interface() {
        
        initComponents();
        
        filter = new javax.swing.filechooser.FileNameExtensionFilter("Archivos TXT", "txt");
        
        FileChooser.setFileFilter(filter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();
        WindowTabs = new javax.swing.JTabbedPane();
        TabStart = new javax.swing.JPanel();
        StartTitle = new javax.swing.JLabel();
        StartCreate = new javax.swing.JButton();
        StartLoad = new javax.swing.JButton();
        WindowMenus = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        FileCreate = new javax.swing.JMenuItem();
        FileLoad = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 576));

        TabStart.setMinimumSize(new java.awt.Dimension(1024, 518));
        TabStart.setPreferredSize(new java.awt.Dimension(1024, 518));
        TabStart.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StartTitle.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        StartTitle.setText("Connections");
        TabStart.add(StartTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        StartCreate.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        StartCreate.setText("Nueva red social");
        StartCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartCreateActionPerformed(evt);
            }
        });
        TabStart.add(StartCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        StartLoad.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        StartLoad.setText("Cargar red social");
        StartLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartLoadActionPerformed(evt);
            }
        });
        TabStart.add(StartLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, -1, -1));

        WindowTabs.addTab("Inicio", TabStart);

        getContentPane().add(WindowTabs, java.awt.BorderLayout.CENTER);

        MenuFile.setText("Archivo");

        FileCreate.setText("Nueva red social...");
        FileCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileCreateActionPerformed(evt);
            }
        });
        MenuFile.add(FileCreate);

        FileLoad.setText("Cargar red social...");
        FileLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileLoadActionPerformed(evt);
            }
        });
        MenuFile.add(FileLoad);

        jMenuItem1.setText("Guardar red social");
        MenuFile.add(jMenuItem1);

        WindowMenus.add(MenuFile);

        MenuEdit.setText("Editar");
        WindowMenus.add(MenuEdit);

        setJMenuBar(WindowMenus);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartCreateActionPerformed
        String validChars = "abcdefghijklmnñopqrstuvwxyzáéíóú0123456789-_ ";
        while (true) {
            try {
                String graphname = javax.swing.JOptionPane.showInputDialog("Nombre de la red social:");
                if (graphname == null) break;
                if (!Utilities.validateCharacters(graphname.toLowerCase(), validChars)) {
                    throw new java.io.IOException("Solo se permiten caracteres alfanuméricos, espacios, \"_\" y \"-\".");
                }
                GraphViewer tab = new GraphViewer();
                WindowTabs.add(graphname, tab);
                break;
            } catch (java.io.IOException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_StartCreateActionPerformed

    private void FileCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileCreateActionPerformed
        String validChars = "abcdefghijklmnñopqrstuvwxyzáéíóú0123456789-_ ";
        while (true) {
            try {
                String graphname = javax.swing.JOptionPane.showInputDialog("Nombre de la red social:");
                if (graphname == null) break;
                if (!Utilities.validateCharacters(graphname.toLowerCase(), validChars)) {
                    throw new java.io.IOException("Solo se permiten caracteres alfanuméricos, espacios, \"_\" y \"-\".");
                }
                GraphViewer tab = new GraphViewer();
                WindowTabs.add(graphname, tab);
                break;
            } catch (java.io.IOException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_FileCreateActionPerformed

    private void StartLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartLoadActionPerformed
        
        try {
            int returnVal = FileChooser.showOpenDialog(null);

            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                EDD.Graph graph = new EDD.Graph();
                graph.load(FileChooser.getSelectedFile());
                GraphViewer tab = new GraphViewer(graph);
                String filename = FileChooser.getSelectedFile().getName();
                WindowTabs.add(filename.substring(0, filename.length()-4), tab);
            }
        } catch (java.io.IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_StartLoadActionPerformed

    private void FileLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileLoadActionPerformed
        
        try {
            int returnVal = FileChooser.showOpenDialog(null);

            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                EDD.Graph graph = new EDD.Graph();
                graph.load(FileChooser.getSelectedFile());
                GraphViewer tab = new GraphViewer(graph);
                WindowTabs.add(tab);
            }
        } catch (java.io.IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_FileLoadActionPerformed

    
    javax.swing.filechooser.FileNameExtensionFilter filter;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JMenuItem FileCreate;
    private javax.swing.JMenuItem FileLoad;
    private javax.swing.JMenu MenuEdit;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JButton StartCreate;
    private javax.swing.JButton StartLoad;
    private javax.swing.JLabel StartTitle;
    private javax.swing.JPanel TabStart;
    private javax.swing.JMenuBar WindowMenus;
    private javax.swing.JTabbedPane WindowTabs;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}