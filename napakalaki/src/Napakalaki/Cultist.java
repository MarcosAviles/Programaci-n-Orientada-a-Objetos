/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

/**
 *
 * @author Marcos
 */
public class Cultist {
    private String name;
    private int gainedLevels;

    public Cultist(String _name, int _gainedLevels){
        name=_name;
        gainedLevels=_gainedLevels;
    }
    
    public int getGainedLevels(){
        return gainedLevels;
    }
}
