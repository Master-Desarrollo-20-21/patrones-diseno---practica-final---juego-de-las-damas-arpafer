package damas.controllers;

import damas.models.Session;

public abstract class LoadController extends AcceptorController {

    public LoadController(Session session) {
        super(session);
    }
            
    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
    
    public abstract void load(String name);

    public abstract String[] getFilesNames(); 
}
