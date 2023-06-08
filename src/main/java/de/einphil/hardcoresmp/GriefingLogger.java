package de.einphil.hardcoresmp;

import org.bukkit.entity.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GriefingLogger {
    private static final String LOG_DIRECTORY_PATH = "plugins/HardcoreSMP/";
    private static final String LOG_FILE_PREFIX = "grieflog";
    private static final String LOG_FILE_EXTENSION = ".txt";


    public static void log(Player player, String action) {
        try  {
            logger(player, action);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void logger(Player player, String action) {

        String formattedMessage = getCurrentTimestamp() + " " + player.getName() + " " + action + " at " + (int)player.getLocation().getX() + "x " + (int)player.getLocation().getY() + "y " + (int)player.getLocation().getZ() + "z in World: " + player.getWorld().getName();
        String logFileName = getCurrentLogFileName();

        try {
            File logFile = new File(LOG_DIRECTORY_PATH, logFileName);
            logFile.getParentFile().mkdirs();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
                writer.write(formattedMessage);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return dateFormat.format(new Date());
    }

    private static String getCurrentLogFileName() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(new Date()) + "-" + LOG_FILE_PREFIX + LOG_FILE_EXTENSION;
    }
}
