# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
  require_relative 'bad_consequence'
class SpecificBadConsequence < BadConsequence
  
  attr_accessor :specificVisibleTreasure, :specificHiddenTreasure
  
  def initialize(text, levels, v, h)
    super(text,levels)
    @specificVisibleTreasure=v
    @specificHiddenTreasure=h
  end
  
  def isEmpty
    if @specificVisibleTreasure.empty? && @specificHiddenTreasure.empty?
      return true;
    else 
      return false
    end
  end
  
  def substractVisibleTreasure(t)
    if !@specificVisibleTreasure.empty?
      @specificVisibleTreasure.delete(t.type)
    end
  end
  
  def substractHiddenTreasure(t)
    if !@specificHiddenTreasure.empty?
      @specificHiddenTreasure.delete(t.type)
    end
  end
  
  def adjustToFitTreasureLists(v, h)
    resultado = SpecificBadConsequence.new(self.text, self.levels, Array.new, Array.new)
    if @specificHiddenTreasure.length>0
      @specificHiddenTreasure.each do |x|
        h.each do |t|
          if x==t.type
            resultado.specificHiddenTreasure.push(x)
          end
        end
      end
    end
    if @specificVisibleTreasure.length>0
      @specificVisibleTreasure.each do |sv|
        v.each do |x|
          if sv==x.type
            resultado.specificVisibleTreasure.push(sv)
          end
        end
      end
    end
    return resultado;
  end
  
  def to_s()
   " \n #{super.to_s} +  \n Tesoros Visibles perdidos: #{@specificVisibleTreasure} \n Tesoros Ocultos perdidos: #{@specificHiddenTreasure}"
  end
   
  public_class_method :new
end
end