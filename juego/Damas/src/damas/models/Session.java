package damas.models;

public interface Session {
   
    public StateValue getValueState(); 
    public void next();
    public void setState(StateValue stateValue);
}
