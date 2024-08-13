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

public class FrmClient extends JFrame implements ActionListener{
    JLabel idc,nom,prenom,tel,email;
    JTextField tidc,tnom,tprenom,ttel,temail,trecherche;
    JButton be,bv,bi,br,bu,bd;
    ArrayList<Client> listeClient = new ArrayList();
    JTable tableclient;
    private final DefaultTableModel model;
    Client cl = null;
    
public FrmClient(){
   idc = new JLabel("IdClient");
   idc.setBounds(10, 30, 100, 30);
   this.getContentPane().add(idc);
   
   nom = new JLabel("Nom");
   nom.setBounds(10, 70, 100, 30);
   this.getContentPane().add(nom);
   
   prenom = new JLabel("Prenom");
   prenom.setBounds(10, 110, 100, 30);
   this.getContentPane().add(prenom);
   
   tel = new JLabel("Tel");
   tel.setBounds(10, 150, 100, 30);
   this.getContentPane().add(tel);
   
   email = new JLabel("E-mail");
   email.setBounds(10, 190, 100, 30);
   this.getContentPane().add(email);
   
   tidc = new JTextField();
   tidc.setBounds(120, 30, 100, 30);
   this.getContentPane().add(tidc);
   
   tnom = new JTextField();
   tnom.setBounds(120, 70, 100, 30);
   this.getContentPane().add(tnom);
   
   tprenom = new JTextField();
   tprenom.setBounds(120, 110, 100, 30);
   this.getContentPane().add(tprenom);
   
   ttel = new JTextField();
   ttel.setBounds(120, 150, 100, 30);
   this.getContentPane().add(ttel);
   
   temail = new JTextField();
   temail.setBounds(120, 190, 100, 30);
   this.getContentPane().add(temail);
   
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
    cl = new Client();
       if(e.getSource()==be){
          int IdClient = Integer.valueOf(tidc.getText());
          String nom = tnom.getText();
          String prenom = tprenom.getText();
          int tel = Integer.valueOf(ttel.getText());
          String email = temail.getText();
          cl = new Client(IdClient,nom,prenom,tel,email);
          Factory.setClient(cl);
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
                        cl = Factory.getRechcl(rech);
                        if(cl != null){
                            tidc.setText(String.valueOf(cl.getIdClient()));
                            tnom.setText(cl.getNom());
                            tprenom.setText(cl.getPrenom());
                            temail.setText(cl.getEmail());
//                            listenationalite.setSelectedItem(cl.getNationalite());
                            ttel.setText(String.valueOf(cl.getTel()));
                        }
                       }
                                else{
                            if(e.getSource()==bd){
//                                 cl = new Client();
//                                if(cl != null){
                                  String msg = "Souhaitez-vous supprimer ";
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
//                                  if(rep==0){
                                        String IdClient = tidc.getText();
                                        Factory.getdelcl(IdClient);
                                        afficher();
                                        initialiser();
//                                  }
//                                }
                        }
                            else if(e.getSource()==bu){
                            int idc = Integer.valueOf(tidc.getText());
                            String nom = tnom.getText();
                            String prenom = tprenom.getText();
                            int tel = Integer.valueOf(ttel.getText());
                            String email = temail.getText();
//                            String nation = listenationalite.getSelectedItem().toString();
//                            int telephone = Integer.valueOf(ttel.getText());
                            cl = new Client(idc,nom,prenom,tel,email);
                            Factory.modifClient(cl,Integer.valueOf(tidc.getText()));
                            }
                            }
}
       }
           public void afficher(){
             model.setRowCount(0);
             listeClient = Factory.getClient();
             for(Client m : listeClient){
             model.addRow(new Object[]{
             m.getIdClient(),m.getNom(),m.getPrenom(),m.getTel(),m.getEmail()});
             }
             tableclient = new JTable(model);
             JScrollPane p = new JScrollPane(tableclient);
             p.setBounds(60, 400, 450, 100);
             this.getContentPane().add(p);
           }
    public void initialiser(){
    tidc.setText("");
    tnom.setText("");
    tprenom.setText("");
    ttel.setText("");
    temail.setText("");
    }

}
