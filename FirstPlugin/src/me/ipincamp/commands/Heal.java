package me.ipincamp.commands;

import me.ipincamp.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("NullableProblems")
public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            Msg.send(commandSender, "&cOnly players can be use this command.");
            return true;
        }

        Player player = (Player) commandSender;
        player.setHealth(20.0d);

        return true;
    }
}
