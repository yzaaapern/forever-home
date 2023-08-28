/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author annga
 */
public class Test 
{
    public static void main(String[] args) 
    {
        Player player1 = new Player("Anny");
        Animal cat = new Cat("Poopoo cat");
        
        Game game = new Game(player1, cat);
        
        
//        LevelUpRunnable lur = new LevelUpRunnable(player1.getFosterPet());
//        Thread petLevelUpThread = new Thread(lur);
//        petLevelUpThread.start();
        
//        System.out.println(player1.getFosterPet());
        
        
        
//        DecrementStatsRunnable dsr = new DecrementStatsRunnable(player1.getFosterPet());
//        Thread petThread = new Thread(dsr);
//        petThread.start();

        
        
    }
}
