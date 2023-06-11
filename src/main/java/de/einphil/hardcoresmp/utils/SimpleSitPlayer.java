package de.einphil.hardcoresmp.utils;

import de.einphil.hardcoresmp.HardcoreSMP;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class SimpleSitPlayer {
    private Player player;

    private HardcoreSMP simpleSit;

    public SimpleSitPlayer(Player player, HardcoreSMP simpleSit) {
        this.player = player;
        this.simpleSit = simpleSit;
    }

    public Player getBukkitPlayer() {
        return this.player;
    }

    public void setSitting(boolean arg) {
        if (arg && !isSitting()) {
            Location location = this.player.getLocation();
            ArmorStand seat = (ArmorStand)location.getWorld().spawn(location.clone().subtract(0.0D, 1.7D, 0.0D), ArmorStand.class);
            seat.setGravity(false);
            seat.setVisible(false);
            this.player.sendMessage("Du sitzt jetzt");
            seat.setPassenger((Entity)this.player);
            this.simpleSit.seats.put(this.player.getUniqueId(), seat);
        } else if (!arg && isSitting()) {
            ArmorStand seat = this.simpleSit.seats.get(this.player.getUniqueId());
            this.player.sendMessage("Du sitzt nicht mehr");
            this.simpleSit.seats.remove(this.player.getUniqueId());
            this.player.eject();
            this.player.teleport(seat.getLocation().clone().add(0.0D, 1.7D, 0.0D));
            seat.remove();
        }
    }

    public boolean isSitting() {
        return this.simpleSit.seats.containsKey(this.player.getUniqueId());
    }
}
