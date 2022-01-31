package me.ipincamp.mcpl;

import me.ipincamp.mcpl.commands.*;
import me.ipincamp.mcpl.events.JoinLeave;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mcpl extends JavaPlugin {

    private static Mcpl plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();

        plugin = this;

        Bukkit.getServer().getPluginManager().registerEvents(new JoinLeave(), this);

        new Heal();
        new Feed();
        new Ping();
        new Spawn(this);

        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MCPL] Thank you for choosing this plugin!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MCPL] Have a nice day...");

    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
