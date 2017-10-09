/*
 * Decompiled with CFR 0_122.
 */
package com.accenture.selenium.util;

import com.accenture.selenium.res.ResourcesConfig;
import java.util.Properties;

public class Constantes {
    public static final String URL_INICIAL = "https://mywizard.accenture.com/";
    public static final String URL_MANAGE = "https://mywizard.accenture.com/MyWizard/Manage";
    public static final String URL_COMMAND_CENTER = "https://mywizardam.accenture.com/External/HPDP?DMProjectId=18214";
    public static String URL_UPLOAD_FILE;
    public static String PATH_DRIVER;
    public static String DRIVER_CODE;
    public static String RUTA_ARCHIVO_PROCESAR;
    public static String RUTA_ARCHIVO_SUBIR;
    public static String USER;
    public static String PASSWORD;

    static {
        PATH_DRIVER = ResourcesConfig.prop.getProperty("ruta_driver");
        DRIVER_CODE = ResourcesConfig.prop.getProperty("DRIVER_CODE");
        RUTA_ARCHIVO_PROCESAR = ResourcesConfig.prop.getProperty("RUTA_ARCHIVO_PROCESAR");
        RUTA_ARCHIVO_SUBIR = ResourcesConfig.prop.getProperty("RUTA_ARCHIVO_SUBIR");
        URL_UPLOAD_FILE = ResourcesConfig.prop.getProperty("URL_UPLOAD_FILE");
        USER = ResourcesConfig.prop.getProperty("USER");
        PASSWORD = ResourcesConfig.prop.getProperty("PASSWORD");
    }
}

