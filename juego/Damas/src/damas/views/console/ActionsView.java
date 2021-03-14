package damas.views.console;

import damas.views.console.menus.PlayMenu;
import damas.controllers.PlayController;
import utils.Console;

public class ActionsView {
                
    public ActionsView() {
    
    }

    public void interact(PlayController playController) {
                
        Console.getInstance().writeln();                
        new PlayMenu(playController).execute();     
    }
    
}
