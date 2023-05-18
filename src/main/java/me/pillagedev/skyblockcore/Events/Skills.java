package me.pillagedev.skyblockcore.Events;

import com.google.common.collect.HashBasedTable;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.google.common.collect.Table;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack; 

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
        //y ≈ 3.4608x^3 - 25.2433x^2 + 68.5532x + 7.7537
        float calcXP = (float) ((Math.pow((3.4608 * (farmingLevel(player) + 1)), 3)) - (Math.pow((25.2433 * (farmingLevel(player) + 1)), 2)) + (68.5532 * (farmingLevel(player) + 1)) + 7.7537);
        int xp = Math.round(calcXP);
        while (currentExp >= xp) {
            currentExp -= xp;
            skillLevel.put(player.getName(), "farming", farmingLevel(player) + 1);
            //TODO: Add farming level up message
        }
    }

    public int miningLevel(Player player) {
        return skillLevel.get(player.getName(), "mining");
    }

    @EventHandler
    public void miningSkill(BlockBreakEvent event) {
        float currentExp = skillExp.get(event.getPlayer().getName(), "mining");
        Player player = event.getPlayer();
        Material material = event.getBlock().getType();
        if (material == Material.COBBLESTONE || material == Material.STONE) {
            float newExp = currentExp + 1; //TODO: Incorporate mining wisdom
            skillExp.put(player.getName(), "mining", newExp);
        } else if (material == Material.COAL_ORE || material == Material.IRON_ORE) {
            float newExp = currentExp + 5; //TODO: Incorporate mining wisdom
            skillExp.put(player.getName(), "mining", newExp);
        } else if (material == Material.GOLD_ORE) {
            float newExp = currentExp + 6; //TODO: Incorporate mining wisdom
            skillExp.put(player.getName(), "mining", newExp);
        } else if (material == Material.LAPIS_ORE || material == Material.REDSTONE_ORE) {
            float newExp = currentExp + 7; //TODO: Incorporate mining wisdom
            skillExp.put(player.getName(), "mining", newExp);
        } else if (material == Material.EMERALD_ORE) {
            float newExp = currentExp + 9; //TODO: Incorporate mining wisdom
            skillExp.put(player.getName(), "mining", newExp);
        } else if (material == Material.DIAMOND_ORE) {
            float newExp = currentExp + 10; //TODO: Incorporate mining wisdom
            skillExp.put(player.getName(), "mining", newExp);
        } else if (material == Material.DIAMOND_BLOCK) {
            float newExp = currentExp + 15; //TODO: Incorporate mining wisdom
            skillExp.put(player.getName(), "mining", newExp);
        } else if (material == Material.OBSIDIAN) {
            float newExp = currentExp + 20; //TODO: Incorporate mining wisdom
            skillExp.put(player.getName(), "mining", newExp);
        } else if (material == Material.END_STONE) {
            float newExp = currentExp + 3; //TODO: Incorporate mining wisdom
            skillExp.put(player.getName(), "mining", newExp);
        } else if (material == Material.NETHERRACK) {
            float newExp = (float) (currentExp + 0.5);
            skillExp.put(player.getName(), "mining", newExp);
        } else if (material == Material.SAND) {
            float newExp = currentExp + 3;
            skillExp.put(player.getName(), "mining", newExp);
        }

        //y ≈ 3.4608x^3 - 25.2433x^2 + 68.5532x + 7.7537
        float calcXP = (float) ((Math.pow((3.4608 * (miningLevel(player) + 1)), 3)) - (Math.pow((25.2433 * (miningLevel(player) + 1)), 2)) + (68.5532 * (miningLevel(player) + 1)) + 7.7537);
        int xp = Math.round(calcXP);
        while (currentExp >= xp) {
            currentExp -= xp;
            skillLevel.put(player.getName(), "mining", miningLevel(player) + 1);
            //TODO: Add mining level up message
        }
    }

    public int fishingLevel(Player player) {
        return skillLevel.get(player.getName(), "fishing");
    }

    @EventHandler(ignoreCancelled = true)
    public void fishingSkill(PlayerFishEvent event) {
        Player player = event.getPlayer();
        float currentExp = skillExp.get(player.getName(), "fishing");
        ItemStack caughtItem = (Item) event.getCaught();
    }

}
