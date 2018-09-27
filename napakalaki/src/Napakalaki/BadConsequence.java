/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;

/**
 *
 * @author javi
 */
public abstract class BadConsequence {
    static final int MAXTREASURES = 10;
    private String text;
    private int levels;
    
    public BadConsequence(String _text, int _levels){
        text=_text;
        levels=_levels;
    }
    
    public String getTtext(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    public abstract BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h);
    public abstract boolean isEmpty();
    public abstract void substractHiddenTreasure(Treasure t);
    public abstract void substractVisibleTreasure(Treasure t);
    
     
    
    @Override
    public String toString(){
        return "Texts = " + (text) 
                + " Levels = " + Integer.toString(levels)
                + "\n";
    }
    
}
