package io.github.mooy1.infinityexpansion.implementation.generators;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.mooy1.infinityexpansion.implementation.abstracts.AbstractGenerator;
import io.github.mooy1.infinityexpansion.implementation.blocks.InfinityWorkbench;
import io.github.mooy1.infinityexpansion.implementation.materials.CompressedItem;
import io.github.mooy1.infinityexpansion.implementation.materials.InfinityItem;
import io.github.mooy1.infinityexpansion.implementation.materials.MachineItem;
import io.github.mooy1.infinityexpansion.implementation.materials.SmelteryItem;
import io.github.mooy1.infinityexpansion.setup.categories.Categories;
import io.github.mooy1.infinityexpansion.utils.Util;
import io.github.mooy1.infinitylib.PluginUtils;
import io.github.mooy1.infinitylib.presets.LorePreset;
import io.github.mooy1.infinitylib.presets.MenuPreset;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import lombok.AllArgsConstructor;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Solar panels and some other basic generators
 *
 * @author Mooy1
 *
 * Thanks to panda for some stuff to work off of
 */
public final class EnergyGenerator extends AbstractGenerator {
    
    public static void setup(InfinityExpansion plugin) {
        new EnergyGenerator(Categories.BASIC_MACHINES, HYDRO, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SmelteryItem.MAGSTEEL, MachineItem.MACHINE_CIRCUIT, SmelteryItem.MAGSTEEL,
                new ItemStack(Material.BUCKET), SlimefunItems.ELECTRO_MAGNET, new ItemStack(Material.BUCKET),
                SmelteryItem.MAGSTEEL, MachineItem.MACHINE_CIRCUIT, SmelteryItem.MAGSTEEL
        }, 6, Type.WATER).register(plugin);
        new EnergyGenerator(Categories.ADVANCED_MACHINES, REINFORCED_HYDRO, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                HYDRO, MachineItem.MACHINE_CIRCUIT, HYDRO,
                MachineItem.MAGSTEEL_PLATE, MachineItem.MACHINE_CORE, MachineItem.MAGSTEEL_PLATE,
                HYDRO, MachineItem.MACHINE_CIRCUIT, HYDRO
        }, 30, Type.WATER).register(plugin);

        new EnergyGenerator(Categories.ADVANCED_MACHINES, GEOTHERMAL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MachineItem.MAGSTEEL_PLATE, MachineItem.MAGSTEEL_PLATE, MachineItem.MAGSTEEL_PLATE,
                SlimefunItems.LAVA_GENERATOR_2, SlimefunItems.LAVA_GENERATOR_2, SlimefunItems.LAVA_GENERATOR_2,
                MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CORE, MachineItem.MACHINE_CIRCUIT
        }, 36, Type.GEOTHERMAL).register(plugin);
        new EnergyGenerator(Categories.ADVANCED_MACHINES, REINFORCED_GEOTHERMAL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                GEOTHERMAL, MachineItem.MACHINE_CIRCUIT, GEOTHERMAL,
                MachineItem.MACHINE_PLATE, MachineItem.MACHINE_CORE, MachineItem.MACHINE_PLATE,
                GEOTHERMAL, MachineItem.MACHINE_CIRCUIT, GEOTHERMAL
        }, 180, Type.GEOTHERMAL).register(plugin);

        new EnergyGenerator(Categories.BASIC_MACHINES, BASIC_PANEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SmelteryItem.MAGSTEEL, MachineItem.MAGSTEEL_PLATE, SmelteryItem.MAGSTEEL,
                SlimefunItems.SOLAR_PANEL, SlimefunItems.SOLAR_PANEL, SlimefunItems.SOLAR_PANEL,
                MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT
        }, 9, Type.SOLAR).register(plugin);
        new EnergyGenerator(Categories.ADVANCED_MACHINES, ADVANCED_PANEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BASIC_PANEL, BASIC_PANEL, BASIC_PANEL,
                SmelteryItem.TITANIUM, SlimefunItems.SOLAR_GENERATOR_4, SmelteryItem.TITANIUM,
                MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT
        }, 150, Type.SOLAR).register(plugin);

        new EnergyGenerator(Categories.ADVANCED_MACHINES, CELESTIAL_PANEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MachineItem.MACHINE_PLATE, MachineItem.MACHINE_PLATE, MachineItem.MACHINE_PLATE,
                ADVANCED_PANEL, ADVANCED_PANEL, ADVANCED_PANEL,
                MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CORE, MachineItem.MACHINE_CIRCUIT
        }, 500, Type.SOLAR).register(plugin);
        new EnergyGenerator(Categories.ADVANCED_MACHINES, VOID_PANEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                CompressedItem.VOID_INGOT, CompressedItem.VOID_INGOT, CompressedItem.VOID_INGOT,
                CELESTIAL_PANEL, CELESTIAL_PANEL, CELESTIAL_PANEL,
                SmelteryItem.MAGNONIUM, SmelteryItem.MAGNONIUM, SmelteryItem.MAGNONIUM
        }, 2400, Type.LUNAR).register(plugin);

        new EnergyGenerator(Categories.INFINITY_CHEAT, INFINITE_PANEL, InfinityWorkbench.TYPE, new ItemStack[] {
                EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL,
                EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL,
                SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY,
                SmelteryItem.INFINITY, InfinityItem.CIRCUIT, InfinityItem.CORE, InfinityItem.CORE, InfinityItem.CIRCUIT, SmelteryItem.INFINITY,
                SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY,
                EnergyGenerator.VOID_PANEL, EnergyGenerator.VOID_PANEL, EnergyGenerator.VOID_PANEL, EnergyGenerator.VOID_PANEL, EnergyGenerator.VOID_PANEL, EnergyGenerator.VOID_PANEL
        }, 75000, Type.INFINITY).register(plugin);
    }
    
    public static final SlimefunItemStack HYDRO = new SlimefunItemStack(
            "HYDRO_GENERATOR",
            Material.PRISMARINE_WALL,
            "&9水力發電機",
            "&7在流動的水中產生能量",
            "",
            LorePreset.energyBuffer(600),
            LorePreset.energyPerSecond(6)
    );
    public static final SlimefunItemStack REINFORCED_HYDRO = new SlimefunItemStack(
            "REINFORCED_HYDRO_GENERATOR",
            Material.END_STONE_BRICK_WALL,
            "&f強化&9水力發電機",
            "&7產生更多的能量",
            "&7從流動的水中",
            "",
            LorePreset.energyBuffer(3000),
            LorePreset.energyPerSecond(30)
    );
    public static final SlimefunItemStack GEOTHERMAL = new SlimefunItemStack(
            "GEOTHERMAL_GENERATOR",
            Material.MAGMA_BLOCK,
            "&c地熱發電機",
            "&7從世界的熱能中產生能量",
            "",
            LorePreset.energyBuffer(3600),
            LorePreset.energyPerSecond(36)
    );
    public static final SlimefunItemStack REINFORCED_GEOTHERMAL = new SlimefunItemStack(
            "REINFORCED_GEOTHERMAL_GENERATOR",
            Material.SHROOMLIGHT,
            "&f強化&c地熱發電機",
            "&7產生更多的能量",
            "&7從世界的熱能中",
            "",
            LorePreset.energyBuffer(18000),
            LorePreset.energyPerSecond(180)
    );
    public static final SlimefunItemStack BASIC_PANEL = new SlimefunItemStack(
            "BASIC_PANEL",
            Material.BLUE_GLAZED_TERRACOTTA,
            "&9基本太陽能板",
            "&7從太陽產生能量",
            "",
            LorePreset.energyBuffer(900),
            LorePreset.energyPerSecond(9)
    );
    public static final SlimefunItemStack ADVANCED_PANEL = new SlimefunItemStack(
            "ADVANCED_PANEL",
            Material.RED_GLAZED_TERRACOTTA,
            "&c高級太陽能板",
            "&7從太陽產生能量",
            "",
            LorePreset.energyBuffer(15000),
            LorePreset.energyPerSecond(150)
    );
    public static final SlimefunItemStack CELESTIAL_PANEL = new SlimefunItemStack(
            "CELESTIAL_PANEL",
            Material.YELLOW_GLAZED_TERRACOTTA,
            "&e天體面板",
            "&7從太陽產生能量",
            "",
            LorePreset.energyBuffer(50000),
            LorePreset.energyPerSecond(500)
    );
    public static final SlimefunItemStack VOID_PANEL = new SlimefunItemStack(
            "VOID_PANEL",
            Material.LIGHT_GRAY_GLAZED_TERRACOTTA,
            "&8虛空面板",
            "&7從黑暗中產生能量",
            "",
            LorePreset.energyBuffer(240000),
            LorePreset.energyPerSecond(2400)
    );
    public static final SlimefunItemStack INFINITE_PANEL = new SlimefunItemStack(
            "INFINITE_PANEL",
            Material.LIGHT_BLUE_GLAZED_TERRACOTTA,
            "&b無限面板",
            "&7從宇宙中產生能量",
            "",
            LorePreset.energyBuffer(7500000),
            LorePreset.energyPerSecond(75000)
    );

    private final Type type;
    private final int generation;
    private final int storage;

    private EnergyGenerator(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int generation, Type type) {
        super(category, item, recipeType, recipe);
        this.type = type;
        this.generation = generation;
        this.storage = generation * 100;
    }

    @Override
    public void setupMenu(@Nonnull BlockMenuPreset blockMenuPreset) {
        for (int i = 0 ; i < 9 ; i++) {
            blockMenuPreset.addItem(i, MenuPreset.borderItemStatus, ChestMenuUtils.getEmptyClickHandler());
        }
        blockMenuPreset.addItem(4, MenuPreset.loadingItemRed, ChestMenuUtils.getEmptyClickHandler());
    }

    @Nonnull
    @Override
    public int[] getTransportSlots(@Nonnull DirtyChestMenu dirtyChestMenu, @Nonnull ItemTransportFlow itemTransportFlow, ItemStack itemStack) {
        return new int[0];
    }

    @Override
    public void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) {

    }

    @Override
    public int getGeneratedOutput(@Nonnull Location l, @Nonnull Config data) {
        @Nullable final BlockMenu inv = BlockStorage.getInventory(l);
        if (inv == null) return 0;

        Type type = getGeneration(l.getBlock(), Objects.requireNonNull(l.getWorld()));
        
        if (type == null) {
            if (inv.hasViewer()) {
                inv.replaceExistingItem(4, new CustomItem(
                        Material.GREEN_STAINED_GLASS_PANE,
                        "&c未發電",
                        "&7已儲存: &6" + LorePreset.format(getCharge(l)) + " J"
                ));
            }
            return 0;
        } else {
            int gen = type.more ? this.generation << 1 : this.generation;
            if (inv.hasViewer()) {
                inv.replaceExistingItem(4, new CustomItem(
                        Material.GREEN_STAINED_GLASS_PANE,
                        "&a發電",
                        "&7類型: &6" + type.status,
                        "&7產生中: &6" + LorePreset.roundHundreds(gen * PluginUtils.TICK_RATIO) + " J/s ",
                        "&7已儲存: &6" + LorePreset.format(getCharge(l)) + " J"
                ));
            }
            return gen;
        }
    }

    private Type getGeneration(@Nonnull Block block, @Nonnull World world) {
        if (this.type == Type.WATER) {

            // don't check water log every tick
            if (Util.isWaterLogged(block)) {
                return Type.WATER;
            }

        } else if (this.type == Type.INFINITY) {

            return Type.INFINITY;

        } else if (world.getEnvironment() == World.Environment.NETHER) {

            if (this.type == Type.GEOTHERMAL) {
                return Type.NETHER;
            }

            if (this.type == Type.LUNAR) {
                return Type.LUNAR;
            }

        } else if (world.getEnvironment() == World.Environment.THE_END) {

            if (this.type == Type.LUNAR) {
                return Type.LUNAR;
            }

        } else if (world.getEnvironment() == World.Environment.NORMAL) {

            if (this.type == Type.GEOTHERMAL) {
                return Type.GEOTHERMAL;
            }

            if (world.getTime() >= 13000 || block.getLocation().add(0, 1, 0).getBlock().getLightFromSky() != 15) {

                if (this.type == Type.LUNAR) {
                    return Type.LUNAR;
                }

            } else if (this.type == Type.SOLAR) {
                return Type.SOLAR;
            }
        }

        return null;
    }

    @Override
    public int getCapacity() {
        return this.storage;
    }

    @Nonnull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.GENERATOR;
    }

    @Override
    public int getStatus() {
        return 4;
    }

    @AllArgsConstructor
    private enum Type {
        WATER("水力發電", false),
        GEOTHERMAL("地熱", false),
        SOLAR("日間", false),
        LUNAR("夜間", false),
        INFINITY("無限", false),
        
        NETHER("地獄 (2x)", true);
        
        private final String status;
        private final boolean more;
        
    }

}