package fr.hippo;

import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import dev.hytalemodding.commands.ExampleCommand;
import dev.hytalemodding.events.ExampleEvent;
import fr.hippo.commands.HelloWorld;
import fr.hippo.commands.Velocity;
import fr.hippo.interactions.ArtifactPushback;

import javax.annotation.Nonnull;

public class HippoPlugin extends JavaPlugin {

    public HippoPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        //this.getCommandRegistry().registerCommand(new ExampleCommand("example", "An example command"));
        //this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, ExampleEvent::onPlayerReady);
        this.getCodecRegistry(Interaction.CODEC).register("artifact_pushback", ArtifactPushback.class, ArtifactPushback.CODEC);
        this.getCommandRegistry().registerCommand(new HelloWorld("hello", "A simple Hello World command"));
        this.getCommandRegistry().registerCommand(new Velocity("velocity", "Launch player forward, directed by their head rotation"));
    }
}