/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut.screens;

import rltut.Creature;
import rltut.Item;

/**
 *
 * @author arthur
 */
public class ReadScreen extends InventoryBasedScreen{
    private int sx;
    private int sy;
    
    public ReadScreen(Creature player, int sx, int sy){
        super(player);
        this.sx = sx;
        this.sy = sy;
    }
    
    protected String getVerb(){
        return "read";
    }
    
    protected boolean isAcceptable(Item item){
        return !item.writtenSpells().isEmpty();
    }
    
    protected Screen use(Item item){
        return new ReadSpellScreen(player, sx, sy, item);
    }
}
