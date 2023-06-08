package de.einphil.hardcoresmp.listeners;

import de.einphil.hardcoresmp.GriefingLogger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerBlockPlaceListener implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        GriefingLogger.log(event.getPlayer(), "placed a block ("+event.getBlock().getType().name()+")");
    }
}
