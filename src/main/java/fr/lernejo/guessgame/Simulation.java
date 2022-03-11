package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long number = player.askNextGuess();
        logger.log("User typed " + number);
        if (number < numberToGuess) {
            player.respond(true);
            return false;
        }
        else if (number > numberToGuess) {
            player.respond(false);
            return false;
        }
        return true;
    }

    public void loopUntilPlayerSucceed(long limit) {
        boolean isFinished = false;
        long n = 0;
        long startTime = System.currentTimeMillis();
        while (!isFinished && n < limit){
            isFinished = nextRound();
            n++;
        }
        long durringTime = System.currentTimeMillis() - startTime;
        Date time = new Date(durringTime);
        DateFormat df = new SimpleDateFormat("mm:ss.SSS");
        logger.log("During time: " + df.format(time));
        if (isFinished)
            logger.log("Player has found the number in " + n + " iterations");
        else
            logger.log("Player has not found the number within " + limit +
                " iterations");
    }
}
