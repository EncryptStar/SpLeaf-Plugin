package net.encryptstar.spleaf.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.encryptstar.spleaf.events.PlayerJoinListener;

public class TimerStopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!PlayerJoinListener.isTimerStopped()) {
            PlayerJoinListener.stopTimer();
        }
        return true;
    } 
}
