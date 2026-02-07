package fr.hippo.events;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import fr.hippo.HippoPlugin;

public class PlayerEnterUniverseEvent {

    public static void onPlayerConnect(PlayerReadyEvent event){
        Player player = event.getPlayer();
        String name = player.getDisplayName();
        player.sendMessage(Message.raw("HELLO " + name + " how are you today?"));
        HippoPlugin.LOGGER.atInfo().log(name + " just connected on server.");
    }
}
