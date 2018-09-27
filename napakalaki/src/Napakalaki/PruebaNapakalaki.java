/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author marcos
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    
    
    /*//NIVEL DE COMBATE SUPERIOR A 10 = consulta1
   static ArrayList <Monster> consulta1 (ArrayList<Monster> monstruos){
        ArrayList<Monster> aux= new ArrayList();
        for(Monster m: monstruos){
             if( m.getCombatLevel()>10)
             {
                aux.add(m); 
             }
         }
        return aux;
    }
    
       //MAL ROLLO CON PÉRDIDA DE NIVELES SUPERIOR A 1 = consulta2
   static ArrayList <Monster> consulta2 (ArrayList<Monster> monstruos){
        ArrayList<Monster> aux= new ArrayList();
        for(Monster m: monstruos){
             if( m.getBadConsequence().getLevels()>0)
             {
                aux.add(m); 
             }
         }
        return aux;
    }
   
          //BUEN ROLLO CON GANANCIAS DE NIVELES SUPERIOR A 1 = consulta3
   static ArrayList <Monster> consulta3 (ArrayList<Monster> monstruos){
        ArrayList<Monster> aux= new ArrayList();
        for(Monster m: monstruos){
             if( m.getPrize().getLevel()>1)
             {
                aux.add(m); 
             }
         }
        return aux;
    }
   
   //MAL ROLLO CON PERDIDA DE UN TIPO DE TESORO VISIBLE Y/O OCULTOS = consulta4
   static ArrayList <Monster> consulta4 (ArrayList<Monster> monstruos){
        ArrayList<Monster> aux= new ArrayList();
        for(Monster m: monstruos){
             if( !m.getBadConsequence().getTesorosEspecificosVisible().isEmpty() || !m.getBadConsequence().getTesorosEspecificosOcultos().isEmpty() ){
                  aux.add(m);
             }
         }
        return aux;
    }*/
   
    /*public static void main(String[] args) {
        
        ArrayList<Monster> monstruos = new ArrayList();
        ArrayList<Life> life = new ArrayList();
        
        //monstruo 1
        BadConsequence bad = new BadConsequence("Pierdes tu armadura visible y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ARMOR))); 
        Prize prize = new Prize(2,1); 
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, bad, prize));

        
        
         
         System.out.print("\n Los monstrous mayores de nivel 10: "+consulta1(monstruos));
         System.out.print("\n Los monstrous con pérdidas de niveles superior a 1: "+consulta2(monstruos));
         System.out.print("\n Los monstrous con ganancias de niveles superior a 1: "+consulta3(monstruos));
         System.out.print("\n Los monstrous con pérdida de un tipo de tesoro visible y/o oculto: "+consulta4(monstruos));
        
        
        //EXAMEN
        ArrayList<Player> jugadores = new ArrayList();
        jugadores.add(new Player("Marcos"));
        jugadores.add(new Player("Marcos2"));
        //life.add(new Life());
        //life.add(new Life());
        //jugadores.get(0).addFriend(monstruos.get(0));
        //jugadores.get(1).addFriend(monstruos.get(1));
        //jugadores.get(0).addLife(life.get(0));
        //jugadores.get(1).addLife(life.get(1));
        System.out.print("El jugador 1 con nivel de combate:"+jugadores.get(0).getCombatLevel());
        System.out.print("El jugador 1 con nivel de combate:"+jugadores.get(1).getCombatLevel());
        //EXAMEN
    }*/
}
