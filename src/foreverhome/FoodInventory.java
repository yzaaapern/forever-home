/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

import java.util.Scanner;

/**
 *
 * @author yzape
 */
public class FoodInventory {
    
    private final int NUM_OF_FOODS = 6;
    public Food foodForAll;
    public Food kibble;
    public Food cannedFood;
    public Food veggieMix;
    public Food seeds;
    public Food rainbowTreat;
    
    Food[] foods = new Food[NUM_OF_FOODS];
    
    public FoodInventory(){
        this.foodForAll = new FoodType0("Food for All", 10, 6, 5);
        this.foods[0] = foodForAll;
        
        this.kibble = new FoodType1("Kibble", 20, 10, 0);
        this.foods[1] = kibble;
        
        this.cannedFood = new FoodType1("Canned Food", 30, 12, 0);
        this.foods[2] = cannedFood;
        
        this.veggieMix = new FoodType2("Veggie Mix", 20, 10, 0);
        this.foods[3] = veggieMix;
        
        this.seeds = new FoodType2("Seeds", 30, 12, 0);
        this.foods[4] = seeds;
        
        this.rainbowTreat = new FoodType0("Rainbow Treat", 50, 20, 0);
        this.foods[5] = rainbowTreat;
    }
    
    public Food getValidFoodMenu(int foodType){
        
        // Variables
        
        String input;
        int inputNum = 0;
        Food chosenFood = null; // player's chosen food to buy
        
        Scanner scanner = new Scanner(System.in); // scanner for user input
        
        System.out.println("Get more foods to feed your foster pet!");
        System.out.println("Purchasing one of these foods increases your chosen food's quantity by 5! Isn't that nice?");
        
        // Displaying store for valid food type
        System.out.println(this.displayValidFood(foodType));
        
        System.out.println("x -  Go back to Pet Foster Menu");
        
        do
        {
            System.out.print("Your choice: ");
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                return null;
            }
            
        }while(!this.isValidInput(input));
        
        inputNum = Integer.parseInt(input);       
        
        // Player is getting from list of viable foods
        chosenFood = this.getValidFood(foodType, inputNum);
        
        return chosenFood;
        
    }
    
    public Food useValidFoodMenu(int foodType){
        String input;
        int inputNum = 0;
        Food chosenFood = null;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Feed your foster pet something tasty! \n");
        
        // Displaying player's stock of food types 0 and 1
        System.out.println(this.displayValidFood(foodType));
        
        System.out.println("x -  Go back to Pet Foster Menu");
        
        do{
            System.out.print("Your choice: ");
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                return null;
            }
            
            
        }while(!this.isValidInput(input));
        
        inputNum = Integer.parseInt(input);       

        // Player feeding pet from list of viable foods
        chosenFood = this.useValidFood(foodType, inputNum);
        
        return chosenFood;
    }
    
    @Override
    public String toString(){
        String foodInventoryOutput = "Your current food inventory: \n";
        int count = 1;
        
        for(Food f : foods){
            foodInventoryOutput += count + ". " + f.toStringNoCost() + "\n---------------------\n";
            count++;
        }
        
        return foodInventoryOutput;
    }
    
    public boolean isValidInput(String input){
        try{
            Integer.parseInt(input);
        }
        
        catch(NumberFormatException ex){
            if(input.equalsIgnoreCase("x")){
                return true;
            }
            
            if(input == "" || input == " "){
                System.out.println("Invalid input.\nPlease try again.");
                return false;
            }
            
            System.out.println("Invalid input.\nPlease try again.");
            return false;
            
        }
        return true;
    }
    
    public String displayValidFood(int foodType)
    {
        String output = "";
        int count = 1;
        for(int i = 0; i < this.foods.length; i++) // for loop for the length of the foods array
        {
            if(this.foods[i].getFoodType() == 0 || this.foods[i].getFoodType() == foodType) // if the food is of type 0 or 1
            {
                output += count + ". " + this.foods[i];
                count++; // increments count for viable foods
            }
        }
        return output;
    }
    
    public Food getValidFood(int foodType, int inputNum)
    {
        int count = 1;
        Food chosenFood = null;
        
        for(int i = 0; i < this.foods.length; i++)
        {
            if(this.foods[i].getFoodType() == 0 || this.foods[i].getFoodType() == foodType) // if the food is a valid type
            {
                if(inputNum == count) // if the user's inputNum is equal to the count of viable foods
                {
                    chosenFood = this.foods[i]; // the chosen food is that food
                }
                count++; // increments count for viable foods
            }
        }
        return chosenFood;
    }
    
    public Food useValidFood(int foodType, int inputNum)
    {
        Food chosenFood = null;
        int count = 1; // count for viable foods is reset to 1
        for(int i = 0; i < this.foods.length; i++)
        {
            if(this.foods[i].getFoodType() == 0 || this.foods[i].getFoodType() == foodType) // if the food is of type 0 or 1
            {
                if(inputNum == count) // if the user's inputNum is equal to the count of viable foods
                {
                    chosenFood = this.foods[i]; // the chosen food is that food
                }
                count++; // increments count for viable foods
            }
        }
        return chosenFood;
    }
}
