package damas.controllers;

public interface ControllerVisitor {
    
    void visit(StartController controller);    
    void visit(PlayController controller);
    void visit(ResumeController controller);
    void visit(SaveController controller);
    void visit(LoadController controller);
}
