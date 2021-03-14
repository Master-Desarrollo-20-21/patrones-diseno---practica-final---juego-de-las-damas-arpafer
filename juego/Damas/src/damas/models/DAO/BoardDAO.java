package damas.models.DAO;

import damas.models.Board;
import damas.models.Cell;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

class BoardDAO {

    private final String EMPTY = "-";
    private final Board board;

    BoardDAO(Board board) {
        this.board = board;
    }

    void save(FileWriter fileWriter) {
        try {
            for (int i = 0; i < this.board.getNumCellsBySide(); i++) {
                for (int j = 0; j < this.board.getNumCellsBySide(); j++) {
                    Cell cell = this.board.getCell(i, j);
                    if (cell.isFree()) {
                        fileWriter.write(this.EMPTY);
                    } else {
                        fileWriter.write(cell.getTokenCharacter());
                    }
                }
                fileWriter.write("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load(BufferedReader bufferedReader) {
        try {
            this.board.clear();
            for (int i = 0; i < this.board.getNumCellsBySide(); i++) {
                String linea = bufferedReader.readLine();
                for (int j = 0; j < this.board.getNumCellsBySide(); j++) {
                    if (!linea.substring(j, j + 1).equals(this.EMPTY)) {
                        String character = linea.substring(j, j + 1);
                        this.board.setCell(i, j, character);
                    } else {
                        this.board.quitToken(i, j);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
