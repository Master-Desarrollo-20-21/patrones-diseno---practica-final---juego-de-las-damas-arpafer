package damas.models;

public abstract class Token {
    protected Color color;      
    
    public Token(Color color) {
        this.color = color;
    }
    
    public static Token getTokenByCharacter(String character) {
        if (character.equals("b")) {
            return new Pawn(Color.WHITE);
        }
        if (character.equals("n")) {
            return new Pawn(Color.BLACK);
        }
        if (character.equals("B")) {
            return new Queen(Color.BLACK);            
        }
        if (character.equals("N")) {
            return new Queen(Color.BLACK);
        }
        return null;
    }    
    
    Color getColor() {
        return this.color;
    }
    
    public abstract Token clone();                    
    public abstract boolean isValidMovement(Movement movement, Board board);     
    public abstract boolean canCapture(Movement movement, Board board);        
    
    private boolean isCoordinateInBoardLimits(int targetRow, int targetColumn) {
        return targetRow >= 0 && targetRow < Board.NUM_CELLS_BY_SIDE && targetColumn >= 0 && targetColumn < Board.NUM_CELLS_BY_SIDE;        
    }
    
    protected Movement getMovement(Cell cell, int incrementOffsetRow, int incrementOffsetColumn, Board board) {
        int initialRow = cell.getRow();
        int initialCol = cell.getColumn();
        int targetRow = cell.getRow() + incrementOffsetRow;
        int targetColumn = cell.getColumn() + incrementOffsetColumn;                     
        if (this.isCoordinateInBoardLimits(targetRow, targetColumn) && board.getCell(targetRow, targetColumn).isFree()) {            
            return new Movement(board.getCell(initialRow, initialCol), board.getCell(targetRow, targetColumn));
        } else {
            return null;
        }
    }                   

    public abstract boolean isPawn();

    public abstract String getCharacter();                
}
