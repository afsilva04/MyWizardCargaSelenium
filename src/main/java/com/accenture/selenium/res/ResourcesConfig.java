/*
 * Decompiled with CFR 0_122.
 */
package com.accenture.selenium.res;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;

public final class ResourcesConfig {
    private static final String LOG4J_FILE_NAME = "./CargaMyWizardJar_LOG.properties";
    private static final String RESOURCE_FILE_NAME = "./CargaMyWizardJar.properties";
    public static Properties prop = new Properties();
    private static InputStream input = null;

    private ResourcesConfig() {
    }

    public static void LoadProperties() {
        try {
            PropertyConfigurator.configure("./CargaMyWizardJar_LOG.properties");
            input = new FileInputStream("./CargaMyWizardJar.properties");
            if (input != null) {
                org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ResourcesConfig.class);
                logger.info("--------------------------------------------------------");
                logger.debug("Log4j configurado: ./CargaMyWizardJar_LOG.properties");
                System.out.println("ResourcesProperties > Archivo properties correctamente cargado");
                prop.load(input);
            } else {
                System.err.println("ResourcesProperties > Ha ocurrido un error al cargar el archivo de properties");
            }
        }
        catch (IOException ex) {
            System.err.println("ResourcesProperties > Error al cargar las properties: ERROR: " + ex.getMessage());
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                }
                catch (IOException ex) {
                    Logger.getLogger(ResourcesConfig.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}