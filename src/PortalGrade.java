import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PortalGrade {

    public static void main(String[] args)throws InterruptedException,IOException{

        System.setProperty("webdriver.gecko.driver","c:\\Gecko\\geckodriver.exe");
        WebDriver driver;
        driver = new FirefoxDriver();

        String appUrl = "http://portal.aait.edu.et";

        driver.get(appUrl);

        WebElement atr = driver.findElement(By.xpath("//*[@id=\"UserName\"]"));

        WebElement password = driver.findElement(By.xpath("//*[@id=\"Password\"]"));

        atr.sendKeys("ATR/7016/09");
        password.sendKeys("****");

        driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button")).click();

        driver.get("https://portal.aait.edu.et/Grade/GradeReport");

        WebElement bigTable = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/table"));

        File file = new File("Grades.txt");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(bigTable.getText());

        fileWriter.flush();
        fileWriter.close();
        Thread.sleep(7000);
        driver.quit();

    }
}
