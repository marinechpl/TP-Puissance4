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

    /** PlateauDeJeu()
     * Constructeur de la classe : création des 42 cellules vides 
     */
    public PlateauDeJeu() { 
        for (int i=0; i<6;i++){
            for (int j=0; j<7; j++){
                grille[i][j] = new CelluleDeGrille();
            }            
        }   
    }
    
    /** ajouterJetonDansColonne 
     * @param Jeton
     * @param indice_c
     * ajoute le jeton en paramètre dans la case vide la plus basse de la 
     * colonne en paramètre 
     * @return indice de la ligne 
     */
    public int ajouterJetonDansColonne(jeton Jeton, int indice_c){
        int indice_l=0;
        for(int i=0; i<6; i++){
            if (grille[indice_l][indice_c-1].presenceJeton()==false){
                grille[indice_l][indice_c-1].affecterJeton(Jeton);  
                return indice_l;
            }else {
                indice_l=indice_l+1;
            }
        }return indice_l;
    }
    
    /** colonneRemplie 
     * @param ind_c
     * savoir si la colonne est remplie ou non 
     * @return vrai ou faux si colonne remplie ou non 
     */
    public boolean colonneRemplie(int ind_c){
        for (int i= 0; i<6; i++){
            if (grille[i][ind_c].presenceJeton()==false){
                return false;
            }
        }return true;
    }
    
    /** grilleRemplie 
     * savoir si la grille est remplie ou non 
     * @return vrai ou faux si colonne remplie ou non 
     */
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
    

    //public viderGrille(String Joueur, String Joueur){  
      //  for (int i=0; i<6; i++){
        //    for (int j=0; j<7; j++){
          //      grille[i][j].jetonCourant=null;
            //}
        //}
    //}

    
    /** acfficherGrilleSurConsole 
     * va permettre d'afficher la grille complete sur la console 
     */
    public void afficherGrilleSurConsole(){ 
        // on commence par la ligne d'en haut : ligne 6 
        for (int i=5; i>=0 ; i--) {
            System.out.print("\n");
            for (int j = 0; j < 7; j++){
                System.out.print(grille[i][j]);
            }
         }
    }
    
    /** presenceJeton 
     * @param x
     * @param y
     * regarde si un jeton est présent dans la cellule des coord x,y
     * @return vrai ou faux
     */
    public Boolean presenceJeton(int x, int y){
        return grille[x][y].presenceJeton();
    }
    
    /** lireCouleurJeton 
     * @param x
     * @param y
     * regarde la couleur du jeton dans la cellule des coord x,y
     * @return vrai ou faux
     */
    public String lireCouleurJeton(int x, int y){
        return grille[x][y].lireCouleurDuJeton(); 
    }
    
    public boolean etreGagnantePourCouleur(String couleur){
        if (ligneGagnantePourCouleur(couleur)==true 
                || colonneGagnantePourCouleur(couleur)== true 
                || diagonaleMontanteGagnantePourCouleur(couleur)== true 
                || diagonaleDescendanteGagnantePourCouleur(couleur)== true){
            return true; 
        }else {
            return false;
        }
        
    }

    /** ligneGagnantePourCouleur 
     * @param couleur
     * regarde si la ligne est gagnante 
     * @return vrai ou faux
     */
    public boolean ligneGagnantePourCouleur(String couleur){ 
            boolean rep_c = false;
            for (int i=0; i<6;i++){
                for (int j=0; j<4;j++){
                    if (grille[i][j].lireCouleurDuJeton()==couleur){
                        if ((grille[i][j].lireCouleurDuJeton()==grille[i][j+1].lireCouleurDuJeton()) 
                                && grille[i][j+1].lireCouleurDuJeton()==grille[i][j+2].lireCouleurDuJeton() 
                                && grille[i][j+2].lireCouleurDuJeton()==grille[i][j+3].lireCouleurDuJeton()){
                            rep_c=true;
                        }   
                    }
                }
            }return rep_c;        
    }

    /** colonneGagnantepourCouleur 
     * @param couleur
     * regarde si la colonne est gagnante 
     * @return vrai ou faux
     */
    public boolean colonneGagnantePourCouleur(String couleur){
        boolean rep_l=false;
        for (int i=0; i<3;i++){
                for (int j=0; j<7;j++){
                    if (grille[i][j].lireCouleurDuJeton()==couleur){
                        if ((grille[i][j].lireCouleurDuJeton()==grille[i+1][j].lireCouleurDuJeton()) 
                                && grille[i+1][j].lireCouleurDuJeton()==grille[i+2][j].lireCouleurDuJeton() 
                                && grille[i+2][j].lireCouleurDuJeton()==grille[i+3][j].lireCouleurDuJeton()){
                        rep_l= true;
                        }
                    }              
                }
            }return rep_l;
    }

    /** diagonaleMontanteGagnantepourCouleur 
     * @param couleur
     * regarde si la diago montante est gagnante 
     * @return vrai ou faux
     */
    public boolean diagonaleMontanteGagnantePourCouleur(String couleur){
        boolean rep_dm=false;
        for (int i=0; i<3; i++){
            for (int j=0; j<4; j++){
                if (grille[i][j].lireCouleurDuJeton()==couleur){
                    if ((grille[i][j].lireCouleurDuJeton()==grille[i+1][j+1].lireCouleurDuJeton()) 
                            && grille[i][j].lireCouleurDuJeton()==grille[i+2][j+2].lireCouleurDuJeton() 
                            && grille[i][j].lireCouleurDuJeton()==grille[i+3][j+3].lireCouleurDuJeton()){
                        rep_dm= true;
                    }
                }
            
            }
        }return rep_dm;
    }
    
    /** diagonaleDescendanteGagnantepourCouleur 
     * @param couleur
     * regarde si la diagonale descendante est gagnante 
     * @return vrai ou faux
     */
    public boolean diagonaleDescendanteGagnantePourCouleur(String couleur){
        boolean rep_dd=false;
        for (int i=3; i<6; i++){
            for (int j=0; j<4; j++){
                if (grille[i][j].lireCouleurDuJeton()==couleur){
                    if ((grille[i][j].lireCouleurDuJeton()==grille[i-1][j+1].lireCouleurDuJeton()) 
                            && grille[i][j].lireCouleurDuJeton()==grille[i-2][j+2].lireCouleurDuJeton() 
                            && grille[i][j].lireCouleurDuJeton()==grille[i-3][j+3].lireCouleurDuJeton()){
                        rep_dd= true;
                    }
                }
            
            }
        }return rep_dd;
    }

    /** tasserColonne 
     * place les jetons dans la ligne la plus basse possible 
     * @param ind_c 
     */
    //public void tasserColonne(int ind_c){
        //for (int i=0; i<5; i++){
            //if (grille[i][ind_c].presenceJeton()==false){
                //grille[i][ind_c]=grille[i+1][ind_c];
                //grille[i+1][ind_c].affecterJeton(null);  
            //}
        //}
    //}
    
    
    
    /** presenceTrouNoir
     * regarde si un trou noir est present sur la case [x][y]
     * @param x
     * @param y
     * @return vrai ou faux
     */
    public boolean presenceTrouNoir(int x, int y){
        if (grille[x][y].presenceTrouNoir()==true){
            return true;
        }else {
            return false;
        }
    }
    /** placerTrouNoir
     * place un trou noir en x,y 
     * @param x
     * @param y 
     */
    public void placerTrouNoir(int x, int y){
        grille[x][y].placerTrouNoir();
    }
    /** supprimerTrouNoir
     * supprime le trou noir en x,y
     * @param x
     * @param y 
     */
    public void supprimerTrouNoir(int x, int y){
        grille[x][y].supprimerTrouNoir();
    }

    /**presenceDesintegrateur
     * regarde s'il y a un desintégrateur en x,y 
     * @param x
     * @param y
     * @return vrai ou faux
     */
    public boolean presenceDesintegrateur(int x, int y){
        if (grille[x][y].presenceDesintegrateur()==true){
            return true;
        }else {
            return false;
        }
    }
    /** placerDesintegrateur
     * place un desintegrateur en x,y 
     * @param x
     * @param y 
     */
    public void placerDesintegrateur(int x, int y){
        grille[x][y].placerDesintegrateur();
    }
    /** supprimerDesintegrateur
     * supprime desintegrateur en x,y
     * @param x
     * @param y 
     */
    public void supprimerDesintegrateur(int x, int y){
        grille[x][y].supprimerDesintegrateur();
    }
    /** supprimerJeton 
     * supprime le jeton en x,y 
     * @param x
     * @param y 
     */
    public void supprimerJeton(int x , int y){
        grille[x][y].supprimerJeton();
    }
    
    /** recupererJeton 
     * recupere le jeton en x,y 
     * @param x
     * @param y
     * @return le référence du jeton retourné 
     */
    public jeton recupererJeton(int x, int y){
        return grille[x][y].recupererJeton();
    }
    
    
}  
