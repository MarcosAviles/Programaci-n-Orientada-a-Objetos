# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
class NumericBadConsequence < BadConsequence
  
  attr_accessor :nVisibleTreasure, :nHiddenTreasure
  
  def initialize(text, levels, nVisible, nHidden)
    super(text, levels)
    @nVisibleTreasure=nVisible
    @nHiddenTreasure=nHidden
  end
  
  def isEmpty
    if @nVisibleTreasure==0 && @nHiddenTreasure==0
      return true;
    else 
      return false
    end
  end
  
  def substractVisibleTreasure(t)
    if @nVisibleTreasure!=0
            @nVisibleTreasure-=1
    end
  end
  
  def substractHiddenTreasure(t)
    if @nHiddenTreasure!=0
            @nHiddenTreasure-=1
    end
  end
  
  def adjustToFitTreasureLists(v, h)
    resultado = NumericBadConsequence.new(self.text, self.levels,0,0)
    if @nVisibleTreasure!=0 || @nHiddenTreasure !=0
      if @nVisibleTreasure>v.length
        resultado.nVisibleTreasure=v.length
      else
        resultado.nVisibleTreasure = @nVisibleTreasure
      end
      
      if @nHiddenTreasure>h.length
        resultado.nHiddenTreasure=h.length
      else
        resultado.nHiddenTreasure=@nHiddenTreasure
      end
    end
   return resultado;
  end
  
  def to_s()
   " \n #{super.to_s} \n Tesoros Visibles perdidos: #{@nVisibleTreasure} \n Tesoros Ocultos perdidos: #{@nHiddenTreasure} \n "
  end
  
  public_class_method :new
end
end