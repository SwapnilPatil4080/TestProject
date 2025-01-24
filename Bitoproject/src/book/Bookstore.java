package book;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bookstore {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		String expectedTitle = "DEMOQA";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DAMINI\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//To write test results in file
		FileWriter file = new FileWriter("C:\\Users\\DAMINI\\eclipse-workspace\\BitoTask\\Bitoproject\\testResult\\result.txt",true);
		
		WebDriver driver = new ChromeDriver();
		
		//To launch the web site
		driver.get("https://demoqa.com/books");
		//To maximize the browser window
		driver.manage().window().maximize();
		Thread.sleep(5000);		
		String actualTitle = driver.getTitle();
		//Test to verify the title and if the page is loaded successfully
		if(expectedTitle.contentEquals(actualTitle))
		{
			System.out.println("DEMOQA page loaded succesfully");
			file.write("DEMOQA page loaded succesfully\n");
		}
		else
		{
			System.out.println("DEMOQA page load failed");
			file.write("DEMOQA page load failed\n");
		}
		
		//All web element locators
		WebElement searchBox = driver.findElement(By.id("searchBox"));
		WebElement imageTableHeader = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[1]/div[1]"));
		WebElement titleTableHeader = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[1]"));
		WebElement authorTableHeader = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[3]/div[1]"));
		WebElement publisherTableHeader = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[4]/div[1]"));
		WebElement bookTitle = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span/a"));
		WebElement Elements = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/span/div"));
		
		
		//Test to verify the search input box is visible
		boolean flag = searchBox.isDisplayed();
		System.out.println("Search Input box is displayed: "+flag);
		file.write("Search Input box is displayed: "+flag+"\n");
		
		//Test to verify the Image table header is visible
		boolean flag1 = imageTableHeader.isDisplayed();
		System.out.println("Image table header is displayed: "+flag1);
		file.write("Image table header is displayed: "+flag1+"\n");
		
		//Test to verify the Title table header is visible
		boolean flag2 = titleTableHeader.isDisplayed();
		System.out.println("Title table header is displayed: "+flag2);
		file.write("Title table header is displayed: "+flag2+"\n");
		
		//Test to verify the Author table header is visible
		boolean flag3 = authorTableHeader.isDisplayed();
		System.out.println("Author table header is displayed: "+flag3);
		file.write("Author table header is displayed: "+flag3+"\n");
		
		//Test to verify the Publisher table header is visible
		boolean flag4 = publisherTableHeader.isDisplayed();
		System.out.println("Publisher table header is displayed: "+flag4);
		file.write("Publisher table header is displayed: "+flag4+"\n");
		
		//Test to verify the Book Title is visible
		boolean flag5 = bookTitle.isDisplayed();
		System.out.println("Book Title is displayed: "+flag5);
		file.write("Book Title is displayed: "+flag5+"\n");
		
		//Test to verify the Textbox section from left panel dropdown is visible
		Elements.click();
		Thread.sleep(2000);
		WebElement textboxElement = driver.findElement(By.xpath("//*[@id=\"item-0\"]"));
		boolean flag6 = textboxElement.isDisplayed();
		System.out.println("Textbox element is displayed: "+flag6);
		file.write("Textbox element is displayed: "+flag6+"\n");
		
		//Test to verify the search input is working
		searchBox.sendKeys("Git");
		Thread.sleep(5000);
		WebElement bookTitle1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div"));
		if(bookTitle1.getText().contains("Git"))
		{
			System.out.println("Book search with title is successful");
			file.write("Book search with title is successful\n");
		}
		else
		{
			System.out.println("Book search with title failed");
			file.write("Book search with title failed\n");
		}
		
		//Test to reset search box
		searchBox.sendKeys("");
		Thread.sleep(5000);
		System.out.println("Search reset");
		
		file.close();
		driver.close();

	}

}
