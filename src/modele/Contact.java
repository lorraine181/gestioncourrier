/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author USER
 */
public class Contact {
     private int Id;
     private String nom, prenom,email,sujet,message;
     
public Contact(int Id,String nom, String prenom, String email, String sujet, String message){
    this.Id = Id;
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.sujet = sujet;
    this.message = message;

}
public int getId(){
     return Id;
 }
public void setId(int Id){
      this.Id = Id;
}
public String getNom(){
     return nom;
 }
public void setNom(String nom){
      this.nom = nom;
}
public String getPrenom(){
     return prenom;
 }
public void setPrenom(String prenom){
      this.prenom = prenom;
}
public String getEmail(){
     return email;
 }
public void setEmail(String email){
      this.email = email;
}
public String getSujet(){
     return sujet;
 }
public void setSujet(String sujet){
      this.sujet = sujet;
}
public String getMessage(){
     return message;
 }
public void setMessage(String message){
      this.message = message;
}
public Contact(){
    
}
}
