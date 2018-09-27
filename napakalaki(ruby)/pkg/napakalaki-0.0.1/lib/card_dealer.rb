#encoding: utf-8
#  To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
require 'singleton'
require_relative 'treasure'
require_relative 'monster'
require_relative 'bad_consequence'
require_relative 'prize'
require_relative 'napakalaki'
require_relative 'treasure_kind'
require_relative 'cultist'
require_relative 'specific_bad_consequence'
require_relative 'numeric_bad_consequence'
require_relative 'death_bad_consequence'


class CardDealer
  include Singleton
  
  def initialize()
    @unusedMonsters=Array.new
    @usedMonsters=Array.new
    @usedTreasures=Array.new
    @unusedTreasures=Array.new
    @unusedCultists=Array.new
  end
  
  def initTreasureCardDeck
        @unusedTreasures.push(Treasure.new("¡Sí mi amo!",4,TreasureKind::HELMET))
        @unusedTreasures.push(Treasure.new("Botas de investigación",3,TreasureKind::SHOES))
        @unusedTreasures.push(Treasure.new("Capucha de Cthulhu",3,TreasureKind::HELMET))
        @unusedTreasures.push(Treasure.new("A prueba de babas",2,TreasureKind::ARMOR))
        @unusedTreasures.push(Treasure.new("Botas de lluvia ácida",1,TreasureKind::BOTHHANDS))
        @unusedTreasures.push(Treasure.new("Casco minero",2,TreasureKind::HELMET))
        @unusedTreasures.push(Treasure.new("Ametralladora Thompson",4,TreasureKind::BOTHHANDS))
        @unusedTreasures.push(Treasure.new("Camiseta de la UGR",1,TreasureKind::ARMOR))
        @unusedTreasures.push(Treasure.new("Clavo de rail ferroviario",3,TreasureKind::ONEHAND))
        @unusedTreasures.push(Treasure.new("Cuchillo de sushi arcano",2,TreasureKind::ONEHAND))
        @unusedTreasures.push(Treasure.new("Fez alópodo",3,TreasureKind::HELMET))
        @unusedTreasures.push(Treasure.new("Hacha prehistórica",2,TreasureKind::ONEHAND))
        @unusedTreasures.push(Treasure.new("El aparato del Pr. Tesla",4,TreasureKind::ARMOR))
        @unusedTreasures.push(Treasure.new("Gaita",4,TreasureKind::BOTHHANDS))
        @unusedTreasures.push(Treasure.new("Insecticida",2,TreasureKind::ONEHAND))
        @unusedTreasures.push(Treasure.new("Escopeta de 3 cañones",4,TreasureKind::BOTHHANDS))
        @unusedTreasures.push(Treasure.new("Garabato místico",2,TreasureKind::ONEHAND))
        @unusedTreasures.push(Treasure.new("La rebeca metálica",2,TreasureKind::ARMOR))
        @unusedTreasures.push(Treasure.new("Lanzallamas",4,TreasureKind::BOTHHANDS))
        @unusedTreasures.push(Treasure.new("Necro-comicón",1,TreasureKind::ONEHAND))
        @unusedTreasures.push(Treasure.new("Necronomicón",5,TreasureKind::BOTHHANDS))
        @unusedTreasures.push(Treasure.new("Linterna a 2 manos",3,TreasureKind::BOTHHANDS))
        @unusedTreasures.push(Treasure.new("Necro-gnomicón",2,TreasureKind::ONEHAND))
        @unusedTreasures.push(Treasure.new("Necrotelecom",2,TreasureKind::HELMET))
        @unusedTreasures.push(Treasure.new("Mazo de los antiguos",3,TreasureKind::ONEHAND))
        @unusedTreasures.push(Treasure.new("Necro-playboycón",3,TreasureKind::ONEHAND))
        @unusedTreasures.push(Treasure.new("Porra preternatural",2,TreasureKind::ONEHAND))
        @unusedTreasures.push(Treasure.new("Shogulador",1,TreasureKind::BOTHHANDS))
        @unusedTreasures.push(Treasure.new("Varita de atizamiento",3,TreasureKind::ONEHAND))
        @unusedTreasures.push(Treasure.new("Tentáculo de pega",2,TreasureKind::HELMET))
        @unusedTreasures.push(Treasure.new("Zapato deja-amigos",1,TreasureKind::SHOES))
  end
  
def initMonsterCardDeck()
    #Monstruo 1
price = Prize.new(2,1)
bc = SpecificBadConsequence.new('Pierdes tu armadura visible y otra oculta',
                                                          0,
                                                          [TreasureKind::ARMOR],
                                                          [TreasureKind::ARMOR])
@unusedMonsters.push(Monster.new('3 Byakhess de bonanza', 8, bc, price))

#Monstruo 2

price = Prize.new(1,1)
bc = SpecificBadConsequence.new('Embobados con el lindo primigenio te descartas de tu casco visible',
                                                          0, 
                                                          [TreasureKind::HELMET], 
                                                          Array.new)
