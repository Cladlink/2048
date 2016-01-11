import javax.swing.*;
import java.util.Random;

public class Model
{
    static Random rand = new Random();
    void moveUp(JLabel[][] plateau, ImageIcon[] cartes)
    {
        int i, j, h, k;

        for (i=0;i<plateau.length;i++)
        {
            for (k = 3; k > 0; k--)
            {
                for (j = 0; j < k; j++)
                {
                    // juste que là ok !
                    // i  i  i  i
                    // si la case -1 est pleine et égale à elle même
                    if (plateau[i][j].getIcon() == plateau[i][j + 1].getIcon()
                        && plateau[i][j].getIcon() != cartes[0])
                    {
                        // recherche de la carte correspondante
                        for (h = 0; h < cartes.length; h++)
                        {
                            if (plateau[i][j].getIcon() == cartes[h])
                            {
                                break;
                            }
                        }
                        plateau[i][j + 1] = new JLabel(cartes[0]);
                        plateau[i][j] = new JLabel(cartes[h + 1]);
                    }
                    // si la case -1 est vide
                    else if (plateau[i][j].getIcon() == cartes[0])
                    {
                        plateau[i][j] = plateau[i][j + 1];
                        plateau[i][j + 1] = new JLabel(cartes[0]);
                    }
                }
            }
        }
    }
    void moveLeft(JLabel[][] plateau, ImageIcon[] cartes)
    {
        int i, j, h, k;

        for (j=0;j<plateau.length;j++)
        {
            for (k = 3; k > 0; k--)
            {
                for (i=0; i<k; i++)
                {
                    // juste que là ok !
                    // i  i  i  i
                    // si la case -1 est pleine et égale à elle même
                    if (plateau[i][j].getIcon() == plateau[i+1][j].getIcon()
                            && plateau[i][j].getIcon() != cartes[0])
                    {
                        // recherche de la carte correspondante
                        for (h = 0; h < cartes.length; h++)
                        {
                            if (plateau[i][j].getIcon() == cartes[h])
                            {
                                break;
                            }
                        }
                        plateau[i + 1][j] = new JLabel(cartes[0]);
                        plateau[i][j] = new JLabel(cartes[h + 1]);
                    }
                    // si la case -1 est vide
                    else if (plateau[i][j].getIcon() == cartes[0])
                    {
                        plateau[i][j] = plateau[i+1][j];
                        plateau[i+1][j] = new JLabel(cartes[0]);
                    }
                }
            }
        }
    }
    void moveDown(JLabel[][] plateau, ImageIcon[] cartes)
    {
        int i, j, h, k;

        for (i=0; i<plateau.length; i++)
        {
            for (k = 0; k < 3; k++)
            {
                for (j=3; j>k; j--)
                {
                    // i  i  i  i
                    // si la case -1 est pleine et égale à elle même
                    if (plateau[i][j].getIcon() == plateau[i][j-1].getIcon()
                        && plateau[i][j].getIcon() != cartes[0])
                    {
                        // recherche de la carte correspondante
                        for (h = 0; h < cartes.length; h++)
                        {
                            if (plateau[i][j].getIcon() == cartes[h])
                            {
                                break;
                            }
                        }
                        plateau[i][j-1] = new JLabel(cartes[0]);
                        plateau[i][j] = new JLabel(cartes[h+1]);
                    }
                    // si la case -1 est vide
                    else if (plateau[i][j].getIcon() == cartes[0])
                    {
                        plateau[i][j] = plateau[i][j-1];
                        plateau[i][j-1] = new JLabel(cartes[0]);
                    }

                }
            }
        }
    }
    void moveRight(JLabel[][] plateau, ImageIcon[] cartes)
    {
        int i, j, h, k;

        for (j=0; j<plateau.length; j++)
        {
            for (k=0; k<3; k++)
            {
                for (i=3; i>k; i--)
                {
                    // i  i  i  i
                    // si la case -1 est pleine et égale à elle même
                    if (plateau[i][j].getIcon() == plateau[i-1][j].getIcon()
                            && plateau[i][j].getIcon() != cartes[0])
                    {
                        // recherche de la carte correspondante
                        for (h = 0; h < cartes.length; h++)
                        {
                            if (plateau[i][j].getIcon() == cartes[h])
                            {
                                break;
                            }
                        }
                        plateau[i-1][j] = new JLabel(cartes[0]);
                        plateau[i][j] = new JLabel(cartes[h+1]);
                    }
                    // si la case -1 est vide
                    else if (plateau[i][j].getIcon() == cartes[0])
                    {
                        plateau[i][j] = plateau[i-1][j];
                        plateau[i-1][j] = new JLabel(cartes[0]);
                    }

                }
            }
        }
    }

    int nbVide(JLabel[][] plateau, ImageIcon[] cartes)
    {
        int i, j, compteurDeVide=0;
        for (i=0;i<plateau.length;i++)
        {
            for (j=0;j<plateau[i].length;j++)
            {
                if (plateau[i][j].getIcon()==cartes[0])
                {
                    compteurDeVide ++;
                }
            }
        }
        return compteurDeVide;
    }
    void newCard(int cartesVide, JLabel[][] plateau, ImageIcon[] cartes)
    {
        int carteVideRand = rand.nextInt(cartesVide);
        if (carteVideRand == 0) carteVideRand = 1;
        System.out.println("vide hazard : " + carteVideRand + " nombres de vide : " + cartesVide);
        int i, j, compteurDeVide=0;
        for (i=0;i<plateau.length;i++)
        {
            for (j=0;j<plateau[i].length;j++)
            {
                if (plateau[i][j].getIcon()==cartes[0])
                {
                    compteurDeVide++;
                }
                if (compteurDeVide==carteVideRand)
                {
                    plateau[i][j]= new JLabel(cartes[1]);
                    System.out.print("test ?");
                    compteurDeVide++;
                }
            }
        }
    }
    boolean testVictoire(JLabel[][] plateau, ImageIcon[] cartes)
    {
        int i, j;
        for(i=0;i<plateau.length;i++)
        {
            for(j=0;j<plateau[i].length;j++)
            {
                if (plateau[i][j].getIcon()==cartes[11])
                {
                    return true;
                }
            }
        }
        return false;
    }
}
