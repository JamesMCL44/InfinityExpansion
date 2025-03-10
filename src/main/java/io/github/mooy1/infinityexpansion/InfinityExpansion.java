package io.github.mooy1.infinityexpansion;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import javax.annotation.Nonnull;

import io.github.mooy1.infinityexpansion.categories.Categories;
import io.github.mooy1.infinityexpansion.commands.GiveRecipe;
import io.github.mooy1.infinityexpansion.commands.PrintItem;
import io.github.mooy1.infinityexpansion.commands.SetData;
import io.github.mooy1.infinityexpansion.items.Blocks;
import io.github.mooy1.infinityexpansion.items.Gear;
import io.github.mooy1.infinityexpansion.items.Generators;
import io.github.mooy1.infinityexpansion.items.Machines;
import io.github.mooy1.infinityexpansion.items.Materials;
import io.github.mooy1.infinityexpansion.items.MobData;
import io.github.mooy1.infinityexpansion.items.Quarries;
import io.github.mooy1.infinityexpansion.items.Researches;
import io.github.mooy1.infinityexpansion.items.SlimefunExtension;
import io.github.mooy1.infinityexpansion.items.Storage;
import io.github.mooy1.infinitylib.AbstractAddon;
//import io.github.mooy1.infinitylib.bstats.bukkit.Metrics;
import io.github.mooy1.infinitylib.commands.AbstractCommand;

public final class InfinityExpansion extends AbstractAddon {

    private static InfinityExpansion instance;

    public static InfinityExpansion inst() {
        return instance;
    }

    @Override
    public void enable() {
        instance = this;

        if (getServer().getPluginManager().getPlugin("LiteXpansion") != null) {
            runSync(() -> log(Level.WARNING,
                    "########################################################",
                    "LiteXpansion 削弱(nerfs)此附加的能源發電機.",
                    "你可以在LiteXpansion的config內關閉此削弱.",
                    "在 'options:' 增加 'nerf-other-addons: false'",
                    "########################################################"
            ));
        }

        Categories.setup(this);
        MobData.setup(this);
        Materials.setup(this);
        Machines.setup(this);
        Quarries.setup(this);
        Gear.setup(this);
        Blocks.setup(this);
        Storage.setup(this);
        Generators.setup(this);
        SlimefunExtension.setup(this);

        if (getConfig().getBoolean("balance-options.enable-researches")) {
            Researches.setup();
        }
    }

    //@Override
    /*protected Metrics setupMetrics() {
        return new Metrics(this, 8991);
    }*/

    @Nonnull
    @Override
    protected String getGithubPath() {
        return "SlimeTraditionalTranslation/InfinityExpansion/master";
    }

    @Nonnull
    @Override
    protected List<AbstractCommand> setupSubCommands() {
        return Arrays.asList(new GiveRecipe(), new SetData(), new PrintItem());
    }

    @Nonnull
    @Override
    public String getAutoUpdatePath() {
        return "auto-update";
    }

    @Override
    public void disable() {
        instance = null;
    }

}
