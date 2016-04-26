/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut.screens;

import rltut.Creature;
import rltut.Line;
import rltut.Point;

/**
 *
 * @author arthur
 */
public class FireWeaponScreen extends TargetBasedScreen {
    public FireWeaponScreen(Creature player, int sx, int sy){
        super(player, "Fire " + player.weapon().name() + " at?", sx, sy);
    }
    
    public boolean isAcceptable(int x, int y){
        if (!player.canSee(x, y, player.z)){
            return false;
        }
        
        for (Point p : new Line(player.x, player.y, x, y)){
            if (!player.realTile(p.x, p.y, player.z).isGround()){
                return false;
            }
        }
        return true;
    }
    
    public void selectWorldCoodinate(int x, int y, int screenX, int screenY){
        Creature other = player.creature(x, y, player.z);
        
        if (other == null){
            player.notify("There's no one there to fire at.");
        } else {
            player.rangedWeaponAttack(other);
        }
    }
}
