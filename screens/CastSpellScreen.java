/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut.screens;

import rltut.Creature;
import rltut.Spell;

/**
 *
 * @author arthu
 */
public class CastSpellScreen extends TargetBasedScreen{
    private Spell spell;
    
    public CastSpellScreen(Creature player, String caption, int sx, int sy, Spell spell){
        super(player, caption, sx, sy);
        this.spell = spell;
    }
    
    public void selectWorldCoodinate(int x, int y, int screenX, int screenY){
        player.castSpell(spell, x, y);
    }
}
