package damas.models;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {

    public List<GameMemento> mementos;
    private int firstPrevious;
    private Game game;

    public GameRegistry(Game game) {        
        this.game = game;
        this.reset();
    }

    void register() {
        for (int i = 0; i < this.firstPrevious; i++) {
            this.mementos.remove(0);
            this.firstPrevious--;
        }
        this.mementos.add(this.firstPrevious, this.game.createMemento());        
    }

    void undo() {

        this.firstPrevious++;
        this.game.set(this.mementos.get(this.firstPrevious));
    }

    void redo() {
        this.firstPrevious--;
        this.game.set(this.mementos.get(this.firstPrevious));
    }

    boolean isUndoable() {
        return this.firstPrevious < this.mementos.size() - 1;
    }

    boolean isRedoable() {
        return this.firstPrevious >= 1;
    }

    void reset() {        
        this.mementos = new ArrayList<GameMemento>();
        this.firstPrevious = 0;
        this.mementos.add(this.firstPrevious, this.game.createMemento());
    }
}
