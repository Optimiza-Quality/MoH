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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RNVLJordanian extends RNVLInternal {

	WebDriver driver;

	Integer Const = 500;
	
	public static String AppNo;
	
	public static String KeepAppNo;
	
	public String NationalIDValue;
	
	public String IDNumberValue;
	
	public String CatchError (String AppNo) throws InterruptedException, IOException{
	
		driver.navigate().refresh();
			
		Thread.sleep(Const+ 200);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(ReGraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

		Thread.sleep(Const + 200);
		
		// Degree
		Select Degree = new Select(driver.findElement(ReDegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		driver.findElement(ReNextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(ReUploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_3-PNG\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		driver.findElement(ReNextToReviewAttachmentCases).click();

		// ---------------------------------Review-Section----------------------------

		driver.findElement(ReNextToSubmitAttachmentCases).click(); // Next-Button

		// ---------------------------------Rate-and-Submit--------------------------

		Thread.sleep(Const * 10);
		driver.findElement(ReRateSadAttachmentCases).click(); // Rate-Sad

		Thread.sleep(Const * 10);
		driver.findElement(ReNotesAttachmentCases).sendKeys("Õ“Ì‰"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(ReSubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Metigation.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse Metigation");
		
		AppNo = driver.findElement(ReApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(ReBackToHomeAttachmentCases).click(); // Home-Page
		
		return AppNo;
	}
	
		@BeforeMethod(enabled = true, groups = {"Start"})
	public void GetDriver() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();
		
		
		// System.setProperty("webdriver.ie.driver","C:\\Users\\emasoud\\Desktop\\IEDriverServer.exe");
		 //driver = new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("https://ohs-vip:4443/public/index.html");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//driver.findElement(By.id("overridelink")).click();
		
		//driver.findElement(ChangeLanguage).click();
		
		//Thread.sleep(Const);
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

			 } else
			
			// // Check if parameter passed from TestNG is 'IE'
				 if (browsername.equalsIgnoreCase("ie")) {
			// // create IE instance
			//
			 System.setProperty("webdriver.ie.driver","C:\\Users\\emasoud\\Desktop\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			 driver.manage().window().maximize();
			 driver.get("https://ohs-vip:4443/public/index.html");
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.findElement(By.id("overridelink")).click();
			//
			Thread.sleep(2000);
			// } else
			
			// // Check if parameter passed from TestNG is 'firefox'
			// if (browsername.equalsIgnoreCase("firefox")) {
			// // create firefox instance
			//
			// System.setProperty("webdriver.gecko.driver",
			// "C:\\Users\\emasoud\\Desktop\\geckodriver.exe");
			// driver = new FirefoxDriver();
			// driver.manage().window().maximize();
			// driver.get("https://ohs-vip:4443/public/index.html");
			// driver.manage().timeouts().implicitlyWait(30,
			// TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(30,
			// TimeUnit.SECONDS);

		}
	}

	@AfterMethod(enabled =true, groups = {"Start"})
	public void End(ITestResult result) throws InterruptedException {
		// Here will compare if test is failing then only it will enter into
		// if
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
				FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));

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

	@Test(priority = 1, enabled=true, groups = {"Success", "Full"}, retryAnalyzer = MoH.RetryAnalyzer.class)
	public void SubmitNursingApp_Jordanian_Case1000() throws InterruptedException, IOException {

		//  ﬁœÌ„ «·ÿ·» »‰Ã«Õ - »Ì«‰«  ’ÕÌÕ…
		// «·„Ê«›ﬁ… ⁄·Ï «·ÿ·»
	
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);

		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		NationalIDValue = "9782007189";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue = "YRA61028";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("61316"); // Association-Number

		driver.findElement(Captcha).sendKeys("8587"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		} catch (Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 5);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");

		Thread.sleep(Const);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2015"); // Graduation-Year

		Thread.sleep(Const);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234638", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button
		
		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button
			
		// ------------------------------Rate-and-Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys("”⁄Ìœ"); // Notes

		Thread.sleep(Const * 5);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult);
				
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.0.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse Case 1.0.0.0");

		AppNo = driver.findElement(ApplicationNumberGeneralCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

		KeepAppNo = this.Processing_ApproveByHead_Case1100(AppNo);

		this.Processing_ApproveByDirector_Case1100_2(KeepAppNo);

		ViewApplicationAndLicense_Jordanain_Case1101(KeepAppNo, NationalIDValue, IDNumberValue);
		
		
	}

		@Test(priority = 2, enabled = true, groups = {"Success", "Full"}, retryAnalyzer = MoH.RetryAnalyzer.class)
	public void SubmitNursingApp_Jordanian_Case1200() throws InterruptedException, IOException {

		// «·„” Œœ„ ﬁ«„ »«‰‘«¡ Õ”«» Ê·„ Ì „ ⁄„·Ì…  ﬁœÌ„ «·ÿ·»
		// —›÷ „œÌ— «·„œÌ—Ì…
		
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------

		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------
		NationalIDValue = "9882013944";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue = "DIP68802";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("1234"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 10);

		// Screenshot for Initial Contact Details

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.2.0.0_Initial_Contact_Detials.png"));

		// --------------------------------Edit-Contact-Details---------------------------------
		driver.findElement(ModifyContactDetails).click(); // Edit-Contact-Details-Link
		this.EditContactDetails();
		// -------------------------Go-Back-To-Application-Form---------------------------------

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appTypeAgain = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type
		appTypeAgain.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID
		
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("1234"); // Association-Number

		driver.findElement(Captcha).sendKeys("0090"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 10);

		// Screenshot for Updated Contact Details

		TakesScreenshot ts2 = (TakesScreenshot) driver;
		File source2 = ts2.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source2, new File("./ScreenShots/Case1.2.0.0_Updated_Contact_Detials.png"));

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian-Inside

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 8);

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");

		Thread.sleep(Const);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2012"); // Graduation-Year

		Thread.sleep(Const);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234856", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate-and-Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateNeutralGeneralCases).click(); // Rate-Neutral

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys("„Õ«Ìœ"); // Notes

		Thread.sleep(Const * 20);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		System.out.println("Expected Message: " + ExpectedResult);
		System.out.println("Actual Message: " + ActualResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts3 = (TakesScreenshot) driver;
		File source3 = ts3.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source3, new File("./ScreenShots/Case1.2.0.0.png"));

		// --------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse Case 1.2.0.0");

		AppNo = driver.findElement(ApplicationNumberGeneralCases).getText();

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

		KeepAppNo = this.Processing_ApproveByHead_Case1100(AppNo);
		this.Processing_RejectByDirector_Case1110(KeepAppNo);
		
		this.ViewApplicationAndRejection_Jordanain_Case1111(KeepAppNo, NationalIDValue, IDNumberValue);

	}
		
	@Test(priority = 3, enabled = true, groups = {"Previous"})
	public void SubmitNursingApp_Jordanian_Case1420() throws InterruptedException, IOException {

		// «·„” Œœ„ ﬁ«„ » ﬁœÌ„ ÿ·» ”«»ﬁ Ê „  «·„Ê«›ﬁ… ⁄·ÌÂ

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9782007189"); // National-ID

		driver.findElement(IDNumber).sendKeys("YRA61028"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("61316"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·ÊÃÊœ  ’—ÌÕ „“«Ê·… „Â‰… „„—÷ ﬁ«‰Ê‰Ì ”«»ﬁ";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.4.2.0.png"));

		System.out.println("Passed. Jordanian Nurse Case 1.4.2.0");

	}

	@Test(priority = 4, enabled = true, groups = {"Previous"})
	public void SubmitNursingApp_Jordanian_Case1400() throws InterruptedException, IOException {

		// «·„” Œœ„ Õ«’· ⁄·Ï —Œ’… „“«Ê·… „Â‰…

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9842006777"); // National-ID

		driver.findElement(IDNumber).sendKeys("IMX30305"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("19056"); // Association-Number

		driver.findElement(Captcha).click();

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual: " + ActualErrorMessage);

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·ÊÃÊœ  ’—ÌÕ „“«Ê·… „Â‰… „„—÷ ﬁ«‰Ê‰Ì ”«»ﬁ. ·„“Ìœ „‰ «·„⁄·Ê„«  Ì—ÃÏ «·≈ ’«· ⁄·Ï «·Œÿ «·”«Œ‰ ·Ê“«—… «·’Õ… 065004545";

		System.out.println("Expected: " + ExpectedErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.4.0.0.png"));

		System.out.println("Passed. Jordanian Nurse 1.4.0.0");

	}

	@Test(priority = 4, enabled = true, groups = {"Previous"})
	public void SubmitNursingApp_Jordanian_Case1410() throws InterruptedException, IOException {

		// «·„” Œœ„ Õ«’· ⁄·Ï —Œ’… „“«Ê·… „Â‰… „‰ «·Œœ„«  «·ÿ»Ì…

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("7411325533"); // National-ID

		driver.findElement(IDNumber).sendKeys("7799266"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("10224"); // Association-Number

		driver.findElement(Captcha).click();

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual: " + ActualErrorMessage);

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·ÊÃÊœ  ’—ÌÕ „“«Ê·… „Â‰… „„—÷ ﬁ«‰Ê‰Ì ”«»ﬁ";
		System.out.println("Expected: " + ExpectedErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.4.1.0.png"));

		System.out.println("Passed. Jordanian Nurse 1.4.1.0");

	}

	@Test(priority = 5, enabled = true, groups = {"CSPD"})
	public void SubmitNursingApp_Jordanian_Case1500() throws InterruptedException, IOException {

		// Œÿ√ ›Ì „⁄·Ê„«  «·√ÕÊ«· - «·»Ì«‰«  €Ì— „ÿ«»ﬁ…

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9842006777"); // National-ID

		driver.findElement(IDNumber).sendKeys("IMX30385"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("19056"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "«·—ﬁ„ «·Êÿ‰Ì Ê—ﬁ„ «·ÂÊÌ… €Ì— „ÿ«»ﬁÌ‰° Ì—ÃÏ «· √ﬂœ „‰ ’Õ… «·√—ﬁ«„ «·„œŒ·…";
		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.5.0.0.png"));

		System.out.println("Passed. Jordanian Nurse 1.5.0.0");

	}

	@Test(priority = 5, enabled = true, groups = {"CSPD"})
	public void SubmitNursingApp_Jordanian_Case1500_2() throws InterruptedException, IOException {

		// Œÿ√ ›Ì „⁄·Ê„«  «·√ÕÊ«· - «·‘Œ’ „ Ê›Ì

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9652023349"); // National-ID

		driver.findElement(IDNumber).sendKeys("5882628"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("1709"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "«·—ﬁ„ «·Êÿ‰Ì «·„œŒ· ·‘Œ’ „ Ê›Ì";

		System.out.println("Expected: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.5.0.0_2.png"));

		System.out.println("Passed. Jordanian Nurse 1.5.0.0_2");

	}

	@Test(priority = 6, groups = {"CSPD"})
	public void SubmitNursingApp_Jordanian_Case1510() throws InterruptedException, IOException {

		// Œÿ√ ›Ì „⁄·Ê„«  «·√ÕÊ«· - «·ÂÊÌ… „‰ ÂÌ… «·’·«ÕÌ…

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9762030643"); // National-ID

		driver.findElement(IDNumber).sendKeys("BSF31951"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("5630"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·≈‰ Â«¡ ’·«ÕÌ… «·ÂÊÌ…° Ì—ÃÏ „—«Ã⁄… œ«∆—… «·√ÕÊ«· «·„œ‰Ì… · ÃœÌœ «·ÂÊÌ…";

		System.out.println("Exoected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.5.1.0.png"));

		System.out.println("Passed. Jordanian Nurse 1.5.1.0");

	}

	@Test(priority = 8, groups = {"High", "Full"})
	public void SubmitNursingApp_Jordanian_Case1600() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·À«‰ÊÌ…
		// Missing GPA
		// Upload jpg file

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		NationalIDValue = "9791051994";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue="11624403";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("7196"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian
		
		Thread.sleep(Const);
		
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");
		// University.selectByIndex(139); // Jordanian-University

		Thread.sleep(Const*2);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

		Thread.sleep(Const*2);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor
		
		Thread.sleep(Const);

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234594", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(UploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		driver.findElement(NextToReviewAttachmentCases).click();

		// ---------------------------------Review-Section----------------------------
	
		driver.findElement(NextToSubmitAttachmentCases).click(); // Next-Button

		// ---------------------------------Rate-and-Submit--------------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateSadAttachmentCases).click(); // Rate-Sad

		Thread.sleep(Const * 10);
		driver.findElement(NotesAttachmentCases).sendKeys("Õ“Ì‰"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0 " + ActualResult);

		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page

	
		KeepAppNo= this.Processing_ApproveByHead_Case1100(AppNo);
	
		this.Processing_IncompleteByDirector_Case1120(KeepAppNo);
		
		ViewApplicationAndModifyApp_Jordanain_Case1121(KeepAppNo, NationalIDValue, IDNumberValue);//Modify
		
		this.Processing_ApproveByDirector_Case1100_3(KeepAppNo);
		
		ViewApplicationAndLicense_Jordanain_Case1101(KeepAppNo, NationalIDValue, IDNumberValue);//View
		

	}

	@Test(priority = 7, enabled = true, groups = {"High", "Full"})
	public void SubmitNursingApp_Jordanian_Case1600_2() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·À«‰ÊÌ…
		// Missing Certificate Year
		// Upload jpeg file 1.87 MB

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		NationalIDValue = "9761043963";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue = "11704349";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("5503"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 4);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");
		// University.selectByIndex(139); // Jordanian-University

		Thread.sleep(Const);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year
		
		Thread.sleep(Const);

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234581", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(UploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_2 - jpeg\\Uploader2.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		driver.findElement(NextToReviewAttachmentCases).click();

		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitAttachmentCases).click(); // Next-Button

		// ---------------------------------Rate-and-Submit--------------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateSadAttachmentCases).click(); // Rate-Sad

		Thread.sleep(Const * 10);
		driver.findElement(NotesAttachmentCases).sendKeys("Õ“Ì‰"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		System.out.println("Actual Message: " + ActualResult);
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		System.out.println("Expected Message: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_2.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_2");
		
		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
	
		KeepAppNo= this.Processing_ApproveByHead_Case1100(AppNo);
	
		this.Processing_IncompleteByDirector_Case1120(KeepAppNo);
		
		ViewApplicationAndModifyApp_Jordanain_Case1121(KeepAppNo, NationalIDValue, IDNumberValue);//Modify
		
		this.Processing_IncompleteByDirector_Case1120_2(KeepAppNo);
		
		ViewApplicationAndModifyApp_Jordanain_Case1121(KeepAppNo, NationalIDValue, IDNumberValue);//Modify
		
		this.Processing_ApproveByDirector_Case1100_3(KeepAppNo);
		
		ViewApplicationAndLicense_Jordanain_Case1101(KeepAppNo, NationalIDValue, IDNumberValue);//View

	}

	@Test(priority = 7, enabled= true ,groups = {"High", "Full"})
	public void SubmitNursingApp_Jordanian_Case1600_3() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·À«‰ÊÌ…
		// Missing Branch Code
		// Upload file PNG
		// €Ì— «—œ‰Ì œ«Œ· «·«—œ‰ 

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------
		NationalIDValue = "9811009627";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue = "TDT14511";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("9297"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(2); // Non-Jordanian-Inside

		Thread.sleep(Const * 3);
		
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		
//		// Semester
//		Select Semester = new Select(driver.findElement(SemesterDDL));
//		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");
		// University.selectByIndex(139); // Jordanian-University

		Thread.sleep(Const+ 200);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

		Thread.sleep(Const + 200);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234613", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		try {
		driver.findElement(UploadSchoolCertificate).click();
	
		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_3-PNG\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		driver.findElement(NextToReviewAttachmentCases).click();

		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitAttachmentCases).click(); // Next-Button

		// ---------------------------------Rate-and-Submit--------------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateSadAttachmentCases).click(); // Rate-Sad

		Thread.sleep(Const * 10);
		driver.findElement(NotesAttachmentCases).sendKeys("Õ“Ì‰"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_3.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_3");
		
		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
		
		}
		
		catch(Exception e){
			
			AppNo=this.CatchError(AppNo);
		}
		
		
		KeepAppNo = this.Processing_IncompleteByHead_Case1140(AppNo);
		
		ViewApplicationAndModifyApp_Jordanain_Case1121(KeepAppNo, NationalIDValue, IDNumberValue);//Modify
		
		this.Processing_IncompleteByHead_Case1140_2(KeepAppNo);
		
		ViewApplicationAndModifyApp_Jordanain_Case1121(KeepAppNo, NationalIDValue, IDNumberValue);//Modify
		
		this.Processing_ApproveByHead_Case1100_2(KeepAppNo);
	
		this.Processing_IncompleteByDirector_Case1120(KeepAppNo);
		
		ViewApplicationAndModifyApp_Jordanain_Case1121(KeepAppNo, NationalIDValue, IDNumberValue);//Modify
		
		this.Processing_IncompleteByDirector_Case1120_2(KeepAppNo);
		
		ViewApplicationAndModifyApp_Jordanain_Case1121(KeepAppNo, NationalIDValue, IDNumberValue);//Modify
		
		this.Processing_ApproveByDirector_Case1100_3(KeepAppNo);
		
		ViewApplicationAndLicense_Jordanain_Case1101(KeepAppNo, NationalIDValue, IDNumberValue);//View


	}

	
	@Test(priority = 7, enabled = true,  groups = {"High", "Full"})
	public void SubmitNursingApp_Jordanian_Case1600_4() throws InterruptedException, IOException {

		// €Ì— «—œ‰Ì Œ«—Ã «·«—œ‰
		// «” ﬂ„«· ‰Ê«ﬁ’ - »Ì«‰«  «Œ—Ï

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		NationalIDValue = "9861004148";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue = "GCV20876";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("14382"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(3); // Non-Jordanian-Outside
		
		Thread.sleep(Const * 5);
		
		//High-School-Country
		Select HighSchoolCount = new Select(driver.findElement(HighSchoolCountry));
		HighSchoolCount.selectByIndex(7);
 
		Thread.sleep(Const * 2);
		
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");
		// University.selectByIndex(139); // Jordanian-University

		Thread.sleep(Const+200);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

		Thread.sleep(Const+200);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234626", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button
	
		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button
	
		// ---------------------------------Rate-and-Submit--------------------------
		
		Thread.sleep(Const * 10);
		driver.findElement(RateSadGeneralCases).click(); // Rate-Sad

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys("Õ“Ì‰"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		System.out.println("Actual Message: " + ActualResult);
		//System.out.println("Expected Message: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_4.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_4");
		
		AppNo = driver.findElement(ApplicationNumberGeneralCases).getText();
		
		System.out.println("App No: " + AppNo);

		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page
		
		
		KeepAppNo = this.Processing_IncompleteByHead_Case1140(AppNo);
		
		this.ViewApplicationAndModifyAppOther_Jordanain_Case1121_1(KeepAppNo, NationalIDValue, IDNumberValue);
		
		this.Processing_ApproveByHead_Case1100_2(KeepAppNo);
		this.Processing_ApproveByDirector_Case1100_2(KeepAppNo);
		
		this.ViewApplicationAndLicense_Jordanain_Case1101(KeepAppNo, NationalIDValue, IDNumberValue);

	}


	@Test(priority = 7, enabled = true, groups = {"High", "Full"})
	public void SubmitNursingApp_Jordanian_Case1600_5() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·À«‰ÊÌ…
		// Missing Certificate Country
		// upload JPG file 1.99 MB

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------
		NationalIDValue = "9691037561";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue = "IZZ18429";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("3055"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");
		// University.selectByIndex(139); // Jordanian-University

		Thread.sleep(Const);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year
		
		Thread.sleep(Const);

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234566", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(UploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_5-jpg\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		driver.findElement(NextToReviewAttachmentCases).click();

		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitAttachmentCases).click(); // Next-Button

		// ---------------------------------Rate-and-Submit--------------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateSadAttachmentCases).click(); // Rate-Sad

		Thread.sleep(Const * 10);
		driver.findElement(NotesAttachmentCases).sendKeys("Õ“Ì‰"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_5.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_5");

		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page

		KeepAppNo = this.Processing_RejectByHead_Case1130(AppNo);
		
		this.ViewApplicationAndRejection_Jordanain_Case1111(KeepAppNo, NationalIDValue, IDNumberValue);
	}


	@Test(priority = 7, enabled = false)
	public void SubmitNursingApp_Jordanian_Case1600_6() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·À«‰ÊÌ…
		// Missing Certificate Country Description

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9791000918"); // National-ID

		driver.findElement(IDNumber).sendKeys("DYD93618"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("7637"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");
		// University.selectByIndex(139); // Jordanian-University

		Thread.sleep(Const);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year
		
		Thread.sleep(Const);

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234600", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(UploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		driver.findElement(NextToReviewAttachmentCases).click();

		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitAttachmentCases).click(); // Next-Button

		// ---------------------------------Rate-and-Submit--------------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateSadAttachmentCases).click(); // Rate-Sad

		Thread.sleep(Const * 10);
		driver.findElement(NotesAttachmentCases).sendKeys("Õ“Ì‰"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_6.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_6");

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page

	}

	
	@Test(priority = 7, groups = {"High", "Full"})
	public void SubmitNursingApp_Jordanian_Case1600_7() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·À«‰ÊÌ… „‰ „⁄·Ê„«  ÊÀÌﬁ… «·„⁄«œ·…

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------
		NationalIDValue="9841018602";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue="11103774";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("11636"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("›—‰”«");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("Centre International de Recontre Mathematiques");

		Thread.sleep(Const * 10);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2005"); // Graduation-Year

		Thread.sleep(Const);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// Equivalence-Letter
		driver.findElement(EquivalenceLetter).sendKeys("12345");

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234621", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(UploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		driver.findElement(NextToReviewAttachmentCases).click();

		// ---------------------------------Review-Section----------------------------
	
		driver.findElement(NextToSubmitAttachmentCases).click(); // Next-Button

		// ---------------------------------Rate-and-Submit--------------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateSadAttachmentCases).click(); // Rate-Sad

		Thread.sleep(Const * 10);
		driver.findElement(NotesAttachmentCases).sendKeys("Õ“Ì‰"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		
		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);


		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_7.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_7 " + ActualResult);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
		
		KeepAppNo = this.Processing_RejectByHead_Case1130(AppNo);
			
		this.ViewApplicationAndRejection_Jordanain_Case1111(KeepAppNo, NationalIDValue, IDNumberValue);

	}

	
	@Test(priority = 7, groups = {"High"})
	public void SubmitNursingApp_Jordanian_Case1600_8() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·À«‰ÊÌ…
		// Missing GPA
		// Upload doc file

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9791051994"); // National-ID

		driver.findElement(IDNumber).sendKeys("11624403"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("7196"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");
		// University.selectByIndex(139); // Jordanian-University

		Thread.sleep(Const);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year
		
		Thread.sleep(Const);

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234594", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(UploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_8-doc\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = "«·„·›«  «·„”„ÊÕ »Â« „‰ ‰Ê⁄";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_8.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_8 " + ActualResult);

	}

	
	@Test(priority = 7, groups = {"High"})
	public void SubmitNursingApp_Jordanian_Case1600_9() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·À«‰ÊÌ…
		// Missing GPA
		// Upload rar file

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9791051994"); // National-ID

		driver.findElement(IDNumber).sendKeys("11624403"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("7196"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");
		// University.selectByIndex(139); // Jordanian-University
		
		Thread.sleep(Const);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

		Thread.sleep(Const);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234594", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(UploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_9-zip\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = "«·„·›«  «·„”„ÊÕ »Â« „‰ ‰Ê⁄";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_9.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_9 " + ActualResult);

	}

	
	@Test(priority = 7, enabled = true, groups = {"High"})
	public void SubmitNursingApp_Jordanian_Case1600_10() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·À«‰ÊÌ…
		// Missing GPA
		// Upload exe file

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9791051994"); // National-ID

		driver.findElement(IDNumber).sendKeys("11624403"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("7196"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");
		// University.selectByIndex(139); // Jordanian-University

		Thread.sleep(Const);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

		Thread.sleep(Const);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234594", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(UploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_10-exe\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = "«·„·›«  «·„”„ÊÕ »Â« „‰ ‰Ê⁄";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_10.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_10" + ActualResult);

	}


	@Test(priority = 7, enabled = true, groups = {"High"})
	public void SubmitNursingApp_Jordanian_Case1600_11() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·À«‰ÊÌ…
		// Missing GPA
		// Upload gif file

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9791051994"); // National-ID

		driver.findElement(IDNumber).sendKeys("11624403"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("7196"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 5);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");
		// University.selectByIndex(139); // Jordanian-University

		Thread.sleep(Const);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year
		
		Thread.sleep(Const);

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234594", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(UploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_11-gif\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = "«·„·›«  «·„”„ÊÕ »Â« „‰ ‰Ê⁄";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_11.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_11" + ActualResult);

	}

	
	@Test(priority = 7, groups = {"High"})
	public void SubmitNursingApp_Jordanian_Case1600_12() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·À«‰ÊÌ…
		// Missing GPA
		// Upload too large file

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9791051994"); // National-ID

		driver.findElement(IDNumber).sendKeys("11624403"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("7196"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (Exception e) {// do nothing
		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");
		
		Thread.sleep(Const);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

		Thread.sleep(Const);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234594", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(UploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_12-JPG - large\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(ErrorMessage).getText();
		String ExpectedResult = "«·„·›«  «·„”„ÊÕ »Â«";
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_12.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_12");

	}


	@Test(priority = 8, groups = {"Uni"})
	public void SubmitNursingApp_Jordanian_Case1700() throws InterruptedException, IOException {

		// ⁄œ„ «” —Ã«⁄ „⁄·Ê„«  «·»ﬂ«·Ê—ÌÊ”
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9872003176"); // National-ID

		driver.findElement(IDNumber).sendKeys("PJX99004"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("19728"); // Association-Number

		driver.findElement(Captcha).sendKeys("9999"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {
			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 10);

		} catch (Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("Ã«„⁄… „ƒ Â");

		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234637", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		Thread.sleep(Const * 10);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·⁄œ„ ≈” —Ã«⁄ „⁄·Ê„«  «·»ﬂ«·Ê—ÌÊ”° Ì—ÃÏ „—«Ã⁄… Ê“«—… «· ⁄·Ì„ «·⁄«·Ì Ê«·»ÕÀ «·⁄·„Ì · ’ÊÌ» «·√Ê÷«⁄";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.0.0");

	}

	
	@Test(priority = 9, groups = {"Uni"})
	public void SubmitNursingApp_Jordanian_Case1700_2() throws InterruptedException, IOException {

		// ⁄œ„  ÿ«»ﬁ „⁄·Ê„«  «·»ﬂ«·Ê—ÌÊ”
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9872003176"); // National-ID

		driver.findElement(IDNumber).sendKeys("PJX99004"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("19728"); // Association-Number

		driver.findElement(Captcha).sendKeys("9999"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {
			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 10);
		} catch (Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("Ã«„⁄… „ƒ Â");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2006"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234637", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		Thread.sleep(Const * 10);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "„⁄·Ê„«  «·»ﬂ«·Ê—ÌÊ” «·„œŒ·… €Ì— ’ÕÌÕ…. ·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·». ·„“Ìœ „‰ «·„⁄·Ê„«  Ì—ÃÏ «·≈ ’«· ⁄·Ï «·Œÿ «·”«Œ‰ ·Ê“«—… «·’Õ…";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.0.0_2.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.0.0_2");

	}

	
	@Test(priority = 9, groups = {"Uni"})
	public void SubmitNursingApp_Jordanian_Case1700_3() throws InterruptedException, IOException {

		// ⁄œ„  ÿ«»ﬁ „⁄·Ê„«  «·»ﬂ«·Ê—ÌÊ” - «·Ã«„⁄…

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);

		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9872003176"); // National-ID

		driver.findElement(IDNumber).sendKeys("PJX99004"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("19728"); // Association-Number

		driver.findElement(Captcha).sendKeys("9999"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {
			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 10);
		} catch (Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");

		Thread.sleep(Const);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		Thread.sleep(Const);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC--------

		driver.findElement(NCRC).sendKeys("1234637", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		Thread.sleep(Const * 10);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "„⁄·Ê„«  «·»ﬂ«·Ê—ÌÊ” «·„œŒ·… €Ì— ’ÕÌÕ…. ·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·». ·„“Ìœ „‰ «·„⁄·Ê„«  Ì—ÃÏ «·≈ ’«· ⁄·Ï «·Œÿ «·”«Œ‰ ·Ê“«—… «·’Õ…";
		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.0.0_3.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.0.0_3");

	}

	
	@Test(priority = 10, groups = {"Uni", "Full"})
	public void SubmitNursingApp_Jordanian_Case1710() throws InterruptedException, IOException {

		//  Œ—Ã „‰ ﬂ·Ì… „‰Ï ﬁ»· 1999

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		NationalIDValue="9831038134";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue="9836521";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("14374"); // Association-Number

		driver.findElement(Captcha).sendKeys("0440"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 2);

		} catch (Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("ﬂ·Ì… «·«„Ì—… „‰Ï ·· „—Ì÷");
		// University.selectByIndex(139); // Jordanian-University

		Thread.sleep(Const + 200);
		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("1998"); // Graduation-Year

		Thread.sleep(Const+200);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234625", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate-and-Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 15);

		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.1.0 " + ActualResult);

		AppNo = driver.findElement(ApplicationNumberGeneralCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

		KeepAppNo = this.Processing_IncompleteByHead_Case1140(AppNo);
		
		ViewApplicationAndModifyAppOther_Jordanain_Case1121_1(KeepAppNo, NationalIDValue, IDNumberValue);//Modify
		
		this.Processing_ApproveByHead_Case1100_2(AppNo);
		
		this.Processing_IncompleteByDirector_Case1120(KeepAppNo);
		
		ViewApplicationAndModifyAppOther_Jordanain_Case1121_1(KeepAppNo, NationalIDValue, IDNumberValue);//Modify
		
		this.Processing_ApproveByDirector_Case1100_3(KeepAppNo);
		
		ViewApplicationAndLicense_Jordanain_Case1101(KeepAppNo, NationalIDValue, IDNumberValue);

	}

	
	@Test(priority = 11, groups = {"Uni", "Full", "Equi"})
	public void SubmitNursingApp_Jordanian_Case1720() throws InterruptedException, IOException {

		// ‘Â«œ… «·»ﬂ«·Ê—ÌÊ” „‰ Ã«„⁄… Œ«—Ã «·«—œ‰

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		NationalIDValue = "9761018598";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue = "FMR73323";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("6133"); // Association-Number

		driver.findElement(Captcha).sendKeys("0440"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 2);

		} catch (Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("›—‰”«");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("Centre International de Recontre Mathematiques");

		Thread.sleep(Const * 8);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2005"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// Equivalence-Letter
		driver.findElement(EquivalenceLetter).sendKeys("12344");

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234588", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate and
		// Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.2.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.2.0 " + ActualResult);
		
		AppNo = driver.findElement(ApplicationNumberGeneralCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);
		
		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

		KeepAppNo= this.Processing_ApproveByHead_Case1100(AppNo);
		
		this.Processing_IncompleteByDirector_Case1120(KeepAppNo);
		
		this.ViewApplicationAndModifyAppOther_Jordanain_Case1121_1(IDNumberValue, NationalIDValue, KeepAppNo);
		
		

	}
	

	@Test(priority = 12, enabled = true, groups = {"Uni", "Full"})
	public void SubmitNursingApp_Jordanian_Case1300() throws InterruptedException, IOException {

		// «·„” Œœ„ ﬁ«„ » ﬁœÌ„ ÿ·» ”«»ﬁ Ê·« Ì“«· ﬁÌœ «· ‰›Ì–

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9761018598"); // National-ID

		driver.findElement(IDNumber).sendKeys("FMR73323"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("6133"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·ÊÃÊœ ÿ·»  ’—ÌÕ „“«Ê·… „Â‰… „„—÷ ﬁ«‰Ê‰Ì ”«»ﬁ —ﬁ„";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.3.0.0.png"));

		System.out.println("Passed. Jordanian Nurse Case 1.3.0.0");

	}
	
	
	@Test(priority = 12, groups = {"Uni", "Equi"})
	public void SubmitNursingApp_Jordanian_Case1721() throws InterruptedException, IOException {

		// ‘Â«œ… «·»ﬂ«·Ê—ÌÊ” „‰ Ã«„⁄… Œ«—Ã «·«—œ‰ - Œÿ√ ›Ì —ﬁ„ ÊÀÌﬁ…
		// «·„⁄«œ·…

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9822017509"); // National-ID

		driver.findElement(IDNumber).sendKeys("11897416"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("14249"); // Association-Number

		driver.findElement(Captcha).sendKeys("0440"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);
		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com");// Email
			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 2);
		} catch (Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("›—‰”«");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("Centre International de Recontre Mathematiques");

		Thread.sleep(Const * 8);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2005"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// Equivalence-Letter
		driver.findElement(EquivalenceLetter).sendKeys("78954");

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234624", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		Thread.sleep(Const * 10);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "„⁄·Ê„«  «·»ﬂ«·Ê—ÌÊ” «·„œŒ·… €Ì— ’ÕÌÕ…. ·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·». ·„“Ìœ „‰ «·„⁄·Ê„«  Ì—ÃÏ «·≈ ’«· ⁄·Ï «·Œÿ «·”«Œ‰ ·Ê“«—… «·’Õ…";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.2.1.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.2.1");

		}

	
	@Test(priority = 13,enabled = true ,groups = {"Uni", "Full", "Equi"})
	public void SubmitNursingApp_Jordanian_Case1730() throws InterruptedException, IOException {

		// Ã«„⁄… ⁄—»Ì… ÕﬂÊ„Ì… ﬁ»· 2001

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		NationalIDValue = "9801007698";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue = "AVZ64216";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("8255"); // Association-Number

		driver.findElement(Captcha).sendKeys("9999"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 2);
		} catch (

		Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(5); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(" Ê‰”");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("Ã«„⁄… ”Ê”…");

		Thread.sleep(Const * 20);

		// Admission-Year
		Select Admission = new Select(driver.findElement(AdmissionYear));
		Admission.selectByVisibleText("2000");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2004");

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234604", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------

		Thread.sleep(Const * 2);
		
		String WarningMessage = driver.findElement(WarningMessageGeneralCases).getText();
		System.out.println("Warning Message: " + WarningMessage);
		
		Assert.assertTrue(WarningMessage.contains("Ì„ﬂ‰ﬂ  ﬁœÌ„ ÿ·» «·„“«Ê·… «·ﬂ —Ê‰Ì« „‰ Œ·«· ‰Ÿ«„ «·Œœ„«  «·≈·ﬂ —Ê‰Ì…° ·ﬂ‰ Ì ÊÃ» ⁄·Ìﬂ „—«Ã⁄… Ê“«—… «·’Õ… „’ÿÕ»« «·‘Â«œ«  «·√’·Ì… ··»ﬂ«·Ê—ÌÊ” Ê –·ﬂ ‰Ÿ—« ·√‰ﬂ Œ—ÌÃ Ã«„⁄… ⁄—»Ì… ÕﬂÊ„Ì… Ê «· Õﬁ  »«·œ—«”… ﬁ»· 2001"));
		
		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate-and-Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys("”⁄Ìœ"); // Notes

		Thread.sleep(Const * 20);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.3.0.png"));

		// ------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.3.0 " + ActualResult);

		AppNo = driver.findElement(ApplicationNumberGeneralCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);
		
		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

		KeepAppNo= this.Processing_ApproveByHead_Case1100(AppNo);
		
		this.Processing_IncompleteByDirector_Case1120(KeepAppNo);
		
		ViewApplicationAndModifyAppOther_Jordanain_Case1121_1(KeepAppNo, NationalIDValue, IDNumberValue);//Modify
		
		this.Processing_ApproveByDirector_Case1100_3(KeepAppNo);
		
		ViewApplicationAndLicense_Jordanain_Case1101(KeepAppNo, NationalIDValue, IDNumberValue);//View

	}

	
	@Test(priority = 14, groups = {"Uni", "Equi"})
	public void SubmitNursingApp_Jordanian_Case1731() throws InterruptedException, IOException {

		// Ã«„⁄… ⁄—»Ì… ÕﬂÊ„Ì… ›Ì «Ê »⁄œ 2001

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		NationalIDValue = "9862038522";
		driver.findElement(NationalID).sendKeys(NationalIDValue); // National-ID

		IDNumberValue = "NUH62653";
		driver.findElement(IDNumber).sendKeys(IDNumberValue); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("16100"); // Association-Number

		driver.findElement(Captcha).sendKeys("9999"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 4);
		}

		catch (

		Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 5);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(5); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·⁄—«ﬁ");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("Ã«„⁄…  ﬂ—Ì ");

		Thread.sleep(Const * 20);

		// Admission-Year
		Select Admission = new Select(driver.findElement(AdmissionYear));
		Admission.selectByVisibleText("2002");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016");

		Thread.sleep(Const * 10);

		// Equivalence-Letter
		driver.findElement(EquivalenceLetter).sendKeys("99999");

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234630", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate-and-Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys("”⁄Ìœ"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "ÿ·»ﬂ »‰Ã«Õ";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.3.1.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.3.1 " + ActualResult);

		AppNo = driver.findElement(ApplicationNumberGeneralCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);
		
		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

		KeepAppNo= this.Processing_ApproveByHead_Case1100(AppNo);
		
		this.Processing_IncompleteByDirector_Case1120(KeepAppNo);
		
		ViewApplicationAndModifyAppOther_Jordanain_Case1121_1(KeepAppNo, NationalIDValue, IDNumberValue);//modify

	}

	
	@Test(priority = 15, groups = {"Uni"})
	public void SubmitNursingApp_Jordanian_Case1740() throws InterruptedException, IOException {

		// «·Õ«·… €Ì— „ Œ—Ã
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9671008411"); // National-ID

		driver.findElement(IDNumber).sendKeys("LPR65554"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("2639"); // Association-Number

		driver.findElement(Captcha).sendKeys("9999"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 20);

		} catch (Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(2); // Non-Jordanian-Inside

		Thread.sleep(Const);
		
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 5);
		
		// Semester
		//Select Semester = new Select(driver.findElement(SemesterDDL));
		//Semester.selectByIndex(2); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");

		Thread.sleep(Const);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2013"); // Graduation-Year

		Thread.sleep(Const);
		
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor
		
		Thread.sleep(Const);

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234565", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·⁄œ„ ≈” —Ã«⁄ „⁄·Ê„«  «·»ﬂ«·Ê—ÌÊ”° Ì—ÃÏ „—«Ã⁄… Ê“«—… «· ⁄·Ì„ «·⁄«·Ì Ê«·»ÕÀ «·⁄·„Ì · ’ÊÌ» «·√Ê÷«⁄";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.4.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.4.0");

	}


	@Test(priority = 16, enabled = true ,groups = {"Uni", "Equi"})
	public void SubmitNursingApp_Jordanian_Case1750() throws InterruptedException, IOException {

		// ﬁ—«— «·„⁄«œ·… €Ì— „⁄«œ·
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9862038577"); // National-ID

		driver.findElement(IDNumber).sendKeys("AXU40964"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("7418"); // Association-Number

		driver.findElement(Captcha).sendKeys("9999"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {
			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 20);
		} catch (Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(2); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·ﬂÊÌ ");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("Ã«„⁄… «·ﬂÊÌ ");

		Thread.sleep(Const);

		
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		Thread.sleep(Const * 10);

		driver.findElement(EquivalenceLetter).sendKeys("741224"); // Equivalence-Doc

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("010101", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "€Ì— „⁄«œ·…";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.5.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.5.0");

	}


	@Test(priority = 17, groups = {"Uni"})
	public void SubmitNursingApp_Jordanian_Case1760() throws InterruptedException, IOException {

		// «· Œ’’ ·Ì” „‰ ÷„‰  Œ’’«  «· „—Ì÷
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9791048710"); // National-ID

		driver.findElement(IDNumber).sendKeys("TGQ18341"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("7057"); // Association-Number

		driver.findElement(Captcha).sendKeys("8985");; // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 20);
		} catch (Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");
		// UniversityCountry.selectByIndex(139); // «·√—œ‰

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("Ã«„⁄… «·⁄·Ê„ Ê«· ﬂ‰Ê·ÊÃÌ« «·√—œ‰Ì…");

		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234592", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·√‰  Œ’’ﬂ ·Ì”  «»⁄ ·ﬂ·Ì… «· „—Ì÷";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.6.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.6.0");
	}

	
	@Test(priority = 18, groups = {"NCRC"})
	public void SubmitNursingApp_Jordanian_Case1800() throws InterruptedException, IOException {

		// Œÿ√ ›Ì —ﬁ„ ‘Â«œ… ⁄œ„ «·„ÕﬂÊ„Ì…
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9671008411"); // National-ID

		driver.findElement(IDNumber).sendKeys("LPR65554"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("2639"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 20);
		} catch (Exception e) {// do nothing

		}

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2012"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("00000", Keys.TAB); // NCRC

		Thread.sleep(Const * 10);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·⁄œ„ ÊÃÊœ ‘Â«œ… ⁄œ„ „ÕﬂÊ„Ì…";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.8.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.8.0.0");

	}


	@Test(priority = 19, groups = {"NCRC"})
	public void SubmitNursingApp_Jordanian_Case1810() throws InterruptedException, IOException {

		// „ÕﬂÊ„

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9932047777"); // National-ID

		driver.findElement(IDNumber).sendKeys("SIB96983"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("22147"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		try {

			driver.findElement(MobileNumber).sendKeys("797352297"); // Mobile-Number

			driver.findElement(Email).sendKeys("emasoud@optimizasolutions.com"); // Email

			driver.findElement(Address).sendKeys("Optimiza Solutions", Keys.TAB); // Address

			Thread.sleep(Const * 20);
			
		} catch (Exception e) {// do nothing

		}
		
		Thread.sleep(Const * 20);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2012"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("7412", Keys.TAB); // NCRC

		Thread.sleep(Const * 10);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·ÊÃÊœ Œÿ√ ›Ì «·„⁄·Ê„«  «·„” —Ã⁄… ·‘Â«œ… ⁄œ„ «·„ÕﬂÊ„Ì…";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.8.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.8.1.0");

		// driver.quit();
	}


	@Test(priority = 20, groups = {"NCRC"})
	public void SubmitNursingApp_Jordanian_Case1820() throws InterruptedException, IOException {

		// ‘Â«œ… ⁄œ„ «·„ÕﬂÊ„Ì… „‰ ÂÌ… «·’·«ÕÌ…

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9661035099"); // National-ID

		driver.findElement(IDNumber).sendKeys("JJR42264"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("1415"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------

		driver.findElement(VerificationCodeText).click(); // Verification-Code

		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 3);

		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 3);

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("«·√—œ‰");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("«·Ã«„⁄… «·«—œ‰Ì…");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2012"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234651", Keys.TAB); // NCRC

		Thread.sleep(Const * 10);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·√‰ ‘Â«œ… ⁄œ„ «·„ÕﬂÊ„Ì… «·’«œ—… ﬁœ  Ã«Ê“  «·À·«À… √‘Â— „‰  «—ÌŒ ≈’œ«—Â«";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.8.2.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.8.2.0");

		// driver.quit();
	}


	@Test(priority = 21, groups = {"JNMC"})
	public void SubmitNursingApp_Jordanian_Case1900() throws InterruptedException, IOException {

		// «·„„—÷ €Ì— „‰ ”» ··‰ﬁ«»…

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 5);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9791048710"); // National-ID

		driver.findElement(IDNumber).sendKeys("TGQ18341"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("707"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·√‰ «·„„—÷ €Ì— „‰ ”» ··‰ﬁ«»…° Ì—ÃÏ «·«‰ ”«» ··‰ﬁ«»… Ê„‰ À„  ﬁœÌ„ ÿ·»  ’—ÌÕ „“«Ê·… „Â‰… „„—÷ ﬁ«‰Ê‰Ì";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.9.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.9.0.0");

		// driver.quit();
	}

	
	@Test(priority = 22, groups = {"JNMC"})
	public void SubmitNursingApp_Jordanian_Case1910() throws InterruptedException, IOException {

		// «·„„—÷ €Ì— „”œœ ·—”Ê„ «·‰ﬁ«»…

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9772009853"); // National-ID

		driver.findElement(IDNumber).sendKeys("NSB73174"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("5867"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·√‰ «·„„—÷ €Ì— „”œœ ··—”Ê„ «·„ — »… ⁄·ÌÂ ›Ì «·‰ﬁ«»…° Ì—ÃÏ  ”œÌœ —”Ê„ «·‰ﬁ«»… Ê„‰ À„  ﬁœÌ„ ÿ·»  ’—ÌÕ „“«Ê·… „Â‰… „„—÷ ﬁ«‰Ê‰Ì";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.9.1.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.9.1.0");

		// driver.quit();
	}


	@Test(priority = 23, groups = {"JNMC"})
	public void SubmitNursingApp_Jordanian_Case1920() throws InterruptedException, IOException {

		// «·„„—÷ „‰ ”» ··‰ﬁ«»…Ê·„ Ì „ «” —Ã«⁄ „⁄·Ê„« Â

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9592009582"); // National-ID

		driver.findElement(IDNumber).sendKeys("UBI96847"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("60982"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "·« Ì„ﬂ‰ﬂ «” ﬂ„«·  ﬁœÌ„ «·ÿ·» ‰Ÿ—« ·ÕœÊÀ Œÿ√ ›Ì ≈” —Ã«⁄ „⁄·Ê„«  «·„„—÷ „‰ ‰ﬁ«»… «·„„—÷Ì‰° Ì—ÃÏ „—«Ã⁄… ‰ﬁ«»… «·„„—÷Ì‰ ·· √ﬂœ „‰ «·≈‰ ”«» Ê’Õ… «·»Ì«‰« ";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.9.2.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.9.2.0");

	}


	@Test(priority = 35, groups = {"ContactUs"})
	public void ContactUs_Case8000() throws InterruptedException, IOException {

		// «—”«· «” ›”«—

		driver.findElement(By.id("customerImg")).click(); // Contact-Us

		Select Service = new Select(driver.findElement(By.id("pt1:soc3::content"))); // Select-Service

		Service.selectByIndex(1);

		Select MessageType = new Select(driver.findElement(By.id("pt1:soc2::content"))); // Select-Type

		MessageType.selectByIndex(1);

		driver.findElement(By.id("pt1:it3::content")).sendKeys("Essra");

		Select CountryCode = new Select(driver.findElement(By.id("pt1:mn1:dc_soc1::content"))); // Country-Code

		CountryCode.selectByVisibleText("+962");

		driver.findElement(By.id("pt1:mn1:itMobileNumber::content")).sendKeys("797352298"); // Mobile

		driver.findElement(By.id("pt1:e1:itEmail::content")).sendKeys("e@e.com"); // Email

		driver.findElement(By.id("pt1:it7::content")).sendKeys(" ‰’ «·—”«·… ‰’ «·—”«·… ‰’ «·—”«·… ‰’ «·—”«·…");

		driver.findElement(By.id("pt1:itCaptchaValue::content")).sendKeys("0000"); // Captcha

		driver.findElement(By.id("pt1:b2")).click(); // Send

		// Assert

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = " „  ﬁœÌ„ ≈” ›”«— »‰Ã«Õ. «·—ﬁ„ «·„—Ã⁄Ì ÂÊ";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case8.0.0.0.png"));

		System.out.println("Passed. Contact Us 8.0.0.0");

	}


	@Test(priority = 36, groups = {"ContactUs"})
	public void ContactUs_Case8100() throws InterruptedException, IOException {

		// «—”«· «ﬁ —«Õ

		driver.findElement(By.id("customerImg")).click(); // Contact-Us

		Select Service = new Select(driver.findElement(By.id("pt1:soc3::content"))); // Select-Service

		Service.selectByIndex(1);

		Select MessageType = new Select(driver.findElement(By.id("pt1:soc2::content"))); // Select-Type

		MessageType.selectByIndex(2);

		driver.findElement(By.id("pt1:it3::content")).sendKeys("Essra");

		Select CountryCode = new Select(driver.findElement(By.id("pt1:mn1:dc_soc1::content"))); // Country-Code

		CountryCode.selectByVisibleText("+962");

		driver.findElement(By.id("pt1:mn1:itMobileNumber::content")).sendKeys("797352298"); // Mobile

		driver.findElement(By.id("pt1:e1:itEmail::content")).sendKeys("e@e.com"); // Email

		driver.findElement(By.id("pt1:it7::content")).sendKeys("«—”«· «ﬁ —«Õ «—”«· «ﬁ —«Õ «—”«· «ﬁ —«Õ «—”«· «ﬁ —«Õ");

		driver.findElement(By.id("pt1:itCaptchaValue::content")).sendKeys("0000"); // Captcha

		driver.findElement(By.id("pt1:b2")).click(); // Send

		// Assert

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = " „  ﬁœÌ„ ≈ﬁ —«Õ »‰Ã«Õ. «·—ﬁ„ «·„—Ã⁄Ì ÂÊ";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case8.1.0.0.png"));

		System.out.println("Passed. Contact Us 8.1.0.0");

	}


	@Test(priority = 36, groups = {"ContactUs"})
	public void ContactUs_Case8200() throws InterruptedException, IOException {

		// «—”«· ‘ﬂÊÏ

		driver.findElement(By.id("customerImg")).click(); // Contact-Us

		Select Service = new Select(driver.findElement(By.id("pt1:soc3::content"))); // Select-Service

		Service.selectByIndex(1);

		Select MessageType = new Select(driver.findElement(By.id("pt1:soc2::content"))); // Select-Type

		MessageType.selectByIndex(3);

		driver.findElement(By.id("pt1:it3::content")).sendKeys("Essra");

		Select CountryCode = new Select(driver.findElement(By.id("pt1:mn1:dc_soc1::content"))); // Country-Code

		CountryCode.selectByVisibleText("+962");

		driver.findElement(By.id("pt1:mn1:itMobileNumber::content")).sendKeys("797352298"); // Mobile

		driver.findElement(By.id("pt1:e1:itEmail::content")).sendKeys("e@e.com"); // Email

		driver.findElement(By.id("pt1:it7::content")).sendKeys("«—”«· ‘ﬂÊÏ «—”«· ‘ﬂÊÏ «—”«· ‘ﬂÊÏ «—”«· ‘ﬂÊÏ");

		driver.findElement(By.id("pt1:itCaptchaValue::content")).sendKeys("0000"); // Captcha

		driver.findElement(By.id("pt1:b2")).click(); // Send

		// Assert

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = " „  ﬁœÌ„ ‘ﬂ«ÊÏ »‰Ã«Õ. «·—ﬁ„ «·„—Ã⁄Ì";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case8.2.0.0.png"));

		System.out.println("Passed. Contact Us 8.2.0.0");

	}


	@Test(priority = 38)
	public void MyPage_EditContactDetails_Jordanain() throws InterruptedException, IOException {

		//  ⁄œÌ· „⁄·Ê„«  «·« ’«·
		
		System.out.println(NationalIDValue + " " + IDNumberValue);

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("√›—«œ");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys(NationalIDValue); // National-ID

		driver.findElement(MyPageCardNo).sendKeys(IDNumberValue); // Card-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Continue

		Thread.sleep(Const * 10);

		// ---------------------------EditContactDetails--------------------
		this.EditContactDetails();

		System.out.println("Passed. Edited Jordanian Details");
	}


	@Test(priority = 39)
	public void MyPage_EditContactDetails_HealthInstitute() throws InterruptedException, IOException {

		//  ⁄œÌ· „⁄·Ê„«  «·« ’«·

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("„ƒ””… ’ÕÌ…");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("52317954"); // Institute-National-ID

		driver.findElement(MyPageCardNo).sendKeys("41725"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Continue

		Thread.sleep(Const * 10);

		// -----------------------EditContactDeatils-----------------------
		this.EditContactDetails();

		System.out.println("Passed. Edited Health Institute Details.");
	}


	@Test(priority = 40)
	public void MyPage_EditContactDetails_RoyalMedicalServices() throws InterruptedException, IOException {

		//  ⁄œÌ· „⁄·Ê„«  «·« ’«·

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("«·Œœ„«  «·ÿ»Ì… «·„·ﬂÌ…");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("717144523"); // RMS-National-ID

		driver.findElement(MyPageCardNo).sendKeys("523317"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Continue

		Thread.sleep(Const * 10);

		// -------------------EditContactDetails----------------------
		this.EditContactDetails();

		System.out.println("Passed. Edited Royal Medical Services Details");

	}

	@Test(priority = 41)
	public void MypageValidations() throws InterruptedException, IOException{
		
		this.MyPage_Individuals_Case7000();
		this.MyPage_Companies_Case7100();
		this.MyPage_HealthInstitute_Case7200();
		this.MyPage_RoyalMedicalServices_Case7200_2();
		this.MyPage_Individuals_Case7300();
		this.MyPage_Companies_Case7300_2();
		this.MyPage_HealthInstitute_Case7300_3();
		this.MyPage_RoyalMedicalServices_Case7300_4();
		this.MyPage_RoyalMedicalServices_Case7400();
		this.MyPage_WrongVerificationCode_Case7500();

		
	}
	// end
	
	@Test(groups = {"Start"})
	public void fake(){
		//hi
	}
}
