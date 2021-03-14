package damas.views.console;

import damas.controllers.AcceptorController;
import damas.controllers.StartController;
import damas.views.View;
import damas.views.console.menus.StartMenu;
import utils.Console;

public class StartView extends View {

    @Override
    public void interact(AcceptorController controller) {
        Console.getInstance().writeln();
        Console.getInstance().writeln("D A M A S");
        Console.getInstance().writeln();
        new StartMenu((StartController)controller).execute();      
    }        
}
