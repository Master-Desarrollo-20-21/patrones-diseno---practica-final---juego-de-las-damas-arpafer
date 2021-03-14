package damas.controllers.implementation;

import damas.controllers.Logic;
import damas.models.DAO.SessionImplementationDAO;
import damas.models.SessionImplementation;
import damas.models.StateValue;

public class LogicImplementation extends Logic {

    protected SessionImplementationDAO sessionImplementationDAO;

    protected StartControllerImplementation startControllerImplementation;

    protected LoadControllerImplementation loadControllerImplementation;
    
    protected PlayControllerImplementation playControllerImplementation;

    protected SaveControllerImplementation saveControllerImplementation;

    protected ResumeControllerImplementation resumeControllerImplementation;

    public LogicImplementation(SessionImplementationDAO sessionImplementationDAO) {
        this.session = new SessionImplementation();
        this.sessionImplementationDAO = sessionImplementationDAO;
        this.sessionImplementationDAO.associate((SessionImplementation) this.session);
        this.startControllerImplementation = new StartControllerImplementation(this.session, this.sessionImplementationDAO);
        this.loadControllerImplementation = new LoadControllerImplementation(this.session, this.sessionImplementationDAO);
        this.playControllerImplementation = new PlayControllerImplementation(this.session);
        this.saveControllerImplementation = new SaveControllerImplementation(this.session, this.sessionImplementationDAO);
        this.resumeControllerImplementation = new ResumeControllerImplementation(this.session);
        this.acceptorControllers.put(StateValue.INITIAL, this.startControllerImplementation);
        this.acceptorControllers.put(StateValue.LOAD, this.loadControllerImplementation);
        this.acceptorControllers.put(StateValue.IN_GAME, this.playControllerImplementation);
        this.acceptorControllers.put(StateValue.SAVE, this.saveControllerImplementation);
        this.acceptorControllers.put(StateValue.RESUME, this.resumeControllerImplementation);
        this.acceptorControllers.put(StateValue.EXIT, null);
    }
}
