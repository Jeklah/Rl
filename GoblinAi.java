/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut;

import java.util.List;


/**
 *
 * @author arthur
 */
public class GoblinAi extends CreatureAi {
    private Creature player;
    
    public GoblinAi(Creature creature, Creature player){
        super(creature);
        this.player = player;
    }
    
    public void onUpdate(){
        if (creature.canSee(player.x, player.y, player.z)){
            hunt(player);
        } else { 
            wander();
        }
    }
    
    public void hunt(Creature target){
        List<Point> points = new Path(creature, target.x, target.y).points();
        
        int mx = points.get(0).x - creature.x;
        int my = points.get(0).y - creature.y;
        
        creature.moveBy(mx, my, 0);
    }
    
    private boolean canRangedWeaponAttack(Creature other){
        return creature.weapon() != null
                && creature.weapon().rangedAttackValue() > 0
                && creature.canSee(other.x, other.y, other.z);
    }
    
    private boolean canThrowAt(Creature other){
        return creature.canSee(other.x, other.y, other.z)
                && getWeaponToThrow() != null;
    }
    
    private Item getWeaponToThrow(){
        Item toThrow = null;
        
        for (Item item : creature.inventory().getItems()){
            if (item == null || creature.weapon() == item || creature.armour() == item){
                continue;
            }
            
            if (toThrow == null || item.thrownAttackValue() > toThrow.attackValue()){
                toThrow = item;
            }
        }
        
        return toThrow;
    }
    
    private boolean canPickup(){
        return creature.item(creature.x, creature.y, creature.z) != null
                && !creature.inventory().isFull();
    }
    
    protected boolean canUseBetterEquipment(){
        int currentWeaponRating = creature.weapon() == null ? 0 : creature.weapon().attackValue() + creature.weapon().rangedAttackValue();
        int currentArmourRating = creature.armour() == null ? 0 : creature.armour().defenseValue();
        
        for (Item item : creature.inventory().getItems()){
            if (item == null){
                continue;
            }
            
            boolean isArmour = item.attackValue() + item.rangedAttackValue() < item.defenseValue();
            if (item.attackValue() + item.rangedAttackValue() > currentWeaponRating
                    || isArmour && item.defenseValue() > currentArmourRating){
                return true;
            }
        }
        return false;
    }
    
    protected void useBetterEquipment(){
        int currentWeaponRating = creature.weapon() == null ? 0 : creature.weapon().attackValue() + creature.weapon().rangedAttackValue();
        int currentArmourRating = creature.armour() == null ? 0 : creature.armour().defenseValue();
        
        for (Item item : creature.inventory().getItems()){
            if (item == null){
                continue;
            }
            boolean isArmour = item.attackValue() + item.rangedAttackValue() < item.defenseValue();
            
            if (item.attackValue() + item.rangedAttackValue() > currentWeaponRating
                    || isArmour && item.defenseValue() > currentArmourRating){
                creature.equip(item);
            }
        }
        
    }
}
