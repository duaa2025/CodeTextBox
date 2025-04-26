import java.awt.RenderingHints.Key;
import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v133.fedcm.model.AccountUrlType;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyClass {
	
	WebDriver driver= new ChromeDriver();
	String WebSite="https://codenboxautomationlab.com/practice/";
	Random rand= new Random();
	
	
	@BeforeTest
	public void MySetup() {
		driver.get(WebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}
	
	
	@Test(priority=1, enabled=false)
	public void RadioButton() {
		WebElement DivOptions= driver.findElement(By.id("radio-btn-example"));
		List <WebElement> AllOptions=DivOptions.findElements(By.tagName("input"));
		Random Rand= new Random();
		int index=Rand.nextInt(AllOptions.size());
		AllOptions.get(index).click();
	}
	
	@Test (priority=2, enabled= false)
	public void DynamicDropDownList() throws InterruptedException {
		
		WebElement AutoComplete=driver.findElement(By.id("autocomplete"));
		String [] contries={"Jo", "Sy", "Ir", "Ye"};
		int RandIndex= rand.nextInt(contries.length);
		AutoComplete.sendKeys(contries[RandIndex]);
		Thread.sleep(1000);
		//AutoComplete.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
		AutoComplete.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		
	}
	
	@Test (priority=3, enabled= false)
	public void StaticDropDownList() {
	
		WebElement StaticList= driver.findElement(By.id("dropdown-class-example"));
		
	Select MySelect= new Select(StaticList);
	
	MySelect.selectByVisibleText("API");
	//to print all options in one time use: 
			System.out.println(StaticList.getText());
	for(int i=0; i<(StaticList.findElements(By.tagName("option")).size()); i++) {
		
		//to print all options separately use the below:
		List <WebElement> Options=driver.findElements(By.tagName("option"));
		System.out.println(Options.get(i).getText());		}
	
	//MySelect.selectByIndex(2);
	//FindElement retrieve data type list 
	// To calculate # of options in the static list:the below sentence
	System.out.println(StaticList.findElements(By.tagName("option")).size());
	}
	

	@Test (priority=4, enabled= false)
	public void CheckBoxes() {
		WebElement DivCheckBox= driver.findElement(By.id("checkbox-example"));
		List<WebElement> AllCheckBoxes=DivCheckBox.findElements(By.tagName("input"));
		//To click all options use the for loop:
//		for(int i=0; i<AllCheckBoxes.size();i++) {
//			AllCheckBoxes.get(i).click();
//		}
		//To select options randomly:
		Random Rand= new Random();
		int RandIndex=Rand.nextInt(AllCheckBoxes.size());
		int RandIndex1=Rand.nextInt(AllCheckBoxes.size());

		AllCheckBoxes.get(RandIndex).click();
		AllCheckBoxes.get(RandIndex1).click();
	}
	
	@Test(priority=5, enabled=false)
	public void NewWindow() throws InterruptedException{
		WebElement SwitchWindowButton=driver.findElement(By.id("openwindow"));
		// we can use this: SwitchWindowButton.sendKeys(Keys.ENTER);
		SwitchWindowButton.click();
		//The below (set) is a list have all the opened windows:
		Set <String> WindowHandles=driver.getWindowHandles();
		//To convert from Set to list:
		List <String> Handles= new  ArrayList <>(WindowHandles);
		
		driver.switchTo().window(Handles.get(1));
		//.manage().window().maximize();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"menu-item-9660\"]/a/span[1]/span")).click();
		driver.findElement(By.id("slider-9-slide-18-layer-1")).click();
		driver.switchTo().window(Handles.get(0));
	}	
	@Test(priority=6, enabled=false)
	public void NewTab() throws InterruptedException {
		WebElement OpenTabButton= driver.findElement(By.id("opentab"));
		OpenTabButton.click();
		Set <String> Tab=driver.getWindowHandles();
		List <String> Tabs=new ArrayList<>(Tab);
		
		driver.switchTo().window(Tabs.get(1));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.switchTo().window(Tabs.get(0));
		
	}
	
	@Test(priority=7, enabled=false)
	public void Alert() {
		WebElement TextBox= driver.findElement(By.id("name"));
		TextBox.sendKeys("Dua'a");
		//WebElement AlertButton= driver.findElement(By.id("alertbtn"));
		//AlertButton.click();
		//driver.switchTo().alert().accept();
		WebElement ConfirmButton= driver.findElement(By.id("confirmbtn"));
		ConfirmButton.click();
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
	}
	
	@Test(priority=8, enabled=true)
	public void Tbale() {
		WebElement TheTable= driver.findElement(By.id("product"));
		List<WebElement> TableRows=TheTable.findElements(By.tagName("tr"));
		List<WebElement>TableData=TheTable.findElements(By.tagName("td"));
		//to print all table rows
		/*
		 * for(int i=0; i<TableRows.size();i++) {
		 * System.out.println(TableRows.get(i).getText()); }
		 */
		//`to print randomly row data
		/*
		 * Random rand= new Random(); int index=rand.nextInt(TableRows.size());
		 * System.out.println(TableRows.get(index).getText());
		 */
		//To print the Instructor column data
		
		for(int i=0; i<TableData.size();i=i+3) {
			System.out.println(TableData.get(i).getText());	 }
		//To print the Course column data
		for(int i=1; i<TableData.size();i=i+3) {
			System.out.println(TableData.get(i).getText());	 }
		//To print the price column data
		for(int i=2; i<TableData.size();i=i+3) {
			System.out.println(TableData.get(i).getText());	 }
		
		
		// System.out.println(TableData.get(1).getText());

		
	}
	
	
	
	@AfterTest 
	public void End() {}
}
