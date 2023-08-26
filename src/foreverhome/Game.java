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
    
    public Game(Player player){
        this.player = player;
        this.displayFosterMenu();
        
    }
    
    public Game(Player player, Animal fosterPet){
        this.player = player;
        this.player.fosterPet = fosterPet;
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
            fosterName = scanner.nextLine();
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
        
        this.displayPetFosterMenu();
    }
    public void displayPetFosterMenu(){
        String input;
        int inputNum = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(this.player.fosterPet.toString());
        System.out.println("Choose one of the following:");
        System.out.println("1. Feed " + this.player.fosterPet.name);
        System.out.println("2. Bathe " + this.player.fosterPet.name);
        System.out.println("3. Play or do tricks with " + this.player.fosterPet.name);
        System.out.println("4. Buy food for " + this.player.fosterPet.name);
        System.out.println("x - Exit the game");
        
        do{
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
           }
            
            switch(inputNum){
                case 1:
                    this.displayFoodMenu();
                    break;
                case 2:
                    this.player.fosterPet.incHygiene();
                    if(this.player.fosterPet.checkLevelForIncLevel()){
                        this.player.fosterPet.incLevel();
                        this.player.incDabloons();
                    }
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
    
    public void displayInteractMenu(){
        String input;
        int inputNum = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Play with " + this.player.fosterPet.name + " or teach them some new tricks!");
        System.out.println("Choose one of the following: \n");
        System.out.println("1. Give " + this.player.fosterPet.name + " a pat");
        System.out.println("2. Play with " + this.player.fosterPet.name);
        System.out.println("3. Tell them to go potty (only available if your pet foster is level 5+");
        System.out.println("4. Tell them to bow (only available if your pet foster is level 6+");
        System.out.println("5. Shake hands with " + this.player.fosterPet.name + "(only available if your pet foster is level 7+)");
        System.out.println("6. Get your pet foster to spin in a circle (only available if your pet foster is level 8+)");
        System.out.println("7. Tell " + this.player.fosterPet.name + " to play dead (only available if your pet foster is level 9+)");
        System.out.println("8. Get your pet foster to fetch a ball (only available if your pet foster is level 10");
        System.out.println("9. Go back to Pet Foster Menu");
        System.out.println("x - Exit the game");
        
        do{
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
           }
            
            switch(inputNum){
                case 1:
                    this.player.fosterPet.givePat();
                    if(this.player.fosterPet.checkLevelForIncLevel()){
                        this.player.fosterPet.incLevel();
                        this.player.incDabloons();                        
                    }
                    System.out.println(this.player.fosterPet.toString());
                    break;
                case 2:
                    this.player.fosterPet.playWithFoster();
                    if(this.player.fosterPet.checkLevelForIncLevel()){
                        this.player.fosterPet.incLevel();
                        this.player.incDabloons();
                        
                    }
                    System.out.println(this.player.toString());
                    break;
                case 3: 
                    this.player.fosterPet.goPotty();
                    if(this.player.fosterPet.checkLevelForIncLevel()){
                        this.player.fosterPet.incLevel();
                        this.player.incDabloons();                        
                    }
                    System.out.println(this.player.toString());
                    break;
                case 4:
                    this.player.fosterPet.bow();
                    if(this.player.fosterPet.checkLevelForIncLevel()){
                        this.player.fosterPet.incLevel();
                        this.player.incDabloons();                        
                    }
                    System.out.println(this.player.toString());
                    break;
                case 5:
                    this.player.fosterPet.shakeHands();
                    if(this.player.fosterPet.checkLevelForIncLevel()){
                        this.player.fosterPet.incLevel();
                        this.player.incDabloons();                        
                    }
                    System.out.println(this.player.toString());
                    break;
                case 6:
                    this.player.fosterPet.spin();
                    if(this.player.fosterPet.checkLevelForIncLevel()){
                        this.player.fosterPet.incLevel();
                        this.player.incDabloons();                      
                    }
                    System.out.println(this.player.toString());
                    break;
                case 7:
                    this.player.fosterPet.playDead();
                    if(this.player.fosterPet.checkLevelForIncLevel()){
                        this.player.fosterPet.incLevel();
                    }
                    System.out.println(this.player.toString());
                    break;
                case 8:
                    this.player.fosterPet.fetch();
                    if(this.player.fosterPet.checkLevelForIncLevel()){
                        this.player.fosterPet.incLevel();
                        this.player.incDabloons();                        
                    }
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
    
    public void buyFoodMenu(){
        String input;
        int inputNum;
        Scanner scanner = new Scanner(System.in);
        

        
        switch(checkFosterPet(this.player.fosterPet)){
            case 1:
                // Buy dog related foods
                break;
            case 2:
                // Buy cat related foods
                break;
            case 3:
                // Buy rat related foods
                break;
            case 4:
                // Buy parrot related foods;
                break;
            case 5:
                // Buy chicken related foods;
                break;
            case 6:
                // Go back to petFosterMenu
                break;
                
            default: break;
        }
    }
    public void displayFoodMenu(){
        switch(checkFosterPet(this.player.fosterPet)){
            case 1:
                this.displayDogAndCatFoodMenu();
                break;
            case 2:
                this.displayDogAndCatFoodMenu();
                break;
            case 3:
                this.displayRatParrotAndChickenFoodMenu();
                break;
            case 4:
                this.displayRatParrotAndChickenFoodMenu();
                break;
            case 5:
                this.displayRatParrotAndChickenFoodMenu();
                break;
            default: break;
        }
    }
    
    public void displayDogAndCatFoodMenu(){
        String input;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Feed your foster pet with something tasty! Choose one of the following: ");
        System.out.println("1. " );
        System.out.println("");
        
        do{
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                break;
            }
            
            switch(Integer.parseInt(input)){
                case 1:
                    //Food For All
                    break;
                case 2:
                    //Kibble
                    break;
                case 3:
                    //Canned Food
                    break;
                case 4:
                    //Rainbow Treat
                    break;
                default: break;
            }
        }while(!isValidInput(input));
    }
    
    public void displayRatParrotAndChickenFoodMenu(){
        String input;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Feed your pet foster with something tasty! Choose one of the following: ");
        System.out.println("1. " );
        System.out.println("");
        
        do{
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                break;
            }
            
            switch(Integer.parseInt(input)){
                case 1:
                    //Food For All
                    break;
                case 2:
                    //Veggie Mix
                    break;
                case 3:
                    //Seeds
                    break;
                case 4:
                    //Rainbow Treat
                    break;
                default: break;
            }
        }while(!isValidInput(input));
    } 
    
    public int checkFosterPet(Animal fosterPet){
        int animalType = 0;
        
        if(fosterPet instanceof Dog){
            animalType = 1;
            return animalType;
        }

        else if(fosterPet instanceof Cat){
            animalType = 2;
            return animalType;
        }
        
        else if(fosterPet instanceof Rat){
            animalType = 3;
            return animalType;
        }
        
        else if(fosterPet instanceof Parrot){
            animalType = 4;
            return animalType;
        }
        
        else{
            animalType = 5;
            return animalType;
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
            
            System.out.println("Invalid input.\nPlease try again.");
            return false;
            
        }
        return true;
    }
}
