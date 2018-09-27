#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
require_relative 'player'
require_relative 'treasure'

  
class BadConsequence
  @@MAXTREASURES = 10
  attr_reader :text, :levels
  
  def initialize(t, l)
    @text=t
    @levels=l
  end
  
  def self.getMaxTreasures
    return @@MAXTREASURES
  end
  
  def adjustToFitTreasureList(v, h)
    raise NotImplementedError.new
  end
  
  def isEmpty()
    raise NotImplementedError.new
  end
  
  def substractHiddenTreasure(t)
    raise NotImplementedError.new
  end
  
  def substractVisibleTreasure(t)
    raise NotImplementedError.new
  end

  private_class_method :new
  
  def to_s()
   " \n Texto: #{@text} \n Niveles perdidos: #{@levels} \n "
  end
  
end
end