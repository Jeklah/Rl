/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arthur
 */
public class LevelUpController {
    private static LevelUpOption[] options = new LevelUpOption[]{
        new LevelUpOption("Increased hit points"){
            public void invoke(Creature creature) { creature.gainMaxHp(); }
        },
        new LevelUpOption("Increased attack value"){
            public void invoke(Creature creature) { creature.gainAttackValue(); }
        },
        new LevelUpOption("Increased defense value"){
            public void invoke(Creature creature) { creature.gainDefenseValue(); }
        },
        new LevelUpOption("Increased vision"){
            public void invoke(Creature creature) { creature.gainVision(); }
        }
    };
    
    public void autoLevelUp(Creature creature){
        options[(int)(Math.random() * options.length)].invoke(creature);
    }

}