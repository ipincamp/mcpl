package me.ipincamp.mcpl.events;

import me.ipincamp.mcpl.utils.Msg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Welcome implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Msg.send(player, "&bWelcome &a" + player.getName() + "&b on BLCKNET!");
    }
}
