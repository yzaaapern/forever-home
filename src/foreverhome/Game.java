/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

import java.util.Scanner;
/**
 *
 * @author yzape
 */
public class Game {
    
    private final Player player;
    public LevelUpRunnable lur;
    public DecrementStatsRunnable dsr;
    public Thread petLevelUpThread, petDecrementStatsThread;
    
    public Game(Player player){
        this.player = player;
        this.displayFosterMenu();
        
    }
    
    public Game(Player player, Animal fosterPet){
        this.player = player;
        this.player.fosterPet = fosterPet;
        this.player.hasFosterPet = true;
        
//        this.lur = new LevelUpRunnable(this.player);
//        this.petLevelUpThread = new Thread(this.lur);
//        this.petLevelUpThread.start();
        
        this.dsr = new DecrementStatsRunnable(this.player);
        this.petDecrementStatsThread = new Thread(this.dsr);
        this.petDecrementStatsThread.start();
        
        this.displayPetFosterMenu();
        
    }
    
    public void displayFosterMenu(){
        String input;
        String fosterName;
        Animal a;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome " + this.player.getName() + " to Forever Home!");
        System.out.println("Current Stats: ");
        System.out.println(this.player.toString());
        System.out.println("Pick an animal that you would like to foster: ");        
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Rat");
        System.out.println("4. Parrot");
        System.out.println("5. Chicken");
        
        do{
            System.out.print("Your choice: ");
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                break;
            }
            
        }while(!isValidInput(input));
        
        do{
            System.out.print("Give them a name: ");
            fosterName = scanner.next();
        }while(fosterName == "" || fosterName == " ");
        
        
        switch(Integer.parseInt(input)){
            case 1:
                System.out.println("You chose a dog!");
                a = new Dog(fosterName);
                this.player.fosterPet = a;
                this.player.hasFosterPet = true;
                break;
            case 2:
                System.out.println("You chose a cat!");
                a = new Cat(fosterName);
                this.player.fosterPet = a;
                this.player.hasFosterPet = true;
                break;
            case 3: 
                System.out.println("You chose a rat!");
                a = new Rat(fosterName);
                this.player.fosterPet = a;
                this.player.hasFosterPet = true;
                break;
            case 4: 
                System.out.println("You chose a parrot!");
                a = new Parrot(fosterName);
                this.player.fosterPet = a;
                this.player.hasFosterPet = true;
                break;
            case 5: 
                System.out.println("You chose a chicken!");
                a = new Chicken(fosterName);
                this.player.fosterPet = a;
                this.player.hasFosterPet = true;
                break;
            default: break;
        }
        
        this.dsr = new DecrementStatsRunnable(this.player);
        this.petDecrementStatsThread = new Thread(this.dsr);
        this.petDecrementStatsThread.start();
        
