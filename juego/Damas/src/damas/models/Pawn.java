package damas.models;

public class Pawn extends Token {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMovement(Movement movement, Board board) {
        return this.isAdvanceDistanceValid(movement) || this.canCapture(movement, board);
    }

    protected boolean isAdvanceDistanceValid(Movement movement) {
        return ((this.color == Color.WHITE && movement.getDistanceRows() == 1) || (this.color == Color.BLACK && movement.getDistanceRows() == -1))
                && (movement.getDistanceColumns() == 1 || movement.getDistanceColumns() == -1);
    }

    private boolean isCaptureDistanceValid(Movement movement) {
        return ((this.color == Color.WHITE && movement.getDistanceRows() == 2) || (this.color == Color.BLACK && movement.getDistanceRows() == -2))
                && (movement.getDistanceColumns() == 2 || movement.getDistanceColumns() == -2);
    }

    @Override
    public boolean canCapture(Movement movement, Board board) {
        if (this.isCaptureDistanceValid(movement)) {
            int increment;
            if (this.color == Color.WHITE) {
                increment = -1;
            } else {
                increment = 1;
            }
            Color colorEnemy = board.getTokenColor(movement.getInitialRow() + increment, movement.getInitialColumn() - 1);
            if (colorEnemy != null) {
                movement.setCapturedCell(board.getCell(movement.getInitialRow() + increment, movement.getInitialColumn() - 1));
            } else {
                colorEnemy = board.getTokenColor(movement.getInitialRow() + increment, movement.getInitialColumn() + 1);
                if (colorEnemy != null) {
                    movement.setCapturedCell(board.getCell(movement.getInitialRow() + increment, movement.getInitialColumn() + 1));
                }
            }
            return colorEnemy != null && this.color != colorEnemy;
        }
        return false;
    }

    @Override
    public Token clone() {
        return new Pawn(this.color);
    }
   
    @Override
    public boolean isPawn() {
        return true;
    }

    @Override
    public String getCharacter() {
        if (this.color == Color.WHITE) {
           return "b";
        } else {
            return "n";
        }            
    }        
}
