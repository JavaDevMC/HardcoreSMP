package de.einphil.hardcoresmp.listeners;

import com.maximde.pluginutils.ColorUtils;
import de.einphil.hardcoresmp.GriefingLogger;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;


public class PlayerInteractListener implements Listener {
    public static ArrayList<UUID> usedReviveItem = new ArrayList<>();
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block clickedBlock = event.getClickedBlock();

        if(action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
            if(event.getItem() != null) {
                if(event.getItem().getType() == Material.STRUCTURE_VOID) {
                    if(usedReviveItem.contains(player.getUniqueId())) {
                        player.sendMessage(ChatColor.RED+"Du hast schon eine aktive Wiederbelebung!");
                    } else {
                        usedReviveItem.add(player.getUniqueId());
                        player.getInventory().remove(event.getItem());
                        player.sendMessage(ChatColor.GREEN+"Schreibe den namen des Spielers welchen du wiederbelen willst in den Chat!");
                    }
                }
            }
        }

        logger(event);

        if (action == Action.RIGHT_CLICK_BLOCK && clickedBlock != null && clickedBlock.getType() == Material.OBSIDIAN) {
            if (player.getItemInHand().getType() == Material.END_CRYSTAL) {
                event.setCancelled(true);
                player.sendMessage(ColorUtils.generateGradientText(Color.RED, Color.ORANGE, "You cannot place end crystals on obsidian :)"));
            }
        }
    }

    private void logger(PlayerInteractEvent event) {
        if(event.getClickedBlock() == null) return;
        if(event.getClickedBlock().getType() == Material.CHEST) {
            GriefingLogger.log(event.getPlayer(), "Opened a chest");
        }
        if(event.getClickedBlock().getType() == Material.ENDER_CHEST) {
            GriefingLogger.log(event.getPlayer(), "Opened an enderchest");
        }
        if(event.getClickedBlock().getType() == Material.BARREL) {
            GriefingLogger.log(event.getPlayer(), "Opened a barrel");
        }
        if(event.getClickedBlock().getType() == Material.ANVIL) {
            GriefingLogger.log(event.getPlayer(), "Opened an anvil");
        }
    }
}
