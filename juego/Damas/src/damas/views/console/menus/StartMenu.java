package damas.views.console.menus;

import damas.controllers.StartController;
import utils.Menu;


public class StartMenu extends Menu {
    
    public StartMenu(StartController startController) {
       this.addCommand(new LoadCommand(startController));
       this.addCommand(new PlayCommand(startController));       
       this.addCommand(new ExitCommand(startController));              
    }
}
