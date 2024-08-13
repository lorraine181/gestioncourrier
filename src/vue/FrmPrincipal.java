/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;

import modele.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
/**
 *
 * @author USER
 */
public class FrmPrincipal extends JFrame implements ActionListener{
    JMenuBar bar; 
    JMenu mdonne,mtrait,mfich;
    JMenuItem mclient,mmateriel,mreparation,mtechnicien;     
    public FrmPrincipal() {
        bar = new JMenuBar(); 
        mfich = new JMenu("Fichier"); 
        mdonne = new JMenu("Donnees de base"); 
        mtrait = new JMenu("Traitement");
        mclient = new JMenuItem("Client");
        mclient.addActionListener(this);
        mtechnicien = new JMenuItem("Contact");
        mtechnicien.addActionListener(this);
        mmateriel = new JMenuItem("Courrier"); 
        mmateriel.addActionListener(this);
        mreparation = new JMenuItem("Employer");
        mreparation.addActionListener(this);
        mdonne.add(mclient); 
        mdonne.add(mtechnicien);
        mdonne.add(mmateriel);
        mdonne.add(mreparation);
        bar.add(mdonne); 
        bar.add(mtrait); 
        bar.add(mfich);
        bar.setBounds(10,10,500,30);
        this.getContentPane().add(bar);
        
        this.setLayout(null);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==mclient){
        FrmClient c = new FrmClient();
        c.setSize(800,800);
        c.setTitle("Gestion des clients");
        c.setVisible(true);  
        }
        else if(e.getSource()==mtechnicien){
                FrmContact  t = new FrmContact();
                t.setSize(800,800);
                t.setTitle("Gestion des techniciens");
                t.setVisible(true);
            }
            else if(e.getSource()==mmateriel){
                FrmCourrier  m = new FrmCourrier();
                m.setSize(800,800);
                m.setTitle("Gestion des materiels");
                m.setVisible(true);
            }
        else if(e.getSource()==mreparation){
                FrmEmployer  r = new FrmEmployer();
                r.setSize(800,800);
                r.setTitle("Gestion des reparations");
                r.setVisible(true);
            }
    }
}

