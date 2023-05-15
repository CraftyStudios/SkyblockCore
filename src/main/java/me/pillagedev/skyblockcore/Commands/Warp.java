package me.pillagedev.skyblockcore.Commands;

import com.google.common.collect.HashBasedTable;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.collect.Table;

import java.util.Objects;

public class Warp {
    Table<String, String, Boolean> hasWarpUnlocked = HashBasedTable.create();
    public Warp() {
    }

    public boolean onCommand(String[] args, CommandSender sender, Command cmd) {
        String destination = null;
        if (cmd.getName().equalsIgnoreCase("warp")) {
            Player player = (Player) sender;
            World world = player.getWorld();
            hasWarpUnlocked.put(player.getName(), "spawn", true);

            if (args.length > 0) {
                destination = args[0];
            } else {
                player.sendMessage("§cUsage: /warp <destination>");
            }
            switch (Objects.requireNonNull(destination)) {
                case "spawn":
                    Location spawnLoc = new Location(world, 0, 0, 0);
                    player.teleport(spawnLoc);
                case "shop":
                    if (Boolean.TRUE.equals(hasWarpUnlocked.get(player.getName(), "shop"))) {
                        Location shopLoc = new Location(world, 0, 0, 0);
                        player.teleport(shopLoc);
                    } else {
                        player.sendMessage("§cYou have not unlocked this warp!");
                    }
                case "mines":
                    if (Boolean.TRUE.equals(hasWarpUnlocked.get(player.getName(), "mines"))) {
                        Location minesLoc = new Location(world, 0, 0, 0);
                        player.teleport(minesLoc);
                    } else {
                        player.sendMessage("§cYou have not unlocked this warp!");
                    }
                case "farm":
                    if (Boolean.TRUE.equals(hasWarpUnlocked.get(player.getName(), "farm"))) {
                        Location farmLoc = new Location(world, 0, 0, 0);
                        player.teleport(farmLoc);
                    } else {
                        player.sendMessage("§cYou have not unlocked this warp!");
                    }
                case "forest":
                    if (Boolean.TRUE.equals(hasWarpUnlocked.get(player.getName(), "forest"))) {
                        Location forestLoc = new Location(world, 0, 0, 0);
                        player.teleport(forestLoc);
                    } else {
                        player.sendMessage("§cYou have not unlocked this warp!");
                    }
                case "mountains":
                    if (Boolean.TRUE.equals(hasWarpUnlocked.get(player.getName(), "mountains"))) {
                        Location mountainsLoc = new Location(world, 0, 0, 0);
                        player.teleport(mountainsLoc);
                    } else {
                        player.sendMessage("§cYou have not unlocked this warp!");
                    }
                case "auction":
                    if (Boolean.TRUE.equals(hasWarpUnlocked.get(player.getName(), "auction"))) {
                        Location auctionLoc = new Location(world, 0, 0, 0);
                        player.teleport(auctionLoc);
                    } else {
                        player.sendMessage("§cYou have not unlocked this warp!");
                    }
            }
            return true;
        }
        return false;
    }
}
