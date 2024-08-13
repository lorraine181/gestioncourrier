/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author USER
 */
public class Employer {
    private int Idemplo, tel;
    private String nomserv,nomemplo,prenomemplo;

public Employer(int Idemplo, String nomserv, String nomemplo, String prenomemplo,int tel){
    this.Idemplo = Idemplo;
    this.nomserv = nomserv;
    this.nomemplo = nomemplo;
    this.prenomemplo = prenomemplo;
    this.tel = tel;
}
public Employer(){
}
public int getIdemplo(){
     return Idemplo;
 }
public void setIdemplo(int Idemplo){
      this.Idemplo = Idemplo;
}
public String getNomserv(){
     return nomserv;
 }
public void setNomserv(String nomserv){
      this.nomserv = nomserv;
}
public String getNomemplo(){
     return nomemplo;
 }
public void setNomemplo(String nomemplo){
      this.nomemplo = nomemplo;
}
public String getPrenomemplo(){
     return prenomemplo;
 }
public void setPrenomemplo(String prenomemplo){
      this.prenomemplo = prenomemplo;
}
public int getTel(){
     return tel;
 }
public void setTel(int tel){
      this.tel = tel;
}
}
