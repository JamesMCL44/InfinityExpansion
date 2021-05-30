package io.github.mooy1.infinityexpansion;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import javax.annotation.Nonnull;

import io.github.mooy1.infinityexpansion.categories.Categories;
import io.github.mooy1.infinityexpansion.commands.GiveRecipe;
import io.github.mooy1.infinityexpansion.commands.PrintItem;
import io.github.mooy1.infinityexpansion.commands.SetData;
import io.github.mooy1.infinityexpansion.implementation.SlimefunExtension;
import io.github.mooy1.infinityexpansion.implementation.blocks.Blocks;
import io.github.mooy1.infinityexpansion.implementation.gear.Gear;
import io.github.mooy1.infinityexpansion.implementation.generators.Generators;
import io.github.mooy1.infinityexpansion.implementation.machines.Machines;
import io.github.mooy1.infinityexpansion.implementation.materials.Materials;
import io.github.mooy1.infinityexpansion.implementation.mobdata.MobData;
import io.github.mooy1.infinityexpansion.implementation.storage.Storage;
import io.github.mooy1.infinitylib.AbstractAddon;
//import io.github.mooy1.infinitylib.bstats.bukkit.Metrics;
import io.github.mooy1.infinitylib.commands.AbstractCommand;

public final class InfinityExpansion extends AbstractAddon {

    private static InfinityExpansion instance;

    public static InfinityExpansion inst() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        super.onEnable();
        if (getServer().getPluginManager().getPlugin("LiteXpansion") != null) {
            runSync(() -> log(Level.WARNING,
                    "########################################################",
                    "LiteXpansion 削弱(nerfs)此附加的能源發電機.",
                    "你可以在LiteXpansion的config內關閉此削弱.",
                    "在 'options:' 增加 'nerf-other-addons: false'",
                    "########################################################"
            ));
        }

        try {
            Categories.setup(this);
            MobData.setup(this);
            Materials.setup(this);
            Machines.setup(this);
            Gear.setup(this);
            Blocks.setup(this);
            Storage.setup(this);
            Generators.setup(this);
            SlimefunExtension.setup(this);
        } catch (Throwable e) {
            runSync(() -> {
                log(Level.SEVERE,
                        "The following error has occurred during InfinityExpansion startup!",
                        "Not all items will be available because of this!",
                        "Report this on Github or Discord and make sure to update Slimefun!"
                );
                e.printStackTrace();
            });
        }
    }

    //@Override
    /*protected Metrics setupMetrics() {
        return new Metrics(this, 8991);
    }*/

    @Nonnull
    @Override
    protected String getGithubPath() {
        return "xMikux/InfinityExpansion/master";
    }

    @Nonnull
    @Override
    protected List<AbstractCommand> getSubCommands() {
        return Arrays.asList(new GiveRecipe(), new SetData(), new PrintItem());
    }

    @Override
    public void onDisable() {
        instance = null;
    }

}
