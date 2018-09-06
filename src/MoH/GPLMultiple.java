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

public class GPLMultiple extends GPLFields {

	WebDriver driver;

	Integer Const = 200;
	public static String AppNo;

	@BeforeMethod(enabled = true)
	public void GetDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\nftaiha\\\\git\\\\MoH\\\\MoH\\\\src\\\\MoH\\\\chromedriver.exe");
		driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\emasoud\\Desktop\\geckodriver.exe");
		// driver = new FirefoxDriver();
		driver.get("http://soa-vip:7003/public/index.html");
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
	// Submit successfully
	public void SubmitMultipleApp_Case5000() throws InterruptedException, IOException {
		driver.findElement(Apply).click();

		Thread.sleep(Const * 2);

		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);

		Thread.sleep(Const * 8);

		driver.findElement(NextToBasicInfo).click();

		Thread.sleep(Const * 2);

		// ---------------------------Basic-Info---------------------------------------

		driver.findElement(CoNationalNumber2).sendKeys("200000866");
		driver.findElement(CoNumber).sendKeys("21337");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);

		Thread.sleep(Const * 8);

		driver.findElement(CoVerify).click();

		Thread.sleep(Const * 8);

		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		// ---------------------------Other-Info---------------------------------------

		driver.findElement(PropertyNumber).sendKeys("41121208118131");

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

		// ---------------------------Attachments---------------------------------------
		Thread.sleep(Const * 20);
		driver.findElement(Sketch).click();
		Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.
		Thread.sleep(Const * 10);
		driver.findElement(Contract).click();
		Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		Thread.sleep(Const * 10);
		driver.findElement(Lease).click();
		Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.
		Thread.sleep(Const * 10);
		driver.findElement(COSketch).click();
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.
		Thread.sleep(Const * 30);

		// Give path where the au3 is saved.

		Thread.sleep(Const * 40);

		driver.findElement(CoNextToReview).click();

		// ---------------------------Review---------------------------------------
		driver.findElement(NextToRating).click();

		Thread.sleep(Const * 5);
		driver.findElement(RateHappyAttachmentCases).click();

		Thread.sleep(Const * 5);
		driver.findElement(NotesAttachmentCases).sendKeys("Happy");

		Thread.sleep(Const * 8);

		driver.findElement(SubmitAttachmentCases).click();

		// ----------------------Success-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		System.out.println("Actual : " + ActualResult);
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		System.out.println("Expected : " + ExpectedResult);
		
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		
		//-------------------------- capture-screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.0.0.0.png"));
		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.0.0.0 " );

		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page

	}

	//  exists user
	@Test(priority = 3)
	public void SubmitMultipleApp_Case5200() throws InterruptedException, IOException {
		driver.findElement(Apply).click();

		Thread.sleep(Const * 2);

		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);

		Thread.sleep(Const * 8);

		driver.findElement(NextToBasicInfo).click();

		Thread.sleep(Const * 2);

		// ---------------------------Basic-Info---------------------------------------

		driver.findElement(CoNationalNumber2).sendKeys("741237857");
		driver.findElement(CoNumber).sendKeys("1414254");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);

		Thread.sleep(Const * 8);

		driver.findElement(CoVerify).click();

		Thread.sleep(Const * 20);
		// click on edit user's info link

		driver.findElement(ModifyContactDetails).click();
		//
		Thread.sleep(Const * 20);
		driver.findElement(VerificationCode2).sendKeys("0000", Keys.TAB);
		Thread.sleep(Const * 40);
		driver.findElement(NextToMyPage).click();
		Thread.sleep(Const * 20);
		driver.findElement(MyAddress).sendKeys("Address1");

		driver.findElement(SaveEditedInfo).click();
		String ActualResult = driver.findElement(SuccessMessageMyPage).getText();
		System.out.println("Actual : " + ActualResult);
		String ExpectedResult = "تم تنفيذ العملية بنجاح";
		System.out.println("Expected : " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.2.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.2.0.0 ");

	}

	// Open application
	@Test(priority = 3)
	public void SubmitMultipleApp_Case5300() throws InterruptedException, IOException {
		driver.findElement(Apply).click();

		Thread.sleep(Const * 2);

		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);

		Thread.sleep(Const * 8);

		driver.findElement(NextToBasicInfo).click();

		Thread.sleep(Const * 2);

		// ---------------------------Basic-Info---------------------------------------

		driver.findElement(CoNationalNumber2).sendKeys("200000866");
		driver.findElement(CoNumber).sendKeys("21337");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);

		Thread.sleep(Const * 10);

		driver.findElement(CoVerify).click();

		Thread.sleep(Const * 10);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual : " + ActualResult);
		String ExpectedResult = "لايزال قيد التنفيذ";
		System.out.println("Expected = " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.3.0.0.png"));
		
		System.out.println("Passed. Multiple Pharmacists Case 5.3.0.0 " + ActualResult);

		// -----------------------------------------------------------------------------------------------
	
	}
