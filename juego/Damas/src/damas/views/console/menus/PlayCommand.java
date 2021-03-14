package damas.views.console.menus;

import damas.controllers.StartController;
import damas.views.Message;
import damas.views.menus.Command;

public class PlayCommand extends Command {
    
    private StartController startController;
    
    public PlayCommand(StartController startController) {
        super(Message.PLAY_COMMAND.toString(), startController);
        this.startController = startController;
    }

    @Override
    protected void execute() {
        this.startController.play();
    }

    @Override
    protected boolean isActive() {
        return true;
    }
    
}
