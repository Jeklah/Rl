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
        Item item = new Item('|', AsciiPanel.yellow, "bread");
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
        Item item = new Item(')', AsciiPanel.white, "dagger");
        item.modifyAttackValue(5);
        world.addAtEmptyLocation(item, depth);
        return item;
    }
    
    public Item newSword(int depth){
        Item item = new Item(')', AsciiPanel.brightWhite, "sword");
        item.modifyAttackValue(10);
        world.addAtEmptyLocation(item, depth);
        return item;
    }
    
    public Item newStaff(int depth){
        Item item = new Item(')', AsciiPanel.yellow, "staff");
        item.modifyAttackValue(5);
        item.modifyDefenseValue(3);
        world.addAtEmptyLocation(item, depth);
        return item;
        
        
    }
}
