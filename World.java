/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arthur
 */
public class World {
    private Tile[][][] tiles;
    private int width;
    public int width() { return width; }
    
    private int height;
    public int height() { return height; }
    
    private int depth;
    public int depth() { return depth; }
    
    private List<Creature> creatures;
    
    public Creature creature(int x, int y, int z){
        for (Creature c : creatures){
            if (c.x == x && c.y == y && c.z == z){
                return c;
            }
        }
        return null;
    }
    
    public World(Tile[][][] tiles){
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
        this.depth = tiles[0][0].length;
        this.creatures = new ArrayList<Creature>();
    }
    
    public Tile tile(int x, int y, int z){
        if (x < 0 || x >= width || y < 0 || y >= height || z >= depth || z < 0){
            return Tile.BOUNDS;
        } else {
            return tiles[x][y][z];
        }
    }
    
    public char glyph(int x, int y, int z){
        return tile(x,y,z).glyph();
    }
    
    public Color color(int x, int y, int z){
        return tile(x,y,z).color();
    }
    
    public void dig(int x, int y, int z){
        if (tile(x,y,z).isDiggable()){
            tiles[x][y][z] = Tile.FLOOR;
        }
    }
    
    public void addAtEmptyLocation(Creature creature, int z){
        int x;
        int y;
        
        do {
            x = (int)(Math.random() * width);
            y = (int)(Math.random() * height);
        } while (!tile(x,y,z).isGround() || creature(x,y,z) != null);
        
        creature.x = x;
        creature.y = y;
        creature.z = z;
        creatures.add(creature);
    }
    
    public void remove(Creature other){
        creatures.remove(other);
    }
    
    public void update(){
	List<Creature> toUpdate = new ArrayList<Creature>(creatures);
	for (Creature creature : toUpdate){
		creature.update();
	}
    }
}
