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
}
