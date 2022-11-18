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
   
    public jeton(String couleur) {
        this.couleur = couleur; 
    }
    
    public String lireCouleur(){
        return couleur ; 
    }

    @Override
    public String toString() {
       if (couleur=="jaune"){
        return  " J " ;
    }else if (couleur=="rouge"){
        return "R";
    }else {
        return "vous n'avez pas entré la bonne couleur";
    }    
    }
}


