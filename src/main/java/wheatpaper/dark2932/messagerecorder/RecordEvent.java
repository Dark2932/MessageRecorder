package wheatpaper.dark2932.messagerecorder;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordEvent implements Listener {

    private final JavaPlugin plugin = MessageRecorder.plugin;
    private final YamlConfiguration newConfig = new YamlConfiguration();

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        newConfig.set(new SimpleDateFormat("HH:mm:ss").format(new Date()), "<" + player.getName() + "> " + message);

        try {
            newConfig.save(new File(plugin.getDataFolder(), new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
