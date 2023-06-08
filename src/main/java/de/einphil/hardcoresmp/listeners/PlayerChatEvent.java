package de.einphil.hardcoresmp.listeners;

import com.maximde.pluginutils.ColorUtils;
import de.einphil.hardcoresmp.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;

public class PlayerChatEvent implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if(PlayerInteractListener.usedReviveItem.contains(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
            if(event.getMessage().equalsIgnoreCase("cancel")) {
                ItemBuilder itemBuilder = new ItemBuilder(Material.STRUCTURE_VOID, 1, ColorUtils.generateGradientText(Color.ORANGE, Color.WHITE, "Wiederbelebungs Item"));
                event.getPlayer().getInventory().addItem(itemBuilder.getItemStack());
                PlayerInteractListener.usedReviveItem.remove(event.getPlayer().getUniqueId());
                return;
            }
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(event.getMessage());
            if(offlinePlayer == null) {
                event.getPlayer().sendMessage(ChatColor.DARK_RED+"Spieler nicht gefunden! Schreibe " + ChatColor.RED + "CANCEL" + ChatColor.DARK_RED + " in den Chat um abzubrechen und das item wieder zu bekommen oder versuche es mit einem anderen Spieler!");
                return;
            }
            if(!offlinePlayer.isWhitelisted()) {
                event.getPlayer().sendMessage(ChatColor.DARK_RED+offlinePlayer.getName()+" ist schon in der Whitelist!");
                return;
            }
            offlinePlayer.setWhitelisted(false);
            PlayerInteractListener.usedReviveItem.remove(event.getPlayer().getUniqueId());
            Bukkit.broadcastMessage(ColorUtils.generateGradientText(Color.GREEN, Color.WHITE, event.getPlayer().getName() + " hat" + offlinePlayer.getName() + " wiederbelebt!"));
        }
    }
}
