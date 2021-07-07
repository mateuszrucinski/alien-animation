package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJPanel extends JPanel implements ActionListener {
    private final static int GAME_WIDTH = 1200;
    private final static int GAME_HEIGHT = 800;

    private int x = 0;
    private int y = 0;
    private int xVariable = 5;
    private int yVariable = 1;

    private final Timer timer;

    private final Image tlo;
    private final Image enemy;

    MyJPanel() {

        tlo = new ImageIcon("tlo.jpg").getImage();
        enemy = new ImageIcon("enemy.png").getImage();

        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        setBackground(Color.BLACK);

        timer = new Timer(8, this);
        timer.start();
    }

    public void paint(Graphics g) {

        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(tlo, 0, 0, null);
        g2d.drawImage(enemy, x, y, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x >= GAME_WIDTH - enemy.getWidth(null) || x < 0) {
            xVariable = -xVariable;
        }
        x += xVariable;

        if (y >= GAME_HEIGHT - enemy.getHeight(null) || y < 0) {
            yVariable = -yVariable;
        }
        y += yVariable;

        repaint();
    }


}
