package damas.models.DAO;

import damas.models.Turn;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

class TurnDAO {

    private Turn turn;

    TurnDAO(Turn turn) {
        this.turn = turn;
    }

    void save(FileWriter fileWriter) {

        try {
            fileWriter.write(this.turn.getValue().ordinal() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(BufferedReader bufferedReader) {
        try {
            this.turn.setValue(Integer.parseInt(bufferedReader.readLine()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
