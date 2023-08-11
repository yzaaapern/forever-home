/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author yzape
 */
public class Game {
    
    private final Player player;
    
    public Game(Player player){
        this.player = player;
    }
    
    public Game(Player player, Animal fosterPet){
        this.player = player;
        this.player.fosterPet = fosterPet;
    }
    
    public void displayMainMenu(){
        
    }
    
    public void displayFosterMenu(){
        
    }
    
    public void displayInteractMenu(){
        
    }
    
    public void displayFoodMenu(){
        
    }
    
    public boolean isValidInput(String input){
        return true;
    }
}
