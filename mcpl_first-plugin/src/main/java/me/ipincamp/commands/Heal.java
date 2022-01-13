package me.ipincamp.commands;

import me.ipincamp.FirstPlugin;
import me.ipincamp.utils.CommandBase;
import me.ipincamp.utils.Message;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal {
    public Heal(FirstPlugin plugin) {
        new CommandBase("heal", true) {
            @Override
            public boolean onCommand(CommandSender sender, String[] arguments) {
                if (!(sender instanceof Player)) {
                    Message.send(sender, "&cOnly players can be use this command!");
                    return true;
                }
                Player player = (Player) sender;
                player.setHealth(20.0d);
                Message.send(player, "&aYou have been healed!");

                return true;
            }

            @Override
            public String getUsage() {
                return "/heal";
            }
        }.enableDelay(60).setPermission("mcpl.command.heal");
    }
}
