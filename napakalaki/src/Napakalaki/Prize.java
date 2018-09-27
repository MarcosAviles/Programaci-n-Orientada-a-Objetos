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
public class Prize {
    private int treasure;
    private int level;
       
      
    public Prize(int _treasure, int _level){
            treasure=_treasure;
            level=_level;
        }
        
    public int getTreasure(){
            return treasure;
        }
        
    public int getLevel(){
            return level;
        }

    public String toString(){
        return "Numero de tesoros = " + Integer.toString(treasure) + " "
                + " Niveles obtenidos = " + Integer.toString(level)+" "
                + "\n";

    }
        
    
}
