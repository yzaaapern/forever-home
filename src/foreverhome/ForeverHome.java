/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package foreverhome;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yzape
 */
public class ForeverHome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // constants
        final int INC_DABLOON = 10;
        final int DABLOON_REWARD = 100;
        final int DEFAULT_DABLOON = 20;
        
        // instantiate new Food objects, these are the types of pet food in the game.
        
        Food kibble = new Food("Kibble", 10, 10, 0);
        Food rainbowTreat = new Food("Rainbow Treat", 28, 20, 0);
        Food cannedFood = new Food("Canned Food", 15, 12, 0);
        Food veggieMix = new Food("Veggie Mix", 10,10 ,0);
        Food seeds = new Food("Seeds", 15, 12, 0);
        Food foodForAll = new Food("Food For All", 5, 6, 5);
        
        String playerName = "";
        int dabloons = 0;
        ArrayList<Food> playerInventory = new ArrayList<Food>();
        
        
    }
    
    // functions
    public void alert()
    {
        
    }
    
    public void incDabloon(int level)
    {
        
    }
    
}
