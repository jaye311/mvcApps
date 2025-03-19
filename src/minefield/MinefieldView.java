package mineField;
import mvc.*;
import java.awt.*;

public class MinefieldView extends View{
    private static final int CELL_SIZE = 15; // Size of each cell in pixels


    public MinefieldView(MineField mineField) {
        super(mineField);
        setPreferredSize(new Dimension(mineField.getFieldSize() * CELL_SIZE, mineField.getFieldSize() * CELL_SIZE));

    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        MineField mineField = (MineField) model;
        int fieldSize = mineField.getFieldSize();

        for (int row = 0; row < fieldSize; row++){
            for(int col = 0; col < fieldSize; col++){
                int x = col * CELL_SIZE; // Finds the position of the cell
                int y = row * CELL_SIZE;

                if (row == mineField.getY() && col == mineField.getX()) {
                    gc.setColor(Color.BLUE); // Player position
                }else if (row == mineField.getFieldSize() - 1 && col == mineField.getFieldSize() - 1) {
                    gc.setColor(Color.GREEN); // Goal cell
                } else if (mineField.isSteppedOn(row, col)) {
                    gc.setColor(Color.LIGHT_GRAY); // Revealed cell
                } else {
                    gc.setColor(Color.GRAY); // Unrevealed cell
                }

                gc.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                gc.setColor(Color.BLACK);
                gc.drawRect(x, y, CELL_SIZE, CELL_SIZE);

                // Paints mine if player steps on it
                if (mineField.isSteppedOn(row, col) && mineField.hasMine(row, col)) {
                    gc.setColor(Color.RED);
                    gc.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                }

                // Draw text showing adjacent mines (Either a number or "?")
                gc.setColor(Color.BLACK);
                gc.setFont(new Font("Arial", Font.BOLD, CELL_SIZE - CELL_SIZE / 3));

                if(mineField.isSteppedOn(row,col)){
                    String adjMines = String.valueOf(mineField.getAdjacentMines(row, col));
                    gc.drawString((adjMines), x + CELL_SIZE / 3, y + CELL_SIZE - CELL_SIZE / 4);
                }else{
                    gc.drawString("?", x + CELL_SIZE / 3, y + CELL_SIZE - CELL_SIZE / 4);
                }
            }
        }

    }
}
