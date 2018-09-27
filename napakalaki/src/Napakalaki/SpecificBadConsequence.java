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
public class SpecificBadConsequence extends BadConsequence{
    
    private ArrayList<TreasureKind> specificHiddenTreasure= new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasure= new ArrayList();
    
    public SpecificBadConsequence(String _text, int _levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super(_text, _levels);
        specificHiddenTreasure=tVisible;
        specificVisibleTreasure=tHidden;
    }
    
    public ArrayList<TreasureKind> getTesorosEspecificosVisible(){
        return specificVisibleTreasure;
    }
    
    public ArrayList<TreasureKind> getTesorosEspecificosOcultos(){
        return specificHiddenTreasure;
    }
    
    @Override
    public boolean isEmpty(){
       if(specificVisibleTreasure.isEmpty() && specificHiddenTreasure.isEmpty()){
           return true;
       }
       else {
           return false;
       }
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(!specificVisibleTreasure.isEmpty()){
            specificVisibleTreasure.remove(t.getType());
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(specificHiddenTreasure.isEmpty()){
            specificHiddenTreasure.remove(t.getType());
        }
    }
    
    @Override
    public SpecificBadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
       SpecificBadConsequence resultado = new SpecificBadConsequence(super.getTtext(), super.getLevels(), new ArrayList(), new ArrayList());
       if(this.specificHiddenTreasure.size()>0){
            for(int i=0; i<this.specificHiddenTreasure.size(); i++){
             for(int j=0;j<h.size();j++){
                 if(this.specificHiddenTreasure.get(i)==h.get(j).getType()){
                       resultado.specificHiddenTreasure.add(this.specificHiddenTreasure.get(i));
                    }
             }
            }
        }
        if(this.specificVisibleTreasure.size()>0){
         for(int i=0;i<this.specificVisibleTreasure.size();i++){
             for(int j=0;j<v.size();j++){
                  if(this.specificVisibleTreasure.get(i)==v.get(j).getType()){
                     resultado.specificVisibleTreasure.add(this.specificVisibleTreasure.get(i));
                    }
             }
            }
        }
        return resultado;
    }
    
    @Override
    public String toString(){
        return "Texto = " + (super.getTtext())
                + " Levels = " + Integer.toString(super.getLevels())
                + "spedificHiddenTreasures = " + specificHiddenTreasure
                + " spedificVisibleTreasure = " + specificVisibleTreasure
                + "\n";
    }
}
