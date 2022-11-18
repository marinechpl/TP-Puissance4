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
    private String couleur ;
   
    public String jeton(String couleur) { //vérifie que la couleur du jeton reste bien jaune ou rouge
        this.couleur = couleur; 
        if (couleur!="rouge" && couleur!="jaune"){
            return "Que deux couleurs possible (rouge et jaune)"; 
        }else{
            return couleur;
        }
    }
    
    public String lireCouleur(){ //lit la couleur
        return couleur ; 
    }

    @Override
    public String toString() { //renvoie la bonne couleur
       if (couleur=="jaune"){
        return  " J " ;
    }else {
        return "R";
    }    
    }
}


