package de.einphil.hardcoresmp.commands;



import com.maximde.pluginutils.ColorUtils;
import de.einphil.hardcoresmp.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;


public class Spawn implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        player.teleport(new Location(player.getWorld(),0,66,0));
        return false;
    }
}
