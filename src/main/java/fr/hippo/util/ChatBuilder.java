package fr.hippo.util;

import fr.hippo.ChatCanal;

public class ChatBuilder {

    public static ChatCanal defaultBuildChat(){
        return new ChatCanal("default", "Default Chat", "Chat Used by default", "", 20, false, false, "*");
    }

}
