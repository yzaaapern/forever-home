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
    private int dabloons;
    private FoodInventory foodInventory;
    
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
        this.foodInventory = foodInventory;
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
    
    public int getDabloons() {
        return dabloons;
    }

    public void setDabloons(int dabloons) {
        this.dabloons = dabloons;
    }
    
    public FoodInventory getFoodInventory(){
        return this.foodInventory;
    }

    public void incDabloons(){
        if(this.fosterPet.getLevel() == 10 && this.fosterPet.getLevelXP() == this.fosterPet.getLevelXPBar())
        {
            this.setDabloons(this.getDabloons() + REWARD_DABLOONS);
        }
        if(this.fosterPet.checkLevelForIncLevel())
        {
            this.setDabloons(this.getDabloons() + INC_DABLOONS);

        }
    }
    
    public void decDabloons(Food food)
    {
        this.setDabloons(this.getDabloons() - food.getFoodCost());
    }
    
    public String toString(){
        String displayPet = (this.hasFosterPet == true) ? this.fosterPet.toString() + this.foodInventory.toString(): "No Pet";
        return "---------------------\n" +
               "PLAYER STATS\n" + 
               "Username: " + this.name + 
               "\nDabloons: $" + this.getDabloons() + 
               "\n---------------------\n" + displayPet;
    }


}
