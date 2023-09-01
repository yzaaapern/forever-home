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
    private static String startInput;
    private static String username;

    public ForeverHome() {
        this.users = new HashSet<>();
        this.getUsersAndPets(usersAndPets_FileName);
    }

    public void start() {

        username = getUsernameAndStartInput();
        Player player = checkUser(username);
        checkUserAndStartInput(player);
        updateUserAndPetInfo(player);
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
//                    System.out.println(playerInfo);
                    String petFosterInfo = userAndPet[1];
//                    System.out.println(petFosterInfo);
//                    String foodInventoryInfo = userAndPet[2];

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

//                            if (!foodInventoryInfo.isEmpty()) {
//                                String[] foods = foodInventoryInfo.split(",");
//
//                                for (String food : foods) {
//                                    String[] foodData = food.split(":");
//
//                                    if (foodData.length == 5) {
//                                        String foodName = foodData[0];
//                                        int foodType = Integer.parseInt(foodData[1]);
//                                        int foodValue = Integer.parseInt(foodData[2]);
//                                        int foodCost = Integer.parseInt(foodData[3]);
//                                        int foodCount = Integer.parseInt(foodData[4]);
//
//                                        if (foodType == 0) {
//                                            Food newFood = new FoodType0(foodName, foodValue, foodCost, foodCount);
//                                        } else if (foodType == 1) {
//                                            Food newFood = new FoodType1(foodName, foodValue, foodCost, foodCount);
//                                        } else {
//                                            Food newFood = new FoodType2(foodName, foodValue, foodCost, foodCount);
//                                        }
//                                    }
//
//                                }
//
//                            }
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
                System.out.println(player.fileToString());
                fileWriter.write(player.fileToString() + '\n');
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
