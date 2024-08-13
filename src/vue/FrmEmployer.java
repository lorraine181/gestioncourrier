/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;

import modele.*;
import controleur.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author USER
 */
public class FrmEmployer extends JFrame implements ActionListener{
    JLabel Idemplo,nomserv,nomemplo,prenomemplo,tel;
    JTextField tIdemplo,tnomserv,tnomemplo,tprenomemplo,ttel,trecherche;
    JButton be,bv,bi,br,bu,bd;
    ArrayList<Client> listeEmploye = new ArrayList();
    JTable tableemploye;
    private final DefaultTableModel model;
    Employer cl = null;
    
public FrmEmployer(){
   Idemplo = new JLabel("Idemplo");
   Idemplo.setBounds(10, 30, 100, 30);
   this.getContentPane().add(Idemplo);
   
   nomserv = new JLabel("Nom_service");
   nomserv.setBounds(10, 70, 100, 30);
   this.getContentPane().add(nomserv);
   
   nomemplo = new JLabel("Nom_employe");
   nomemplo.setBounds(10, 110, 100, 30);
   this.getContentPane().add(nomemplo);
   
   prenomemplo = new JLabel("Prenom_employe");
   prenomemplo.setBounds(10, 150, 100, 30);
   this.getContentPane().add(prenomemplo);
   
   tel = new JLabel("Tel");
   tel.setBounds(10, 190, 100, 30);
   this.getContentPane().add(tel);
   
   tIdemplo = new JTextField();
   tIdemplo.setBounds(120, 30, 100, 30);
   this.getContentPane().add(tIdemplo);
   
   tnomserv = new JTextField();
   tnomserv.setBounds(120, 70, 100, 30);
   this.getContentPane().add(tnomserv);
   
   tnomemplo = new JTextField();
   tnomemplo.setBounds(120, 110, 100, 30);
   this.getContentPane().add(tnomemplo);
   
   tprenomemplo = new JTextField();
   tprenomemplo.setBounds(120, 150, 100, 30);
   this.getContentPane().add(tprenomemplo);
   
   ttel = new JTextField();
   ttel.setBounds(120, 190, 100, 30);
   this.getContentPane().add(ttel);
   
    trecherche = new JTextField();
    trecherche.setBounds(230, 30, 100, 30);
    this.getContentPane().add(trecherche);
    
    be = new JButton("Enregistrer");
    be.setBounds(10, 300, 120, 30);
    be.addActionListener(this);
    this.getContentPane().add(be);
    
    bv = new JButton("visualiser");
    bv.setBounds(140, 300, 120, 30);
    bv.addActionListener(this);
    this.getContentPane().add(bv);
    
    bi = new JButton("Initialiser");
    bi.setBounds(270, 300, 120, 30);
    bi.addActionListener(this);
    this.getContentPane().add(bi);
    
    br = new JButton("Rechercher");
    br.setBounds(400, 300, 120, 30);
    br.addActionListener(this);
    this.getContentPane().add(br);
    
    bu = new JButton("Update");
    bu.setBounds(530, 300, 120, 30);
    bu.addActionListener(this);
    this.getContentPane().add(bu);
    
    bd = new JButton("Delete");
    bd.setBounds(660, 300, 120, 30);
    bd.addActionListener(this);
    this.getContentPane().add(bd);
    
    model = new DefaultTableModel();
    model.addColumn("IdClient");
    model.addColumn("Nom");
    model.addColumn("Prenom");
//    model.addColumn("Adresse");
    model.addColumn("Tel");
    model.addColumn("E-mail");
    
    this.getContentPane().setLayout(null);
 }
public void actionPerformed(ActionEvent e){
    cl = new Employer();
       if(e.getSource()==be){
          int Idemplo = Integer.valueOf(tIdemplo.getText());
          String nomserv = tnomserv.getText();
          String nomemplo = tnomemplo.getText();
          String prenomemplo = tprenomemplo.getText();
          int tel = Integer.valueOf(ttel.getText());
          cl = new Employer(Idemplo,nomserv,nomemplo,prenomemplo,tel);
          Factory.setEmployer(cl);
       }
       else
           if(e.getSource()==bv){
              afficher();
           }
       else
               if(e.getSource()==bi){
                   initialiser();
               }
       
                  else{
                       if(e.getSource()==br){
                        int rech = Integer.valueOf(trecherche.getText());
                        cl = Factory.getRechemp(rech);
                        if(cl != null){
                            tIdemplo.setText(String.valueOf(cl.getIdemplo()));
                            tnomserv.setText(cl.getNomserv());
                            tnomemplo.setText(cl.getNomemplo());
                            tprenomemplo.setText(cl.getPrenomemplo());
//                            listenationalite.setSelectedItem(cl.getNationalite());
                            ttel.setText(String.valueOf(cl.getTel()));
                        }
                       }
                                else{
                            if(e.getSource()==bd){
                                if(cl != null){
                                  String msg = "Souhaitez-vous supprimer "+cl.getNomserv();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelemp(cl);
                                        afficher();
                                        initialiser();
                                  }
                                }
                        }
                            else if(e.getSource()==bu){
                            int idc = Integer.valueOf(tIdemplo.getText());
                            String nom = tnomserv.getText();
                            String prenom = tnomemplo.getText();
                            String email = tprenomemplo.getText();
                            int tel = Integer.valueOf(ttel.getText());
//                            String nation = listenationalite.getSelectedItem().toString();
//                            int telephone = Integer.valueOf(ttel.getText());
                            cl = new Employer(idc,nom,prenom,email,tel);
                            Factory.modifEmployer(cl,Integer.valueOf(tIdemplo.getText()));
                            }
                            }
}
       }
           public void afficher(){
             model.setRowCount(0);
             listeEmploye = Factory.getClient();
             for(Client m : listeEmploye){
             model.addRow(new Object[]{
             m.getIdClient(),m.getNom(),m.getPrenom(),m.getTel(),m.getEmail()});
             }
             tableemploye = new JTable(model);
             JScrollPane p = new JScrollPane(tableemploye);
             p.setBounds(60, 400, 450, 100);
             this.getContentPane().add(p);
           }
    public void initialiser(){
    tIdemplo.setText("");
    tnomserv.setText("");
    tnomemplo.setText("");
    tprenomemplo.setText("");
    ttel.setText("");
    }

}
