package fr.hippo.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.math.util.TrigMathUtil;
import com.hypixel.hytale.math.vector.Transform;
import com.hypixel.hytale.math.vector.Vector3d;
import com.hypixel.hytale.math.vector.Vector3f;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.arguments.system.DefaultArg;
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.entity.knockback.KnockbackComponent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class HelloWorld extends AbstractPlayerCommand {

    private final DefaultArg<Float> force;

    public HelloWorld(@NullableDecl String name, @NullableDecl String description) {
        super(name, description);
        this.force = this.withDefaultArg("force", "Velocity force", ArgTypes.FLOAT, (float)50, "Default 50");
    }

    @Override
    protected void execute(@NonNullDecl CommandContext commandContext, @NonNullDecl Store<EntityStore> store, @NonNullDecl Ref<EntityStore> ref, @NonNullDecl PlayerRef playerRef, @NonNullDecl World world) {
        Transform currentPosition = playerRef.getTransform();
        //playerRef.sendMessage(Message.raw("Position: " + currentPosition.getPosition().toString()));
        //playerRef.sendMessage(Message.raw("Rotation: " + currentPosition.getRotation().toString()));
        //playerRef.sendMessage(Message.raw("Direction: " + currentPosition.getAxisDirection().toString()));
        Player player = store.getComponent(ref, Player.getComponentType());

        world.execute(() -> {
            if(player == null) return;

            float velocityForce = this.force.get(commandContext);
            LOGGER.atInfo().log("Velocity force is " + velocityForce);

            KnockbackComponent knockback= new KnockbackComponent();

            Vector3f rotation = playerRef.getTransform().getRotation();
            Vector3f headRotation = playerRef.getHeadRotation();

            //playerRef.sendMessage(Message.raw("Position:[" + position.x + ", " + position.y + ", " + position.z + "]"));
            //playerRef.sendMessage(Message.raw("Direction:[" + direction.x + ", " + direction.y + ", " + direction.z + "]"));
            playerRef.sendMessage(Message.raw("Rotation:[" + rotation.x + ", " + rotation.y + ", " + rotation.z + "]"));
            playerRef.sendMessage(Message.raw("Heard rotation:[" + headRotation.x + ", " + headRotation.y + ", " + headRotation.z + "]"));

            //LOGGER.atInfo().log("Position: " + rotation.toString());
            //LOGGER.atInfo().log("Direction: " + direction.toString());
            //LOGGER.atInfo().log("Rotation: " + rotation.toString());

            float forwardX = TrigMathUtil.cos(headRotation.getPitch());
            float forwardY = - TrigMathUtil.sin(headRotation.getPitch());
            float forwardZ = TrigMathUtil.cos(headRotation.getPitch())  * TrigMathUtil.cos(headRotation.getYaw());

            Vector3d velocityDirection = new Vector3d(forwardX*velocityForce,forwardY*velocityForce,forwardZ*velocityForce);
            LOGGER.atInfo().log("velocityDirection: " + velocityDirection.toString());
            //velocityDirection = (new Vector3f(forwardX*force,forwardY*force,forwardZ*force));

            LOGGER.atInfo().log("velocityDirection: " + velocityDirection.toString());

            knockback.setVelocity(velocityDirection);

            store.addComponent(player.getReference(), KnockbackComponent.getComponentType(), knockback);


            /*Teleport teleport = Teleport.createForPlayer(
                    world,
                    new Vector3d(currentPosition.getPosition().add(new Vector3d(1,1,1))),
                    new Vector3f(currentPosition.getRotation())
            );
            playerRef.sendMessage(Message.raw("Teleport " + playerRef.getUsername()));
            store.addComponent(player.getReference(), Teleport.getComponentType(), teleport);
            */
        });

    }

    /*@NullableDecl
    @Override
    protected CompletableFuture<Void> execute(@NonNullDecl CommandContext commandContext) {
        CommandSender sender = commandContext.sender();

        sender.sendMessage(Message.raw("Hello " + sender.getDisplayName() + " you just executed a command. Wow."));
        return CompletableFuture.completedFuture(null);
    }*/
}
