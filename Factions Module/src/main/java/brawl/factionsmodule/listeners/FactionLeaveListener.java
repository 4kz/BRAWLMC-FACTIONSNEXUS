package brawl.factionsmodule.listeners;

import brawl.factionsmodule.FactionsModuleController;
import brawl.nexuscore.util.NexusOperations;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.event.FPlayerLeaveEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FactionLeaveListener implements Listener {

    String                      lastPlayerInFactionError;
    String                      nameOfTheBeaconWand;

    public FactionLeaveListener() {
        lastPlayerInFactionError    = FactionsModuleController.plugin.getConfig().getString("lastPlayerInFactionError");
        nameOfTheBeaconWand         = FactionsModuleController.plugin.getConfig().getString("nameOfTheBeaconWand");
    }

    @EventHandler
    public void factionLeave (FPlayerLeaveEvent event) {

        FPlayer     fPlayer             = event.getfPlayer();
        Faction     faction             = fPlayer.getFaction();
        Player      player              = fPlayer.getPlayer();

        if (faction.getFPlayers().size() == 1)
        {
            NexusOperations.removeFromPlayer(player);
        }

    }

}
