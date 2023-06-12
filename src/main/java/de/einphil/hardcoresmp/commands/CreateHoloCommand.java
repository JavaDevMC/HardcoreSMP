package de.einphil.hardcoresmp.commands;


import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Display;
import org.bukkit.entity.Player;
import de.einphil.hardcoresmp.utils.Hologram;

public class CreateHoloCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player) {
            if(args.length == 1) {
                player.sendMessage("Nutze /hologram <text>");
                return false;
            }
            StringBuilder text = new StringBuilder();
            for(String arg : args) {
                text.append(arg).append(" ");
            }
            var hologram = new Hologram(player.getLocation(), Display.Billboard.HORIZONTAL, true);
            hologram.setText(text.toString());
            hologram.setBackground(Color.fromARGB(0, 0, 0, 0));
        }
        return false;
    }
}
