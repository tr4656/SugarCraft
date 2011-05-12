package us.icebrg.sugarcraft;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Handle events for all Player related events
 * @author tr4656, jonathanyc
 */
public class SCPlayerListener extends PlayerListener
{
    private final SugarCraft plugin;

    public SCPlayerListener(SugarCraft instance)
    {
        plugin = instance;
    }

    public void onPlayerInteract(PlayerInteractEvent event)
    {
    	switch (event.getAction())
    	{
    		case RIGHT_CLICK_AIR:
    		case RIGHT_CLICK_BLOCK:
    			
    			break;
    	}
    }
    //Insert Player related code here
}