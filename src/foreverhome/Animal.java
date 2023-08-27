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
    public static int DEFAULT_STAT = 100;
    
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
    */
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return ("\n---------------------\n" +
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
    @Override
    public void givePat() {
        this.incHappiness();
        this.incLevelXP();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void playWithFoster() {
        this.incHappiness();
        this.decHunger();
        this.decHygiene();
        this.incLevelXP();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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
        if(checkLevelForIncLevel()){
            this.resetLevelXP();
            this.setLevelXPBar(levelXPBar += Level.INC_LEVELXP_CAP);
            return this.level++;
        }
        
        else{
            return this.level;
        }
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
