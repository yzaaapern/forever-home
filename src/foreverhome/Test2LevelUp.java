/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author annga
 */
public class Test2LevelUp 
{
    public static void main(String[] args) 
    {
        Animal cat = new Cat("Catty Poo");
        Food rainbowTreat = new Food("Rainbow Treat", 28, 20, 0);
        
        LevelUpRunnable lur = new LevelUpRunnable(cat);
        Thread catLevelUpThread = new Thread(lur);
        catLevelUpThread.start();
        
        cat.incHunger(rainbowTreat);
        cat.incHunger(rainbowTreat);
        cat.incHunger(rainbowTreat);
        cat.incHunger(rainbowTreat);
        cat.incHunger(rainbowTreat);
        System.out.println(cat);
        cat.incHunger(rainbowTreat);
        cat.incHunger(rainbowTreat);
        System.out.println(cat);
        cat.incHunger(rainbowTreat);
        cat.incHunger(rainbowTreat);
        System.out.println(cat);
        cat.incHunger(rainbowTreat);
        cat.incHunger(rainbowTreat);
        System.out.println(cat);
        
        cat.incHappiness();
    }
}
