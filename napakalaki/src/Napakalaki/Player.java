/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Napakalaki;
import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;


/**
 *
 * @author marcos0
 */
public class Player {
    static final int MAXLEVELS = 10;
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    private BadConsequence pendingBadConsequence;
    protected Player enemy;
    private ArrayList<Treasure> visibleTreasure;
    private ArrayList<Treasure> hiddenTreasure;
    
    
    public Player(String _name){
        name=_name;
        level=1;
        dead=true;
        canISteal=true;
        pendingBadConsequence=null;
        enemy=null;
        visibleTreasure=new ArrayList();
        hiddenTreasure=new ArrayList();
    }
    
    public Player(Player p){
        name=p.name;
        level=p.level;
        dead=p.dead;
        canISteal=p.canISteal;
        pendingBadConsequence=p.pendingBadConsequence;
        enemy=p.enemy;
        visibleTreasure=p.visibleTreasure;
        hiddenTreasure=p.hiddenTreasure;
        
    }
  
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        dead = false;
    }
    
    protected int getCombatLevel(){ 
        int result=level;
        for (Treasure t: visibleTreasure){
            result+=t.getBonus();
        }
        return result;
    }
    
    public int getNivelCombate(){
        int aux=this.getCombatLevel();
        return aux;
    }
    
    private void incrementLevels(int l){
        if(level+l<=MAXLEVELS){
            level = level + l;
        }
        else{
            level=MAXLEVELS;
        }
    }
    
    protected void decrementLevels(int l){
        if(level-l>=0){
            level = level - l;
        }
        else {
            level=1;
            //dead=true;
        }
    }
    
    //EXAMEN
    public int quitarNivelesEnemigo(ArrayList<Treasure> selOcultos){
        int puntos=0;
        for(Treasure t : selOcultos){
            puntos+=t.getBonus();
        }
        if(puntos>5){
           puntos=4;
        }
        this.enemy.decrementLevels(puntos);
        return puntos;
    }
    //FIN EXAMEN
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b; 
    }
    
    public BadConsequence getPendingBadConsequence(){
        return pendingBadConsequence;
    }
    private void applyPrize(Monster m){
        int nLevels=m.getLevelsGained();
        this.incrementLevels(nLevels);
        int nTreasures=m.getTreasuresGained();
        if(nTreasures>0){
            CardDealer dealer=CardDealer.getInstance();
            for(int i=0; i<nTreasures; i++){
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasure.add(treasure);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence bc = m.getBadConsequence();
        int nLevels = bc.getLevels();
        this.decrementLevels(nLevels);
        BadConsequence pendingBad = bc.adjustToFitTreasureList(visibleTreasure, hiddenTreasure);
        this.setPendingBadConsequence(pendingBad);
    }
    
    protected boolean canMakeTreasureVisible(Treasure t){
        int aux=0;
        boolean resultado=true;
        boolean tiene_dosmanos=false;
        for(Treasure v: visibleTreasure){
            if(v.getType()==TreasureKind.BOTHHANDS){
                tiene_dosmanos=true;
            }
            if(v.getType()==t.getType()){
                resultado=false;
            }
            if(v.getType()==TreasureKind.ONEHAND){
                aux++;
            }
        }
        if(t.getType()==TreasureKind.ONEHAND && aux<2){
            if(tiene_dosmanos==true){
                resultado=false;
            }
            else{
                resultado=true;
            }
        }
        if(aux>=1 && t.getType()==TreasureKind.BOTHHANDS){
            resultado=false;
        }
        return resultado;
    }
    
    private int howManyVisibleTreasure(TreasureKind tkind){
        int contador=0;
        for(Treasure t: visibleTreasure){
            if(t.getType()== tkind){
                contador++;
            }
        }
        return contador;
    }
    
    private void dieIfNoTreasures(){
        if(visibleTreasure.isEmpty() && hiddenTreasure.isEmpty()){
            dead=true;
        }
            
    }
    
    public boolean isDead(){
        return dead;     
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasure;
    }
        
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasure;
    }
    
    public CombatResult combat(Monster m){
        CombatResult aux;
        int myLevel = this.getCombatLevel();
        int monsterLevel = this.getOponentLevel(m);
        if(this.getLevels()>=MAXLEVELS){
            aux= CombatResult.WINGAME;
        }
        else if(myLevel>monsterLevel){
            this.applyPrize(m);
            aux = CombatResult.WIN;
            
        }
        else{
            this.applyBadConsequence(m);
            if(this.shouldConvert()){
                aux=CombatResult.LOSEANDCONVERT;
            }
            else{
                aux = CombatResult.LOSE;
            }
        }
        return aux;
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canl = this.canMakeTreasureVisible(t);
        if(canl){
            visibleTreasure.add(t);
            hiddenTreasure.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasure.remove(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        this.dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasure.remove(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        this.dieIfNoTreasures();
    }
    
    public boolean validState(){
        boolean aux=true;
        if (pendingBadConsequence!=null){
            if(!pendingBadConsequence.isEmpty()){ 
                aux=false;
            }
        }
        if(hiddenTreasure.size()>4){
            aux=false;
        }
        return aux;
    }
    
    public void initTreasures(){
       CardDealer dealer = CardDealer.getInstance();
       Dice dice=Dice.getInstance();
       this.bringToLife();
       Treasure treasure = dealer.nextTreasure();
       hiddenTreasure.add(treasure);
       int number = dice.nextNumber("Tira para conseguir los tesoros","1->1 tesoro, mayor que 1->2 tesoros, 6->3 tesoros");
       if(number>1){
           treasure=dealer.nextTreasure();
           hiddenTreasure.add(treasure);
       }
       if(number==6){
           treasure = dealer.nextTreasure();
           hiddenTreasure.add(treasure);
       }
    }
    
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
        boolean canl = this.canISteal();
        boolean canYou;
        Treasure treasure;
        if(canl){
            canYou = enemy.canYouGiveMeATreasure();
            if(canYou){
                treasure = enemy.giveMeATreasure();
                hiddenTreasure.add(treasure);
                this.haveStolen();
                return treasure;
            }
        }
        return null;
    }
    
    public void setEnemy(Player _enemy){
        enemy=_enemy;
    }
    
    protected Treasure giveMeATreasure(){
        Random generator=new Random();
        int aux=(generator.nextInt(hiddenTreasure.size()));
        return hiddenTreasure.get(aux);
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    protected boolean canYouGiveMeATreasure(){
        if(hiddenTreasure.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    
    private void haveStolen(){
        canISteal=false;
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> auxVisibleTreasure =new ArrayList(visibleTreasure);
        ArrayList<Treasure> auxHiddenTreasure =new ArrayList(hiddenTreasure);
        for(Treasure t: auxVisibleTreasure){
            this.discardVisibleTreasure(t);
        }
        for(Treasure x: auxHiddenTreasure){
            this.discardHiddenTreasure(x);
        }
    }
   
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        Dice dice=Dice.getInstance();
        int number =dice.nextNumber("Tira el dado para convertirte en sectario","Si sale 1 te conviertes!!");
        if(number==1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Player getEnemy(){
        return enemy;
    }
    
    @Override
    public String toString(){
        return "Nombre del jugador = " + (name) + "\n "
                + " Nivel del Jugador = " + Integer.toString(level) + "\n "
                + "Muerte  = " + dead +"\n "
                + "Mal rollo pendiente = " + pendingBadConsequence +"\n "
                + "Enemigo = " + enemy.getName() + "\n "
                + "Tesoros Visibles = " + visibleTreasure +"\n "
                + "Tesoros Ocultos = " + hiddenTreasure + " "
                + "\n";
          
    }
}
