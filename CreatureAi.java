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
    public void onEnter(int x, int y, int z, Tile tile) {
        if (tile.isGround()){
            creature.x = x;
            creature.y = y;
            creature.z = z;
        } else {
            creature.doAction("bump into a wall");
        }
    }
    
    public void onUpdate() { }
    
    public void onNotify(String message) { }
    
    public boolean canSee(int wx, int wy, int wz){
        if (creature.z != wz){
            return false;
        }
        
        if ((creature.x-wx) * (creature.x-wx) + (creature.y-wy) * (creature.y-wy) > creature.visionRadius()*creature.visionRadius()){
            return false;
        }
        
        for (Point p : new Line(creature.x, creature.y, wx, wy)){
            if (creature.tile(p.x, p.y, wz).isGround() || p.x == wx && p.y == wy){
                continue;
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    public void wander(){
        int mx = (int)(Math.random() * 3) -1;
        int my = (int)(Math.random() * 3) -1;
        
        Creature other = creature.creature(creature.x + mx, creature.y + my, creature.z);
        
        if (other != null && other.name() == creature.name()){
            return;
        } else {
            creature.moveBy(mx, my, 0);
        } 
    }
}
