package de.einphil.hardcoresmp.commands;



import com.maximde.pluginutils.ColorUtils;
import de.einphil.hardcoresmp.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;


public class GetReviveItem implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!player.getUniqueId().toString().equals("4b9b96e9-2ab6-4ecb-bd83-5205778a8b4f") && !player.isOp()) {
            player.sendMessage(ChatColor.RED + "Du darfst das nicht");
            return false;
        }
        ItemBuilder itemBuilder = new ItemBuilder(Material.STRUCTURE_VOID, 1, ColorUtils.generateGradientText(Color.ORANGE, Color.WHITE, "Wiederbelebungs Item"));
        player.getInventory().addItem(itemBuilder.getItemStack());
        return false;
    }
}
