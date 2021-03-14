package damas.controllers;

import damas.models.Session;
import damas.models.StateValue;
import java.util.Map;
import java.util.HashMap;

public class Logic {

    protected Session session;    
    public Map<StateValue, AcceptorController> acceptorControllers;
    
    public Logic() {        
        this.acceptorControllers = new HashMap<StateValue, AcceptorController>();         
    }
    
    public AcceptorController getController() {
        return this.acceptorControllers.get(this.session.getValueState());
    }
    
}
