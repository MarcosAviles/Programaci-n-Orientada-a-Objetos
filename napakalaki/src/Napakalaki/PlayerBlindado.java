/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//EXAMEN
package Napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class PlayerBlindado extends Player {
    
    public PlayerBlindado(String _name) {
        super(_name);
    }
    
    @Override
    protected boolean canMakeTreasureVisible(Treasure t){
        boolean aux;
        if(t.getType()==TreasureKind.ARMOR){
            aux=true;
        }
        else{
            aux=super.canMakeTreasureVisible(t);
        }
        return aux;
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    protected int getCombatLevel(){
        int aux=super.getCombatLevel();
        int numero=0;
        for(Treasure t : super.getVisibleTreasures()){
            if(t.getType()==TreasureKind.ARMOR){
                numero++;
            }
        }
        aux*=numero;
        return aux;
    }
    
    @Override
    public int quitarNivelesEnemigo(ArrayList<Treasure> selOcultos){
        int puntos=0;
        for(Treasure t : selOcultos){
            if(t.getType()==TreasureKind.ARMOR){
                
            }
            else{
                puntos+=t.getBonus();
            }
        }
        if(puntos>5){
           puntos=4;
        }
        super.decrementLevels(puntos);
        return puntos;
    }
    
}

// FIN EXAMEN