package damas.views.console.menus;

import damas.controllers.PlayController;
import damas.views.Message;
import damas.views.console.ActionsView;
import damas.views.console.BoardView;
import damas.views.menus.Command;

public class RedoCommand extends Command {
       
    private PlayController playController;
    
    public RedoCommand(PlayController playController) {
        super(Message.REDO_COMMAND.toString(), playController);
        this.playController = (PlayController)this.acceptorController;
    }

    @Override
    protected void execute() {        
        this.playController.redo();    
        new BoardView().interact(playController);
        new ActionsView().interact(playController);
    }

    @Override
    protected boolean isActive() {
        return this.playController.isRedoable();
    }
    
}
