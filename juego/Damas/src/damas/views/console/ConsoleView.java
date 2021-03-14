package damas.views.console;

import damas.controllers.AcceptorController;
import damas.controllers.ControllerVisitor;
import damas.controllers.LoadController;
import damas.controllers.PlayController;
import damas.controllers.ResumeController;
import damas.controllers.SaveController;
import damas.controllers.StartController;
import damas.views.View;

public class ConsoleView extends View implements ControllerVisitor {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;
    private SaveView saveView;
    private LoadView loadView;
    
    public ConsoleView() {
       this.startView = new StartView();  
       this.playView = new PlayView();
       this.resumeView = new ResumeView();
       this.saveView = new SaveView();
       this.loadView = new LoadView();
    }
    
    @Override
    public void visit(StartController controller) {
        this.startView.interact(controller);
    }

    @Override
    public void visit(PlayController controller) {
        this.playView.interact(controller);
    }

    @Override
    public void visit(ResumeController controller) {
        this.resumeView.interact(controller);
    }
    
    @Override
    public void visit(SaveController controller) {
        this.saveView.interact(controller);
    }
    
    @Override
    public void visit(LoadController controller) {
        this.loadView.interact(controller);
    }
    
    @Override
    public void interact(AcceptorController controller) {
        controller.accept(this);
    }
    
}
