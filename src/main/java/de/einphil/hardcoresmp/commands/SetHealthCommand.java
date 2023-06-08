package de.einphil.hardcoresmp.commands;


import com.maximde.pluginutils.ColorUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class SetHealthCommand implements CommandExecutor {

    private final char oe = '\u00F6';
    private final char ae = '\u00E4';
    private final char ue = '\u00FC';
    private final char sharps = '\u00DF';

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!player.getUniqueId().toString().equals("4b9b96e9-2ab6-4ecb-bd83-5205778a8b4f") && !player.isOp()) {
            player.sendMessage(ChatColor.RED + "Du darfst das nicht");
            return false;
        }
        if(args.length != 1) {
            player.sendMessage(ChatColor.RED +  "Bitte nutze /sethealth <zahl>");
            return false;
        }

        int newHealth;

        try {
            newHealth = Integer.parseInt(args[0]);
        } catch (Exception exception) {
            player.sendMessage(ChatColor.RED +  args[0] + " ist keine g"+ue+"ltige Zahl!");
            return false;
        }
        if(newHealth <= 0) {
            player.sendMessage(ChatColor.RED + "Die Zahl muss gr"+oe+sharps+"er als 0 sein!");
            return false;
        }
        try {
            player.setMaxHealth(newHealth);
            player.sendMessage(ColorUtils.generateGradientText(Color.GREEN, Color.ORANGE,"Du hast nun " + newHealth / 2 + " Herzen!"));
        } catch (Exception e) {
            e.printStackTrace();
            player.sendMessage(ChatColor.RED + "Ein fehler ist aufgetreten! " + newHealth + " ist m"+oe+"glicherweise zu gro"+sharps+"!");
        }
        return false;
    }
}
