/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Pavel
 */
public class XOStats {
    private final int count;
    private final XOPlayer winner;
    private double duration;
    
    public XOStats (int i, XOPlayer player) {
        this.count = i;
        this.winner = player;
    }
    
    public void setDuration(double gameDuration) {
        this.duration = gameDuration;
    }
    
}
