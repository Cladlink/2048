import javax.swing.*;
import java.awt.event.*;

public class ControlMenu extends Control implements ActionListener
{
    public ControlMenu(Model model, Vue vue)
    {
        super(model, vue);
        vue.setMenuControler(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        // Nouvelle partie
        if (e.getSource()==vue.getFichierNewGame())
        {
            vue.dispose();
            vue.getInitPlateau();
            vue.repaint();
            vue.getCreerWidget();
            vue.setVisible(true);
        }
        // Quitter
        else if (e.getSource()==vue.getFichierQuitter())
        {
            vue.dispose();
        }
        // A propos
        else if (e.getSource()==vue.getAbout())
        {
            JOptionPane.showMessageDialog(vue, "Ce programme a été développé par Michael BOUTBOUL");
        }
    }
}
