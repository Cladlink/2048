import javax.swing.*;
import java.awt.event.*;

public class ControlInput extends Control implements KeyListener
{
    JLabel[][] plateau = vue.getPlateau();
    ImageIcon[] cartes = vue.getCartes();
    public ControlInput(Model model, Vue vue)
    {
        super(model, vue);
        vue.setInputControler(this);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

        // bouton haut
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            model.moveUp(plateau, cartes);
            endTurn();
        }

        // bouton droite
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            model.moveRight(plateau, cartes);
            endTurn();
        }

        // bouton bas
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            model.moveDown(plateau, cartes);
            endTurn();

        }

        // bouton gauche
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            model.moveLeft(plateau, cartes);
            endTurn();
        }

    }
    void endTurn()
    {
        // on compte le nombre de cases vide afin de savoir si on continue la partie ou non.
        int vide = model.nbVide(plateau, cartes);
        boolean victoire;
        victoire = model.testVictoire(plateau, cartes);

        int i, j, noPossibility=0;
        for (i=0; i<plateau.length-1;i++)
        {
            for (j=0; j<plateau[i].length-1;j++)
            {
                if (plateau[i][j].getIcon()==plateau[i][j+1].getIcon()
                        || plateau[i][j].getIcon()==plateau[i+1][j].getIcon()
                        || plateau[i+1][j].getIcon()==plateau[i+1][j+1].getIcon())
                {
                    noPossibility++;
                    System.out.println(noPossibility);
                }
            }
        }
        // Victoire ?
        if (victoire)
        {
            JOptionPane.showMessageDialog(vue, "Bravo vous avez gagné !");
            vue.dispose();
            vue.getInitPlateau();
            vue.repaint();
            vue.getCreerWidget();
            vue.setVisible(true);
        }
        // GameOver
        else if (vide==0 && noPossibility==0)
        {

            JOptionPane.showMessageDialog(vue, "GameOver");
            vue.dispose();
            vue.getInitPlateau();
            vue.repaint();
            vue.getCreerWidget();
            vue.setVisible(true);
        }

        //placement d'une carte au hazard
        else if (vide>0)
        {
            model.newCard(vide, plateau, cartes);
        }

        //rafraichissement du tableau
        vue.setPlateau(plateau);
        vue.repaint();
        vue.getCreerWidget();
        vue.setVisible(true);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}