package fr.hippo.events;

import com.hypixel.hytale.math.shape.Box;
import com.hypixel.hytale.math.vector.Transform;
import com.hypixel.hytale.math.vector.Vector3d;
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.World;
import fr.hippo.HippoPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerChat {
    public static void onPlayerChat(PlayerChatEvent event) {
        PlayerRef playerRef = event.getSender();
        Transform transform = playerRef.getTransform();

        //get position bounds
        //TODO add a way to set variable area size
        Vector3d position1 = transform.getPosition().add(10);
        Vector3d position2 = transform.getPosition().add(-10);
        Box box = new Box(position1, position2);

        //get current world & playerRef of this world
        World world = Universe.get().getWorld(playerRef.getWorldUuid());
        Collection<PlayerRef> playerRefs = world.getPlayerRefs();

        HippoPlugin.LOGGER.atInfo().log("Players list in current world : " + playerRefs.toString());

        //filter to get player in range
        playerRefs = playerRefs.stream().filter(ref -> box.containsPosition(ref.getTransform().getPosition().x,
                ref.getTransform().getPosition().y,
                ref.getTransform().getPosition().z)
        ).toList();

        HippoPlugin.LOGGER.atInfo().log("Filtered player list in current world : " + playerRefs.toString());


    }
}
