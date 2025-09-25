package net.encryptstar.spleaf.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.encryptstar.spleaf.Main;
import net.encryptstar.spleaf.events.PlayerJoinListener;

public class TimerStartCommand implements CommandExecutor {
    private final Main plugin;
    public TimerStartCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (PlayerJoinListener.isTimerStopped()) {
            PlayerJoinListener.startTimer(plugin);
        }
        return true;
    }

}