@unusedMonsters.push(Monster.new('Chibithulhu', 2, bc,price))

#Monstruo 3

price = Prize.new(1,1)
bc = SpecificBadConsequence.new('El primordial bostezo contagioso. Pierdes el calzado visible', 
                                               0,
                                               [TreasureKind::SHOES],
                                               Array.new)
                                             
@unusedMonsters.push(Monster.new('El sopor de Dunwich', 2, bc, price))

#Monstruo 4
price = Prize.new(4,1)
bc = SpecificBadConsequence.new('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo.
                                               Descarta 1 mano visible y 1 mano oculta', 
                                               0,
                                               [TreasureKind::ONEHAND],
                                               [TreasureKind::ONEHAND])
                                             
@unusedMonsters.push(Monster.new('Ángeles de la noche ibicenca', 14, bc, price))

#Monstruo 5
price = Prize.new(3,1)
bc = NumericBadConsequence.new('Pierdes todos tus tesoros visibles', 
                                               0,
                                               10,
                                               0)
                                             
@unusedMonsters.push(Monster.new('El gorrón en el umbral', 10, bc, price))

#Monstruo 6
price = Prize.new(2,1)
bc = SpecificBadConsequence.new('Pierdes la armadura visible', 
                                               0, 
                                               [TreasureKind::ARMOR], 
                                               Array.new)
                                             
@unusedMonsters.push(Monster.new('H.P. Munchcraft', 6, bc, price))

#Monstruo 7

price = Prize.new(1,1)
bc = SpecificBadConsequence.new('Sientes bichos bajo la ropa. Descarta tu armadura visible',
                                               0,
                                               [TreasureKind::ARMOR],
                                               Array.new)
                                             
@unusedMonsters.push(Monster.new('Bichgooth',2, bc, price))

#Monstruo 8

price = Prize.new(4,2)
bc = NumericBadConsequence.new('Pierdes 5 niveles y 3 tesoros visibles',
                                               5, 
                                               3,
                                               0)
                                             
@unusedMonsters.push(Monster.new('El rey de la rosa',13,bc,price))

#Monstruo 9

price = Prize.new(1,1)
bc = NumericBadConsequence.new('Toses los pulmones y pierdes 2 niveles',
                                               2,
                                               0,
                                               0)
                                             
@unusedMonsters.push(Monster.new('La que redacta en las tinieblas', 2, bc, price))

#Monstruo 10

