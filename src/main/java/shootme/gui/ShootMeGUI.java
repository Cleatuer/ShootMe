/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shootme.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Nicole
 */
public class ShootMeGUI extends JFrame
{

   public ShootMeGUI()
   {
      initGUI();
   }

   private void initGUI()
   {

      add(new GamePanel());

      setSize(800, 600);

      setTitle("Moving character!");
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args)
   {

      EventQueue.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {

            ShootMeGUI ex = new ShootMeGUI();
            ex.setVisible(true);
         }
      });
   }
}
