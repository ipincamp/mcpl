package me.ipincamp.mcpl.commands;

import me.ipincamp.mcpl.utils.CommandHandlers;
import me.ipincamp.mcpl.utils.MessageFormats;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed {
    public Feed() {
        new CommandHandlers("feed", true) {
            @Override
            public boolean onCommand(CommandSender sender, String [] arguments) {
                Player player = (Player) sender;
                player.setFoodLevel(20);
                MessageFormats.send(player, "You have been feed!");

                return true;
            }

            @Override
            public String getUsage() {
                return "/feed";
            }
        }.enableDelay(10).setPermission("mcpl.command.feed");
    }
}
