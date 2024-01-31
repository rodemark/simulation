package com.rodemark.actions;

import com.rodemark.base_entity.Entity;
import com.rodemark.entities.field.Cell;
import com.rodemark.entities.field.WorldMap;
import com.rodemark.entities.mobile.Fox;
import com.rodemark.entities.mobile.Rabbit;
import com.rodemark.entities.stationary.Carrot;
import com.rodemark.entities.stationary.Rock;
import com.rodemark.entities.stationary.Tree;

import java.util.HashMap;
import java.util.Scanner;

public class Simulation {
    private final Scanner scanner = new Scanner(System.in);
    private int width = 10;
    private int height = 10;

    public void mainMenu() {
        while (true) {
            System.out.println("——————————————————————————————————");
            System.out.println("1. Start");
            System.out.println("2. Settings");
            System.out.println("3. Exit");
            System.out.println("——————————————————————————————————");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> startMenu();
                case 2 -> settings();
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void settings() {
        System.out.println("Now width and height: " + width + "x" + height + "\n " +
                "If you want to change the settings, then input \"yes\", else \"no\"");

        String input = scanner.nextLine();

        switch (input) {
            case "yes" -> {
                System.out.print("Input width: ");
                width = scanner.nextInt();

                System.out.print("Input height: ");
                height = scanner.nextInt();
            }
            case "no" -> {
                // do nothing
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void startMenu() {
        WorldMap worldMap = initMap();
        worldMap.printMap();
        int countIteration = 1;

        while (true) {
            System.out.println("——————————————————————————————————");
            System.out.println("1. Make a move with all creatures");
            System.out.println("2. Make a move only by predators");
            System.out.println("3. Make a move only by herbivores");
            System.out.println("4. Generate a new map");
            System.out.println("5. Exit");
            System.out.println("——————————————————————————————————");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.println("Amount iteration: " + countIteration);
            worldMap.printMap();

            switch (choice) {
                case 1, 2, 3 -> {
                    if (!worldMap.existHerbivores()){
                        System.out.println("Everyone died!");
                        worldMap.removeAllPredators();
                        worldMap.printMap();
                        return;
                    }
                    countIteration++;

                    Action action = new Action(worldMap);
                    action.moving(choice == 1 ? "all" : (choice == 2 ? "predators" : "herbivores"));

                }
                case 4 -> {
                    System.out.println("Generating a new map...");
                    worldMap = initMap();
                    worldMap.printMap();
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private WorldMap initMap(){
        HashMap<Cell, Entity> entityHashMap = new HashMap<>();
        WorldMap worldMap = new WorldMap(entityHashMap, height, width);

        Action action = new Action(worldMap);
        action.spawning(Rabbit.class);
        action.spawning(Fox.class);
        action.spawning(Carrot.class);
        action.spawning(Rock.class);
        action.spawning(Tree.class);

        return worldMap;
    }

}
