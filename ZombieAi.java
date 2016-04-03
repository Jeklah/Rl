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
public class ZombieAi extends CreatureAi{
    private Creature player;
    
    public ZombieAi(Creature creature, Creature player){
        super(creature);
        this.player = player;
    }
}
