package damas.views.console.menus;

import utils.Menu;
import damas.controllers.PlayController;

public class PlayMenu extends Menu {
    
    public PlayMenu(PlayController playController) {
       this.addCommand(new MoveCommand(playController));
       this.addCommand(new UndoCommand(playController));
       this.addCommand(new RedoCommand(playController));              
       this.addCommand(new ExitOrResumeCommand(playController));       
    }
}
