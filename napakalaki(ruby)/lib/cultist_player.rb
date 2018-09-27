# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
require_relative 'player'
require_relative 'cultist'

class CultistPlayer < Player
  
  @@totalCultistPlayer=0
  
  def initialize (p,c)
    #Player.newplayer(p)
    super(p.name)
    @level=p.level
    @dead=p.dead
    @canISteal=p.canISteal
    @enemy=p.enemy
    @hiddenTreasures=p.hiddenTreasures
    @visibleTreasures=p.visibleTreasures
    @pendingBadConsequence=p.pendingBadConsequence
    @myCultistCard=c
    @@totalCultistPlayer+=1
  end
  
  
  def getCombatLevel
    nivel = super.getCombatLevel
    nivel += nivel*0.2
    nivel+= @myCultistCard.getGainedLevels
    nivel *= @@totalCultistPlayer
    return nivel
  end
  
  def getOponentLevel(m)
    return m.getCombatLevelAgainstCultistPlayer
  end
  
  def self.getTotalCultistPlayer
    return @@totalCultistPlayer
  end
  
  def shouldConvert
    return false
  end
  
  def giveMeATreasure
    aux= rand(super.VisibleTreasures.length)
    return super.VisibleTreasures.at(aux);
  end
  
  def canYouGiveMeATreasure
    if(super.enemy.visibleTreasures.empty?)
      return false
    else
      return true
    end
  end

  def to_s()
   " \n #{super.to_s} +  \n Carta de Cultist: #{@myCultistCard} \n Total de Jugadores Cultist: #{@@totalCultistPlayer}"
  end
  
  private :giveMeATreasure, :canYouGiveMeATreasure
end
end