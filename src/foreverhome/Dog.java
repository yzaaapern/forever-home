/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author yzape
 */
public class Dog extends Animal{
    
    public Dog(String name){
        super(name);
        this.setAnimalFoodType(1);
    }
    
    public Dog(String name, int happiness, int hunger, int hygiene, int levelXP, int levelXPBar, int level){
        super(name, happiness, hunger, hygiene, levelXP, levelXPBar, level);
        this.setAnimalFoodType(1);
    }
}
