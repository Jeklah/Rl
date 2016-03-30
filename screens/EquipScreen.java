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
public class EquipScreen extends InventoryBasedScreen {
    public EquipScreen(Creature player){
        super(player);
    }
    
    protected String getVerb(){
        return "wear or wield";
    }
    
    protected boolean isAcceptable(Item item){
        return item.attackValue() > 0 || item.defenseValue() > 0;
    }
    
    protected Screen use(Item item){
        player.equip(item);
        return null;
    }
}
