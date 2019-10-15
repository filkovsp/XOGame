/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import game.XOGame;
import game.XOMatrix;

/**
 * This class should be designed by singletone pattern.
 * @author Pavel
 */
public class XOApplication {
    private static XOApplication application = null;
    private static XOMatrix matrix = null;
    private static XOGame game = null;
    
    public static XOApplication getInstance() {
        
        synchronized(XOApplication.class) {
            if(application == null) {
                application = new XOApplication();
                matrix = new XOMatrix();
                game = new XOGame();
            }
        }
        return application;
        
    }
    
}
