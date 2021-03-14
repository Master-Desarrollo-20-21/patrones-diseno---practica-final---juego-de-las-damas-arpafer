package damas.views.console;

import damas.controllers.AcceptorController;
import damas.controllers.LoadController;
import damas.views.Message;
import damas.views.View;
import utils.Console;

public class LoadView extends View {
   
    @Override
    public void interact(AcceptorController controller) {
        Console.getInstance().writeln();
        LoadController loadController = (LoadController) controller;
        String[] files = loadController.getFilesNames();
        for (int i = 0; i < files.length; i++) {
            Console.getInstance().writeln((i + 1) + ")" + files[i]);
        }        
        String fileName = Console.getInstance().readString(Message.SELECT_FILE.toString());
        loadController.load(files[Integer.parseInt(fileName) - 1]);
    }
    
}