//ra8am 8aid mansha2a gher mwjood 
	@Test(priority = 2)
	public void SubmitMultipleApp_Case5400_1() throws InterruptedException, IOException {
		// incorrect institute national number
		driver.findElement(Apply).click();

		Thread.sleep(Const * 2);

		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);

		Thread.sleep(Const * 8);

		driver.findElement(NextToBasicInfo).click();

		Thread.sleep(Const * 2);

		// ---------------------------Basic-Info---------------------------------------

		driver.findElement(CoNationalNumber2).sendKeys("2999999999");
		driver.findElement(CoNumber).sendKeys("2139");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);

		Thread.sleep(Const * 8);

		driver.findElement(CoVerify).click();

		Thread.sleep(Const * 8);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual : " + ActualResult);

		String ExpectedResult = "رقم المنشأة الوطني غير موجود";
		System.out.println("Expected = " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.4.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.4.0.0_1 " + ActualResult);

	}
	//ra8am sharekeh w ra8am mansha2a gher motabe8en 
	@Test(priority = 2)
	public void SubmitMultipleApp_Case5400_2() throws InterruptedException, IOException {
		// incorrect institute national number
		driver.findElement(Apply).click();

		Thread.sleep(Const * 2);

		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);

		Thread.sleep(Const * 8);

		driver.findElement(NextToBasicInfo).click();

		Thread.sleep(Const * 2);

		// ---------------------------Basic-Info---------------------------------------

		driver.findElement(CoNationalNumber2).sendKeys("200000866");
		driver.findElement(CoNumber).sendKeys("2139");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);

		Thread.sleep(Const * 8);

		driver.findElement(CoVerify).click();

		Thread.sleep(Const * 8);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual : " + ActualResult);

		String ExpectedResult = "رقم قيد المنشأة الوطني ورقم الشركة غير مطابقين";
		System.out.println("Expected = " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.4.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.4.0.0_2 " + ActualResult);

	}
	
	@Test(priority = 2)
