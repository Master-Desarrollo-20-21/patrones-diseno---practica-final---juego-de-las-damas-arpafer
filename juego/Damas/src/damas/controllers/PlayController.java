package damas.controllers;

import damas.models.Color;
import damas.models.Session;

public abstract class PlayController extends AcceptorController {
        
    public PlayController(Session session) {
        super(session);        
    }
    
    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
    
    public abstract int getBoardSideLength();

    public abstract boolean isBusyCell(int row, int col);

    public abstract Color getCellTokenColor(int row, int col);

    public abstract Color getCellColor(int row, int col);

    public abstract Color getTurnColor();

      
    public abstract void move();

    public abstract void nextTurn();

    public abstract boolean canDoneMovement(String[] movements);
        
    public abstract boolean hadCaptured();
            
    public abstract boolean isPawn(int row, int col);
    
    public abstract boolean isUndoable();
    
    public abstract boolean isRedoable();

    public abstract void exit();

    public abstract void undo();
    
    public abstract void redo();

    public abstract void resume();
}
