package shootme.gui;

import shootme.beans.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Nicole on 20.03.2017
 */
public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private Character character;
    private final int DELAY = 10;

    public GamePanel() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
        setOpaque(true);
//        setBackground(Color.BLACK);

        character = new Character();

        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(character.getImage(), character.getX(), character.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        character.move();
        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            character.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            character.keyPressed(e);
        }
    }
}
