package damas.models;

public class SessionImplementation implements Session {

    private State state;
    private Game game;
    private GameRegistry gameRegistry;
    private String name;

    public SessionImplementation() {
        this.state = new State();
        this.game = new Game();
        this.gameRegistry = new GameRegistry(this.game);
    }

    public Game getGame() {    
        return this.game;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void next() {
        this.state.next();
    }

    public void setState(StateValue value) {
        this.state.setState(value);
    }

    public int getSideLength() {
        return this.game.getSideLength();
    }

    public boolean isBusyCell(int row, int col) {
        return this.game.isBusyCell(row, col);
    }

    public Color getTokenColor(int row, int col) {
        return this.game.getTokenColor(row, col);
    }

    public Color getCellColor(int row, int col) {
        return this.game.getCellColor(row, col);
    }

    public Color getTurnColor() {
        return this.game.getTurnColor();
    }

    public void move() {
        this.game.move();
    }

    public void nextTurn() {
        this.game.nextTurn();
        this.gameRegistry.register();
    }

    public boolean canDoneMovement(String[] movements) {
        return this.game.canDoneMovement(movements);
    }

    public boolean hasCaptured() {
        return this.game.hasCaptured();
    }

    public boolean isPawn(int row, int col) {
        return this.game.isPawn(row, col);
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void undo() {
        this.gameRegistry.undo();
    }

    public boolean isUndoable() {
        return this.gameRegistry.isUndoable();
    }

    public void redo() {
        this.gameRegistry.redo();
    }

    public boolean isRedoable() {
        return this.gameRegistry.isRedoable();
    }

    public void reset() {
        this.game.reset();
        this.state.reset();
        this.resetRegistry();
        this.name = null;
    }

    public void setValueState(StateValue stateValue) {
        this.state.setState(stateValue);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void resetRegistry() {
        this.gameRegistry.reset();
    }

    public void registry() {
        this.gameRegistry.register();
    }

    public boolean hasName() {
        return this.name != null;
    }        
}
