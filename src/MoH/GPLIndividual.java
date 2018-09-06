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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GPLIndividual extends GPLInternal{
	
	WebDriver driver;

	Integer Const = 800;
	
	@BeforeMethod(enabled = true)
	public void GetDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ChromeDriver);
		driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver",
		// MyFirefoxDriver);
		// driver = new FirefoxDriver();
		
		driver.get(ExternalTesting);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@BeforeMethod(enabled =false)
	@Parameters("browsers")
	public void CrossBrowser(String browsername) throws Exception {

		// Check if parameter passed from TestNG is 'Chrome'
		if (browsername.equalsIgnoreCase("Chrome")) {
			// create Chrome instance
			System.setProperty("webdriver.chrome.driver", ChromeDriver);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(ExternalTesting);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			 } else
			
		 // Check if parameter passed from TestNG is 'IE'
			 if (browsername.equalsIgnoreCase("ie")) {
			 // create IE instance
			
			 System.setProperty("webdriver.ie.driver", IEDriver);
			 driver = new InternetExplorerDriver();
			 driver.manage().window().maximize();
			 driver.get(ExternalTesting);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			// driver.findElement(overridelink).click();
			
			 Thread.sleep(2000);
			 } else
			
			 // Check if parameter passed from TestNG is 'firefox'
			 if (browsername.equalsIgnoreCase("firefox")) {
			 // create firefox instance
			
			 System.setProperty("webdriver.gecko.driver", MyFirefoxDriver);
			 driver = new FirefoxDriver();
			 driver.manage().window().maximize();
			 driver.get(ExternalTesting);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

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

		driver.findElement(LoginVerificationCode).sendKeys("0000", Keys.TAB); // Verification-Code

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

	public void Attachments() throws InterruptedException, IOException{
		driver.findElement(Resignation).click();
		
		Thread.sleep(Const * 10);
	
		Runtime.getRuntime().exec(JPGAtt);
		// Give path where the au3 is saved.

		Thread.sleep(Const * 20);
		
		driver.findElement(Sketch).click();
		
		Thread.sleep(Const * 10);
		
		Runtime.getRuntime().exec(JPGAtt);
		// Give path where the au3 is saved.
		
		Thread.sleep(Const * 10);
		
		driver.findElement(GAM).click();

		Runtime.getRuntime().exec(JPGAtt);
		// Give path where the au3 is saved.
		
		Thread.sleep(Const * 10);
		
		driver.findElement(COSketch).click();
		
		Thread.sleep(Const * 10);
		
		Runtime.getRuntime().exec(JPGAtt);
		// Give path where the au3 is saved.
	
		Thread.sleep(Const * 10);
		
		driver.findElement(Lease).click();

		Thread.sleep(Const * 10);
		
		Runtime.getRuntime().exec(JPGAtt);
		// Give path where the au3 is saved.
		
		Thread.sleep(Const * 20);
		
		driver.findElement(CoNextToReview).click();
		
	}
	
	@Test(priority = 1,enabled = true ,groups = {"Success, Full"})
	public void SubmitIndividualApp_Case4000() throws InterruptedException, IOException{
		
		//تقدبم الطلب بنجاح - بيانات صحيحة
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		NationalIDValue = "9822056900";
		driver.findElement(PharmNationalID).sendKeys(NationalIDValue);
		
		IDNumberValue = "19820222";
		driver.findElement(PharmIDNumber).sendKeys(IDNumberValue);
		
		driver.findElement(CoNationalNumber).sendKeys("100045693");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
		
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(MobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("91751103828112", Keys.TAB);
		
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
		
		this.Attachments();
		
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
		String ExpectedResult = "طلبك بنجاح";
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
		
		//--------------------------------Processing--------------------------
		
		Round = 1;
		KeepAppNo = this.Processing_ApproveByAudit_Case4100(AppNo, IrbidUserName1, IrbidPassword1, Round);
		this.Processing_ApproveByJPA_Case4100_2(KeepAppNo, JPAUserName, JPAPassword, Round);
		this.Processing_AppointByIC_Case4100_3(KeepAppNo, IrbidUserName2, IrbidPassword2);
		
		this.Processing_IncompleteByIC_Case4100_3(KeepAppNo, IrbidUserName2, IrbidPassword2);
		this.Processing_IncompleteByIC_Case4100_3(KeepAppNo, IrbidUserName3, IrbidPassword3);
		
	this.ViewApplicationAndModifyApp_Jordanain_Case4121(KeepAppNo, NationalIDValue, IDNumberValue);
		
		Round = 2;
		this.Processing_ApproveByIC_Case4100_3(KeepAppNo, IrbidUserName2, IrbidPassword2, Round);
		this.Processing_ApproveByIC_Case4100_3(KeepAppNo, IrbidUserName3, IrbidPassword3, Round);
		
		this.Processing_ApproveByDirector_Case4100_4(KeepAppNo, IrbidUserName3, IrbidPassword3);
		this.ViewApplication_Jordanain_Case4101(KeepAppNo, NationalIDValue, IDNumberValue);
		
	}

	@Test(priority = 3,enabled = true ,groups = {"Success, Full"})
	public void SubmitIndividualApp_Case4200() throws InterruptedException, IOException{
		
		//قام بانشاء حساب ولم يتم عملية تقديم الطلب
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		NationalIDValue = "9851032994";
		driver.findElement(PharmNationalID).sendKeys(NationalIDValue);
		
		IDNumberValue = "19850115";
		driver.findElement(PharmIDNumber).sendKeys(IDNumberValue);
		
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
		
		driver.findElement(PharmNationalID).sendKeys(NationalIDValue);
		
		driver.findElement(PharmIDNumber).sendKeys(IDNumberValue);
		
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
		
		driver.findElement(SocialSecurityNo).sendKeys("9851032994");
		
		driver.findElement(PharmAddress).sendKeys("address 1");
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		
		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToAttachemnts).click();
		
		//---------------------------Attachments---------------------------------------
		
		this.Attachments();
		
		driver.findElement(NextToRating).click();
			
		//---------------------------Review---------------------------------------
		
		Thread.sleep(Const * 5);
		driver.findElement(RateNeutralAttachmentCases).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(NotesAttachmentCases).sendKeys("محايد");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(SubmitAttachmentCases).click();
		
		//----------------------Success-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "طلبك بنجاح";
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

		//---------------------------------Processing----------------------------------
		
		Round = 1;
		KeepAppNo = this.Processing_IncompleteByAudit_Case4140(AppNo, CapitalUserName1, CapitalPassword1, Round);
		this.ViewApplicationAndModifyApp_Jordanain_Case4121(KeepAppNo, NationalIDValue, IDNumberValue);
		
		Round = 2;
		this.Processing_ApproveByAudit_Case4100(KeepAppNo, CapitalUserName1, CapitalPassword1, Round);
		
		Round = 1;
		this.Processing_IncompleteByJPA_Case4120_2(KeepAppNo, JPAUserName, JPAPassword, Round);
		this.ViewApplicationAndModifyApp_Jordanain_Case4121(KeepAppNo, NationalIDValue, IDNumberValue);
		
		Round = 2;
		this.Processing_ApproveByJPA_Case4100_2(KeepAppNo, JPAUserName, JPAPassword, Round);
		
		Round = 1;
		this.Processing_AppointByIC_Case4100_3(KeepAppNo, CapitalUserName1, CapitalPassword1);
		this.Processing_ApproveByIC_Case4100_3(KeepAppNo, CapitalUserName1, CapitalPassword1, Round);
		this.Processing_IncompleteByIC_Case4100_3(KeepAppNo, CapitalUserName2, CapitalPassword2);
		
		this.ViewApplicationAndModifyApp_Jordanain_Case4121(KeepAppNo, NationalIDValue, IDNumberValue);
		
		Round = 2;
		this.Processing_RejectByIC_Case4100_3(KeepAppNo, CapitalUserName1, CapitalPassword1, Round);
		this.Processing_RejectByIC_Case4100_3(KeepAppNo, CapitalUserName2, CapitalPassword2, Round);
		
		this.ViewApplicationAndRejection_Jordanain_Case4111(KeepAppNo, NationalIDValue, IDNumberValue);
	}
	
	@Test(priority = 3, groups = {"Previous"})
	public void SubmitIndividualApp_Case4300() throws InterruptedException, IOException{
		
		//لديه طلب اخر
		
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

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لوجود طلب ترخيص صيدلية عامة سابق";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.3.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.3.0.0");
		
	}
		
	@Test(priority = 4, groups = {"CSPD"})
	public void SubmitIndividualApp_Case4400() throws InterruptedException, IOException{
		
		//بيانات الاحوال غير مطابقة
		
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

		String ExpectedErrorMessage = "الرقم الوطني ورقم الهوية غير مطابقين، يرجى التأكد من صحة الأرقام المدخلة";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.4.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.4.0.0");
		
	}
	
	@Test(priority = 4, groups = {"CSPD"})
	public void SubmitIndividualApp_Case4410() throws InterruptedException, IOException{
		
		//الهوية منتهية الصلاحية
		
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

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لإنتهاء صلاحية الهوية، يرجى مراجعة دائرة الأحوال المدنية لتجديد الهوية";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.4.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.4.1.0");
		
	}
	
	@Test(priority = 5, groups = {"CSPD"})
	public void SubmitIndividualApp_Case4400_2() throws InterruptedException, IOException{
		
		//الشخص متوفي
		
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

		String ExpectedErrorMessage = "الرقم الوطني المدخل لشخص متوفي. لا يمكنك استكمال تقديم الطلب";

		System.out.println("Expected: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.4.0.0_2.png"));

		System.out.println("Passed. Individual Pharmacist 4.4.0.0_2");




	}

	@Test(priority = 6, groups = {"MIT" , "CCD"})
	public void SubmitIndividualApp_Case4500() throws InterruptedException, IOException{
		
		//رقم المنشأة غير موجود
		
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

		String ExpectedErrorMessage = "رقم المنشأة الوطني غير موجود، يرجى التأكد من صحة الرقم المدخل";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.5.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.5.0.0");
		
	}

	@Test(priority = 6, groups = {"MIT", "CCD"})
	public void SubmitIndividualApp_Case4510() throws InterruptedException, IOException{
		
		//المنشأة غير فعالة
		
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

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لأن حالة المنشأة غير فعالة، يرجى مراجعة وزارة الصناعة والتجارة أو دائرة مراقبة الشركات لتصويب الأوضاع";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.5.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.5.1.0");
		
	}

	@Test(priority = 7, groups = {"CCD"})
	public void SubmitIndividualApp_Case4520() throws InterruptedException, IOException{
		
		//المنشأة مسجلة في دائرة مراقبة الشركات
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		NationalIDValue = "9832023360"; 
		driver.findElement(PharmNationalID).sendKeys(NationalIDValue);
		
		IDNumberValue = "19830804";
		driver.findElement(PharmIDNumber).sendKeys(IDNumberValue);
		
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
		
		this.Attachments();
		
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
		String ExpectedResult = "طلبك بنجاح";
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
		
		Round = 1;
		KeepAppNo = this.Processing_ApproveByAudit_Case4100(AppNo, CapitalUserName1, CapitalPassword1, Round);
		this.Processing_ApproveByJPA_Case4100_2(KeepAppNo, JPAUserName, JPAPassword, Round);
		this.Processing_AppointByIC_Case4100_3(KeepAppNo, CapitalUserName1, CapitalPassword1);
		this.Processing_RejectByIC_Case4100_3(KeepAppNo, CapitalUserName1, CapitalPassword1, Round);
		this.Processing_ApproveByIC_Case4100_3(KeepAppNo, CapitalUserName2, CapitalPassword2, Round);
		this.ViewApplicationAndRejection_Jordanain_Case4111(KeepAppNo, NationalIDValue, IDNumberValue);
		
	}

	@Test(priority = 8, groups = {"CCD"})
	public void SubmitIndividualApp_Case4530() throws InterruptedException, IOException{
		
		//عدد الشركاء اكثر من واحد
		
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

		String ExpectedErrorMessage = "لا يجوز تقديم الطلب بهذا النوع من انواع مقدمي الطلب كون عدد الشركاء أكثر من واحد، يرجى الرجوع لصفحة قائمة التحقق واختيار";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.5.3.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.5.3.0");
		
	}

	@Test(priority = 9, groups = {"CCD, MIT"})
	public void SubmitIndividualApp_Case4540() throws InterruptedException, IOException{
		
		//المنشأة ليس لها اسم تجاري
		
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
	
		Thread.sleep(Const * 10);
		
		try {

			driver.findElement(MobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
			

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "اسم تجاري";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.5.4.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.5.4.0");
		
	}

	@Test(priority = 10, groups = {"JPA"})
	public void SubmitIndividualApp_Case4600() throws InterruptedException, IOException{
		
		//غير منتسب للنقابة
		
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

		String ExpectedErrorMessage = "غير منتسب";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.6.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.6.0.0");
		
	}

	@Test(priority = 11, groups = {"JPA"})
	public void SubmitIndividualApp_Case4610() throws InterruptedException, IOException{
		
		//منتسب وغير مسدد
		
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

		String ExpectedErrorMessage = "غير مسدد";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.6.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.6.1.0");
		
	}

	@Test(priority = 11, enabled = false, groups = {"JPA"})
	public void SubmitIndividualApp_Case4620() throws InterruptedException, IOException{
		
		//عدم استرجاع بيانات من النقابة
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("");
		
		driver.findElement(PharmIDNumber).sendKeys("");
		
		driver.findElement(CoNationalNumber).sendKeys("");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
	
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "تصويب";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.6.2.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.6.2.0");
		
	}

	@Test(priority = 12, groups = {"VL"})
	public void SubmitIndividualApp_Case4700() throws InterruptedException, IOException{
		
		//ليس لديه رخصة مزاولة
		
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

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لأنك غير مزاول للمهنة لثلاث سنوات فأكثر";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.7.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.7.0.0");
		
	}

	@Test(priority = 13, groups = {"VL"})
	public void SubmitIndividualApp_Case4710() throws InterruptedException, IOException{
		
		//مزاول لاقل من 3 سنوات
		
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

		String ExpectedErrorMessage = "ثلاث سنوات";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.7.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.7.1.0");
		
	}
	
	@Test(priority = 14, groups = {"Own", "Commitment"})
	public void SubmitIndividualApp_Case4800() throws InterruptedException, IOException{
		
		//الصيدلي يمتلك صيدلية اخرى
		
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

		String ExpectedErrorMessage = "يمتلك";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.8.2.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.8.2.0");
		
		
	}
	
	@Test(priority = 14, groups = {"Own", "Commitment"})
	public void SubmitIndividualApp_Case4810() throws InterruptedException, IOException{
		
		// الصيدلي كان يمتلك صيدلية اخرى قبل اقل من سنتين - الغاء
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9931019949");
		
		driver.findElement(PharmIDNumber).sendKeys("019949");
		
		driver.findElement(CoNationalNumber).sendKeys("100264135");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
			
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "عدم مرور سنتين";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.8.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.8.1.0");
		
		
	}
	
	@Test(priority = 14, groups = {"Own", "Commitment"})
	public void SubmitIndividualApp_Case4810_2() throws InterruptedException, IOException{
		
		// الصيدلي كان يمتلك صيدلية اخرى قبل اقل من سنتين - اغلاق
		
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
		//---------------------------Basic-Info---------------------------------------
		
		driver.findElement(PharmNationalID).sendKeys("9931019950");
		
		driver.findElement(PharmIDNumber).sendKeys("019950");
		
		driver.findElement(CoNationalNumber).sendKeys("100264136");
		
		driver.findElement(Captcha).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(VerifyBtn).click();
			
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "عدم مرور سنتين";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.8.1.0_2.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.8.1.0_2");
		
		
	}
	
	@Test(priority = 2, groups = {"SSN", "Commitment"})
	public void SubmitIndividualApp_Case4900() throws InterruptedException, IOException{
		
		//رقم انتساب الضمان غير صحيح
		
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

		String ExpectedErrorMessage = "ضمان";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.9.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.9.0.0");	
		
	}
	
	@Test(priority = 16, groups = {"SSN", "Commitment"})
	public void SubmitIndividualApp_Case4910() throws InterruptedException, IOException{
		
		//الصيدلي غير متفرغ للعمل في الصيدلية حسب رقم الضمان
		
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

		String ExpectedErrorMessage = "عدم تفرغ";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.9.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.9.1.0");
		
	}
	
	@Test(priority = 16, groups = {"MoH", "Commitment"})
	public void SubmitIndividualApp_Case4920() throws InterruptedException, IOException{
		
		//الصيدلي غير متفرغ للعمل في الصيدلية حسب وزارة الصحة 
		
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

		String ExpectedErrorMessage = "عدم تفرغ";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.9.2.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.9.2.0");
		
	}
	
	@Test(priority = 17, groups = {"DLS"})
	public void SubmitIndividualApp_Case41000() throws InterruptedException, IOException{
		
		//خطأ في رقم سند تسجيل العقار
		
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

		String ExpectedErrorMessage = "رقم سند تسجيل العقار المدخل غير صحيح";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.10.0.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.10.0.0");
		
	}

	@Test(priority = 17, groups = {"DLS"})
	public void SubmitIndividualApp_Case41010() throws InterruptedException, IOException{
		
		//العقار تابع لسلطة اقليم العقبة
		
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
		
		driver.findElement(PropertyNumber).sendKeys("346481107028112", Keys.TAB);
		
		//---------------------------------
		
		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لوجود العقار ضمن أراضي سلطة إقليم العقبة";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./GPL-Individual-ScreenShots/Case4.10.1.0.png"));

		System.out.println("Passed. Individual Pharmacist Case 4.10.1.0");
		
	}

	@Test(priority = 17, groups = {"DLS", "Previous"})
	public void SubmitIndividualApp_Case41020() throws InterruptedException, IOException{
		
		//العقار عليه طلب سابق
		
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

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لوجود طلب إصدار رخصة صيدلية عامة على نفس العقار";

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
