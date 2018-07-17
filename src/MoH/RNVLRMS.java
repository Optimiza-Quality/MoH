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

public class RNVLRMS extends RNVLFields {

	WebDriver driver;

	Integer Const = 200;
	String AppNo;
	String KeepAppNo;

	@BeforeMethod(enabled = true)
	public void GetDriver() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nftaiha\\git\\MoH\\MoH\\chromedriver.exe");
		driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\emasoud\\Desktop\\geckodriver.exe");
		// driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get("https://ohs-vip:4443/public/index.html");
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
				FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));

				System.out.println("Failed. Screenshot taken " + result.getName());
			} catch (Exception e) {

				System.out.println("Failed. Exception while taking screenshot" + e.getMessage());
			}
		}

		driver.quit();

	}

	@Test(priority = 1, enabled = true, retryAnalyzer = MoH.RetryAnalyzer.class)
	public void SubmitNursingApp_RMS_Case3000() throws InterruptedException, IOException {
		// submit successfully

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

		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys("10224"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("7411325533"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton

		Thread.sleep(Const * 10);
		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 20);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		Thread.sleep(Const * 20);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2006"); // Graduation-Year

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
		driver.findElement(NotesGeneralCases).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		String AppNo = driver.findElement(ApplicationNumberGeneralCases).getText();
		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3000-ApplicationNoRMS.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("RMS 3.0.0.0" + ActualResult);
		Thread.sleep(Const * 10);
		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

		driver.get("https://172.16.0.254:4443/internal/faces/index.jsf");

		driver.findElement(By.id("pt1:lid1:dc_it1::content")).sendKeys("ESRAA"); // Username

		driver.findElement(By.id("pt1:lid1:dc_it2::content")).sendKeys("12345"); // Password

		Thread.sleep(Const * 5);

		driver.findElement(By.id("pt1:lid1:dc_b1")).click(); // Login

		driver.findElement(By.id("icon3")).click();

		driver.findElement(By.id("icon8")).click();

		driver.findElement(By.id("icon32")).click();

		driver.findElement(By.id("icon58")).click();
		Thread.sleep(Const * 20);

		driver.findElement(By.id("pt1:pgl14")).click(); // Navigate-Out

		Thread.sleep(Const * 20);
		System.out.println(AppNo);

		String[] TrimmedAppNo = AppNo.split("/");

		for (String str : TrimmedAppNo) {
			System.out.println(str);

			driver.findElement(By.id("pt1:r1:1:requestNo::content")).sendKeys(str);

			break;

		}

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:b1")).click(); // Search

		Thread.sleep(Const * 20);

		driver.findElement(By.linkText("تفاصيل")).click(); // Details

		Thread.sleep(Const * 20);

		TakesScreenshot ts2 = (TakesScreenshot) driver;
		File source2 = ts2.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source2, new File("./ScreenShots/Case3.1.0.0.png"));

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:sor1:_2\"]")).click(); // Radio-Reject

		Thread.sleep(Const * 20);

		driver.findElement(By.id("pt1:r1:2:itNotes::content")).sendKeys("notes", Keys.TAB);// Notes

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:2:b2")).click(); // Process

	}

	// User not exists
	@Test(priority = 2, enabled = true)
	public void SubmitNursingApp_RMS_Case3200() throws InterruptedException, IOException {
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
		driver.findElement(NationalID).sendKeys("71445826"); // National-ID

		driver.findElement(PrivateNo).sendKeys("71445"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys("10224"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("7411325533"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		// --------------------Assert---------------------

		Thread.sleep(Const * 10);
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "رقم قيد المنشأة الوطني غير موجود، لا يمكنك استكمال تقديم الطلب. يرجى مراجعة وزارة الصحة لإنشاء حساب خاص بك. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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

		// ------------.--------------------------------------------------------------------------------------

	}

	// Incorrect user's info
	@Test(priority = 3, enabled = true)
	public void SubmitNursingApp_RMS_Case3210() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next button
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("71445"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys("10224"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("7411325533"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "الرقم الخاص غير مطابق، لا يمكنك استكمال تقديم الطلب. يرجى التأكد من صحة الرقم الخاص. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		Select userType = new Select(driver.findElement(ApplicantTypeDDLCSS));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number
		driver.findElement(AssociationNumber).sendKeys("10224"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("7411325533"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
		System.out.println(
				"ExpectedErrorMessage: لا يمكنك استكمال تقديم الطلب لإصدار تصريح مزاولة مهنة ممرض قانوني نظرا لوجود طلب تصريح مزاولة مهنة ممرض قانوني سابق رقم ( / ) لديك لايزال قيد التنفيذ، لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545");

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(
				"لا يمكنك استكمال تقديم الطلب لإصدار تصريح مزاولة مهنة ممرض قانوني نظرا لوجود طلب تصريح مزاولة مهنة ممرض قانوني سابق رقم"));
		System.out.println("RMS 3.3.0.0");

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3300-RMS_OpenApp.png"));

		// -----------------------------------------------------------------------------------------------

	}

	// المستخدم حاصل على رخصة مزاولة مهنة
	// Nurse has an active license
	@Test(priority = 4, enabled = true)
	public void RMS_Case3400() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(driver.findElement(ApplicantTypeDDLCSS));
		// RMS
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys(""); // Association-Number
		driver.findElement(MilitaryNo).sendKeys(""); // Military
														// ID-No
		Thread.sleep(Const * 10);

		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);
		// -------------Assert---------------------
		String ActualErrorMessage = driver.findElement(ErrorMessageByXpath).getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "";
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		System.out.println("RMS 3.4.0.0");

		// ------------------ScreenShot---------------
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case2300.png"));
	}

	// incorrect Military ID-No
	@Test(priority = 5, enabled = true)
	public void SubmitNursingApp_RMS_Case3500() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(driver.findElement(ApplicantTypeDDLCSS));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys("7728"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9882773822"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code

		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		// ----------------------Assert-----------------------
		Thread.sleep(Const * 20);
		String ActualErrorMessage = driver.findElement(By.xpath("pt1:exceptionMsg")).getText();

		System.out.println("Actual Message: " + ActualErrorMessage);

		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "الرقم الوطني المدخل غير صحيح، لا يمكنك استكمال تقديم الطلب. يرجى التأكد من صحة رقم الوطني. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		Select userType = new Select(driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys("4378"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9731006845"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton

		// ----------------------Assert-----------------------
		String ActualErrorMessage = driver.findElement(ErrorMessageByXpath).getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب لإصدار تصريح مزاولة مهنة ممرض قانوني نظرا لأن الرقم الوطني المدخل لشخص متوفي. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3600() throws InterruptedException, IOException {
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

		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys("7196"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9791051994"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");

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
		// String ExpectedErrorMessage ="يرجى إرفاق صورة عن شهادة الثانوية
		// العامة / صورة
		// عن معادلة شهادة الثانوية العامة في صفحة المرفقات. لمزيد من المعلومات
		// يرجى
		// الإتصال على الخط الساخن لوزارة الصحة 065004545";
		// System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
		//
		//
		// Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		driver.findElement(UploadSchoolCertificate).click(); // Choose
																// File
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\Uploader.exe");
		Thread.sleep(Const * 20);
		driver.findElement(NextToReviewAttachmentCases).click(); // Next-Button
		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 20);
		driver.findElement(NextToSubmitAttachmentCases).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyAttachmentCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesAttachmentCases).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		// -------------------------Assert-Application
		// Submission------------------------
		Thread.sleep(Const * 10);
		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts2 = (TakesScreenshot) driver;
		File source2 = ts2.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source2, new File("./ScreenShots-RMS/3.6ApplicationNoRMS.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("RMS Case3600" + ActualResult);
		Thread.sleep(Const * 10);
		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page
	}

	// Bachelor's degree info not retrieved in MOHE table
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3700() throws InterruptedException, IOException {
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

		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys("19728"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9872003176"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة مؤته");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button
		// -----------------------------Assert--------------------------------------
		Thread.sleep(Const * 10);
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
		Thread.sleep(Const * 10);
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب، نظرا لعدم إسترجاع معلومات البكالوريوس ، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3700-Bachelor'sData.png"));

	}

	// studied at Muna's collage
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3710() throws InterruptedException, IOException {
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
		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number
		driver.findElement(AssociationNumber).sendKeys("1279"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("1755643222"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);
		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 30);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("كلية الاميرة منى للتمريض");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("1998"); // Graduation-Year
		// Equivelant document number field
		Thread.sleep(Const * 10);
		driver.findElement(EquivalenceLetter).sendKeys("142544");
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
		driver.findElement(NotesGeneralCases).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		// ----------------Assert---------------------------
		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// ----------------------------------------------------------------------------------------------
		System.out.println("RMS 3.0.0.0" + ActualResult);
		Thread.sleep(Const * 10);
		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3710.png"));

	}

	// Incorrect equivalent document number
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3721() throws InterruptedException, IOException {
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

		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys("7414"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("7412235474"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

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
		UniversityCountry.selectByVisibleText("الكويت");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة الكويت");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year
		// Equivelant document number field
		Thread.sleep(Const * 10);
		driver.findElement(EquivalenceLetter).sendKeys("142544");
		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ----------------------Assert-----------------------
		Thread.sleep(Const * 20);
		String ActualErrorMessage = driver.findElement(By.xpath("pt1:exceptionMsg")).getText();

		System.out.println("Actual Message: " + ActualErrorMessage);

		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استمال تقديم الطلب نظرا لأن معلومات البكالوريوس المدخلة غير صحيحة , لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3721-IncorrectEq.No.png"));

	}

	// Studied university outside Jordan
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3720() throws InterruptedException, IOException {
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
		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number
		driver.findElement(AssociationNumber).sendKeys("7122"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9855217444"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);
		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000"); // Verification-Code
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out
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
		UniversityCountry.selectByVisibleText("الكويت");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة الكويت");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Equivalent document number field
		Thread.sleep(Const * 10);
		driver.findElement(EquivalenceLetter).sendKeys("142544");
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
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3720-needsEquation.png"));

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
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

		driver.findElement(By.id("pt1:r1:6:fp1:dc_b1")).click(); // Home-Page
	}

	// Governmental outside , before 2001
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3730() throws InterruptedException, IOException {
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

		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys("7441"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("7174458234"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code

		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

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
		Thread.sleep(Const * 10);
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter
		// ---------------------------------Bachelor-Degree-Frame----------------

		// University-Country
		Thread.sleep(Const * 10);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("مصر");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة القاهرة");
		// Admission date
		Thread.sleep(Const * 10);
		Select Admission = new Select(driver.findElement(AdmissionYear));
		Admission.selectByVisibleText("1998"); // Graduation-Year
		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Equivalent document number field
		// Thread.sleep(Const*10);
		// driver.findElement(EquivalenceLetter).sendKeys("142544");
		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3730.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("RMS 3.0.0.0" + ActualResult);
		Thread.sleep(Const * 10);
		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page
	}

	// Governmental outside , After 2001
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3731() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(ApplyCSS).click();
		// user type ddl
		Select userType = new Select(driver.findElement(ApplicantTypeDDLCSS));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);

		driver.findElement(NextToBasicInfo).click(); // Next

		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID

		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys("25669"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("1755236447"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code

		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

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
		UniversityCountry.selectByVisibleText("العراق");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة تكريت");
		// Admission date
		Thread.sleep(Const * 10);
		Select Admission = new Select(driver.findElement(AdmissionYear));
		Admission.selectByVisibleText("2002");
		Thread.sleep(Const * 10);

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Equivalent document number field
		Thread.sleep(Const * 10);
		driver.findElement(EquivalenceLetter).sendKeys("142544");

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3731.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("RMS 3.0.0.0" + ActualResult);
		Thread.sleep(Const * 10);
		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page
	}

	// Not graduated user
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3740() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nftaiha\\eclipse-MoH-UAT\\MoH-UAT\\src\\chromedriver.exe");
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

		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number

		driver.findElement(AssociationNumber).sendKeys("2639"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9671008411"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code

		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2013"); // Graduation-Year

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// --------------------------Assert----------------------------
		String ActualErrorMessage = driver.findElement(ErrorMessageByXpath).getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب، نظرا لعدم إسترجاع معلومات البكالوريوس ، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		Select userType = new Select(driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number
		driver.findElement(AssociationNumber).sendKeys("7057"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9791048710"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);
		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000"); // Verification-Code
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out
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

		// ------------------------Bachelor-Degree-Frame--------------------
		// University-Country
		Thread.sleep(Const * 10);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة العلوم والتكنولوجيا الأردنية");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// --------------------------Assert----------------------------
		String ActualErrorMessage = driver.findElement(ErrorMessageByXpath).getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لأن تخصصك ليس تابع لكلية التمريض، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3760-NotNurse.png"));

	}

	// Equivalence document status is not equivalent
	@Test(priority = 14, enabled = true)
	public void SubmitNursingApp_RMS_Case3750() throws InterruptedException, IOException {
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
		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number
		driver.findElement(AssociationNumber).sendKeys("7418"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("7144582411"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		Thread.sleep(Const * 10);
		driver.findElement(NextToVerificationCode).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(VerificationCodeText).sendKeys("0000"); // Verification-Code
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out
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

		// ------------------------Bachelor-Degree-Frame--------------------
		// University-Country
		Thread.sleep(Const * 10);
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("الكويت");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة الكويت");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Equivelant document number field
		Thread.sleep(Const * 10);
		driver.findElement(EquivalenceLetter).sendKeys("142544");
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
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب، نظرا لان حالة شهادة البكالوريوس (غير معادلة) ، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		Select userType = new Select(driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number
		driver.findElement(AssociationNumber).sendKeys("7412"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9791048710"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton

		// ----------------------Assert-----------------------
		String ActualErrorMessage = driver.findElement(ErrorMessageByXpath).getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لأنك غير منتسب للنقابة يرجى الانتساب للنقابة ومن ثم تقديم طلب تصريح مزاولة مهنة ممرض قانوني. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 06500454";
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
		Select userType = new Select(driver.findElement(ApplicantTypeDDLCSS));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number
		driver.findElement(AssociationNumber).sendKeys("5867"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9772009853"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton

		// ----------------------Assert-----------------------
		String ActualErrorMessage = driver.findElement(ErrorMessageByXpath).getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لأنك غير مسدد للرسوم المترتبة عليك في النقابة يرجى تسديد رسوم النقابة ومن ثم تقديم طلب تصريح مزاولة مهنة ممرض قانوني. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		Select userType = new Select(driver.findElement(ApplicantTypeDDLCSS));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(NextToBasicInfo).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(NationalID).sendKeys("717144523"); // National-ID
		driver.findElement(PrivateNo).sendKeys("523317"); // Private
															// Number
		driver.findElement(AssociationNumber).sendKeys("60982"); // Association-Number
		driver.findElement(MilitaryNo).sendKeys("9592009582"); // Military
																// ID-No
		Thread.sleep(Const * 10);
		driver.findElement(Captcha).sendKeys("0000"); // Captcha
														// code
		Thread.sleep(Const * 10);
		driver.findElement(VerifyButton).click(); // VerifyButton
		// -------------Assert---------------------
		String ActualErrorMessage = driver.findElement(ErrorMessageByXpath).getText();
		System.out.println("Actual Message: " + ActualErrorMessage);

		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لحدوث خطأ في إسترجاع معلوماتك من نقابة الممرضين، يرجى مراجعة نقابة الممرضين للتأكد من الإنتساب ولتأكد من صحة بياناتك، لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
