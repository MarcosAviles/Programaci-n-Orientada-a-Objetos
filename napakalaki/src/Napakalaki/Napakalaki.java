/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author marcos
 */
public class Napakalaki {
    
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    private Monster currentMonster;
    private static final Napakalaki INSTANCE = new Napakalaki();
    
    private Napakalaki() {
        players = new ArrayList();
        currentMonster= null;
        currentPlayer = null;
        dealer=CardDealer.getInstance();
    }
    
    public static Napakalaki getInstance() {
        return INSTANCE;
    }
       
    private void initPlayers( ArrayList<String> names){ 
        players.add(new PlayerBlindado(names.get(0)));
        for (int i=1; i<names.size(); i++) {
            players.add(new Player(names.get(i)));
        }
        
    }
    
    private Player nextPlayer(){
        Player aux;
        Random generator=new Random();
        if(currentPlayer==null){
                aux= players.get(generator.nextInt(players.size()));
        }
        else{
            if(players.get(players.size()-1)==currentPlayer){
                aux= players.get(0);
            }
            else{
                int indice=players.indexOf(currentPlayer);
                aux = players.get(indice+1);
            }
        }
        return aux;
    }
    
    private boolean nextTurnAllowed(){
        if(currentPlayer==null){
            return true;
        }
        else{
            return currentPlayer.validState();
        }
    }
    
    private void setEnemies(){
        Random generator=new Random();
        int numeroJugadores=players.size();
        int indice;
            for(int i=0; i<numeroJugadores; i++){
                indice = (generator.nextInt(numeroJugadores));
                if(i != indice){
                  players.get(i).setEnemy(players.get(indice));
                }
                else{
                    i--;
                }
        }
        
    }
    
    public CombatResult developCombat(){
        CombatResult aux = currentPlayer.combat(currentMonster);
        if(aux==CombatResult.LOSEANDCONVERT){
            Cultist c=dealer.nextCultist();
            CultistPlayer cp=new CultistPlayer(currentPlayer,c);
            int indice=players.indexOf(currentPlayer);
            players.set(indice, cp);
            
            for(Player p: players){
                if(p.getEnemy()==currentPlayer){
                    p.setEnemy(cp);
                }
            }
            currentPlayer=cp;
        }
        dealer.giveMonsterBack(currentMonster);
        return aux;
    }
    
    public void discardVisibleTreasure(ArrayList<Treasure> treasures){
        for(Treasure t: treasures){
            currentPlayer.discardVisibleTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    
    public void discardHiddenTreasure(ArrayList<Treasure> treasures){
        for(Treasure t: treasures){
            currentPlayer.discardHiddenTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure t:treasures){
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    public void initGame(ArrayList<String> names){
        this.initPlayers(names);
        this.setEnemies();
        dealer.initCards();
        this.nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK, dead;
        stateOK=this.nextTurnAllowed();
        if(stateOK){
            currentMonster=dealer.nextMonster();
            currentPlayer=this.nextPlayer();
            dead=currentPlayer.isDead();
            if(dead){
              currentPlayer.initTreasures();
            }
        }
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return result==CombatResult.WINGAME;
    }

    public String toString(){
        return "Jugador Actual = " + currentPlayer
                + " Jugadores = " + players
                + " Mazo de cartas = " + dealer
                + " Monstruo actual = " + currentMonster
                + "\n";
    }
    
    
}
