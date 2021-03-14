package damas.views.console.menus;

import damas.controllers.StartController;
import damas.views.Message;
import damas.views.menus.Command;

public class ExitCommand extends Command {

    private StartController startController;
    
    public ExitCommand(StartController startController) {
        super(Message.EXIT_COMMAND.toString(), startController);
        this.startController = startController;
    }

    @Override
    protected void execute() {
       this.startController.exit();
    }

    @Override
    protected boolean isActive() {
        return true;
    }
    
}
