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
public class DropScreen extends InventoryBasedScreen {
    public DropScreen (Creature player){
        super(player);
    }
    
    protected String getVerb(){
        return "drop";
    }
    
    protected boolean isAcceptable(Item item){
        return true;
    }
    
    protected Screen use(Item item){
        player.drop(item);
        return null;
    }
}
