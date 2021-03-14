package damas.views.console;

import damas.controllers.AcceptorController;
import damas.controllers.SaveController;
import damas.views.Message;
import damas.views.View;
import utils.Console;

public class SaveView extends View {
           
    @Override
    public void interact(AcceptorController controller) {
        SaveController saveController = (SaveController) controller;
        RespondYesNoView respond = new RespondYesNoView();
        respond.interact(Message.SAVE.toString());
        String name = null;
        if (respond.isAffirmative()) {
          if (saveController.hasName()) {
              saveController.save();
          } else {
              boolean exists = false;
              do {
                 name = Console.getInstance().readString(Message.NAME.toString());
                 exists = saveController.exists(name);
                 if (exists) {
                     Console.getInstance().writeln(Message.ALREADY_EXIST.toString());
                 }
              } while (exists);
              saveController.save(name);
          }
        }
        controller.next();
    }

}
