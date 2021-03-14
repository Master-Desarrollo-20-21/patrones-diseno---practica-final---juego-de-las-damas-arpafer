package damas.controllers.implementation;

import damas.controllers.LoadController;
import damas.models.DAO.SessionImplementationDAO;
import damas.models.Session;
import damas.models.SessionImplementation;

public class LoadControllerImplementation extends LoadController {

    private SessionImplementationDAO sessionImplementationDAO;
    private SessionImplementation sessionImplementation;
    
    public LoadControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDAO;
        this.sessionImplementation = ((SessionImplementation) this.session);                
    }
    
    @Override
    public void load(String name) {             
        this.sessionImplementationDAO.load(name);        
    }
    
    @Override
    public String[] getFilesNames() {        
        return this.sessionImplementationDAO.getGamesNames();
    }
}
