package me.ipincamp;

import me.ipincamp.commands.Feed;
import me.ipincamp.commands.Heal;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("ConstantConditions")
public class FirstPlugin extends JavaPlugin {
    private static FirstPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("Plugin Enabled...");

        Bukkit.getPluginManager().registerEvents(new HelloWorld(), this);
        getCommand("heal").setExecutor(new Heal());
        new Feed();
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin Disabled...");
    }

    public static FirstPlugin getInstance() {
        return instance;
    }
}
