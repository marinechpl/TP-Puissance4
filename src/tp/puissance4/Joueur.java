/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.puissance4;

/**
 *
 * @author Elisa
 */
public class Joueur {
    private String nom; 
    private String couleur;
    private jeton reserveJetons;
  
    
    public Joueur(String nom, String couleur, int reserveJetons) {
        this.nom = nom;
        this.couleur = couleur;
        this.reserveJetons = reserveJetons;
    }
    public String joueur(){
        nom= " ";
        return nom;
    }
    
    public String affecterCouleur(){
        return couleur.lireCouleur();
    }
    
    public int nombreDeJetons(){
    return length.reserveJetons();
    }
    
    public jeton ajouterJeton();
    
    
}



    
    
    
    
