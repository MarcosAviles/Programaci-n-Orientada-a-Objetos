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
public class DeathBadConsequence extends NumericBadConsequence{
    
    private boolean death;
    
    public DeathBadConsequence(String _text, boolean _death){
        super(_text, Player.MAXLEVELS, BadConsequence.MAXTREASURES, BadConsequence.MAXTREASURES);
        death=_death;
    }
    
    public boolean getDeath(){
        return death;
    }
    
    @Override
    public String toString(){
        return "Muerte = " + death
                + "\n";
    }
}
