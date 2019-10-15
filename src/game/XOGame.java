/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Pavel
 */
public class XOGame {
    
    public int count;
    public final XOPlayer p1;
    public final XOPlayer p2;
    private ArrayList<Object> gameStats = new ArrayList<>();
    private XOPlayer nowTurn;
    public boolean active;
    
    /**
     * Default constructor for XOGame object.
     * Defines internal public fields p1="P1" and p2="P2".
     * Sets game round counter = 0
     */
    public XOGame () {
        this.count = 0;
        
        this.p1 = new XOPlayer("P1");
        this.p1.setCounter(0);
        
        this.p2 = new XOPlayer("P2");
        this.p2.setCounter(0);
        
    }
        
    /**
     * Initialises random signs for each player X|O and sets nextTurn field pointing to a randomly selected  player's object
     */
    public void Initialise () {
            
        this.active = false;
        this.p1.setCounter(0);
        this.p2.setCounter(0);
        
        if (0 == (new Random()).nextInt(2)) {
            p1.setSign("X");
            p2.setSign("O");
        } else {
            p1.setSign("O");
            p2.setSign("X");
        }
        
        nowTurn = (0 == (new Random()).nextInt(2)) ? p1 : p2;
        this.active = true;

    }
    
    public void startOver () {
        
        this.Initialise();
        this.count = 1;
        
    }    
    
       
    /**
     * Adds current game's stats into gameStats array
     * @param table
     * @param hasWinner 
     */
    
    public void addStats(javax.swing.JTable table, boolean hasWinner) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        Object[] stats;
        
        if (hasWinner) {
            tableModel.addRow(new Object[]{Integer.toString(this.count), this.getPlayer().getName()});
            stats = new Object[] { this.count, this.getPlayer() };
            
        } else {
            tableModel.addRow(new Object[]{Integer.toString(this.count), " "});
            stats = new Object[] { this.count, "---" };
        }
        
        this.gameStats.add(this.count - 1, stats);
        
    }
    
    /**
     * 
     * @param table
     */ 
    private void reloadStats (javax.swing.JTable table) {
    }
    
    /**
     * Increments game round counter and re-Initialises xoMatrix
     * @return 
     */
    public int nextGame () {
        this.Initialise();
        this.count++;
        
        return this.count;
    }
    
    /**
     * Switches next players pointer.
     * @return Returns next player's object
     */
    public XOPlayer nowTurn () {
        this.nowTurn = ("P1".equals(this.nowTurn.toString())) ? p2 : p1;
        return this.nowTurn;
    }
    
    /**
     * Returns current player's object
     * @return Current player's object
     */
    public XOPlayer getPlayer () {
        return this.nowTurn;
    }
    
}
