package damas.views.console.menus;

import damas.controllers.StartController;
import damas.views.Message;
import damas.views.menus.Command;

public class LoadCommand extends Command {

    private StartController startController;
    
    public LoadCommand(StartController startController) {
        super(Message.LOAD_COMMAND.toString(), startController);
        this.startController = startController;
    }

    @Override
    protected void execute() {
        this.startController.load();
    }

    @Override
    protected boolean isActive() {
        return this.startController.hasGamesNames();
    }
    
}
