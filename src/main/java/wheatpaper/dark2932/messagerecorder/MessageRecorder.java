package wheatpaper.dark2932.messagerecorder;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MessageRecorder extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        this.getLogger().info("MessageRecorder loaded!");
        Bukkit.getPluginManager().registerEvents(new RecordEvent(), this);
    }

}
