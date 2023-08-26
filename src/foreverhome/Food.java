/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author annga
 */
public class Food 
{
    // protected instance variables
    protected String foodName;
    protected int foodValue;
    protected int foodCost;
    protected int foodCount;
    protected final int INC_FOOD_COUNT = 5;
    
    // default constructor
    public Food()
    {
        this.foodName = "";
        this.foodValue = 0;
        this.foodCost = 0;
        this.foodCount = 0;
    }
    
    
    // constructor 
    public Food(String foodName, int foodValue, int foodCost, int foodCount)
    {
        this.foodName = foodName;
        this.foodValue = foodValue;
        this.foodCost = foodCost;
        this.foodCount = foodCount;
    }

    // methods
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
    
    public void decFoodCount()
    {
        if(this.getFoodCount()> 0)
        {
            this.foodCount--;
        }
    }
    
    private void incFoodCount()
    {
        this.foodCount += INC_FOOD_COUNT;
    }
    
    @Override
    public String toString()
    {
        return this.getFoodName() + "\n\t-Hunger Value: " + this.getFoodValue() + " points \n\t-Cost: $" + this.getFoodCost() + "\n\t-Quantity: " + this.getFoodCount();
    }
            
    
    

    
    
    
}
