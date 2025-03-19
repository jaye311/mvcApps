package mineField;

import java.awt.*;
import javax.swing.*;

import mvc.*;
import java.awt.*;
import javax.swing.*;


public class MinefieldPanel extends AppPanel {
    private JButton N, E, S, W, NW, NE, SW, SE;
    private MinefieldView view; // View to display the minefield

    public void buttonLayout(){
        JPanel p;

        //FlowLayout provides buttons with horizontal spacing
        p = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        p.add(NW);
        p.add(N);
        p.add(NE);
        controlPanel.add(p);

        p = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 6));
        p.add(W);
        p.add(new JLabel()); // Spacing placeholder (blank space)
        p.add(E);
        controlPanel.add(p);

        p = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 6));
        p.add(SW);
        p.add(S);
        p.add(SE);
        controlPanel.add(p);
    }

    public MinefieldPanel(AppFactory factory) {
        super(factory);

//        // Creates and adds the MinefieldView
//        view = new MinefieldView(((MineField) model));
//        model.subscribe(view); // Allows the view to update according to changes
//        this.add(view);

        N = new JButton("N");
        E = new JButton("E");
        S = new JButton("S");
        W = new JButton("W");
        NW = new JButton("NW");
        NE = new JButton("NE");
        SW = new JButton("SW");
        SE = new JButton("SE");

        controlPanel.setLayout(new GridLayout(3, 3));
        buttonLayout();

        N.addActionListener(this);

        E.addActionListener(this);

        S.addActionListener(this);

        W.addActionListener(this);

        NW.addActionListener(this);

        NE.addActionListener(this);

        SW.addActionListener(this);

        SE.addActionListener(this);
    }

    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new mineField.MinefieldPanel(factory);
        panel.display();
    }

}

