package com.myapp.login;


public class UserDTO {

	private String nom;
    private String prenom;
    
    public UserDTO(String prenom, String nom) {
        this.nom = nom;
        this.prenom = prenom;
     }
    
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
