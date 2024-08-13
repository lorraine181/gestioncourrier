/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author USER
 */
public class Client {
    private int IdClient,tel;
    private String nom,prenom,email;

public Client(int IdClient, String nom, String prenom, int tel, String email){
  this.IdClient = IdClient;
  this.nom = nom;
  this.prenom = prenom;
  this.tel = tel;
  this.email = email;
}
public Client(){
    
}
   public int getIdClient(){
       return IdClient;
   }
   public void setIdClient(int IdClient){
        this.IdClient = IdClient;
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
   public int getTel(){
      return tel;
   }
   public void setTel(int tel){
        this.tel = tel;
   }
   public String getEmail(){
    return email;
   }
   public void setEmail(String email){
      this.email = email;
   }
}