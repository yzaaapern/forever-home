/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author annga 
 * Name: Ann Del Rosario 
 * Student ID: 21143100
 */
public abstract class Food {

    /*
        INSTANCE AND CONSTANT VARIABLES
     */
    private final int INC_FOOD_COUNT = 5; // when food is bought, it increases by this amount.

    private String foodName;
    private int foodType; // integer for food type, type 0 is compatible with all animals, type 1 is for bigger animals (cats & dogs), type 2 is for smaller animals (rat, parrot, chicken).
    private int foodValue; // integer for how many hunger points the food has
    private int foodCost;
    private int foodCount;

    /*
        OBJECT CONSTRUCTOR
     */
    public Food(String foodName, int foodValue, int foodCost, int foodCount) {
        this.foodName = foodName;
        this.foodValue = foodValue;
        this.foodCost = foodCost;
        this.foodCount = foodCount;
    }

    /*
        FOODNAME: GET METHOD
     */
    public String getFoodName() {
        return this.foodName;
    }

    /*
        FOODTYPE: GET AND SET METHOD
     */
    public int getFoodType() {
        return this.foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }

    /*
        FOODVALUE: GET METHOD
     */
    public int getFoodValue() {
        return this.foodValue;
    }

    /*
        FOODCOST: GET METHOD
     */
    public int getFoodCost() {
        return this.foodCost;
    }

    /*
        FOODCOUNT: GET AND SET METHOD
     */
    public int getFoodCount() {
        return this.foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    /*
        METHODS
     */
    
    /*
        decFoodCount Method
        
        Parameters: None
        Return: None
        Description: Decrements the quantity of a food object. If the decremented quantity is less than 0, the food object's quantity is set to 0.
     */
    public void decFoodCount() {
        int dec_foodCount = this.getFoodCount() - 1;

        if (dec_foodCount < 0) {
            this.setFoodCount(0);
        } else {
            this.setFoodCount(dec_foodCount);
        }
    }

    /*
        incFoodCount Method
        
        Parameters: None
        Return: None
        Description: Increments the quantity of a food object.
     */
    public void incFoodCount() {
        this.foodCount += INC_FOOD_COUNT;
    }

    /*
        OVERRIDE TOSTRING METHOD
        Parameters: None
        Return: String
        Description: Returns useful description of the food object.
    
     */
    @Override
    public String toString() {
        return this.getFoodName() + "\n\t-Hunger Value: " + this.getFoodValue() + " points \n\t-Cost: $" + this.getFoodCost() + "\n\t-Quantity: " + this.getFoodCount() + "\n";
    }

    /*
        toStringNoCost Method
    
        Parameters: None
        Return: String
        Description: Returns useful description of the food object without its cost.
    
     */
    public String toStringNoCost() {
        return this.getFoodName() + "\n\t-Hunger Value: " + this.getFoodValue() + "\n\t-Quantity: " + this.getFoodCount();
    }

}
