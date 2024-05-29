package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHrmApp 
{
	WebDriver driver;
	String emp_id="";
	
	@Given("launch chrome browser")
	public void launch_chrome_browser() 
	{
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}
	@When("i open application with url with {string}")
	public void i_open_application_with_url_with(String url) 
	{
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Then("i should see login page")
	public void i_should_see_login_page() 
	{
	    String exp_data = "login";
	    String act_data = driver.getCurrentUrl();
	    if(act_data.contains(exp_data))
	    {
	    	Reporter.log("system shown loginpage",true);
	    }
	    else
	    {
	    	Reporter.log("system doesn't shown loginpage",true);
	    }
	}
	@When("i enter username as {string}")
	public void i_enter_username_as(String uname) 
	{
	    driver.findElement(By.id("txtUsername")).sendKeys(uname);
	}
	@When("i enter password as {string}")
	public void i_enter_password_as(String pwd) 
	{
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	}
	@When("i click login button")
	public void i_click_login_button() 
	{
	    driver.findElement(By.id("btnLogin")).click();
	}
	@Then("i should see admin dashboard")
	public void i_should_see_admin_dashboard() 
	{
		String exp_data = "Dashboard";
	    String act_data = driver.findElement(By.xpath("//div[@class='box']/div/h1")).getText();
	    if(exp_data.equals(act_data))
	    {
	    	Reporter.log("system shown dashboard",true);
	    }
	    else
	    {
	    	Reporter.log("system doesn't show dashboard",true);
	    }
	}
	@When("i click logout link")
	public void i_click_logout_link() 
	{
	    driver.findElement(By.partialLinkText("Welcome")).click();
	    driver.findElement(By.linkText("Logout")).click();
	}	
	@When("close the browser")
	public void close_the_browser() 
	{
	   driver.quit(); 
	}
	@Then("i should see err messege")
	public void i_should_see_err_messege() 
	{
		String act_data = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
		if(act_data.contains("Invalid")||act_data.contains("empty"))
		{
			Reporter.log("system generated appropriate messege",true);
		}
		else
		{
			Reporter.log("system doesn't generated appropriate messege",true);
		}
	}
	@When("i click addemployee link")
	public void i_click_addemployee_link() 
	{
	    driver.findElement(By.linkText("PIM")).click();
	    driver.findElement(By.linkText("Add Employee")).click();
	}
	@When("i enter first name as {string}")
	public void i_enter_first_name_as(String fname) 
	{
	    driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(fname);
	}
	@When("i enter last name as {string}")
	public void i_enter_last_name_as(String lname) 
	{
	    driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lname);
	}
	@When("i click save emp button")
	public void i_click_save_emp_button() 
	{
		emp_id = driver.findElement(By.xpath("//input[@id='employeeId']")).getAttribute("value");
	    driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	}
	@Then("i should see employee in emptable")
	public void i_should_see_employee_in_emptable() 
	{
	    driver.findElement(By.linkText("Employee List")).click();
	    driver.findElement(By.id("empsearch_id")).sendKeys(emp_id);
	    driver.findElement(By.id("searchBtn")).click();
	    String res= driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a")).getText();
	    if(emp_id.equals(res))
	    {
	    	Reporter.log("Employee Added Successfully",true);
	    }
	    else
	    {
	    	Reporter.log("Employee Adding is Unsuccessful",true);
	    }
	}
}
