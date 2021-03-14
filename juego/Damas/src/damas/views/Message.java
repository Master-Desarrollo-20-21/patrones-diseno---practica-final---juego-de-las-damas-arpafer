package damas.views;

public enum Message {
    HEAD_TITLE("D A M A S"),
    PLAY_COMMAND("Play"),
    LOAD_COMMAND("Load play from disc"),
    EXIT_OR_RESUME_COMMAND("Exit or resume"),
    EXIT_COMMAND("Exit"),    
    SELECT_OPTION("Select a option..."),
    SELECT_MOVEMENT_OPTION("Select a movement"),    
    MOVE_COMMAND("Move"),
    RESUME_COMMAND("Resume"),    
    ROW_INITIAL("\tRow initial (1 - 8): "),
    COLUMN_INTIAL("\tColumn initial (a - h): "),
    ROW_TARGET("\tRow target (1 - 8): "),
    COLUMN_TARGET("\tColumn target (a - h): "),
    OTHER_MOVEMENT("\t¿Other movement? (Yes/no)"),
    CAPTURE_MOVEMENT_OPTION(".- Capturar pieza/s"), 
    ILEGAL_MOVEMENT("¡Ilegal movement!"),
    ROW_AND_COLUMN_INITIAL("\tInitial Row and Column (example: 3c):"),
    ROW_AND_COLUMN_TARGET("\tTarget Row and Column (example: 4d):"),
    ERROR_COORDINATES("\t¡Error coordinates!"),
    INTRO_COORDINATES("intro coordinates (ejem: 3c4d): "), 
    UNDO_COMMAND("Undo previous action"),
    REDO_COMMAND("Redo previous action"),
    RESUME("Do you want to continue a new Play? (Y/n)"), 
    SAVE("Do you want to save the game? (y/n)"),
    SAVE_COMMAND("Save"), 
    NAME("Name: "), 
    ALREADY_EXIST("The proposed name already exists"), 
    SELECT_FILE("Select file...");
    
   private String message;
   
   Message(String message) {
       this.message = message;
   } 
    
    public String toString() {
       return this.message;
    }    
}
