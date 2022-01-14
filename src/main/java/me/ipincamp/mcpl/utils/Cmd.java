package me.ipincamp.mcpl.utils;

import me.ipincamp.mcpl.Mcpl;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Cmd extends BukkitCommand implements CommandExecutor {
    private List<String> cooldowns = null;
    private int delay = 0;
    private final int minArguments;
    private final int maxArguments;
    private final boolean playerOnly;

    public Cmd(String command) {
        this(command, 0);
    }

    public Cmd(String command, boolean playerOnly) {
        this(command, 0, playerOnly);
    }

    public Cmd(String command, int requiredArguments) {
        this(command, requiredArguments, requiredArguments);
    }

    public Cmd(String command, int minArguments, int maxArguments) {
        this(command, minArguments, maxArguments, false);
    }

    public Cmd(String command, int requiredArguments, boolean playerOnly) {
        this(command, requiredArguments, requiredArguments, playerOnly);
    }

    public Cmd(String command, int minArguments, int maxArguments, boolean playerOnly) {
        super(command);

        this.minArguments = minArguments;
        this.maxArguments = maxArguments;
        this.playerOnly = playerOnly;

        CommandMap commandMap = getCommandMap();
        if (commandMap != null) {
            commandMap.register(command, this);
        }
    }

    public CommandMap getCommandMap() {
        try {
            if (Bukkit.getPluginManager() instanceof SimplePluginManager) {
                Field field = SimplePluginManager.class.getDeclaredField("commandMap");
                field.setAccessible(true);

                return (CommandMap) field.get(Bukkit.getPluginManager());
            }
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public Cmd cooldowns(int delay) {
        this.delay = delay;
        this.cooldowns = new ArrayList<>();

        return this;
    }

    public void removeCooldown(Player player) {
        this.cooldowns.remove(player.getName());
    }

    public void sendUsage(CommandSender sender) {
        Msg.send(sender, getUsage());
    }

    public boolean execute(CommandSender sender, String aliases, String [] arguments) {
        if (arguments.length < minArguments || (arguments.length > maxArguments && maxArguments != -1)) {
            sendUsage(sender);

            return true;
        }

        if (playerOnly && !(sender instanceof Player)) {
            Msg.send(sender, "&cOnly players can use this command.");

            return true;
        }

        String permission = getPermission();
        if (permission != null && !sender.hasPermission(permission)) {
            Msg.send(sender, "&cYou do not have permission to use this command.");

            return true;
        }

        if (cooldowns != null && sender instanceof Player) {
            Player player = (Player) sender;
            if (cooldowns.contains(player.getName())) {
                Msg.send(player, "&cPlease wait before reusing this command again.");

                return true;
            }

            cooldowns.add(player.getName());
            Bukkit.getScheduler().scheduleSyncDelayedTask(Mcpl.getInstance(), () -> {
                cooldowns.remove(player.getName());
            }, 20L * delay);
        }

        if (!onCommand(sender, arguments)) {
            sendUsage(sender);
        }

        return true;
    }

    public boolean onCommand(CommandSender sender, Command command, String aliases, String [] arguments) {
        return this.onCommand(sender, arguments);
    }

    public abstract boolean onCommand(CommandSender sender, String [] arguments);

    public abstract String getUsage();
}
