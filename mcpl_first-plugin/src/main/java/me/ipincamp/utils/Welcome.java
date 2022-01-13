package me.ipincamp.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Welcome implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent join) {
        Player p = join.getPlayer();
        p.sendMessage("Welcome to the server!");
    }
}
