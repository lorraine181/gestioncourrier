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
public class FrmCourrier extends JFrame implements ActionListener{
    JLabel IdC,trackingnumber,sendername, recepientname,recipientadresse;
    JTextField tIdC,ttrackingnumber,tsendername, trecepientname,trecipientadresse,trecherche;
    JButton be,bv,bi,br,bu,bd;
    ArrayList<Client> listeCourrier = new ArrayList();
    JTable tablecourrier;
    private final DefaultTableModel model;
    Courrier cl = null;
    
public FrmCourrier(){
   IdC = new JLabel("IdC");
   IdC.setBounds(10, 30, 100, 30);
   this.getContentPane().add(IdC);
   
   trackingnumber = new JLabel("Trancking_number");
   trackingnumber.setBounds(10, 70, 100, 30);
   this.getContentPane().add(trackingnumber);
   
   sendername = new JLabel("Sender_name");
   sendername.setBounds(10, 110, 100, 30);
   this.getContentPane().add(sendername);
   
   recepientname = new JLabel("Recepient_name");
   recepientname.setBounds(10, 150, 100, 30);
   this.getContentPane().add(recepientname);
   
   recipientadresse = new JLabel("Recepient_adresse");
   recipientadresse.setBounds(10, 190, 100, 30);
   this.getContentPane().add(recipientadresse);
   
   tIdC = new JTextField();
   tIdC.setBounds(120, 30, 100, 30);
   this.getContentPane().add(tIdC);
   
   ttrackingnumber = new JTextField();
   ttrackingnumber.setBounds(120, 70, 100, 30);
   this.getContentPane().add(ttrackingnumber);
   
   tsendername = new JTextField();
   tsendername.setBounds(120, 110, 100, 30);
   this.getContentPane().add(tsendername);
   
   trecepientname = new JTextField();
   trecepientname.setBounds(120, 150, 100, 30);
   this.getContentPane().add(trecepientname);
   
   trecipientadresse = new JTextField();
   trecipientadresse.setBounds(120, 190, 100, 30);
   this.getContentPane().add(trecipientadresse);
   
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
    cl = new Courrier();
       if(e.getSource()==be){
          int IdC = Integer.valueOf(tIdC.getText());
          int trackingnumber = Integer.valueOf(ttrackingnumber.getText());
          String sendername = tsendername.getText();
          String recepientname = trecepientname.getText();
//          int tel = Integer.valueOf(ttel.getText());
          String recipientadresse = trecipientadresse.getText();
          cl = new Courrier(IdC,trackingnumber,sendername,recepientname,recipientadresse);
          Factory.setCourrier(cl);
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
                        cl = Factory.getRechcou(rech);
                        if(cl != null){
                            tIdC.setText(String.valueOf(cl.getIdC()));
                            ttrackingnumber.setText(String.valueOf(cl.getTrackingnumber()));
                            tsendername.setText(cl.getSendername());
                            trecepientname.setText(cl.getRecepientname());
                            trecipientadresse.setText(cl.getRecipientadresse());
//                            listenationalite.setSelectedItem(cl.getNationalite());
//                            ttel.setText(String.valueOf(cl.getTel()));
                        }
                       }
                                else{
                            if(e.getSource()==bd){
                                if(cl != null){
                                  String msg = "Souhaitez-vous supprimer "+cl.getSendername()+" - "+cl.getRecepientname();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelcou(cl);
                                        afficher();
                                        initialiser();
                                  }
                                }
                        }
                            else if(e.getSource()==bu){
                            int IdC = Integer.valueOf(tIdC.getText());
                            int trackingnumber = Integer.valueOf(ttrackingnumber.getText());
                            String sendername = tsendername.getText();
                            String recepientname = trecepientname.getText();
                            String recipientadresse = trecipientadresse.getText();
//                            int tel = Integer.valueOf(ttel.getText());
//                            String nation = listenationalite.getSelectedItem().toString();
//                            int telephone = Integer.valueOf(ttel.getText());
                            cl = new Courrier(IdC,trackingnumber,sendername,recepientname,recipientadresse);
                            Factory.modifCourrier(cl,Integer.valueOf(tIdC.getText()));
                            }
                            }
}
       }
           public void afficher(){
             model.setRowCount(0);
             listeCourrier = Factory.getClient();
             for(Client m : listeCourrier){
             model.addRow(new Object[]{
             m.getIdClient(),m.getNom(),m.getPrenom(),m.getTel(),m.getEmail()});
             }
             tablecourrier = new JTable(model);
             JScrollPane p = new JScrollPane(tablecourrier);
             p.setBounds(60, 400, 450, 100);
             this.getContentPane().add(p);
           }
    public void initialiser(){
    tIdC.setText("");
    ttrackingnumber.setText("");
    tsendername.setText("");
    trecepientname.setText("");
    trecipientadresse.setText("");
    }

}
