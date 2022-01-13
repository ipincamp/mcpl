package me.ipincamp.commands;

import me.ipincamp.FirstPlugin;
import me.ipincamp.utils.CommandBase;
import me.ipincamp.utils.Message;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed {
    public Feed(FirstPlugin plugin) {
        new CommandBase("feed", true) {
            @Override
            public boolean onCommand(CommandSender sender, String[] arguments) {
                Player player = (Player) sender;
                player.setFoodLevel(20);

                Message.send(player, "&aYou have been feed!");
                return true;
            }

            @Override
            public String getUsage() {
                return "/feed";
            }
        }.enableDelay(30).setPermission("mcpl.command.feed");
    }
}
