/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp.puissance4;

/**
 *
 * @author 33769
 */
public class TPPuissance4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        jeton J1 = new jeton ("rouge");
        System.out.println(J1);
        
        CelluleDeGrille cel = new CelluleDeGrille();
        System.out.println(cel);
        
        PlateauDeJeu P1 = new PlateauDeJeu();
        System.out.println(P1);
        
        
    }
}
