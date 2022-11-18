/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.puissance4;

/**
 *
 * @author Elisa
 */
public class PlateauDeJeu {
    CelluleDeGrille[][] grille = new CelluleDeGrille[6][7];

    public PlateauDeJeu() {
        for (int i=0; i<6;i++){
            for (int j=0; j<7; j++){
                grille[i][j] = grille[6][7];
            }            
        }   
    }
    
    public int ajouterJetonDansColonne(String jeton, int indice){
    
    }
   
}
