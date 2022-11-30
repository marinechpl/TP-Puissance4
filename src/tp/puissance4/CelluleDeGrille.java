/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.puissance4;

/**
 *
 * @author Elisa
 */
public class CelluleDeGrille {
    jeton jetonCourant;  

    /** CelluleDeGrille
     * Constructeur de la classe : initialise la cellule avec rien 
     */
    public CelluleDeGrille() {
        this.jetonCourant = null ;
    }
   
    /** presenceJeton
     * analyse si il y a un jeton ou pas dans la cellule 
     * @return true -> jeton ; false -> pas de jeton
     */
    public boolean presenceJeton(){
        if (jetonCourant!=null){
           return true;
        }else{
           return false ;
        }
    }
    
    /** affecterJeton
     * affecte à la cellule un jeton
     * @param jet
     * @return la nouvelle valeur du jeton
     */
    public jeton affecterJeton(jeton jet){
       jetonCourant = jet ;
       return jetonCourant;
    }
    
    /** lireCouleurDuJeton
     * si jeton est present 
     * @return renvoie vers la fonction qui lit la couleur 
     * sinon -> "vide"
     */
    public String lireCouleurDuJeton(){
        if (presenceJeton()==true){
            return jetonCourant.lireCouleur() ;
        }else{
            return "vide";
        } 
    }
    
    /** recupererJeton
     * on place le jeton dans une variable et on change sa valeur en null 
     * permet de recuperer le lien vers le jeton enlevé, qu'on pourra redonner plus tard
     * @return la valeur du jetoncourant placé dans la variable 
     */
    public jeton recupererJeton(){
        jeton jetrecup = jetonCourant;
        jetonCourant=null;
        return jetrecup;
    }

    @Override
    public String toString() {
      // return "CelluleDeGrille{" + "jetonCourant=" + jetonCourant + '}';
        
      if (this.presenceJeton()==false){
          return ".";
      }else{
        if  (this.lireCouleurDuJeton()=="rouge") {
            return "R";            
        }else{
            return "J";
        }
      }   
      }  
    

}

      

       
   


    
