package grammarlyExtTest;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.testng.annotations.Test;

public class grammarly {

	@Test(priority = 1)
	public void testCase1CheckingGrammarlyInstalled() throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver", "chromedriverarm");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("load-extension=grammarlyzipfile");
		options.addArguments("--incognito");

		ChromeDriver driver = new ChromeDriver(options);

		// navigating to extension page settings
		driver.get("chrome://extensions/?id=neoafllhelabcnhjmalikiodmeepajhk");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// This method is also working to enable the incognito mode in extension
		// settings
//	        JavascriptExecutor js = (JavascriptExecutor) driver; 
//	        js.executeScript
//	        ("document.querySelector('extensions-manager').shadowRoot.querySelector('#viewManager > extensions-detail-view.active').shadowRoot.querySelector('div#container.page-container > div.page-content > div#options-section extensions-toggle-row#allow-incognito').shadowRoot.querySelector('label#label input').click()");

		// This also works to enable the incognito mode in extension settings
		// this method uses the action class with keyboard actions
		Actions action = new Actions(driver);
		for (int i = 0; i < 4; i++) {
			action.sendKeys(Keys.TAB).perform();
		}
		action.sendKeys(Keys.ENTER).perform();

		// Actual test Case start here
		// TC-1 checking if grammarly is enabled in a online editor

		driver.get("https://www.onlinetexteditor.com/");
		String extensionWindow = driver.getWindowHandle();
		WebElement textArea = driver.findElement(By.tagName("textarea"));
		// clearing teh text area for typing
		textArea.clear();

		textArea.sendKeys(" Seplling ");
		action.click(textArea);

		// waiting for new pop up window to appear with grammarly, since we uploaded the
		// extension

		driver.switchTo().window(extensionWindow);

		List<WebElement> grammarlyCheck = driver.findElements(By.tagName("grammarly-extension"));

		for (WebElement tempWebElement : grammarlyCheck) {
			assertEquals(tempWebElement.getAttribute("data-grammarly-shadow-root"), "true");
			System.out.println("Assertion passed : Grammarly Extension is enabled ");

		}
		
		//if pop up opens from grammarly extension, the below code will close the pop up window
		Set<String> handles = driver.getWindowHandles();
		for (String temphandles: handles)
		{
			if(!temphandles.equals(extensionWindow))
			{
			    driver.switchTo().window(temphandles);

			    driver.close();
			}
		}

		driver.switchTo().window(extensionWindow);
		
		// clearing after assertion
		textArea.clear();
		System.out.println("TC-1 Pass");
		
