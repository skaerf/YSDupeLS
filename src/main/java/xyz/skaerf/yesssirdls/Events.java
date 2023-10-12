package xyz.skaerf.yesssirdls;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class Events implements Listener {

    @EventHandler
    public void onKill(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        Player killer = event.getPlayer().getKiller();
        if (killer == null) return;
        double health = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health-2);
        killer.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(killer.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()+2);
        player.sendMessage(Component.text(ChatColor.RED+"One of your hearts have been given up to "+killer.getName()+"."));
        killer.sendMessage(Component.text(ChatColor.RED+"You have stolen one of the hearts of "+player.getName()+"."));
    }
}
