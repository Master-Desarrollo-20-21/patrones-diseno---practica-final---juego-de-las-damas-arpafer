package damas.views.console;

import damas.controllers.PlayController;
import damas.models.Color;
import damas.models.Movement;
import utils.Console;
import damas.views.Message;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class MovementView {

    private ArrayList<Movement> movements;

    public MovementView() {
        this.movements = new ArrayList<Movement>();
    }

    public void interact(PlayController playController) {
        this.showTurn(playController);        
        String movements = Console.getInstance().readString(Message.INTRO_COORDINATES.toString());
        boolean ilegalMovement = false;
        int movementIndex = 0;
        String initialCell = "", targetCell = "";
        if (this.validSintaxisCoordinates(movements)) {
            while (movementIndex < movements.length()) {
                if (movementIndex == 0) {
                    initialCell = this.getNextCell(movements, movementIndex);
                    movementIndex += 2;
                }
                targetCell = this.getNextCell(movements, movementIndex);
                movementIndex += 2;
                if (playController.canDoneMovement(new String[]{this.getRow(initialCell), this.getColumn(initialCell), this.getRow(targetCell), this.getColumn(targetCell)})) {
                    playController.move();
                    new BoardView().interact(playController);
                } else {
                    ilegalMovement = true;
                    Console.getInstance().writeln(Message.ILEGAL_MOVEMENT.toString() + " at (" + initialCell + targetCell + ")");
                }                
                if (ilegalMovement) {
                    do {
                        movements = Console.getInstance().readString(Message.INTRO_COORDINATES.toString());
                    } while (!this.validSintaxisCoordinates(movements));
                    movementIndex = 0;
                    initialCell = "";
                    ilegalMovement = false;
                } else {
                    initialCell = targetCell;
                }
            }
            playController.nextTurn();
        } else {
            Console.getInstance().writeln(Message.ERROR_COORDINATES.toString());
        }
        Console.getInstance().writeln();
    }

    private void showTurn(PlayController playController) {
        Color turnColor = playController.getTurnColor();
        Console.getInstance().writeln("Turn " + turnColor + ": ");
    }

    private boolean validSintaxisCoordinates(String coordinates) {
        Pattern pattern = Pattern.compile("([1-8]{1}[a-h]{1}[1-8]{1}[a-h]{1})+([1-8]{1}[a-h]{1})*");
        return pattern.matcher(coordinates).matches();
    }

    private String getRow(String cell) {
        return cell.substring(0, 1);
    }

    private String getColumn(String cell) {
        return cell.substring(1, 2);
    }

    private String getNextCell(String movements, int movementIndex) {
        return movements.substring(movementIndex, movementIndex + 2);
    }
}
