package damas.models;

public class Queen extends Token {

    private static int ROW_INVALID = -1;
    private static int COLUMN_INVALID = -1;

    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMovement(Movement movement, Board board) {
        return this.isAdvanceDistanceValid(movement) || this.canCapture(movement, board);
    }

    protected boolean isAdvanceDistanceValid(Movement movement) {
        return ((this.color == Color.WHITE && movement.getDistanceRows() <= -1) || (this.color == Color.BLACK && movement.getDistanceRows() >= 1))
                && (movement.getDistanceColumns() <= -1 || movement.getDistanceColumns() >= 1);
    }

    @Override
    public boolean canCapture(Movement movement, Board board) {
        int incrementRow = this.getIncrementInRow(movement);
        int incrementColumn = this.getIncrementInColumn(movement);
        int row = movement.getInitialRow() + incrementRow;
        int column = movement.getInitialColumn() + incrementColumn;
        int previousRowWithToken = Queen.ROW_INVALID;
        int previousColWithToken = Queen.COLUMN_INVALID;
        while (row != movement.getTargetRow() && column != movement.getTargetColumn()) {
            if (this.isTokenSameColor(row, column, board)) {
                return false;
            } else if (board.getTokenColor(row, column) != null && previousRowWithToken == row - incrementRow && previousColWithToken == column - incrementColumn) {
                return false;
            }
            if (board.getTokenColor(row, column) != null) {
                previousRowWithToken = row;
                previousColWithToken = column;
            }
            row += incrementRow;
            column += incrementColumn;
        }
        return true;
    }

    private boolean isTokenSameColor(int row, int column, Board board) {
        return board.getTokenColor(row, column) == this.color;
    }

    private int getIncrementInRow(Movement movement) {
        if (movement.getDistanceRows() <= -1) {
            return -1;
        } else {
            return 1;
        }
    }

    private int getIncrementInColumn(Movement movement) {
        if (movement.getDistanceColumns() <= -1) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public Token clone() {
        return new Queen(this.color);
    }
    
    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public String getCharacter() {
        if (this.color == Color.WHITE) {
            return "B";
        } else {
            return "N";
        }
    }
}
