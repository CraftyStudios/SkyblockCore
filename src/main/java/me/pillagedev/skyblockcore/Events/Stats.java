package me.pillagedev.skyblockcore.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.google.common.collect.HashBasedTable;

public class Stats implements Listener {
    HashBasedTable<String, String, Integer> playerStats = HashBasedTable.create();

    public int getSkill(String skill, Player player) {
        return playerStats.get(player.getName(), skill);
    }

    public int combatWisdom(Player player) {
        return playerStats.get(player.getName(), "combatWisdom");
    }
    
    public int miningWisdom(Player player) {
        return playerStats.get(player.getName(), "miningWisdom");
    }

    public int farmingWisdom(Player player) {
        return playerStats.get(player.getName(), "farmingWisdom");
    }

    public int foragingWisdom(Player player) {
        return playerStats.get(player.getName(), "foragingWisdom");
    }

    public int fishingWisdom(Player player) {
        return playerStats.get(player.getName(), "fishingWisdom");
    }

    public int health(Player player) {
        return playerStats.get(player.getName(), "health");
    }
}
