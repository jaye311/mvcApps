package mineField;

import mvc.Model;

public class MineField extends Model {
    public static int percentMined = 5;
    private int fieldSize;
    private Cell [][] field;
    private int playerX;
    private int playerY;
    private boolean playerLiving;

    public MineField(){
        fieldSize = 20;
        field = new Cell[fieldSize][fieldSize];
        playerX = 0;
        playerY = 0;
        playerLiving = true;
    }

    public Cell[][] setMines(){
        field = new Cell[fieldSize][fieldSize];
        for(int row = 0; row < field.length; row++){
            for(int col = 0; col < field[row].length; col++){
                //set random mines in field at percentMined percentage
                field[row][col] = new Cell(percentMined);
            }
        }
        //the starting and ending square should not be mines
        field[0][0].setMine(false);
        field[fieldSize - 1][fieldSize - 1].setMine(false);
        //setting correct AdjacentMines Count for each cell in field
        for(int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                int count = 0;
                if(row > 0) {
                    if(field[row - 1][col].getMine())
                        count++;
                    if(col > 0)
                        if(field[row - 1][col - 1].getMine())
                            count++;
                    if(col < fieldSize - 1)
                        if(field[row - 1][col + 1].getMine())
                            count++;
                }
                if(col > 0 && field[row][col - 1].getMine())
                    count++;
                if(row < fieldSize - 1) {
                    if(field[row + 1][col].getMine())
                        count++;
                    if(col > 0)
                        if(field[row + 1][col - 1].getMine())
                            count++;
                    if(col < fieldSize - 1)
                        if(field[row + 1][col + 1].getMine())
                            count++;
                }
                if(col < fieldSize - 1 && field[row][col + 1].getMine())
                    count++;
                field[row][col].setAdjacentMines(count);
            }
        }
        //player starts on starting square
        field[0][0].setSteppedOn(true);
        return field;
    }

    public void setPercentMined(int percent){
        if(percent <= 100 && percent >= 0)
            percentMined = percent;
    }
    //use this method for MoveCommand
    public void move(String direction) {
        if(!playerLiving)
            System.err.println("You are dead!");
        else{
            if (direction.equals("NE")) {
                if (playerY > 0 && playerX < fieldSize) {
                    playerY--;
                    playerX++;
                }
            }
            if (direction.equals("SE")) {
                if (playerY < fieldSize && playerX < fieldSize) {
                    playerY++;
                    playerX++;
                }
            }
            if (direction.equals("E")) {
                if (playerX < fieldSize) {
                    playerX++;
                }
            }
            if (direction.equals("N")) {
                if (playerY > 0) {
                    playerY--;
                }
            }
            if (direction.equals("S")) {
                if (playerY < fieldSize) {
                    playerY++;
                }
            }
            if (direction.equals("SW")) {
                if (playerY < fieldSize && playerX > 0) {
                    playerY++;
                    playerX--;
                }
            }
            if (direction.equals("NW")) {
                if (playerY > 0 && playerX > 0) {
                    playerY--;
                    playerX--;
                }
            }
            if (direction.equals("W")) {
                if (playerX > 0) {
                    playerX--;
                }
            }
            //if you step on a mine you lose
            if(field[playerY][playerX].getMine()){
                playerLiving = false;
                System.err.println("You are dead!");
            }
            //reveal hidden cells that were steppedOn
            if(!field[playerY][playerX].isSteppedOn()){
                field[playerY][playerX].setSteppedOn(true);
            }
            //Player has reached goal
            if(playerY == fieldSize - 1 && playerX == fieldSize - 1){
                System.out.println("You win!");
            }
            notifySubscribers();
        }
    }

    public int getX(){
        return playerX;
    }
    public int getY(){
        return playerY;
    }
    public int getFieldSize(){
        return fieldSize;
    }
    public void setFieldSize(int size){
        if(size > 0)
            fieldSize = size;
    }

    //for testing
    public void textRepresentation(){
        for(int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                if(row == playerY && col == playerX)
                    System.out.print("\033[0;34m" + field[row][col] + "\u001B[0m");
                else if(row == fieldSize - 1 && col == fieldSize - 1)
                    System.out.print("\u001B[32m" + field[row][col] + "\u001B[0m");
                else
                    System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
}
