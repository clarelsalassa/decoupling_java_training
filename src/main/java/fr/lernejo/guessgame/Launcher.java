package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;

import java.security.SecureRandom;
import java.util.regex.Pattern;

public class Launcher {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (args.length == 1 && args[0].equals("-interactive"))
        {
            HumanPlayer player = new HumanPlayer();
            Simulation simulation = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long number = random.nextInt(100);
            simulation.initialize(number);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if (args.length == 2
            && args[0].equals("-auto")
            && pattern.matcher(args[1]).matches())
        {
            ComputerPlayer computer = new ComputerPlayer();
            Simulation simulation = new Simulation(computer);
            simulation.initialize(Long.parseLong(args[1]));
            simulation.loopUntilPlayerSucceed(1000);
        }
        else {
            System.out.println("Deux façons de lancer le programme:\n" +
                "args: -interactive\n" +
                "args: -auto [long number]");
        }

    }
}
