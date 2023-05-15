package me.pillagedev.skyblockcore.Events;

import com.google.common.collect.HashBasedTable;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.google.common.collect.Table;
import org.bukkit.event.block.BlockBreakEvent;

public class Skills implements Listener {
    Table<String, String, Integer> skillLevel = HashBasedTable.create();
    Table<String, String, Float> skillExp = HashBasedTable.create();


    public boolean crops(Material material) {
        return material == Material.WHEAT || material == Material.CARROTS || material == Material.POTATOES || material == Material.NETHER_WART || material == Material.COCOA_BEANS || material == Material.PUMPKIN || material == Material.MELON || material == Material.CACTUS || material == Material.SUGAR_CANE || material == Material.RED_MUSHROOM || material == Material.RED_MUSHROOM_BLOCK || material == Material.BROWN_MUSHROOM || material == Material.BROWN_MUSHROOM_BLOCK;
    }

    public int farmingLevel(Player player) {
        return skillLevel.get(player.getName(), "farming");
    }

    @EventHandler
    public void farmingSkill(BlockBreakEvent event) {
        float currentExp = skillExp.get(event.getPlayer().getName(), "farming");
        Player player = event.getPlayer();
        Material material = event.getBlock().getType();
        if (crops(material)) {
            if (material == Material.WHEAT || material == Material.NETHER_WART || material == Material.MELON || material == Material.POTATO || material == Material.CARROT || material == Material.COCOA_BEANS) {
                float newExp = currentExp + 4; //TODO: Incorporate farming wisdom
                skillExp.put(player.getName(), "farming", newExp);
            } else if (material == Material.SUGAR_CANE || material == Material.RED_MUSHROOM_BLOCK || material == Material.BROWN_MUSHROOM_BLOCK || material == Material.CACTUS) {
                float newExp = currentExp + 2; //TODO: Incorporate farming wisdom
                skillExp.put(player.getName(), "farming", newExp);
            } else if (material == Material.PUMPKIN) {
                float newExp = (float) (currentExp + 4.5); //TODO: Incorporate farming wisdom
                skillExp.put(player.getName(), "farming", newExp);
            } else if (material == Material.RED_MUSHROOM || material == Material.BROWN_MUSHROOM) {
                float newExp = currentExp + 6; //TODO: Incorporate farming wisdom
                skillExp.put(player.getName(), "farming", newExp);
            }
        }
        float xp = 50 * farmingLevel(player) * (farmingLevel(player) + 1);
        while (currentExp >= xp) {
            currentExp -= xp;
            skillLevel.put(player.getName(), "farming", farmingLevel(player) + 1);
            xp = 50 * farmingLevel(player) * (farmingLevel(player) + 1);
        }
    }


}
