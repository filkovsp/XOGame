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
public class XOPlayer {
    
    public final String name;
    private String dysplayName;
    private String sign;
    private java.awt.Color color;
    private int counter;
    
    /**
     * Default constructor for player's object.
     * Player's name must be provided, by default P1|P2 is being initialised in class XOGame.
     * @param name 
     */    
    public XOPlayer (String name) {
        this.name = name;
        this.counter = 0; 
        this.dysplayName = name;
    }

    /**
     * Returns user-friendly name from internal field dysplayName
     * @return dysplayName field value.
     */
    public String getName () {
        return this.dysplayName;
    }

    /**
     * Sets user-friendly name from internal field dysplayName
     * @param name would be set to dysplayName
     */
    public void setName (String name) {
        this.dysplayName = name;
    }    
    
    /**
     * Current cells foreground colour
     * @return java.awt.Color - current cells colour
     */
    public java.awt.Color getColor () {
        return this.color;
    }
    
    /**
     * Returns current cells text X|O
     * @return String "X"|"O" - current cells text
     */
    public String getSign () {
        return this.sign;
    }
    
    /**
     * Sets text Sign for current cell and its colour X:Red, O:Blue
     * @param sign String "X"|"O"
     */
    public void setSign (String sign) {
        this.sign = sign;
        switch (sign) {
            case "O":
                this.color = new java.awt.Color(0, 0, 255);
                break;
            
            case "X":
                this.color = new java.awt.Color(255, 51, 51);
                break;
            
            default:
                break;
        }

    }
    
    public int getCounter() {
        return this.counter;
    }
    
    public void setCounter(int cnt) {
        this.counter = cnt;
    }    
    
    @Override
    public String toString() {
        return this.name;
    }    
    
    
}
