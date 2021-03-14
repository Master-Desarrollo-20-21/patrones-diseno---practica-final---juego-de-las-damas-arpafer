package damas.views.console;

import damas.controllers.AcceptorController;
import damas.controllers.PlayController;
import damas.views.View;

class PlayView extends View {
        
    public PlayView() {
      
    }
    
    @Override
    public void interact(AcceptorController playController) {
        new BoardView().interact((PlayController) playController);
        new ActionsView().interact((PlayController) playController);        
    }    
}
