package damas.views.console;

import utils.Console;

public class RespondYesNoView {
    
    private boolean respondYes;
    
    public RespondYesNoView() {
        this.respondYes = false;
    }
    public boolean isAffirmative() {
        return this.respondYes;
    }
    public void interact(String message) {        
        String respond = Console.getInstance().readString(message);
        this.respondYes = respond.equals("Y") || respond.equals("y") || respond.equals("Yes") || respond.equals("yes");            
    }
}
