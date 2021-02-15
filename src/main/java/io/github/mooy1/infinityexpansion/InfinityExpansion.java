package io.github.mooy1.infinityexpansion;

import io.github.mooy1.infinityexpansion.setup.Setup;
import io.github.mooy1.infinityexpansion.setup.commands.GiveRecipe;
import io.github.mooy1.infinitylib.ConfigUtils;
import io.github.mooy1.infinitylib.PluginUtils;
import io.github.mooy1.infinitylib.command.CommandManager;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import lombok.Getter;
import org.bstats.bukkit.Metrics;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;

public class InfinityExpansion extends JavaPlugin implements SlimefunAddon {

    @Getter
    private static InfinityExpansion instance;
    @Getter
    private static double difficulty = 1;

    @Override
    public void onEnable() {
        instance = this;

        PluginUtils.setup(ChatColor.AQUA + "無限" + ChatColor.GRAY + "附加", this, "xMikux/InfinityExpansion/master", getFile());
        
        CommandManager.setup("infinityexpansion", "infinityexpansion.admin", "/ie, /ix, /infinity",
                new GiveRecipe()
        );

        @SuppressWarnings("unused")
        final Metrics metrics = new Metrics(this, 8991);

        difficulty = ConfigUtils.getDouble(getConfig(), "balance-options.difficulty", .1, 10, 1);

        Setup.setup(this);
        
        PluginUtils.startTicker(() -> {});

    }

    @Override
    public void onDisable() {
        instance = null;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/xMikux/InfinityExpansion/issues";
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}