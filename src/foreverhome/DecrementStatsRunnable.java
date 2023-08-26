/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author annga
 */
public class DecrementStatsRunnable implements Runnable
{
    // instance variables
    public Animal pet;
    public final int TIME_INTERVAL = 60000; // time interval between stat decrements is 1 minute
    
    // constructor
    public DecrementStatsRunnable(Animal animal)
    {
        this.pet = animal;
    }
    
    @Override
    public void run()
    {
        
        // while the pet's happiness, hunger, and hygiene stats are greater than 0, it will decrement those stats.
        while(this.pet.getHappiness() > 0 || this.pet.getHunger() > 0 || this.pet.getHygiene() > 0)
        {
            this.pet.decHappiness();
            this.pet.decHunger();
            this.pet.decHygiene();
            System.out.println(this.pet.toString() + "\n");
            
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
