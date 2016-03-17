/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut;

import java.util.List;

/**
 *
 * @author arthur
 */
public class PlayerAi extends CreatureAi {
    private List<String> messages;
 
    public PlayerAi(Creature creature, List<String> messages){
        super(creature);
        this.messages = messages;
    }
    
    public void onEnter(int x, int y,int z, Tile tile){
        if (tile.isGround()){
            creature.x = x;
            creature.y = y;
            creature.z = z;
        } else if (tile.isDiggable()){
            creature.dig(x, y, z);
        }
    }
    
    public void onNotify(String message){
        messages.add(message);
    }
   
}
