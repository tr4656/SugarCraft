//import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
//import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerListener;
//import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Handle events for all Player related events
 * @author JamesWP
 */
public class HealPlayerListener extends PlayerListener {
    //private final Heal plugin;

    public HealPlayerListener(Heal instance) {
        //plugin = instance;
    }
    public void onPlayerCommand(PlayerChatEvent event) {
		  //Make the message a string.
			String[] split = event.getMessage().split(" ");
			//Get the player that talked.
			
			//If the first part of the string is /basic or /b then do this.
			if ((split[0].equalsIgnoreCase("/heal"))
					|| (split[0].equalsIgnoreCase("/h"))
					|| (split[0].equalsIgnoreCase("///"))) {


				Player player = event.getPlayer();
				player.setHealth(20);
				player.setFireTicks(0);
				
				event.setCancelled(true);
			}

		}
}