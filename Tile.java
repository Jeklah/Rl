/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut;

import java.awt.Color;
import asciiPanel.AsciiPanel;

/**
 *
 * @author arthur
 */
public enum Tile {
    FLOOR((char)250, AsciiPanel.yellow),
    WALL((char)177, AsciiPanel.yellow),
    BOUNDS('X', AsciiPanel.brightBlack),
    STAIRS_DOWN('>', AsciiPanel.white),
    STAIRS_UP('<', AsciiPanel.white),
    UNKNOWN(' ', AsciiPanel.white);
    
    private char glyph;
    public char glyph() { return glyph; }
    
    private Color color;
    public Color color() { return color; }
    
    public boolean isDiggable(){
        return this == Tile.WALL;
    }
    
    public boolean isGround(){
        return this != WALL && this != BOUNDS;
    }
    
    Tile(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }
}