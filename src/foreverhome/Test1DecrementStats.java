/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author annga
 */
public class Test1DecrementStats 
{
    public static void main(String[] args) 
    {
        Animal cat = new Cat("Catty Poo");
        Food rainbowTreat = new Food("Rainbow Treat", 28, 20, 0);
        
        DecrementStatsRunnable dsr = new DecrementStatsRunnable(cat);
        Thread catThread = new Thread(dsr);
        catThread.start();
        
        cat.incHunger(rainbowTreat);
        cat.incHappiness();
            
    }
}
