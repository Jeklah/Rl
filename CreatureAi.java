/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut;

/**
 *
 * @author arthur
 */
public class CreatureAi {
    protected Creature creature;
    
    public CreatureAi(Creature creature){
        this.creature = creature;
        this.creature.setCreatureAi(this);
    }    
    public void onEnter(int x, int y, int z, Tile tile) { }
    
    public void onUpdate() { }
    
    public void onNotify(String message) { }
}
