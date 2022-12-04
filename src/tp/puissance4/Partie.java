/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.puissance4;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Elisa
 */
public class Partie {
    private Joueur listeJoueurs []= new Joueur[2];
    private Joueur joueurCourant;
    private PlateauDeJeu plateau = new PlateauDeJeu() ;

    //public Partie(Joueur j1, Joueur j2) {
        //this.listeJoueurs[0]=j1;
        //this.listeJoueurs[1]=j2;
    //}
    
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
    
    /** JoueurSuivant 
     * donne le prochain joueur a jouer
     * @return le joueur 
     */
    public Joueur JoueurSuivant (){
        if (listeJoueurs[0]==joueurCourant){
            return listeJoueurs[1];
        }else {
            return listeJoueurs[0];
        }
    }
    
    
    public void placerTrousNoirsEtDesintegrateurs (){
        Random r = new Random();
        int compt_d = 5;
        int compt_t=5;
        
        while (compt_d!=0 && compt_t!=0){
            for (int i=0; i<3; i++){
            
                int ligne = r.nextInt(6);
                int colonne =r.nextInt(7);
                plateau.placerTrouNoir(ligne, colonne);
                compt_t-=1;
                plateau.placerDesintegrateur(ligne, colonne);
                compt_d-=1;
            
            }
            for (int i=0; i<2;i++){
                int ligne = r.nextInt(6);
                int colonne =r.nextInt(7);
                if (plateau.presenceDesintegrateur(ligne, colonne)==false && plateau.presenceTrouNoir(ligne, colonne)==false){
                    plateau.placerTrouNoir(ligne, colonne);
                    compt_t-=1;

                }
            }
            for (int i=0; i<2;i++){
                int ligne = r.nextInt(6);
                int colonne =r.nextInt(7);
                if (plateau.presenceDesintegrateur(ligne, colonne)==false && plateau.presenceTrouNoir(ligne, colonne)==false){
                    plateau.placerDesintegrateur(ligne, colonne);
                    compt_d-=1;
                }
            }
        }
    }
    
    /**initialiserLaPartie
     * créer 30 jetons pour chaque couleur pour les 2 joueurs 
     */
    public void initialiserPartie(){
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs[0]);
        creerEtAffecterJeton(listeJoueurs[1]);  
        placerTrousNoirsEtDesintegrateurs ();
        
    }
    
    public void lancerPartie(){

        //Création des joueurs
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choix du pseudo du J1 :");
        Joueur j1 = new Joueur(sc.nextLine());
        
        System.out.println("Choix du pseudo du J2 :");
        Joueur j2 = new Joueur(sc.nextLine());
        
        listeJoueurs[0] = j1;
        listeJoueurs[1] = j2;
        
        attribuerCouleurAuxJoueurs();
        
        System.out.println(j1.nom + " est de couleur "+ j1.couleur);
        System.out.println(j2.nom + " est de couleur "+ j2.couleur);
        
        creerEtAffecterJeton(j1);
        creerEtAffecterJeton(j2);
        
        Random r = new Random();
        boolean le_premier = r.nextBoolean();
        if (le_premier) {
            joueurCourant = listeJoueurs[0];
        } else {
            joueurCourant = listeJoueurs[1];
        }
        
        placerTrousNoirsEtDesintegrateurs ();
        
        plateau.afficherGrilleSurConsole();
        
        
        
    }
}
