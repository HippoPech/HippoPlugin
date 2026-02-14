package fr.hippo;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.EnumCodec;
import com.hypixel.hytale.codec.codecs.map.MapCodec;
import com.hypixel.hytale.codec.lookup.CodecMapCodec;
import com.hypixel.hytale.codec.lookup.ObjectCodecMapCodec;

import java.util.HashMap;

public class ChatConfig {
    public static final BuilderCodec<ChatConfig> CODEC = BuilderCodec.builder(ChatConfig.class, ChatConfig::new)
            .append(new KeyedCodec<ChatCanal>("Chat", new MapCodec<>(Codec.FLOAT), HashMap<String, Float>::new));

}
