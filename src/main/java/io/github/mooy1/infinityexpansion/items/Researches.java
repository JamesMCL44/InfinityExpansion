package io.github.mooy1.infinityexpansion.items;

import lombok.experimental.UtilityClass;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

@UtilityClass
public final class Researches {

    private static final int FIRST_RESEARCH_ID = 314000000;

    public static void setup() {
        create(0, "harvesting_void", "虛空採收", 35,
                Materials.VOID_BIT, Materials.VOID_DUST, Materials.VOID_INGOT, Machines.VOID_HARVESTER
        );
        create(1, "infinity_gear", "無限裝備", 60,
                Gear.AXE, Gear.BLADE, Gear.BOW, Gear.PICKAXE, Gear.SHOVEL, Gear.SHIELD,
                Gear.CROWN, Gear.CHESTPLATE, Gear.LEGGINGS, Gear.BOOTS, Gear.INFINITY_MATRIX
        );
        create(2, "singularities", "創造奇點", 35,
                Materials.ALUMINUM_SINGULARITY,
                Materials.SILVER_SINGULARITY,
                Materials.COPPER_SINGULARITY,
                Materials.LEAD_SINGULARITY,
                Materials.ZINC_SINGULARITY,
                Materials.TIN_SINGULARITY,
                Materials.MAGNESIUM_SINGULARITY,
                Materials.COAL_SINGULARITY,
                Materials.IRON_SINGULARITY,
                Materials.GOLD_SINGULARITY,
                Materials.DIAMOND_SINGULARITY,
                Materials.EMERALD_SINGULARITY,
                Materials.LAPIS_SINGULARITY,
                Materials.REDSTONE_SINGULARITY,
                Materials.NETHERITE_SINGULARITY,
                Materials.QUARTZ_SINGULARITY,
                Machines.SINGULARITY_CONSTRUCTOR,
                Machines.RESOURCE_SYNTHESIZER
        );
        create(3, "infinity_ingot", "創造無限", 40,
                Materials.EARTH_SINGULARITY, Materials.FORTUNE_SINGULARITY, Materials.MAGIC_SINGULARITY,
                Materials.METAL_SINGULARITY, Materials.INFINITE_INGOT, Blocks.INFINITY_FORGE
        );
        create(4, "harvesting_end", "終界採收", 20,
                Materials.ENDER_ESSENCE, Gear.ENDER_FLAME, Gear.VEIN_MINER_RUNE
        );
        create(5, "mob_data", "虛擬怪物農場", 30,
                MobData.CHAMBER, MobData.EMPTY_DATA_CARD, MobData.INFUSER,
                MobData.COW, MobData.SHEEP, MobData.CHICKEN
        );
        create(6, "oscillators", "改善採石場", 30,
                Quarries.DIAMOND_OSCILLATOR, Quarries.EMERALD_OSCILLATOR, Quarries.LAPIS_OSCILLATOR,
                Quarries.REDSTONE_OSCILLATOR, Quarries.QUARTZ_OSCILLATOR
        );
        create(7, "machine_materials", "機器材料", 20,
                Materials.MAGSTEEL, Materials.MAGSTEEL_PLATE, Materials.MACHINE_CIRCUIT,
                Materials.MACHINE_CORE, Materials.MACHINE_PLATE
        );
        create(8, "compressed_cobble", "壓縮鵝卵石", 15,
                Materials.COBBLE_1, Materials.COBBLE_2, Materials.COBBLE_3,
                Materials.COBBLE_4, Materials.COBBLE_5, Machines.COBBLE_PRESS
        );
        create(9, "starter_machines", "初始機器", 15,
                Machines.BASIC_COBBLE, Machines.BASIC_GROWER,
                Machines.BASIC_TREE, Quarries.BASIC_QUARRY
        );
        create(10, "strainers", "材料過濾器", 10,
                Blocks.STRAINER_BASE, Materials.BASIC_STRAINER,
                Materials.ADVANCED_STRAINER, Materials.REINFORCED_STRAINER
        );
        create(11, "starter_power", "初始能源", 15,
                Generators.BASIC_PANEL, Generators.HYDRO
        );
        create(12, "advanced_power", "高級能源", 35,
                Generators.ADVANCED_PANEL, Generators.GEOTHERMAL, Generators.REINFORCED_HYDRO,
                Generators.REINFORCED_GEOTHERMAL, Generators.CELESTIAL_PANEL,
                SlimefunExtension.ADVANCED_NETHER_STAR_REACTOR
        );
        create(13, "advanced_machines", "高級機器", 40,
                Machines.DUST_EXTRACTOR, Machines.EXTREME_FREEZER, Machines.GEO_QUARRY,
                Machines.DECOMPRESSOR, Machines.STONEWORKS_FACTORY, Machines.BASIC_OBSIDIAN,
                Machines.INGOT_FORMER, Blocks.ADVANCED_ANVIL, Machines.URANIUM_EXTRACTOR,
                Machines.GEAR_TRANSFORMER
        );
        create(14, "upgraded_machines", "升級版機器", 40,
                SlimefunExtension.ADVANCED_CHARGER, SlimefunExtension.ADVANCED_ENCHANTER,
                SlimefunExtension.ADVANCED_DISENCHANTER, SlimefunExtension.ADVANCED_SMELTERY,
                Machines.ADVANCED_COBBLE, Machines.ADVANCED_GROWER, Machines.ADVANCED_TREE,
                SlimefunExtension.ADVANCED_GEO_MINER, Quarries.ADVANCED_QUARRY
        );
        create(15, "infinity_upgrades", "無限升級", 80,
                Machines.INFINITE_VOID_HARVESTER, Machines.INFINITY_COBBLE, Machines.INFINITY_CONSTRUCTOR,
                Machines.INFINITY_GROWER, Machines.INFINITY_TREE, Machines.INFINITY_INGOT_FORMER,
                Generators.INFINITE_PANEL, Generators.INFINITY_REACTOR, Storage.INFINITY_STORAGE,
                SlimefunExtension.INFINITY_CAPACITOR, SlimefunExtension.INFINITY_CHARGER,
                SlimefunExtension.INFINITY_DISENCHANTER, SlimefunExtension.INFINITY_ENCHANTER,
                Quarries.INFINITY_QUARRY, Machines.INFINITY_DUST_EXTRACTOR
        );
        create(16, "void_upgrades", "虛空升級", 45,
                Generators.VOID_PANEL, SlimefunExtension.VOID_CAPACITOR, Storage.VOID_STORAGE,
                Machines.POWERED_BEDROCK, Quarries.VOID_QUARRY
        );
        create(17, "advanced_alloys", "高級合金", 30,
                Materials.TITANIUM, Materials.ADAMANTITE, Materials.MAGNONIUM, Materials.MYTHRIL
        );
        create(18, "big_storage", "大儲存", 20,
                Storage.STORAGE_FORGE, Storage.BASIC_STORAGE, Storage.ADVANCED_STORAGE, Storage.REINFORCED_STORAGE
        );
        create(19, "infinity_materials", "無限材料", 40,
                Materials.INFINITY_SINGULARITY, Materials.INFINITE_CORE, Materials.INFINITE_CIRCUIT
        );
        create(20, "neutral_mob_data", "中立生物資料卡", 25,
                MobData.SLIME, MobData.MAGMA_CUBE, MobData.BEE, MobData.VILLAGER
        );
        create(21, "hostile_mob_data", "敵對生物資料卡", 30,
                MobData.ZOMBIE, MobData.SPIDER, MobData.SKELETON,
                MobData.CREEPER, MobData.GUARDIAN, MobData.WITCH
        );
        create(22, "advanced_mob_data", "高級生物資料卡", 45,
                MobData.WITHER_SKELETON, MobData.ENDERMEN, MobData.IRON_GOLEM, MobData.BLAZE
        );
        create(23, "boss_mob_data", "Boss資料卡", 60,
                MobData.WITHER, MobData.ENDER_DRAGON
        );
    }

    private static void create(int id, String key, String name, int cost, SlimefunItemStack... items) {
        new Research(InfinityExpansion.inst().getKey(key), FIRST_RESEARCH_ID + id, name, cost).addItems(items).register();
    }

}
