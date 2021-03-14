package damas.controllers;

import damas.models.Session;

public abstract class SaveController extends AcceptorController {

    public SaveController(Session session) {
        super(session);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public abstract void save(String name);

    public abstract void save();

    public abstract void next();

    public abstract boolean hasName();

    public abstract boolean exists(String readString);
}
