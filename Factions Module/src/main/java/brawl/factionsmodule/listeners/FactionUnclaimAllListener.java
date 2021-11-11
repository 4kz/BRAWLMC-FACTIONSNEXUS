package brawl.factionsmodule.listeners;

import brawl.nexuscore.events.NexusBrokenEvent;
import brawl.nexuscore.util.NexusOperations;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.event.LandUnclaimAllEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FactionUnclaimAllListener implements Listener {

    @EventHandler
    public void factionUnclaim(LandUnclaimAllEvent event) throws Exception {
        FPlayer fPlayer     = event.getfPlayer();
        Player player       = fPlayer.getPlayer();
        Faction faction     = fPlayer.getFaction();

        Location location                    = faction
                .getHome();

        if(!faction.hasHome())
            return;

        try{
            NexusOperations.addToInventory(player);
        } catch (Exception e) {
            player.sendMessage(e.getMessage());
            event.setCancelled(true);
            return;
        }

        NexusBrokenEvent nexusBrokenEvent = new NexusBrokenEvent(location);
        Bukkit.getPluginManager().callEvent(nexusBrokenEvent);

        NexusOperations.addToInventory(player);


    }
}
