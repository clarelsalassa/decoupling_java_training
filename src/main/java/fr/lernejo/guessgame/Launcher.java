package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        HumanPlayer player = new HumanPlayer();
        Simulation simulation = new Simulation(player);
        SecureRandom random = new SecureRandom();
        long number = random.nextInt(100);
        simulation.initialize(number);
        simulation.loopUntilPlayerSucceed();
    }
}
