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

public class LevelUpRunnable implements Runnable
{
    // Instance variables
    public Animal fosterPet;
    public final int MAX_LEVEL = 10; // Highest level cap for a foster pet
    public final int TIME_INTERVAL = 5000; // time interval between level up checks 
    
    // Default Constructor
    public LevelUpRunnable()
    {
        this.fosterPet = null;
    }
    
    // Constructor
    public LevelUpRunnable(Animal animal)
    {
        this.fosterPet = animal;
    }
    
    // METHODS
    
    /* run method
    
    Parameters: None
    Return: None
    Description: While the foster pet is under the max level, the thread will run and check if the pet is able to level up
    */
    
    @Override
    public void run()
    {
        while(fosterPet.getLevel() < MAX_LEVEL)
        {
            System.out.println(fosterPet);
            fosterPet.incLevel();
            try
            {
                Thread.sleep(TIME_INTERVAL);
            }
            catch(InterruptedException e)
            {
                System.err.println(e);
            }
            
        }

    }    
    
}
