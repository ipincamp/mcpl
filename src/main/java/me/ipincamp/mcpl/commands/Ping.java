package me.ipincamp.mcpl.commands;

import me.ipincamp.mcpl.utils.Cmd;
import me.ipincamp.mcpl.utils.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ping {
    public Ping() {
        new Cmd("ping", true) {
            @Override
            public boolean onCommand(CommandSender sender, String [] arguments) {
                if (arguments.length == 0) {
                    if (!(sender instanceof Player)) {
                        Msg.send(sender, "&cOnly player can use this command!");
                        return true;
                    } else {
                        if (sender.hasPermission("mcpl.command.ping")) {
                            final Player p = (Player) sender;
                            Msg.send(sender, "&eYour ping: &a" + p.getPing() + "ms.");
                        } else {
                            Msg.send(sender, "&cYou do not have permission!");
                            return true;
                        }
                    }
                } else if (arguments.length == 1) {
                    if (sender.hasPermission("mcpl.command.ping.others")) {
                        Player player = Bukkit.getServer().getPlayer(arguments[0]);

                        if (player == null) {
                            Msg.send(sender, "&cPlayer " + arguments[0] + " could not be found!");
                            return true;
                        }

                        Msg.send(sender, player.getName() + "'s ping: &e" + player.getPing() + "ms.");
                    } else {
                        Msg.send(sender, "&cYou do not have permission!");
                    }
                    return true;
                }
                return false;
            }

            @Override
            public String getUsage() {
                return "/ping";
            }
        }.cooldowns(3).setPermission("mcpl.command.ping");
    }
}
