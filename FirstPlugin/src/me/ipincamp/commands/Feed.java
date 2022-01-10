package me.ipincamp.commands;

import me.ipincamp.CommandBase;
import me.ipincamp.Msg;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("NullableProblems")
public class Feed {
    public Feed() {
        new CommandBase("feed",true) {
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
        }.enableDelay(2);
    }
}
