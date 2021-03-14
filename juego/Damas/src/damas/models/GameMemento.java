package damas.models;

public class GameMemento {
    private Board board;
    private Turn turn;
    
    GameMemento(Turn turn, Board board) {
        this.board = board.copy();
        this.turn = turn.copy();        
    }
    
    Board getBoard() {
        return this.board;
    }
    
    Turn getTurn() {
        return this.turn;
    }
}
