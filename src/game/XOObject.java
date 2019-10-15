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

public class XOObject {

    /**
     * Object of a matrix (XOObject)
     * Final field "name" is being initialised once object created.
     */
    public final String name;
    private boolean signed = false;
    private String sign;
    private javax.swing.JLabel userObject = null;
    

    /**
     * Constructs an empty object container with the given Name
     * @param name 
     */
    public XOObject (String name) {
        this.name = name;
        this.signed = false;
    }
    
    /**
     * Constructs an empty object container with the given NAME and SELECTED property.
     * @param name 
     * @param signed 
     */
    public XOObject (String name, boolean signed) {
        this.name = name;
        this.signed = signed;
    }
    
    /**
     * Returns User Object
     * @return 
     */
    public Object getUserObject() {
        return this.userObject;
    }
    
    /**
     * Sets User Object
     * @param obj 
     */
    public void setUserObject(Object obj) {
        this.userObject = (javax.swing.JLabel) obj;
    }
    
    /**
     * Marks Object as signed, means the corresponded xoCell has been defiled with X|O
     * @param signed 
     */
    private void setSigned (boolean signed) {
        this.signed = signed;
    }
    
    /**
     * 
     * @return 
     */
    public String getSign () {
        return this.sign;
    }
    
    /**
     * Marks current cell with sign "X"|"O" and sets label's foreground colour in cell
     * @param sign String X|O
     * @param color java.awt.Color
     */
    public void setSign (String sign, java.awt.Color color) {
        this.signed = true;
        this.sign = sign;
        this.userObject.setText(sign);
        this.userObject.setForeground(color);
    }    
    
    /**
     * Returns true if current cell in xoMatrix is already defined with sign X|O
     * @return true|false from internal field "signed"
     */
    public boolean isSigned () {
        return this.signed;
    }
    
    @Override
    public String toString() {
        return this.name;
    }   
    
}
