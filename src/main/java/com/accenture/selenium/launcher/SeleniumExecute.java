/*
 * Decompiled with CFR 0_122.
 */
package com.accenture.selenium.launcher;

import com.accenture.selenium.util.Constantes;
import java.util.List;
import java.util.function.Function;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumExecute {
    private static final Logger log = Logger.getLogger(SeleniumExecute.class);
    private static String xpath_boton_confirmacion = "/html/body/div[4]/div/div/div/div[2]/button[1]";
    private WebDriver driver;

    public void preExe() {
        log.info("Comienzo del proceso Selenium - Carga MyWizard");
        log.info("Driver utilizado: " + Constantes.DRIVER_CODE);
        System.setProperty(Constantes.DRIVER_CODE, Constantes.PATH_DRIVER);
        this.driver = new InternetExplorerDriver();
        //this.driver = new ChromeDriver();
        log.info("Driver creado correctamente");
        log.info("Abriendo pagina inicial del reporte");
        log.info("Pagina inicial configurada hacia: " + Constantes.URL_UPLOAD_FILE);
        this.driver.get(Constantes.URL_UPLOAD_FILE);
        log.info("Cargando pagina inicial del reporte");
        
        if(this.driver.findElement(By.id("signOnTitle")).getText().equals("Enterprise Sign On"))
        {
            this.driver.findElement(By.id("userNameInput")).sendKeys(Constantes.USER);
            this.driver.findElement(By.id("passwordInput")).sendKeys(Constantes.PASSWORD);
            this.driver.findElement(By.id("submitButton")).click();
        }
        
    }

    public void execute() {
        WebDriverWait waitCortinaInicial = new WebDriverWait(this.driver, 20);
        waitCortinaInicial.until(ExpectedConditions.elementToBeClickable(By.id("xlspicker")));
        log.info("Ingresare la ruta del archivo a cargar");
        log.info("Ruta del archivo a cargar: " + Constantes.RUTA_ARCHIVO_SUBIR);
        this.driver.findElement(By.id("xlspicker")).sendKeys(Constantes.RUTA_ARCHIVO_SUBIR);
        log.info("Archivo correctamente cargado");
        log.info("Procedo a subir el reporte");
        this.driver.findElement(By.id("xlssubmit")).click();
        log.info("Presiono en 'Upload Tickets'");
        WebDriverWait waitPopUPConfirmacion = new WebDriverWait(this.driver, 20);
        waitPopUPConfirmacion.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_boton_confirmacion)));
        this.driver.findElement(By.xpath(xpath_boton_confirmacion)).click();
        log.info("Confirmo el mensaje popup");
        log.info("Flujo finalizado");
        
        String msg = this.driver.findElement(By.xpath("/html/body/div[1]/span")).getText();
        if (msg != null && !msg.equals("")) {
            log.info(msg);
        } else {
            log.info("No se encontro el texto del menaje!!");
        }
        
        String detail = this.driver.findElement(By.xpath("//*[@id=\"failedRecordsMessageContainer\"]/font[2]")).getText();
        String[] detailList = detail.split("#");
        for(String d : detailList){
            log.info(d);
        }
        
        String result = this.driver.findElement(By.xpath("//*[@id=\"failedRecordsMessageContainer\"]/font[1]")).getText();
        log.info(result);
        
    }

    public void postExe() {
        try {
            log.info("Me pongo a dormir 15 segundos antes de cerrar");
            Thread.sleep(15000);
        }
        catch (InterruptedException e) {
            log.error("Error al poner el proceso a dormir");
        }
        this.driver.close();
        log.info("Proceso finalizado");
    }
}

