/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

/**
 *
 * @author Pavel
 */
public class XOMatrix {
    
    private final ArrayList xoMatrix = new ArrayList();
    private XOObject lastSelected; // = null;
    private int counter;

    
    /**
     * default constructor.
     * only initialises xoMatrix with XOObject(s) inside.
     */
    public XOMatrix () {
        //this.Initialize();
    }
    
    /**
     * Overriden constructor.
     * initialises xoMatrix with XOObject(s) inside and assignes Objects objContainer to each UserObject
     * @param objContainer container contains JLabels.
     */
    public XOMatrix (javax.swing.JPanel objContainer) {
        //this.Initialize(objContainer);
    }
    
    /**
     * Initialises XOMatrix with XOObject inside as xoMatrix field.
     * Sets ArrayList matrix[3][3] with puts XOObject in each position.
     */
    private void Initialize () {
        
        this.counter = 0;

        ArrayList xoArr = new ArrayList<>();
        
        for (int y = 0; y < 3; y++) {
            
            for (int x = 0; x < 3; x++) {            
                // TOTO: assign change event listener here
                //XOObject xoObj = new XOObject("x" + Integer.toString(x) + Integer.toString(y));
                //xoArr.add(x, xoObj);
                
                xoArr.add(x, new XOObject("x" + Integer.toString(x) + Integer.toString(y)));
                
            }
            
            //xoMatrix.add(y, xoArr);            
            xoMatrix.add(y, new ArrayList<>(xoArr));
            
            xoArr.clear();
        }
    }
    
    /**
     * Extended Initialisation of XOMatrix with XOObject inside as xoMatrix field.
     * Sets ArrayList matrix[3][3] with puts XOObject in each position and assignes Objects objContainer to each UserObject
     * sets by default position [1][1] selected.
     * @param objContainer
     */
    public void Initialize (javax.swing.JPanel objContainer) {
        
        this.Initialize();
        
        int x,y;
        
        for (Component c : objContainer.getComponents()) {
            
            
            if (c instanceof javax.swing.JLabel) {
                javax.swing.JLabel item = (javax.swing.JLabel) c;
                
                x = Integer.parseInt(item.getName().substring(1,2));
                y = Integer.parseInt(item.getName().substring(2,3));

                item.setText("");
                item.setForeground(Color.black);
                item.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                XOObject xoObj = (XOObject) this.getObjectByXY(x, y);
                //xoObj.setUserObject(l);
                xoObj.setUserObject(item);
            }

        }
        
        this.setSelected (1, 1, true);
        
    }
    
    /**
     * @return Matrix of objects with pointers to Labels represented by UserObject property.
     * see methods getUserObject and setUserObject in XOObject Class.
     */
    public ArrayList getXOMatrix () {
        return this.xoMatrix;
    }
    

    /**
     * Moves selection of component in matrix
     * @param mv the keypressed code
     * returned by java.awt.event.KeyEvent evt
     * evt.getKeyCode():
     * <ul>
     * <li>  38 - arrow UP       ||  87 - key w
     * <li>  39 - arrow RIGHT    ||  68 - key d
     * <li>  40 - arrow DOWN     ||  83 - key s
     * <li>  37 - arrow LEFT     ||  65 - key a
     * </ul>
     */    
    public void setMove (int mv) {
        int x,y;
        x = Integer.parseInt(this.lastSelected.toString().substring(1,2));
        y = Integer.parseInt(this.lastSelected.toString().substring(2,3));
        
        switch (mv) {
            //Up
            case 38:
            case 87:
                if (y > 0) {
                    this.setSelected(x,y,false);
                    y--;
                    this.lastSelected = this.setSelected(x,y,true);
                }
                break;
                
            //Down
            case 40:
            case 83:
                if (y < 2) {
                    this.setSelected(x,y,false);
                    y++;
                    this.lastSelected = this.setSelected(x,y,true);
                }
                break;
                
            //Right
            case 39:
            case 68:
                if (x < 2) {
                    this.setSelected(x,y,false);
                    x++;
                    this.lastSelected = this.setSelected(x,y,true);
                }
                break;
                
            //Left:
            case 37:
            case 65:
                if (x > 0) {
                    this.setSelected(x,y,false);
                    x--;
                    this.lastSelected = this.setSelected(x,y,true);
                }
                break;
            
            default:
                break;
        }
    }
    
    /**
     * Sets object element selected by X and Y coordinates provided.
     * @param x X-coordinate of object element in Matrix
     * @param y Y-coordinate of object element in Matrix
     * @param selected Boolean true or false, cell-selection marker.
     * @return Last Selected (XOObject)Object.name
     */
    private XOObject setSelected (int x, int y, boolean selected) {
        
        XOObject xoObj = getObjectByXY(x, y);
        javax.swing.JLabel userObject = (javax.swing.JLabel) xoObj.getUserObject();
        
        if (userObject instanceof javax.swing.JLabel) {
            if (!selected) {
                userObject.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            } else {
                userObject.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
            }
        } else {
            return null;
        }
        
        this.lastSelected = xoObj; //.toString();
        return this.lastSelected;
    }
        
    /**
     * @return Last Selected (XOObject)Object.name
     */
    public XOObject getLastSelected () {
        return this.lastSelected;
    }
    
