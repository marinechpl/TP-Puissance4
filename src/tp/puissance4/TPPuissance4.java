/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp.puissance4;

/**
 *
 * @author 33769
 */
public class TPPuissance4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        jeton J1 = new jeton ("rouge");
        jeton J2 = new jeton ("jaune");
        CelluleDeGrille cel = new CelluleDeGrille();
        
        PlateauDeJeu P1 = new PlateauDeJeu();
        
        P1.ajouterJetonDansColonne(J1,1);
        P1.ajouterJetonDansColonne(J2, 2);
        P1.ajouterJetonDansColonne(J1,3);
        P1.ajouterJetonDansColonne(J1,4);
        P1.ajouterJetonDansColonne(J1,1);
        P1.ajouterJetonDansColonne(J1,1);
        P1.ajouterJetonDansColonne(J1,1);
        boolean rep = P1.colonneGagnantePourCouleur("rouge");
        
        System.out.println (rep);
        
        P1.afficherGrilleSurConsole();
        
        
        
        
    }
}
