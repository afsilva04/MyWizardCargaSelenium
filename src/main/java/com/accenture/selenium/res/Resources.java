/*
 * Decompiled with CFR 0_122.
 */
package com.accenture.selenium.res;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

public final class Resources {
    private static Resources instance = null;
    private static Properties props = new Properties();

    private Resources() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void init(URL p_resourceFile) throws IOException {
        Properties properties = props;
        synchronized (properties) {
            if (instance == null) {
                instance = new Resources();
            }
            Properties others = new Properties();
            others.load(p_resourceFile.openStream());
            props.putAll(others);
        }
    }

    public static String getResource(String p_resourcekey) {
        if (instance == null) {
            System.err.println("Las properties no pudieron ser inicializadas");
        }
        return props.getProperty(p_resourcekey);
    }
}

