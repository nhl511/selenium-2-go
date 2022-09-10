/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.longnh.selenium.guru99;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Admin
 */
public class Guru99Test {
    
    String username = "mngr437635";
    String password = "pezavez";
    private static WebDriver myBrowser;
    private static String driverPath = "chromedriver.exe";

    
    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        
        myBrowser = new ChromeDriver(); 
            
        myBrowser.manage().window().maximize();
    }
    
    @Test
    public void testLoginGivenRightAccountSayHelloUserName() throws InterruptedException{
        myBrowser.get("https://demo.guru99.com/v4/");       
        WebElement userTag = myBrowser.findElement(By.xpath("(//input[@name='uid'])[1]"));      
        userTag.sendKeys(username);
        WebElement passwordTag = myBrowser.findElement(By.xpath("(//input[@name='password'])[1]"));      
        passwordTag.sendKeys(password);
        WebElement loginTag = myBrowser.findElement(By.xpath("(//input[@name='btnLogin'])[1]"));      
        loginTag.click();
        Thread.sleep(3000);        
        WebElement nameTag = myBrowser.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
        System.out.println(nameTag.getText());
        
        assertEquals("Manger Id : " + username, nameTag.getText());
        Thread.sleep(5000);
        
    }
    @AfterAll
    public static void tearDownClass() {
        myBrowser.quit();
    }
    
}
