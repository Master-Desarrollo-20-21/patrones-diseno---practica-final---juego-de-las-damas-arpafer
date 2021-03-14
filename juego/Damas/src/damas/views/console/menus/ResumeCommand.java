package damas.views.console.menus;

import damas.controllers.ResumeController;
import damas.views.Message;
import damas.views.console.ResumeView;
import damas.views.menus.Command;

public class ResumeCommand extends Command {

    public ResumeCommand(ResumeController resumeController) {
        super(Message.RESUME_COMMAND.toString(), resumeController);
    }

    @Override
    protected void execute() {
        new ResumeView().interact((ResumeController)this.acceptorController);
    }

    @Override
    protected boolean isActive() {
        return true;
    }
    
}
