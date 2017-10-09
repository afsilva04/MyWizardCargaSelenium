/*
 * Decompiled with CFR 0_122.
 */
package com.accenture.selenium.launcher;

import com.accenture.selenium.res.ResourcesConfig;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launcher {
    private static final Logger log = Logger.getLogger(Launcher.class);

    public static void main(String[] args) {
        
        /*
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://mywizardam.accenture.com/UploadTickets/UploadTicketDump/?projectId=e1f4562b-6b15-41ad-bb7f-93306ceb9f65&engagementId=5b110734-728f-49b3-83ca-dbc738104ba8&clientId=a3211ed6-8d54-4add-b4a5-96803a53747e&Client=&engagement=&project=&redirect=serviceDeliverysubTile");
        */
        
        ResourcesConfig.LoadProperties();
        SeleniumExecute o = new SeleniumExecute();
        o.preExe();
        o.execute();
        o.postExe();
    }
}