public void SubmitMultipleApp_Case5420() throws InterruptedException, IOException {
		// esem tejari
		driver.findElement(Apply).click();

		Thread.sleep(Const * 2);

		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);

		Thread.sleep(Const * 8);

		driver.findElement(NextToBasicInfo).click();

		Thread.sleep(Const * 2);

		// ---------------------------Basic-Info---------------------------------------

		driver.findElement(CoNationalNumber2).sendKeys("200123456");
		driver.findElement(CoNumber).sendKeys("3456");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);

		Thread.sleep(Const * 8);

		driver.findElement(CoVerify).click();

		Thread.sleep(Const * 8);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.4.1.0 " + ActualResult);
		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب نظرا لعدم وجود اسم او علامة تجارية مسجلة للصيدلية، يرجى التأكد من تسجيل الاسم أو العلامة التجارية في وزارة الصناعة والتجارة. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		// capture-screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.4.0.0.png"));
		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.4.2.0 " + ActualResult);
		System.out.println("Expected = " + ExpectedResult);

	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5410() throws InterruptedException, IOException {
		// inactive company
		driver.findElement(Apply).click();

		Thread.sleep(Const * 2);

		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);

		Thread.sleep(Const * 8);

		driver.findElement(NextToBasicInfo).click();

		Thread.sleep(Const * 2);

		// ---------------------------Basic-Info---------------------------------------

		driver.findElement(CoNationalNumber2).sendKeys("200110194");
		driver.findElement(CoNumber).sendKeys("21333");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);

		Thread.sleep(Const * 8);

		driver.findElement(CoVerify).click();

		Thread.sleep(Const * 8);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Actual: " + ActualResult);

		String ExpectedResult = "لأن حالة المنشأة غير فعالة";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.4.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.4.1.0 " + ActualResult);
		System.out.println("Expected = " + ExpectedResult);

	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5430() throws InterruptedException, IOException {
		// inactive company
		driver.findElement(Apply).click();

		Thread.sleep(Const * 2);

		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);

		Thread.sleep(Const * 8);

		driver.findElement(NextToBasicInfo).click();

		Thread.sleep(Const * 2);

		// ---------------------------Basic-Info---------------------------------------

		driver.findElement(CoNationalNumber2).sendKeys("200000888");
		driver.findElement(CoNumber).sendKeys("21335");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);

		Thread.sleep(Const * 8);

		driver.findElement(CoVerify).click();

		Thread.sleep(Const * 8);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.4.3.0 " + ActualResult);

		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب، يرجى التأكد من تسجيل الاسم أو العلامة التجارية في وزارة الصناعة والتجارة.لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.4.3.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.4.3.0 " + ActualResult);
		System.out.println("Expected = " + ExpectedResult);

	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5440() throws InterruptedException, IOException {
		// 3alameh aw esem tejari
		driver.findElement(Apply).click();

		Thread.sleep(Const * 2);

		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);

		Thread.sleep(Const * 8);

		driver.findElement(NextToBasicInfo).click();

		Thread.sleep(Const * 2);

		// ---------------------------Basic-Info---------------------------------------

		driver.findElement(CoNationalNumber2).sendKeys("200000888");
		driver.findElement(CoNumber).sendKeys("21335");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);

		Thread.sleep(Const * 8);

		driver.findElement(CoVerify).click();

		Thread.sleep(Const * 8);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.4.4.0 " + ActualResult);

		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب، يرجى التأكد من تسجيل الاسم أو العلامة التجارية في وزارة الصناعة والتجارة.لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.4.4.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.4.4.0 " + ActualResult);
		System.out.println("Expected = " + ExpectedResult);

	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5450() throws InterruptedException, IOException {
		// national numbers are not retrieved
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("213244845");
		driver.findElement(CoNumber).sendKeys("21336");
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);
		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.4.5.0 " + ActualResult);

		String ExpectedResult = " لا يمكنك إستكمال تقديم الطلب، نظرا لعدم إسترجاع جميع الأرقام الوطنية للشركاء، يرجى مراجعة دائرة  مراقبة الشركات لتصويب الأوضاع. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		// capture-screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.4.5.0.png"));
		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.4.5.0 " + ActualResult);
		System.out.println("Expected = " + ExpectedResult);

	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5500() throws InterruptedException, IOException {
		// gher montaseb lal na8abeh
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200005441");
		driver.findElement(CoNumber).sendKeys("21337");
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("4120109068232");

		Thread.sleep(Const * 8);

		driver.findElement(PharmCoordinates).sendKeys("45456");

		driver.findElement(PharmAddress).sendKeys("address 1");

		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();

		Thread.sleep(Const * 8);

		driver.findElement(CoNextToAttachemnts).click();
		Thread.sleep(Const * 20);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.5.0.0 " + ActualResult);

		String ExpectedResult = " لا يمكنك استكمال تقديم الطلب نظرا لعدم استرجاع بينات السيد /السيدة () من النقابة , يرجى تصحيح البيانات عند النقابة,  لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.5.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.5.0.0 " + ActualResult);
		System.out.println("Expected = " + ExpectedResult);
	}
