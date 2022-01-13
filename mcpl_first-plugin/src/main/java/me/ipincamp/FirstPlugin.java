package me.ipincamp;

import me.ipincamp.commands.Feed;
import me.ipincamp.commands.Heal;
import me.ipincamp.commands.Spawn;
import me.ipincamp.utils.Welcome;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FirstPlugin extends JavaPlugin {
    private static FirstPlugin instance;

    @Override
    public void onEnable() {
        System.out.println("Hello World!");

        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new Welcome(), this);
        new Heal(this);
        new Feed(this);
        new Spawn(this);
    }

    @Override
    public void onDisable() {
        System.out.println("Shutting Down...");
    }

    public static FirstPlugin getInstance() {
        return instance;
    }
}
