package me.ipincamp.mcpl.commands;

import me.ipincamp.mcpl.Mcpl;
import me.ipincamp.mcpl.utils.Cmd;
import me.ipincamp.mcpl.utils.Msg;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Spawn {
    private Location spawn = null;

    public Spawn(Mcpl plugin) {
        FileConfiguration config = plugin.getConfig();

        String worldName = config.getString("spawn.world");
        if (worldName == null) {
            Bukkit.getLogger().warning("spawn.world does not exist within config.yml!");
            return;
        }

        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            Bukkit.getLogger().severe("World \"" + worldName + "\" does not exist!");
            return;
        }

        // Gathering coordinates
        int x = config.getInt("spawn.x");
        int y = config.getInt("spawn.y");
        int z = config.getInt("spawn.z");
        float yaw = (float) config.getDouble("spawn.yaw");
        float pitch = (float) config.getDouble("spawn.pitch");

        spawn = new Location(world, x, y, z, yaw, pitch);

        new Cmd("setmyspawn", true) {
            @Override
            public boolean onCommand(CommandSender sender, String [] arguments) {
                Player player = (Player) sender;
                Location location = player.getLocation();

                // Write config
                config.set("spawn.world", location.getWorld().getName());
                config.set("spawn.x", location.getBlockX());
                config.set("spawn.y", location.getBlockY());
                config.set("spawn.z", location.getBlockZ());
                config.set("spawn.yaw", location.getYaw());
                config.set("spawn.pitch", location.getPitch());

                // Don't forget to save them
                plugin.saveConfig();
                spawn = location;
                Msg.send(player, "Your spawn has been set");

                return true;
            }

            @Override
            public String getUsage() {
                return "/setmyspawn";
            }
        }.cooldowns(5).setPermission("mcpl.command.setmyspawn");

        new Cmd("myspawn", true) {
            @Override
            public boolean onCommand(CommandSender sender, String [] arguments) {
                Player player = (Player) sender;
                player.teleport(spawn);
                Msg.send(player, "&eTeleporting you...");

                return true;
            }

            @Override
            public String getUsage() {
                return "/myspawn";
            }
        }.cooldowns(3).setPermission("mcpl.command.myspawn");
    }
}
