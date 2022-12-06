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
    private boolean avoirTrouNoir;
    private boolean avoirDesintegrateur;

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
     * @param jeton
     * @return la nouvelle valeur du jeton
     */
    public jeton affecterJeton(jeton jeton){
       this.jetonCourant = jeton;
       return jeton;
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
    
    /**placerTrouNoir 
     * place un trou noir en changeant la valeur en vrai 
     * @return la nouvelle valeur  
     */
    public boolean placerTrouNoir(){
        avoirTrouNoir=true;
        return avoirTrouNoir;
    }
    
    /**supprimerTrouNoir 
     * enlève un trou noir en changeant la valeur en false 
     * @return la nouvelle valeur  
     */
    public boolean supprimerTrouNoir(){
        avoirTrouNoir=false;
        return avoirTrouNoir;
    }
    
    /**presenceTrouNoir 
     * regarde si il y a présence d'un trou noir 
     * @return vrai ou faux 
     */
    public boolean presenceTrouNoir(){
        if (avoirTrouNoir==true) {
            return true;
        }else {
            return false;
        }
    }
    
    /**supprimerJeton
     * passe la valeur du jeton a null 
     * @return nvl valeur  
     */
    public jeton supprimerJeton(){
       jetonCourant=null;
       return jetonCourant;
    }
    
    /**presenceDesintegrateur
     * regarde si il y a présence d'un desintegrateur 
     * @return vrai ou faux 
     */
    public boolean presenceDesintegrateur(){
        if (avoirDesintegrateur==true) {
            return true;
        }else {
            return false;
        }
    }
    
    /**placerDesinterateur
     * change la valeur avoirDesintegrateur en vrai
     * @return la nvl valeur 
     */
    public boolean placerDesintegrateur(){
        avoirDesintegrateur=true;
        return avoirDesintegrateur;
    }
    
    /**supprimerDesintegrateur 
     * change la valeur de avoirDesintegrateur en fauix
     * @return la nvl valeur
     */
    public boolean supprimerDesintegrateur(){
        avoirDesintegrateur=false;
        return avoirDesintegrateur;
    }
    
    /**activerTrouNoir 
     * supprime jeton et le Trou Noir
     */
    public void activerTrouNoir(){
        jetonCourant=null;
        avoirTrouNoir=false;
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
        
      if (this.presenceJeton()==true){
          if (this.jetonCourant.lireCouleur()=="rouge") {
            return " R ";            
        }else{
            return " J ";
        }
        }
        else if (this.presenceTrouNoir()==true && this.presenceDesintegrateur()==true){
            return " J ";
        }
        else if (this.presenceTrouNoir()==true){
            return " T ";
            
        }
        else if (this.presenceDesintegrateur()==true){
            return " D ";
        }else {
            return " . ";
        }
        
      }
    

}

      

       
   


    
