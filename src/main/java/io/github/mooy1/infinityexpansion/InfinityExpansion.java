package io.github.mooy1.infinityexpansion;

import io.github.mooy1.infinityexpansion.setup.Setup;
import io.github.mooy1.infinityexpansion.setup.commands.GiveRecipe;
import io.github.mooy1.infinitylib.ConfigUtils;
import io.github.mooy1.infinitylib.PluginUtils;
//import io.github.mooy1.infinitylib.bstats.bukkit.Metrics;
import io.github.mooy1.infinitylib.command.CommandManager;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import java.util.logging.Level;

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
        
        //Metrics metrics = PluginUtils.setupMetrics(8991);

        loadDifficulty();
        
        //metrics.addCustomChart(new Metrics.SimplePie("difficulty", () -> String.valueOf(difficulty)));
        
        boolean lXInstalled = getServer().getPluginManager().getPlugin("LiteXpansion") != null;
        
        if (lXInstalled) {
            PluginUtils.runSync(() -> PluginUtils.log(Level.WARNING,
                    "############################################",
                    "LiteXpansion 對此插件上的一些物品進行了削弱(nerfs),",
                    " 以及Slimefun的一些物品.",
                    "如果你不希望有這些削弱, 則需要刪除LiteXpansion.",
                    "任何由此引起的投訴應提交給LiteXpansion.",
                    "############################################"
            ));
        }
        
        //metrics.addCustomChart(new Metrics.SimplePie("litexpansion_installed", () -> String.valueOf(lXInstalled)));
        
        Setup.setup(this);
        
        PluginUtils.startTicker(() -> {});
    }
    
    private void loadDifficulty() {
        double val = ConfigUtils.getDouble(getConfig(), "balance-options.difficulty", .1, 10, 1);
        // round to .1 .2 .3 or 1 2 3 etc
        if (val < 1) {
            val = ((int) (val * 10)) / 10D;
        } else if (val > 1) {
            val = (int) val;
        }
        difficulty = val;
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
