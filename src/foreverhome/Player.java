/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author yzape
 */
public class Player {
    
    private final int INC_DABLOONS = 10;
    private final int REWARD_DABLOONS = 100;
    private String name;
    public Animal fosterPet;
    public boolean hasFosterPet;
    public int dabloons;
    public FoodInventory foodInventory;
    
    public Player(String name){
        this.setName(name);
        this.setFosterPet(null);
        this.hasFosterPet = false;
        this.dabloons = 20;
        this.foodInventory = new FoodInventory();
    }
    
    public Player(String name, Animal fosterPet, FoodInventory foodInventory){
        this.setName(name);
        this.setFosterPet(fosterPet);
        this.hasFosterPet = true;
        this.setFoodInventory(foodInventory);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setFosterPet(Animal fosterPet){
        this.fosterPet = fosterPet;
    }
    
    public Animal getFosterPet(){
        return this.fosterPet;
    }
    
    public void setFoodInventory(FoodInventory foodInventory){
        this.foodInventory = foodInventory;
    }
    
    public FoodInventory getFoodInventory(){
        return this.foodInventory;
    }
    
    public void incDabloons(){
        if(this.fosterPet.level == 10 && this.fosterPet.levelXP == this.fosterPet.levelXPBar){
            this.dabloons += REWARD_DABLOONS;
        }
        if(this.fosterPet.checkLevelForIncLevel()){
           this.dabloons += INC_DABLOONS;

        }
    }
    
    public void decDabloons(Food food){
        if(food == null){
            return;
        }
        
        if(this.dabloons == 0){
            System.out.println("You do not have enough money to buy " + food.foodName);
            return;
        }
        
        else{
            this.dabloons -= food.foodCost;
        }
    }
    
    public String toString(){
        String displayPet = (this.hasFosterPet == true) ? this.fosterPet.toString() + this.foodInventory.toString(): "No Pet";
        return "---------------------\n" +
               "PLAYER STATS\n" + 
               "Username: " + this.name + 
               "\nDabloons: $" + this.dabloons + 
               "\n---------------------\n" + displayPet;
    }
}
