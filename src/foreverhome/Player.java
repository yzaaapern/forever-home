/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author yzape
 */
public class Player {
    
    private String name;
    public Animal fosterPet;
    public boolean hasFosterPet;
    
    public Player(String name){
        this.setName(name);
        this.setFosterPet(null);
        this.hasFosterPet = false;
    }
    
    public Player(String name, Animal fosterPet){
        this.setName(name);
        this.setFosterPet(fosterPet);
        this.hasFosterPet = true;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setFosterPet(Animal fosterPet){
        this.fosterPet = fosterPet;
    }
    
    public Animal getFosterPet(){
        return this.fosterPet;
    }
    
    public String toString(){
        return "Username: " + this.name + "\n" + this.fosterPet.toString();
        
    }
}
