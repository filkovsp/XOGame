/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Pavel
 */
public interface Game {
    public void initialise();
    public void startGame();
    public void nextGame();
    public void saveStats();
}
