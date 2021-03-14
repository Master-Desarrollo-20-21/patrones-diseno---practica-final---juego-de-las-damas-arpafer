package damas.controllers.implementation;

import damas.controllers.StartController;
import damas.models.DAO.SessionImplementationDAO;
import damas.models.Session;
import damas.models.SessionImplementation;
import damas.models.StateValue;

public class StartControllerImplementation extends StartController {

    private SessionImplementationDAO sessionImplementationDAO;
    private SessionImplementation sessionImplementation;
    
    StartControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDAO;
        this.sessionImplementation = ((SessionImplementation)this.session);
    }            
    
    @Override
    public void load() {               
        this.session.next();
    }
    
    public void play() {
        this.setState(StateValue.IN_GAME);
    }

    @Override
    public boolean hasGamesNames() {
        return this.sessionImplementationDAO.getGamesNames() != null && this.sessionImplementationDAO.getGamesNames().length > 0;
    }
}
