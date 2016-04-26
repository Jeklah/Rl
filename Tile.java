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
    FLOOR((char)250, AsciiPanel.yellow, "A dirt and rock cave floor."),
    WALL((char)177, AsciiPanel.yellow, "A dirt and rock cave wall."),
    BOUNDS('x', AsciiPanel.brightBlack, "Beyond the edge of the world."),
    STAIRS_DOWN('>', AsciiPanel.white, "A stone staircase that goes down."),
    STAIRS_UP('<', AsciiPanel.white, "A stone staircase that goes up."),
    UNKNOWN(' ', AsciiPanel.white, "(unknown)");
    
    private char glyph;
    public char glyph() { return glyph; }
    
    private Color color;
    public Color color() { return color; }
    
    private String details;
    public String details() { return details; }
    
    public boolean isDiggable(){
        return this == Tile.WALL;
    }
    
    public boolean isGround(){
        return this != WALL && this != BOUNDS;
    }
    
    Tile(char glyph, Color color, String details){
        this.glyph = glyph;
        this.color = color;
        this.details = details;
    }
}
