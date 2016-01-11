public class ControlGroup
{

    private Model model;
    private Vue vue;
    public ControlMenu controlMenu;
    public ControlInput controlInput;


    public ControlGroup(Model model)
    {
        this.model = model;
        vue = new Vue(model);
        controlMenu = new ControlMenu(model,vue);
        controlInput = new ControlInput(model,vue);
    }
}
