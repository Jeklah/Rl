/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut;

import asciiPanel.AsciiPanel;
import java.util.List;
/**
 *
 * @author arthur
 */
public class CreatureFactory {
    private World world;
      
    public CreatureFactory(World world){
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
}
