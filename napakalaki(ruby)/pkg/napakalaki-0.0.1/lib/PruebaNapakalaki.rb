#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.


#monster = Array.new
=begin
require 'prize'
require 'bad_consequence'
require 'treasure_kind'
require 'monster'


# Métodos de consultas-----------------------------------------------------------------------------
# Consulta1
#def consulta1(monster)
  #aux = Array.new
  #monster.each do |m|
    #if (m.combatLevel>10) then
    #aux << m
    #end
  #end
  #return aux
#end

#Consulta2
#def consulta2(monster)
  #aux = Array.new
  #monster.each do |m|
    #if (m.bc.levels>0) then
    #aux << m
    #end
  #end
  #return aux
#end

#Consulta3
def consulta3(monster)
  aux = Array.new
  monster.each do |m|
    if (m.price.levels>1) then
    aux << m
    end
  end
  return aux
end

#Consulta4
def consulta4(monster)
  aux = Array.new
  monster.each do |m|
    if (!m.bc.specificVisibleTreasure.empty? || !m.bc.specificHiddenTreasure.empty?) then
    aux << m
    end
  end
  return aux
end

#puts "Los mostrous con nivel de combate superior a 10: "
#puts consulta1(monster)

#puts "Los mostrous con mal rollo que implican solo  perdidas de niveles: "
#puts consulta2(monster)

#puts "Los mostrous con un buen rollo que implican una ganancia de niveles superior a 1: "
#puts consulta3(monster)

#puts "Los mostrous con un mal rollo que implican perdida de un determinado tipo de tesoros ya sea visibles y/o ocultos: "
#puts consulta4(monster)

=end