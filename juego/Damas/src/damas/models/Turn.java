package damas.models;

import java.util.ArrayList;
import java.util.List;

public class Turn {

    private static int NUM_PLAYERS = 2;
    private Color color;
    private ArrayList<Movement> movements;
    
    public Turn(Color value) {
        this.color = value;
        this.movements = new ArrayList<Movement>();
    }

    private Turn(Turn turn) {
        this(turn.getValue());

        for (int i = 0; i < this.movements.size(); i++) {
            this.movements.add((turn.movements.get(i)).copy());
        }
    }

    public Color getValue() {
        return this.color;
    }
    
    public void setValue(int color) {
        this.color = Color.values()[color];
    }

    public void nextTurn() {
        this.color = Color.values()[(this.color.ordinal() + 1) % Turn.NUM_PLAYERS];
    }

    public void addMovement(Movement movement) {

        this.movements.add(movement);
    }

    public List<Movement> getMovements() {
        return this.movements;
    }
    
    public Movement getLastMovement() {
        if (this.movements.size() > 0) {
            return this.movements.get(this.movements.size() - 1);
        } else {
            return null;
        }
    }

    public int getTargetRow() {
        return this.movements.get(this.movements.size() - 1).getTargetRow();
    }

    public int getTargetColumn() {
        return this.movements.get(this.movements.size() - 1).getTargetColumn();
    }

    public int getInitialRow() {
        return this.movements.get(this.movements.size() - 1).getInitialRow();
    }

    public int getInitialColumn() {
        return this.movements.get(this.movements.size() - 1).getInitialColumn();
    }

    void quitCapturedCell() {
        this.movements.get(this.movements.size() - 1).quitCapturedToken();
    }

    int getCapturedNumberTokens() {
        int num = 0;
        for (Movement movement : this.movements) {
            if (movement.getCapturedCell() != null) {
                num++;
            }
        }
        return num;
    }

    public boolean hasCaptured() {
        return this.movements.get(this.movements.size() - 1).hasCaptured();
    }

    Turn copy() {
        return new Turn(this);
    }
}
