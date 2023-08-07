/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author yzape
 */
public abstract class Animal implements Interact, Level{

    /*
        INSTANCE AND CONSTANT VARIABLES
    */
    public static final int INC_STAT = 10;
    public static final int DEC_STAT = 5;
    public static final int STAT_THRESHOLD = 25;
    public final int DEFAULT_STAT = 100;
    
    protected String name;
    protected int happiness, hygiene, hunger, level, levelXP;
    
    /*
        OBJECT CONSTRUCTOR
    */
    public Animal(String name){
        this.setName(name);
        this.happiness = 0;
        this.hygiene = 0;
        this.hunger = 0;
        this.level = 0;
        this.levelXP = 0;
    }
    
    /*
        NAME: SET AND GET METHOD
    */
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    /*
        HAPPINESS: GET METHOD
    */
    
    public int getHappiness(){
        return this.happiness;
    }
    
    public int getHunger(){
        return this.hunger;
    }
    
    public int getHygiene(){
        return this.hygiene;
    }
    
    public int getLevelXP(){
        return this.levelXP;
    }
    
    public int getLevel(){
        return this.level;
    }
    
    
    /*
        OVERRIDE TOSTRING METHOD
    */
    
    public String toString(){
        return (this.name + ",  level: " + this.level + " and level exp: " + this.levelXP + 
                "\nHunger: " + this.hunger + 
                "\nHygiene: " + this.hygiene +
                "\nHappiness: " + this.happiness);
    }
    /*
        METHODS
    */
    
//    public void incHunger(Food food){
//        this.hunger += food.value;
//    }
    
    public void decHunger(){
        
    }
    
    public void incHappiness(){
        this.happiness += Animal.INC_STAT;
        this.incLevelExp();
    }
    
    public void decHappiness(){
        
    }
    
    public void incHygiene(){
        this.hygiene += INC_STAT;
        this.incLevelExp();

    }
    
    public void decHygiene(){
        
    }
    
    /*
        OVERRIDE INTERACT METHODS
    */
    @Override
    public void givePat() {
        this.incHappiness();
        this.incLevelExp();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void playWithFoster() {
        this.incHappiness();
        this.incLevelExp();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void goPotty() {
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void bow() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void shakeHands() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void spin() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void playDead() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void fetch() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
        OVERRIDE LEVEL METHODS
    */
    @Override
    public int checkLevelExp(int levelXP) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return 0;
    }

    @Override
    public int incLevel() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return 0;
    }

    @Override
    public void incLevelExp() {
        this.levelXP += Level.INC_EXP;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void decLevelExp() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void resetLevelExp() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
