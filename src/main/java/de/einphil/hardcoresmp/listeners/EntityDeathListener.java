package de.einphil.hardcoresmp.listeners;

import de.einphil.hardcoresmp.utils.GriefingLogger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathListener implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if(event.getEntity().getKiller() == null) return;
        if(event.getEntity() instanceof Player) return;
        if(event.getEntity().getKiller() instanceof Player) {
            GriefingLogger.log(event.getEntity().getKiller(), "killed " + event.getEntity().getType().name());
        }
    }
}
