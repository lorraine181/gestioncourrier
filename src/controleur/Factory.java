/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.*;
import java.time.format.*;
import modele.*;
import vue.*;

/**
 *
 * @author USER
 */
public class Factory {
    public static Connection conn = null;
    public static Statement stm;
    public static PreparedStatement pstmet = null;
    public static ResultSet rs = null;
    
public static Connection getConnection(){
String serveur = "localhost";
int port = 3306;
String database = "gestion";
String username = "root";
String password = "";
  try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         String url = "jdbc:mysql://" + serveur + ":" + port + "/" + database;
         conn = DriverManager.getConnection(url, username, password);
         System.out.println("connected");
         
         return conn;
  }
  catch(Exception e){
    e.printStackTrace();
    return null;
  }
}
public static void setClient(Client cl){
   try{
       conn = getConnection();
       pstmet = conn.prepareStatement("insert into courrier.client(IdClient,nom,prenom,tel,email) values (?,?,?,?,?)");
       pstmet.setInt(1, cl.getIdClient());
       pstmet.setString(2, cl.getNom());
       pstmet.setString(3, cl.getPrenom());
       pstmet.setInt(4, cl.getTel());
       pstmet.setString(5, cl.getEmail());
       pstmet.executeUpdate();
       pstmet.close();
       conn.close();
   }
   catch(Exception ex){
       ex.printStackTrace();
    }
}
public static ArrayList<Client> getClient(){
 ArrayList<Client> lic = new ArrayList();
 Client cli = null;
  try{
       conn = getConnection();
       stm = conn.createStatement();
       rs = stm.executeQuery("select * from courrier.client"); 
        while(rs.next()){
            cli  = new Client();
            cli.setIdClient(rs.getInt("IdClient"));
            cli.setNom(rs.getString("nom"));
            cli.setPrenom(rs.getString("prenom"));
            cli.setTel(rs.getInt("tel"));
            cli.setEmail(rs.getString("email"));
            lic.add(cli);
        }
      conn.close();
      stm.close();
  }  
    catch(Exception e){
    }
  return lic;
    }
    public static Client getRechcl(int cli){
        Client cl = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from courrier.client where IDclient='"+cli+"'");
            if(rs.next()){
                cl = new Client();
                cl.setIdClient(rs.getInt("IdClient"));
                cl.setNom(rs.getString("nom"));
                cl.setPrenom(rs.getString("prenom"));
                cl.setTel(rs.getInt("tel"));
                cl.setEmail(rs.getString("email"));
//                cl.setNationalite(rs.getString("nationalite"));
               
            }
            conn.close();
            stm.close();
            return cl;
        }
        catch(Exception e){
        return null;
        }
        }
  public static void getdelcl(String cl){
    try{
        conn = getConnection();
        pstmet = conn.prepareStatement("delete from courrier.client where IdClient =?");
        pstmet.setString(1, cl);
        pstmet.executeUpdate();
        conn.close();
    }
    catch (Exception e){
    }
  }
    public static void modifClient(Client cli,int c){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("update courrier.client set nom=?,prenom=?,tel=?,email=?, where IDClient='"+c+"'");
//            pstmet.setInt(1, cli.getIdclient());
            pstmet.setString(1, cli.getNom());
            pstmet.setString(2, cli.getPrenom());
            pstmet.setString(3, cli.getEmail());
//            pstmet.setString(4, cli.getNationalite());
            pstmet.setInt(5, cli.getTel());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    //frmcontact
    public static void setContact(Contact co){
   try{
       conn = getConnection();
       pstmet = conn.prepareStatement("insert into courrier.contact(nom,prenom,tel,email,message) values (?,?,?,?,?)");
       pstmet.setInt(1, co.getId());
       pstmet.setString(2, co.getNom());
       pstmet.setString(3, co.getPrenom());
//       pstmet.setInt(4, co.getTel());
       pstmet.setString(5, co.getEmail());
       pstmet.setString(5, co.getMessage());
       pstmet.executeUpdate();
       
       pstmet.close();
       conn.close();
   }
   catch(Exception ex){
       ex.printStackTrace();
    }
}
public static ArrayList<Contact> getContact(){
 ArrayList<Contact> lic = new ArrayList();
 Contact cli = null;
  try{
       conn = getConnection();
       stm = conn.createStatement();
       rs = stm.executeQuery("select * from courrier.contact"); 
        while(rs.next()){
            cli  = new Contact();
            cli.setId(rs.getInt("Id"));
            cli.setNom(rs.getString("nom"));
            cli.setPrenom(rs.getString("prenom"));
//            cli.setTel(rs.getInt("tel"));
            cli.setEmail(rs.getString("email"));
            cli.setSujet(rs.getString("sujet"));
            cli.setMessage(rs.getString("message"));
            lic.add(cli);
        }
      conn.close();
      stm.close();
  }  
    catch(Exception e){
    }
  return lic;
    }
    public static Contact getRechco(int cli){
        Contact cl = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from courrier.contact where Id='"+cli+"'");
            if(rs.next()){
                cl = new Contact();
                cl.setId(rs.getInt("id"));
                cl.setNom(rs.getString("nom"));
                cl.setPrenom(rs.getString("prenom"));
//                cl.setTel(rs.getInt("tel"));
                cl.setEmail(rs.getString("email"));
                cl.setSujet(rs.getString("sujet"));
                cl.setMessage(rs.getString("message"));
//                cl.setNationalite(rs.getString("nationalite"));
               
            }
            conn.close();
            stm.close();
            return cl;
        }
        catch(Exception e){
        return null;
        }
        }
    public static void getDelco(Contact co){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from courrier.contact where id='"+co.getId()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
        }
      }
    public static void modifContact(Contact cli,int c){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("update courrier.contact set nom=?,prenom=?,email=?,sujet=?,message=? where id='"+c+"'");
//            pstmet.setInt(1, cli.getIdclient());
            pstmet.setString(1, cli.getNom());
            pstmet.setString(2, cli.getPrenom());
            pstmet.setString(3, cli.getEmail());
            pstmet.setString(3, cli.getSujet());
            pstmet.setString(3, cli.getMessage());
//            pstmet.setString(4, cli.getNationalite());
//            pstmet.setInt(5, cli.getTel());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    //frmcourrier
        public static void setCourrier(Courrier co){
   try{
       conn = getConnection();
       pstmet = conn.prepareStatement("insert into courrier.contact(nom,prenom,tel,email) values (?,?,?,?)");
       pstmet.setInt(1, co.getIdC());
       pstmet.setInt(2, co.getTrackingnumber());
       pstmet.setString(3, co.getSendername());
//       pstmet.setInt(4, co.getTel());
       pstmet.setString(5, co.getRecepientname());
       pstmet.setString(5, co.getRecipientadresse());
       int RowsInserted = pstmet.executeUpdate();
       if(RowsInserted > 0){
       System.out.print("Donnees enregistre avec succes!");
       }else{
          System.out.print("echec de l'enregistrement des donnees");
       }
       pstmet.close();
       conn.close();
   }
   catch(Exception ex){
       ex.printStackTrace();
    }
}
public static ArrayList<Courrier> getCourrier(){
 ArrayList<Courrier> lic = new ArrayList();
 Courrier cli = null;
  try{
       conn = getConnection();
       stm = conn.createStatement();
       rs = stm.executeQuery("select * from courrier.courrier"); 
        while(rs.next()){
            cli  = new Courrier();
            cli.setIdC(rs.getInt("Id"));
            cli.setTrackingnumber(rs.getInt("tracking_number"));
            cli.setSendername(rs.getString("sender_name"));
//            cli.setTel(rs.getInt("tel"));
            cli.setRecepientname(rs.getString("recepient_name"));
            cli.setRecipientadresse(rs.getString("recepient_adresse"));
//            cli.setMessage(rs.getString("message"));
        }
      conn.close();
      stm.close();
  }  
    catch(Exception e){
    }
  return lic;
    }
    public static Courrier getRechcou(int cli){
        Courrier cl = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from courrier.courrier where id='"+cli+"'");
            if(rs.next()){
                cl = new Courrier();
                cl.setIdC(rs.getInt("id"));
                cl.setTrackingnumber(rs.getInt("tracking_number"));
                cl.setSendername(rs.getString("sender_name"));
//                cl.setTel(rs.getInt("tel"));
                cl.setRecepientname(rs.getString("recepient_name"));
                cl.setRecipientadresse(rs.getString("recepient_adresse"));
//                cl.setMessage(rs.getString("message"));
//                cl.setNationalite(rs.getString("nationalite"));
               
            }
            conn.close();
            stm.close();
            return cl;
        }
        catch(Exception e){
        return null;
        }
        }
    public static void getDelcou(Courrier cou){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from courrier.courrier where id='"+cou.getIdC()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
        }
      }
    public static void modifCourrier(Courrier cli,int c){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("update courrier.courrier set idc=?,trackingnumber=?,sendername=?,recepientname=?,recipientadresse=? where idc='"+c+"'");
            pstmet.setInt(1, cli.getIdC());
            pstmet.setInt(2, cli.getTrackingnumber());
            pstmet.setString(3, cli.getSendername());
            pstmet.setString(4, cli.getRecepientname());
            pstmet.setString(5, cli.getRecipientadresse());
//            pstmet.setString(6, cli.getMessage());
//            pstmet.setString(4, cli.getNationalite());
//            pstmet.setInt(5, cli.getTel());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    //frm employer
    
    public static void setEmployer(Employer cl){
   try{
       conn = getConnection();
       pstmet = conn.prepareStatement("insert into courrier.employer(Idemplo,nom_service,nom_employe,prenom_employe,tel) values (?,?,?,?)");
       pstmet.setInt(1, cl.getIdemplo());
       pstmet.setString(2, cl.getNomserv());
       pstmet.setString(3, cl.getNomemplo());
       pstmet.setString(4, cl.getPrenomemplo());
       pstmet.setInt(5, cl.getTel());
       
       int RowsInserted = pstmet.executeUpdate();
       if(RowsInserted > 0){
       System.out.print("Donnees enregistre avec succes!");
       }else{
          System.out.print("echec de l'enregistrement des donnees");
       }
       pstmet.close();
       conn.close();
   }
   catch(Exception ex){
       ex.printStackTrace();
    }
}
public static ArrayList<Employer> getEmployer(){
 ArrayList<Employer> lic = new ArrayList();
 Employer cli = null;
  try{
       conn = getConnection();
       stm = conn.createStatement();
       rs = stm.executeQuery("select * from courrier.employer"); 
        while(rs.next()){
            cli  = new Employer();
            cli.setIdemplo(rs.getInt("Idemplo"));
            cli.setNomserv(rs.getString("nom_service"));
            cli.setNomemplo(rs.getString("nom_employe"));
            cli.setPrenomemplo(rs.getString("prenom_employe"));
            cli.setTel(rs.getInt("tel"));
            
        }
      conn.close();
      stm.close();
  }  
    catch(Exception e){
    }
  return lic;
    }
    public static Employer getRechemp(int cli){
        Employer cl = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from courrier.employer where Idemplo='"+cli+"'");
            if(rs.next()){
                cl = new Employer();
                cl.setIdemplo(rs.getInt("Idemplo"));
                cl.setNomserv(rs.getString("nom_service"));
                cl.setNomemplo(rs.getString("nom_employe"));
                cl.setPrenomemplo(rs.getString("prenom_employe"));
                cl.setTel(rs.getInt("tel"));
//                cl.setNationalite(rs.getString("nationalite"));
               
            }
            conn.close();
            stm.close();
            return cl;
        }
        catch(Exception e){
        return null;
        }
        }
    public static void getDelemp(Employer cli){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from courrier.employer where Idemplo='"+cli.getIdemplo()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
        }
      }
    public static void modifEmployer(Employer cli,int c){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("update courrier.employer set Idemplo=?,nom_service=?,nom_employe=?,Prenom_employe=?,tel=? where Idemplo='"+c+"'");
            pstmet.setInt(1, cli.getIdemplo());
            pstmet.setString(2, cli.getNomserv());
            pstmet.setString(3, cli.getNomemplo());
            pstmet.setString(4, cli.getPrenomemplo());
            pstmet.setInt(5, cli.getTel());
//            pstmet.setString(4, cli.getNationalite());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
}
//}

