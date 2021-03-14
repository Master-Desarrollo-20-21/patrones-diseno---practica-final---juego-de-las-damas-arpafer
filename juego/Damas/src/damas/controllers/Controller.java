
package damas.controllers;

import damas.models.Session;
import damas.models.StateValue;


public abstract class Controller {
    
    protected Session session;    
    
    public Controller(Session session) {
        this.session = session;
    }
    
    public void next() {
        this.session.next();
    }
    
    protected void setState(StateValue value) {
       this.session.setState(value);
    }
           
    public void exit() {
        this.setState(StateValue.EXIT);
    }

    public void init() {
        this.setState(StateValue.INITIAL);
    }         
}
