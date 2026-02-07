package fr.hippo.components;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.validation.Validators;
import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.math.util.MathUtil;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class EnergyComponent implements Component<EntityStore> {

    private float amount;
    private int level;

    public static final BuilderCodec<EnergyComponent> CODEC =
            BuilderCodec.builder(EnergyComponent.class, EnergyComponent::new)
                    .append(new KeyedCodec<>("amount", Codec.FLOAT),
                            (data, value) -> data.amount = value, // setter
                            data -> data.amount) // getter
                    .addValidator(Validators.nonNull())
                    .add()

                    .append(new KeyedCodec<>("level", Codec.INTEGER),
                            (data, value) -> data.level = value, //setter
                            data -> data.level) // getter
                    .addValidator(Validators.nonNull())
                    .add()
                    .build();

    public EnergyComponent() {
        this.amount = 0;
        this.level = 0;
    }

    public EnergyComponent(float amount) {
        this.amount = amount;
        this.updateLevel();
    }

    public EnergyComponent(EnergyComponent energyComponent) {
        this.amount = energyComponent.getAmount();
        this.level = energyComponent.getLevel();
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float add(float amount){
        this.amount += amount;
        this.updateLevel();
        return this.amount;
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

    private void updateAmount(){
        //Update XpAmount
    }

    private void updateLevel() {
        if(this.level <= 16) {
            this.level = MathUtil.floor(Math.sqrt(this.amount + 9) - 3);
        }
        if(this.level >= 17 && this.level <= 30) {
            this.level = MathUtil.floor(((double) 81 /10) + Math.sqrt(((double) 2 /5) * (this.amount - (double) 7839 /40)));
        }
        if(this.level >= 31) {
            this.level = MathUtil.floor(((double) 325 /18) + Math.sqrt(((double) 2 /9) * (this.amount - ((double) 54215 /72))));
        }
    }
}
