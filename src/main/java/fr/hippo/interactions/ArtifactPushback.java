package fr.hippo.interactions;

import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.math.vector.Vector3d;
import com.hypixel.hytale.protocol.InteractionState;
import com.hypixel.hytale.protocol.InteractionType;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.InteractionContext;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.entity.knockback.KnockbackComponent;
import com.hypixel.hytale.server.core.modules.interaction.interaction.CooldownHandler;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.SimpleInstantInteraction;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class ArtifactPushback extends SimpleInstantInteraction {

    public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();
    public static final BuilderCodec<ArtifactPushback> CODEC = BuilderCodec.builder(
            ArtifactPushback.class, ArtifactPushback::new, SimpleInstantInteraction.CODEC
    ).build();

    @Override
    protected void firstRun(@NonNullDecl InteractionType interactionType, @NonNullDecl InteractionContext interactionContext, @NonNullDecl CooldownHandler cooldownHandler) {
        CommandBuffer<EntityStore> commandBuffer = interactionContext.getCommandBuffer();
        //Check if commandBuffer not null
        if(commandBuffer == null) {
            interactionContext.getState().state = InteractionState.Failed;
            LOGGER.atInfo().log("commandBuffer is null");
            return;
        }
        //retrieve ref of whatever triggering interaction
        Ref<EntityStore> ref = interactionContext.getEntity();
        //get store of this entity
        Store<EntityStore> store = ref.getStore();

        //get Knockback component
        KnockbackComponent knockbackComponent = store.getComponent(ref, KnockbackComponent.getComponentType());

        knockbackComponent.setVelocity(new Vector3d(1d,1d,1d));

        //Player is also a component of PlayerRef
        Player player = commandBuffer.getComponent(ref, Player.getComponentType());


        if(player == null) {
            interactionContext.getState().state = InteractionState.Failed;
            LOGGER.atInfo().log("player is null");
            return;
        }

        player.sendMessage(Message.raw("Hello your velocity is now " + knockbackComponent.getVelocity().toString()));


        //player.processVelocitySample(4, player.getPlayerConfigData().lastSavedPosition, );
    }
}
