package damas.controllers.implementation;

import damas.controllers.SaveController;
import damas.models.DAO.SessionImplementationDAO;
import damas.models.Session;
import damas.models.SessionImplementation;

public class SaveControllerImplementation extends SaveController {

    private SessionImplementationDAO sessionImplementationDAO;
    private SessionImplementation sessionImplementation;

    public SaveControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDAO;
        this.sessionImplementation = ((SessionImplementation) this.session);
    }

    @Override
    public void save(String name) {
        this.sessionImplementationDAO.save(name);
    }

    @Override
    public void save() {
        this.sessionImplementationDAO.save();
    }

    @Override
    public void next() {
        this.sessionImplementation.next();
    }

    @Override
    public boolean hasName() {
        return this.sessionImplementation.hasName();
    }

    @Override
    public boolean exists(String name) {
        return this.sessionImplementationDAO.exists(name);
    }
}
