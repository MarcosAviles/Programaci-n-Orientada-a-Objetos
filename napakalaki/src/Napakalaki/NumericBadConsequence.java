/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;


/**
 *
 * @author Marcos
 */
public class NumericBadConsequence extends BadConsequence{
    
    private int nVisibleTreasure;
    private int nHiddenTreasure;
    
    public NumericBadConsequence(String _text, int _levels, int _nVisible, int _nHidden){
        super(_text, _levels);
        nVisibleTreasure=_nVisible;
        nHiddenTreasure=_nHidden;            
    }
    
    public int getNVisibleTreasure(){
        return nVisibleTreasure;
    }
    
    public void setNVisibleTreasure(int x){
        nVisibleTreasure=x;
    }
    
    public int getNHiddenTreasure(){
        return nHiddenTreasure;
    }
    
    public void setNHiddenTreasure(int x){
        nHiddenTreasure=x;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasure!=0){
            nVisibleTreasure=nVisibleTreasure-1;
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasure!=0){
            nHiddenTreasure=nHiddenTreasure-1;
        }
    }
    
    @Override
    public boolean isEmpty(){
       if(nVisibleTreasure == 0 && nHiddenTreasure==0){
           return true;
       }
       else {
           return false;
       }
    }
    
    @Override
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
       NumericBadConsequence resultado = new NumericBadConsequence(super.getTtext(), super.getLevels(), 0,0);
       if(nVisibleTreasure!=0 || nHiddenTreasure!=0){
        if(nVisibleTreasure>v.size()){
            resultado.nVisibleTreasure=v.size();
         }
        else{
         resultado.nVisibleTreasure = this.nVisibleTreasure;
         }
        if(nHiddenTreasure>h.size()){
            resultado.nHiddenTreasure=h.size();
         }
        else{
         resultado.nHiddenTreasure=this.nHiddenTreasure;
         }
       }
       return resultado;
    }
    
    @Override
    public String toString(){
        return "Texto = " + (super.getTtext()) 
                + " Levels = " + Integer.toString(super.getLevels())
                + "nVisibleTreasures = " + Integer.toString(nVisibleTreasure) 
                + " nHiddenTreasures = " + Integer.toString(nHiddenTreasure)
                + "\n";
    }
}
