/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut;

import asciiPanel.AsciiPanel;
import java.util.List;
import rltut.Item;
/**
 *
 * @author arthur
 */
public class StuffFactory {
    private World world;
      
    public StuffFactory(World world){
        this.world = world;
    }
    
    public Creature newPlayer(List<String> messages, FieldOfView fov){
        Creature player = new Creature(world, '@', AsciiPanel.brightWhite, 100, 20, 5, "player");
        world.addAtEmptyLocation(player, 0);
        new PlayerAi(player, messages, fov);
        return player;
    }
    
    public Creature newFungus(int depth){
        Creature fungus = new Creature(world, 'f', AsciiPanel.green, 10, 0, 0, "Fungus");
        world.addAtEmptyLocation(fungus, depth);
        new FungusAi(fungus, this);
        return fungus;
    }
    
    public Creature newBat(int depth){
        Creature bat = new Creature(world, 'b', AsciiPanel.yellow, 15, 5, 0, "Bat");
        world.addAtEmptyLocation(bat, depth);
        new BatAi(bat);
        return bat;
    }
    
    public Item newRock(int depth){
        Item rock = new Item(',', AsciiPanel.yellow, "rock");
        world.addAtEmptyLocation(rock, depth);
        return rock;
    }
    
    public Item newVictoryItem(int depth){
        Item item = new Item('*', AsciiPanel.brightWhite, "teddy bear");
        world.addAtEmptyLocation(item, depth);
        return item;
    }
    
    public Item newBread(int depth){
        Item item = new Item('e', AsciiPanel.yellow, "bread");
        item.modifyFoodValue(200);
        world.addAtEmptyLocation(item, depth);
        return item;
    }
    
    public Item newFruit(int depth){
        Item item = new  Item('&', AsciiPanel.brightRed, "apple");
        item.modifyFoodValue(100);
        world.addAtEmptyLocation(item, depth);
        return item;
    }
    
    public Item newDagger(int depth){
        Item item = new Item('!', AsciiPanel.white, "dagger");
        item.modifyAttackValue(5);
        world.addAtEmptyLocation(item, depth);
        return item;
    }
    
    public Item newSword(int depth){
        Item item = new Item('|', AsciiPanel.brightWhite, "sword");
        item.modifyAttackValue(10);
        world.addAtEmptyLocation(item, depth);
        return item;
    }
    
    public Item newStaff(int depth){
        Item item = new Item('ƪ', AsciiPanel.yellow, "staff");
        item.modifyAttackValue(5);
        item.modifyDefenseValue(3);
        world.addAtEmptyLocation(item, depth);
        return item;        
    }
    
    public Item newLightArmour(int depth){
        Item item = new Item('[', AsciiPanel.green, "tunic");
        item.modifyDefenseValue(2);
        world.addAtEmptyLocation(item, depth);
        return item;
    }
    
    public Item newMediumArmour(int depth){
        Item item = new Item('[', AsciiPanel.white, "chainmail");
        item.modifyDefenseValue(4);
        world.addAtEmptyLocation(item, depth);
        return item;        
    }
    
    public Item newHeavyArmour(int depth){
        Item item = new Item('[', AsciiPanel.brightWhite, "platemail");
        item.modifyDefenseValue(6);
        world.addAtEmptyLocation(item, depth);
        return item;
    }
    
    public Item randomWeapon(int depth){
        switch ((int)(Math.random() * 3)) {
            case 0: return newDagger(depth);
            case 1: return newSword(depth);
            default: return newStaff(depth);
        }
    }
    
    public Item randomArmour(int depth){
        switch ((int)(Math.random() * 3)){
            case 0: return newLightArmour(depth);
            case 1: return newMediumArmour(depth);
            default: return newHeavyArmour(depth);
        }
    }
    
    public Item newEdibleWeapon(int depth){
        Item item = new Item(')', AsciiPanel.yellow, "baguette");
        item.modifyAttackValue(3);
        item.modifyFoodValue(50);
        world.addAtEmptyLocation(item, depth);
        return item;
    }
    
    public Creature newZombie(int depth, Creature player){
        Creature zombie = new Creature(world, 'z', AsciiPanel.white, 50, 10, 10, "zombie");
        world.addAtEmptyLocation(zombie, depth);
        new ZombieAi(zombie, player);
        return zombie;
    }
}
