package mineField;

import mvc.*;


public class MoveCommand extends Command {
    private MineField model;
    private String direction;

    public MoveCommand(Model model, String direction) {
        super(model);
        this.model = (MineField) model;
        this.direction = direction;
    }
    public void execute() {
        model.move(direction);
//        model.getField()[model.getX()][model.getY()].setSteppedOn(true); // Mark as visited
        model.changed();
    }

}