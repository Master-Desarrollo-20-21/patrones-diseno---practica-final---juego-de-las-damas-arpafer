package damas.views.console;

import damas.controllers.PlayController;
import damas.models.Color;
import utils.Console;

public class BoardView {

    private String WHITE_PAWN = " b ";
    private String WHITE_QUEEN = " B ";
    private String BLACK_PAWN = " n ";
    private String BLACK_QUEEN = " N ";
    private String EMPTY = "   ";

    public BoardView() {
    }

    public void interact(PlayController playController) {

        int numberAtMargin = 8;
        Console.getInstance().writeln();
        this.showLetters();
        Console.getInstance().writeln("    .................................");
        for (int row = 0; row < playController.getBoardSideLength(); row++) {
            Console.getInstance().write(String.valueOf(numberAtMargin));
            Console.getInstance().write("   ");
            Console.getInstance().write("|");
            for (int col = 0; col < playController.getBoardSideLength(); col++) {
                if (playController.isBusyCell(row, col)) {
                    if (playController.getCellTokenColor(row, col) == Color.WHITE) {
                        if (playController.isPawn(row, col)) {
                            Console.getInstance().write(this.WHITE_PAWN);
                        } else {
                            Console.getInstance().write(this.WHITE_QUEEN);
                        }
                    } else {
                        if (playController.isPawn(row, col)) {
                            Console.getInstance().write(this.BLACK_PAWN);
                        } else {
                            Console.getInstance().write(this.BLACK_QUEEN);
                        }
                    }
                } else {
                    Console.getInstance().write(this.EMPTY);
                }
                Console.getInstance().write("|");
            }
            Console.getInstance().write("   " + String.valueOf(numberAtMargin));
            numberAtMargin--;
            Console.getInstance().writeln();
            Console.getInstance().writeln("    .................................");
        }
        this.showLetters();
    }

    private void showLetters() {
        Console.getInstance().writeln("      a   b   c   d   e   f   g   h");
    }

}
