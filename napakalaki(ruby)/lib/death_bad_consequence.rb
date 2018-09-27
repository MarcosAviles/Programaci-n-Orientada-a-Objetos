# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
class DeathBadConsequence < NumericBadConsequence
  
  attr_accessor :death
  
  def initialize(text, death)
    super(text, Player.getMaxLevel, BadConsequence.getMaxTreasures, BadConsequence.getMaxTreasures)
    @death=death
  end
  
  def to_s
    " \n #{super.to_s} \n Muerte: #{@death}"
  end
  
  public_class_method :new
end
end