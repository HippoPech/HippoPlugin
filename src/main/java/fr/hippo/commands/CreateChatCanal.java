package fr.hippo.commands;

import com.hypixel.hytale.server.core.command.system.AbstractCommand;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.arguments.system.OptionalArg;
import com.hypixel.hytale.server.core.command.system.arguments.system.RequiredArg;
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes;
import fr.hippo.ChatCanal;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.concurrent.CompletableFuture;

public class CreateChatCanal extends AbstractCommand {

    private final RequiredArg<String> id;
    private final RequiredArg<String> name;
    private final RequiredArg<String> description;
    private final RequiredArg<Integer> distance;
    private final RequiredArg<String> prefix;
    private final OptionalArg<Boolean> isGlobal;
    private final OptionalArg<Boolean> isUniversal;
    private final OptionalArg<String> permission;

    protected CreateChatCanal(@NullableDecl String name, @NullableDecl String description) {
        super(name, description);

        this.id = (this.withRequiredArg("id", "Identifier of chat canal", ArgTypes.STRING));
        this.name = (this.withRequiredArg("id", "Identifier of chat canal", ArgTypes.STRING));
        this.description = (this.withRequiredArg("id", "Identifier of chat canal", ArgTypes.STRING));
        this.distance = (this.withRequiredArg("id", "Identifier of chat canal", ArgTypes.INTEGER));
        this.prefix = (this.withRequiredArg("id", "Identifier of chat canal", ArgTypes.STRING));
        this.isGlobal = (this.withOptionalArg("id", "Identifier of chat canal", ArgTypes.BOOLEAN));
        this.isUniversal = (this.withOptionalArg("id", "Identifier of chat canal", ArgTypes.BOOLEAN));
        this.permission = (this.withOptionalArg("id", "Identifier of chat canal", ArgTypes.STRING));

    }

    @NullableDecl
    @Override
    protected CompletableFuture<Void> execute(@NonNullDecl CommandContext commandContext) {
        ChatCanal canal = new ChatCanal(this.id.get(commandContext), this.name.get(commandContext), this.description.get(commandContext), this.prefix.get(commandContext), this.distance.get(commandContext));
        return null;
    }
}
