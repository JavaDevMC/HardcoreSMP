package de.einphil.hardcoresmp.commands;

import de.einphil.hardcoresmp.HardcoreSMP;
import de.einphil.hardcoresmp.utils.SimpleSitPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SitCommand implements CommandExecutor {
    private HardcoreSMP hardcoreSMP;
    public SitCommand(HardcoreSMP hardcoreSMP) {
        this.hardcoreSMP = hardcoreSMP;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Geht nur als spieler lol");
            return false;
        }
        SimpleSitPlayer player = new SimpleSitPlayer((Player)sender, hardcoreSMP);
        if (player.isSitting()) {
            player.setSitting(false);
        } else if (player.getBukkitPlayer().isOnGround()) {
            player.setSitting(true);
        } else {
            player.getBukkitPlayer().sendMessage("Failed");
        }
        return false;
    }
}
