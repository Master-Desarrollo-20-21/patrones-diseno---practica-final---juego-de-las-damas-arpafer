package damas.models;

public class Movement {

    private Cell cell1;
    private Cell cell2;
    private Cell capturedCell;
    private boolean hadCapture;

    public Movement(Cell cell1, Cell cell2) {
        this.cell1 = cell1;
        this.cell2 = cell2;
        this.capturedCell = null;
        this.hadCapture = false;
    }
    
    private Movement(Cell cell1, Cell cell2, Cell capturedCell, boolean hadCapture) {
        this(cell1, cell2);
        assert cell1 != null && cell2 != null;
        
        this.capturedCell = capturedCell;
        this.hadCapture = hadCapture;
    } 
    
    public Cell getCapturedCell() {
        return this.capturedCell;
    }

    public int getDistanceRows() {
        return this.cell1.getDistanceRows(this.cell2);
    }

    public int getDistanceColumns() {
        return this.cell1.getDistanceColumns(this.cell2);
    }

    int getInitialRow() {
        return this.cell1.getRow();
    }

    int getInitialColumn() {
        return this.cell1.getColumn();
    }

    int getTargetRow() {
        return this.cell2.getRow();
    }

    int getTargetColumn() {
        return this.cell2.getColumn();
    }

    void quitCapturedToken() {
        if (this.capturedCell != null) {                        
            this.capturedCell.quitToken();
        }
    }

    void setCapturedCell(Cell cell) {
        this.capturedCell = cell;
        this.hadCapture = true;
    }

    public boolean hasCaptured() {
        return this.hadCapture;
    }
    
    public Movement copy() {
        return new Movement(this.cell1.clone(), this.cell2.clone(), this.capturedCell.clone(), this.hadCapture);
    }
}
