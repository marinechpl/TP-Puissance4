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
    private String couleur;
    private ArrayList <jeton> reserveJetons = null;
  
    
     /** Joueur
     * constructeur : initialise le nom du joueur
     * @param couleur
     */
    public Joueur(String nom) {
        this.nom = nom;    
    }
    
     /** affecterCouleur
     * affecte au joueur la couleur passée en paramètre 
     * @param couleur
     */
    public void affecterCouleur(String couleur){
        this.couleur = couleur;
    }
    
     /** lireCouleur
     * 
     * @return la couleur du joueur 
     */
    public String lireCouleur(){
        return couleur;
    }
    
     /** nombreDeJetons
     * compte le nombre de jeton dans la réserve du joueur
     * @return le nombre de jetons disponibles 
     */
    public int nombreDeJetons(){
        return reserveJetons.size();
    }
    
     /** ajouterJeton
     * ajoute le jeton en paramètre à la réserve du joueur 
     * @param jet
     */
    public void ajouterJeton(jeton jet){
        reserveJetons.add(jet);
    }
    
    /** jouerJeton
     * retire un jeton de la réserve 
     * @return lien vers le jeton enlevé 
     */
    public jeton jouerJeton(){
        jeton jet = reserveJetons.remove(0);
        return jet;
    }
}



    
    
    
    
