package fr.hippo.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.math.vector.Vector3d;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.arguments.system.DefaultArg;
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.knockback.KnockbackComponent;
import com.hypixel.hytale.server.core.modules.entity.component.HeadRotation;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class Velocity extends AbstractPlayerCommand {

    private final DefaultArg<Float> force;

    public Velocity(@NonNullDecl String name, @NonNullDecl String description) {
        super(name, description);
        this.force = (this.withDefaultArg("force", "Velocity force", ArgTypes.FLOAT, (float)1, "Default 1"));
    }

    @Override
    protected void execute(@NonNullDecl CommandContext commandContext, @NonNullDecl Store<EntityStore> store, @NonNullDecl Ref<EntityStore> ref, @NonNullDecl PlayerRef playerRef, @NonNullDecl World world) {
        if (playerRef.getReference() == null) return;
        float velocityForce = (this.force.get(commandContext)) * 10;
        HeadRotation headRotation = store.getComponent(ref, HeadRotation.getComponentType());
        Vector3d forward = headRotation.getDirection().scale(velocityForce);
        KnockbackComponent knockback = new KnockbackComponent();
        knockback.setVelocity(forward);
        store.addComponent(playerRef.getReference(), KnockbackComponent.getComponentType(), knockback);
    }
}