    /**
     * Gets object from xoMatrix property by X and Y coordinates provided.
     * @param x X-coordinate of object element in Matrix
     * @param y Y-coordinate of object element in Matrix
     * @return Object from xoMatrix
     */
    private XOObject getObjectByXY(int x, int y) {
        ArrayList xoList = (ArrayList) xoMatrix.get(y);
        XOObject xoObj = (XOObject) xoList.get(x);
        return xoObj;
    }
    
    /**
     * Sets visual representative sign X/O for a current cell
     * @param player
     * @return Returns boolean true is successfully signed, or false if cell has already been signed with text.
     */
    public boolean setSign ( XOPlayer player ) {

        XOObject xoObj = this.lastSelected; 
        
        if (!xoObj.isSigned()) {
            xoObj.setSign(player.getSign(), player.getColor());
            player.setCounter(player.getCounter() + 1);
            this.counter++;
            return true;
        } else {
            return false;
        }        
        
    }
 
    /**
     * Sets visual representative sign X/O for a current cell
     * @param sign String "X" | "O"
     * @param color java.awt.Color
     * @return Returns boolean true is successfully signed, or false if cell has already been signed with text.
     */    
    public boolean setSign ( String sign, java.awt.Color color ) {

        XOObject xoObj = this.lastSelected; 
        
        if (!xoObj.isSigned()) {
            xoObj.setSign(sign, color);
            this.counter++;
            return true;
        } else {
            return false;
        }
    }
      
    public int getCount () {
        return this.counter;
    }
    
    public boolean checkWinner (XOPlayer player) {
        return 
                this.scanLeftDiagonal(player)
            ||  this.scanRightDiagonal(player)
            ||  this.scanRow(player)
            ||  this.scanColumn(player)
        ;

    }
    
    private boolean scanRow (XOPlayer player) {
        
        ArrayList<XOObject> xoArr = new ArrayList<>();
        String playerStr = "";
        String matrixStr = "";
        
        int x,y;
        //x = Integer.parseInt(this.lastSelected.toString().substring(1,2));
        y = Integer.parseInt(this.lastSelected.toString().substring(2,3));
        
        for (x = 0; x < 3; x++) {
            playerStr += player.getSign();
            matrixStr += this.getObjectByXY(x, y).getSign();
            xoArr.add(this.getObjectByXY(x, y));            
        }
        
        if (playerStr.equals(matrixStr)) {
            for (XOObject i : xoArr) {
                javax.swing.JLabel item = (javax.swing.JLabel) i.getUserObject();
                //item.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
                item.setBorder(javax.swing.BorderFactory.createEtchedBorder(player.getColor(), null));
            }
            return true;
        } else {
             return false;
        }
    }
    
    private boolean scanColumn (XOPlayer player) {
        
       ArrayList<XOObject> xoArr = new ArrayList<>();
        String playerStr = "";
        String matrixStr = "";
        
        int x,y;
        x = Integer.parseInt(this.lastSelected.toString().substring(1,2));
        //y = Integer.parseInt(this.lastSelected.toString().substring(2,3));
        
        for (y = 0; y < 3; y++) {
            playerStr += player.getSign();
            matrixStr += this.getObjectByXY(x, y).getSign();
            xoArr.add(this.getObjectByXY(x, y));            
        }
        
        if (playerStr.equals(matrixStr)) {
            for (XOObject i : xoArr) {
                javax.swing.JLabel item = (javax.swing.JLabel) i.getUserObject();
                //item.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
                item.setBorder(javax.swing.BorderFactory.createEtchedBorder(player.getColor(), null));
            }
            return true;
        } else {
             return false;
        }
        
    }    
    
    private boolean scanLeftDiagonal (XOPlayer player) {
        
        ArrayList<XOObject> xoArr = new ArrayList<>();
        String playerStr = "";
        String matrixStr = "";

        int x,y;
        for (x = 0; x < 3; x++) {
            y = x;
            playerStr += player.getSign();
            matrixStr += this.getObjectByXY(x, y).getSign();
            xoArr.add(this.getObjectByXY(x, y));

        }

        if (playerStr.equals(matrixStr)) {
            for (XOObject i : xoArr) {
                javax.swing.JLabel item = (javax.swing.JLabel) i.getUserObject();
                //item.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
                item.setBorder(javax.swing.BorderFactory.createEtchedBorder(player.getColor(), null));
            }
            return true;
        } else {
             return false;
        }        
    }
    
    private boolean scanRightDiagonal (XOPlayer player) {
        ArrayList<XOObject> xoArr = new ArrayList<>();
        String playerStr = "";
        String matrixStr = "";
        
        int y = 0;
        for (int x = 2; x >= 0; x--) {
            playerStr += player.getSign();
            matrixStr += this.getObjectByXY(x, y).getSign();
            xoArr.add(this.getObjectByXY(x, y));
            y++;
        }

        if (playerStr.equals(matrixStr)) {
            for (XOObject i : xoArr) {
                javax.swing.JLabel item = (javax.swing.JLabel) i.getUserObject();
                //item.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
                item.setBorder(javax.swing.BorderFactory.createEtchedBorder(player.getColor(), null));
            }
            return true;
        } else {
             return false;
        } 
    }

    
}
