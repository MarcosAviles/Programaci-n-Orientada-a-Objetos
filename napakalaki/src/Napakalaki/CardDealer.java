/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author marcos
 */
public class CardDealer {
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private static final CardDealer INSTANCE = new CardDealer();
    private ArrayList<Cultist> unusedCultists;
    
    private CardDealer() {
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        unusedCultists = new ArrayList();
    }
    
    public static CardDealer getInstance() {
        return INSTANCE;
    }
    
    
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Si mi amo!",4,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigacion",3,TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia acida",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la UGR",1,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alopodo",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistorica",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla",4,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato mistico",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metalica",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro comicon",1,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicon",5,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos",3,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicon",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro playboycon",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentaculo de pega",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos",1,TreasureKind.SHOES));    
        
    }
    
    private void initMonsterCardDeck(){
        //montruo 1
        BadConsequence bad;
        bad = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ARMOR))); 
        Prize prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, bad, prize, 0));
        //monstruo 2
        bad = new SpecificBadConsequence ("Embobados con el lindo primigenio te descartas de tu casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, bad, prize, 0));
        
        //monstruo3
        bad = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible",0,new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList()); 
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bad, prize, 0));
        
        //monstruo 4
        bad= new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND))); 
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, bad, prize, 0));
        
        //monstruo 5
        bad = new NumericBadConsequence("Pierdes todos tus tesoros visibles",0,BadConsequence.MAXTREASURES,0); 
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorron en el umbral", 10, bad, prize, 0));
        
        //monstruo 6
        bad = new SpecificBadConsequence("Pierdes la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList()); 
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, bad, prize, 0));
        
        //monstruo 7
        bad = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList()); 
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, bad, prize, 0));
        
        //monstruo 8
        bad = new NumericBadConsequence("Pierdes 5 nivles y 3 tesoros visibles",5,3,0); 
        prize= new Prize(1,2);
        unusedMonsters.add(new Monster("El rey de la rosa", 13, bad, prize,0));
        
        //monstruo 9
        bad = new NumericBadConsequence("Toses dos pulmones y pierdes dos niveles",2,0,0); 
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, bad, prize, 0));
        
        //Monster10
         bad=new DeathBadConsequence("Estos monstruos resultan bastantes superficiales y te aburren mortalmente. Estas muerto",true);
         prize=new Prize(2,1);
         unusedMonsters.add(new Monster("Los hondos",8, bad, prize, 0));

        //Monster11
         bad=new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
         prize=new Prize(2,1);
         unusedMonsters.add(new Monster("Semillas Cthulhu",4, bad, prize, 0));

        //Monster12
         bad=new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
         prize=new Prize(2,1);
         unusedMonsters.add(new Monster("Dameargo",1, bad, prize, 0));
         
        //Monster13
         bad=new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles",3,0,0);
         prize=new Prize(1,1);
         unusedMonsters.add(new Monster("Pollipolipo volante",3, bad, prize, 0));
         
        //Monster14
         bad=new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto",true);
         prize=new Prize(3,1);
         unusedMonsters.add(new Monster("YskhtihyssgGoth",12, bad, prize, 0));
  
        //Monster15
         bad=new DeathBadConsequence("La familia te atrapa. Estas muerto",true);
         prize=new Prize(4,1);
         unusedMonsters.add(new Monster("Familia feliz",1, bad, prize, 0));

        //Monster16
         bad=new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList());
         prize=new Prize(2,1);
         unusedMonsters.add(new Monster("Roboggoth",8, bad, prize, 0));

        //Monster17
         bad=new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());
         prize=new Prize(1,1);
         unusedMonsters.add(new Monster("El espia",5, bad, prize, 0));
         
        //Monster18
         bad=new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesotos visibles",2,5,0);
         prize=new Prize(1,1);
         unusedMonsters.add(new Monster("El lenguas",20, bad, prize, 0));
         
        //Monster19
         bad=new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3,new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),new ArrayList());
         prize=new Prize(1,1);
         unusedMonsters.add(new Monster("Bicefalo",20, bad, prize, 0));
         
         bad=new SpecificBadConsequence("Pierdes 1 mano visible",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
         prize=new Prize(3,1);
         unusedMonsters.add(new Monster("El mal indecible impronunciable",10,bad,prize,-2));
         
         bad = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.",0,BadConsequence.MAXTREASURES,0);
         prize=new Prize(2,1);
         unusedMonsters.add(new Monster("Testigos Oculares",6,bad,prize,2));
         
         bad=new DeathBadConsequence("Hoy no es tu día de suerte. Mueres.",true);
         prize=new Prize(2,5);
         unusedMonsters.add(new Monster("El gran cthulhu",20, bad, prize,4));
         
         bad=new NumericBadConsequence("Tu gobierno te recorta 2 niveles",2,0,0);
         prize=new Prize(2,1);
         unusedMonsters.add(new Monster("Serpiente politico",8, bad, prize, -2));
         
         bad=new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas",0,new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND, TreasureKind.ONEHAND)));
         prize=new Prize(1,1);
         unusedMonsters.add(new Monster("Felpuggoth",2, bad, prize,5));
         
         bad=new NumericBadConsequence("Pierdes 2 niveles",2,0,0);
         prize=new Prize(4,2);
         unusedMonsters.add(new Monster("Shoggoth",16, bad, prize, -4));
         
         bad=new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles",2,0,0);
         prize=new Prize(1,1);
         unusedMonsters.add(new Monster("Lolitagooth",2, bad, prize, 3));
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonster(){
        Collections.shuffle(unusedMonsters);
    }
    
    public Treasure nextTreasure(){
        if(unusedTreasures.isEmpty()){
            unusedTreasures=usedTreasures;
            this.shuffleTreasures();
            usedTreasures=new ArrayList();
        }
        Treasure aux=unusedTreasures.get(0);
        unusedTreasures.remove(0);
        return aux;
    }
    
    public Monster nextMonster(){
        if(unusedMonsters.isEmpty()){
            unusedMonsters=usedMonsters;
            this.shuffleMonster();
            usedMonsters=new ArrayList();
        }
        Monster aux=unusedMonsters.get(0);
        unusedMonsters.remove(0);
        return aux;
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
       this.initTreasureCardDeck();
       this.initMonsterCardDeck();
       this.initCultistCardDeck();
       this.shuffleMonster();
       this.shuffleTreasures();
       this.shuffleCultists();
    }
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    
    private void initCultistCardDeck(){
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 2));
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 2));
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 1));
        
    }
    
    public Cultist nextCultist(){
        Cultist aux=unusedCultists.get(0);
        unusedCultists.remove(0);
        return aux;
    }

    public String toString(){
        return "Cartas de tesoros no usados = " + unusedTreasures
                + " Cartas de Tesoros descartados = " + usedTreasures
                + " Cartas de mosntruos no usadas = " + unusedMonsters
                + " Cartas de monstruos descartadas = " + usedMonsters 
                + "\n";
    }
    
    
}
