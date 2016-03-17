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
public class FungusAi extends CreatureAi {
    
    private CreatureFactory factory;
    private int spreadCount;
    
    public FungusAi(Creature creature, CreatureFactory factory){
        super(creature);
        this.factory = factory;
    }
    
    private void spread(){
        int x = creature.x + (int)(Math.random() * 11) - 5;
        int y = creature.y + (int)(Math.random() * 11) - 5;

        
        if(!creature.canEnter(x, y, creature.z)){
            return;
        }
        
        Creature child = factory.newFungus(creature.z);
        child.x = x;
        child.y = y;
        child.z = creature.z;
        spreadCount++;
    }
    
    public void onUpdate(){
        if (spreadCount < 5 && Math.random() < 0.02){
            spread();
        }
    }

}
