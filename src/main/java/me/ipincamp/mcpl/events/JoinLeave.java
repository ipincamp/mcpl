package me.ipincamp.mcpl.events;

import me.ipincamp.mcpl.Mcpl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@SuppressWarnings("RegExpRedundantEscape")
public class JoinLeave implements Listener {
    @EventHandler
    public static void onJoin(PlayerJoinEvent event) {
        try {
            String joinMessage;
            Player player = event.getPlayer();

            if (player.hasPlayedBefore()) {
                joinMessage = Mcpl.getPlugin().getConfig().getString("joinMessage");
            } else {
                joinMessage = Mcpl.getPlugin().getConfig().getString("firstJoinMessage");
                if (joinMessage == null) {
                    joinMessage = Mcpl.getPlugin().getConfig().getString("joinMessage");
                }
            }

            if (joinMessage == null) {
                return;
            }

            joinMessage = joinMessage.replaceAll("&", "§");
            joinMessage = joinMessage.replaceAll("\\[displayName\\]", player.getDisplayName());
            event.setJoinMessage(joinMessage);
        } catch (Exception ignored) {

        }
    }

    @EventHandler
    public static void onQuit(PlayerQuitEvent event) {
        try {
            String quitMessage = Mcpl.getPlugin().getConfig().getString("quitMessage");

            Player player = event.getPlayer();

            if (quitMessage == null) {
                return;
            }

            quitMessage = quitMessage.replaceAll("&", "§");
            quitMessage = quitMessage.replaceAll("\\[displayName\\]", player.getDisplayName());
            event.setQuitMessage(quitMessage);
        } catch (Exception ignored) {

        }
    }
}
