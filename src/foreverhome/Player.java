/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

import java.util.Objects;

/**
 *
 * @author yzape
 */
public class Player //implements Interact
{
    
    public static final int INC_DABLOONS = 10;
    public static final int REWARD_DABLOONS = 100;
    private String name;
    public Animal fosterPet;
    public boolean isPlaying = false;
    public boolean hasFosterPet;
    private int dabloons;
    private FoodInventory foodInventory;
    private InteractionList interactionList;
    
    public Player(String name){
        this.setName(name);
        this.setFosterPet(null);
        this.hasFosterPet = false;
        this.dabloons = 20;
        this.foodInventory = new FoodInventory();
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

    public void incDabloons(int amount)
    {
        int inc_dabloons = this.getDabloons() + amount;
        this.setDabloons(inc_dabloons);
    }
    
    public void decDabloons(int amount)
    {
        int dec_dabloons = this.getDabloons() - amount;
        if(dec_dabloons >= 0)
        {
            this.setDabloons(dec_dabloons);
        }
    }
    
    public void buyFood(Food food)
    {
        if(this.getDabloons() >= food.getFoodCost())
        {
            food.incFoodCount();
            this.decDabloons(food.getFoodCost());
        }
        else
        {
            System.out.println("Insufficient Funds.\n");
        }
    }
    
    public void feedPet(Food food)
    {
        if(food.getFoodCount() > 0)
        {
            this.getFosterPet().incHunger(food);
            food.decFoodCount();
            this.getFosterPet().incLevelXP();
            this.levelUpReward();
        }
        else
        {
            System.out.println("Insufficient supply.\n");
        }
    }
    
    public void giveBath()
    {
        this.getFosterPet().incHygiene();
        this.getFosterPet().incLevelXP();
        this.levelUpReward();
    }
    
    /*
        OVERRIDE INTERACT METHODS
    */
    
    /*  givePat method
    
    Parameters: None
    Return: None
    Description: When the player pats their pet the pet becomes happier and increases pet's xp
    */
    
    public void interactWithPet(Interaction interaction)
    {
        if(this.isInteractUnlocked(interaction))
        {
            if(interaction instanceof Play)
            {
                this.getFosterPet().incHappiness();
                this.getFosterPet().decHunger();
                this.getFosterPet().decHygiene();
            }
            else if(interaction instanceof Trick)
            {
                this.getFosterPet().incHappiness();
            }
            else if(interaction instanceof Health)
            {
                this.getFosterPet().incHappiness();
                this.getFosterPet().incHygiene();
            }
            this.getFosterPet().incLevelXP();
            this.levelUpReward();
        }
        else
        {
            System.out.println("You cannot do this trick yet! " + this.getFosterPet().getName() + " has yet to reach Level " + interaction.getLevelUnlocked() + ".");
        }
    }
    
    public boolean isInteractUnlocked(Interaction interaction)
    {
        if(this.getFosterPet().getLevel() >= interaction.getLevelUnlocked())
        {
            return true;
        }
        return false;
    }
    
    public void levelUpReward()
    {
        if(this.getFosterPet().checkLevelForIncLevel())
        {
            this.getFosterPet().incLevel();
            this.getFosterPet().levelUpMessage();
            if(this.getFosterPet().getLevel() < Animal.MAX_LEVEL)
            {
                this.incDabloons(Player.INC_DABLOONS);
            }
            else
            {
                this.incDabloons(Player.REWARD_DABLOONS);
            }
            
        }
        
    }
    
    @Override
    public String toString(){
        String displayPet = (this.hasFosterPet == true) ? this.fosterPet.toString() + this.foodInventory.toString(): "No Pet";
        return "---------------------\n" +
               "PLAYER STATS\n" + 
               "Username: " + this.name + 
               "\nDabloons: $" + this.getDabloons() + 
               "\n" + displayPet;
    }
    
    
    public String fileToString(){
        String displayPet = (this.hasFosterPet) ? this.fosterPet.toString() : "NoPet";
        return this.name + ":" + this.dabloons 
             + "|" + this.fosterPet.getName() + ":" + this.fosterPet.checkFosterPet(fosterPet) + ":" + this.fosterPet.getHappiness() + ":" + this.fosterPet.getHunger() + ":" + this.fosterPet.getHygiene() + ":" + this.fosterPet.getLevelXP() + ":" + this.fosterPet.getLevelXPBar() + ":" + this.fosterPet.getLevel();
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        
        Player otherPlayer = (Player) o;
        return Objects.equals(this.name, otherPlayer.name);
    }

}
