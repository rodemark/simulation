package com.rodemark;

import com.rodemark.actions.Simulation;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        Simulation simulation = new Simulation();
        simulation.mainMenu();
    }

}