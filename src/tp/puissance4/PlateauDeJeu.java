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
                grille[i][j] = new CelluleDeGrille(null);
            }            
        }   
    }
    
    public int ajouterJetonDansColonne(jeton Jeton, int indice){
        
    }
    
    public grilleRemplie(){
        
    }
    
    public viderGrille(String Joueur, String Joueur){
        
    }
    
    public afficherGrilleSurConsole(){
        
    }
    
    public presenceJeton(int x, int y){
        
    }
    
    public lireCouleurJeton(int x, int y){
        
    }
    
    public etreGagnantePourCouleur(String couleur){
        public ligneGagnantepourCouleur(String couleur){
            
        }
        
        public colonneGagnantePourCouleur(String couleur){
            
        }
        
        public diagonaleMontanteGagnantePourCouleur(String couleur){
            
        }
        
        public diagonaleDesencanteGagnantePourCouleur(String){
            
        }
    }
    
    
    
}
