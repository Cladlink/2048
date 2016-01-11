import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Random;

public class Vue extends JFrame
{

    private static Random rand = new Random();

    // déclaration menu
    private JMenuBar menu;
    private JMenu fichier;
    private JMenuItem fichierNewGame;
    private JMenuItem fichierQuitter;
    private JMenuItem about;

    // déclaration cartes
    private ImageIcon[] cartes =
        {
            new ImageIcon(getClass().getResource("img/Empty.jpg")),
            new ImageIcon(getClass().getResource("img/Deux.jpg")),
            new ImageIcon(getClass().getResource("img/Quatre.jpg")),
            new ImageIcon(getClass().getResource("img/Huit.jpg")),
            new ImageIcon(getClass().getResource("img/Seize.jpg")),
            new ImageIcon(getClass().getResource("img/TrenteDeux.jpg")),
            new ImageIcon(getClass().getResource("img/SoixanteQuatre.jpg")),
            new ImageIcon(getClass().getResource("img/CentVingtHuit.jpg")),
            new ImageIcon(getClass().getResource("img/DeuxCentCinquanteSix.jpg")),
            new ImageIcon(getClass().getResource("img/CinqCentDouze.jpg")),
            new ImageIcon(getClass().getResource("img/MilleVingtQuatre.jpg")),
            new ImageIcon(getClass().getResource("img/DeuxMilleQuaranteHuit.jpg")),
        };
    public ImageIcon[] getCartes() { return cartes; }


    // déclaration plateau
    JLabel[][] plateau;

    public JLabel[][] getPlateau() { return plateau; }
    public void setPlateau(JLabel[][] plateau) { this.plateau = plateau; }

    // déclaration JPanel
    private JPanel pano;

    public Vue(Model model)
    {
        initAttribut();
        initPlateau();
        creerWidget();

        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    public JMenuItem getFichierNewGame() { return fichierNewGame; }
    public JMenuItem getFichierQuitter() { return fichierQuitter; }
    public JMenuItem getAbout() { return about; }

    /*
     * Initialise les éléments de la JFrame
     */
    private void initAttribut()
    {
        // initialisation menu
        menu = new JMenuBar();

        fichier = new JMenu("fichier");
        fichierNewGame = new JMenuItem("Nouvelle partie");
        fichier.add(fichierNewGame);
        fichierQuitter = new JMenuItem("Quitter");
        fichier.add(fichierQuitter);
        menu.add(fichier);

        about = new JMenuItem("?");
        menu.add(about);
        setJMenuBar(menu);

        // initialisation plateau
        plateau = new JLabel[4][4];
    }

    /*
         * Initialise le plateau avec deux "2" aléatoire
         */
    private void initPlateau()
    {
        int i, j;
        int initDeux = rand.nextInt(14) + 2;
        // randMemoire : petite astuce pour avoir un deuxieme nombre strictement
        // inférieur au premier afin de ne pas avoir deux fois le même nombre.
        int randMemoire = initDeux - 1;
        for (i = 0; i < plateau.length; i++)
        {
            for (j = 0; j < plateau[i].length; j++)
            {
                plateau[i][j] = new JLabel(cartes[0]);
            }
        }
        plateau[initDeux / plateau[0].length][initDeux % plateau[0].length] = new JLabel(cartes[1]);
        initDeux = rand.nextInt(randMemoire);
        plateau[initDeux / plateau[0].length][initDeux % plateau[0].length] = new JLabel(cartes[1]);
    }
    public void getInitPlateau(){ initPlateau(); }

    /*
     * place les éléments dans la fenêtre
     */
    private void creerWidget()
    {
        pano = new JPanel(new GridLayout(4, 4));
        int i, j;
        for (i = 0; i < plateau.length; i++)
        {
            for (j = 0; j < plateau[i].length; j++)
            {
                pano.add(plateau[j][i]);
            }
        }
        setContentPane(pano);
    }
    public void getCreerWidget() { creerWidget(); }

    public void setMenuControler(ActionListener listener)
    {
        fichierNewGame.addActionListener(listener);
        fichierQuitter.addActionListener(listener);
        about.addActionListener(listener);
    }
    public void setInputControler(KeyListener keyp)
    {
        addKeyListener(keyp);
    }
}