/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut.screens;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import rltut.Creature;
import rltut.Item;
import asciiPanel.AsciiPanel;
/**
 *
 * @author arthur
 */
public abstract class InventoryBasedScreen implements Screen {
    protected Creature player;
    private String letters;
    
    protected abstract String getVerb();
    protected abstract boolean isAcceptable(Item item);
    protected abstract Screen use(Item item);
    
    public InventoryBasedScreen(Creature player){
        this.player = player;
        this.letters = "abcdefghijklmnopqrstuvwxyz";
    }
    
    public void displayOutput(AsciiPanel terminal) {
        ArrayList<String> lines = getList();
        
        int y = 23 - lines.size();
        int x = 4;
        
        if (lines.size() > 3){
            terminal.clear(' ', x, y, 20, lines.size());
        }
        
        for (String line : lines){
            terminal.write(line, x, y++);
        }
        
        terminal.clear(' ', 0, 23, 80, 1);
        terminal.write("What would you like to " + getVerb() + "?", 2, 23);
        terminal.repaint();
    }
    
    private ArrayList<String> getList(){
        ArrayList<String> lines = new ArrayList<String>();
        Item[] inventory = player.inventory().getItems();
        
        for (int i = 0; i < inventory.length; i++){
            Item item = inventory[i];
            
            if (item == null || !isAcceptable(item)){
                continue;
            }
            
            String line = letters.charAt(i) + " - " + item.glyph() + " " + item.name();
            lines.add(line);
        }
        return lines;
    }
    
    public Screen respondToUserInput(KeyEvent key){
        char c = key.getKeyChar();
        
        Item[] items = player.inventory().getItems();
        
        if (letters.indexOf(c) > -1 && 
            items.length > letters.indexOf(letters) &&
            items[letters.indexOf(c)] != null &&
            isAcceptable(items[letters.indexOf(c)])){
                return use(items[letters.indexOf(c)]);
        } else if (key.getKeyCode() == KeyEvent.VK_ESCAPE){
                return null;
        } else {
                return this;
        }
    }
}
