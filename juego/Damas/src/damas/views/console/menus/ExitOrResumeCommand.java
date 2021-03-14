package damas.views.console.menus;

import damas.controllers.PlayController;
import damas.views.Message;
import damas.views.menus.Command;

public class ExitOrResumeCommand extends Command {

    public ExitOrResumeCommand(PlayController playController) {
        super(Message.EXIT_OR_RESUME_COMMAND.toString(), playController);
    }

    @Override
    protected void execute() {
        ((PlayController)this.acceptorController).next();
    }

    @Override
    protected boolean isActive() {
        return true;
    }
    
}
