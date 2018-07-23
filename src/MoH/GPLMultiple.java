package MoH;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

public class GPLMultiple extends GPLFields{
	
	WebDriver driver;

	Integer Const = 200;
	public static String AppNo;

	@BeforeMethod(enabled = true)
	public void GetDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\nftaiha\\\\git\\\\MoH\\\\MoH\\\\src\\\\MoH\\\\chromedriver.exe");
		driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\emasoud\\Desktop\\geckodriver.exe");
		// driver = new FirefoxDriver();
		driver.get("https://ohs-vip:4443/public/index.html");
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
			driver.get("https://ohs-vip:4443/public/index.html");
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
				FileUtils.copyFile(source, new File("./Screenshots-GPLFailure/" + result.getName() + ".png"));

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
	//Submit successfully
	public void SubmitMultipleApp_Case5000() throws InterruptedException, IOException{
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		
		driver.findElement(CoNationalNumber2).sendKeys("200000866");
		driver.findElement(CoNumber).sendKeys("21337");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("91751103828112");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys("address 1");
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
		
		//---------------------------Attachments---------------------------------------
		
		driver.findElement(Sketch).click();
		
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);
		
		driver.findElement(Lease).click();
		Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.
		driver.findElement(COSketch).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.
		driver.findElement(Contract).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.
		
		Thread.sleep(Const * 30);
		
		driver.findElement(CoNextToReview).click();
		
		//---------------------------Review---------------------------------------
		driver.findElement(NextToRating).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(RateHappyAttachmentCases).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(NotesAttachmentCases).sendKeys("Happy");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(SubmitAttachmentCases).click();
		
		//----------------------Success-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case4.0.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.0.0.0 " + ActualResult);

		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
		
	}
	
	//Not exist user
	@Test(priority = 3)
	public void SubmitMultipleApp_Case5200() throws InterruptedException, IOException{
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		
		driver.findElement(CoNationalNumber2).sendKeys("741237857");
		driver.findElement(CoNumber).sendKeys("1414254");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
		
		Thread.sleep(Const * 8);
		 //click on edit user's info link 
		
		driver.findElement(ModifyContactDetails).click();
		//
		Thread.sleep(Const * 20);
		driver.findElement(VerificationCodeMyPage).sendKeys("0000");
		Thread.sleep(Const * 20);
		driver.findElement(NextToMyPage).click();
		Thread.sleep(Const * 20);
		driver.findElement(MyAddress).sendKeys("Address1");

		driver.findElement(SaveEditedInfo).click();

		// capture-screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.2.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.2.0.0 " );
		
	}
	//Open application
	@Test(priority = 3)
	public void SubmitMultipleApp_Case5300() throws InterruptedException, IOException{
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		
		driver.findElement(CoNationalNumber2).sendKeys("200000866");
		driver.findElement(CoNumber).sendKeys("21337");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
		
		Thread.sleep(Const * 8);
		
		//----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب لترخيص صيدلية عامة مزاولة نظرا لوجود طلب ترخيص صيدلية عامة سابق رقم (14 / 2018) لديك لايزال قيد التنفيذ، لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.3.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.3.0.0 " + ActualResult);
		System.out.println("Expected = " + ExpectedResult);
	}
	@Test(priority = 2)
	public void SubmitMultipleApp_Case5400() throws InterruptedException, IOException{
		
		//
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		
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
		
		driver.findElement(NextToRating).click();
		
		//---------------------------Review---------------------------------------
		
		Thread.sleep(Const * 5);
		driver.findElement(RateNeutralAttachmentCases).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(NotesAttachmentCases).sendKeys("ãÍÇíÏ");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(SubmitAttachmentCases).click();
		
		//----------------------Success-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "";
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
	
		
	}


