package me.pillagedev.skyblockcore.Interfaces;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Skills implements Listener {
    public boolean onCommand(CommandSender sender, Command cmd, String[] args) {
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("skills")) {
            player.openInventory(SkillsGUI(player));
        }
        return false;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        if (item == )
    }

    public Inventory SkillsGUI(Player player) {
        Inventory SkillsGUI = Bukkit.createInventory(null, 54, "Your Skills");
        ItemStack filler = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        assert fillerMeta != null;
        fillerMeta.setDisplayName(" ");
        filler.setItemMeta(fillerMeta);
        for (int i = 0; i < 54; i++) { //TODO: Edit loop
            SkillsGUI.setItem(i, filler);
        }

        ItemStack titleItem = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta titleItemMeta = titleItem.getItemMeta();
        assert titleItemMeta != null;
        titleItemMeta.setDisplayName("§a§lYour Skills");
        List<String> titleItemLore = titleItemMeta.getLore();
        assert titleItemLore != null;
        titleItemLore.add("§7Your skills are displayed below.");
        titleItemLore.add("");
        titleItemLore.add("§6Skill Average:"); //TODO: Add skill average
        titleItemMeta.setLore(titleItemLore);
        titleItem.setItemMeta(titleItemMeta);
        SkillsGUI.setItem(4, titleItem);

        ItemStack farmingSkill = new ItemStack(Material.GOLDEN_HOE);
        ItemMeta farmingSkillMeta = farmingSkill.getItemMeta();
        assert farmingSkillMeta != null;
        farmingSkillMeta.setDisplayName("§aFarming"); //TODO: add skill level
        List<String> farmingSkillLore = farmingSkillMeta.getLore();
        assert farmingSkillLore != null;
        farmingSkillLore.add("§7Harvest crops and collect farming items to level up this skill!");
        farmingSkillLore.add("");
        farmingSkillLore.add("§7Progress to Level (next level): §e--%"); //TODO: add next level number & percent to next level
        farmingSkillLore.add("§2-------§r----------------- §e---§6/§e---k"); //TODO: Make progress bar functional and counters functional
        farmingSkillLore.add("§7Farming (next level) Rewards:"); //TODO: add next level number
        farmingSkillLore.add("add rewards here"); //TODO: add rewards (multi lined)
        farmingSkillLore.add("");
        farmingSkillLore.add("§eClick to view!");
        farmingSkillMeta.setLore(farmingSkillLore);
        farmingSkill.setItemMeta(farmingSkillMeta);
        SkillsGUI.setItem(19, farmingSkill);

        ItemStack miningSkill = new ItemStack(Material.STONE_PICKAXE);
        ItemMeta miningSkillMeta = miningSkill.getItemMeta();
        assert miningSkillMeta != null;
        miningSkillMeta.setDisplayName("§aMining"); //TODO: add skill level
        List<String> miningSkillLore = miningSkillMeta.getLore();
        assert miningSkillLore != null;
        miningSkillLore.add("§7Mine ores and collect mining items to level up this skill!");
        miningSkillLore.add("");
        miningSkillLore.add("§7Progress to Level (next level): §e--%"); //TODO: add next level number & percent to next level
        miningSkillLore.add("§2-------§r----------------- §e---§6/§e---k"); //TODO: Make progress bar functional and counters functional
        miningSkillLore.add("§7Mining (next level) Rewards:"); //TODO: add next level number
        miningSkillLore.add("add rewards here"); //TODO: add rewards (multi lined)
        miningSkillLore.add("");
        miningSkillLore.add("§eClick to view!");
        miningSkillMeta.setLore(miningSkillLore);
        miningSkill.setItemMeta(miningSkillMeta);
        SkillsGUI.setItem(20, miningSkill);

        ItemStack combatSkill = new ItemStack(Material.STONE_SWORD);
        ItemMeta combatSkillMeta = combatSkill.getItemMeta();
        assert combatSkillMeta != null;
        combatSkillMeta.setDisplayName("§aCombat"); //TODO: add skill level
        List<String> combatSkillLore = combatSkillMeta.getLore();
        assert combatSkillLore != null;
        combatSkillLore.add("§7Kill mobs and collect combat items to level up this skill!");
        combatSkillLore.add("");
        combatSkillLore.add("§7Progress to Level (next level): §e--%"); //TODO: add next level number & percent to next level
        combatSkillLore.add("§2-------§r----------------- §e---§6/§e---k"); //TODO: Make progress bar functional and counters functional
        combatSkillLore.add("§7Combat (next level) Rewards:"); //TODO: add next level number
        combatSkillLore.add("add rewards here"); //TODO: add rewards (multi lined)
        combatSkillLore.add("");
        combatSkillLore.add("§eClick to view!");
        combatSkillMeta.setLore(combatSkillLore);
        combatSkill.setItemMeta(combatSkillMeta);
        SkillsGUI.setItem(21, combatSkill);

        ItemStack foragingSkill = new ItemStack(Material.JUNGLE_SAPLING);
        ItemMeta foragingSkillMeta = foragingSkill.getItemMeta();
        assert foragingSkillMeta != null;
        foragingSkillMeta.setDisplayName("§aForaging"); //TODO: add skill level
        List<String> foragingSkillLore = foragingSkillMeta.getLore();
        assert foragingSkillLore != null;
        foragingSkillLore.add("§7Chop trees and collect foraging items to level up this skill!");
        foragingSkillLore.add("");
        foragingSkillLore.add("§7Progress to Level (next level): §e--%"); //TODO: add next level number & percent to next level
        foragingSkillLore.add("§2-------§r----------------- §e---§6/§e---k"); //TODO: Make progress bar functional and counters functional
        foragingSkillLore.add("§7Foraging (next level) Rewards:"); //TODO: add next level number
        foragingSkillLore.add("add rewards here"); //TODO: add rewards (multi lined)
        foragingSkillLore.add("");
        foragingSkillLore.add("§eClick to view!");
        foragingSkillMeta.setLore(foragingSkillLore);
        foragingSkill.setItemMeta(foragingSkillMeta);
        SkillsGUI.setItem(22, foragingSkill);

        ItemStack fishingSkill = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingSkillMeta = fishingSkill.getItemMeta();
        assert fishingSkillMeta != null;
        fishingSkillMeta.setDisplayName("§aFishing"); //TODO: add skill level
        List<String> fishingSkillLore = fishingSkillMeta.getLore();
        assert fishingSkillLore != null;
        fishingSkillLore.add("§7Fish and collect fishing items to level up this skill!");
        fishingSkillLore.add("");
        fishingSkillLore.add("§7Progress to Level (next level): §e--%"); //TODO: add next level number & percent to next level
        fishingSkillLore.add("§2-------§r----------------- §e---§6/§e---k"); //TODO: Make progress bar functional and counters functional
        fishingSkillLore.add("§7Fishing (next level) Rewards:"); //TODO: add next level number
        fishingSkillLore.add("add rewards here"); //TODO: add rewards (multi lined)
        fishingSkillLore.add("");
        fishingSkillLore.add("§eClick to view!");
        fishingSkillMeta.setLore(fishingSkillLore);
        fishingSkill.setItemMeta(fishingSkillMeta);
        SkillsGUI.setItem(23, fishingSkill);

        ItemStack enchantingSkill = new ItemStack(Material.ENCHANTING_TABLE);
        ItemMeta enchantingSkillMeta = enchantingSkill.getItemMeta();
        assert enchantingSkillMeta != null;
        enchantingSkillMeta.setDisplayName("§aEnchanting"); //TODO: add skill level
        List<String> enchantingSkillLore = enchantingSkillMeta.getLore();
        assert enchantingSkillLore != null;
        enchantingSkillLore.add("§7Enchant items and collect enchanting items to level up this skill!");
        enchantingSkillLore.add("");
        enchantingSkillLore.add("§7Progress to Level (next level): §e--%"); //TODO: add next level number & percent to next level
        enchantingSkillLore.add("§2-------§r----------------- §e---§6/§e---k"); //TODO: Make progress bar functional and counters functional
        enchantingSkillLore.add("§7Enchanting (next level) Rewards:"); //TODO: add next level number
        enchantingSkillLore.add("add rewards here"); //TODO: add rewards (multi lined)
        enchantingSkillLore.add("");
        enchantingSkillLore.add("§eClick to view!");
        enchantingSkillMeta.setLore(enchantingSkillLore);
        enchantingSkill.setItemMeta(enchantingSkillMeta);
        SkillsGUI.setItem(24, enchantingSkill);

        ItemStack alchemySkill = new ItemStack(Material.BREWING_STAND);
        ItemMeta alchemySkillMeta = alchemySkill.getItemMeta();
        assert alchemySkillMeta != null;
        alchemySkillMeta.setDisplayName("§aAlchemy"); //TODO: add skill level
        List<String> alchemySkillLore = alchemySkillMeta.getLore();
        assert alchemySkillLore != null;
        alchemySkillLore.add("§7Brew potions and collect alchemy items to level up this skill!");
        alchemySkillLore.add("");
        alchemySkillLore.add("§7Progress to Level (next level): §e--%"); //TODO: add next level number & percent to next level
        alchemySkillLore.add("§2-------§r----------------- §e---§6/§e---k"); //TODO: Make progress bar functional and counters functional
        alchemySkillLore.add("§7Alchemy (next level) Rewards:"); //TODO: add next level number
        alchemySkillLore.add("add rewards here"); //TODO: add rewards (multi lined)
        alchemySkillLore.add("");
        alchemySkillLore.add("§eClick to view!");
        alchemySkillMeta.setLore(alchemySkillLore);
        alchemySkill.setItemMeta(alchemySkillMeta);
        SkillsGUI.setItem(30, alchemySkill);

        ItemStack carpentrySkill = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta carpentrySkillMeta = carpentrySkill.getItemMeta();
        assert carpentrySkillMeta != null;
        carpentrySkillMeta.setDisplayName("§aCarpentry"); //TODO: add skill level
        List<String> carpentrySkillLore = carpentrySkillMeta.getLore();
        assert carpentrySkillLore != null;
        carpentrySkillLore.add("§7Craft items and collect carpentry items to level up this skill!");
        carpentrySkillLore.add("");
        carpentrySkillLore.add("§7Progress to Level (next level): §e--%"); //TODO: add next level number & percent to next level
        carpentrySkillLore.add("§2-------§r----------------- §e---§6/§e---k"); //TODO: Make progress bar functional and counters functional
        carpentrySkillLore.add("§7Carpentry (next level) Rewards:"); //TODO: add next level number
        carpentrySkillLore.add("add rewards here"); //TODO: add rewards (multi lined)
        carpentrySkillLore.add("");
        carpentrySkillLore.add("§eClick to view!");
        carpentrySkillMeta.setLore(carpentrySkillLore);
        carpentrySkill.setItemMeta(carpentrySkillMeta);
        SkillsGUI.setItem(35, carpentrySkill);

        ItemStack tamingSkill = new ItemStack(Material.SHEEP_SPAWN_EGG);
        ItemMeta tamingSkillMeta = tamingSkill.getItemMeta();
        assert tamingSkillMeta != null;
        tamingSkillMeta.setDisplayName("§aTaming"); //TODO: add skill level
        List<String> tamingSkillLore = tamingSkillMeta.getLore();
        assert tamingSkillLore != null;
        tamingSkillLore.add("§7Tame mobs and collect taming items to level up this skill!");
        tamingSkillLore.add("");
        tamingSkillLore.add("§7Progress to Level (next level): §e--%"); //TODO: add next level number & percent to next level
        tamingSkillLore.add("§2-------§r----------------- §e---§6/§e---k"); //TODO: Make progress bar functional and counters functional
        tamingSkillLore.add("§7Taming (next level) Rewards:"); //TODO: add next level number
        tamingSkillLore.add("add rewards here"); //TODO: add rewards (multi lined)
        tamingSkillLore.add("");
        tamingSkillLore.add("§eClick to view!");
        tamingSkillMeta.setLore(tamingSkillLore);
        tamingSkill.setItemMeta(tamingSkillMeta);
        SkillsGUI.setItem(36, tamingSkill);

        ItemStack dungeonItem = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta dungeonItemMeta = dungeonItem.getItemMeta();
        assert dungeonItemMeta != null;
        dungeonItemMeta.setDisplayName("§aDungeon"); //TODO: add skill level
        List<String> dungeonItemLore = dungeonItemMeta.getLore();
        assert dungeonItemLore != null;
        dungeonItemLore.add("§7Complete dungeon runs and collect dungeon items to level up this skill!");
        dungeonItemLore.add("");
        dungeonItemLore.add("§7Progress to Level (next level): §e--%"); //TODO: add next level number & percent to next level
        dungeonItemLore.add("§2-------§r----------------- §e---§6/§e---k"); //TODO: Make progress bar functional and counters functional
        dungeonItemLore.add("§7Dungeon (next level) Rewards:"); //TODO: add next level number
        dungeonItemLore.add("add rewards here"); //TODO: add rewards (multi lined)
        dungeonItemLore.add("");
        dungeonItemLore.add("§eClick to view!");
        dungeonItemMeta.setLore(dungeonItemLore);
        dungeonItem.setItemMeta(dungeonItemMeta);
        SkillsGUI.setItem(42, dungeonItem);
        return SkillsGUI;
    }
}
