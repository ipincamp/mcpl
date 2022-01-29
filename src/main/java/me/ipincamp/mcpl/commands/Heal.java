package me.ipincamp.mcpl.commands;

import me.ipincamp.mcpl.utils.CommandHandlers;
import me.ipincamp.mcpl.utils.MessageFormats;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal {
    public Heal() {
        new CommandHandlers("heal", true) {
            @Override
            public boolean onCommand(CommandSender sender, String[] arguments) {
                if (!(sender instanceof Player)) {
                    MessageFormats.send(sender, "&cOnly players can use this command!");
                    return true;
                }

                Player player = (Player) sender;
                player.setHealth(20.0d);

                return true;
            }

            @Override
            public String getUsage() {
                return "/heal";
            }
        }.enableDelay(60).setPermission("mcpl.command.heal");
    }
}
