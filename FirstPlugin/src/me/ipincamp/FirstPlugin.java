package me.ipincamp;

import me.ipincamp.commands.Feed;
import me.ipincamp.commands.Heal;
import me.ipincamp.commands.Spawn;
import me.ipincamp.utils.HelloWorld;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("ConstantConditions")
public class FirstPlugin extends JavaPlugin {
    private static FirstPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("Plugin Enabled...");

        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new HelloWorld(), this);
        getCommand("heal").setExecutor(new Heal());
        new Feed();
        new Spawn(this);
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin Disabled...");
    }

    public static FirstPlugin getInstance() {
        return instance;
    }
}
