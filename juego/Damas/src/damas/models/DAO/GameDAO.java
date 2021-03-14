package damas.models.DAO;

import damas.models.Game;
import java.io.BufferedReader;
import java.io.FileWriter;

public class GameDAO {

    private Game game;
    private BoardDAO boardDAO;
    private TurnDAO turnDAO;

    public GameDAO(Game game) {
        this.game = game;
        this.boardDAO = new BoardDAO(this.game.getBoard());
        this.turnDAO = new TurnDAO(this.game.getTurn());
    }

    void load(BufferedReader bufferedReader) {
       this.turnDAO.load(bufferedReader);
       this.boardDAO.load(bufferedReader);
    }

    void save(FileWriter fileWriter) {

        this.turnDAO.save(fileWriter);
        this.boardDAO.save(fileWriter);

    }

}
