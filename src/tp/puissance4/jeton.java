package tp.puissance4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Elisa
 */
public class jeton {
    String couleur ;
    
    public jeton(String couleur) {
        this.couleur = couleur;
    }
    
    public String lireCouleur(){ //lit la couleur
        return couleur ; 
    }

    @Override
    public String toString() { //renvoie la bonne couleur avec differente nomenclature saisie
       if (couleur=="jaune" || couleur =="Jaune" || couleur == "JAUNE"){
        return  " J " ;
    }else if (couleur=="rouge" || couleur == "Rouge" || couleur == "ROUGE") {
        return "R";
    }else {
        return "que deux valeurs possibles : rouge ou jaune";
        }
    }
}



