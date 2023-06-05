package google;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigateToGoogleServicesTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
        FileInputStream excel = new FileInputStream("./TestData/GoogleTestCase.xlsx");
        Workbook workbook=WorkbookFactory.create(excel);
        Sheet sheet=workbook.getSheet("Sheet1");
        Row row=sheet.getRow(5);
        Cell cell=row.getCell(2);
        String gmail_url=cell.getStringCellValue();
        System.out.println(gmail_url);
        String search_value=sheet.getRow(6).getCell(2).getStringCellValue();
        System.out.println(search_value);
        driver.get(gmail_url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[@class=\"gb_d\"]")).click();
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//span[@data-text=\"YouTube\"]")).click();

       String title=driver.getTitle();
       if(title.contains("YouTube"))
       {
       	System.out.println("verified");
      }
      else {
      	System.out.println("failed");
        }

	}

}
