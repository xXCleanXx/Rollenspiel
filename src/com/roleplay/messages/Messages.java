package com.roleplay.messages;

import java.util.ResourceBundle;

public class Messages {

    static ResourceBundle bundle = ResourceBundle.getBundle("com.roleplay.messages.messages");

    public static String getString(String key){
        return bundle.getString(key);
    }
}
