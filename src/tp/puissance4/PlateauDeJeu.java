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
    
    public int ajouterJetonDansColonne(jeton Jeton, int indice_c){
        int indice_l=6;
        for(int i=1; i<6; i++){
            if (grille[indice_l][indice_c].presenceJeton()==false){
                return indice_l;     
            }else {
                indice_l=indice_l-i;
            }
        }return indice_l;
    }

    public boolean grilleRemplie(){
        boolean rep = false ;
        for (int i=0; i<6; i++){
            for (int j=0; j<7;j++){
                if (grille[i][j].presenceJeton()==false){
                    rep=false;
                } else {
                    rep=true;
                }
            }
        } return rep ;
    }
        
    public boolean colonneRemplie(int ind_c){
        for (int i= 0; i<6; i++){
            if (grille[i][ind_c].presenceJeton()==false){
                return false;
            }
        }return true;
    }
    
    //public viderGrille(String Joueur, String Joueur){  
    //}
    
    public String afficherGrilleSurConsole(){ 
         for (int i = 0; i<=6 ; i++) {
            for (int j = 0; j < 7; j++) {
                 if (grille[i][j].presenceJeton() == false) {
                    return ".";
                } else {
                    return grille[i][j].lireCouleurDuJeton();
                }
            }
         }
    }
    
    public Boolean presenceJeton(int x, int y){
        boolean pres = grille[x][y].presenceJeton();
        return pres;
    }
    
    public String lireCouleurJeton(int x, int y){
        String couleur = grille[x][y].lireCouleurDuJeton();
        return couleur ; 
    }
    
    //public boolean etreGagnantePourCouleur(String couleur){
    //}

    public boolean ligneGagnantepourCouleur(String couleur){ 
            boolean rep_c = false;
            for (int i=0; i<=3;i++){
                for (int j=0; j<=5;j++){
                    if ((grille[i][j].lireCouleurDuJeton()==grille[i][j+1].lireCouleurDuJeton()) && grille[i][j].lireCouleurDuJeton()==grille[i][j+2].lireCouleurDuJeton() && grille[i][j].lireCouleurDuJeton()==grille[i][j+3].lireCouleurDuJeton()){
                        return true;
                    }                   
                }
            }return rep_c;        
    }

    public boolean colonneGagnantePourCouleur(String couleur){
        boolean rep_l = false ;
        for (int i=0; i<=6;i++){
                for (int j=0; j<=2;j++){
                    if ((grille[i][j].lireCouleurDuJeton()==grille[i+1][j].lireCouleurDuJeton()) && grille[i][j].lireCouleurDuJeton()==grille[i+2][j].lireCouleurDuJeton() && grille[i][j].lireCouleurDuJeton()==grille[i+3][j].lireCouleurDuJeton()){
                        return true;
                    }                   
                }
            }return rep_l;   
    }

    //public boolean diagonaleMontanteGagnantePourCouleur(String couleur){
        
    //}
    
    //public boolean diagonaleDesencanteGagnantePourCouleur(String couleur){
    //}


}   
