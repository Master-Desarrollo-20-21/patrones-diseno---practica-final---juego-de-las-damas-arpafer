package damas.models;

import java.util.HashMap;
import java.util.Map;

public class Board {

    public static int NUM_CELLS_BY_SIDE = 8;
    private Cell[][] cells;
    private Map<String, Integer> letters;
    private Movement lastCheckedMovement;

    public Board() {
        this.cells = new Cell[Board.NUM_CELLS_BY_SIDE][Board.NUM_CELLS_BY_SIDE];
        this.createHashLetters();
        this.createRows();
        this.putTokens();
        this.lastCheckedMovement = null;
    }

    private Board(Board board) {
        this();
        assert board != null;

        for (int i = 0; i < Board.NUM_CELLS_BY_SIDE; i++) {
            for (int j = 0; j < Board.NUM_CELLS_BY_SIDE; j++) {
                this.cells[i][j] = board.getCell(i, j).clone();
            }
        }
    }

    public int getNumCellsBySide() {
        return Board.NUM_CELLS_BY_SIDE;
    }

    private void createHashLetters() {
        this.letters = new HashMap<String, Integer>();
        this.letters.put("a", 0);
        this.letters.put("b", 1);
        this.letters.put("c", 2);
        this.letters.put("d", 3);
        this.letters.put("e", 4);
        this.letters.put("f", 5);
        this.letters.put("g", 6);
        this.letters.put("h", 7);
    }

    private void createRows() {
        Color colorInitial = Color.WHITE;
        Color nextColor = Color.BLACK;
        for (int row = 0; row < Board.NUM_CELLS_BY_SIDE; row++) {
            this.cells[row] = createRow(row, colorInitial, nextColor);
            Color color = colorInitial;
            colorInitial = nextColor;
            nextColor = color;
        }
    }

    private Cell[] createRow(int row, Color color1, Color color2) {
        return new Cell[]{new Cell(color1, row, 0),
            new Cell(color2, row, 1),
            new Cell(color1, row, 2),
            new Cell(color2, row, 3),
            new Cell(color1, row, 4),
            new Cell(color2, row, 5),
            new Cell(color1, row, 6),
            new Cell(color2, row, 7)
        };
    }

    private void putTokens() {
        for (int row = 0; row < 3; row++) {
            this.putTokensInRow(row, Color.BLACK);
        }
        for (int row = Board.NUM_CELLS_BY_SIDE - 3; row < Board.NUM_CELLS_BY_SIDE; row++) {
            this.putTokensInRow(row, Color.WHITE);
        }
    }

    private void putTokensInRow(int row, Color color) {
        for (int col = 0; col < Board.NUM_CELLS_BY_SIDE; col++) {
            if (this.cells[row][col].getColor() == Color.BLACK) {
                this.cells[row][col].putToken(new Pawn(color));
            }
        }
    }

    public Movement getLastCheckedMovement() {
        return this.lastCheckedMovement;
    }

    public int getSideLength() {
        return Board.NUM_CELLS_BY_SIDE;
    }

    boolean isBusyCell(int row, int col) {
        if (row >= 0 && row < Board.NUM_CELLS_BY_SIDE && col >= 0 && col < Board.NUM_CELLS_BY_SIDE) {
            return this.cells[row][col].isBusy();
        } else {
            return false;
        }
    }

    public boolean isFreeCell(int row, int col) {
        if (row >= 0 && row < Board.NUM_CELLS_BY_SIDE && col >= 0 && col < Board.NUM_CELLS_BY_SIDE) {
            return this.cells[row][col].isFree();
        } else {
            return false;
        }
    }

    public Color getTokenColor(int row, int col) {
        if (row >= 0 && row < Board.NUM_CELLS_BY_SIDE && col >= 0 && col < Board.NUM_CELLS_BY_SIDE) {
            return this.cells[row][col].getTokenColor();
        } else {
            return null;
        }
    }

    public Color getCellColor(int row, int col) {
        return this.cells[row][col].getColor();
    }

    public Token getToken(int row, int col) {
        return this.cells[row][col].getToken();
    }

    public Cell getCell(int row, int col) {
        return this.cells[row][col];
    }

    public boolean canDoneMovement(String[] movement, Turn turn) {
        
        this.lastCheckedMovement = null;
        int initialRow = this.getArrayRowIndex(movement[0]);
        int initialCol = this.getColumnIndexByLetter(movement[1]);
        int targetRow = this.getArrayRowIndex(movement[2]);
        int targetCol = this.getColumnIndexByLetter(movement[3]);
        boolean basicCondition = this.isValidInitialPosition(initialRow, initialCol, turn) && this.isFreeCell(targetRow, targetCol);
        boolean tokenCanMove = false;
        if (basicCondition) {
            this.lastCheckedMovement = new Movement(this.cells[initialRow][initialCol], this.cells[targetRow][targetCol]);
            tokenCanMove = this.cells[initialRow][initialCol].isTokenCanDoMovement(this.lastCheckedMovement, this);
        }
        return basicCondition && tokenCanMove;
    }

    public int getArrayRowIndex(String row) {
        return Board.NUM_CELLS_BY_SIDE - Integer.parseInt(row);
    }

    public int getColumnIndexByLetter(String letter) {
        return this.letters.get(letter.toLowerCase());
    }

    private boolean isValidInitialPosition(int row, int col, Turn turn) {
        return this.isBusyCell(row, col) && this.isTokenColorOK(row, col, turn);
    }

    private boolean isTokenColorOK(int initialRow, int initialCol, Turn turn) {
        return this.getTokenColor(initialRow, initialCol).toString().equals(turn.getValue().toString());
    }

    public void moveToken(Turn turn) {
        Token tokenClone = this.getToken(turn.getInitialRow(), turn.getInitialColumn()).clone();
        this.cells[turn.getInitialRow()][turn.getInitialColumn()].quitToken();
        this.cells[turn.getTargetRow()][turn.getTargetColumn()].putToken(tokenClone);
        if (turn.getValue() == Color.WHITE && turn.getTargetRow() == 0) {
            this.cells[turn.getTargetRow()][turn.getTargetColumn()].convertTokenToQueen(tokenClone);
        } else if (turn.getValue() == Color.BLACK && turn.getTargetRow() == Board.NUM_CELLS_BY_SIDE - 1) {
            this.cells[turn.getTargetRow()][turn.getTargetColumn()].convertTokenToQueen(tokenClone);
        }
    }

    public void quitCapturedToken(Turn turn) {
        turn.quitCapturedCell();
    }

    public boolean canCaptureFrom(String[] coordinate, Turn turn) {

        int initialRow = this.getArrayRowIndex(coordinate[0]);
        int initialColumn = this.getColumnIndexByLetter(coordinate[1]);
        return this.cells[initialRow][initialColumn].canCaptureFrom(this);
    }

    public boolean isPawn(int row, int col) {
        return this.cells[row][col].isTokenPawn();
    }

    public Board copy() {
        return new Board(this);
    }

    public void clear() {
        for (int i = 0; i < Board.NUM_CELLS_BY_SIDE; i++) {
            for (int j = 0; j < Board.NUM_CELLS_BY_SIDE; j++) {
                if (this.cells[i][j].getColor() == Color.BLACK) {
                    this.cells[i][j].quitToken();
                }
            }
        }
    }

    public void setCell(int i, int j, String character) {
        this.cells[i][j].putToken(character);
    }

    public void quitToken(int row, int column) {
        this.cells[row][column].quitToken();
    }
}
