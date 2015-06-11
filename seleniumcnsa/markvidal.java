package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class MarkVidal {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
          // driver = new FirefoxDriver();
	  driver = new HtmlUnitDriver();
	  
	  
	  driver.manage().window().setPosition(new Point(0,0));
	  driver.manage().window().setSize(new Dimension(1280,720));
	  
	  // turn off htmlunit warnings
	            java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
	  java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
	        baseUrl = "https://www.google.es/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMarkVidal() throws Exception {
    driver.get(baseUrl + "/#q=universidad+de+almeria");
    driver.findElement(By.id("lst-ib")).clear();
    driver.findElement(By.id("lst-ib")).sendKeys("universidad de almeria");
    driver.findElement(By.name("btnG")).click();
    driver.findElement(By.linkText("Universidad de Almería")).click();
    driver.findElement(By.linkText("Órganos de Gobierno")).click();
    driver.findElement(By.linkText("Gabinete de Comunicación")).click();
    assertEquals("Marc Vidal habla en la UAL la revolución que “cambiará el mundo”", driver.findElement(By.linkText("Marc Vidal habla en la UAL la revolución que “cambiará el mundo”")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
