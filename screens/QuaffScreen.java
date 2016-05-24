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
public class QuaffScreen extends InventoryBasedScreen{
    public QuaffScreen(Creature player){
        super(player);
    }
    
    protected String getVerb(){
        return "quaff";
    }
    
    protected boolean isAcceptable(Item item){
        return item.quaffEffect() != null;
    }
    
    protected Screen use(Item item){
        player.quaff(item);
        return null;
    }
}
