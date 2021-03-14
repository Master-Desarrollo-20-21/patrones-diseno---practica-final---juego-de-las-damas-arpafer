package damas.controllers;

import damas.models.Session;

public abstract class StartController extends AcceptorController {
    
    public StartController(Session session) {
        super(session);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public abstract void load(); 
    
    public abstract void play();

    public abstract boolean hasGamesNames(); 
       
}
