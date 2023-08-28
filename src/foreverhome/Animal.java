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
    
    public static final int INC_STAT = 10; // when a stat is increased it will increase by 10 points
    public static final int DEC_STAT = 5; // when a stat is decreased it will decrease by 5 points
    public static int DEFAULT_STAT = 100; // default stat cap for happiness, hygiene, hunger, and level xp 
    
    protected String name; 
    protected int happiness, hygiene, hunger, level, levelXP, statBar, levelXPBar;
    
    /*
        OBJECT CONSTRUCTOR
    */
    
    public Animal(String name){
        this.setName(name);
        this.setHappiness(0);
        this.setHygiene(0);
        this.setHunger(0);
        this.setLevel(0);
        this.setLevelXP(0);
        this.setStatBar(Animal.DEFAULT_STAT);
        this.setLevelXPBar(Level.DEFAULT_LEVELXP_CAP);
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
        HAPPINESS: SET AND GET METHOD
    */
    public void setHappiness(int happiness){
        this.happiness = happiness;
    }
    
    public int getHappiness(){
        return this.happiness;
    }
    
    /*
        HUNGER: SET AND GET METHOD
    */
    public void setHunger(int hunger){
        this.hunger = hunger;
        
    }
    
    public int getHunger(){
        return this.hunger;
    }
    
    /*
        HYGIENE: SET AND GET METHOD
    */
    public void setHygiene(int hygiene){
        this.hygiene = hygiene;
    }
    
    public int getHygiene(){
        return this.hygiene;
    }
    
    /*
        LEVELXP: SET AND GET METHOD
    */
     public void setLevelXP(int levelXP){
         this.levelXP = levelXP; 
    }
     
    public int getLevelXP(){
        return this.levelXP;
    }
    
    /*
        LEVEL: SET AND GET METHOD
    */
     public void setLevel(int level){
        this.level = level;
    }
     
    public int getLevel(){
        return this.level;
    }
    
    /*
        STATBAR: SET AND GET METHODS
    */
    public void setStatBar(int statBar){
        this.statBar = statBar;
    }
    
    public int getStatBar(){
        return this.statBar;
    }
    
    /*
        LEVELXPBAR: SET AND GET METHODS
    */
    public void setLevelXPBar(int levelXPBar){
        this.levelXPBar = levelXPBar;
    }
    
    public int getLevelXPBar(){
        return this.levelXPBar;
    }
    
    /*
        OVERRIDE TOSTRING METHOD
        Parameters: None
        Return: String
        Description: Returns useful description of the foster pet's stats.
    
    */

    @Override
    public String toString(){
        return ("---------------------\n" +
                "FOSTER PET STATS" +
                "\n-Foster Pet Name: " + this.name + 
                "\n-Level: " + this.level + " and Level XP: " + this.levelXP + "/" + this.levelXPBar +
                "\n-Hunger: " + this.hunger + "/" + this.statBar +
                "\n-Hygiene: " + this.hygiene + "/" + this.statBar +
                "\n-Happiness: " + this.happiness + "/" + this.statBar +
                "\n---------------------\n");
    }
    
    /*
        METHODS
    */
    
    /*  incHunger method
    
    Parameters: Food object
    Return: None
    Description: If the pet eats their hunger stat will increase,
    If the increase in hunger is greater than the cap, it will just be set to the cap (you cannot have more hunger points than the max cap)
    Otherwise, the hunger is the hunger + the increase in hunger constant.
    */
    
    public void incHunger(Food food){
        int inc_hunger = this.hunger + food.getFoodValue();
        if(inc_hunger > DEFAULT_STAT)
        {
            this.setHunger(DEFAULT_STAT);
        }
        else
        {
            this.setHunger(inc_hunger);
        }
        this.incLevelXP();
    }
    
    /*  decHunger method
    
    Parameters: None
    Return: None
    Description: The pet's hunger stat will decrease
    If the decrease in hunger is lower than 0, it will just be set to 0 (you cannot have negative hunger points)
    Otherwise, the hunger is the hunger - decrease in hunger constant.
    */
    
    public void decHunger(){
        int dec_hunger = this.hunger - Animal.DEC_STAT;
        if(dec_hunger < 0)
        {
            this.setHunger(0);
        }
        else
        {
            this.setHunger(dec_hunger);
        }
        
    }
    
    /*  incHunger method
    
    Parameters: None
    Return: None
    Description: Pet's happiness stat increases
    If the increase in happiness is greater than the cap, it will just be set to the cap (you cannot have more happiness points than the max cap)
    Otherwise, the happiness is the happiness + the increase in happiness constant.
    */
    
    public void incHappiness(){
        int inc_happiness = this.happiness + Animal.INC_STAT;
        if(inc_happiness > DEFAULT_STAT)
        {
            this.setHappiness(DEFAULT_STAT);
        }
        else
        {
            this.setHappiness(inc_happiness);
        }
        this.incLevelXP();
    }
    
    /*  decHappiness method
    
    Parameters: None
    Return: None
    Description: The pet's happiness stat will decrease
    If the decrease in happiness is lower than 0, it will just be set to 0 (you cannot have negative happiness points)
    Otherwise, the happiness is the happiness - decrease in happiness constant.
    */
    
    public void decHappiness(){
        int dec_happiness = this.happiness - Animal.DEC_STAT;
        if(dec_happiness < 0)
        {
            this.setHappiness(0);
        }
        else
        {
            this.setHappiness(dec_happiness);
        }
    }
    
    /*  incHygiene method
    
    Parameters: None
    Return: None
    Description: Pet's hygiene stat increases (this occurs when the pet is bathed)
    If the increase in hygiene is greater than the cap, it will just be set to the cap (you cannot have more hygiene points than the max cap)
    Otherwise, the hygiene is the hygiene + the increase in hygiene constant.
    */
    
    public void incHygiene(){
        int inc_hygiene = this.hygiene + Animal.INC_STAT;
        if(inc_hygiene > DEFAULT_STAT)
        {
            this.setHygiene(DEFAULT_STAT);
        }
        else
        {
            this.setHygiene(inc_hygiene);
        }
        this.incLevelXP();
    }
    
    /*  decHygiene method
    
    Parameters: None
    Return: None
    Description: The pet's hygiene stat will decrease (normally when playing)
    If the decrease in hygiene is lower than 0, it will just be set to 0 (you cannot have negative hygiene points)
    Otherwise, the hygiene stat is the hygiene - decrease in hygiene constant.
    */
    
    public void decHygiene(){
        int dec_hygiene = this.hygiene - Animal.DEC_STAT;
        if(dec_hygiene < 0)
        {
            this.setHygiene(0);
        }
        else
        {
            this.setHygiene(dec_hygiene);
        }
    }
    
    /*
        OVERRIDE INTERACT METHODS
    */
    
    /*  givePat method
    
    Parameters: None
    Return: None
    Description: When the player pats their pet the pet becomes happier and increases pet's xp
    */
    
    @Override
    public void givePat() {
        this.incHappiness();
        this.incLevelXP();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*  playWithFoster method
    
    Parameters: None
    Return: None
    Description:  When the player plays with their pet, the pet becomes happier, hungier, a bit dirty, and increases pet's xp
    */
    
    @Override
    public void playWithFoster() {
        this.incHappiness();
        this.decHunger();
        this.decHygiene();
        this.incLevelXP();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*  goPotty method
    
    Parameters: None
    Return: None
    Description: If the pet has unlocked potty and the pet goes potty, the pet will become happier, a bit dirty, and increases pet's xp
    */
    
    @Override
    public void goPotty() {
        int levelUnlocked = 5;
        if(checkLevelForInteract(levelUnlocked)){
            this.incHappiness();
            this.decHygiene();
            this.incLevelXP();
        }
        else{
            System.out.println("You cannot do this trick yet! " + this.name + " has yet to reach Level 5.");
        }
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*  bow method
    
    Parameters: None
    Return: None
    Description: If the pet has unlocked bow and the pet does the bow trick, the pet will become happier and increases the pet's xp
    Otherwise, if the pet has not unlocked bow, the system will tell the player that they cannot do the trick yet.
    */
    
    @Override
    public void bow() {
        int levelUnlocked = 6;
        if(checkLevelForInteract(levelUnlocked)){
            this.incHappiness();
            this.incLevelXP();
        }
        else{
            System.out.println("You cannot do this trick yet! " + this.name + " has yet to reach Level 6.");
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*  shakeHands method
    
    Parameters: None
    Return: None
    Description: If the pet has unlocked shake hands and the pet does the shake hand trick, the pet will become happied and increases the pet's xp
    Otherwise, if the pet has not unlocked shake hands, the system will tell the player that they cannot do the trick yet.
    */
    
    @Override
    public void shakeHands() {
        int levelUnlocked = 7;
        if(checkLevelForInteract(levelUnlocked)){
            this.incHappiness();
            this.incLevelXP();
        }
        else{
            System.out.println("You cannot do this trick yet! " + this.name + " has yet to reach Level 7.");
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*  spin method
    
    Parameters: None
    Return: None
    Description: If the pet has unlocked spin and the pet does a spin trick 
    */
    
    @Override
    public void spin() {
        int levelUnlocked = 8;
        if(checkLevelForInteract(levelUnlocked)){
            this.incHappiness();
            this.incLevelXP();
        }
        else{
            System.out.println("You cannot do this trick yet! " + this.name + " has yet to reach Level 8.");
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*  givePat method
    
    Parameters:
    Return:
    Description: 
    */
    
    @Override
    public void playDead() {
        int levelUnlocked = 9;
        if(checkLevelForInteract(levelUnlocked)){
            this.incHappiness();
            this.incLevelXP();
        }
        else{
            System.out.println("You cannot do this trick yet! " + this.name + " has yet to reach Level 9.");
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*  givePat method
    
    Parameters:
    Return:
    Description: 
    */
    
    @Override
    public void fetch() {
        int levelUnlocked = 10;
        if(checkLevelForInteract(levelUnlocked)){
            this.incHappiness();
            this.decHunger();
            this.decHygiene();
            this.incLevelXP();
        }
        else{
            System.out.println("You cannot do this trick yet! " + this.name + " has yet to reach Level 10.");
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
        OVERRIDE LEVEL METHODS
    */
    
    @Override
    public boolean checkLevelForInteract(int level) {
        return this.level >= level;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean checkLevelForIncLevel(){
        return (this.happiness == this.getStatBar()
                && this.hunger == this.getStatBar()
                && this.hygiene == this.getStatBar()
                && this.levelXP == this.getLevelXPBar());
    }

    @Override
    public int incLevel() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int inc_level = this.getLevel();
        if(checkLevelForIncLevel()){
            
            this.resetLevelXP();
            this.setLevelXPBar(levelXPBar += Level.INC_LEVELXP_CAP);
            inc_level++;
            this.setLevel(inc_level);
        }
        
        return this.level;
    }

    @Override
    public void incLevelXP() {
        int inc_levelXP = this.levelXP + Level.INC_EXP;
        if(inc_levelXP > this.levelXPBar)
        {
            this.setLevelXP(this.levelXPBar);
        }
        else
        {
            this.setLevelXP(inc_levelXP);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void decLevelXP() {
        int dec_levelXP = this.levelXP - Level.DEC_EXP;
        if(dec_levelXP < 0)
        {
            this.setLevelXP(0);
        }
        else
        {
            this.setLevelXP(dec_levelXP);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void resetLevelXP() {
        this.setLevelXP(0);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
