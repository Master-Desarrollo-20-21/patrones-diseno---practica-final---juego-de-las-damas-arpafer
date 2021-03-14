package damas.controllers.implementation;

import damas.controllers.PlayController;
import damas.models.Color;
import damas.models.DAO.SessionImplementationDAO;
import damas.models.Session;
import damas.models.SessionImplementation;
import damas.models.StateValue;

public class PlayControllerImplementation extends PlayController {

    private SessionImplementationDAO sessionImplementationDAO;
    private SessionImplementation sessionImplementation;

    public PlayControllerImplementation(Session session) {
        super(session);
        this.sessionImplementationDAO = sessionImplementationDAO;
        this.sessionImplementation = ((SessionImplementation) this.session);
    }
    
    @Override
    public int getBoardSideLength() {
        return this.sessionImplementation.getSideLength();
    }

    @Override
    public boolean isBusyCell(int row, int col) {
        return this.sessionImplementation.isBusyCell(row, col);
    }

    @Override
    public Color getCellTokenColor(int row, int col) {
        return this.sessionImplementation.getTokenColor(row, col);
    }

    @Override
    public Color getCellColor(int row, int col) {
        return this.sessionImplementation.getCellColor(row, col);
    }

    @Override
    public Color getTurnColor() {
        return this.sessionImplementation.getTurnColor();
    }
   
    @Override
    public void move() {
        this.sessionImplementation.move();
    }

    @Override
    public void nextTurn() {
        this.sessionImplementation.nextTurn();
    }

    @Override
    public boolean canDoneMovement(String[] movements) {
        return this.sessionImplementation.canDoneMovement(movements);
    }

    @Override
    public boolean hadCaptured() {
        return this.sessionImplementation.hasCaptured();
    }
   
    @Override
    public boolean isPawn(int row, int col) {
        return this.sessionImplementation.isPawn(row, col);
    }

    @Override
    public boolean isUndoable() {
        return this.sessionImplementation.isUndoable();
    }

    @Override
    public boolean isRedoable() {
        return this.sessionImplementation.isRedoable();
    }

    @Override
    public void exit() {
        this.setState(StateValue.EXIT);
    }

    @Override
    public void undo() {
        this.sessionImplementation.undo();
    }

    @Override
    public void redo() {
        this.sessionImplementation.redo();
    }

    @Override
    public void resume() {
        this.setState(StateValue.RESUME);
    }

}
