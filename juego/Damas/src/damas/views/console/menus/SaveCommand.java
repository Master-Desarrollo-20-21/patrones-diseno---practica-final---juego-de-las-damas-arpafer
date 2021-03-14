package damas.views.console.menus;

import damas.controllers.SaveController;
import damas.views.Message;
import damas.views.console.SaveView;
import damas.views.menus.Command;

public class SaveCommand extends Command {

    private SaveController saveController;
    
    public SaveCommand(SaveController saveController) {        
        super(Message.SAVE_COMMAND.toString(), saveController);
        this.saveController = (SaveController)this.acceptorController;
    }

    @Override
    protected void execute() {
        new SaveView().interact(this.saveController);
        this.saveController.next();
    }

    @Override
    protected boolean isActive() {
        return true;
    }
    
}
