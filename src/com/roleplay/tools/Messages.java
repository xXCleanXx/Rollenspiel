package com.roleplay.tools;

import java.util.ResourceBundle;

public class Messages {
    static ResourceBundle bundle = ResourceBundle.getBundle("com.roleplay.tools.messages_de");

    public static String getString(String key) {
        return bundle.getString(key);
    }
}