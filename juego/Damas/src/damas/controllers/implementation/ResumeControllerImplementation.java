package damas.controllers.implementation;

import damas.controllers.ResumeController;
import damas.models.DAO.SessionImplementationDAO;
import damas.models.Session;
import damas.models.SessionImplementation;

public class ResumeControllerImplementation extends ResumeController {

    private SessionImplementationDAO sessionImplementationDAO;
    private SessionImplementation sessionImplementation;
    
    public ResumeControllerImplementation(Session session) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDAO;
        this.sessionImplementation = ((SessionImplementation) this.session);
    }
    
    @Override
    public void resume(boolean isResumed) {
        if (isResumed) {                        
            this.init();
        } else {
            this.next();
        }
    }        
}
