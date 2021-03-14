package damas.models.DAO;

import damas.models.SessionImplementation;
import damas.models.StateValue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SessionImplementationDAO {

    public static final String EXTENSION = ".dam";

    public static final String DIRECTORY = "./partidas";

    private static File directory;

    static {
        SessionImplementationDAO.directory = new File(SessionImplementationDAO.DIRECTORY);
    }

    private SessionImplementation sessionImplementation;

    private GameDAO gameDAO;

    public void associate(SessionImplementation sessionImplementation) {
        this.sessionImplementation = sessionImplementation;
        this.gameDAO = new GameDAO(this.sessionImplementation.getGame());
    }

    public void load(String name) {
        this.sessionImplementation.setName(name);
        File file = new File(SessionImplementationDAO.directory, name);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            this.gameDAO.load(bufferedReader);
            this.sessionImplementation.resetRegistry();            
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sessionImplementation.setValueState(StateValue.IN_GAME);        
    }

    public void save() {
        this.save(this.sessionImplementation.getName());
    }

    public void save(String name) {
        if (name.endsWith(SessionImplementationDAO.EXTENSION)) {
            name = name.replace(SessionImplementationDAO.EXTENSION, "");
        }
        File file = new File(SessionImplementationDAO.directory, name + SessionImplementationDAO.EXTENSION);
        try {
            FileWriter fileWriter = new FileWriter(file);
            this.gameDAO.save(fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getGamesNames() {
        return SessionImplementationDAO.directory.list();
    }

    public boolean exists(String name) {
        String[] names = this.getGamesNames();
        if (names != null) {
            for (String auxName : names) {
                if (auxName.equals(name + SessionImplementationDAO.EXTENSION)) {
                    return true;
                }
            }
        }
        return false;
    }    
}
