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
public class EatScreen extends InventoryBasedScreen{
    public EatScreen(Creature player){
        super(player);
    }
    
    @Override
    protected String getVerb(){
        return "eat";
    }
    
    @Override
    protected boolean isAcceptable(Item item){
        return item.foodValue() != 0;
    }
    
    @Override
    protected Screen use(Item item){
        player.eat(item);
        return null;
    }
}
