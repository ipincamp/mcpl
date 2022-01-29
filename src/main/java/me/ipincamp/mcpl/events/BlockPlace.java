package me.ipincamp.mcpl.events;

import me.ipincamp.mcpl.utils.MessageFormats;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Material type = event.getBlock().getType();

        if (type == Material.TORCH) {
            Player player = event.getPlayer();
            MessageFormats.send(player, "&eBe careful!");
        }
    }
}
