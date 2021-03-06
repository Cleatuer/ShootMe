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
public class GamePanel extends JPanel implements ActionListener
{

   private Timer timer;
   private Character character;
   private final int DELAY = 1 / 30 * 1000;

   public GamePanel()
   {
      initBoard();
   }

   private void initBoard()
   {

      addKeyListener(new MyKeyAdapter());
      setFocusable(true);
      setOpaque(true);
      setBackground(Color.WHITE);

      character = new Character();

      timer = new Timer(DELAY, this);
      timer.start();
   }

   @Override
   public void paintComponent(Graphics g)
   {

      doDrawing(g);

      Toolkit.getDefaultToolkit().sync();
   }

   private void doDrawing(Graphics g)
   {
      Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(Color.white);
      g2d.drawRect(character.getX(), character.getY(), character.getImage().getWidth(), character.getImage().getHeight());
      character.move();
      g2d.drawImage(character.getImage(), character.getX(), character.getY(), null);
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      paintComponent(getGraphics());
   }

   private class MyKeyAdapter extends KeyAdapter
   {

      @Override
      public void keyReleased(KeyEvent e)
      {
         character.keyReleased(e);
      }

      @Override
      public void keyPressed(KeyEvent e)
      {
          if(e.getKeyCode() == KeyEvent.VK_SPACE){
              character.setDy(-1);
              for (int i = 1; i < 100; i++){
                  character.move();
                  paintComponent(getGraphics());
              }
              character.setDy(1);
              for (int i = 1; i < 100; i++){
                  character.move();
                  paintComponent(getGraphics());
              }
              character.setDy(0);
          }
         character.keyPressed(e);
         paintComponent(getGraphics());
      }
   }
}
