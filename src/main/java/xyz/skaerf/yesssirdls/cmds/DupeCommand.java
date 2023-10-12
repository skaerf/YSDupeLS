package xyz.skaerf.yesssirdls.cmds;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DupeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Component.text("Console is unable to run this as you must be holding an item"));
            return true;
        }
        Player player = (Player) sender;
        if (player.getInventory().getItemInMainHand().isEmpty()) {
            player.sendMessage(Component.text(ChatColor.RED+"You must be holding an item!"));
            return true;
        }
        player.getInventory().addItem(player.getInventory().getItemInMainHand());
        player.sendMessage(Component.text(ChatColor.GREEN+"Your item has been duplicated."));
        return true;
    }
}
