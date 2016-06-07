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
public class Effect {
    protected int duration;
    
    public boolean isDone() { return duration < 1; }
    
    public Effect(int duration){
        this.duration = duration;
    }
    
    public Effect(Effect other){
        this.duration = other.duration;
    }
    
    public void update(Creature creature){
        duration--;
    }
    
    public void start(Creature creature){
        
    }
    
    public void end(Creature creature){
        
    }
}
