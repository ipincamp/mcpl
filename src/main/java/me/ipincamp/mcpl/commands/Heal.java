package me.ipincamp.mcpl.commands;

import me.ipincamp.mcpl.utils.Cmd;
import me.ipincamp.mcpl.utils.Msg;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal {
    public Heal() {
        new Cmd("heal", true) {
            @Override
            public boolean onCommand(CommandSender sender, String [] arguments) {
                if (!(sender instanceof Player)) {
                    Msg.send(sender, "&cOnly player can use this command.");

                    return true;
                }

                Player player = (Player) sender;
                player.setHealth(20.0d);
                Msg.send(player, "&aYou have been healed.");

                return true;
            }

            @Override
            public String getUsage() {
                return "/heal";
            }
        }.cooldowns(30).setPermission("mcpl.command.heal");
    }
}
