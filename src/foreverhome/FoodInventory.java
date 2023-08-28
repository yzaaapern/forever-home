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
        this.foodForAll = new Food("Food for All", 10, 6, 5);
        this.foods[0] = foodForAll;
        
        this.kibble = new Food("Kibble", 20, 10, 0);
        this.foods[1] = kibble;
        
        this.cannedFood = new Food("Canned Food", 30, 12, 0);
        this.foods[2] = cannedFood;
        
        this.veggieMix = new Food("Veggie Mix", 20, 10, 0);
        this.foods[3] = veggieMix;
        
        this.seeds = new Food("Seeds", 30, 12, 0);
        this.foods[4] = seeds;
        
        this.rainbowTreat = new Food("Rainbow Treat", 50, 20, 0);
        this.foods[5] = rainbowTreat;
    }
    
    public Food buyDogAndCatFood(){
        String input;
        int inputNum = 0;
        Food chosenFood = null;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Get more foods to feed your foster pet!");
        System.out.println("Purchasing one of these foods increases your chosen food's quantity by 5! Isn't that nice?");
        System.out.println("1. Food for All\n\t-Hunger Value: 5 points\n\t-Cost: $6");
        System.out.println("2. Kibble\n\t-Hunger Value: 10 points\n\t-Cost: $10");
        System.out.println("3. Canned Food\n\t-Hunger Value: 15 points\n\t-Cost: $12");
        System.out.println("4. Rainbow Treat\n\t-Hunger Value: 28 points\n\t-Cost: $20");
        System.out.println("x - Go back to Pet Foster Menu");
        
        do{
            System.out.print("Your choice: ");
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                return null;
            }
            
            
        }while(!this.isValidInput(input));
        
        inputNum = Integer.parseInt(input);       

        
        switch(inputNum){
            case 1:
                this.foodForAll.incFoodCount();
                chosenFood = foodForAll;
                break;
            case 2:
                this.kibble.incFoodCount();
                chosenFood = kibble;
                break;
            case 3:
                this.cannedFood.incFoodCount();
                chosenFood = cannedFood;
                break;
            case 4:
                this.rainbowTreat.incFoodCount();
                chosenFood = rainbowTreat;
                break;
            default: break;
        }
        
        return chosenFood;
        
    }
    
    public Food displayDogAndCatFoodMenu(){
        String input;
        int inputNum = 0;
        Food chosenFood = null;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Feed your foster pet something tasty! \n");
        System.out.println("1. " + foodForAll.toStringNoCost());
        System.out.println("2. " + kibble.toStringNoCost());
        System.out.println("3. " + cannedFood.toStringNoCost());
        System.out.println("4. " + rainbowTreat.toStringNoCost());
        System.out.println("x -  Go back to Pet Foster Menu");
        
        do{
            System.out.print("Your choice: ");
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                return null;
            }
            
            
        }while(!this.isValidInput(input));
        
        inputNum = Integer.parseInt(input);       

        
        switch(inputNum){
            case 1:
                this.foodForAll.decFoodCount();
                chosenFood = foodForAll;
                break;
            case 2:
                this.kibble.decFoodCount();
                chosenFood = kibble;
                break;
            case 3:
                this.cannedFood.decFoodCount();
                chosenFood = cannedFood;
                break;
            case 4:
                this.rainbowTreat.decFoodCount();
                chosenFood = rainbowTreat;
                break;
            default: break;
        }
        
        return chosenFood;
    }
    
    public Food buyRatParrotAndChickenFood(){
        String input;
        int inputNum = 0;
        Food chosenFood = null;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Buy your foster pet with something tasty!");
        System.out.println("1. Food for All\n\t-Hunger Value: 5 points\n\t-Cost: $6");
        System.out.println("2. Veggie Mix\n\t-Hunger Value: 10 points\n\t-Cost: $10");
        System.out.println("3. Seeds\n\t-Hunger Value: 15 points\n\t-Cost: $12");
        System.out.println("4. Rainbow Treat\n\t-Hunger Value: 28 points\n\t-Cost: $20");
        System.out.println("x -  Go back to Pet Foster Menu");
        
        do{
            System.out.print("Your choice: ");
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                return null;
            }
            
            
        }while(!this.isValidInput(input));
        
        inputNum = Integer.parseInt(input);       
        
        switch(inputNum){
            case 1:
                this.foodForAll.incFoodCount();
                chosenFood = foodForAll;
                break;
            case 2:
                this.veggieMix.incFoodCount();
                chosenFood = veggieMix;
                break;
            case 3:
                this.seeds.incFoodCount();
                chosenFood = seeds;
                break;
            case 4:
                this.rainbowTreat.incFoodCount();
                chosenFood = rainbowTreat;
                break;
            default: break;
        }
        
        return chosenFood;
    }
    
    public Food displayRatParrotAndChickenFoodMenu(){
        String input;
        int inputNum = 0;
        Food chosenFood = null;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Buy your foster pet with something tasty!");
        System.out.println("1. " + foodForAll.toString());
        System.out.println("2. " + veggieMix.toString());
        System.out.println("3. " + seeds.toString());
        System.out.println("4. " + rainbowTreat.toString());
        System.out.println("x -  Go back to Pet Foster Menu");
        
        do{
            System.out.print("Your choice: ");
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                break;
            }
            
            
        }while(!this.isValidInput(input));
       
        inputNum = Integer.parseInt(input);       

        
        switch(inputNum){
            case 1:
                this.foodForAll.decFoodCount();
                chosenFood = foodForAll;
                break;
            case 2:
                this.veggieMix.decFoodCount();
                chosenFood = veggieMix;
                break;
            case 3:
                this.seeds.decFoodCount();
                chosenFood = seeds;
                break;
            case 4:
                this.rainbowTreat.decFoodCount();
                chosenFood = rainbowTreat;
                break;
            default: break;
        }
        
        return chosenFood;
    }
    
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
    
    
    
   
}
