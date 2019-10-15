/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import ui.XOFrame;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Pavel
 */
public class XO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(XO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Runnable xoGUI = new Runnable () {
        
            @Override
            public void run() {
                XOFrame xo = new XOFrame();
                xo.setLocationRelativeTo(null);
                xo.pack();

                xo.setVisible(true);
            }
        };
        
        SwingUtilities.invokeLater(xoGUI);
        
        //System.out.println(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
    }
    
}
