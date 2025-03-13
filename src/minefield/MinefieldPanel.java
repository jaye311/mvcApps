package mineField;

import java.awt.*;
import javax.swing.*;

import mvc.*;
import java.awt.*;
import javax.swing.*;


public class MinefieldPanel extends AppPanel {
    private JButton N;
    private JButton E;
    private JButton S;
    private JButton W;
    private JButton NW;
    private JButton NE;
    private JButton SW;
    private JButton SE;
    public MinefieldPanel(AppFactory factory) {
        super(factory);
        controlPanel.setLayout(new GridLayout(4, 2));
        N = new JButton("N");
        N.addActionListener(this);
        controlPanel.add(N);
        E = new JButton("E");
        E.addActionListener(this);
        controlPanel.add(E);
        S = new JButton("S");
        S.addActionListener(this);
        controlPanel.add(S);
        W = new JButton("W");
        W.addActionListener(this);
        controlPanel.add(W);
        NW = new JButton("NW");
        NW.addActionListener(this);
        controlPanel.add(NW);
        NE = new JButton("NE");
        NE.addActionListener(this);
        controlPanel.add(NE);
        SW = new JButton("SW");
        SW.addActionListener(this);
        controlPanel.add(SW);
        SE = new JButton("SE");
        SE.addActionListener(this);
        controlPanel.add(SE);
    }

    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new mineField.MinefieldPanel(factory);
        panel.display();
    }

}

