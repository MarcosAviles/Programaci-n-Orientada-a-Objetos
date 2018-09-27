/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.Random;

/**
 *
 * @author Marcos
 */
public class CultistPlayer extends Player {
    public static int totalCultistPlayers=0;
    public Cultist myCultistCard;

    public CultistPlayer(String _name) {
        super(_name);
    }
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard=c;
        totalCultistPlayers=totalCultistPlayers+1;
    }
    
    public Cultist getCultistPlayer(){
        return myCultistCard;
    }
    
    @Override
    protected int getCombatLevel(){
        int aux=super.getCombatLevel();
        aux=(int) (aux+(0.2*aux));
        aux=aux+(myCultistCard.getGainedLevels()*totalCultistPlayers);
        return aux;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return true;
    }
    
    @Override
    protected Treasure giveMeATreasure(){
        Random generator=new Random();
        int aleatorio=super.getVisibleTreasures().size();
        aleatorio=(generator.nextInt(aleatorio));
        return super.getVisibleTreasures().get(aleatorio);
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        if(enemy.getVisibleTreasures().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    
    public int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
}
