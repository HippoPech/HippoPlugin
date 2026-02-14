package fr.hippo;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ChatCanal implements Component<EntityStore> {

    public static final BuilderCodec<ChatCanal> CODEC = BuilderCodec.builder(ChatCanal.class, ChatCanal::new)
        .append(new KeyedCodec<String>("Id", Codec.STRING),
                (config, value) -> config.id = value, // Setter
                (config) -> config.id).add() // Getter
        .append(new KeyedCodec<Integer>("Distance", Codec.INTEGER),
                (config, value) -> config.distance = value, // Setter
                (config) -> config.distance).add() // Getter
        .append(new KeyedCodec<String>("Description", Codec.STRING),
                (config, value) -> config.description = value, // Setter
                (config) -> config.description).add() // Getter
        .append(new KeyedCodec<String>("Prefix", Codec.STRING),
                (config, value) -> config.prefix = value, // Setter
                (config) -> config.prefix).add() // Getter
        .append(new KeyedCodec<Boolean>("IsGlobal", Codec.BOOLEAN),
                (config, value) -> config.isGlobal = value, // Setter
                (config) -> config.isGlobal).add() // Getter
        .append(new KeyedCodec<Boolean>("IsUniversal", Codec.BOOLEAN),
                (config, value) -> config.isUniversal = value, // Setter
                (config) -> config.isUniversal).add() // Getter
        .append(new KeyedCodec<String>("Permission", Codec.STRING),
                (config, value) -> config.permission = value, // Setter
                (config) -> config.permission).add() // Getter
        .build();


    private String id;
    private int distance;
    private String name;
    private String description;
    private String prefix;
    private boolean isGlobal;
    private boolean isUniversal;
    private String permission;


    public ChatCanal() {}

    public ChatCanal(String id, String name, String description, String prefix, int distance, boolean isGlobal, boolean isUniversal, String permission) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.prefix = prefix;
        this.distance = distance;
        this.isGlobal = isGlobal;
        this.isUniversal = isUniversal;
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    public void setGlobal(boolean global) {
        isGlobal = global;
    }

    public boolean isUniversal() {
        return isUniversal;
    }

    public void setUniversal(boolean universal) {
        isUniversal = universal;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @NullableDecl
    @Override
    //TODO
    public Component<EntityStore> clone() {
        return null;
    }

    @NullableDecl
    @Override
    //TODO
    public Component<EntityStore> cloneSerializable() {
        return Component.super.cloneSerializable();
    }
}
