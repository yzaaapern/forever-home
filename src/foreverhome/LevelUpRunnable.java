/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author annga
 */
public class LevelUpRunnable implements Runnable
{
    // instance variables
    public Animal pet;
    public final int MAX_LEVEL = 10;
    public final int TIME_INTERVAL = 5000;
    
    // constructor
    public LevelUpRunnable(Animal animal)
    {
        this.pet = animal;
    }
    
    @Override
    public void run()
    {
        while(pet.getLevel() < MAX_LEVEL)
        {
            
            if(pet.checkLevelForIncLevel())
            {
                pet.incLevel();
                System.out.println(pet);
            }
            try
            {
                Thread.sleep(TIME_INTERVAL);
                System.out.println(pet);
            }
            catch(InterruptedException e)
            {
                System.err.println(e);
            }
            
        }

    }
    
    
}
