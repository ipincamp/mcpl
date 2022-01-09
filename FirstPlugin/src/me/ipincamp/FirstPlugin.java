package me.ipincamp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FirstPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Plugin Enabled...");

        Bukkit.getPluginManager().registerEvents(new HelloWorld(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin Disabled...");
    }
}
