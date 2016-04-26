/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut.screens;

import rltut.Creature;
import rltut.Item;
import rltut.Line;
import rltut.Point;

/**
 *
 * @author arthur
 */
public class ThrowAtScreen extends TargetBasedScreen {
    private Item item;
    
    public ThrowAtScreen(Creature player, int sx, int sy, Item item){
        super(player, "Throw " + item.name() + " at?", sx, sy);
        this.item = item;
    }
    
    public boolean isAcceptable(int x, int y){
        if (!player.canSee(x, y, player.z)){
            return false;
        }
        
        for (Point p : new Line(player.x, player.y, x, y)){
            if (!player.realTile(p.x, p.y, player.z).isGround()){
                return false;
            }
        }
        
        return true;
    }
    
    public void selectWorldCoodinate(int x, int y, int screenX, int screenY){
        player.throwItem(item, x, y, player.z);
    }
    
    
    
    
}