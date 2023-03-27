package com.roleplay.tools;

import java.util.ResourceBundle;

public class Strings {
    static ResourceBundle bundle = ResourceBundle.getBundle("com.roleplay.tools.strings");

    public static String getString(String key) {
        return bundle.getString(key);
    }
}
