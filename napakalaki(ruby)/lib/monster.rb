#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
require_relative 'player'

class Monster
  attr_reader :name, :combatLevel, :bc, :price, :levelChangeAgainstCultistPlayer
  def initialize(name, combatLevel, bc, price)
    @name=name
    @combatLevel=combatLevel
    @price=price
    @bc=bc
    @levelChangeAgainstCultistPlayer=0
  end
  
  def Monster.newmonster(n,l,badConsequence, p, ic)
    @levelChangeAgainstCultistPlayer=ic
    Monster.new(n,l,badConsequence, p)
    
  end
  
  def getLevelsGained
    return @price.levels
  end
  
  def getTreasuresGained
    return @price.treasures
  end
  
  def getCombatLevelAgainstCultistPlayer
    return @levelChangeAgainstCultistPlayer+@combatLevel
  end
  
  #def getCombatLevel()
    #return @combatLevel
  #end
  
  def to_s
   "\nMostruo : #{@name} \n Nivel: #{@combatLevel} \n \n Buen rollo: #{@price}  \n Mal rollo: #{@bc} \n Level de cambio Cultist Player: #{@levelChangeAgainstCultistPlayer}"
  end
  
  end
end