package damas.models;

public class Cell {

    private Color color;
    private boolean busy;
    private int row;
    private int col;
    private Token token;
    
    public Cell(Color color, int row, int col, Token token) {
        this.color = color;
        this.busy = true;
        this.row = row;
        this.col = col;
        this.token = token;
    }
    
     private Cell(Color color, int row, int col, Token token, boolean isBusy) {
        this.color = color;
        this.busy = isBusy;
        this.row = row;
        this.col = col;
        this.token = token;
    }
     
    public Cell(Color color, int row, int col) {
        this.color = color;
        this.busy = false;
        this.row = row;
        this.col = col;        
    }
            
    public boolean isFree() {
        return !this.busy;
    }
    
    public boolean isBusy() {
        return this.busy;
    }
    
    public Token getToken() {
    
        return this.token;
    }
    
    public void putToken(Token token) {
        this.token = token;
        this.busy = true;                
    }
    
    public void putToken(String character) {
        this.putToken(Token.getTokenByCharacter(character));        
    }
           
    public void convertTokenToQueen(Token token) {
        this.token = new Queen(token.getColor());
    }
    
    public void quitToken() {
        this.token = null;
        this.busy = false;
    }
    
    public Cell clone() {
        if (this.token != null) {
           return new Cell(this.color, this.row, this.col, this.token.clone(), this.busy);        
        } else {
            return new Cell(this.color, this.row, this.col, null, this.busy);        
        }
            
    }

    public boolean hasToken() {
        return this.token != null;
    }
    
    public Color getTokenColor() {
        if (this.token != null) {
            return this.token.getColor();
        } else {
            return null;
        }
    }

    public Color getColor() {
        return this.color;
    }

    boolean isTokenCanDoMovement(Movement movement, Board board) {
        return this.token.isValidMovement(movement, board);
    }

    int getDistanceRows(Cell cell2) {
        return this.row - cell2.row;                        
    }

    int getDistanceColumns(Cell cell2) {
        return this.col - cell2.col;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.col;
    }

    boolean canCapture(Movement movement, Board board) {
        return this.token.canCapture(movement, board);
    }

    boolean canCaptureFrom(Board board) {
        return this.token.couldCaptureFrom(this, board);
    }        

    public boolean isTokenPawn() {
        if (this.token != null) {
           return this.token.isPawn();
        } else {
            return false;
        }
    }

    public String getTokenCharacter() {
        assert(this.token != null);
        return this.token.getCharacter();
    }    
}
