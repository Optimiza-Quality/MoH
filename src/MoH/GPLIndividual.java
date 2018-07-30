package MoH;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GPLIndividual extends GPLFields{
	
	WebDriver driver;

	Integer Const = 400;
	public static String AppNo;

	@BeforeMethod(enabled = true)
	public void GetDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\emasoud\\Desktop\\geckodriver.exe");
		// driver = new FirefoxDriver();
		driver.get("https://172.16.0.254:4443/public/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@BeforeMethod(enabled = false)
	@Parameters("browsers")
	public void CrossBrowser(String browsername) throws Exception {

		// Check if parameter passed from TestNG is 'Chrome'
		if (browsername.equalsIgnoreCase("Chrome")) {
			// create Chrome instance
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://172.16.0.254:4443/public/index.html");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			// } else
			//
			// // Check if parameter passed from TestNG is 'IE'
			// if (browsername.equalsIgnoreCase("ie")) {
			// // create IE instance
			//
			// System.setProperty("webdriver.ie.driver",
			// "C:\\Users\\emasoud\\Desktop\\IEDriverServer.exe");
			// driver = new InternetExplorerDriver();
			// driver.manage().window().maximize();
			// driver.get("https://ohs-vip:4443/public/index.html");
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			// driver.findElement(By.id("overridelink")).click();
			//
			// Thread.sleep(2000);
			// } else
			//
			// // Check if parameter passed from TestNG is 'firefox'
			// if (browsername.equalsIgnoreCase("firefox")) {
			// // create firefox instance
			//
			// System.setProperty("webdriver.gecko.driver",
			// "C:\\Users\\emasoud\\Desktop\\geckodriver.exe");
			// driver = new FirefoxDriver();
			// driver.manage().window().maximize();
			// driver.get("https://ohs-vip:4443/public/index.html");
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		}
	}

	@AfterMethod(enabled = true)
	public void End(ITestResult result) throws InterruptedException {
		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// Create reference of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot) driver;

				// Call method to capture screenshot
				File source = ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all
				// screenshot in our project home directory and
				// result.getName() will return name of test case so that
				// screenshot name will be same
				FileUtils.copyFile(source, new File("./GPL-Individual-Screenshots/" + result.getName() + ".png"));

				System.out.println("Failed. Screenshot taken " + result.getName());
			} catch (Exception e) {

				System.out.println("Failed. Exception while taking screenshot" + e.getMessage());
			}
		}

		driver.quit();

	}

	public void EditContactDetails() throws InterruptedException {

		driver.findElement(LoginVerificationCode).sendKeys("0000"); // Verification-Code

		Thread.sleep(Const * 5);

		driver.findElement(NextToMyPage).click(); // Next

		Thread.sleep(Const * 3);

		driver.findElement(MyMobileNumber).clear();

		Thread.sleep(Const * 3);

		driver.findElement(MyMobileNumber).sendKeys("987654321"); // Edit-Mobile-Number

		Thread.sleep(Const * 3);

		driver.findElement(MyEmail).clear(); // Clear-Email

		Thread.sleep(Const * 3);

		driver.findElement(MyEmail).sendKeys("SECOND.EMAIL@GMAIL.com"); // Edit-Email

		Thread.sleep(Const * 3);

		driver.findElement(MyAddress).clear(); // Clear-Address

		Thread.sleep(Const * 3);

		driver.findElement(MyAddress).sendKeys("ADDRESS 2, STREET 2, BUILDING 2"); // Edit-AdDress

		Thread.sleep(Const * 5);

		driver.findElement(SaveEditedInfo).click(); // Save

		Thread.sleep(Const * 4);

		driver.findElement(GoToHomePage).click(); // Home-Page-Icon

	}
	
	@Test(priority = 1)
	public void SubmitIndividualApp_Case4000() throws InterruptedException, IOException{
		
		// ﬁœ»„ «·ÿ·» »‰Ã«Õ - »Ì«‰«  ’ÕÌÕ…
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9822056900");
		
		driver.findElement(PharmIDNumber).sendKeys("19820222");
		
		driver.findElement(CoNationalNumber).sendKeys("100045693");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(MobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("91751103828112");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
		
		driver.findElement(SocialSecurityNo).sendKeys("9822056900");
		
		driver.findElement(PharmAddress).sendKeys("address 1");
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		
		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToAttachemnts).click();
		
		//---------------------------Attachments---------------------------------------
		
		driver.findElement(Sketch).click();
		
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);
		
		driver.findElement(Lease).click();
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 20);
		
		driver.findElement(NextToReview).click();
		
		Thread.sleep(Const * 10);
		
		driver.findElement(NextToRating).click();
		//---------------------------Review---------------------------------------
		
		Thread.sleep(Const * 5);
		driver.findElement(RateHappyAttachmentCases).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(NotesAttachmentCases).sendKeys("Happy");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(SubmitAttachmentCases).click();
		
		//----------------------Success-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.0.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Individual Pharmacist Case 4.0.0.0 " + ActualResult);

		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
		
	}

	@Test(priority = 3)
	public void SubmitIndividualApp_Case4200() throws InterruptedException, IOException{
		
		//ﬁ«„ »«‰‘«¡ Õ”«» Ê·„ Ì „ ⁄„·Ì…  ﬁœÌ„ «·ÿ·»
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9851032994");
		
		driver.findElement(PharmIDNumber).sendKeys("19850115");
		
		driver.findElement(CoNationalNumber).sendKeys("100000822");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 10);
		
		// --------------------------------Edit-Contact-Details---------------------------------
		
		driver.findElement(ModifyContactDetails).click();
		
		this.EditContactDetails();
		//-----------------------Go-Back-To-Application-Form----------------------------------
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userTypeAgain = new Select(driver.findElement(AppType));
		userTypeAgain.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9851032994");
		
		driver.findElement(PharmIDNumber).sendKeys("19850115");
		
		driver.findElement(CoNationalNumber).sendKeys("100000822");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 10);
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("51282027248131");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
		
		driver.findElement(SocialSecurityNo).sendKeys("9822056900");
		
		driver.findElement(PharmAddress).sendKeys("address 1");
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		
		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToAttachemnts).click();
		
		//---------------------------Attachments---------------------------------------
		
		driver.findElement(Sketch).click();
		
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);
		
		driver.findElement(Lease).click();
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 40);
		
		driver.findElement(NextToReview).click();
		
		Thread.sleep(Const * 10);
		
		driver.findElement(NextToRating).click();
			
		//---------------------------Review---------------------------------------
		
		Thread.sleep(Const * 5);
		driver.findElement(RateNeutralAttachmentCases).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(NotesAttachmentCases).sendKeys("„Õ«Ìœ");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(SubmitAttachmentCases).click();
		
		//----------------------Success-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.2.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Individual Pharmacist Case 4.2.0.0 " + ActualResult);

		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
		
	}
	
	@Test(priority = 3)
	public void SubmitIndividualApp_Case4300() throws InterruptedException, IOException{
		
		//·œÌÂ ÿ·» «Œ—
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9822056900");
		
		driver.findElement(PharmIDNumber).sendKeys("19820222");
		
		driver.findElement(CoNationalNumber).sendKeys("100045693");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·ÊÃÊœ ÿ·»  —ŒÌ’ ’Ìœ·Ì… ⁄«„… ”«»ﬁ";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.3.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.3.0.0");
		
	}
		
	@Test(priority = 4)
	public void SubmitIndividualApp_Case4400() throws InterruptedException, IOException{
		
		//»Ì«‰«  «·«ÕÊ«· €Ì— „ÿ«»ﬁ…
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9831061595");
		
		driver.findElement(PharmIDNumber).sendKeys("19810923");
		
		driver.findElement(CoNationalNumber).sendKeys("100103923");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "€Ì— „ÿ«»ﬁ";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.4.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.4.0.0");
		
	}
	
	@Test(priority = 4)
	public void SubmitIndividualApp_Case4410() throws InterruptedException, IOException{
		
		//«·ÂÊÌ… „‰ ÂÌ… «·’·«ÕÌ…
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("2000797074");
		
		driver.findElement(PharmIDNumber).sendKeys("19810923");
		
		driver.findElement(CoNationalNumber).sendKeys("100047452");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·≈‰ Â«¡ ’·«ÕÌ… «·ÂÊÌ…° Ì—ÃÏ „—«Ã⁄… œ«∆—… «·√ÕÊ«· «·„œ‰Ì… · ÃœÌœ «·ÂÊÌ…";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.4.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.4.1.0");
		
	}
	
	@Test(priority = 5)
	public void SubmitIndividualApp_Case4400_2() throws InterruptedException, IOException{
		
		//«·‘Œ’ „ Ê›Ì
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9842036376");
		
		driver.findElement(PharmIDNumber).sendKeys("19840729");
		
		driver.findElement(CoNationalNumber).sendKeys("100047400");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "«·—ﬁ„ «·Êÿ‰Ì «·„œŒ· ·‘Œ’ „ Ê›Ì. ·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·»";

		System.out.println("Expected: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.4.0.0_2.png"));

		System.out.println("Passed. Individual Pharmacist 4.4.0.0_2");




	}

	@Test(priority = 6)
	public void SubmitIndividualApp_Case4500() throws InterruptedException, IOException{
		
		//—ﬁ„ «·„‰‘√… €Ì— „ÊÃÊœ
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9711018243");
		
		driver.findElement(PharmIDNumber).sendKeys("9787361");
		
		driver.findElement(CoNationalNumber).sendKeys("100000000");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "—ﬁ„ «·„‰‘√… «·Êÿ‰Ì €Ì— „ÊÃÊœ° Ì—ÃÏ «· √ﬂœ „‰ ’Õ… «·—ﬁ„ «·„œŒ·";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.5.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.5.0.0");
		
	}

	@Test(priority = 6)
	public void SubmitIndividualApp_Case4510() throws InterruptedException, IOException{
		
		//«·„‰‘√… €Ì— ›⁄«·…
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9711018243");
		
		driver.findElement(PharmIDNumber).sendKeys("9787361");
		
		driver.findElement(CoNationalNumber).sendKeys("100047451");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·√‰ Õ«·… «·„‰‘√… €Ì— ›⁄«·…° Ì—ÃÏ „—«Ã⁄… Ê“«—… «·’‰«⁄… Ê«· Ã«—… √Ê œ«∆—… „—«ﬁ»… «·‘—ﬂ«  · ’ÊÌ» «·√Ê÷«⁄";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.5.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.5.1.0");
		
	}

	@Test(priority = 7)
	public void SubmitIndividualApp_Case4520() throws InterruptedException, IOException{
		
		//«·„‰‘√… „”Ã·… ›Ì œ«∆—… „—«ﬁ»… «·‘—ﬂ« 
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9832023360");
		
		driver.findElement(PharmIDNumber).sendKeys("19830804");
		
		driver.findElement(CoNationalNumber).sendKeys("200045693");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(MobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("2624010298134");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
		
		driver.findElement(SocialSecurityNo).sendKeys("9832023360");
		
		driver.findElement(PharmAddress).sendKeys("address 1");
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(2);
		
		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToAttachemnts).click();
		
		//---------------------------Attachments---------------------------------------
		
		driver.findElement(Sketch).click();
		
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);
		
		driver.findElement(Lease).click();
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 20);
		
		driver.findElement(NextToReview).click();
		
		Thread.sleep(Const * 10);
		
		driver.findElement(NextToRating).click();
		
		//---------------------------Review---------------------------------------
		
		Thread.sleep(Const * 5);
		driver.findElement(RateSadAttachmentCases).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(NotesAttachmentCases).sendKeys("Sad");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(SubmitAttachmentCases).click();
		
		//----------------------Success-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.5.2.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Individual Pharmacist Case 4.5.2.0 " + ActualResult);

		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
		
	}

	@Test(priority = 8)
	public void SubmitIndividualApp_Case4530() throws InterruptedException, IOException{
		
		//⁄œœ «·‘—ﬂ«¡ «ﬂÀ— „‰ Ê«Õœ
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9821060969");
		
		driver.findElement(PharmIDNumber).sendKeys("19821114");
		
		driver.findElement(CoNationalNumber).sendKeys("200045694");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« ÌÃÊ“  ﬁœÌ„ «·ÿ·» »Â–« «·‰Ê⁄ „‰ «‰Ê«⁄ „ﬁœ„Ì «·ÿ·» ﬂÊ‰ ⁄œœ «·‘—ﬂ«¡ √ﬂÀ— „‰ Ê«Õœ° Ì—ÃÏ «·—ÃÊ⁄ ·’›Õ… ﬁ«∆„… «· Õﬁﬁ Ê«Œ Ì«—";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.5.3.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.5.3.0");
		
	}

	@Test(priority = 9)
	public void SubmitIndividualApp_Case4540() throws InterruptedException, IOException{
		
		//«·„‰‘√… ·Ì” ·Â« «”„  Ã«—Ì
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9802054679");
		
		driver.findElement(PharmIDNumber).sendKeys("19801028");
		
		driver.findElement(CoNationalNumber).sendKeys("100053866");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "«”„  Ã«—Ì";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.5.4.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.5.4.0");
		
	}

	@Test(priority = 10)
	public void SubmitIndividualApp_Case4600() throws InterruptedException, IOException{
		
		//€Ì— „‰ ”» ··‰ﬁ«»…
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9771025033");
		
		driver.findElement(PharmIDNumber).sendKeys("4194057");
		
		driver.findElement(CoNationalNumber).sendKeys("100053865");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "€Ì— „‰ ”»";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.6.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.6.0.0");
		
	}

	@Test(priority = 11)
	public void SubmitIndividualApp_Case4610() throws InterruptedException, IOException{
		
		//„‰ ”» Ê€Ì— „”œœ
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9851055811");
		
		driver.findElement(PharmIDNumber).sendKeys("19851002");
		
		driver.findElement(CoNationalNumber).sendKeys("100053864");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "€Ì— „”œœ";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.6.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.6.1.0");
		
	}

	@Test(priority = 11, enabled = false)
	public void SubmitIndividualApp_Case4620() throws InterruptedException, IOException{
		
		//⁄œ„ «” —Ã«⁄ »Ì«‰«  „‰ «·‰ﬁ«»…
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9851055811");
		
		driver.findElement(PharmIDNumber).sendKeys("19851002");
		
		driver.findElement(CoNationalNumber).sendKeys("100053864");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "€Ì— „”œœ";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.6.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.6.1.0");
		
	}

	@Test(priority = 12)
	public void SubmitIndividualApp_Case4700() throws InterruptedException, IOException{
		
		//·Ì” ·œÌÂ —Œ’… „“«Ê·…
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9861015386");
		
		driver.findElement(PharmIDNumber).sendKeys("12345678");
		
		driver.findElement(CoNationalNumber).sendKeys("100053863");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·√‰ﬂ €Ì— „“«Ê· ··„Â‰… ·À·«À ”‰Ê«  ›√ﬂÀ—";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.7.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.7.0.0");
		
	}

	@Test(priority = 13)
	public void SubmitIndividualApp_Case4710() throws InterruptedException, IOException{
		
		//„“«Ê· ·«ﬁ· „‰ 3 ”‰Ê« 
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9861015387");
		
		driver.findElement(PharmIDNumber).sendKeys("12345678");
		
		driver.findElement(CoNationalNumber).sendKeys("100053862");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "À·«À ”‰Ê« ";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.7.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.7.1.0");
		
	}
	
	@Test(priority = 14)
	public void SubmitIndividualApp_Case4800() throws InterruptedException, IOException{
		
		//«·’Ìœ·Ì Ì„ ·ﬂ ’Ìœ·Ì… «Œ—Ï
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9842002147");
		
		driver.findElement(PharmIDNumber).sendKeys("19840111");
		
		driver.findElement(CoNationalNumber).sendKeys("100053860");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
			
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "Ì„ ·ﬂ";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.8.2.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.8.2.0");
		
		
	}
	
	@Test(priority = 14)
	public void SubmitIndividualApp_Case4810() throws InterruptedException, IOException{
		
		//«·’Ìœ·Ì ﬂ«‰ Ì„ ·ﬂ ’Ìœ·Ì… «Œ—Ï ﬁ»· «ﬁ· „‰ ”‰ Ì‰
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9891061943");
		
		driver.findElement(PharmIDNumber).sendKeys("12345678");
		
		driver.findElement(CoNationalNumber).sendKeys("100123055");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
			
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·«„ ·«ﬂ «·”Ìœ";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.8.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.8.1.0");
		
		
	}
	
	@Test(priority = 2)
	public void SubmitIndividualApp_Case4900() throws InterruptedException, IOException{
		
		//—ﬁ„ «‰ ”«» «·÷„«‰ €Ì— ’ÕÌÕ
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9851032994");
		
		driver.findElement(PharmIDNumber).sendKeys("19850115");
		
		driver.findElement(CoNationalNumber).sendKeys("100000822");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(MobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("51282027248131");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
		
		driver.findElement(SocialSecurityNo).sendKeys("555878");
		
		driver.findElement(PharmAddress).sendKeys("address 1");
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		
		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToAttachemnts).click();
		
		//---------------------------------
		
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "÷„«‰";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.9.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.9.0.0");	
		
	}
	
	@Test(priority = 16)
	public void SubmitIndividualApp_Case4910() throws InterruptedException, IOException{
		
		//«·’Ìœ·Ì €Ì— „ ›—€ ··⁄„· ›Ì «·’Ìœ·Ì… Õ”» —ﬁ„ «·÷„«‰
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9832000159");
		
		driver.findElement(PharmIDNumber).sendKeys("19830307");
		
		driver.findElement(CoNationalNumber).sendKeys("100053861");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(MobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("223928003998122",Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
		
		driver.findElement(SocialSecurityNo).sendKeys("9832000159");
		
		driver.findElement(PharmAddress).sendKeys("address 1");
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		
		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToAttachemnts).click();
		
		//---------------------------------
		
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "⁄œ„  ›—€";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.9.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.9.1.0");
		
	}
	
	@Test(priority = 16)
	public void SubmitIndividualApp_Case4920() throws InterruptedException, IOException{
		
		//«·’Ìœ·Ì €Ì— „ ›—€ ··⁄„· ›Ì «·’Ìœ·Ì… Õ”» Ê“«—… «·’Õ… 
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9691023156");
		
		driver.findElement(PharmIDNumber).sendKeys("ABC12345");
		
		driver.findElement(CoNationalNumber).sendKeys("100123888");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(MobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("917116018328101",Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
		
		//driver.findElement(SocialSecurityNo).sendKeys("9832000159");
		
		driver.findElement(PharmAddress).sendKeys("address 1");
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(3);
		
		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToAttachemnts).click();
		
		//---------------------------------
		
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "⁄œ„  ›—€";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.9.2.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.9.2.0");
		
	}
	
	@Test(priority = 17)
	public void SubmitIndividualApp_Case41000() throws InterruptedException, IOException{
		
		//Œÿ√ ›Ì —ﬁ„ ”‰œ  ”ÃÌ· «·⁄ﬁ«—
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9831061595");
		
		driver.findElement(PharmIDNumber).sendKeys("19830606");
		
		driver.findElement(CoNationalNumber).sendKeys("100103923");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(MobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("8989", Keys.TAB);
		
		//---------------------------------
		
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "—ﬁ„ ”‰œ  ”ÃÌ· «·⁄ﬁ«— «·„œŒ· €Ì— ’ÕÌÕ";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.10.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.10.0.0");
		
	}

	@Test(priority = 17)
	public void SubmitIndividualApp_Case41010() throws InterruptedException, IOException{
		
		//«·⁄ﬁ«—  «»⁄ ·”·ÿ… «ﬁ·Ì„ «·⁄ﬁ»…
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9831061595");
		
		driver.findElement(PharmIDNumber).sendKeys("19830606");
		
		driver.findElement(CoNationalNumber).sendKeys("100103923");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(MobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("34637606978102", Keys.TAB);
		
		//---------------------------------
		
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "⁄ﬁ»…";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.10.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.10.1.0");
		
	}

	@Test(priority = 17)
	public void SubmitIndividualApp_Case41020() throws InterruptedException, IOException{
		
		//«·⁄ﬁ«— ⁄·ÌÂ ÿ·» ”«»ﬁ
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9831061595");
		
		driver.findElement(PharmIDNumber).sendKeys("19830606");
		
		driver.findElement(CoNationalNumber).sendKeys("100103923");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(MobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("91751103828112", Keys.TAB);
		
		Thread.sleep(Const * 20);

		//---------------------------------

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·ÊÃÊœ ÿ·» ≈’œ«— —Œ’… ’Ìœ·Ì… ⁄«„… ⁄·Ï ‰›” «·⁄ﬁ«—";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.10.2.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.10.2.0");
		
	}

}
