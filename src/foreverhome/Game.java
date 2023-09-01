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
    public static volatile boolean startThreads = true;
    public DecrementStatsRunnable dsr;
    public Thread petDecrementStatsThread;
    InteractionList interactionList = new InteractionList();
    
    public Game(Player player){
        this.player = player;
        this.player.isPlaying = true;

        //this.startGameMessage();
        this.displayFosterMenu();

    }

    public Game(Player player, Animal fosterPet) {
        this.player = player;
        this.player.fosterPet = fosterPet;
        this.player.isPlaying = true;
        this.player.hasFosterPet = true;

        //this.startGameMessage();
        this.displayPetFosterMenu();

    }
    
    public void displayFosterMenu(){
        
        // Variables
        int inputNum = 0;
        String fosterName;
        Animal a;
        this.player.isPlaying = true; // the user is playing.
        
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Welcome prompt
        System.out.println("Welcome " + this.player.getName() + " to Forever Home!");
        
        // Display user stats
        System.out.println("Current Stats: ");
        System.out.println(this.player.toString());
        
        // Pick a foster animal prompt
        System.out.println("Pick an animal that you would like to foster: ");        
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Rat");
        System.out.println("4. Parrot");
        System.out.println("5. Chicken");
        
        // User inputs a number for which animal they wish to foster
        inputNum = this.userEnterInput(Animal.NUM_OF_ANIMAL_CLASS);
        
        // User names their foster pet
        do{
            System.out.print("Give them a name: ");
            fosterName = scanner.next();
        }while(fosterName == "" || fosterName == " "); // if the foster name is empty spaces, repeat the prompt. We do not want an empty name
               
        // Foster pet is instantiated
        switch(inputNum){
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
        
        // Display the Pet Foster Menu
        this.displayPetFosterMenu();
    }
    
    public void displayPetFosterMenu(){
        int numOfOptions = 4;
        int inputNum = 0;
        
        this.startThreads();
        
        // If the pet is max level, they are ready for adoption
        if(this.player.getFosterPet().getLevel() == Animal.MAX_LEVEL)
        {
            System.out.println(this.player.getFosterPet().getName() + " is ready for adoption! ");
            numOfOptions = 5;
        }
        
        // Pet Foster Menu Title
        System.out.println("##############################");
        System.out.println("        PET FOSTER MENU       ");
        System.out.println("##############################");
        
        // Display user stats
        System.out.println(this.player.toString());
        
        // Pet Foster Menu
        System.out.println("Choose one of the following:");
        System.out.println("1. Feed " + this.player.fosterPet.getName());
        System.out.println("2. Bathe " + this.player.fosterPet.getName());
        System.out.println("3. Play or do tricks with " + this.player.fosterPet.getName());
        System.out.println("4. Buy food for " + this.player.fosterPet.getName());   

        // If the pet is max level/ready to adopt, an extra menu option is presented
        if(this.player.getFosterPet().getLevel() == Animal.MAX_LEVEL)
        {
            // Option 5. Adoption 
            System.out.println("5. Find "+ this.player.fosterPet.getName() + "'s forever home :)");
            System.out.println("x - Exit the game");
            
            // User enters a number
            inputNum = this.userEnterInput(numOfOptions);
        }
        else
        {
            // User enters a number
            System.out.println("x - Exit the game");
            inputNum = this.userEnterInput(numOfOptions);
        }

        switch(inputNum){
            case 1:
                // User wants to feed their pet
                this.feedPetFosterMenu();
                break;
            case 2:
                // User wants to bathe their pet
                this.player.giveBath();
                System.out.println(this.player.fosterPet.toString()); // print the pet's stats
                break;
            case 3: 
                // User wants to interact with the pet
                this.displayInteractMenu();
                break;
            case 4:
                // user wants to buy food for their pet
                this.buyFoodMenu(); // open buy food meny
                break;
            case 5:
                // If the pet is mad level
                if(this.player.getFosterPet().getLevel() == Animal.MAX_LEVEL)
                {
                    // display adoption menu
                    this.adoptionMenu();
                    break;
                }
                else
                {
                    // If the player enters 5 but their pet is not max level, break.
                    break;
                }
            default: break;     
        }

        // If the player is playing, display the Pet Foster Men
        if(this.player.isPlaying)
        {
            this.displayPetFosterMenu();
        }
            
    }
    
    public void displayInteractMenu()
    {
        int inputNum = 0;
        
        System.out.println("Play with " + this.player.fosterPet.getName() + " or teach them some new tricks!");
        System.out.println("Choose one of the following: \n");
        
        for(int i = 0; i < InteractionList.NUM_OF_INTERACTIONS; i++)
        {
            if(this.player.isInteractUnlocked(interactionList.getInteractions()[i]))
            {
                System.out.println((i+1) + ". " + this.player.getFosterPet().getName() + " "+ interactionList.getInteractions()[i].getInteractionDesc());
            }
            else
            {
                System.out.println((i+1) + ". " + this.player.getFosterPet().getName() + " "+ interactionList.getInteractions()[i].getInteractionDesc() + " (only available if your pet foster is level " + interactionList.getInteractions()[i].getLevelUnlocked() + "+)");
            }
        }
        
        System.out.println((InteractionList.NUM_OF_INTERACTIONS +1) + ". Go back to Pet Foster Menu");
        
        System.out.println("x - Exit the game\n");
        
        inputNum = this.userEnterInput(InteractionList.NUM_OF_INTERACTIONS +1);
            
        if(this.player.isPlaying)
        {
            for(int i = 0; i <= InteractionList.NUM_OF_INTERACTIONS + 1; i++)
            {
                if(inputNum == (i+1))
                {
                    this.player.interactWithPet(interactionList.getInteractions()[i]);
                }
                else if(inputNum == (InteractionList.NUM_OF_INTERACTIONS + 1))
                {
                    System.out.println("Returning back to Pet Foster Menu.");
                    this.displayPetFosterMenu();
                }
            }
        }
        
    }
    
    /*
        FOOD MENUS
    */
    
    public void buyFoodMenu()
    {
        // Variables
        String input = "";
        Food chosenFood = null;
        int inputNum = 0;
        Scanner scanner = new Scanner(System.in);
        
        // Food store prompt
        System.out.println("Get more foods to feed your foster pet!");
        System.out.println("Purchasing one of these foods increases your chosen food's quantity by 5! Isn't that nice?");
        
        // Displaying store for valid food types of the foster pet
        System.out.println(this.displayValidFood(this.player.getFosterPet().getAnimalFoodType()));
        System.out.println("x -  Go back to Pet Foster Menu");
        
        // User's input number
        inputNum = this.userEnterInput(this.getValidFoodRange(this.player.getFosterPet().getAnimalFoodType()));
        
        // If the player is still playing/has not pressed x to exit the game
        if(this.player.isPlaying)
        {
            // Player is getting from list of viable foods
            chosenFood = this.getValidFood(this.player.getFosterPet().getAnimalFoodType(), inputNum);

            // Player buys pet food
            this.player.buyFood(chosenFood);
        }
    }
    
    public void feedPetFosterMenu()
    {
        // Variables
        String input = "";
        Food chosenFood = null;
        int inputNum = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Feed your foster pet something tasty! \n");
        
        // Display player's stock of valid food types of their foster pet
        System.out.println(this.displayValidFood(this.player.getFosterPet().getAnimalFoodType()));
        System.out.println("x -  Go back to Pet Foster Menu");
        
        // User's input number
        inputNum = this.userEnterInput(this.getValidFoodRange(this.player.getFosterPet().getAnimalFoodType()));
        
        // If the player is still playing/has not pressed x to exit the game
        if(this.player.isPlaying)
        {
            // Player feeding pet from list of viable foods
            chosenFood = this.getValidFood(this.player.getFosterPet().getAnimalFoodType(), inputNum);

            // Player feeds pet
            this.player.feedPet(chosenFood);
        }
    }
    
    /* displayValidFood method
    
    Parameters: integer for the animal's prefered foodtype
    Return: String display
    Description: Must be invoked with a food type, displays a list of compatible foods.
    */
    public String displayValidFood(int foodType)
    {
        // Variables
        String output = "";
        int count = 1;
        
        for(int i = 0; i < this.player.getFoodInventory().getFoods().length; i++) // for loop for the length of the foods array
        {
            if(this.player.getFoodInventory().getFoods()[i].getFoodType() == 0 || this.player.getFoodInventory().getFoods()[i].getFoodType() == foodType) // if the food is compatible
            {
                output += count + ". " + this.player.getFoodInventory().getFoods()[i]; // output adds the count and the food description
                count++; // increments count for viable foods
            }
        }
        return output; // return output
    }
    
    /* getValidFood method
    
    Parameters: integer for food type, integer for the user's input number
    Return: A Food object 
    Description: Must be invoked with a food type and user's input number. Returns 
    */
    public Food getValidFood(int foodType, int inputNum)
    {
        int count = 1;
        Food chosenFood = null;
        
        for(int i = 0; i < this.player.getFoodInventory().getFoods().length; i++)
        {
            if(this.player.getFoodInventory().getFoods()[i].getFoodType() == 0 || this.player.getFoodInventory().getFoods()[i].getFoodType() == foodType) // if the food is a valid type
            {
                if(inputNum == count) // if the user's inputNum is equal to the count of viable foods
                {
                    chosenFood = this.player.getFoodInventory().getFoods()[i]; // the chosen food is that food
                }
                count++; // increments count for viable foods
            }
        }
        return chosenFood;
    }
    
    public int getValidFoodRange(int foodType)
    {
        int validFoodRange = 0;
        for(int i = 0; i < this.player.getFoodInventory().getFoods().length; i++)
        {
            if(this.player.getFoodInventory().getFoods()[i].getFoodType() == 0 || this.player.getFoodInventory().getFoods()[i].getFoodType() == foodType)
            {
                validFoodRange++;
            }
        }
        return validFoodRange;
    }
    
    public void startGameMessage() {
        String[] startGameMessages = {
            "##############################\n      LAUNCHING THE GAME      \n##############################",
            "3...",
            "2...",
            "1...",
            "##############################\n         GAME STARTED         \n##############################\n",
            "---------------------\n"
        };

        for (String s : startGameMessages) {
            System.out.println(s);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
    
    private void startThreads() {
        if (this.startThreads) {
            this.dsr = new DecrementStatsRunnable(this.player);
            this.petDecrementStatsThread = new Thread(this.dsr);
            this.petDecrementStatsThread.start();
        }
    }
    
    public void endGameMessage() {
        String[] endGameMessages = {
            "---------------------",
            "Preparing the game for shutdown!",
            "Please do not close or forcefully terminate the program.",
            "This will take a while...",
            "Taking you to the End Game Portal...",
            "##############################\n       ENDING THE GAME        \n##############################",
            "Your game statistics will be displayed in the following: ",
            "(P.S. Take your time reading them! It's quite long...)",
            this.player.toString(),
            "Don't worry about losing any of your data! All of your progress is stored within a thorough file system.",
            "That means when you log onto the game next time, you can simply enter your username as it must be unique for every user. ",
            "##############################\n          GAME ENDED        \n##############################",
            "\nThank you, " + this.player.getName() + ", for playing Forever Home. We hope to see you again next time. :)"
        };

        for (String s : endGameMessages) {
            System.out.println(s);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void adoptionMenu()
    {
        int inputNum = 0;
        
        System.out.println("Do you want to keep " + this.player.getFosterPet().getName() + " for a while longer? [1] or put " 
                            + this.player.getFosterPet().getName() + " up for adoption [2] or press x to exit game. ");

        inputNum = this.userEnterInput(2);
        
        if(inputNum == 1)
            {
                System.out.println("That's all good");
            }
        else if(inputNum == 2)
            {
                System.out.println("Thank you for fostering " + this.player.getFosterPet().getName() + ",  they have found their forever home :)");
                this.player.hasFosterPet = false;
                this.player.isPlaying = false;
            }
    } 
    /*
        USER INPUT & VALIDITY METHODS
    */
    
    public int userEnterInput(int inputRange)
    {
        String input = "";
        int inputNum = 0;
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.print("Your choice: ");
            input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("x")){
                this.player.isPlaying = false;
                this.endGameMessage();
                break;
            }
            
            try{
                inputNum = Integer.parseInt(input);
                if(this.isValidInputRange(inputNum, inputRange))
                {
                    break;
                }
                else
                {
                    System.out.println("Input is out of range.\nPlease try again.");
                    continue;
                }
            }
            catch(NumberFormatException ex){
                if(input.equalsIgnoreCase("x"))
                {
                    this.player.isPlaying = false;
                    this.endGameMessage();
                    break;
                }
                System.out.println("Invalid input.\nPlease try again.");
            }
        }while(!this.isValidInput(input, inputRange));
        
        return inputNum;
    }
    
    private boolean isValidInput(String input, int inputRange)
    {
        int inputNum = 0;
        Scanner scanner = new Scanner(System.in);

        
        
        try{
            inputNum = Integer.parseInt(input);
            if(!this.isValidInputRange(inputNum, inputRange))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        catch(NumberFormatException ex){
            if(input.equalsIgnoreCase("x"))
                {
                    this.player.isPlaying = false;
                    return true;
                }
            return false;
        }
    }
    
    private boolean isValidInputRange(int inputNum, int inputRange)
    {
        if(inputNum > inputRange || inputNum <= 0)
        {
            return false;
        }
        return true;
    }
    
}
