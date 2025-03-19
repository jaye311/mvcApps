package mineField;

import mvc.*;

public class MinefieldFactory implements AppFactory {

    @Override
    public Model makeModel() { return new MineField(); }

    @Override
    public View makeView(Model m) {
        return new MinefieldView((MineField)m);
    }

    @Override
    public String[] getEditCommands() {
            return new String[]{"N", "E", "S", "W", "NW", "NE", "SW", "SE"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equals("N") || type.equals("E") || type.equals("S") || type.equals("W") ||
                type.equals("NW") || type.equals("NE") || type.equals("SW") || type.equals("SE"))
            return new MoveCommand(model, type);
        return null;
    }

   @Override
    public String getTitle() { return "Mine Field"; }

    @Override
    public String[] getHelp() {
        return new String[] {"Click N, E, S, W, NW, NE, SW, SE to move the minefield"};
    }

    @Override
    public String about() {
        return "Minefield version 1.0. Copyright 2025 by Cyberdellic Designs";
    }

}
