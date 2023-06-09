package de.einphil.hardcoresmp.listeners;

import com.comphenix.protocol.PacketType;
import com.maximde.pluginutils.ColorUtils;
import de.einphil.hardcoresmp.HardcoreSMP;
import de.einphil.hardcoresmp.utils.GriefingLogger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import java.awt.*;

public class PlayerDeathListener implements Listener {

    private Plugin hardcoreSMP;

    public PlayerDeathListener(HardcoreSMP hardcoreSMP) {
        this.hardcoreSMP = hardcoreSMP;
    }

    private final char oe = '\u00F6';
    private final char ae = '\u00E4';
    private final char ue = '\u00FC';

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player victim = event.getEntity();
        Player killer = victim.getKiller();
        if (victim.getUniqueId().toString().equals("4b9b96e9-2ab6-4ecb-bd83-5205778a8b4f")) {
            removeHearts(victim);
            return;
        }
        victim.setMaxHealth(20);
        if (killer == null) {
            victim.setWhitelisted(false);
            victim.kickPlayer(ColorUtils.generateGradientText(new Color(206, 0, 0), new Color(238, 84, 0), "Du bist gestorben und damit raus!"));
            return;
        }


        GriefingLogger.log(killer, "killed " + victim.getName());
        if(killer.getMaxHealth() <= 2) {
            killer.setHealth(0);
            killer.setWhitelisted(false);
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.hardcoreSMP, () -> {
                //kick player
            killer.kickPlayer(ColorUtils.generateGradientText(new Color(206, 0, 0), new Color(238, 84, 0), "Du hast jemanden getötet und deine letzen Herzen verloren! Damit bist du raus!"));
            }, 2L);
        } else {
            killer.setMaxHealth(killer.getMaxHealth()-4);
        }
        Bukkit.broadcastMessage(ColorUtils.generateGradientText(new Color(229, 192, 0), new Color(255, 99, 78),killer.getName() + " wurden f"+ue+"r das T"+oe+"ten eines anderen Spielers 2 Herzen abgezogen."));
    }

    /**
     * @param player -> LordSpike
     */
    private void removeHearts(Player player) {
        if(player.getMaxHealth() <= 4.0) {
            Bukkit.broadcastMessage(ColorUtils.generateGradientText(new Color(255, 0, 0), new Color(224, 85, 0), player.getName() + " ist gestorben! ENDE"));

            for(Player all : Bukkit.getOnlinePlayers()) {
                all.setGameMode(GameMode.SPECTATOR);
                all.sendTitle(ChatColor.RED+""+ChatColor.BOLD+"ENDE", ColorUtils.generateGradientText(new Color(255, 0, 0), new Color(224, 85, 0), player.getName() + " ist gestorben!"), 10, 50, 10);
            }
            player.setMaxHealth(20);
            return;
        }
        player.setMaxHealth(player.getMaxHealth() - 4.0);
        player.sendMessage(ColorUtils.generateGradientText(new Color(206, 141, 0), new Color(238, 206, 0), "Du hast 2 Herzen verloren!"));
    }
}
