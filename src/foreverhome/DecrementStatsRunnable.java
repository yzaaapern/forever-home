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

public class DecrementStatsRunnable implements Runnable
{
    // Instance variables
    public Player player;
    public final int TIME_INTERVAL = 5000; // time interval between stat decrements is 1 minute
    
    // Constructor
    public DecrementStatsRunnable(Player player)
    {
        this.player = player;
    }
    
    // METHODS
    
    /* run method
    
    Parameters: None
    Return: None
    Description: While the player has a foster pet, the foster pet's stats (happiness, hunger, and hygiene) will decrease over time. 
    */
    
    @Override
    public void run()
    {
        // while the player has a foster pet, the player's foster pet's happiness, hunger, and hygience will decrease over time
        while(this.player.hasFosterPet == true)
        {
            this.player.getFosterPet().decHappiness(); 
            this.player.getFosterPet().decHunger();
            this.player.getFosterPet().decHygiene();
            
            try
            {
                Thread.sleep(TIME_INTERVAL); // thread will sleep for the allocated time interval
            }
            catch(InterruptedException e)
            {
                System.err.println(e);
            }
        }
        
        
    }
}
