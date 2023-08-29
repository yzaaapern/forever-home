/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author annga
 */
public abstract class Food 
{
    // Instance variables
    private String foodName;
    private int foodType; // integer for food type, type 0 is compatible with all animals, type 1 is for bigger animals (cats & dogs), type 2 is for smaller animals (rat, parrot, chicken).
    private int foodValue; // integer for how many hunger points the food has
    private int foodCost;
    private int foodCount;
    private final int INC_FOOD_COUNT = 5; // when food is bought, it increases by this amount.
    
    // Constructor 
    public Food(String foodName, int foodValue, int foodCost, int foodCount)
    {
        this.foodName = foodName;
        this.foodValue = foodValue;
        this.foodCost = foodCost;
        this.foodCount = foodCount;
    }

    // METHODS
    
    // Get & set methods
    public String getFoodName()
    {
        return this.foodName;
    }
    
        public int getFoodType()
    {
        return this.foodType;
    }
    
    public void setFoodType(int foodType)
    {
        this.foodType = foodType;
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
    
    public void decFoodCount()
    {
        int dec_foodCount = this.getFoodCount() - 1;
        
        if(dec_foodCount < 0)
        {
            this.setFoodCount(0);
        }
        else
        {
            this.setFoodCount(dec_foodCount);
        }
    }
    
    public void incFoodCount()
    {
        this.foodCount += INC_FOOD_COUNT;
    }
    
    @Override
    public String toString()
    {
        return this.getFoodName() + "\n\t-Hunger Value: " + this.getFoodValue() + " points \n\t-Cost: $" + this.getFoodCost() + "\n\t-Quantity: " + this.getFoodCount() + "\n";
    }
    
    public String toStringNoCost()
    {
        return this.getFoodName() + "\n\t-Hunger Value: " + this.getFoodValue() + "\n\t-Quantity: " + this.getFoodCount();
    }
            
    
    

    
    
    
}