        this.displayPetFosterMenu();
    }
    
    public void displayPetFosterMenu(){
        String input;
        int inputNum = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("##############################");
        System.out.println("        PET FOSTER MENU       ");
        System.out.println("##############################");
        System.out.println(this.player.toString());
        System.out.println("Choose one of the following:");
        System.out.println("1. Feed " + this.player.fosterPet.getName());
        System.out.println("2. Bathe " + this.player.fosterPet.getName());
        System.out.println("3. Play or do tricks with " + this.player.fosterPet.getName());
        System.out.println("4. Buy food for " + this.player.fosterPet.getName());
        
        
        System.out.println("x - Exit the game");
        
        do{
            System.out.print("Your choice: ");
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                break;
            }
            
           try{
               inputNum = Integer.parseInt(input);
           }
           catch(NumberFormatException ex){
               if(input == "" || input == " "){
                   input = scanner.nextLine();
               }
               if(input.equalsIgnoreCase("x")){
                   break;
               }
           }
            
            switch(inputNum){
                case 1:
                    this.feedFosterMenu();
                    break;
                case 2:
                    this.player.fosterPet.incHygiene();
                    System.out.println(this.player.fosterPet.toString());
                    break;
                case 3: 
                    this.displayInteractMenu();
                    break;
                case 4:
                    this.buyFoodMenu();
                    break;
                default: break;     
            }
            
            this.displayPetFosterMenu();
        }while(!this.isValidInput(input));
        
    }
    
    public void displayInteractMenu()
    {
        String input;
        int inputNum = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Play with " + this.player.fosterPet.getName() + " or teach them some new tricks!");
        System.out.println("Choose one of the following: \n");
        System.out.println("1. Give " + this.player.fosterPet.getName() + " a pat");
        System.out.println("2. Play with " + this.player.fosterPet.getName());
        System.out.println("3. Tell them to go potty (only available if your pet foster is level 5+");
        System.out.println("4. Tell them to bow (only available if your pet foster is level 6+");
        System.out.println("5. Shake hands with " + this.player.fosterPet.getName() + "(only available if your pet foster is level 7+)");
        System.out.println("6. Get your pet foster to spin in a circle (only available if your pet foster is level 8+)");
        System.out.println("7. Tell " + this.player.fosterPet.getName() + " to play dead (only available if your pet foster is level 9+)");
        System.out.println("8. Get your pet foster to fetch a ball (only available if your pet foster is level 10");
        System.out.println("9. Go back to Pet Foster Menu");
        System.out.println("x - Exit the game");
        
        do
        {
            System.out.print("Your choice: ");
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                break;
            }
            
            try{
               inputNum = Integer.parseInt(input);
           }
           catch(NumberFormatException ex){
               if(input == "" || input == " "){
                   input = scanner.nextLine();
               }
               if(input.equalsIgnoreCase("x")){
                   break;
               }
           }
            
            switch(inputNum){
                case 1:
                    this.player.fosterPet.givePat();
                    System.out.println(this.player.fosterPet.toString());
                    break;
                case 2:
                    this.player.fosterPet.playWithFoster();
                    System.out.println(this.player.toString());
                    break;
                case 3: 
                    this.player.fosterPet.goPotty();
                    System.out.println(this.player.toString());
                    break;
                case 4:
                    this.player.fosterPet.bow();
                    System.out.println(this.player.toString());
                    break;
                case 5:
                    this.player.fosterPet.shakeHands();
                    System.out.println(this.player.toString());
                    break;
                case 6:
                    this.player.fosterPet.spin();
                    System.out.println(this.player.toString());
                    break;
                case 7:
                    this.player.fosterPet.playDead();
                    System.out.println(this.player.toString());
                    break;
                case 8:
                    this.player.fosterPet.fetch();
                    System.out.println(this.player.toString());
                    break;
                case 9:
                    System.out.println("Returning back to Pet Foster Menu.");
                    this.displayPetFosterMenu();
                    break;
                default: break;
                
            }
            
        }while(!this.isValidInput(input));
    }
    
    public void buyFoodMenu()
    {
        Food boughtFood = null;
        
        boughtFood = this.player.getFoodInventory().getValidFoodMenu(this.player.getFosterPet().getAnimalFoodType());
        if(this.player.getDabloons() >= boughtFood.getFoodCost())
        {
            boughtFood.incFoodCount();
            this.player.decDabloons(boughtFood);
        }
    }
    
    public void feedFosterMenu()
    {
        Food chosenFood = null;
        
        chosenFood = this.player.getFoodInventory().getValidFoodMenu(this.player.getFosterPet().getAnimalFoodType());
        if(chosenFood.getFoodCount() > 0)
        {
            chosenFood.decFoodCount();
            this.player.getFosterPet().incHunger(chosenFood);
        }
    }
    
    public boolean isValidInput(String input){
        try{
            Integer.parseInt(input);
        }
        
        catch(NumberFormatException ex){
            if(input.equalsIgnoreCase("x")){
                return true;
            }
            
            if(input == "" || input == " "){
                System.out.println("Invalid input.\nPlease try again.");
                return false;
            }
            
            System.out.println("Invalid input.\nPlease try again.");
            return false;
            
        }
        return true;
    }
    
    public void endGameMessage()
    {
        System.out.println("Thank you " + this.player.getName() + " for playing ForeverHome, until next time! ");
    }
    
    public void adoptionMenu()
    {
        
        
        // message
        
        // option to put for adoption or just keep playing with pet for a bit longer
        // when pet is adopted, this.player.hasFoster = false;
    }
    
}
