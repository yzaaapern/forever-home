/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

import java.util.HashSet;

/**
 *
 * @author yzape
 */
public class FoodInventory {
    
    Food foodForAll;
    Food kibble;
    Food cannedFood;
    Food veggieMix;
    Food seeds;
    Food rainbowTreat;
    
    HashSet<Food> foodInventory;
    
    public FoodInventory(){
        this.foodForAll = new Food("Food for All", 5, 6, 5);
        this.kibble = new Food("Kibble", 10, 10, 0);
        this.cannedFood = new Food("Canned Food", 15, 12, 0);
        this.veggieMix = new Food("Veggie Mix", 10, 10, 0);
        this.seeds = new Food("Seeds", 15, 12, 0);
        this.rainbowTreat = new Food("Rainbow Treat", 28, 20, 0);
        
        Food[] foods = {foodForAll, kibble, cannedFood, veggieMix, seeds, rainbowTreat};
        
        this.foodInventory = new HashSet();
        
        for(Food f : foods){
            this.foodInventory.add(f);
        }
        
    }
    
    public String toString(){
        String foodInventoryOutput = "Your current food inventory: \n";
        int count = 1;
        
        for(Food f : foodInventory){
            foodInventoryOutput += count + ". " + f.toString() + "\n";
            count++;
        }
        
        return foodInventoryOutput;
    }
    
    
    
   
}
