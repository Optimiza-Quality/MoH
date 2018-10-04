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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RNVLRMS extends RNVLInternal {
	
	WebDriver driver = new ChromeDriver();
	Integer Const = 200;

	@BeforeMethod
//	@Parameters("browsers")
//	public void CrossBrowser(String browsername) throws Exception {
//		// Check if parameter passed from TestNG is 'Chrome'
//		if (browsername.equalsIgnoreCase("Chrome")) {
//			// create Chrome instance
//			System.setProperty("webdriver.chrome.driver", "ChromeDriver");
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.get(ExternalTesting);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		} else
//		// Check if parameter passed from TestNG is 'firefox'
//		if (browsername.equalsIgnoreCase("Firefox")) {
//			// create firefox instance
//			System.setProperty("webdriver.gecko.driver", MyFirefoxDriver);
//			driver = new FirefoxDriver();
//			driver.manage().window().maximize();
//			driver.get(ExternalTesting);
//			driver.findElement(By.xpath("//*[@id=\"advancedButton")).click(); // Advanced
//			Thread.sleep(Const * 10);
//			driver.findElement(By.xpath("exceptionDialogButton")).click(); // Exception
//			Thread.sleep(Const * 100);
//
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		} else
//		// Check if parameter passed from TestNG is 'firefox'
//		if (browsername.equalsIgnoreCase("IE")) {
//			// create firefox instance
//			System.setProperty("webdriver.ie.driver", IEDriver);
//			WebDriver driver = new InternetExplorerDriver();
//			driver.manage().window().maximize();
//			// driver.get(ExternalTesting);
//			Thread.sleep(Const * 10);
//
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		}
//	}

	// SS on Failure
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
				FileUtils.copyFile(source, new File("./ScreenshotsFailure-RMS/" + result.getName() + ".png"));

				System.out.println("Test Case Failed. Screenshot taken " + result.getName());
			} catch (Exception e) {

				System.out.println("Test Case Failed. Exception while taking screenshot" + e.getMessage());
			}
		}

		driver.quit();

	}
	
	@BeforeMethod(enabled = true)
	public void GetDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "ChromeDriver");
		driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver",
		// MyFirefoxDriver);
		// driver = new FirefoxDriver();
		driver.get(ExternalTesting);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.findElement(By.linkText("English")).click();
	}
	
	
	// submit successfully
	//approved 
	@Test(priority = 1, enabled = true) //retryAnalyzer = MoH.RetryAnalyzer.class			
	public void SubmitNursingApp_RMS_Case3000() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number
		Thread.sleep(Const * 10);

		driver.findElement(AssociationNumber).sendKeys("2005"); // Association-Number  2005
		driver.findElement(MilitaryNo).sendKeys("9671027235"); // Military ID-No9671027235
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton

		Thread.sleep(Const * 30);
		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 20);
		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 10);
		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 20);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 10);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(DDLJordan);
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 20);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText(DDLJordanUni);
		Thread.sleep(Const * 20);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy
		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys(RateHappy); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitGeneralCases).click(); // Submit
		
	
		//----------------------------------------Assert-------------------------
		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		System.out.println("Actual " + ActualResult);
		String ExpectedResult =SuccessMsg;
		System.out.println("Expected " + ExpectedResult);
		AppNo = driver.findElement(ApplicationNumberGeneralCases).getText();
		System.out.println("Application Number: " + AppNo);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		// ---------------------------------TakeScreenSHot------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3000-ApplicationNoRMS.png"));
		System.out.println("RMS 3.0.0.0" + ActualResult);
		Thread.sleep(Const * 10);
		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page
		//----Internal-------------
		Thread.sleep(Const * 10);
		Round =1;
		KeepAppNo=Processing_ApproveByHead_Case1100(AppNo, Round); // Approve ra2ees 8esem 
		Processing_ApproveByDirector_Case1100_2(KeepAppNo, Round); // Approve modeer modereyea 

	}

	// User not exists
	@Test(priority = 2, enabled = true)
	public void SubmitNursingApp_RMS_Case3200() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("71445826"); // National-ID

		driver.findElement(PrivateNo).sendKeys("71445"); // Private Number

		driver.findElement(AssociationNumber).sendKeys("10224"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9671027235"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		// --------------------Assert---------------------

		Thread.sleep(Const * 10);
		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = HealthCareNotExist;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		System.out.println("RMS 3.2.0.0");

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3200-RMS_NotExistsUser.png"));

		// -----------------------------------------------------------------------------------------------

	}

	// Incorrect user's info
	@Test(priority = 3, enabled = true)
	public void SubmitNursingApp_RMS_Case3210() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("71445"); // Private Number

		driver.findElement(AssociationNumber).sendKeys("10224"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9671027235"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);
		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = WrongPrivteNumber;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		System.out.println("RMS 3.2.1.0");

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3210-RMS_IncorrectUser'sInfo.png"));

		// -----------------------------------------------------------------------------------------------

	}

	// Open application for the same nurse
	@Test(priority = 4, enabled = true)
	public void SubmitNursingApp_RMS_Case3300() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number
		driver.findElement(AssociationNumber).sendKeys("2005"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9671027235"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 30);
		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();
		Thread.sleep(Const * 20);
		String ExpectedErrorMessage = AppInProgress;
		System.out.println("Expected Result" +ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		
		// ---------------------------------Take-ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3300-RMS_OpenApp.png"));

		// -----------------------------------------------------------------------------------------------

	}

	// المستخدم حاصل على رخصة مزاولة مهنة
	// Nurse has an active license
	@Test(priority = 4, enabled = true)
	public void SubmitNursingApp_RMS_Case3400() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// RMS
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number

		driver.findElement(AssociationNumber).sendKeys("7811"); // Association-Number 1009
		driver.findElement(MilitaryNo).sendKeys("9671028885"); // Military ID-No 9612004436
		Thread.sleep(Const * 10);

		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);
		// -------------Assert---------------------
		String ActualErrorMessage = driver
				.findElement(ErrorMessageByXpath)
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = PrevLicense;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		System.out.println("RMS 3.4.0.0");

		// ------------------ScreenShot---------------
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3400.png"));
	}

	// incorrect Military ID-No
	@Test(priority = 5, enabled = true)
	public void SubmitNursingApp_RMS_Case3500() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number

		driver.findElement(AssociationNumber).sendKeys("1009"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9882773822"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code

		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		// ----------------------Assert-----------------------
		Thread.sleep(Const * 20);
		String ActualErrorMessage = driver.findElement(ErrorMessageIDXpath).getText();

		System.out.println("Actual Message: " + ActualErrorMessage);

		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = CSPDWrongNational;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		System.out.println("RMS 3.5.0.0");

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3500-RMS_IncorrectID-No.png"));

		// -----------------------------------------------------------------------------------------------

	}

	// Military ID-No for a Dead person
	@Test(priority = 6, enabled = true)
	public void SubmitNursingApp_RMS_Dead_Case3500() throws InterruptedException, IOException {

		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number

		driver.findElement(AssociationNumber).sendKeys("1709"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9652023349"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton

		// ----------------------Assert-----------------------
		String ActualErrorMessage = driver
				.findElement(ErrorMessageByXpath)
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage =CSPDDead;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3500-RMS_DeadUser.png"));

		// -----------------------------------------------------------------------------------------------

	}
    // High school info not retrieved in MOHE table
	//Rejection from Head of department 
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3600() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number

		driver.findElement(AssociationNumber).sendKeys("4344"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9741013295"); // Military ID-No
		//Database 123456789
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 10);
		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 10);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(DDLJordan);
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText(DDLJordanUni);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3600-HighScholInfoNotRetrieved.png"));

		// -------------------------------Attachments-Section-----------------------
		// -----------------Assert for warning message --------------------
		// String ActualErrorMessage =
		// driver.findElement(ErrorMessageByXpath).getText();
		// System.out.println("Actual Message: " + ActualErrorMessage);
		//
		// Thread.sleep(Const*10);
		// String ExpectedErrorMessage ="يرجى إرفاق صورة عن شهادة الثانوية العامة / صورة
		// عن معادلة شهادة الثانوية العامة في صفحة المرفقات. لمزيد من المعلومات يرجى
		// الإتصال على الخط الساخن لوزارة الصحة 065004545";
		// System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
		//
		//
		// Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		driver.findElement(UploadSchoolCertificate).click(); // Choose File
		Runtime.getRuntime().exec(JPGAtt);
		Thread.sleep(Const * 20);
		driver.findElement(NextToReviewAttachmentCases).click(); // Next-Button
		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 20);
		driver.findElement(NextToSubmitAttachmentCases).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyAttachmentCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesAttachmentCases).sendKeys(RateHappy); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		//----------------------------------------Assert-------------------------
				String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
				System.out.println("Actual " + ActualResult);
				String ExpectedResult =SuccessMsg;
				System.out.println("Expected " + ExpectedResult);
				String AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText();
				System.out.println("Application Number: " + AppNo);
				Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts2 = (TakesScreenshot) driver;
		File source2 = ts2.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source2, new File("./ScreenShots-RMS/3.6ApplicationNoRMS.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("RMS Case3600");
		Thread.sleep(Const * 10);
		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
		
		KeepAppNo= Processing_RejectByHead_Case1130(AppNo);
		
	}

	// Bachelor's degree info not retrieved in MOHE table
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3700() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number

		driver.findElement(AssociationNumber).sendKeys("19728"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9872003176"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 30);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code


		Thread.sleep(Const * 10);
		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 10);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(DDLJordan);
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 40);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText(DDLMoutaUni);
		Thread.sleep(Const * 40);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Degree
		Thread.sleep(Const * 40);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 20);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button
		// -----------------------------Assert--------------------------------------
		Thread.sleep(Const * 10);
		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();
		Thread.sleep(Const * 10);
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = BachelorNotRetrieved;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3700-Bachelor'sData.png"));

	}

	// studied at Muna's college
	//Rejection from Director
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3710() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number
		driver.findElement(AssociationNumber).sendKeys("14374"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9831038134"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);
		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 10);
		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 20);
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 20);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 20);

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 20);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(DDLJordan);
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 30);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText(DDLMuna);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("1998"); // Graduation-Year
//		// Equivelant document number field
//		Thread.sleep(Const * 10);
//		driver.findElement(EquivalenceLetter).sendKeys("142544");
		// Degree
		Thread.sleep(Const * 20);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys(RateHappy); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitGeneralCases).click(); // Submit
		//----------------------------------------Assert-------------------------
				String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
				System.out.println("Actual " + ActualResult);
				String ExpectedResult =SuccessMsg;
				System.out.println("Expected " + ExpectedResult);
				 AppNo = driver.findElement(ApplicationNumberGeneralCases).getText();
				System.out.println("Application Number: " + AppNo);
				Assert.assertTrue(ActualResult.contains(ExpectedResult));
		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3710.png"));
		//----------Internal----------
		Round =1;
		KeepAppNo=Processing_ApproveByHead_Case1100(AppNo, Round); // Approve ra2ees 8esem 

		Processing_RejectByDirector_Case1110(KeepAppNo, Round); //Rejection from moder modereyea
		
		
	}

	// Incorrect equivalent document number
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3721() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number
		driver.findElement(AssociationNumber).sendKeys("14741"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9702025986"); // Military ID-No 
		//DB was 12345688 in MOHE
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 30);
		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code
		
		Thread.sleep(Const * 10);
		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian
		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 10);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter
		// -----Bachelor-Degree-Frame-----
		Thread.sleep(Const * 10);
		// University-Country
		Thread.sleep(Const * 20);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(DDLKuwait);
		Thread.sleep(Const * 10);
		// University
		Thread.sleep(Const * 30);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText(DDLKuwaitUni);
		Thread.sleep(Const * 20);
		Thread.sleep(Const * 10);
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year
		Thread.sleep(Const * 20);
		// Equivelant document number field
		Thread.sleep(Const * 20);
		driver.findElement(EquivalenceLetter).sendKeys("14242");
		// Degree
		Thread.sleep(Const * 20);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor
		Thread.sleep(Const * 20);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button
		Thread.sleep(Const * 50);
		// ----------------------Assert-----------------------
		Thread.sleep(Const * 20);
		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualErrorMessage);

		Thread.sleep(Const * 20);
		String ExpectedErrorMessage = WrongBachelorInfo;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Thread.sleep(Const * 20);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 30);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3721-IncorrectEq.No.png"));

	}

	// Studied university outside Jordan
	//Incomplete application from Head of department 
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3720() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number
		driver.findElement(AssociationNumber).sendKeys("6133"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9761018598"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 40);
		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code
		
		Thread.sleep(Const * 10);
		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 20);
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 20);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 20);

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 20);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(DDLFrance);
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 20);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText(DDLFrenchUni);
		Thread.sleep(Const * 20);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2005"); // Graduation-Year
		Thread.sleep(Const * 20);

		// Equivalent document number field
		Thread.sleep(Const * 20);
		driver.findElement(EquivalenceLetter).sendKeys("12344");
		// Degree
		Thread.sleep(Const * 20);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys(RateHappy); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		//----------------------------------------Assert-------------------------
				String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
				System.out.println("Actual " + ActualResult);
				String ExpectedResult =SuccessMsg;
				System.out.println("Expected " + ExpectedResult);
				 AppNo = driver.findElement(ApplicationNumberGeneralCases).getText();
				System.out.println("Application Number: " + AppNo);
				Assert.assertTrue(ActualResult.contains(ExpectedResult));
		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts2 = (TakesScreenshot) driver;
		File source2 = ts2.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source2, new File("./ScreenShots-RMS/Case3720-ApplicationNoRMS.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("RMS");
		Thread.sleep(Const * 10);
		Round = 1;
		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page
		
		KeepAppNo=Processing_IncompleteByHead_Case1140(AppNo, Round);
	}

	// Governmental outside , before 2001
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3730() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 20);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		Thread.sleep(Const * 20);

		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number
		Thread.sleep(Const * 20);

		driver.findElement(AssociationNumber).sendKeys("10111"); // Association-Number
		Thread.sleep(Const * 20);

		driver.findElement(MilitaryNo).sendKeys("9821039112"); // Military ID-No 9671028885
		//174147441 DB MoHE 
		//9652023124
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code

		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 10);
		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------
		Thread.sleep(Const * 20);

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 20);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Thread.sleep(Const * 20);
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter
		// ---------------------------------Bachelor-Degree-Frame----------------
		Thread.sleep(Const * 20);

		// University-Country
		Thread.sleep(Const * 20);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(DDLEgypt);
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 50);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText(CairoUni);
		// Admission date
		Thread.sleep(Const * 50);
		Select Admission = new Select(driver.findElement(AdmissionYear));
		Admission.selectByVisibleText("1998"); // Graduation-Year
		Thread.sleep(Const * 50);

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor
		Thread.sleep(Const * 20);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year
		Thread.sleep(Const * 20);

		// Equivalent document number field
		// Thread.sleep(Const*10);
		// driver.findElement(EquivalenceLetter).sendKeys("142544");
		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		//---Assert Warning----
		String ActualResult2 = driver.findElement(WarningMessageGeneralCases).getText();
		System.out.println("Actual " + ActualResult2);
        String Expected2 = Warning2001;
        System.out.println("Expected " + Expected2);
        Assert.assertTrue(ActualResult2.contains(Expected2));

        Thread.sleep(Const * 10);
		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy
		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys(RateHappy); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		//----------------------------------------Assert-------------------------
				String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
				System.out.println("Actual " + ActualResult);
				String ExpectedResult =SuccessMsg;
				System.out.println("Expected " + ExpectedResult);
				String AppNo = driver.findElement(ApplicationNumberGeneralCases).getText();
				System.out.println("Application Number: " + AppNo);
				Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3730.png"));

		// -----------------------------------------------------------------------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(BackToHomeAnother).click(); // Home-Page
	}

	// Governmental outside , After 2001
	//Incomplete application from director 
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3731() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number

		driver.findElement(AssociationNumber).sendKeys("10124"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9831051441"); // Military ID-No
		//DB MOHE 1238897452
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code

		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 10);
		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 50);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(DDLIraq);
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 50);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText(TakreetUni);
		// Admission date
		Thread.sleep(Const * 50);
		Select Admission = new Select(driver.findElement(AdmissionYear));
		Admission.selectByVisibleText("2002");
		Thread.sleep(Const * 50);

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor
		Thread.sleep(Const * 50);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year
		Thread.sleep(Const * 50);

		// Equivalent document number field
		Thread.sleep(Const * 20);
		driver.findElement(EquivalenceLetter).sendKeys("99999");

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys(RateHappy); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitGeneralCases).click(); // Submit
		Thread.sleep(Const * 50);

		//----------------------------------------Assert-------------------------
				String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
				System.out.println("Actual " + ActualResult);
				String ExpectedResult =SuccessMsg;
				System.out.println("Expected " + ExpectedResult);
				AppNo = driver.findElement(ApplicationNumberGeneralCases).getText();
				System.out.println("Application Number: " + AppNo);
				Assert.assertTrue(ActualResult.contains(ExpectedResult));
		Thread.sleep(Const * 50);

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3731.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("RMS 3.0.0.0" + ActualResult);
		Thread.sleep(Const * 10);
		driver.findElement(BackToHomeAnother).click(); // Home-Page
		Round = 1;
		KeepAppNo=Processing_ApproveByHead_Case1100(AppNo, Round);
		Processing_IncompleteByDirector_Case1120(KeepAppNo, Round);
	}

	// Not graduated user
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3740() throws InterruptedException, IOException {
	
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number

		driver.findElement(AssociationNumber).sendKeys("2639"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9671008411"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code

		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code

		Thread.sleep(Const * 10);
		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 10);

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----
		Thread.sleep(Const * 50);

		// University-Country
		Thread.sleep(Const * 50);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(DDLJordan);
		// UniversityCountry.selectByIndex(139); // Jordan
		Thread.sleep(Const * 50);

		// University
		Thread.sleep(Const * 50);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText(DDLJordanUni);
		Thread.sleep(Const * 10);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2013"); // Graduation-Year
		Thread.sleep(Const * 10);

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button
		Thread.sleep(Const * 10);

		// --------------------------Assert----------------------------
		String ActualErrorMessage = driver
				.findElement(ErrorMessageByXpath)
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		
		String ExpectedErrorMessage = BachelorNotRetrieved;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3740-NotGraduated.png"));

	}

	// not nursing Major
	@Test(priority = 9, enabled = true)
	public void SubmitNursingApp_RMS_Case3760() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number
		driver.findElement(AssociationNumber).sendKeys("7057"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9791048710"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);
		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code
		
		Thread.sleep(Const * 10);
		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 20);
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian
		Thread.sleep(Const * 20);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 20);
		Thread.sleep(Const * 20);

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter
		Thread.sleep(Const * 20);

		// ------------------------Bachelor-Degree-Frame--------------------
		// University-Country
		Thread.sleep(Const * 20);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(DDLJordan);
		// UniversityCountry.selectByIndex(139); // Jordan
		Thread.sleep(Const * 20);

		// University
		Thread.sleep(Const * 20);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText(DDLJust);
		Thread.sleep(Const * 20);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year
		Thread.sleep(Const * 20);

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button
		Thread.sleep(Const * 20);

		// --------------------------Assert----------------------------
		String ActualErrorMessage = driver
				.findElement(ErrorMessageByXpath)
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = WrongMajor;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3760-NotNurse.png"));
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

	}

	// Equivalence document status is not equivalent
	@Test(priority = 14, enabled = true)
	public void SubmitNursingApp_RMS_Case3750() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number
		driver.findElement(AssociationNumber).sendKeys("10145"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9831010395"); // Military ID-No
		//DB MOHE 123877221
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 20);
		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000", Keys.TAB); // Verification-Code
		
		Thread.sleep(Const * 10);
		driver.findElement(NextToOtherInfo).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		
		// Schooling-System
		Thread.sleep(Const * 30);
		Select SchoolingSystem = new Select(driver.findElement(SchoolingSysDDL));
		SchoolingSystem.selectByIndex(1); // Jordanian
		Thread.sleep(Const * 20);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(CertificateYearDDL));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 20);

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter
		Thread.sleep(Const * 20);

		// ------------------------Bachelor-Degree-Frame--------------------
		// University-Country
		Thread.sleep(Const * 10);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText(DDLKuwait);
		// UniversityCountry.selectByIndex(139); // Jordan
		Thread.sleep(Const * 20);

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText(DDLKuwaitUni);
		Thread.sleep(Const * 20);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year
		Thread.sleep(Const * 20);

		// Equivelant document number field
		Thread.sleep(Const * 10);
		driver.findElement(EquivalenceLetter).sendKeys("741224");
		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button
		// ----------------------Assert-----------------------
		String ActualErrorMessage = driver.findElement(ErrorMessageByXpath).getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = Equiv;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3750-NotEquivalent.png"));

	}

	// not a member in Jordanian Pharmacists Association
	@Test(priority = 10, enabled = true)
	public void SubmitNursingApp_RMS_Case3800() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number
		driver.findElement(AssociationNumber).sendKeys("7412"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9791048710"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton

		// ----------------------Assert-----------------------
		String ActualErrorMessage = driver
				.findElement(ErrorMessageByXpath)
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = NCMembership;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3800-NotNurse.png"));

	}

	// membership fees are not paid
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3810() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number
		driver.findElement(AssociationNumber).sendKeys("5867"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9772009853"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton

		// ----------------------Assert-----------------------
		String ActualErrorMessage = driver
				.findElement(ErrorMessageByXpath)
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = JNMCFees;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3810-NotNurse.png"));

	}

	// Data corrupted in JNMC
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3820() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private Number
		driver.findElement(AssociationNumber).sendKeys("60982"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9592009582"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		// -------------Assert---------------------
		String ActualErrorMessage = driver.findElement(ErrorMessageByXpath).getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = JNMCData;
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3820-DataCorrupted.png"));

	}

}

