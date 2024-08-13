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
public class FrmContact extends JFrame implements ActionListener{
    JLabel id,nom,prenom,email,sujet,message;
    JTextField tidc,tnom,tprenom,temail,tsujet,tmessage,trecherche;
    JButton be,bv,bi,br,bu,bd;
    ArrayList<Contact> listeContact = new ArrayList();
    JTable tablecontact;
    private final DefaultTableModel model;
    Contact cl = null;
    
public FrmContact(){
   id = new JLabel("Identifiant");
   id.setBounds(10, 30, 100, 30);
   this.getContentPane().add(id);
   
   nom = new JLabel("Nom");
   nom.setBounds(10, 70, 100, 30);
   this.getContentPane().add(nom);
   
   prenom = new JLabel("Prenom");
   prenom.setBounds(10, 110, 100, 30);
   this.getContentPane().add(prenom);
   
   email = new JLabel("E-mail");
   email.setBounds(10, 150, 100, 30);
   this.getContentPane().add(email);
   
   sujet = new JLabel("Sujet");
   sujet.setBounds(10, 190, 100, 30);
   this.getContentPane().add(sujet);
   
   message = new JLabel("Message");
   message.setBounds(10, 240, 100, 30);
   this.getContentPane().add(message);
   
   tidc = new JTextField();
   tidc.setBounds(120, 30, 100, 30);
   this.getContentPane().add(tidc);
   
   tnom = new JTextField();
   tnom.setBounds(120, 70, 100, 30);
   this.getContentPane().add(tnom);
   
   tprenom = new JTextField();
   tprenom.setBounds(120, 110, 100, 30);
   this.getContentPane().add(tprenom);
   
   temail = new JTextField();
   temail.setBounds(120, 150, 100, 30);
   this.getContentPane().add(temail);
   
   tsujet = new JTextField();
   tsujet.setBounds(120, 190, 100, 30);
   this.getContentPane().add(tsujet);
   
   tmessage = new JTextField();
   tmessage.setBounds(120, 240, 100, 30);
   this.getContentPane().add(tmessage);
   
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
    model.addColumn("Identifiant");
    model.addColumn("Nom");
    model.addColumn("Prenom");
    model.addColumn("E-mail");
    model.addColumn("Sujet");
    model.addColumn("Message");
    
    this.getContentPane().setLayout(null);
}
public void actionPerformed(ActionEvent e){
    cl = new Contact();
       if(e.getSource()==be){
          int idc = Integer.valueOf(tidc.getText());
          String name = tnom.getText();
          String prenomc = tprenom.getText();
          String emailc = temail.getText();
          String sujetc = tsujet.getText();
          String messagec = tmessage.getText();
//          int tel = Integer.valueOf(ttel.getText());
          
          cl = new Contact(idc,name,prenomc,emailc,sujetc,messagec);
          Factory.setContact(cl);
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
                        cl = Factory.getRechco(rech);
                        if(cl != null){
                            tidc.setText(String.valueOf(cl.getId()));
                            tnom.setText(cl.getNom());
                            tprenom.setText(cl.getPrenom());
                            temail.setText(cl.getEmail());
                            tsujet.setText(cl.getSujet());
                            tmessage.setText(cl.getMessage());
//                            listenationalite.setSelectedItem(cl.getNationalite());
//                            ttel.setText(String.valueOf(cl.getTel()));
                        }
                       }
                                else{
                            if(e.getSource()==bd){
                                if(cl != null){
                                  String msg = "Souhaitez-vous supprimer "+cl.getNom()+" - "+cl.getPrenom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelco(cl);
                                        afficher();
                                        initialiser();
                                  }
                                }
                        }
                            else if(e.getSource()==bu){
                            int id = Integer.valueOf(tidc.getText());
                            String nom = tnom.getText();
                            String prenom = tprenom.getText();
                            String email = temail.getText();
                            String sujet = tsujet.getText();
                            String message = tmessage.getText();
//                            int tel = Integer.valueOf(ttel.getText());
//                            String nation = listenationalite.getSelectedItem().toString();
//                            int telephone = Integer.valueOf(ttel.getText());
                            cl = new Contact(id,nom,prenom,email,sujet,message);
                            Factory.modifContact(cl,Integer.valueOf(tidc.getText()));
                            }
                            }
}
       }
           public void afficher(){
             model.setRowCount(0);
             listeContact = Factory.getContact();
             for(Contact m : listeContact){
             model.addRow(new Object[]{
             m.getId(),m.getNom(),m.getPrenom(),m.getEmail(),m.getSujet(),m.getMessage()});
             }
             tablecontact = new JTable(model);
             JScrollPane p = new JScrollPane(tablecontact);
             p.setBounds(60, 400, 450, 100);
             this.getContentPane().add(p);
           }
    public void initialiser(){
    tidc.setText("");
    tnom.setText("");
    tprenom.setText("");
    temail.setText("");
    tsujet.setText("");
    tmessage.setText("");
    }

}


