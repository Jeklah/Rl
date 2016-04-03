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
public class ZombieAi extends CreatureAi {

    private Creature player;

    public ZombieAi(Creature creature, Creature player) {
        super(creature);
        this.player = player;
    }

    public void onUpdate() {
        if (Math.random() < 0.2) {
            return;
        }

        if (creature.canSee(player.x, player.y, player.z)) {
            hunt(player);
        } else {
            wander();
        }
    }
    
    public void hunt(Creature target){
        List<Point> points = new Path(creature, target.x, target.y).points();
        int mx = points.get(0).x - creature.x;
        int my = points.get(0).y - creature.y;
        
        creature.moveBy(mx, my, 0);
    }
}
