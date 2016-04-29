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
public class Inventory {
    private Item[] items;
    public Item[] getItems() { return items; }
    public Item getItem(int i) { return items[i]; }
    
    public Inventory(int max){
        items = new Item[max];
    }
    
    public void addItem(Item item){
        for (int i = 0; i < items.length; i++){
            if (items[i] == null){
                items[i] = item;
                break;
            }
        }
    }
    
    public void removeItem(Item item){
        for (int i = 0; i < items.length; i++){
            if (items[i] == item){
                items[i] = null;
                return;
            }
        }
    }
    
    public boolean isFull(){
        int size = 0;
        for (int i = 0; i < items.length; i++){
            if (items[i] != null){
                size++;
            }
        }
        return size == items.length;
    }
    
    public boolean contains(Item item){
        for (Item i : items){
            if (i == item){
                return true;
            }
        }
        return false;
    }
}
