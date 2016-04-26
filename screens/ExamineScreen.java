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
public class ExamineScreen extends InventoryBasedScreen {
    
    public ExamineScreen(Creature player){
        super(player);
    }
    
    protected String getVerb(){
        return "examine";
    }
    
    protected boolean isAcceptable(Item item){
        return true;
    }
    
    protected Screen use(Item item){
        String article = "aeiou".contains(item.name().subSequence(0, 1)) ? "an " : "a ";
        player.notify("It's " + article + item.name() + "." + item.details());
        return null;
    }
}
