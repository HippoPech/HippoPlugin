package fr.hippo.events;

import com.hypixel.hytale.math.vector.Transform;
import com.hypixel.hytale.math.vector.Vector3d;
import com.hypixel.hytale.math.vector.VectorSphereUtil;
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.World;
import fr.hippo.HippoPlugin;

import java.util.Collection;
import java.util.List;

public class PlayerChat {
    public static void onPlayerChat(PlayerChatEvent event) {
        String content = event.getContent();
        PlayerRef senderRef = event.getSender();
        Vector3d senderPosition = senderRef.getTransform().getPosition();

        int chatDistance = 20;

        //get current world & senderRef of this world
        World world = Universe.get().getWorld(senderRef.getWorldUuid());
        Collection<PlayerRef> playerRefs = /*(List<PlayerRef>)*/ world.getPlayerRefs();

        HippoPlugin.LOGGER.atInfo().log("Number of players in current world : " + playerRefs.size());

        //check if others players is contained in a sphere around talking player
        playerRefs = playerRefs.stream().filter(ref -> VectorSphereUtil.isInside(
                senderPosition.getX(),
                senderPosition.getY(),
                senderPosition.getZ(),
                chatDistance,
                ref.getTransform().getPosition())
        ).toList();

        HippoPlugin.LOGGER.atInfo().log("Number of players in sphere : " + playerRefs.size());
        event.setTargets((List<PlayerRef>) playerRefs);

    }
}
