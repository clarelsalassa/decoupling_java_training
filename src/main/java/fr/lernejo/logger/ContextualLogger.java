package fr.lernejo.logger;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ContextualLogger implements Logger{
    private final String className;
    private final Logger logger;

    public ContextualLogger (String className, Logger logger){
        this.className = className;
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        logger.log(LocalDateTime.now().format(formatter) + " " + className + " " + message);
    }
}