price = Prize.new(2,1)
bc = DeathBadConsequence.new('Estos monstruos resultan bastante superficiales y te aburren mortalmente.
                                Estas muerto', true)
@unusedMonsters.push(Monster.new('Los hondos', 8, bc, price))

#Monstruo 11

price = Prize.new(2,1)
bc = NumericBadConsequence.new('Pierdes 2 niveles y 2 tesoros ocultos', 
                                                2, 
                                                0, 
                                                2)
                                              
@unusedMonsters.push(Monster.new('Semillas Cthulhu', 4, bc, price))

#Monstruo 12

price = Prize.new(2,1)
bc = SpecificBadConsequence.new('Te intentas escaquear. Pierdes una mano visible', 
                                                0, 
                                                [TreasureKind::ONEHAND], 
                                                Array.new)
                                              
@unusedMonsters.push(Monster.new('Dameargo', 1, bc, price))

#Monstruo 13

price = Prize.new(1, 1)
bc = NumericBadConsequence.new('Da mucho asquito. Pierdes 3 niveles', 
                                                3, 
                                                0, 
                                                0)
                                              
@unusedMonsters.push(Monster.new('Pollipólipo volante', 3, bc, price))

#Monster 14

price = Prize.new(3, 1)
bc= DeathBadConsequence.new('No le hace gracia que pronuncien mal su nombre. Estás Muerto', true)

@unusedMonsters.push(Monster.new('Yskhtihyssg-Goth', 12, bc, price))

#Monstruo 15

price = Prize.new(3,1)
bc = DeathBadConsequence.new('La familia te atrapa. Estás muerto', true)

@unusedMonsters.push(Monster.new('Familia feliz', 1, bc, price))

#Monstruo 16

price = Prize.new(2,1)
bc = SpecificBadConsequence.new('La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles', 
                                                2, 
                                                [TreasureKind::BOTHHANDS], 
                                                Array.new)
                                              
@unusedMonsters.push(Monster.new('Roboggoth', 8, bc, price))

#Monstruo 17

price = Prize.new(1,1)
bc = SpecificBadConsequence.new('Te asusta en la noche. Pierdes un casco visible', 
                                                0, 
                                                [TreasureKind::HELMET], 
                                                Array.new)
                                              
@unusedMonsters.push(Monster.new('El espia', 5, bc, price))

#Monstruo 18

price = Prize.new(1,1)
bc = NumericBadConsequence.new('Menudo susto te llevas. Pierdes 2 nivles y 5 tesoros visibles', 
                                                2, 
                                                5, 
                                                0)
                                              
@unusedMonsters.push(Monster.new('El Lenguas', 20, bc, price))

#Monstruo 19

price = Prize.new(1,1)
bc = SpecificBadConsequence.new('Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos', 
                                                3, 
                                                  [TreasureKind::BOTHHANDS, TreasureKind::ONEHAND, TreasureKind::ONEHAND],
                                                Array.new)

@unusedMonsters.push(Monster.new('Bicéfalo', 20, bc, price))

price = Prize.new(3,1)
bc = SpecificBadConsequence.new('Pierdes 1 mano visible', 
                                                0, 
                                                  [TreasureKind::ONEHAND],
                                                Array.new)

@unusedMonsters.push(Monster.newmonster('El mal indecible impronuncialbe', 10, bc, price, -2))

price = Prize.new(2,1)
bc = NumericBadConsequence.new('Pierdes tus tesoros visibles. Jajaja.', 
                                                0, 
                                                BadConsequence.getMaxTreasures,
                                                0)
@unusedMonsters.push(Monster.newmonster('Testigos Oculares', 6, bc, price, 2))

price = Prize.new(2,5)
bc = DeathBadConsequence.new('Hoy no es tu dia de suerte. Estas muerto', true)

@unusedMonsters.push(Monster.newmonster('El gran cthulhu', 20, bc, price, 4))

price = Prize.new(2,1)
bc = NumericBadConsequence.new('Tu gobierno te recorta 2 niveles', 
                                                2, 
                                                0,
                                                0)
@unusedMonsters.push(Monster.newmonster('Serpiente Político', 8, bc, price, -2))

price = Prize.new(1,1)
bc = SpecificBadConsequence.new('Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas', 
                                                0, 
                                                  [TreasureKind::ARMOR, TreasureKind::HELMET],
                                                [TreasureKind::BOTHHANDS, TreasureKind::BOTHHANDS, TreasureKind::BOTHHANDS])

@unusedMonsters.push(Monster.newmonster('Felpuggoth', 2, bc, price, 5))

price = Prize.new(4,2)
bc = NumericBadConsequence.new('Pierdes 2 niveles.', 
                                                2, 
                                                0,
                                                0)
@unusedMonsters.push(Monster.newmonster('Shoggoth', 16, bc, price, -4))

price = Prize.new(1,1)
bc = NumericBadConsequence.new('Pintalabios negro. Pierdes 2 niveles.', 
                                                2, 
                                                0,
                                                0)
@unusedMonsters.push(Monster.newmonster('Lolitagooth', 2, bc, price, 3))
end
   
  def shuffleTreasures
    @unusedTreasures=@unusedTreasures.shuffle
  end
  
  def shuffleMonsters
    @unusedMonsters=@unusedMonsters.shuffle
  end
  
  def nextTreasure
    if @unusedTreasures.empty?
            @unusedTreasures=@usedTreasures
            shuffleTreasures
            @usedTreasures=Array.new
    end
    aux=@unusedTreasures.first
      @unusedTreasures.delete(aux)
      return aux;
  end
  
  def nextMonster
    if @unusedMonsters.empty?
            @unusedMonsters=@usedMonsters
            shuffleMonsters
            @usedMonsters=Array.new
    end
    aux=@unusedMonsters.first
      @unusedMonsters.delete(aux)
      return aux;
  end
  
  def giveTreasureBack(t)
    @usedTreasures.push(t)
  end
  
  def giveMonsterBack(m)
    @usedMonsters.push(m)
  end
  
  def initCards()
    initTreasureCardDeck
    initMonsterCardDeck
    initCultistCardDeck
    shuffleMonsters
    shuffleTreasures
    shuffleCultist
  end
  
  def shuffleCultist
    @unusedCultists=@unusedCultists.shuffle
  end
  
  def initCultistCardDeck
    @unusedCultists.push(Cultist.new("Sectario", 1))
    @unusedCultists.push(Cultist.new("Sectario", 2))
    @unusedCultists.push(Cultist.new("Sectario", 1))
    @unusedCultists.push(Cultist.new("Sectario", 2))
    @unusedCultists.push(Cultist.new("Sectario", 1))
    @unusedCultists.push(Cultist.new("Sectario", 1))
  end
  
  def nextCultist
    aux=@unusedCultists.at(0)
    @unusedCultists.delete(0)
    return aux;
  end
  
  #def to_s()
   #" \n Tesoros no Usados: #{@unusedTreasures} \n Tesoros descartados: #{@usedTreasures} \n Monstruos no Usados: #{@unusedMonsters} \n Monstruos descartados: #{@usedMonsters} \n "
  #end
  
  private :initTreasureCardDeck, :initMonsterCardDeck, :shuffleTreasures, :shuffleMonsters, :shuffleCultist, :initCultistCardDeck
  
end
end