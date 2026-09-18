package de.example.wbset;

import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Locale;

public class WbSetPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("WbSet wurde aktiviert!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("wbset")) {
            return false;
        }

        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cDieser Command kann nur von einem Spieler benutzt werden.");
            return true;
        }

        if (!player.hasPermission("wbset.use")) {
            player.sendMessage("§cDazu hast du keine Berechtigung.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage("§cBenutzung: /wbset <Radius>");
            return true;
        }

        double radius;
        try {
            radius = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            player.sendMessage("§cDer Radius muss eine Zahl sein.");
            return true;
        }

        if (!Double.isFinite(radius) || radius <= 0) {
            player.sendMessage("§cDer Radius muss größer als 0 sein.");
            return true;
        }

        World world = player.getWorld();
        WorldBorder border = world.getWorldBorder();

        double x = player.getX();
        double z = player.getZ();
        double diameter = radius * 2.0;

        border.setCenter(x, z);
        border.setSize(diameter);

        player.sendMessage("§aWorldborder gesetzt!");
        player.sendMessage(String.format(Locale.US,
                "§7Mittelpunkt: §f%.1f / %.1f", x, z));
        player.sendMessage(String.format(Locale.US,
                "§7Radius: §f%.1f", radius));
        player.sendMessage(String.format(Locale.US,
                "§7Durchmesser: §f%.1f", diameter));

        return true;
    }
}
