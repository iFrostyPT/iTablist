package Frosty.TabList;

import Frosty.Control.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Bukkit;
import me.clip.placeholderapi.PlaceholderAPI;

public class TabListControl implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void aoEntrar(PlayerJoinEvent e){
        String Header = Main.main.getConfig().getString("Header").replace('&', '§');
        String Footer = Main.main.getConfig().getString("Footer").replace('&', '§');
        e.getPlayer().setPlayerListHeaderFooter(PlaceholderAPI.setPlaceholders(e.getPlayer(), Header), PlaceholderAPI.setPlaceholders(e.getPlayer(), Footer));
    }

    public static void Update() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.main, new Runnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers() ){
                    String Header = Main.main.getConfig().getString("Header").replace('&', '§');
                    String Footer = Main.main.getConfig().getString("Footer").replace('&', '§');
                    p.getPlayer().setPlayerListHeaderFooter(PlaceholderAPI.setPlaceholders(p, Header), PlaceholderAPI.setPlaceholders(p, Footer));
                }
            }
        }, 0, Main.main.getConfig().getInt("UpdateTime"));
    }


}