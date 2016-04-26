/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut.screens;

import rltut.Creature;
import rltut.Item;
import rltut.Tile;


/**
 *
 * @author arthur
 */
public class LookScreen extends TargetBasedScreen{
    
    public LookScreen(Creature player, String caption, int sx, int sy){
        super(player, caption, sx, sy);
    }
    
    public void enterWorldCoordinate(int x, int y, int screenX, int screenY){
        Creature creature = player.creature(x, y, player.z);
        if (creature != null){
            caption = creature.glyph() + " " + creature.name() + creature.details();
            return;
        }
        
        Item item = player.item(x, y, player.z);
        if (item != null){
            caption = item.glyph() + " " + item.name() + item.details();
            return;
        }
        
        Tile tile = player.tile(x, y, player.z);
        caption = tile.glyph() + " " + tile.details();
    }
}