package damas.controllers;

import damas.models.Session;

public abstract class ResumeController extends AcceptorController {
    
    public ResumeController(Session session) {
        super(session);
    }
             
    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
    
    public abstract void resume(boolean newGame);    
}
