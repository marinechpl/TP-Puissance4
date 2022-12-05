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
    private PlateauDeJeu plateau = new PlateauDeJeu();

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
            //placement Désintégrateurs et Trous noirs
            for (int i=0; i<3; i++){
                int ligne = r.nextInt(6);
                int colonne =r.nextInt(7);
                while (plateau.presenceDesintegrateur(ligne, colonne)!= false  || plateau.presenceTrouNoir(ligne, colonne)!=false){
                    ligne = r.nextInt(6);
                    colonne =r.nextInt(7);
                    plateau.placerTrouNoir(ligne, colonne);
                    compt_t-=1;
                    plateau.placerDesintegrateur(ligne, colonne);
                    compt_d-=1;
                }
            }
        
            //placement Trous noirs 
        while (compt_d!=0 && compt_t!=0){    
            for (int i=0; i<2;i++){
                int ligne = r.nextInt(6);
                int colonne =r.nextInt(7);
                while (plateau.presenceDesintegrateur(ligne, colonne)!=false || plateau.presenceTrouNoir(ligne, colonne)!=false){
                    ligne = r.nextInt(6);
                    colonne =r.nextInt(7);
                }plateau.placerTrouNoir(ligne, colonne);
                compt_t-=1;
                }
        }
            // placement Déseintégrateurs 
            for (int i=0; i<2;i++){
                int ligne = r.nextInt(6);
                int colonne =r.nextInt(7);
                while (plateau.presenceDesintegrateur(ligne, colonne)!=false || plateau.presenceTrouNoir(ligne, colonne)!=false){
                    ligne = r.nextInt(6);
                    colonne =r.nextInt(7);
                }plateau.placerDesintegrateur(ligne, colonne);
                compt_d-=1;
            }
        
    }
    
    /**initialiserLaPartie
     * créer 30 jetons pour chaque couleur pour les 2 joueurs 
     */
    public void initialiserPartie(){
        
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
            System.out.println("C'est au tour de " + listeJoueurs[0] );
        } else {
            joueurCourant = listeJoueurs[1];
            System.out.println("C'est au tour de " + listeJoueurs[1] );
        }
        
        placerTrousNoirsEtDesintegrateurs ();
        plateau.afficherGrilleSurConsole();
    }
    
    public int actionJoueur(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Que voulez-vous faire ?");
        System.out.println("1) Jouer un Jeton");
        System.out.println("2) Recuperer un Jeton");
        System.out.println("3) Desintegrer un Jeton");
        int choix = sc.nextInt();
        while (choix > 3 || choix < 1) {
            System.out.println("Erreur : Entrer un choix qui existe :");
            choix = sc.nextInt();
        }return choix;
    }
    
    public void jouerJeton(){
        Scanner sc = new Scanner(System.in);
        boolean resultatAction;
        System.out.println("Veuillez saisir une colonne :");
        int colonne = sc.nextInt();
        while (colonne > 6 || colonne < 0) {
            System.out.println("Erreur : veuillez saisir une colonne :");
            colonne = sc.nextInt();
        }
        resultatAction = plateau.colonneRemplie(colonne);
        while (resultatAction!=false) {
            System.out.println("La colonne est pleine veuillez saisir une autre colonne :");
            colonne = sc.nextInt();
            resultatAction = plateau.colonneRemplie(colonne);
                
        }
        plateau.ajouterJetonDansColonne(joueurCourant.jouerJeton(), colonne);
    }
    
    public boolean recupererJeton (){
        Scanner sc = new Scanner(System.in);
        int colonne;
        int ligne ; 
        System.out.println("Veuillez saisir les coordonnees du jeton a recuperer :");
        System.out.println("Veuillez saisir la colonne :");
        colonne = sc.nextInt();
        while (colonne > 6 || colonne < 0) {
            System.out.println("Erreur : veuillez saisir une colonne valide :");
            colonne = sc.nextInt();
        }
        System.out.println("Veuillez saisir la ligne :");
        ligne = sc.nextInt() - 1;
        while (ligne > 5 || ligne < 0) {
            System.out.println("Erreur : veuillez saisir une ligne valide :");
            ligne = sc.nextInt() - 1;
        }
        if (plateau.presenceJeton(ligne, colonne)!=false 
                    && plateau.lireCouleurJeton(ligne, colonne)==joueurCourant.couleur){
                joueurCourant.ajouterJeton(plateau.recupererJeton(ligne, colonne));
                plateau.tasserColonne(colonne);
                return true;
        }else {
            return false;
    }
    }
    
    public boolean desintJeton(){
        if (joueurCourant.nbDesintegrateur()==0){
            return false;
        }
        int colonne;
        int ligne;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir les coordonnees du jeton a désintegrer :");
        System.out.println("Veuillez saisir la colonne :");
        colonne = sc.nextInt() - 1;
        while (colonne > 6 || colonne < 0) {
            System.out.println("Erreur : veuillez saisir une colonne valide :");
            colonne = sc.nextInt() - 1;
        }
        System.out.println("Veuillez saisir la ligne :");
        ligne = sc.nextInt() - 1;
        while (ligne > 5 || ligne < 0) {
            System.out.println("Erreur : veuillez saisir une ligne valide :");
            ligne = sc.nextInt() - 1;
        }

        if (plateau.presenceJeton(ligne,colonne) != null && plateau.lireCouleurJeton(ligne, colonne)==joueurCourant.lireCouleur()) {
            plateau.supprimerJeton(ligne, colonne);
            plateau.tasserColonne(colonne);
            plateau.placerDesintegrateur(ligne, colonne);
            return true;

        }
        return false;
    }
    
    public boolean TourDeJeu(){
        System.out.println("C'est a " + joueurCourant.nom + " de jouer (" + joueurCourant.couleur + ")");
        System.out.println("Il vous reste " + joueurCourant.nombreDeJetons() + " jetons");
        System.out.println("Il vous reste " + joueurCourant.nbDesintegrateur() + " desintegrateurs");
        int choix = actionJoueur();
        switch (choix) {
            case 1:
                jouerJeton();
                return true;
            //break;
            case 2:
                if (!recupererJeton()) {
                    System.out.println("Vous avez soit saisi un jeton qui n'est pas le votre ou un endroit sans jeton");
                    return false;
                }

                break;
            case 3:
                if (!desintJeton()) {
                    System.out.println("Vous avez soit saisi un jeton qui est le vôtre ou vous n'avez pas de desintegrateur");
                    return false;
                }
                break;
        }
        return true;
    }
   
    public void lancerPartie(){
        initialiserPartie();
        Scanner sc = new Scanner(System.in);

        do {
            while (!TourDeJeu()) {
                System.out.println("Recommencez votre tour");
            }
            
            plateau.afficherGrilleSurConsole();
            joueurCourant = JoueurSuivant();

        } while (plateau.etreGagnantePourCouleur(listeJoueurs[0].lireCouleur()) != true && plateau.etreGagnantePourCouleur(listeJoueurs[1].lireCouleur()) != true && plateau.grilleRemplie() != true);

        if (plateau.etreGagnantePourCouleur(listeJoueurs[0].lireCouleur()) == true && plateau.etreGagnantePourCouleur(listeJoueurs[1].lireCouleur()) == true) {
            System.out.println("C'est " + joueurCourant.nom + " qui a gagne !");
        } else {
            System.out.println("C'est " + JoueurSuivant().nom + " qui a gagne !");
        }

        
    }
}
   