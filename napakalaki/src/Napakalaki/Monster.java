/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

/**
 *
 * @author marcos
 */
public class Monster {
    private String name;
    private int combatLevel;
    private Prize price;
    private BadConsequence bc;
    private int levelChangeAgainstCultisPlayer;
    
    
    public Monster (String _name, int level, BadConsequence _bc, Prize _price ){
        name=_name;
        combatLevel=level;
        price=_price;
        bc=_bc;
        levelChangeAgainstCultisPlayer=0;
    }
    
    public Monster(String n, int l, BadConsequence _bc, Prize p, int IC){
        name=n;
        combatLevel=l;
        bc=_bc;
        price=p;
        levelChangeAgainstCultisPlayer=IC;
    }
    
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return bc;
    }
    
    public Prize getPrize(){
        return price;
    }
    
    public int getLevelsGained(){
        return price.getLevel();
    }
    
    public int getTreasuresGained(){
        return price.getTreasure();
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return combatLevel+levelChangeAgainstCultisPlayer;
    }
    
    
    @Override
    public String toString(){
        return "Names = " + (name) + "\n "
                + " combatLevels = " + Integer.toString(combatLevel)+"\n "
                + "Prices = " + price.toString()+"\n " 
                + "BadConsequences = " + bc.toString() +"\n " 
                + "\n";
    }
    
    
}