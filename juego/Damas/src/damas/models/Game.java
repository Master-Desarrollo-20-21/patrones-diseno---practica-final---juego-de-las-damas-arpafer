package damas.models;

public class Game {
        
    private Board board;
    private State state;
    private Turn turn;
    
    public Game() {
       this.reset();
    }
    
    public Board getBoard() {
        return this.board;
    }
    
    public Turn getTurn() {
        return this.turn;
    }
    
    public State getState() {
        return this.state;
    }
    
    public int getSideLength() {
        return this.board.getSideLength();
    }
    
    public boolean isBusyCell(int row, int col) {
        return this.board.isBusyCell(row, col);
    }

    public Color getTokenColor(int row, int col) {
        return this.board.getTokenColor(row, col);
    }

    public Color getCellColor(int row, int col) {
        return this.board.getCellColor(row, col);
    }

    public Color getTurnColor() {
        return this.turn.getValue();
    }

    public void nextTurn() {  
        this.turn.nextTurn();        
    }

    public boolean canDoneMovement(String[] movements) {
        return this.board.canDoneMovement(movements, this.turn);
    }
    
    private void addMovement() {                   
      this.turn.addMovement(this.board.getLastCheckedMovement());
    }

    public void move() {
        this.addMovement();
        this.board.moveToken(this.turn);     
        this.board.quitCapturedToken(this.turn);
        
    }

    public boolean hasCaptured() {
        return this.turn.hasCaptured();
    }

    public boolean canCaptureAgain(String[] coordinate) {        
        return this.board.canCaptureFrom(coordinate, this.turn);        
    }       

    public boolean isPawn(int row, int col) {
        return this.board.isPawn(row, col);
    }
    
    public void set(GameMemento memento) {
        this.board = memento.getBoard();
        this.turn = memento.getTurn();        
    }

    GameMemento createMemento() {
        return new GameMemento(this.turn, this.board);
    }

    public void reset() {
       this.board = new Board();
       this.state = new State();
       this.turn = new Turn(Color.WHITE);
    }
}
