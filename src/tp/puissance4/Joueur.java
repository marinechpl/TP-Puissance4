/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.puissance4;
import java. util. ArrayList;
/**
 *
 * @author Elisa
 */
public class Joueur {
    private String nom; 
    private jeton couleur;
    private ArrayList <jeton> reserveJetons = null;
  
    
    public Joueur(String nom) {
        this.nom = nom;
        
    }
    
    public String joueur(){
        nom= " "; 
        return nom;
    }
    
    public String affecterCouleur(){
        return couleur.lireCouleur();
    }
    
    public int nombreDeJetons(){
        return reserveJetons.size();
    }
    
}



    
    
    
    
