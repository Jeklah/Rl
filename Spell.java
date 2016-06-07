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
public class Spell {
    private String name;
    public String name() { return name; }
    
    private int manaCost;
    public int manaCost() { return manaCost; }
    
    private Effect effect;
    public Effect effect() { return new Effect(effect); }
    
    public Spell(String name, int manaCost, Effect effect){
        this.name = name;
        this.manaCost = manaCost;
        this.effect = effect;
    }
}
