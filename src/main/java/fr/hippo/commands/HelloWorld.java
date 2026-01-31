package fr.hippo.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.AbstractCommand;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.CommandSender;
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
        CommandSender sender = commandContext.sender();

        sender.sendMessage(Message.raw("Hello " + sender.getDisplayName() + " you just executed a command. Wow."));
        return CompletableFuture.completedFuture(null);
    }
}
