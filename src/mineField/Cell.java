package mineField;

import mvc.Utilities;

import java.io.Serializable;

public class Cell implements Serializable {
    private boolean mine;
    private int adjacentMines;
    private boolean steppedOn;

    //constructor with chance that cell may be a mine
    public Cell(int percentChance){
        adjacentMines = 0;
        steppedOn = false;
        //cell has a percentChance to be a mine
        if(Utilities.rng.nextInt(100) < percentChance){
            setMine(true);
        }
    }
    public void setMine(boolean mine){
        this.mine = mine;
    }

    public void setSteppedOn(boolean steppedOn){
        this.steppedOn = steppedOn;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    public boolean getMine(){
        return mine;
    }

    public boolean isSteppedOn() {
        return steppedOn;
    }

    public String toString(){
        if(steppedOn)
            return "["+adjacentMines+"]";
        else
            return "[?]";
    }
}