;
	@Test(priority = 2)
	public void SubmitMultipleApp_Case5510() throws InterruptedException, IOException {
		// gher mosaded lal rosom
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200000855");
		driver.findElement(CoNumber).sendKeys("21338");
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("4120109068232");

		Thread.sleep(Const * 8);

		driver.findElement(PharmCoordinates).sendKeys("45456");

		driver.findElement(PharmAddress).sendKeys("address 1");

		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();

		Thread.sleep(Const * 8);

		driver.findElement(CoNextToAttachemnts).click();
		Thread.sleep(Const * 20);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.5.1.0 " + ActualResult);

		String ExpectedResult = "يرجى تسديد رسوم النقابة ومن ثم تقديم طلب إصدار رخصة صيدلية";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.5.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.5.1.0 " + ActualResult);
		System.out.println("Expected = " + ExpectedResult);
	}
	//corrupted data in JPA
	@Test(priority = 2)
	public void SubmitMultipleApp_Case5520() throws InterruptedException, IOException {
		// gher mosaded lal rosom
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200147853");
		driver.findElement(CoNumber).sendKeys("4150");
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("4120109068232");

		Thread.sleep(Const * 8);

		driver.findElement(PharmCoordinates).sendKeys("45456");

		driver.findElement(PharmAddress).sendKeys("address 1");

		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();

		Thread.sleep(Const * 8);

		driver.findElement(CoNextToAttachemnts).click();
		Thread.sleep(Const * 20);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.5.1.0 " + ActualResult);

		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب نظرا لأن غير مسدد للرسوم المترتبة عليك في النقابة يرجى تسديد رسوم النقابة ومن ثم تقديم طلب إصدار رخصة صيدلية عامة.لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.5.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.5.1.0 " + ActualResult);
		System.out.println("Expected = " + ExpectedResult);
	}
	//shareek ma 3ndo mozawalet mehnea 
	@Test(priority = 2)
	public void SubmitMultipleApp_Case5600() throws InterruptedException, IOException {
		// gher mosaded lal rosom
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200000844");
		driver.findElement(CoNumber).sendKeys("21339");
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("4120109068232");

		Thread.sleep(Const * 8);

		driver.findElement(PharmCoordinates).sendKeys("45456");

		driver.findElement(PharmAddress).sendKeys("address 1");

		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();

		Thread.sleep(Const * 8);

		driver.findElement(CoNextToAttachemnts).click();
		Thread.sleep(Const * 20);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.6.0.0 " + ActualResult);

		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب، نظرا لأن السيد/السيدة() غير مزاول للمهنة .لمزيد من المعلومات يرجى الاتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Expected = " + ExpectedResult);
		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.6.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.6.0.0 " + ActualResult);
		System.out.println("Expected = " + ExpectedResult);
	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5610() throws InterruptedException, IOException {
		// LESS than 3 months
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200000833");
		driver.findElement(CoNumber).sendKeys("21340");
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("4120109068232");

		Thread.sleep(Const * 8);

		driver.findElement(PharmCoordinates).sendKeys("45456");

		driver.findElement(PharmAddress).sendKeys("address 1");

		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();

		Thread.sleep(Const * 8);

		driver.findElement(CoNextToAttachemnts).click();
		Thread.sleep(Const * 20);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.6.1.0 " + ActualResult);

		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب، نظرا لأن السيد/السيدة() غير مزاول للمهنة لثلاث سنوات و أكثر .لمزيد من المعلومات يرجى الاتصال على الخط الساخن لوزارة الصحة ";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Expected = " + ExpectedResult);
		System.out.println("Expected = " + ExpectedResult);

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.6.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.6.1.0 " + ActualResult);
	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5700() throws InterruptedException, IOException {
		// LESS than 3 months
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200000822");
		driver.findElement(CoNumber).sendKeys("21341");
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("4120109068232");

		Thread.sleep(Const * 8);

		driver.findElement(PharmCoordinates).sendKeys("45456");

		driver.findElement(PharmAddress).sendKeys("address 1");

		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();

		Thread.sleep(Const * 8);

		driver.findElement(CoNextToAttachemnts).click();
		Thread.sleep(Const * 20);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.7.0.0 " + ActualResult);

		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب، نظرا لامتلاك السيد/السيدة () صيدلية عاملة أخرى و لعدم مرور سنتين على بيعه للصيدلية (إسم الصيدلية، أو إغلاق الصيدلية إسم الصيدلية أو إلغائه للصيدلية إسم الصيدلية). لمزيد من المعلومات يرجى الاتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Expected = " + ExpectedResult);

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.7.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.7.0.0 " + ActualResult);
	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5710() throws InterruptedException, IOException {
		// partner owned a pharmacy before less than 2 years
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200000822");
		driver.findElement(CoNumber).sendKeys("21341");
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("4120109068232");

		Thread.sleep(Const * 8);

		driver.findElement(PharmCoordinates).sendKeys("45456");

		driver.findElement(PharmAddress).sendKeys("address 1");

		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();

		Thread.sleep(Const * 8);

		driver.findElement(CoNextToAttachemnts).click();
		Thread.sleep(Const * 20);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.7.1.0 " + ActualResult);

		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب، نظرا لامتلاك السيد/السيدة () صيدلية عاملة أخرى و لعدم مرور سنتين على بيعه للصيدلية (إسم الصيدلية، أو إغلاق الصيدلية إسم الصيدلية أو إلغائه للصيدلية إسم الصيدلية). لمزيد من المعلومات يرجى الاتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Expected = " + ExpectedResult);
		System.out.println("Expected = " + ExpectedResult);

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.7.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.7.1.0 " + ActualResult);
	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5800() throws InterruptedException, IOException {
		// committed pharmacist is not free to work in the pharmacy - 7asab al damman
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("213294150");
		driver.findElement(CoNumber).sendKeys("4150");
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("4120109068232");

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
		Thread.sleep(Const * 20);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.8.0.0 " + ActualResult);

		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب نظرا لعدم تفرغ السيد / السيدة () للعمل في الصيدلية، حيث تبين أنه يعمل في (إسم الصيدلية أو المصنع أو المستودع). لمزيد من المعلومات يرجى الإتصال على الخط الساخن وزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.8.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.8.0.0 " + ActualResult);
	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5810() throws InterruptedException, IOException {
		// committed pharmacist is not free to work in the pharmacy - 7asab MoH
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200141130");
		driver.findElement(CoNumber).sendKeys("36683");
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("4120109068232");

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
		Thread.sleep(Const * 20);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.8.1.0 " + ActualResult);

		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب،  نظرا لعدم تفرغ السيد / السيدة () للعمل بالصيدلية، حيث تبين أنك تعمل بالصيدلية (إسم الصيدلية) أو (إسم المصنع أو (إسم المستودع)  لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Expected = " + ExpectedResult);

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.8.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.8.1.0 " + ActualResult);
	}
	// committed pharmacist is not free to work in the pharmacy - 7asab MoH

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5820() throws InterruptedException, IOException {
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200141130");
		driver.findElement(CoNumber).sendKeys("36683");
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("4120109068232");

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
		Thread.sleep(Const * 20);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.8.2.0 " + ActualResult);
		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب،  نظرا لعدم تفرغ السيد / السيدة () للعمل بالصيدلية، حيث تبين أنك تعمل بالصيدلية (إسم الصيدلية) أو (إسم المصنع أو (إسم المستودع)  لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Expected = " + ExpectedResult);

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.8.2.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.8.2.0 " + ActualResult);
	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5830() throws InterruptedException, IOException {
		//
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200147853");
		driver.findElement(CoNumber).sendKeys("4150");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		try {

			driver.findElement(MobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			Thread.sleep(Const * 4);

		} catch (Exception e) {// do nothing

		}
		Thread.sleep(Const * 15);

		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------
		Thread.sleep(Const * 15);

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("4120109068232");

		Thread.sleep(Const * 8);

		driver.findElement(PharmCoordinates).sendKeys("45456");

		driver.findElement(PharmAddress).sendKeys("address 1");

		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();

		Thread.sleep(Const * 8);
		driver.findElement(By.id("pt1:r1:3:t1:1:it2::content")).sendKeys("45456");
		Thread.sleep(Const * 8);

		driver.findElement(CoNextToAttachemnts).click();
		Thread.sleep(Const * 20);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.8.3.0 " + ActualResult);

		String ExpectedResult = "";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Expected = " + ExpectedResult);

		// capture-screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.8.3.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.8.3.0 " + ActualResult);
	}

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5900() throws InterruptedException, IOException {
		// incorrect dls key
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200000769");
		driver.findElement(CoNumber).sendKeys("9578");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		try {

			driver.findElement(MobileNo2).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email2).sendKeys("emasoud@optimizasolutions.com"); // Email

			Thread.sleep(Const * 4);

		} catch (Exception e) {// do nothing

		}

		Thread.sleep(Const * 8);

		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("342452352522", Keys.TAB);

		Thread.sleep(Const * 8);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.9.0.0 " + ActualResult);

		String ExpectedResult = "رقم سند تسجيل العقار المدخل غير صحيح، يرجى التأكد من صحة الرقم المدخل. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Expected = " + ExpectedResult);

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.9.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.9.0.0 " + ActualResult);
	}
	// Aqaba

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5910() throws InterruptedException, IOException {
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200000769");
		driver.findElement(CoNumber).sendKeys("9578");
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		try {

			driver.findElement(MobileNo2).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email2).sendKeys("emasoud@optimizasolutions.com"); // Email

			Thread.sleep(Const * 4);

		} catch (Exception e) {// do nothing

		}

		Thread.sleep(Const * 8);

		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("346481107028112", Keys.TAB);

		Thread.sleep(Const * 8);

		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.9.1.0 " + ActualResult);

		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب نظرا لوجود العقار ضمن أراضي سلطة إقليم العقبة. يمكنك التقدم بطلبك لسلطة الإقليم مباشرة. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.9.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.9.1.0 " + ActualResult);
	}
	// property already has an application

	@Test(priority = 2)
	public void SubmitMultipleApp_Case5920() throws InterruptedException, IOException {
		driver.findElement(Apply).click();
		Thread.sleep(Const * 2);
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(2);
		Thread.sleep(Const * 8);
		driver.findElement(NextToBasicInfo).click();
		Thread.sleep(Const * 2);
		// ---------------------------Basic-Info---------------------------------------
		driver.findElement(CoNationalNumber2).sendKeys("200000769");
		driver.findElement(CoNumber).sendKeys("9578");//9578
		Thread.sleep(Const * 8);
		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		Thread.sleep(Const * 8);
		driver.findElement(CoVerify).click();
		Thread.sleep(Const * 8);
		try {
			driver.findElement(MobileNo2).sendKeys("797352297"); // Mobile-Number
			driver.findElement(Email2).sendKeys("emasoud@optimizasolutions.com"); // Email
			Thread.sleep(Const * 4);
		} catch (Exception e) {// do nothing
		}
		Thread.sleep(Const * 8);

		driver.findElement(NextToVerificationCode).click();

		// ---------------------------Verification-Code---------------------------------------

		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click();

		driver.findElement(PropertyNumber).sendKeys("41121208118131", Keys.TAB);

		Thread.sleep(Const * 8);
		// ----------------------Assert-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println(" Multiple Pharmacists Case 5.9.2.0 " + ActualResult);

		String ExpectedResult = "لا يمكنك استكمال تقديم الطلب نظرا لوجود طلب إصدار رخصة صيدلية عامة على نفس العقار. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected = " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Expected = " + ExpectedResult);

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Multiple-ScreenShots/Case5.9.2.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Multiple Pharmacists Case 5.9.2.0 " + ActualResult);
	}
}
