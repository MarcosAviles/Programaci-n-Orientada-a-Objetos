#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
require 'singleton'
require_relative 'player'
require_relative 'combat_result'
require_relative 'monster'
require_relative 'card_dealer'
require_relative 'cultist_player'


class Napakalaki
  include Singleton
  attr_reader :currentPlayer, :currentMonster
  
  def initialize
    @currentPlayer=nil
    @players=Array.new
    @dealer=CardDealer.instance
    @currentMonster=nil
   
  end
  
  def initPlayers(names)
    names.each do |n|
      @players.push(Player.new(n))
    end
  end
  
  def nextPlayer
    tamanio=@players.length
    indice=rand(tamanio)
    if(@currentPlayer==nil)
      aux= @players[indice]
    else
      if(@players[tamanio-1]==@currentPlayer)
        aux= @players[0]
      else
        indice=@players.index(@currentPlayer)
        aux = @players[indice+1];
      end
    end
    return aux;
  end
  
  def nextTurnAllowed
    if(@currentPlayer==nil)
      return true
    else
      return @currentPlayer.validState
    end  
  end
  
  def setEnemies
    numero_jugadores=@players.length
        i=0
        while i < numero_jugadores
          indice = (rand(numero_jugadores))
            if(i != indice)
              @players[i].enemy=@players[indice]
            else
              i=i-1
            end
            i=i+1
        end
  end
  
  def developCombat
    aux = @currentPlayer.combat(@currentMonster)
    if(aux==CombatResult::LOSEANDCONVERT)
      c=@dealer.nextCultist
      cul=CultistPlayer.new(@currentPlayer, c)
      posicion=@players.index(@currentPlayer)
      @currentPlayer=cul
        @players.each do |p|
          if(p.enemy==@currentPlayer)
            p.enemy=cul
          end
        end
      @players[posicion]=cul
    end
    @dealer.giveMonsterBack(@currentMonster)
    return aux
  end
  
  def discardVisibleTreasures(treasures)
    treasures.each do |t|
      @currentPlayer.discardVisibleTreasure(t)
      @dealer.giveTreasureBack(t)
    end
  end
  
  def discardHiddenTreasures(treasures)
    treasures.each do |t|
      @currentPlayer.discardHiddenTreasure(t)
      @dealer.giveTreasureBack(t)
    end
  end
  
  def makeTreasuresVisible(treasures)
    treasures.each do |t|
      @currentPlayer.makeTreasureVisible(t)
    end
  end
  
  def initGame(names)
    initPlayers(names)
    setEnemies()
    @dealer = CardDealer.instance()
    @dealer.initCards
    nextTurn()
  end
  
  #def getCurrentPlayer
    #return @currentPlayer
  #end
  
  #def getCurrentMonster
    #return @currentMonster
  #end
  
  def nextTurn
    state_ok=nextTurnAllowed
    if(state_ok)
      @currentMonster=@dealer.nextMonster
      @currentPlayer=nextPlayer
      dead=@currentPlayer.dead
      if(dead)
        @currentPlayer.initTreasures
      end    
    end
    return state_ok;
  end
  
  def endOfGame(result)
    if result == CombatResult::WINGAME
      return true
    else
      return false
    end
  end
  
  def to_s
   "\nActual Jugador : #{@currentPlayer} \n Jugadores: #{@players} \n Actual Monstruo: #{@currentMonster}"
  end
  
  private :initPlayers, :nextPlayer, :nextTurnAllowed, :setEnemies
  
end
end