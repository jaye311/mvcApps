package mineField;

import java.util.Scanner;

public class MineFieldTest {
    public static void main(String[] args) {
        MineField mf = new MineField();
//        mf.setFieldSize(10);
//        mf.setPercentMined(10);
//        mf.setMines();
        mf.textRepresentation();
        Scanner scanner = new Scanner(System.in);
        String direction;
        try {
            while (!(mf.getY() == mf.getFieldSize() && mf.getX() == mf.getFieldSize())) {
                System.out.println("What direction? n, e, s, w, ne, se, nw, sw");
                direction = scanner.nextLine();
                mf.move(direction.toUpperCase());
                System.out.println("You are at: " + mf.getX() + ", " + mf.getY());
                if(!(mf.getY() == mf.getFieldSize() && mf.getX() == mf.getFieldSize()))
                    mf.textRepresentation();
            }
        }
        catch (Exception e){
            System.out.println("You already won!");
        }
    }
}
