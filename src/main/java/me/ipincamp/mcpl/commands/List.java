package me.ipincamp.mcpl.commands;

import me.ipincamp.mcpl.utils.CommandHandlers;
import me.ipincamp.mcpl.utils.MessageFormats;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class List {
    public List() {
        new CommandHandlers("list", true) {
            @Override
            public boolean onCommand(CommandSender sender, String [] arguments) {
                Player player = (Player) sender;
                MessageFormats.send(player, "&e&lMCPL - by &b&uipincamp");
                MessageFormats.send(player, "&a&m------------------");
                MessageFormats.send(player, "&c&lList Command:");
                MessageFormats.send(player, "&21. Feed\n2. Heal\n3. Ping\n4. Spawn & Setspawn");
                MessageFormats.send(player, "&a&m------------------");
                MessageFormats.send(player, "&dFor other command suggestions, please DM me on Discord");
                MessageFormats.send(player, "&a&nipincamp#4779");

                return true;
            }

            @Override
            public String getUsage() {
                return "/list";
            }
        }.enableDelay(3).setPermission("mcpl.command.list");
    }
}
