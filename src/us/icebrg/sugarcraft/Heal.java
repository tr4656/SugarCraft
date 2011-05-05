//import java.awt.Color;
//import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

//import org.bukkit.command.Command;
//import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
//import org.bukkit.Server;
//import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
//import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

/**
 * Heal for Bukkit
 *
 * @author JamesWP
 */
public class Heal extends JavaPlugin {
	
	private static final Logger log = Logger.getLogger("Minecraft");
	
	private final HealPlayerListener playerListener = new HealPlayerListener(this);
    
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();

    public void onEnable() {

        // Register our events
        PluginManager pm = getServer().getPluginManager();
       
        pm.registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, this.playerListener, Event.Priority.Normal, this);
        
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
        log.log(Level.INFO,"{HEAL} ENABELED");
    }
    public void onDisable() {
    	log.log(Level.INFO,"{HEAL} DISABLED");
    	System.out.println("Goodbye world!");
    }
    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        debugees.put(player, value);
    }
    
}