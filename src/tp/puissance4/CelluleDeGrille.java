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
    private jeton jetonCourant;  

   public CelluleDeGrille(jeton jetonCourant) {
        this.jetonCourant = jetonCourant;
        jetonCourant = null;
    }
   
   public boolean presenceJeton(){
       if (jetonCourant!=null){
           return true;
       }else{
           return false ;
       }
    }
   
   public jeton affecterJeton(jeton jet){
       jetonCourant = jet ;
       return jetonCourant;
   }
   
   public String lireCouleurDuJeton(){
   if (presenceJeton()==true){
       return jetonCourant.lireCouleur() ;
   }else{
       return "vide";
   } 
   }

    @Override
    public  String toString() {
      // return "CelluleDeGrille{" + "jetonCourant=" + jetonCourant + '}';
        
      System.out.println(lireCouleurDuJeton());
      if (presenceJeton()==false){
        System.out.println(".");
      }
         
          
      }  
    }

      

       
   


    
