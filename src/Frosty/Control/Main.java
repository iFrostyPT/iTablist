package Frosty.Control;

import Frosty.TabList.TabListControl;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main main;
    public static PluginManager pm;

    public void onEnable() {
        saveDefaultConfig();
        main = this;
        pm = Bukkit.getPluginManager();
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            TabListControl.Update();
            pm.registerEvents(new TabListControl(), main);
            Bukkit.getConsoleSender().sendMessage("§a[iTablist] Successfully activated.");
        } else {
            throw new RuntimeException("This plugin need the PlaceHolderAPI plugin!");
        }

    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c[iTablist] Successfully disable.");
    }
}
