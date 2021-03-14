package damas.controllers;

import damas.models.Session;

public abstract class AcceptorController extends Controller {

   public AcceptorController(Session session) {
       super(session);
   } 
   public abstract void accept(ControllerVisitor controllerVisitor);   
}
