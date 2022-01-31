package me.ipincamp.mcpl.commands;

import me.ipincamp.mcpl.utils.CommandHandlers;
import me.ipincamp.mcpl.utils.MessageFormats;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ping {
    public Ping() {
        new CommandHandlers("ping", 0, 1, true) {
            @Override
            public boolean onCommand(CommandSender sender, String [] arguments) {
                if (arguments.length == 0) {
                    if (!(sender instanceof Player)) {
                        MessageFormats.send(sender, "&cOnly players can use this command!");
                        return true;
                    }

                    Player player = (Player) sender;
                    MessageFormats.send(player, "&eYour ping: &a" + player.getPing() + "ms.");
                }
                if (arguments.length == 1) {
                    if (sender.hasPermission("mcpl.command.ping.others")) {
                        Player player = Bukkit.getServer().getPlayer(arguments[0]);

                        if (player == null) {
                            MessageFormats.send(sender, "&cPlayer " + arguments[0] + " could not be found!");
                            return true;
                        }

                        MessageFormats.send(sender, player.getName() + "'s ping: &e" + player.getPing() + "ms.");
                    }
                }
                return true;
            }

            @Override
            public String getUsage() {
                return "/ping";
            }
        }.enableDelay(3).setPermission("mcpl.command.ping");
    }
}
