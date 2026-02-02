package fr.hippo.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.math.util.TrigMathUtil;
import com.hypixel.hytale.math.vector.Transform;
import com.hypixel.hytale.math.vector.Vector3d;
import com.hypixel.hytale.math.vector.Vector3f;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.arguments.system.DefaultArg;
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.knockback.KnockbackComponent;
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
        Vector3f headRotation = playerRef.getHeadRotation();

        Vector3d forward = (getForwardVector(headRotation)).scale(velocityForce);

        KnockbackComponent knockback = new KnockbackComponent();
        knockback.setVelocity(forward);
        store.addComponent(playerRef.getReference(), KnockbackComponent.getComponentType(), knockback);
    }

    private Vector3d getForwardVector (Vector3f headRotation){
        float forwardX = TrigMathUtil.cos(headRotation.getPitch());
        float forwardY = TrigMathUtil.sin(headRotation.getPitch());
        float forwardZ = TrigMathUtil.cos(headRotation.getPitch())  * TrigMathUtil.cos(headRotation.getYaw());

        return (new Vector3d(forwardX,forwardY,forwardZ));
    }
    private Vector3d getBackwardVector (Vector3f headRotation){
        Vector3d vector =  getForwardVector(headRotation);
        vector.setY(-headRotation.y);
        return vector;
    }
}
