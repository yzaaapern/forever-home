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
 * Date Created: 
 * 
 */

public class Food 
{
    // Instance variables
    private String foodName;
    private int foodValue; // the amount of hunger points contained in one unit of the food
    private int foodCost; 
    private int foodCount; // the amount of specified food in the player's inventory
    private final int INC_FOOD_COUNT = 5; // when a specified food is bought, the amount of units increases by this value
    
    // Constructor 
    public Food(String foodName, int foodValue, int foodCost, int foodCount)
    {
        this.foodName = foodName;
        this.foodValue = foodValue;
        this.foodCost = foodCost;
        this.foodCount = foodCount;
    }

    // METHODS 
    
    // GET & SET METHODS
    // We do not need set methods for foodName, foodValue, and foodCost as once they are instanciated they do not need to be changed
    
    public String getFoodName()
    {
        return this.foodName;
    }
    
    public int getFoodValue()
    {
        return this.foodValue;
    }
    
    public int getFoodCost()
    {
        return this.foodCost;
    }
    
    public int getFoodCount()
    {
        return this.foodCount;
    }
    
    public void setFoodCount(int foodCount)
    {
        this.foodCount = foodCount;
    }
    
    // OTHER METHODS
    
    /* decFoodCount method
    
    Parameters: None
    Return: None
    Description: Decreases the food count of a food instance if the player has a sufficient amount (at least one unit of the food).
    */
    
    public void decFoodCount()
    {
        if(this.getFoodCount()> 0)
        {
            this.setFoodCount(foodCount--);
        }
    }
    
    /* incFoodCount method
    
    Parameters: None
    Return: None
    Description: Increases the food count of a food instance by the INC_FOOD_COUNT value (player buys food in bunches of INC_FOOD_COUNT).
    */
    
    private void incFoodCount()
    {
        this.setFoodCount(this.foodCount += INC_FOOD_COUNT); 
    }
    
    /* toString method
    
    Parameters: None
    Return: String
    Description: Displays a useful description of the food object
    */
    
    @Override
    public String toString()
    {
        return this.getFoodName() + " Hunger value: " + this.getFoodValue() + " points, cost: $" + this.getFoodCost() + " Quantity: " + this.getFoodCount();
    }
    
}
