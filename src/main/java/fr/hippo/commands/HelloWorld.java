package fr.hippo.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.math.vector.Transform;
import com.hypixel.hytale.math.vector.Vector3d;
import com.hypixel.hytale.math.vector.Vector3f;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.AbstractCommand;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.CommandSender;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.entity.knockback.KnockbackComponent;
import com.hypixel.hytale.server.core.modules.entity.teleport.Teleport;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.server.combat.Knockback;
import com.hypixel.hytale.server.core.modules.physics.component.Velocity;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.concurrent.CompletableFuture;

public class HelloWorld extends AbstractPlayerCommand {
    public HelloWorld(@NullableDecl String name, @NullableDecl String description) {
        super(name, description);
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

            //Velocity velocity = store.getComponent(player.getReference(), Velocity.getComponentType());
            //velocity.addForce(1,1,1);

            KnockbackComponent knockback= new KnockbackComponent();

            Vector3d position = playerRef.getTransform().getPosition();



            //Vector3d.directionTo(position)

            LOGGER.atInfo().log("Rotation: " + rotation.toString());





            //Vector3d direction = playerRef.getTransform().getDirection().add();

            //Vector3d direction = new Vector3d(playerRef.getTransform().getRotation());
            //LOGGER.atInfo().log("Direction: " + direction.toString());

            //knockback.setVelocity(new Vector3d(2,2,2));

            //store.addComponent(player.getReference(), KnockbackComponent.getComponentType(), knockback);

            //player.sendMessage(Message.raw("Velocity: " + velocity.toString()));

            //store.addComponent(player.getReference(), Velocity.getComponentType(), velocity);

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
