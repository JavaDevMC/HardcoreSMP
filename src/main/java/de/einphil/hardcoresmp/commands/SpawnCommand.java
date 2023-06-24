package de.einphil.hardcoresmp.commands;



import net.minecraft.world.level.World;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) return false;
        player.teleport(Bukkit.getWorld("world").getSpawnLocation());
        return false;
    }
}

