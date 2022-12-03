/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.puissance4;
import java.util.Random;

/**
 *
 * @author Elisa
 */
public class Partie {
    private Joueur listeJoueurs []= new Joueur[2];
    private Joueur joueurCourant;
    private PlateauDeJeu plateau;

    public Partie(Joueur j1, Joueur j2) {
        this.listeJoueurs[0]=j1;
        this.listeJoueurs[1]=j2;
    }
    
    /**attribuerCouleurAuxJoueurs
     * attribue aléatoirement une couleur au deux joueurs
     */
    public void attribuerCouleurAuxJoueurs(){
        boolean choix;
        Random c = new Random();
        choix = c.nextBoolean();
        if (choix==true){
            listeJoueurs[0].affecterCouleur("rouge");
            listeJoueurs[1].affecterCouleur("jaune");
        }else {
            listeJoueurs[0].affecterCouleur("jaune");
            listeJoueurs[1].affecterCouleur("rouge");
        }
        
    }
    
    /**creerEtAffecterJeton
     * @param joueurCourant
     * créer 30 jetons de la couleur du joueur en paramètre et les ajoute à sa réserve 
     */
    public void creerEtAffecterJeton(Joueur joueurCourant){
        for (int i=0; i<31; i++){
            jeton j = new jeton(joueurCourant.lireCouleur());
            joueurCourant.ajouterJeton(j); 
            i+=1;
        }
    }
    
    /**initialiserLaPartie
     * créer 30 jetons pour chaque couleur pour les 2 joueurs 
     */
    public void initialiserPartie(){
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs[0]);
        creerEtAffecterJeton(listeJoueurs[1]);    
    }
}
