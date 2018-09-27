# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
class SpecificVisibleAndNumericHiddenBadConsequence < BadConsequence
  
  attr_accessor :specificVisibleTreasures, :nHiddenTreasure
  
  def initialize(text, levels, nHidden, specificVisibleTreasures)
    super(text, levels)
    @nHiddenTreasure=nHidden
    @specificVisibleTreasure=specificVisibleTreasures
  end
  
  def isEmpty
    if @specificVisibleTreasure.empty? && @nHiddenTreasure==0
      return true;
    else 
      return false
    end
  end
  
  def substractHiddenTreasure(t)
    if @nHiddenTreasure!=0
            @nHiddenTreasure-=1
    end
  end
  
  def substractVisibleTreasure(t)
    if !@specificVisibleTreasure.empty?
      @specificVisibleTreasure.delete(t.type)
    end
  end
  
  def adjustToFitTreasureLists(v, h)
    resultado = SpecificVisibleAndNumericHiddenBadConsequence.new(self.text, self.levels,0,Array.new)
    if @nHiddenTreasure !=0
      if @nHiddenTreasure>h.length
        resultado.nHiddenTreasure=h.length
      else
        resultado.nHiddenTreasure=@nHiddenTreasure
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
   " \n #{super.to_s} \n Tesoros Ocultos perdidos: #{@nHiddenTreasure} \n Tesoros Visibles perdidos: #{@specificVisibleTreasure} \n "
  end
  
  public_class_method :new
end
end