package damas;

import damas.controllers.Logic;
import damas.controllers.implementation.LogicImplementation;
import damas.models.DAO.SessionImplementationDAO;
import damas.views.View;
import damas.views.console.ConsoleView;

public class ConsoleDamas extends Damas {

    public ConsoleDamas() {
        super();
    }
    
    @Override
    protected View createView() {
        return new ConsoleView();
    }
    
     @Override
    protected Logic createLogic() {
        return new LogicImplementation(new SessionImplementationDAO());           
    }
    
    public static void main(String[] args) {
        
        new ConsoleDamas().play();
    }
   
}
