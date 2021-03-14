package damas;

import damas.controllers.AcceptorController;
import damas.controllers.Logic;
import damas.views.View;

public abstract class Damas {
    
    private Logic logic;
    private View view;
        
    public Damas() {
        this.logic = this.createLogic();       
        this.view = this.createView();
    }
    protected abstract View createView();
    protected abstract Logic createLogic();
    
    public void play() {
        AcceptorController acceptorController;
        do {
            acceptorController = this.logic.getController();
            if (acceptorController != null) {
                this.view.interact(acceptorController);
            }
        } while (acceptorController != null);
    }
}
