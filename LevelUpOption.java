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
public abstract class LevelUpOption {
    private String name;
    public String name() { return name; }
    
    public LevelUpOption(String name){
        this.name = name;
    }
    
    public abstract void invoke(Creature creature);
}
