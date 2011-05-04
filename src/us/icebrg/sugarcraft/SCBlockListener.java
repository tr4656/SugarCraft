import org.bukkit.Block;
import org.bukkit.BlockFace;
import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

/**
 * SugarCraft block listener
 * @author tr4656, jonathanyc
 */
public class SCBlockListener extends BlockListener {
    private final SugarCraft plugin;

    public SCBlockListener(final SugarCraft plugin) {
        this.plugin = plugin;
    }

    //put all Block related code here
}