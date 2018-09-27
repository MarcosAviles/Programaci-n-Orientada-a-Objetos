#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
require_relative 'treasure'
require_relative 'combat_result'
require_relative 'card_dealer'
require_relative 'dice'
require_relative 'bad_consequence'
require_relative 'monster'



class Player
  @@MAXLEVEL=10
  attr_reader :name, :dead, :canISteal, :visibleTreasures, :hiddenTreasures
  attr_accessor :pendingBadConsequence, :level, :enemy
  
  def initialize(name)
    @name=name
    @level=1
    @dead=true
    @canISteal=true
    @enemy=nil
    @hiddenTreasures=Array.new
    @visibleTreasures=Array.new
    @pendingBadConsequence=nil
  end
  
  def self.getMaxLevel
    return @@MAXLEVEL
  end
  
  def bringToLife()
    @dead=false;
  end
  
  #def isDead()
    #return @dead
  #end
  
  def getCombatLevel()
    nivel = @level
    @visibleTreasures.each do|t|
      nivel+=t.bonus 
    end
    return nivel
  end
  
  def incrementLevels(l)
    @level= @level+l
    if @level>10
      @level=Player.getMaxLevel
    end
  end
  
  def decrementLevels(l)
    @level= @level-l
    if @level<=0
      @level=1
    end
  end
  
  def setEnemy(e)
    @enemy=e
  end
  
  #def setPendingbadConsequence(b)
    #@pendingBadConsequence=b
  #end
  
  def applyPrize(m)
    nLevels=m.getLevelsGained()
    incrementLevels(nLevels)
    nTreasures=m.getTreasuresGained()
      if nTreasures>0
        @dealer=CardDealer.instance()
        for i in 0..nTreasures-1 do
                treasure = @dealer.nextTreasure()
                @hiddenTreasures.push(treasure)
        end
      end
  end
  
  def applyBadConsequence(m)
    bc = m.bc
    nLevels = bc.levels
    decrementLevels(nLevels)
    pendingBad = bc.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
    @pendingBadConsequence=pendingBad
  end
  
  def canMakeTreasureVisible(t)
    aux=0
    resultado=true
    tiene_dosmanos=false
    @visibleTreasures.each do |v|
       if v.type == TreasureKind::BOTHHANDS
         tiene_dosmanos=true
       end
       if v.type== t.type
          resultado=false
       end
       if v.type==TreasureKind::ONEHAND
                aux=aux+1
       end
    end
    if t.type ==TreasureKind::ONEHAND && aux<2
       if tiene_dosmanos==true
          resultado=false
       else
          resultado=true
       end
    end
    if aux>=1 && t.type ==TreasureKind::BOTHHANDS
            resultado=false
    end
        return resultado;
  end
  
  def howManyVisibleTreasures(tKind)
    contador=0
    @visibleTreasures.each do |t|
      if (t.type == tKind)
        contador +=1
      end
    end
    return contador;
  end
  
  def dielfNoTreasures()
    if @visibleTreasures.empty? && @hiddenTreasures.empty?
      @dead=true 
    end
  end
  
  def getHiddenTreasures()
    return @hiddenTreasures
  end
  
  def getVisibleTreasures()
   return @visibleTreasures
  end
  
  def combat(m)
    myLevel = getCombatLevel
    monsterLevel = getOponentLevel(m)
        if @level> Player.getMaxLevel
            aux=CombatResult::WINGAME
        else 
          if myLevel>monsterLevel
             applyPrize(m)
              aux = CombatResult::WIN    
         else
            applyBadConsequence(m)
            if(shouldConvert)
              aux= CombatResult::LOSEANDCONVERT
            else
              aux = CombatResult::LOSE
            end
         end
        end
        return aux
  end
  
  #def setHiddenTreasures(h)
   # @hiddenTreasures=h
  #end
  
  def makeTreasureVisible(t)
    canl = canMakeTreasureVisible(t)
    if canl
      @visibleTreasures.push(t);
      @hiddenTreasures.delete(t);
    end
  end
  
  def discardVisibleTreasure(t)
    @visibleTreasures.delete(t)
    if @pendingBadConsequence!=nil && !@pendingBadConsequence.isEmpty
            @pendingBadConsequence.substractVisibleTreasure(t)
    end
        dielfNoTreasures
  end
  
  def discardHiddenTreasure(t)
    @hiddenTreasures.delete(t)
    if @pendingBadConsequence!=nil && !@pendingBadConsequence.isEmpty
            @pendingBadConsequence.substractHiddenTreasure(t)
    end
        dielfNoTreasures
  end
  
  def validState()
    ok=true
    if @pendingBadConsequence!=nil && !@pendingBadConsequence.isEmpty
      ok=false 
    end
    if @hiddenTreasures.length>4
      ok=false
    end
    return ok
  end
  
  def initTreasures()
    dealer = CardDealer.instance()
    dice=Dice.instance()
    bringToLife()
    treasure = dealer.nextTreasure()
    @hiddenTreasures.push(treasure)
    number = dice.nextNumber()
    if number>1
           treasure=dealer.nextTreasure()
           @hiddenTreasures.push(treasure)
    end
    if number==6
           treasure = dealer.nextTreasure()
           @hiddenTreasures.push(treasure)
    end
  end
  
  def stealTreasure()
    canl = canISteal()
     if canl
      canYou = @enemy.canYouGiveMeATreasure
        if canYou
          treasure = @enemy.giveMeATreasure
          @hiddenTreasures.push(treasure)
          haveStolen()
          return treasure
        end
     end
        return nil
  end
  
  def giveMeATreasure()
    aux= rand(@hiddenTreasures.length)
    return @hiddenTreasures.at(aux);
  end
  
  def canYouGiveMeATreasure()
    if(@hiddenTreasures.empty?)
      return false
    else
      return true
    end
  end
  
  def haveStolen()
    @canIsteal=false
  end

  def discardAllTreasures()
    auxVisibleTreasure =Array.new(@visibleTreasures)
    auxHiddenTreasure =Array.new(@hiddenTreasures)
        auxVisibleTreasure.each do |t|
            discardVisibleTreasure(t)
        end
        auxHiddenTreasure.each do |x|
            discardHiddenTreasure(x)
        end
  end
  
  def getOponentLevel(m)
    return m.combatLevel
  end
  
  def shouldConvert
    dice=Dice.instance
    number =dice.nextNumber
    if(number==1)
      return true
    else
      return false
    end
  end
  
  
  def to_s
   "\nNombre del Jugador : #{@name} \n Nivel: #{@level} \n Enemigo: #{@enemy.name} \n Tesoros Visibles: #{@visibleTreasures} \n Tesoros Ocultos: #{@hiddenTreasures} \n Mal Rollo Pendiente: #{@pendingBadConsequence} \n 
  \n "
  end
  
  private :bringToLife, :incrementLevels, :decrementLevels, :applyPrize, 
    :applyBadConsequence, :canMakeTreasureVisible, :howManyVisibleTreasures, :dielfNoTreasures, :giveMeATreasure,
     :haveStolen
  
  
  
  
end
end
