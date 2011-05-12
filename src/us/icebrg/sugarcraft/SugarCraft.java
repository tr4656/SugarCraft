package us.icebrg.sugarcraft;

import java.util.HashMap;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

/**
 * Sample plugin for Bukkit
 *
 * 
 *  */
public class SugarCraft extends JavaPlugin
{
    private final SCPlayerListener playerListener = new SCPlayerListener(this);
    private final SCBlockListener blockListener = new SCBlockListener(this);
    /**
     * The Integer value stores the addiction level. The addiction level goes up
     * one every time a player uses sugar.
     */
    private HashMap<Player, Integer> addictedPlayers = new HashMap<Player, Integer>();

    public void onDisable()
    {
    	FileWriter fileWriter = null;
    	Gson gson = new Gson();
    	
    	try
    	{
    		fileWriter = new FileWriter("addicted.json");
    		fileWriter.write(gson.toJson(this.addictedPlayers));

    	}
    	catch (IOException e)
    	{
    		System.out.println("Unable to write to addicted.json file");
    		
    		return;
    	}
    	finally
    	{
    		try
    		{
    			fileWriter.close();
    		}
    		catch (IOException ignore) { }
    	}
    	
    	System.out.println("Serialized addicted players list and saved to addicted.json.");
    	
        // TODO: Place any custom disable code here

        // NOTE: All registered events are automatically unregistered when a plugin is disabled

    	
        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        System.out.println("Goodbye world!");
    }

    public void onEnable()
    {
    	FileReader fileReader = null;
    	Gson gson = new Gson();
    	
    	try
    	{
    		fileReader = new FileReader("addicted.json");
    		this.addictedPlayers = gson.fromJson(fileReader, new TypeToken<HashMap<Player, Integer>>() {}.getType());
    	}
    	catch (IOException e)
    	{
    		System.out.println("Unable to read from addicted.json file");
    		
    		return;
    	}
    	finally
    	{
    		try
    		{
    			fileReader.close();
    		}
    		catch (IOException ignore) { }
    	}
    	
        // TODO: Place any custom enable code here including the registration of any events

        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.PLAYER_QUIT, playerListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.BLOCK_PHYSICS, blockListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.BLOCK_CANBUILD, blockListener, Priority.Normal, this);
    	pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Priority.Normal, this);

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }
    
    /**
     * Add to the player's addiction level and register them in the addictedPlayers
     * HashMap
     * @param player the player whose addiction level to increase
     */
    public void addAddiction(Player player)
    {
    	Integer addictionLevel;
    	
    	if ( ! this.addictedPlayers.containsKey(player))
    	{
    		this.addictedPlayers.put(player, 1);
    		
    		return;
    	}
    	addictionLevel = this.addictedPlayers.get(player);
    	
    	addictionLevel++;
    	
    	this.addictedPlayers.put(player, addictionLevel);
    }
}