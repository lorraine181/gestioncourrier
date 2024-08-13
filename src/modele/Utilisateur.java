/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author USER
 */
public class Utilisateur {
    private int idutilisateur,password;
    private String username,status,etat;
    
public Utilisateur(int idutilisateur, int password, String username, String status,String etat){
    this.idutilisateur = idutilisateur;
    this.username = username;
    this.password = password;
    this.status = status;
    this.etat = etat;
}
public int getIdutilisateur(){
     return idutilisateur;
 }
public void setIdutilisateur(int idutilisateur){
      this.idutilisateur = idutilisateur;
}
public String getUsername(){
     return username;
 }
public void setUsername(String username){
      this.username = username;
}
public int getPassword(){
     return password;
 }
public void setPassword(int password){
      this.password = password;
}
public String getStatus(){
     return status;
 }
public void setStatus(String status){
      this.status = status;
}
public String getEtat(){
     return etat;
 }
public void setEtat(String etat){
      this.etat = etat;
}
}
