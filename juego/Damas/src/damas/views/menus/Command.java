package damas.views.menus;

import damas.controllers.AcceptorController;

public abstract class Command extends utils.Command {
    
   protected AcceptorController acceptorController;

   public Command(String title, AcceptorController acceptorController) {
       super(title);
       this.acceptorController = acceptorController;
   }   
}
