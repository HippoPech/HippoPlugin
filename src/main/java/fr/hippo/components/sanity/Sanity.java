package fr.hippo.components.sanity;

import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.ArrayList;

public class Sanity implements Component<EntityStore> {

    private ArrayList<SanityPoint> san;
    private int maxSan;

    public Sanity() {
        this.san = new ArrayList<SanityPoint>();
        this.maxSan = 1;
    }

    public Sanity(int value){
        this.san = new ArrayList<>();
        //san.addAll()
    }


    @NullableDecl
    @Override
    public Component<EntityStore> clone() {
        return this;
    }

    @NullableDecl
    @Override
    public Component<EntityStore> cloneSerializable() {
        return Component.super.cloneSerializable();
    }
    //public statis
}
