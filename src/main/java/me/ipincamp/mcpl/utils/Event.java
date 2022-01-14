package me.ipincamp.mcpl.utils;

import me.ipincamp.mcpl.Mcpl;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Event {
    public static void register(Listener listener) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, Mcpl.getInstance());
    }
}
