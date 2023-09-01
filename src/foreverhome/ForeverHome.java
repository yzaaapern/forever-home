/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreverhome;

/**
 *
 * @author yzape
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ForeverHome {

    public HashSet<Player> users;
    private static final String usersAndPets_FileName = "./resources/userAndPet_data.txt";
    private static final String usersAndFoodInventory_FileName = "./resources/userAndFoodInventory_data.txt";
    private static String startInput;
    private static String username;

    public ForeverHome() {
        this.users = new HashSet<>();
        this.getUsersAndPets(usersAndPets_FileName);
        this.getUsersAndFoodInventory(usersAndFoodInventory_FileName);
    }

    public void start() {
        username = getUsernameAndStartInput();
        Player player = checkUser(username);
        checkUserAndStartInput(player);
        updateUserAndPetInfo(player);
        this.updateUserAndFoodInventoryInfo(player);
    }

    private String getUsernameAndStartInput() {
        String userName = "";
        int inputNum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to:\n"
                + "1. LOG IN\n2. SIGN UP\n3. EXIT?");
        do {
            System.out.print("Your choice: ");
            startInput = scanner.nextLine();

            try {
                inputNum = Integer.parseInt(startInput);
            } catch (NumberFormatException ex) {
                if (startInput == "" || startInput == " ") {
                    startInput = scanner.nextLine();
                }
                System.out.println("Invalid input. Please try again.");
            }

            if (inputNum == 1) {
                System.out.println("You chose to log in!");
                do {
                    System.out.print("Enter your username: ");
                    userName = scanner.next();
                } while (userName == "" || userName == " ");

            } else if (inputNum == 2) {
                System.out.println("You chose to sign up!");
                do {
                    System.out.print("Enter your username: ");
                    userName = scanner.next();
                } while (userName == "" || userName == " ");

            } else if (inputNum == 3) {
                System.out.println("You chose to exit! We will not be launching Forever Home.");
                break;

            } else {
                System.out.print("Your choice: ");
                startInput = scanner.nextLine();
            }

        } while (!isValidInput(startInput));

        return userName;

    }

    private void getUsersAndPets(String fileName) {
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = fileReader.readLine()) != null) {
                String[] userAndPet = line.split("\\|");

                if (userAndPet.length == 2) {
                    String playerInfo = userAndPet[0];
                    String petFosterInfo = userAndPet[1];
                    String[] playerData = playerInfo.split(":");

                    if (playerData.length == 2) {
                        String playerName = playerData[0];
                        int dabloons = Integer.parseInt(playerData[1]);
                        Player player = new Player(playerName);
                        player.setDabloons(dabloons);

                        if ("NoPet".equals(petFosterInfo)) {
                            player.setFosterPet(null);
                            player.hasFosterPet = false;
                            users.add(player);

                        } else {
                            String[] petData = petFosterInfo.split(":");
                            if (petData.length == 8) {

                                String petName = petData[0];
                                int petInstance = Integer.parseInt(petData[1]);
                                int petHappiness = Integer.parseInt(petData[2]);
                                int petHunger = Integer.parseInt(petData[3]);
                                int petHygiene = Integer.parseInt(petData[4]);
                                int petLevelXP = Integer.parseInt(petData[5]);
                                int petLevelXPBar = Integer.parseInt(petData[6]);
                                int petLevel = Integer.parseInt(petData[7]);

                                Animal fosterPet = checkFosterInstance(petInstance, petName, petHappiness, petHunger, petHygiene, petLevelXP, petLevelXPBar, petLevel);
                                player.setFosterPet(fosterPet);
                                player.hasFosterPet = true;
                                users.add(player);
                            }

                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void getUsersAndFoodInventory(String fileName) 
    {
        // Variables
        Player player = null;
        String[] userAndFoodInventory;
        String[] foodInventory;
        String[] foodData;
        String foodName = "";
        int foodCount = 0;
        
        final int PLAYER_NAME_INDEX = 0;
        final int FOOD_INVENTORY_INDEX = 1;
        final int FOOD_NAME_INDEX = 0;
        final int FOOD_COUNT_INDEX = 1;
        
        // Delimiters to split the data in the lines
        String bigDelim = "\\|";
        String mediumDelim = ",";
        String smallDelim = ":";
        
        BufferedReader fileReader;
        try 
        {
            fileReader = new BufferedReader(new FileReader(fileName));
            String line;
            
            // while the file reader has not reached the end of the text
            while ((line = fileReader.readLine()) != null) 
            {
                // user and food inventory array is split with a "|"
                userAndFoodInventory = line.split(bigDelim);
                
                // player name is the first part of the array
                String playerName = userAndFoodInventory[PLAYER_NAME_INDEX];
//                System.out.println(playerName);
                
                // food inventory info string is the second part of the array
                String foodInventoryInfo = userAndFoodInventory[FOOD_INVENTORY_INDEX];
//                System.out.println(foodInventoryInfo);
                
                // check if user is a user in the system
                player = this.checkUser(playerName);
//                System.out.println(player);
                
                // food inventory info array is further separated into food inventory data which is split with ":"
                foodInventory = foodInventoryInfo.split(mediumDelim);
                
                if(foodInventory.length == FoodInventory.NUM_OF_FOODS)
                {
                    for(int i = 0; i < foodInventory.length; i++)
                    {
//                        System.out.println(foodInventory[i]);
                        // an element of food data consists of a food name [0] and food count [1]
                        foodData = foodInventory[i].split(smallDelim);
                        foodName = foodData[FOOD_NAME_INDEX];
                        foodCount = Integer.parseInt(foodData[FOOD_COUNT_INDEX]);
                        
                        if(foodName.equals(player.getFoodInventory().getFoods()[i].getFoodName()))
                        {
                            player.getFoodInventory().getFoods()[i].setFoodCount(foodCount);
                        }   
//                        for(int j = 0; j < foodData.length; j++)
//                        {
////                            System.out.println(foodData[j]);
//                            
//                            if(j == 0)
//                            {
//                                foodName = foodData[j];
//                                System.out.println(foodName);
//                            }
//                            if(j == 1)
//                            {
//                                foodCount = Integer.parseInt(foodData[j]);
//                            }
////                            foodName = foodData[FOOD_NAME_INDEX];
////                            foodCount = Integer.parseInt(foodData[FOOD_COUNT_INDEX]);
//                        }
    //                    
    //                    
    //                    if(foodName.equalsIgnoreCase(player.getFoodInventory().getFoods()[i].getFoodName()))
    //                    {
    //                        player.getFoodInventory().getFoods()[i].setFoodCount(foodCount);
    //                    }                  
                    }
                }
            }
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public Player checkUser(String username) {
        Player p = null;

        for (Player player : users) {
            if (player.getName().equals(username)) {
                p = player;
                break;
            }
        }

        if (p == null) {
            p = new Player(username);
        }

        return p;
    }

    public void checkUserAndStartInput(Player p) {
        int startInputNum = Integer.parseInt(startInput);
        Player confirmPlayer = p;
        if (startInputNum == 1) {
            if (p != null && p.hasFosterPet && users.contains(p)) {
                System.out.println("We have found your name in our file system! You have an existing foster pet, named: " + p.fosterPet.getName()
                        + ".\nIs this you? ");
                confirmUserIdentity(confirmPlayer);
            } else if (p != null && !p.hasFosterPet && users.contains(p)) {
                System.out.println("We have found your name in our file system! However, it seems like you do not have an existing foster."
                        + ".\nIs this you? ");
                confirmUserIdentity(confirmPlayer);
            } else if (p != null && !p.hasFosterPet && !users.contains(p)) {
                System.out.println("Your name is not found within our records. That's okay though!"
                        + "\nStarting a new game of Forever Home...");
                confirmPlayer = new Player(username);
                users.add(confirmPlayer);
                Game game = new Game(confirmPlayer);
                confirmPlayer.hasFosterPet = true;

            }
        } else if (startInputNum == 2) {
            if (p != null && p.hasFosterPet && users.contains(p)) {
                System.out.println("You chose to sign up with " + p.getName()
                        + ".\nThis name exists within our file system, with a foster pet named: " + p.fosterPet.getName()
                        + ".\nIs this really you? ");
                confirmUserIdentity(confirmPlayer);
            } else if (p != null && !p.hasFosterPet && users.contains(p)) {
                System.out.println("You chose to sign up with " + p.getName()
                        + ".\nThis name exists within our file system, but you don't seem to have a foster pet."
                        + ".\nIs this really you? ");
                confirmUserIdentity(confirmPlayer);
            } else if (p != null && !p.hasFosterPet && !users.contains(p)) {
                System.out.println("Signing you up for a new game of Forever Home!");
                confirmPlayer = new Player(username);
                users.add(confirmPlayer);
                Game game = new Game(confirmPlayer);
                confirmPlayer.hasFosterPet = true;
            }

        } else {
            return;
        }
    }

    public boolean confirmUserIdentity(Player p) {
        Game game;
        Player player = p;
        boolean isValid = false;
        int inputNum;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Yes, this is me.");
            System.out.println("2. No, this is not me.");
            try {
                System.out.print("Your choice: ");
                inputNum = scanner.nextInt();

                if (inputNum == 1) {
                    System.out.println("We will now proceed to launch Forever Home!");
                    if (player.hasFosterPet) {
                        game = new Game(p, p.fosterPet);
                    }
                    if (!player.hasFosterPet) {
                        game = new Game(p);
                    }
                    isValid = true;

                } else if (inputNum == 2) {
                    System.out.println("Is that so?! Well then, redirecting you back to the start...");
                    start();
                    isValid = true;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again.");
                scanner.next();
            }

        } while (!isValid);
        return true;
    }

    public void updateUserAndPetInfo(Player p) {
        Player modifiedPlayer = p;
        if (modifiedPlayer == null) {
            return;
        }

        for(Player player : users){
            if(modifiedPlayer.getName().equals(player.getName())){
                users.remove(player);
                users.add(modifiedPlayer);
                break;
            }
            else{
                users.add(modifiedPlayer);
                break;
            }
        }

        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(usersAndPets_FileName));
            for (Player player : users) {
                player.fileUserAndPetToString();
                fileWriter.write(player.fileUserAndPetToString() + '\n');
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void updateUserAndFoodInventoryInfo(Player p)
    {
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(usersAndFoodInventory_FileName));
            for (Player player : users) {
                player.fileUserAndFoodInventoryToString();
                fileWriter.write(player.fileUserAndFoodInventoryToString() + '\n');
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Animal checkFosterInstance(int animalType, String petName, int petHappiness, int petHunger, int petHygiene, int petLevelXP, int petLevelXPBar, int petLevel) {
        Animal a = null;
        switch (animalType) {
            case 1:
                a = new Dog(petName, petHappiness, petHunger, petHygiene, petLevelXP, petLevelXPBar, petLevel);
                break;
            case 2:
                a = new Cat(petName, petHappiness, petHunger, petHygiene, petLevelXP, petLevelXPBar, petLevel);
                break;
            case 3:
                a = new Rat(petName, petHappiness, petHunger, petHygiene, petLevelXP, petLevelXPBar, petLevel);
                break;
            case 4:
                a = new Parrot(petName, petHappiness, petHunger, petHygiene, petLevelXP, petLevelXPBar, petLevel);
                break;
            case 5:
                a = new Chicken(petName, petHappiness, petHunger, petHygiene, petLevelXP, petLevelXPBar, petLevel);
                break;
        }

        return a;
    }

    public boolean isValidInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {

            if (input.equalsIgnoreCase("x")) {
                return true;
            }

            if (input == "" || input == " ") {
                System.out.println("Invalid input.\nPlease try again.");
                return false;
            }

            System.out.println("Invalid input.\nPlease try again.");
            return false;

        }
        return true;
    }

    public static void main(String[] args) {
        ForeverHome fhGame = new ForeverHome();
         fhGame.start();
    }

}
