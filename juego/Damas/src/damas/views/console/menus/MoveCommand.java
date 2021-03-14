package damas.views.console.menus;

import damas.controllers.PlayController;
import damas.views.Message;
import damas.views.console.MovementView;
import damas.views.menus.Command;

public class MoveCommand extends Command {

    public MoveCommand(PlayController playController) {
        super(Message.MOVE_COMMAND.toString(), playController);
    }

    @Override
    protected void execute() {
        new MovementView().interact((PlayController)this.acceptorController);
    }

    @Override
    protected boolean isActive() {
        return true;
    }
    
}
