package de.einphil.hardcoresmp.listeners;

import de.einphil.hardcoresmp.utils.GriefingLogger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBlockBreakListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        GriefingLogger.log(event.getPlayer(), "destroyd a block ("+event.getBlock().getType().name()+")");
    }
}
