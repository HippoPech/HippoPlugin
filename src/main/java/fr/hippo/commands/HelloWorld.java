package fr.hippo.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.AbstractCommand;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.concurrent.CompletableFuture;

public class HelloWorld extends AbstractCommand {

    public HelloWorld(@NullableDecl String name, @NullableDecl String description) {
        super(name, description);
    }

    @NullableDecl
    @Override
    protected CompletableFuture<Void> execute(@NonNullDecl CommandContext commandContext) {
        String name = commandContext.sender().getDisplayName();
        commandContext.sendMessage(Message.raw("Hello " + name + " !"));
        return CompletableFuture.completedFuture(null);
    }
}
