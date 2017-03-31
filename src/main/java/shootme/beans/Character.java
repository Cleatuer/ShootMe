package shootme.beans;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Created by Nicole on 20.03.2017
 */
public class Character
{

   private int dx;
   private int dy;
   private int x;
   private int y;
   private BufferedImage imageRight;
   private BufferedImage imageLeft;
   private BufferedImage image;

   public Character()
   {
      try
      {
         char fS = File.separatorChar;
         imageRight = ImageIO.read(new File(System.getProperty("user.dir") + fS + "src" + fS + "main" + fS + "java" + fS + "shootme" + fS + "beans" + fS + "guenter_right.png"));
         imageLeft = ImageIO.read(new File(System.getProperty("user.dir") + fS + "src" + fS + "main" + fS + "java" + fS + "shootme" + fS + "beans" + fS + "guenter_left.png"));
         image = imageRight;
         x = 0;
         y = 0;
      }
      catch (IOException ex)
      {
         System.out.println(ex.toString());
      }
   }

   public void move()
   {
      x += dx;

      if (dx < 0)
      {
         image = imageLeft;
      }
      else if (dx > 0)
      {
         image = imageRight;
      }

      y += dy;

   }

   public int getX()
   {
      return x;
   }

   public int getY()
   {
      return y;
   }

   public BufferedImage getImage()
   {
      return image;
   }

   public void keyPressed(KeyEvent e)
   {

      int key = e.getKeyCode();

      if (key == KeyEvent.VK_LEFT)
      {
         dx = -1;
      }

      if (key == KeyEvent.VK_RIGHT)
      {
         dx = 1;
      }

      if (key == KeyEvent.VK_UP)
      {
         dy = -1;
      }

      if (key == KeyEvent.VK_DOWN)
      {
         dy = 1;
      }
   }

   public void keyReleased(KeyEvent e)
   {

      int key = e.getKeyCode();

      if (key == KeyEvent.VK_LEFT)
      {
         dx = 0;
      }

      if (key == KeyEvent.VK_RIGHT)
      {
         dx = 0;
      }

      if (key == KeyEvent.VK_UP)
      {
         dy = 0;
      }

      if (key == KeyEvent.VK_DOWN)
      {
         dy = 0;
      }
   }
}
