#encoding: utf-8
#  To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
  require_relative 'treasure_kind'
  
class Treasure
    attr_reader :bonus, :name, :type
  def initialize(n,bonus,t)
    @name=n
    @bonus=bonus
    @type=t
  end
  
  def to_s 
    "Name: #{@name} \n Bonus: #{@bonus} \n Tipo de tesoro: #{@type}"
  end
end
end