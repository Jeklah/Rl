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
public class BatAi extends CreatureAi {
    
    public BatAi(Creature creature){
        super(creature);
    }
    
    public void onUpdate(){
        wander();
        wander();
    }
}
