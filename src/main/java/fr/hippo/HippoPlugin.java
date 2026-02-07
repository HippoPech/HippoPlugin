package fr.hippo;

import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerConnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import fr.hippo.commands.GetPlayerInfo;
import fr.hippo.commands.HelloWorld;
import fr.hippo.commands.Velocity;
import fr.hippo.components.EnergyComponent;
import fr.hippo.events.PlayerChat;
import fr.hippo.events.PlayerEnterUniverseEvent;
import fr.hippo.interactions.ArtifactPushback;

import javax.annotation.Nonnull;

public class HippoPlugin extends JavaPlugin {

    public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();
    private ComponentType<EntityStore, EnergyComponent> energyComponent;

    public HippoPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        this.getCodecRegistry(Interaction.CODEC).register("artifact_pushback", ArtifactPushback.class, ArtifactPushback.CODEC);
        this.getCommandRegistry().registerCommand(new HelloWorld("hello", "A simple Hello World command"));
        this.getCommandRegistry().registerCommand(new Velocity("velocity", "Launch player forward, directed by their head rotation"));
        //this.getCommandRegistry().registerCommand(new GetPlayerInfo("get", "Get infos on player"));

        this.energyComponent = this.getEntityStoreRegistry().registerComponent(
                EnergyComponent.class,
                "EnergyComponent",
                EnergyComponent.CODEC
        );
        this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, PlayerEnterUniverseEvent::onPlayerConnect);
        this.getEventRegistry().registerGlobal(PlayerChatEvent.class, PlayerChat::onPlayerChat);
    }
}