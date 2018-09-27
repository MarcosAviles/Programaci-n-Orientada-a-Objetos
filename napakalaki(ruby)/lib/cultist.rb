# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
class Cultist
  attr_reader :gainedLevels, :name
  def initialize (name, gainedLevel)
    @name=name;
    @gainedLevels=gainedLevel
  end
  
  def getGainedLevels()
    return @gainedLevels
  end
  
  def to_s()
   " \n Nombre de Cultist: #{@name} \n Niveles ganados: #{@gainedLevels}"
  end
end
end
