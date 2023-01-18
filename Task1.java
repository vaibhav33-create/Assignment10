package assignment10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","E:\\Java program\\QATester\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys("ineuron@ineuron.ai");
		driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("ineuron");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Manage']")).click();
		driver.findElement(By.xpath("//span[text()='Manage Courses']")).click();
		driver.findElement(By.xpath("//button[text()='Add New Course ']")).click();
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Vaibhav\\Desktop\\Git-push.png");
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Selenium-java");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("full time course");
		driver.findElement(By.xpath("//input[@name='instructorName']")).sendKeys("mukesh");
		WebElement e = driver.findElement(By.xpath("//input[@name='price']"));
		
		e.clear();
		e.sendKeys("5000");
		driver.findElement(By.xpath("//div[text()='Select Category']")).click();
		driver.findElement(By.xpath("//div[@class='menu-items']//button[3]")).click();
		
		
		driver.findElement(By.xpath("//input[@name='endDate']")).click();
		while(true) {
		WebElement date = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"));
		String actdate = date.getText();
		
		String[] ss = actdate.split(" ");
		String month = ss[0];
		String year = ss[1];
		
		if(month.contains("June") && year.contains("2023")) {
			driver.findElement(By.xpath("//div[text()='25']")).click();	
			break;
		}else {
			driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		}
		}
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		List<WebElement> data = driver.findElements(By.xpath("//th[text()='Course Name']//..//..//..//tbody//tr//td"));
		
		for(WebElement ss :data) {
			String exp = ss.getText();
			if(exp.contains("Selenium-java")) {
				System.out.println("Course Added");
				break;
			}
		}
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		
		for(WebElement ww :data) {
			if(!ww.getText().contains("Selenium-java")) {
				System.out.println("Course Deleted");
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Sign out']")).click();
		
	}

}
