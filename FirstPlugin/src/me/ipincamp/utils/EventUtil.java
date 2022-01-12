package me.ipincamp.utils;

import me.ipincamp.FirstPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class EventUtil {
    public static void register(Listener listener) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, FirstPlugin.getInstance());
    }
}
