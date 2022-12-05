/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.puissance4;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import tp.puissance4.CelluleDeGrille;

/**
 *
 * @author Elisa
 */
public class cellule_graph extends JButton {

    CelluleDeGrille celluleAssocie;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_JJ = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_JR = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_TN = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));

    public cellule_graph(CelluleDeGrille uneCellule) {
        celluleAssocie = uneCellule;
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (celluleAssocie.presenceTrouNoir() == true) {
            setIcon(img_TN);
        } else if (celluleAssocie.presenceDesintegrateur() == true) {
            setIcon(img_desint);
        } else {
            String couleur_jeton = celluleAssocie.lireCouleurDuJeton();
            switch (couleur_jeton) {
                case "jaune":
                    setIcon(img_JJ);
                    break;
                case "rouge":
                    setIcon(img_JR);
                case "vide":
                    setIcon(img_vide);
                    break;

            }
        }

    }
}
