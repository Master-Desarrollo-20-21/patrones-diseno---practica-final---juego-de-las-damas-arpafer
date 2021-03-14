package damas.views.console.menus;

import damas.controllers.PlayController;
import damas.views.Message;
import damas.views.console.ActionsView;
import damas.views.console.BoardView;
import damas.views.menus.Command;

public class UndoCommand extends Command {

    private PlayController playController;
    
    public UndoCommand(PlayController playController) {
        super(Message.UNDO_COMMAND.toString(), playController);
        this.playController = (PlayController)this.acceptorController;
    }

    @Override
    protected void execute() {
        this.playController.undo();
        new BoardView().interact(this.playController);        
        new ActionsView().interact(this.playController);
    }

    @Override
    protected boolean isActive() {
        return this.playController.isUndoable();
    } 
}
