package io.github.mooy1.infinityexpansion.implementation.materials;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.mooy1.infinityexpansion.implementation.blocks.InfinityWorkbench;
import io.github.mooy1.infinityexpansion.setup.categories.Categories;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class InfinityItem extends UnplaceableBlock {
    
    public static final SlimefunItemStack CIRCUIT = new SlimefunItemStack(
            "INFINITE_MACHINE_CIRCUIT",
            Material.DIAMOND,
            "&b無限&6機器電路板",
            "&7機器組件"
    );
    public static final SlimefunItemStack CORE = new SlimefunItemStack(
            "INFINITE_MACHINE_CORE",
            Material.DIAMOND_BLOCK,
            "&b無限機器核心",
            "&7機器組件"
    );
    
    public static void setup(InfinityExpansion plugin) {
        new InfinityItem(CIRCUIT, new ItemStack[] {
                MachineItem.MACHINE_CIRCUIT, SmelteryItem.INFINITY, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT, SmelteryItem.INFINITY, MachineItem.MACHINE_CIRCUIT,
                CompressedItem.VOID_INGOT, MachineItem.MACHINE_CIRCUIT, CompressedItem.VOID_INGOT, CompressedItem.VOID_INGOT, MachineItem.MACHINE_CIRCUIT, CompressedItem.VOID_INGOT,
                SmelteryItem.INFINITY, CompressedItem.VOID_INGOT, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT, CompressedItem.VOID_INGOT, SmelteryItem.INFINITY,
                SmelteryItem.INFINITY, CompressedItem.VOID_INGOT, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT, CompressedItem.VOID_INGOT, SmelteryItem.INFINITY,
                CompressedItem.VOID_INGOT, MachineItem.MACHINE_CIRCUIT, CompressedItem.VOID_INGOT, CompressedItem.VOID_INGOT, MachineItem.MACHINE_CIRCUIT, CompressedItem.VOID_INGOT,
                MachineItem.MACHINE_CIRCUIT, SmelteryItem.INFINITY, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT, SmelteryItem.INFINITY, MachineItem.MACHINE_CIRCUIT
        }).register(plugin);
        new InfinityItem(CORE, new ItemStack[] {
                MachineItem.MACHINE_PLATE, MachineItem.MACHINE_CORE, SmelteryItem.INFINITY, SmelteryItem.INFINITY, MachineItem.MACHINE_CORE, MachineItem.MACHINE_PLATE,
                MachineItem.MACHINE_CORE, MachineItem.MACHINE_PLATE, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_PLATE, MachineItem.MACHINE_CORE,
                SmelteryItem.INFINITY, MachineItem.MACHINE_CIRCUIT, SmelteryItem.INFINITY, SmelteryItem.INFINITY, MachineItem.MACHINE_CIRCUIT, SmelteryItem.INFINITY,
                SmelteryItem.INFINITY, MachineItem.MACHINE_CIRCUIT, SmelteryItem.INFINITY, SmelteryItem.INFINITY, MachineItem.MACHINE_CIRCUIT, SmelteryItem.INFINITY,
                MachineItem.MACHINE_CORE, MachineItem.MACHINE_PLATE, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_PLATE, MachineItem.MACHINE_CORE,
                MachineItem.MACHINE_PLATE, MachineItem.MACHINE_CORE, SmelteryItem.INFINITY, SmelteryItem.INFINITY, MachineItem.MACHINE_CORE, MachineItem.MACHINE_PLATE
        }).register(plugin);
    }

    private InfinityItem(SlimefunItemStack item, ItemStack[] recipe) {
        super(Categories.INFINITY_CHEAT, item, InfinityWorkbench.TYPE, recipe);
    }

}
