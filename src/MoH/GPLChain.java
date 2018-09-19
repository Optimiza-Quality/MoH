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
		
		Thread.sleep(Const * 10);
		
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
		
		driver.findElement(NextToReviewChain).click();
		
		
	}
	
	@Test(priority = 1, enabled = true, groups = {"Full", "Redo"})
	public void SubmitChainApp_Case6000() throws InterruptedException, IOException{
	
		// ﬁœÌ„ «·ÿ·» »‰Ã«Õ
		
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
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
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
	
		//·œÌÂ Õ”«»
		
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
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
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
	
		//·œÌÂ ÿ·» „”»ﬁ
		
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
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
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
	
		//„⁄·Ê„«  €Ì— ’ÕÌÕ… - «·‘—ﬂ… €Ì— „ÊÃÊœ…
		
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
		String ExpectedResult = "—ﬁ„ ﬁÌœ «·„‰‘√… «·Êÿ‰Ì €Ì— „ÊÃÊœ";
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
	
		//„⁄·Ê„«  €Ì— ’ÕÌÕ… - —ﬁ„ «·‘—ﬂ… €Ì— „ÿ«»ﬁ
		
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
		
		String ExpectedResult = "—ﬁ„ ﬁÌœ «·„‰‘√… «·Êÿ‰Ì Ê—ﬁ„ «·‘—ﬂ… €Ì— „ÿ«»ﬁÌ‰";
		
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
	
		//«·‘—ﬂ… €Ì— ›⁄«·…
		
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
		String ExpectedResult = "€Ì— ›⁄«·…";
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
	
		//«·‘—ﬂ… ·Ì” ·Â« «”„  Ã«—Ì
		
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
		String ExpectedResult = "·⁄œ„ ÊÃÊœ «”„ «Ê ⁄·«„…  Ã«—Ì… „”Ã·… ··’Ìœ·Ì…";
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
	
		//⁄œ„ «” —Ã«⁄ «·«—ﬁ«„ «·Êÿ‰Ì… „‰ œ«∆—… „—«ﬁ»… «·‘—ﬂ« 
		
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
		String ExpectedResult = "·« Ì„ﬂ‰ﬂ ≈” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·⁄œ„ ≈” —Ã«⁄ Ã„Ì⁄ «·√—ﬁ«„ «·Êÿ‰Ì… ··‘—ﬂ«¡";
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
	
		//«Õœ «·‘—ﬂ«¡ €Ì— „‰ ”» ·‰ﬁ«»… «·’Ì«œ·…
		
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
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		
		String ExpectedResult = "‰ﬁ«»…";
		
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
	
		//«Õœ «·‘—ﬂ«¡ €Ì— „”œœ ·—”Ê„ «·‰ﬁ«»…
		
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
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		String ExpectedResult = "€Ì— „”œœ ··—”Ê„ «·„ — »… ⁄·ÌÂ ›Ì «·‰ﬁ«»…";
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
	
		//«Õœ «·‘—ﬂ«¡ ·Ì” ·œÌÂ —Œ’… „“«Ê·… „Â‰… ’Ìœ·…
		
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
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		String ExpectedResult = "€Ì— „“«Ê·";
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
	
		// «·‘—Ìﬂ €Ì— «·„”ƒÊ· ·œÌÂ —Œ’… „“«Ê·… „Â‰… ’Ìœ·… «ﬁ· „‰ 3 ”‰Ê« 
		
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
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		System.out.println("Actual Result: " + ActualResult);
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
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
		
		// «·‘—Ìﬂ «·„”ƒÊ· ·œÌÂ —Œ’… „“«Ê·… „Â‰… ’Ìœ·… «ﬁ· „‰ 3 ”‰Ê« 
		
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
		driver.findElement(PropertyNumber).sendKeys("411290418121", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		String ExpectedResult = "€Ì— „“«Ê· ··„Â‰… ·À·«À ”‰Ê«  ›√ﬂÀ—";
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
	
		// «·’Ìœ·Ì «·„· “„ Ì„ ·ﬂ ’Ìœ·Ì… «Œ—Ï
		
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
		driver.findElement(PropertyNumber).sendKeys("51298022318131", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		String ExpectedResult = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·«„ ·«ﬂ «·”Ìœ";
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
	
		//  «·’Ìœ·Ì «·„· “„ ﬂ«‰ Ì„ ·ﬂ ’Ìœ·Ì… «Œ—Ï ﬁ»· ”‰ Ì‰
		
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
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		String ExpectedResult = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·⁄œ„ „—Ê— ”‰ Ì‰ ⁄·Ï «·€«¡ „·ﬂÌ… «·”Ìœ";
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
	
		//  «·’Ìœ·Ì «·„· “„ €Ì— „ ›—€ „‰ «·÷„«‰
		
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
		driver.findElement(PropertyNumber).sendKeys("51298022318131", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		String ExpectedResult = "⁄œ„  ›—€";
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
	
		//  «·’Ìœ·Ì «·„· “„ €Ì— „ ›—€ „‰ «·’Õ…
		
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
		driver.findElement(PropertyNumber).sendKeys("51298022318131", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		String ExpectedResult = "Ì⁄„·";
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
	
		//  —ﬁ„ ÷„«‰ Œÿ√
		
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
		driver.findElement(PropertyNumber).sendKeys("51298022318131", Keys.TAB);
		
		Thread.sleep(Const * 8);
		
		driver.findElement(PharmCoordinates).sendKeys("45456");
				
		driver.findElement(PharmAddress).sendKeys("‘«—⁄ „ﬂ… - «·”·«„ 1 - ⁄„«—… 555");
		
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
		String ExpectedResult = "Œÿ√";
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
	
		//  —ﬁ„ ”‰œ  ”ÃÌ· ⁄ﬁ«— Œÿ√
		
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
		String ExpectedResult = "—ﬁ„ ”‰œ  ”ÃÌ· «·⁄ﬁ«— «·„œŒ· €Ì— ’ÕÌÕ";
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
	
		//  «·⁄ﬁ«— ›Ì «·⁄ﬁ»…
		
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
		String ExpectedResult = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·ÊÃÊœ «·⁄ﬁ«— ÷„‰ √—«÷Ì ”·ÿ… ≈ﬁ·Ì„ «·⁄ﬁ»…";
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
	
		//  «·⁄ﬁ«— ⁄·ÌÂ ÿ·»  —ŒÌ’
		
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
		String ExpectedResult = "ÿ·»";
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
	
		//  «·‘—ﬂ… €Ì— „”Ã·… ›Ì Ê“«—… «·’Õ… ﬂ”·”·… ’Ìœ·Ì« 
		
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
		String ExpectedResult = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·⁄œ„ ÊÃÊœ ”Ã· «·‘—ﬂ… ·”·”·… «·’Ìœ·Ì«  ›Ì Ê“«—… «·’Õ…";
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
	
		//  ⁄œœ «·‘—ﬂ«¡ «·„”Ã· ›Ì œ«∆—… „—«ﬁ»… «·‘—ﬂ«  €Ì— „ÿ«»ﬁ ·‰Ÿ«„ «·’Õ…
		
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
		String ExpectedResult = "⁄œœ «·‘—ﬂ«¡";
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
	
		//  ‘—ﬂ… ⁄œœ ›—Ê⁄Â« «—»⁄Ì‰ ›—⁄
		
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
		String ExpectedResult = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« · Ã«Ê“ ⁄œœ «·›—Ê⁄ «· Ì  ‰œ—Ã  Õ  ”·”·… «·’Ìœ·Ì«  40 ›—⁄";
		
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
	
		//  “Ì«œ… ⁄œœ «·›—Ê⁄ ⁄‰ ⁄œœ «·‘—ﬂ«¡
		
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
		String ExpectedResult = "‰Ÿ—« ·√‰ ⁄œœ «·√›—⁄ ›Ì ”·”·… «·’Ìœ·Ì«  ·« Ì”«ÊÌ ⁄œœ «·‘—ﬂ«¡";
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
