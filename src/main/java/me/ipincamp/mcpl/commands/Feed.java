package me.ipincamp.mcpl.commands;

import me.ipincamp.mcpl.utils.Cmd;
import me.ipincamp.mcpl.utils.Msg;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed {
    public Feed() {
        new Cmd("feed", true) {
            @Override
            public boolean onCommand(CommandSender sender, String [] arguments) {
                Player player = (Player) sender;
                player.setFoodLevel(20);
                Msg.send(player, "&aYou have been feed");

                return true;
            }

            @Override
            public String getUsage() {
                return "/feed";
            }
        }.cooldowns(3).setPermission("mcpl.command.feed");
    }
}
