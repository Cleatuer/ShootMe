/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shootme.gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
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
      setLayout(new GridLayout(1, 1));
      add(new GamePanel());
      
      setSize(1280, 720);
      
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
