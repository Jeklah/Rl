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
        },
        new LevelUpOption("Increased mana"){
            public void invoke(Creature creature){
                creature.modifyMaxMana(5);
                creature.modifyMana(5);
                creature.doAction("look more magical");
            }
        },
        
        new LevelUpOption("Increased hit points"){
            public void invoke(Creature creature){
                creature.modifyMaxHp(10);
                creature.modifyHp(10);
                creature.doAction("look a lot healthier");
            }
        },
        new LevelUpOption("Increased mana regeneration"){
            public void invoke(Creature creature){
                creature.modifyRegenManaPer1000(10);
                creature.doAction("look a little less tired");
            }
        },
        new LevelUpOption("Increased mana"){
            public void invoke(Creature creature) { creature.gainMaxMana(); }
        },
        new LevelUpOption("Increased mana regeneration") {
            public void invoke(Creature creature) { creature.gainRegenMana(); }
        }  
         
    };
    
    public void autoLevelUp(Creature creature){
        options[(int)(Math.random() * options.length)].invoke(creature);
    }
    
    public List<String> getLevelUpOptions(){
        List<String> names = new ArrayList<String>();
        for (LevelUpOption option : options){
            names.add(option.name());
        }
        return names;
    }
    
    public LevelUpOption getLevelUpOption(String name){
        for (LevelUpOption option : options){
            if (option.name().equals(name)){
                return option;
            }
        }
        return null;
    }
}
