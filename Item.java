/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut;

import java.awt.Color;


/**
 *
 * @author arthur
 */
public class Item {
    private char glyph;
    public char glyph() { return glyph; }
    
    private Color color;
    public Color color() { return color; }
    
    private String name;
    public String name() { return name; }
    
    public Item(char glyph, Color color, String name){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
    }
}
