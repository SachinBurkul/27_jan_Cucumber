package applicationHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.utilities.BaseUtility;
import org.utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	public static Properties prop;
	public static WebDriver driver;
	
	@Before(order=1)
	public void getProperties() {
		System.out.println("TESt");
		ConfigReader cr = new ConfigReader();
		prop = cr.initProp();
		String bName = prop.getProperty("browserName");
		BaseUtility bu = new BaseUtility();
		driver = bu.startUp(bName);
	}
	@After(order=2)
	public void takeScreenshot(Scenario screnario) {
		if(screnario.isFailed()) {
			String name = screnario.getName().replaceAll(" ","");
			byte[] ar = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			screnario.attach(ar, "image/png", name);
		}
	}
	@After(order=1)
	public void tearDown() {
		driver.quit();
	}
}