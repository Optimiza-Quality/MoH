package MoH;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
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

public class GPLChain extends GPLInternal{
	WebDriver driver;

	Integer Const = 400;

	@BeforeMethod(enabled = true, groups = {"StartChain"})
	public void GetDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ChromeDriver);
		driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\emasoud\\Desktop\\geckodriver.exe");
		// driver = new FirefoxDriver();
		//driver.get(ExternalTesting);
		
		driver.get(ExternalTesting);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
		//driver.findElement(ChangeLanguage).click();
		
		//Thread.sleep(Const * 4);
	}

	@BeforeMethod(enabled = false)
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

			// } else
			//
			// // Check if parameter passed from TestNG is 'IE'
			// if (browsername.equalsIgnoreCase("ie")) {
			// // create IE instance
			//
			// System.setProperty("webdriver.ie.driver",
			// IEDriver);
			// driver = new InternetExplorerDriver();
			// driver.manage().window().maximize();
			// driver.get(ExternalTesting);
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
			// MyFirefoxDriver");
			// driver = new FirefoxDriver();
			// driver.manage().window().maximize();
			// driver.get(ExternalTesting);
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		}
	}

	@AfterMethod(enabled = true,  groups = {"StartChain"})
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
				FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/" + result.getName() + ".png"));

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

	public void ApplyForType() throws InterruptedException{
		driver.findElement(Apply).click();
		
		Thread.sleep(Const * 2);
		
		Select userType = new Select(driver.findElement(AppType));
		userType.selectByIndex(3);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToBasicInfo).click();
		
		Thread.sleep(Const * 2);
		
	}
	
	public void Attachments() throws InterruptedException, IOException{
		Integer fileSize = 10; 
		driver.findElement(Resignation).click();
		Thread.sleep(Const * 2);
		Runtime.getRuntime().exec(JPGAtt);
		Thread.sleep(Const * fileSize);
		
		driver.findElement(Sketch).click();
		Thread.sleep(Const * 2);
		Runtime.getRuntime().exec(JPGAtt);
		Thread.sleep(Const * fileSize);
		
		driver.findElement(GAM).click();
		Thread.sleep(Const * 2);
		Runtime.getRuntime().exec(JPGAtt);
		Thread.sleep(Const * fileSize);
		
		driver.findElement(COSketch).click();
		Thread.sleep(Const * 2);
		Runtime.getRuntime().exec(JPGAtt);
		Thread.sleep(Const * fileSize);
		
		driver.findElement(Lease).click();
		Thread.sleep(Const * 2);
		Runtime.getRuntime().exec(JPGAtt);
		Thread.sleep(Const * fileSize);
		
		driver.findElement(NextToReviewChain).click();
		
		
	}
	
	@Test(priority = 1, enabled = true, groups = {"Full", "Redo"})
	public void SubmitChainApp_Case6000() throws InterruptedException, IOException{
	
		//تقديم الطلب بنجاح
		
		this.ApplyForType();
		//---------------------------Basic-Info---------------------------------------
		NationalIDValue = "200000329";
		driver.findElement(CoNationalNumber2).sendKeys(NationalIDValue);
		
		IDNumberValue = "2139";
		driver.findElement(CoNumber).sendKeys(IDNumberValue);
		
		Thread.sleep(Const);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
		
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code---------------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//---------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("91712108119104", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
		
		//---------------------------Attachments---------------------------------------
		
		this.Attachments();
		
		//---------------------------Review---------------------------------------
		driver.findElement(NextToReview).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(RateHappyAttachmentCases).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(NotesAttachmentCases).sendKeys("Happy");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(SubmitAttachmentCases).click();
		
		//----------------------Success-Message-----------------------------------
		Thread.sleep(Const * 20);

		
		
		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = SuccessMsg;
		System.out.println("Actual Result: " + ActualResult);
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.0.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.0.0.0");

		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
		
		//-------------------------------Processing---------------------------------------
		
		Round = 1;
		KeepAppNo = this.Processing_IncompleteByAudit_Case4140(AppNo, IrbidUserName1, IrbidPassword1, Round); 
		this.ViewApplicationAndModifyApp_Chain_Case6121(KeepAppNo, NationalIDValue, IDNumberValue);	
		
		Round = 2;
		this.Processing_ApproveByAudit_Case4100(KeepAppNo, IrbidUserName1, IrbidPassword1, Round);
		
		Round = 1;
		this.Processing_ApproveByJPA_Case4100_2(KeepAppNo, JPAUserName, JPAPassword, Round);
		this.Processing_AppointByIC_Case4100_3(KeepAppNo, IrbidUserName2, IrbidPassword2);
		this.Processing_ApproveByIC_Case4100_3(KeepAppNo, IrbidUserName2, IrbidPassword2, Round);
		this.Processing_ApproveByIC_Case4100_3(KeepAppNo, IrbidUserName3, IrbidPassword3, Round);
		this.Processing_ApproveByDirector_Case4100_4(KeepAppNo, IrbidUserName1, IrbidPassword1);
		this.ViewApplication_Chain_Case6101(KeepAppNo, NationalIDValue, IDNumberValue);
		
	}
	
	@Test(priority = 2, enabled = true, groups = {"Previous"})
	public void SubmitChainApp_Case6200() throws InterruptedException, IOException{
	
		//لديه حساب
		
		this.ApplyForType();
		//---------------------------Basic-Info---------------------------------------
		NationalIDValue = 	"200000329";	
		driver.findElement(CoNationalNumber2).sendKeys(NationalIDValue);
		
		IDNumberValue = "2139";
		driver.findElement(CoNumber).sendKeys(IDNumberValue);
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
		
		Thread.sleep(Const * 8);
		//----------------------------//Edit-Contact-Details----------------------------
		driver.findElement(ModifyContactDetails).click();
		
		this.EditContactDetails();
		//----------------------------------------Back-to-App---------------------------
		
		this.ApplyForType();
		
		Thread.sleep(Const * 2);
		
		driver.findElement(CoNationalNumber2).sendKeys(NationalIDValue);
		
		driver.findElement(CoNumber).sendKeys(IDNumberValue);
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code----------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//-----------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("917116018328101", Keys.TAB);
		
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
		
		//---------------------------Attachments---------------------------------------
		
		this.Attachments();
		
		//---------------------------Review---------------------------------------
		driver.findElement(NextToReview).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(RateHappyAttachmentCases).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(NotesAttachmentCases).sendKeys("Happy");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(SubmitAttachmentCases).click();
		
		//----------------------Success-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = SuccessMsg;
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.2.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.2.0.0 " + ActualResult);

		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
		
		//-------------------------------------Proccessing----------------------------
		Round = 1;
		
		KeepAppNo = this.Processing_IncompleteByAudit_Case4140(AppNo, IrbidUserName1, IrbidPassword1, Round);
		
		this.ViewApplicationAndModifyApp_Chain_Case6121(KeepAppNo, NationalIDValue, IDNumberValue);
		
		Round = 2;
		
		this.Processing_RejectByAudit_Case4130(KeepAppNo,IrbidUserName1,IrbidPassword1, Round);
		
		this.ViewApplicationAndRejection_Chain_Case6111(KeepAppNo, NationalIDValue, IDNumberValue);
	}

	@Test(priority = 3, enabled = true, groups = {"Previous", "Redo"})
	public void SubmitChainApp_Case6300() throws InterruptedException, IOException{
	
		//لديه طلب مسبق
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
		NationalIDValue = "200000329";
		driver.findElement(CoNationalNumber2).sendKeys(NationalIDValue);
		
		IDNumberValue = "2139";
		driver.findElement(CoNumber).sendKeys(IDNumberValue);
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToVerificationCode).click();
		
		//---------------------------Verification-Code----------------------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		
		//-----------------------------Other-Info---------------------------------------
		
		driver.findElement(PropertyNumber).sendKeys("41192013848122", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
		
		//---------------------------Attachments---------------------------------------
		this.Attachments();
		
		//---------------------------Review---------------------------------------
		driver.findElement(NextToReview).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(RateHappyAttachmentCases).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(NotesAttachmentCases).sendKeys("Happy");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(SubmitAttachmentCases).click();
		
		//----------------------Success-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = SuccessMsg;
		System.out.println("Actual Result: " + ActualResult);
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.3.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed.  Chain Pharmacy Case 6.3.0.0");
		
		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);
		

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page

		Round = 1;
		KeepAppNo = this.Processing_IncompleteByAudit_Case4140(AppNo, CapitalUserName1, CapitalPassword1, Round);
		this.ViewApplicationAndModifyApp_Chain_Case6121(KeepAppNo, NationalIDValue, IDNumberValue);
		Round = 2;
		this.Processing_ApproveByAudit_Case4100(KeepAppNo, CapitalUserName1, CapitalPassword1, Round);
		this.Processing_RejectByJPA_Case4110(KeepAppNo, JPAUserName, JPAPassword);
		
		this.ViewApplicationAndRejection_Chain_Case6111(KeepAppNo, NationalIDValue, IDNumberValue);
		
	}
	
	@Test(priority = 4, groups = {"CCD"})
	public void SubmitChainApp_Case6400() throws InterruptedException, IOException{
	
		//معلومات غير صحيحة - الشركة غير موجودة
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200000000");
		
		driver.findElement(CoNumber).sendKeys("2139");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,0)");
		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = CCDNonExist;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.4.0.0.png"));
		
		System.out.println("Passed. Chain Pharmacy Case 6.4.0.0");
		
	}
	
	@Test(priority = 4, groups = {"CCD", "Redo"})
	public void SubmitChainApp_Case6400_2() throws InterruptedException, IOException{
	
		//معلومات غير صحيحة - رقم الشركة غير مطابق
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200000329");
		
		driver.findElement(CoNumber).sendKeys("2439");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		
		System.out.println("Actual Result: " + ActualResult);
		
		String ExpectedResult = CCDMM;
		
		System.out.println("Expeccted Result: " + ExpectedResult);
		
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.4.0.0_2.png"));
		
		System.out.println("Passed. Chain Pharmacy Case 6.4.0.0_2");
	}
	
	@Test(priority = 5, groups = {"CCD"})
	public void SubmitChainApp_Case6410() throws InterruptedException, IOException{
	
		//الشركة غير فعالة
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200000326");
		
		driver.findElement(CoNumber).sendKeys("2136");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = CCDInactive;
		System.out.println("Actual Result: " + ActualResult);
		System.out.println("Expeccted Result: " + ExpectedResult);
		
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.4.1.0.png"));
		
		System.out.println("Passed. Chain Pharmacy Case 6.4.1.0");
	}

	@Test(priority = 5, enabled = true, groups = {"CCD"})
	public void SubmitChainApp_Case6420() throws InterruptedException, IOException{
	
		//الشركة ليس لها اسم تجاري
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200123456");
		
		driver.findElement(CoNumber).sendKeys("3456");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = CCDTradeMark;
		System.out.println("Actual Result: " + ActualResult);
		System.out.println("Expeccted Result: " + ExpectedResult);
		
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.4.2.0.png"));
		
		System.out.println("Passed. Chain Pharmacy Case 6.4.2.0");
	}

	@Test(priority = 5, groups = {"CCD"})
	public void SubmitChainApp_Case6450() throws InterruptedException, IOException{
	
		//عدم استرجاع الارقام الوطنية من دائرة مراقبة الشركات
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("213297846");
		
		driver.findElement(CoNumber).sendKeys("2140");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------

		Thread.sleep(Const * 5);
		
		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = CCDPartnersNN;
		System.out.println("Actual Result: " + ActualResult);
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.4.5.0.png"));
		
		System.out.println("Passed. Chain Pharmacy Case 6.4.5.0");
	}

	@Test(priority = 6,groups = {"JPA", "Redo"})
	public void SubmitChainApp_Case6500() throws InterruptedException, IOException{
	
		//احد الشركاء غير منتسب لنقابة الصيادلة
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200000328");
		
		driver.findElement(CoNumber).sendKeys("2138");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("2621007048112", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
		
		Thread.sleep(Const * 5);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
		
		Thread.sleep(Const * 5);
		
		String ActualResult = driver.findElement(ErrorMessage).getText();
		
		System.out.println("Actual Result: " + ActualResult);
		
		String ExpectedResult = JPAMembership;
		
		System.out.println("Expeccted Result: " + ExpectedResult);
		
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.5.0.0.png"));
		
		System.out.println("Passed. Chain Pharmacy Case 6.5.0.0");
	}

	@Test(priority = 6, groups = {"JPA"})
	public void SubmitChainApp_Case6510() throws InterruptedException, IOException{
	
		//احد الشركاء غير مسدد لرسوم النقابة
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200000327");
		
		driver.findElement(CoNumber).sendKeys("2137");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("2621007048112", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
		
		Thread.sleep(Const * 5);
		
		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = JPAFees;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.5.1.0.png"));
		
		System.out.println("Passed. Chain Pharmacy Case 6.5.1.0");
	}

	@Test(priority = 6, groups = {"VL"})
	public void SubmitChainApp_Case6600() throws InterruptedException, IOException{
	
		//احد الشركاء ليس لديه رخصة مزاولة مهنة صيدلة
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200000340");
		
		driver.findElement(CoNumber).sendKeys("2140");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 4);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 5);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("2621007048112", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
		
		Thread.sleep(Const * 5);
		
		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = Practicing;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.6.0.0.png"));
		
		System.out.println("Passed. Chain Pharmacy Case 6.6.0.0");
	
}
	
	@Test(priority = 6, groups = {"VL", "Redo"})
	public void SubmitChainApp_Case6600_2() throws InterruptedException, IOException{
	
		// الشريك غير المسؤول لديه رخصة مزاولة مهنة صيدلة اقل من 3 سنوات
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		NationalIDValue = "200008958"; 
		driver.findElement(CoNationalNumber2).sendKeys(NationalIDValue);
		
		IDNumberValue = "12345";
		driver.findElement(CoNumber).sendKeys(IDNumberValue);
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("2621007048112", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		Thread.sleep(Const * 8);
		driver.findElement(RadioButton).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
	//---------------------------Attachments---------------------------------------
		
		this.Attachments();
		
		//---------------------------Review---------------------------------------
		driver.findElement(NextToReview).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(RateHappyAttachmentCases).click();
		
		Thread.sleep(Const * 5);
		driver.findElement(NotesAttachmentCases).sendKeys("Happy");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(SubmitAttachmentCases).click();
		
		//----------------------Success-Message-----------------------------------
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = SuccessMsg;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.6.0.0_2.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.6.0.0_2");

		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
		
		//----------------------------Processing----------------------------------------------
		
		Round = 1; 
		KeepAppNo = this.Processing_ApproveByAudit_Case4100(AppNo, CapitalUserName1, CapitalPassword1, Round);
		this.Processing_IncompleteByJPA_Case4120_2(KeepAppNo, JPAUserName, JPAPassword, Round);
		this.ViewApplicationAndModifyApp_Chain_Case6121(KeepAppNo, NationalIDValue, IDNumberValue);
		
		Round = 2;
		this.Processing_ApproveByJPA_Case4100_2(KeepAppNo, JPAUserName, JPAPassword, Round);
		
		Round = 1;
		this.Processing_AppointByIC_Case4100_3(KeepAppNo, CapitalUserName1, CapitalPassword1);
		this.Processing_ApproveByIC_Case4100_3(KeepAppNo, CapitalUserName1, CapitalPassword1, Round);
		this.Processing_ApproveByIC_Case4100_3(KeepAppNo, CapitalUserName2, CapitalPassword2, Round);
		this.Processing_ApproveByDirector_Case4100_4(KeepAppNo, CapitalUserName2, CapitalPassword2);
		this.ViewApplication_Chain_Case6101(KeepAppNo, NationalIDValue, IDNumberValue);
	
}

	@Test(priority = 6, groups = {"VL"})
	public void SubmitChainApp_Case6610() throws InterruptedException, IOException{
		
		// الشريك المسؤول لديه رخصة مزاولة مهنة صيدلة اقل من 3 سنوات
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200000341");
		
		driver.findElement(CoNumber).sendKeys("2141");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("5127106199102", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(RadioButton).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = Practicing;
		System.out.println("Actual Result: " + ActualResult);
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.6.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.6.1.0");
			
	}
	
	@Test(priority = 7,groups = {"Own", "CommitmentChain", "Redo"})
	public void SubmitChainApp_Case6700() throws InterruptedException, IOException{
	
		// الصيدلي الملتزم مسؤول في فرع اخر
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200085457");
		
		driver.findElement(CoNumber).sendKeys("5457");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 10);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("51282022138112", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = Job;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.7.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.7.0.0");
			
	}

	@Test(priority = 7,groups = {"Own", "CommitmentChain", "Redo"})
	public void SubmitChainApp_Case6710() throws InterruptedException, IOException{
	
		//  الصيدلي الملتزم كان يمتلك صيدلية اخرى قبل سنتين
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200085458");
		
		driver.findElement(CoNumber).sendKeys("5458");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("4109509639123", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = PreviousOwnership;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.7.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.7.1.0");
			
	}
	
	@Test(priority = 8,groups = {"SS", "CommitmentChain"})
	public void SubmitChainApp_Case6800() throws InterruptedException, IOException{
	
		//  الصيدلي الملتزم غير متفرغ من الضمان
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200085466");
		
		driver.findElement(CoNumber).sendKeys("5466");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 10);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("51282022138112", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(RadioButton4).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = Job;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.8.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.8.0.0");
			
	}
	
	@Test(priority = 9,groups = {"MOH", "CommitmentChain", "Redo"})
	public void SubmitChainApp_Case6810() throws InterruptedException, IOException{
	
		//  الصيدلي الملتزم غير متفرغ من الصحة
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200085466");
		
		driver.findElement(CoNumber).sendKeys("5466");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("51282022138112", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(RadioButton3).click();
		Thread.sleep(Const * 8);

		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = Job;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.8.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.8.1.0");
			
	}

	@Test(priority = 9,groups = {"SS", "CommitmentChain", "Redo"})
	public void SubmitChainApp_Case6830() throws InterruptedException, IOException{
	
		//  رقم ضمان خطأ
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200000341");
		
		driver.findElement(CoNumber).sendKeys("2141");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("51282022138112", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys(PharmaAddress);
		
		Select holiday = new Select(driver.findElement(Hoiday));
		holiday.selectByIndex(1);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(RadioButton2).click();
		Thread.sleep(Const * 8);

		driver.findElement(EnterSSN).sendKeys("54545411");
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CheckBox).click();
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoNextToAttachemnts).click();
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = SSC;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.8.3.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.8.3.0");
			
	}
	
	@Test(priority = 10, groups = {"DLS"})
	public void SubmitChainApp_Case6900() throws InterruptedException, IOException{
	
		//  رقم سند تسجيل عقار خطأ
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200000341");
		
		driver.findElement(CoNumber).sendKeys("2141");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("917121081104", Keys.TAB);
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = PropertyNotExist;
		System.out.println("Actual Result: " + ActualResult);
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.9.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.9.0.0");
			
	}
	
	@Test(priority = 11, groups = {"DLS"})
	public void SubmitChainApp_Case6910() throws InterruptedException, IOException{
	
		//  العقار في العقبة
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200000341");
		
		driver.findElement(CoNumber).sendKeys("2141");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("346481107028112", Keys.TAB);
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = PropertyASEZA;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.9.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.9.1.0");
			
	}
	
	@Test(priority = 11, groups = {"DLS", "Previous", "Redo"})
	public void SubmitChainApp_Case6920() throws InterruptedException, IOException{
	
		//  العقار عليه طلب ترخيص
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("200000341");
		
		driver.findElement(CoNumber).sendKeys("2141");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
		driver.findElement(PropertyNumber).sendKeys("91712108119104", Keys.TAB);
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = PropertyExist;
		System.out.println("Actual Result: " + ActualResult);
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.9.2.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.9.2.0");
			
	}

	@Test(priority = 12,groups = {"MOH", "Chain"})
	public void SubmitChainApp_Case61000() throws InterruptedException, IOException{
	
		//  الشركة غير مسجلة في وزارة الصحة كسلسلة صيدليات
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("213294151");
		
		driver.findElement(CoNumber).sendKeys("4151");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = ChainNotRegistered;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.10.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.10.0.0");
			
	}

	@Test(priority = 13,groups = {"MOH", "Chain"})
	public void SubmitChainApp_Case61010() throws InterruptedException, IOException{
	
		//  عدد الشركاء المسجل في دائرة مراقبة الشركات غير مطابق لنظام الصحة
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("213294152");
		
		driver.findElement(CoNumber).sendKeys("4152");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = CCDMOHPartners;
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.10.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.10.1.0");
			
	}

	@Test(priority = 14,groups = {"MOH", "Chain"})
	public void SubmitChainApp_Case61100() throws InterruptedException, IOException{
	
		//  شركة عدد فروعها اربعين فرع
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("213294153");
		
		driver.findElement(CoNumber).sendKeys("4153");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = BranchesNumber;
		
		System.out.println("Actual Result: " + ActualResult);
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.11.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.11.0.0");
			
	}

	@Test(priority = 14, groups = {"MOH", "Chain"})
	public void SubmitChainApp_Case61110() throws InterruptedException, IOException{
	
		//  زيادة عدد الفروع عن عدد الشركاء
		
		this.ApplyForType();
		
		//---------------------------Basic-Info---------------------------------------
				
		driver.findElement(CoNationalNumber2).sendKeys("213294154");
		
		driver.findElement(CoNumber).sendKeys("4154");
		
		Thread.sleep(Const * 8);

		driver.findElement(Captcha2).sendKeys("4568", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(CoVerify).click();
			
		Thread.sleep(Const * 8);
		
		try {

			driver.findElement(CoMobileNo).sendKeys("797352297"); // Mobile-Number

			driver.findElement(CoEmail).sendKeys("emasoud@optimizasolutions.com", Keys.TAB); // Email

			Thread.sleep(Const * 10);
			
		} catch (Exception e) {// do nothing

		}
		
		driver.findElement(NextToVerificationCode).click();
		//----------------------Verification-Code----------------------
		
		driver.findElement(VerificationCode).sendKeys("0000", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(NextToOtherInfo).click();
		//-------------------------Other-Info-Screen-----------------------
	
		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = BranchesPartners;
		System.out.println("Actual Result: " + ActualResult);
		System.out.println("Expeccted Result: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.11.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Chain Pharmacy Case 6.11.1.0");
			
	}

	@Test(groups = {"StartChain"})
	public void fake() {
	//do
	}
}
