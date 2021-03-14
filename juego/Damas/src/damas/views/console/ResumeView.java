package damas.views.console;

import damas.controllers.AcceptorController;
import damas.controllers.ResumeController;
import damas.views.Message;
import damas.views.View;

public class ResumeView extends View {
            
    @Override
    public void interact(AcceptorController controller) {
         RespondYesNoView respondYesNo = new RespondYesNoView();
         respondYesNo.interact(Message.RESUME.toString());                  
         if (respondYesNo.isAffirmative()) {                        
             ((ResumeController)(controller)).resume(true);
         }
         else {
             controller.exit();
         }      
    }
    
}
