/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author USER
 */
public class Courrier {
    private int IdC,trackingnumber;
    private String sendername, recepientname,recipientadresse;
    
public Courrier(int IdC,int trackingnumber , String sendername, String recepientname, String recipientadresse){
    this.IdC = IdC;
    this.trackingnumber = trackingnumber;
    this.sendername = sendername;
    this.recepientname = recepientname;
    this.recipientadresse = recipientadresse;
}
public Courrier(){

}
public int getIdC(){
     return IdC;
 }
public void setIdC(int IdC){
      this.IdC = IdC;
}
public int getTrackingnumber(){
     return trackingnumber;
 }
public void setTrackingnumber(int trackingnumber){
      this.trackingnumber = trackingnumber;
}
public String getSendername(){
     return sendername;
 }
public void setSendername(String sendername){
      this.sendername = sendername;
}
public String getRecepientname(){
     return recepientname;
 }
public void setRecepientname(String recepientname){
      this.recepientname = recepientname;
}
public String getRecipientadresse(){
     return recipientadresse;
 }
public void setRecipientadresse(String recipientadresse){
      this.recipientadresse = recipientadresse;
}
}
