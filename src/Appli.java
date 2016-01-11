import javax.swing.*;
/**
 * Created by cladlink on 29/12/15.
 */
// a comprendre
public class Appli
{
    public static void main (String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                Model model = new Model();
                ControlGroup controler = new ControlGroup(model);
            }
        });
    }
}