		driver.close();
		driver.quit();
	}

	@Test(priority = 2)
	public void testCase2CheckingPositiveResponse()

	{
		System.setProperty("webdriver.chrome.driver", "chromedriverarm");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("load-extension=grammarlyzipfile");
		options.addArguments("--incognito");

		ChromeDriver driver = new ChromeDriver(options);

		// navigating to extension page settings
		driver.get("chrome://extensions/?id=neoafllhelabcnhjmalikiodmeepajhk");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		

		// This method is also working to enable the incognito mode in extension
		// settings
//			        JavascriptExecutor js = (JavascriptExecutor) driver; 
//			        js.executeScript
//			        ("document.querySelector('extensions-manager').shadowRoot.querySelector('#viewManager > extensions-detail-view.active').shadowRoot.querySelector('div#container.page-container > div.page-content > div#options-section extensions-toggle-row#allow-incognito').shadowRoot.querySelector('label#label input').click()");

		
		
		// This also works to enable the incognito mode in extension settings
		// this method uses the action class with keyboard actions
		Actions action = new Actions(driver);
		for (int i = 0; i < 4; i++) {
			action.sendKeys(Keys.TAB).perform();
		}
		action.sendKeys(Keys.ENTER).perform();
		
		
		//getting driver handle
		String grammarlyWindow = driver.getWindowHandle();

		// Unable to use any other word editor or text editor Online as grammarly doesnt
		// read the text in teh editor field and waits indefinitely
		// hence using grammarly editor itself to check if it works as expected
		// grammarly login in website
		driver.get("https://www.grammarly.com/signin");

		WebElement emailGrammarlyInp = driver.findElement(By.cssSelector("input[data-qa='txtEmail']"));

		driver.switchTo().window(grammarlyWindow);

		emailGrammarlyInp.sendKeys("meganathtest2@gmail.com");

		driver.findElement(By.cssSelector("button[data-qa='btnLogin']")).click();
		WebElement pwdGrammarlyInp = driver.findElement(By.cssSelector("input[data-qa='txtPassword']"));
		pwdGrammarlyInp.sendKeys("Test@1234");
		driver.findElement(By.cssSelector("button[data-qa='btnLogin']")).click();

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 45);

		// UI page refreshed twice , hence catching no-element-found-exception and
		// trying again
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-name='new-doc-add-btn']")))
					.click();
		} catch (Exception ex) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-name='new-doc-add-btn']")))
					.click();
		}

		WebElement grammarlyTextArea = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"page\"]/div/div[2]/div[2]/div/div[4]/div[3]/div/main/div/div/div[10]/div[1]/p")));

		grammarlyTextArea.sendKeys(" Seplling ");

		List<WebElement> Checkingword;

		List<WebElement> mistypeWordscards = driver.findElements(By.cssSelector("div[data-role='animation-wrapper']"));

		mistypeWordscards.get(0).click();
		Checkingword = driver.findElements(By.cssSelector("div[data-name='card/apply-insert']"));

		assertEquals(Checkingword.get(0).getText(), "Spelling");
		System.out.println("TC-2 Pass");
		
		driver.close();

		driver.quit();
		
		
	}

	@Test(priority = 3)
	public void testCase3CheckingNegativeResponse()

	{

		System.setProperty("webdriver.chrome.driver", "chromedriverarm");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("load-extension=grammarlyzipfile");
		options.addArguments("--incognito");

		ChromeDriver driver = new ChromeDriver(options);

		// navigating to extension page settings
		driver.get("chrome://extensions/?id=neoafllhelabcnhjmalikiodmeepajhk");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// This method is also working to enable the incognito mode in extension
		// settings
//				        JavascriptExecutor js = (JavascriptExecutor) driver; 
//				        js.executeScript
//				        ("document.querySelector('extensions-manager').shadowRoot.querySelector('#viewManager > extensions-detail-view.active').shadowRoot.querySelector('div#container.page-container > div.page-content > div#options-section extensions-toggle-row#allow-incognito').shadowRoot.querySelector('label#label input').click()");

		// This also works to enable the incognito mode in extension settings
		// this method uses the action class with keyboard actions
		Actions action = new Actions(driver);
		for (int i = 0; i < 4; i++) {
			action.sendKeys(Keys.TAB).perform();
		}
		action.sendKeys(Keys.ENTER).perform();

		String grammarlyWindow = driver.getWindowHandle();

		// Unable to use any other word editor or text editor Online as grammarly doesnt
		// read the text in teh editor field and waits indefinitely
		// hence using grammarly editor itself to check if it works as expected
		// grammarly login in website
		driver.get("https://www.grammarly.com/signin");

		WebElement emailGrammarlyInp = driver.findElement(By.cssSelector("input[data-qa='txtEmail']"));
		Set<String> handles = driver.getWindowHandles();

		for (String temphandles : handles) {
			if (!temphandles.equals(grammarlyWindow)) {
				driver.switchTo().window(grammarlyWindow);
			}
		}

		emailGrammarlyInp.sendKeys("meganathtest2@gmail.com");
		driver.findElement(By.cssSelector("button[data-qa='btnLogin']")).click();
		WebElement pwdGrammarlyInp = driver.findElement(By.cssSelector("input[data-qa='txtPassword']"));
		pwdGrammarlyInp.sendKeys("Test@1234");
		driver.findElement(By.cssSelector("button[data-qa='btnLogin']")).click();

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// UI page refreshed twice , hence catching no-element-found-exception and
		// trying again
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-name='new-doc-add-btn']")))
					.click();
		} catch (Exception ex) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-name='new-doc-add-btn']")))
					.click();
		}

		WebElement grammarlyTextArea = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"page\"]/div/div[2]/div[2]/div/div[4]/div[3]/div/main/div/div/div[10]/div[1]/p")));

		// Actual test Case start here
		// TC-3

		grammarlyTextArea.clear();

		grammarlyTextArea.sendKeys("ortgrafía");

		assertEquals(driver.findElements(By.cssSelector("div[data-role='animation-wrapper']")).isEmpty(), true);
		System.out.println("No recommendations found");
		
		List<WebElement> elementtext= driver.findElements(By.cssSelector("div[data-name='success-lens-text']"));
		
		wait.until(ExpectedConditions.textToBePresentInElement(elementtext.get(1),"No issues found"));
		assertEquals(elementtext.get(1).isDisplayed(), true);

		System.out.println("TC-3 Pass");
		driver.close();
		driver.quit();
	}

}
