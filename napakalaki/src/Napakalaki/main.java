/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class main {
    
    public static void main (String[] args){
        
        ArrayList<String> names;
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        
        Dice.createInstance(napakalakiView);
        PlayerNamesCapture namesCapture= new PlayerNamesCapture(napakalakiView,true);
        names=namesCapture.getNames();
        
        game.initGame(names);
        napakalakiView.setVisible(true);
        napakalakiView.setNapakalaki(game);
    }
}
