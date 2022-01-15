package me.ipincamp.mcpl;

import me.ipincamp.mcpl.commands.Feed;
import me.ipincamp.mcpl.commands.Heal;
import me.ipincamp.mcpl.commands.Ping;
import me.ipincamp.mcpl.commands.Spawn;
import me.ipincamp.mcpl.events.BlockPlace;
import me.ipincamp.mcpl.events.Welcome;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mcpl extends JavaPlugin {
    private static Mcpl instance;

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        Bukkit.getLogger().info("[mcpl] Hello cruel world!");

        // Enabling Configurations
        saveDefaultConfig();

        /**
         * Events Listeners
         */

         Bukkit.getPluginManager().registerEvents(new Welcome(), this);
         Bukkit.getPluginManager().registerEvents(new BlockPlace(), this);

        /**
         * Commands Listeners
         */
        new Feed();
        new Heal();
        new Ping();
        new Spawn(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[mcpl] Cya...!");
    }

    public static Mcpl getInstance() {
        return instance;
    }
}
