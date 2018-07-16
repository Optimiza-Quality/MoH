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

public class RNVLJordanian extends RNVLFields {

	WebDriver driver;

	Integer Const = 200;
	String AppNo = "79 / 2018";

	@BeforeMethod(enabled = true)
	public void GetDriver() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
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
			// driver.manage().timeouts().implicitlyWait(30,
			// TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(30,
			// TimeUnit.SECONDS);
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
			// driver.manage().timeouts().implicitlyWait(30,
			// TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(30,
			// TimeUnit.SECONDS);

		}
	}

	@AfterMethod(enabled = true)
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

	@Test(priority = 1, retryAnalyzer = MoH.RetryAnalyzer.class)
	public void SubmitNursingApp_Jordanian_Case1000() throws InterruptedException, IOException {

		// تقديم الطلب بنجاح - بيانات صحيحة
		// الموافقة على الطلب

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);

		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9782007189"); // National-ID

		driver.findElement(IDNumber).sendKeys("6267846"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2015"); // Graduation-Year

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
		driver.findElement(NotesGeneralCases).sendKeys("سعيد"); // Notes

		Thread.sleep(Const * 5);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture-screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.0.0.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse Case 1.0.0.0 " + ActualResult);

		AppNo = driver.findElement(ApplicationNumberGeneralCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

		RNVLInternal internal = new RNVLInternal();

		internal.Processing_Jordanian_Case1100(); // Approve

		internal.Processing_Jordanian_Case1100_2();// Approve

	}

	// المستخدم قام بانشاء حساب ولم يتم عملية تقديم الطلب
	// رفض مدير المديرية
	@Test(priority = 2)
	public void SubmitNursingApp_Jordanian_Case1200() throws InterruptedException, IOException {

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------

		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9882013944"); // National-ID

		driver.findElement(IDNumber).sendKeys("12345678"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("1234"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		// Screenshot for Initial Contact Details

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.2.0.0_Initial_Contact_Detials.png"));

		// --------------------------------Edit-Contact-Details---------------------------------
		driver.findElement(By.id("pt1:r1:1:lModifyAddress::text")).click(); // Edit-Contact-Details-Link
		this.EditContactDetails();
		// -------------------------Go-Back-To-Application-Form---------------------------------

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appTypeAgain = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appTypeAgain.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9882013944"); // National-ID

		driver.findElement(IDNumber).sendKeys("12345678"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("1234"); // Association-Number

		driver.findElement(Captcha).sendKeys("0090"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

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

		Thread.sleep(Const * 3);

		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("الأردن");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2012"); // Graduation-Year

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
		driver.findElement(NotesGeneralCases).sendKeys("محايد"); // Notes

		Thread.sleep(Const * 20);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 20);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts3 = (TakesScreenshot) driver;
		File source3 = ts3.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source3, new File("./ScreenShots/Case1.2.0.0.png"));

		// --------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse Case 1.2.0.0 " + ActualResult);

		AppNo = driver.findElement(ApplicationNumberGeneralCases).getText();

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

		RNVLInternal internal = new RNVLInternal();

		internal.Processing_Jordanian_Case1100(); // Approve
		internal.Processing_Jordanian_Case1110(); // Reject

	}

	@Test(priority = 3)
	public void SubmitNursingApp_Jordanian_Case1300() throws InterruptedException, IOException {

		// المستخدم قام بتقديم طلب سابق ولا يزال قيد التنفيذ

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9782007189"); // National-ID

		driver.findElement(IDNumber).sendKeys("6267846"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("61316"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب لإصدار تصريح مزاولة مهنة ممرض قانوني نظرا لوجود طلب تصريح مزاولة مهنة ممرض قانوني سابق رقم";

		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.3.0.0.png"));

		System.out.println("Passed. Jordanian Nurse Case 1.3.0.0");

	}

	@Test(priority = 4)
	public void SubmitNursingApp_Jordanian_Case1400() throws InterruptedException, IOException {

		// المستخدم حاصل على رخصة مزاولة مهنة

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9842006777"); // National-ID

		driver.findElement(IDNumber).sendKeys("8835297"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("19056"); // Association-Number

		driver.findElement(Captcha).click();

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual: " + ActualErrorMessage);

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب، بسبب وجود تصريح مزاولة مهنة ممرض قانوني سابق، يرجى استخدام الرابط التالي لاستعراض المزاولة. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

		System.out.println("Expected: " + ExpectedErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.4.0.0.png"));

		System.out.println("Passed. Jordanian Nurse 1.4.0.0");

	}

	@Test(priority = 4, enabled = false)
	public void SubmitNursingApp_Jordanian_Case1410() throws InterruptedException, IOException {

		// المستخدم حاصل على رخصة مزاولة مهنة من الخدمات الطبية

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys(""); // National-ID

		driver.findElement(IDNumber).sendKeys(""); // ID-Number

		driver.findElement(AssociationNumber).sendKeys(""); // Association-Number

		driver.findElement(Captcha).click();

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual: " + ActualErrorMessage);

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب لإصدار تصريح مزاولة مهنة ممرض قانوني نظرا لوجود تصريح مزاولة مهنة ممرض قانوني سابق فعال لدى (الخدمات الطبية الملكية)، يرجى مراجعة وزارة الصحة . لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

		System.out.println("Expected: " + ExpectedErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.4.1.0.png"));

		System.out.println("Passed. Jordanian Nurse 1.4.1.0");

	}

	@Test(priority = 5)
	public void SubmitNursingApp_Jordanian_Case1500() throws InterruptedException, IOException {

		// خطأ في معلومات الأحوال - البيانات غير مطابقة

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9872003176"); // National-ID

		driver.findElement(IDNumber).sendKeys("10985755"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("19728"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "الرقم الوطني ورقم الهوية غير متطابقين، لا يمكنك استكمال تقديم الطلب. يرجى التأكد من صحة رقم الوطني ورقم الهوية. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.5.0.0.png"));

		System.out.println("Passed. Jordanian Nurse 1.5.0.0");

	}

	@Test(priority = 24)
	public void SubmitNursingApp_Jordanian_Case1500_2() throws InterruptedException, IOException {

		// خطأ في معلومات الأحوال - الشخص متوفي

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9731006845"); // National-ID

		driver.findElement(IDNumber).sendKeys("3228854"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("4378"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب لإصدار تصريح مزاولة مهنة ممرض قانوني نظرا لأن الرقم الوطني المدخل لشخص متوفي. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

		System.out.println("Expected: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.5.0.0_2.png"));

		System.out.println("Passed. Jordanian Nurse 1.5.0.0_2");

	}

	@Test(priority = 6)
	public void SubmitNursingApp_Jordanian_Case1510() throws InterruptedException, IOException {

		// خطأ في معلومات الأحوال - الهوية منتهية الصلاحية

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9762030643"); // National-ID

		driver.findElement(IDNumber).sendKeys("10098514"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("5630"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "الهوية منتهية الصلاحية، لا يمكنك استكمال تقديم الطلب إصدار تصريح مزاولة مهنة ممرض قانوني، يرجى مراجعة دائرة الأحوال المدنية لتجديد الهوية. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

		System.out.println("Exoected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// Take SS
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/Case1.5.1.0.png"));

		System.out.println("Passed. Jordanian Nurse 1.5.1.0");

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية
		// Missing GPA
		// Upload jpg file

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

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
		driver.findElement(NotesAttachmentCases).sendKeys("حزين"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
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

		RNVLInternal internal = new RNVLInternal();

		internal.Processing_Jordanian_Case1100(); // Approve
		internal.Processing_Jordanian_Case1120(); // Incomplete

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600_2() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية
		// Missing Certificate Year
		// Upload jpeg file 1.87 MB

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9761043963"); // National-ID

		driver.findElement(IDNumber).sendKeys("11704349"); // ID-Number

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

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

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
		driver.findElement(NotesAttachmentCases).sendKeys("حزين"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_2.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_2" + ActualResult);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600_3() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية
		// Missing Branch Code
		// Upload file PNG

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9811009627"); // National-ID

		driver.findElement(IDNumber).sendKeys("8835296"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234613", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

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
		driver.findElement(NotesAttachmentCases).sendKeys("حزين"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_3.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_3" + ActualResult);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600_4() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية
		// Missing Branch Description
		// Upload file JPEG

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9861004187"); // National-ID

		driver.findElement(IDNumber).sendKeys("7409093"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234626", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Attachments--------------------------

		driver.findElement(UploadSchoolCertificate).click();

		Thread.sleep(Const * 20);
		Runtime.getRuntime().exec("C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_4 - JPEG\\Uploader.exe");
		// Give path where the au3 is saved.

		Thread.sleep(Const * 10);

		driver.findElement(NextToReviewAttachmentCases).click();

		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitAttachmentCases).click(); // Next-Button

		// ---------------------------------Rate-and-Submit--------------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateSadAttachmentCases).click(); // Rate-Sad

		Thread.sleep(Const * 10);
		driver.findElement(NotesAttachmentCases).sendKeys("حزين"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_4.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_4" + ActualResult);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600_5() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية
		// Missing Certificate Country
		// upload JPG file 1.99 MB

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9691037561"); // National-ID

		driver.findElement(IDNumber).sendKeys("11668535"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

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
		driver.findElement(NotesAttachmentCases).sendKeys("حزين"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_5.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_5" + ActualResult);

		AppNo = driver.findElement(ApplicationNumberAttachmentCases).getText(); // Get-App-No

		System.out.println("Application Number: " + AppNo);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page

		RNVLInternal internal = new RNVLInternal();
		internal.Processing_Jordanian_Case1130();// Reject

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600_6() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية
		// Missing Certificate Country Description

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9791000918"); // National-ID

		driver.findElement(IDNumber).sendKeys("9792504"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

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
		driver.findElement(NotesAttachmentCases).sendKeys("حزين"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_6.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_6" + ActualResult);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600_7() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية من معلومات وثيقة المعادلة

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9841018602"); // National-ID

		driver.findElement(IDNumber).sendKeys("11103774"); // ID-Number

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
		UniversityCountry.selectByVisibleText("فرنسا");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("Centre International de Recontre Mathematiques");

		Thread.sleep(Const * 10);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2005"); // Graduation-Year

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
		driver.findElement(NotesAttachmentCases).sendKeys("حزين"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitAttachmentCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageAttachmentCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_7.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_7" + ActualResult);

		driver.findElement(BackToHomeAttachmentCases).click(); // Home-Page

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600_8() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية
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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

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
		String ExpectedResult = "نوع الملف";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_8.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_8 " + ActualResult);

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600_9() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية
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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

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
		String ExpectedResult = "نوع الملف";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_9.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_9 " + ActualResult);

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600_10() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية
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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

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
		String ExpectedResult = "نوع الملف";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_10.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_10" + ActualResult);

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600_11() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية
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

		Thread.sleep(Const * 3);
		// Semester
		Select Semester = new Select(driver.findElement(SemesterDDL));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Select UniversityCountry = new Select(driver.findElement(UniversityCountryDDL));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

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
		String ExpectedResult = "نوع الملف";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_11.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_11" + ActualResult);

	}

	@Test(priority = 7)
	public void SubmitNursingApp_Jordanian_Case1600_12() throws InterruptedException, IOException {

		// عدم استرجاع معلومات الثانوية
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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

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
		String ExpectedResult = "الرجاء تحديد ملف أصغر حجمًا";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.6.0.0_12.png"));

		// ----------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.6.0.0_12" + ActualResult);

	}

	@Test(priority = 8)
	public void SubmitNursingApp_Jordanian_Case1700() throws InterruptedException, IOException {

		// عدم استرجاع معلومات البكالوريوس
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9872003176"); // National-ID

		driver.findElement(IDNumber).sendKeys("10905755"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");

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

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب، نظرا لعدم إسترجاع معلومات البكالوريوس ، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

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

	@Test(priority = 9)
	public void SubmitNursingApp_Jordanian_Case1700_2() throws InterruptedException, IOException {

		// عدم تطابق معلومات البكالوريوس
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9872003176"); // National-ID

		driver.findElement(IDNumber).sendKeys("10905755"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة مؤته");

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

		String ExpectedErrorMessage = "لا يمكنك استمال تقديم الطلب نظرا لأن معلومات البكالوريوس المدخلة غير صحيحة , لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

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

	@Test(priority = 9)
	public void SubmitNursingApp_Jordanian_Case1700_3() throws InterruptedException, IOException {

		// عدم تطابق معلومات البكالوريوس - الجامعة

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);

		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9872003176"); // National-ID

		driver.findElement(IDNumber).sendKeys("10905755"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");

		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC--------

		driver.findElement(NCRC).sendKeys("1234637", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		Thread.sleep(Const * 10);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "لا يمكنك استمال تقديم الطلب نظرا لأن معلومات البكالوريوس المدخلة غير صحيحة , لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

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

	@Test(priority = 10)
	public void SubmitNursingApp_Jordanian_Case1710() throws InterruptedException, IOException {

		// تخرج من كلية منى قبل 1999

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9831038134"); // National-ID

		driver.findElement(IDNumber).sendKeys("9836521"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("كلية الاميرة منى للتمريض");
		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("1998"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234625", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------

		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate and
		// Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 15);

		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
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

		RNVLInternal internal = new RNVLInternal();
		internal.Processing_Jordanian_Case1140(); // Incomplete

	}

	@Test(priority = 11)
	public void SubmitNursingApp_Jordanian_Case1720() throws InterruptedException, IOException {

		// شهادة البكالوريوس من جامعة خارج الاردن

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9761018598"); // National-ID

		driver.findElement(IDNumber).sendKeys("6744622"); // ID-Number

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
		UniversityCountry.selectByVisibleText("فرنسا");

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
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.2.0.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.2.0 " + ActualResult);

		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

	}

	@Test(priority = 12)
	public void SubmitNursingApp_Jordanian_Case1721() throws InterruptedException, IOException {

		// شهادة البكالوريوس من جامعة خارج الاردن - خطأ في رقم وثيقة
		// المعادلة

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9761018598"); // National-ID

		driver.findElement(IDNumber).sendKeys("6744622"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("6133"); // Association-Number

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
		UniversityCountry.selectByVisibleText("فرنسا");

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

		driver.findElement(NCRC).sendKeys("1234588", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		Thread.sleep(Const * 10);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "لا يمكنك استمال تقديم الطلب نظرا لأن معلومات البكالوريوس المدخلة غير صحيحة , لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

		System.out.println("Expected Message: " + ExpectedErrorMessage);

		System.out.println("Actual Message: " + ActualErrorMessage);

		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.2.1.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.2.1");

		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

	}

	@Test(priority = 13)
	public void SubmitNursingApp_Jordanian_Case1730() throws InterruptedException, IOException {

		// جامعة عربية حكومية قبل 2001

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9801007698"); // National-ID

		driver.findElement(IDNumber).sendKeys("8348009"); // ID-Number

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
		UniversityCountry.selectByVisibleText("تونس");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة سوسة");

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

		driver.findElement(NextToSubmitGeneralCases).click(); // Next-Button

		// ------------------------------Rate and
		// Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(RateHappyGeneralCases).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(NotesGeneralCases).sendKeys("سعيد"); // Notes

		Thread.sleep(Const * 20);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.3.0.png"));

		// ------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.3.0 " + ActualResult);

		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

	}

	@Test(priority = 14)
	public void SubmitNursingApp_Jordanian_Case1731() throws InterruptedException, IOException {

		// جامعة عربية حكومية في او بعد 2001

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9862038522"); // National-ID

		driver.findElement(IDNumber).sendKeys("7014522"); // ID-Number

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
		UniversityCountry.selectByVisibleText("تونس");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة سوسة");

		Thread.sleep(Const * 20);

		// Admission-Year
		Select Admission = new Select(driver.findElement(AdmissionYear));
		Admission.selectByVisibleText("2002");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2004");

		Thread.sleep(Const * 10);

		// Equivalence-Letter
		driver.findElement(EquivalenceLetter).sendKeys("12344");

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
		driver.findElement(NotesGeneralCases).sendKeys("سعيد"); // Notes

		Thread.sleep(Const * 2);
		driver.findElement(SubmitGeneralCases).click(); // Submit

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(SuccessMessageGeneralCases).getText();
		String ExpectedResult = "تم تقديم طلبك بنجاح";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.7.3.1.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Passed. Jordanian Nurse 1.7.3.1 " + ActualResult);

		driver.findElement(BackToHomeGeneralCases).click(); // Home-Page

	}

	@Test(priority = 15)
	public void SubmitNursingApp_Jordanian_Case1740() throws InterruptedException, IOException {

		// الحالة غير متخرج
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9671008411"); // National-ID

		driver.findElement(IDNumber).sendKeys("9158076"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");

		// University.selectByIndex(139); // Jordanian-University

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(GraduationYearDDL));
		Graduation.selectByVisibleText("2013"); // Graduation-Year

		// Degree
		Select Degree = new Select(driver.findElement(DegreeDDL));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(NCRC).sendKeys("1234565", Keys.TAB); // NCRC

		Thread.sleep(Const * 5);

		driver.findElement(NextToReviewOrAttachments).click(); // Next-Button

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب، نظرا لعدم إسترجاع معلومات البكالوريوس ، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

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

	@Test(priority = 16)
	public void SubmitNursingApp_Jordanian_Case1750() throws InterruptedException, IOException {

		// قرار المعادلة غير معادل
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("7144582411"); // National-ID

		driver.findElement(IDNumber).sendKeys("741225"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الكويت");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة الكويت");

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

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب، نظرا لعدم إسترجاع معلومات البكالوريوس ، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

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

	@Test(priority = 17)
	public void SubmitNursingApp_Jordanian_Case1760() throws InterruptedException, IOException {

		// التخصص ليس من ضمن تخصصات التمريض
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9791048710"); // National-ID

		driver.findElement(IDNumber).sendKeys("11650264"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("7057"); // Association-Number

		driver.findElement(Captcha).click(); // Captcha-Field

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
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("جامعة العلوم والتكنولوجيا الأردنية");

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

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لأن تخصصك ليس تابع لكلية التمريض، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

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

	@Test(priority = 18)
	public void SubmitNursingApp_Jordanian_Case1800() throws InterruptedException, IOException {

		// خطأ في رقم شهادة عدم المحكومية
		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9671008411"); // National-ID

		driver.findElement(IDNumber).sendKeys("9158076"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");

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

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب، لإصدار تصريح مزاولة مهنة ممرض قانوني يرجى إصدار شهادة عدم محكومية باستخدام الرابط التالي: إصدار شهادة عدم محكومية. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

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

	@Test(priority = 19)
	public void SubmitNursingApp_Jordanian_Case1810() throws InterruptedException, IOException {

		// محكوم

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9932047760"); // National-ID

		driver.findElement(IDNumber).sendKeys("124785"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("22147"); // Association-Number

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
		UniversityCountry.selectByVisibleText("الأردن");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");

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

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم طلب إصدار تصريح مزاولة مهنة ممرض قانوني لوجود خطأ في المعلومات المسترجعة لشهادة عدم المحكومية. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 65004545.";

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

	@Test(priority = 20)
	public void SubmitNursingApp_Jordanian_Case1820() throws InterruptedException, IOException {

		// شهادة عدم المحكومية منتهية الصلاحية

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9661035099"); // National-ID

		driver.findElement(IDNumber).sendKeys("11353957"); // ID-Number

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
		UniversityCountry.selectByVisibleText("الأردن");

		Thread.sleep(Const * 8);

		// University
		Select University = new Select(driver.findElement(UniversityDDL));
		University.selectByVisibleText("الجامعة الاردنية");

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

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب لإصدار تصريح مزاولة مهنة ممرض قانوني نظرا لأن شهادة عدم المحكومية الصادرة قد تجاوزت الثلاث أشهر من تاريخ إصدارها، يرجى إصدار شهادة عدم محكومية حديثة باستخدام الرابط التالي: إصدار شهادة عدم محكومية ، لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

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

	@Test(priority = 21)
	public void SubmitNursingApp_Jordanian_Case1900() throws InterruptedException, IOException {

		// الممرض غير منتسب للنقابة

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 5);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9791048710"); // National-ID

		driver.findElement(IDNumber).sendKeys("11650264"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("707"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لأنك غير منتسب للنقابة يرجى الانتساب للنقابة ومن ثم تقديم طلب تصريح مزاولة مهنة ممرض قانوني. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 06500454";

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

	@Test(priority = 22)
	public void SubmitNursingApp_Jordanian_Case1910() throws InterruptedException, IOException {

		// الممرض غير مسدد لرسوم النقابة

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9772009853"); // National-ID

		driver.findElement(IDNumber).sendKeys("7014120"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("5867"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لأنك غير مسدد للرسوم المترتبة عليك في النقابة يرجى تسديد رسوم النقابة ومن ثم تقديم طلب تصريح مزاولة مهنة ممرض قانوني. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

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

	@Test(priority = 23)
	public void SubmitNursingApp_Jordanian_Case1920() throws InterruptedException, IOException {

		// الممرض منتسب للنقابةولم يتم استرجاع معلوماته

		driver.findElement(Apply).click(); // Select-Service

		// --------------------------------Select-Applicant-Type------------------------------
		Select appType = new Select(driver.findElement(ApplicantTypeDDL)); // Applicant-Type

		appType.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 3);
		driver.findElement(NextToBasicInfo).click(); // Next

		// --------------------------------Fill-Basic-Info---------------------------------

		driver.findElement(NationalID).sendKeys("9592009582"); // National-ID

		driver.findElement(IDNumber).sendKeys("12421454"); // ID-Number

		driver.findElement(AssociationNumber).sendKeys("60982"); // Association-Number

		driver.findElement(Captcha).sendKeys("0000"); // Captcha-Field

		Thread.sleep(Const * 7);

		driver.findElement(VerifyButton).click(); // Verify

		Thread.sleep(Const * 20);

		String ActualErrorMessage = driver.findElement(ErrorMessage).getText();

		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لحدوث خطأ في إسترجاع معلوماتك من نقابة الممرضين، يرجى مراجعة نقابة الممرضين للتأكد من الإنتساب ولتأكد من صحة بياناتك، لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";

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

	@Test(priority = 24)
	public void ViewApplicationAndLicense_Jordanain_Case1101() throws InterruptedException, IOException {

		// الاستعلام عن الطلب وعرض رخصة المزاولة

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("أفراد");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("9882013944"); // National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("12345678"); // Card-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:1:vc1:dc_b2")).click(); // Next

		// -------------------------------View-App----------------------------------

		driver.findElement(By.id("pt1:r1:2:myRequests::ti")).click(); // My-Applications-Tab

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:val00::content")).sendKeys("64"); // Search-For-App-Number

		Thread.sleep(Const);

		driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:val00::content")).sendKeys(Keys.ENTER); // Search

		// driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:_search")).click();
		// //
		// Search

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:2:r1:0:t1:0:l1::text")).click(); // Details

		Thread.sleep(Const * 10);

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.1.0.1_AppDetails.png"));

		driver.findElement(By.id("pt1:r1:2:r1:1:b1")).click(); // Previous

		// driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:_reset")).click();
		// //
		// Clear-Search

		// -------------------------------View-License----------------------------------
		driver.findElement(By.id("pt1:r1:2:myPermits::ti")).click(); // License-Tab

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:val00::content")).sendKeys("64");// Search-For-License

		Thread.sleep(Const);

		driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:val00::content")).sendKeys(Keys.ENTER);// Search

		// driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:_search")).click();
		// //
		// Search

		Thread.sleep(Const * 10);

		// capture screenshot

		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source1, new File("./ScreenShots/LicenseDetailsCase1.1.0.1.png"));

		// -------------------------------Clear----------------------------------

		// driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:_reset")).click();
		// //
		// Clear-Search

		driver.findElement(By.id("pt1:r1:2:b1")).click(); // Home-Page

		System.out.println("Passed. Jordanian - View Application And License 1.1.0.1");

	}

	@Test(priority = 37)
	public void ViewApplicationAndLicense_HealthInstitute_Case2101() throws InterruptedException, IOException {

		// الاستعلام عن الطلب وعرض رخصة المزاولة

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("مؤسسة صحية");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("52317954"); // Institute-National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("41725"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:1:vc1:dc_b2")).click(); // Next

		// -------------------------------View-App----------------------------------

		driver.findElement(By.id("pt1:r1:2:myRequests::ti")).click(); // My-Applications-Tab

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:val00::content")).sendKeys("31"); // Search-For-App-Number

		Thread.sleep(Const);

		driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:val00::content")).sendKeys(Keys.ENTER); // Search

		// driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:_search")).click();
		// //
		// Search

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:2:r1:0:t1:0:l1::text")).click(); // Details

		Thread.sleep(Const * 10);

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case2.1.0.1_AppDetails.png"));

		driver.findElement(By.id("pt1:r1:2:r1:1:b1")).click(); // Previous

		// driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:_reset")).click();
		// //
		// Clear-Search

		// -------------------------------View-License----------------------------------
		driver.findElement(By.id("pt1:r1:2:myPermits::ti")).click(); // License-Tab

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:val00::content")).sendKeys("64");// Search-For-License

		Thread.sleep(Const);

		driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:val00::content")).sendKeys(Keys.ENTER);// Search

		// driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:_search")).click();
		// //
		// Search

		Thread.sleep(Const * 10);

		// capture screenshot

		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source1, new File("./ScreenShots/LicenseDetailsCase2.1.0.1.png"));

		// -------------------------------Clear----------------------------------

		// driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:_reset")).click();
		// //
		// Clear-Search

		driver.findElement(By.id("pt1:r1:2:b1")).click(); // Home-Page

		System.out.println("Passed. Health Institute - View Application And License 2.1.0.1");

	}

	@Test(priority = 37)
	public void ViewApplicationAndLicense_RoyalMedicalServices_Case3101() throws InterruptedException, IOException {

		// الاستعلام عن الطلب وعرض رخصة المزاولة

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("الخدمات الطبية الملكية");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("717144523"); // RMS-National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("523317"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:1:vc1:dc_b2")).click(); // Next

		// -------------------------------View-App----------------------------------

		driver.findElement(By.id("pt1:r1:2:myRequests::ti")).click(); // My-Applications-Tab

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:val00::content")).sendKeys("20"); // Search-For-App-Number

		Thread.sleep(Const);

		driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:val00::content")).sendKeys(Keys.ENTER); // Search

		// driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:_search")).click();
		// //
		// Search

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:2:r1:0:t1:0:l1::text")).click(); // Details

		Thread.sleep(Const * 10);

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case3.1.0.1_AppDetails.png"));

		driver.findElement(By.id("pt1:r1:2:r1:1:b1")).click(); // Previous

		// driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:_reset")).click();
		// //
		// Clear-Search

		// -------------------------------View-License----------------------------------
		driver.findElement(By.id("pt1:r1:2:myPermits::ti")).click(); // License-Tab

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:val00::content")).sendKeys("20");// Search-For-License

		Thread.sleep(Const);

		driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:val00::content")).sendKeys(Keys.ENTER);// Search

		// driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:_search")).click();
		// //
		// Search

		Thread.sleep(Const * 10);

		// capture screenshot

		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source1, new File("./ScreenShots/LicenseDetailsCase3.1.0.1.png"));

		// -------------------------------Clear----------------------------------

		// driver.findElement(By.id("pt1:r1:2:r3:0:qryId1:_reset")).click();
		// //
		// Clear-Search

		driver.findElement(By.id("pt1:r1:2:b1")).click(); // Home-Page

		System.out.println("Passed. Royal Medical Service - View Application And License 3.1.0.1");

	}

	@Test(priority = 25)
	public void MyPage_Individuals_Case7000() throws InterruptedException, IOException {

		// المستخدم غير مسجل في النظام

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("أفراد");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("98526488"); // National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("9813944"); // Card-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "خطأ في معلومات الدخول";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.0.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.0.0.0");

	}

	@Test(priority = 26)
	public void MyPage_Companies_Case7100() throws InterruptedException, IOException {

		// المستخدم غير مسجل في النظام

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("شركة");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("200012345"); // Company-National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("981944"); // Company-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "خطأ في معلومات الدخول";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.1.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.1.0.0");

	}

	@Test(priority = 27)
	public void MyPage_HealthInstitute_Case7200() throws InterruptedException, IOException {

		// المستخدم غير مسجل في النظام

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("مؤسسة صحية");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("9882013944"); // Company-National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("981944"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "لا يوجد حساب";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.2.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.2.0.0");

	}

	@Test(priority = 28)
	public void MyPage_RoyalMedicalServices_Case7200_2() throws InterruptedException, IOException {

		// المستخدم غير مسجل في النظام

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("الخدمات الطبية الملكية");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("205646454"); // Company-National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("981944"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "لا يوجد حساب";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.2.0.0_2.png"));

		System.out.println("Passed. My Page - Individual 7.2.0.0_2");

	}

	@Test(priority = 29)
	public void MyPage_Individuals_Case7300() throws InterruptedException, IOException {

		// المعلومات غير مطابقة

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("أفراد");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("9882013944"); // National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("9813944"); // Card-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "خطأ في معلومات الدخول";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.3.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.3.0.0");

	}

	@Test(priority = 30)
	public void MyPage_Companies_Case7300_2() throws InterruptedException, IOException {

		// معلومات الدخول غير مطابقة

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("شركة");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("200012345"); // Company-National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("981944"); // Company-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "خطأ في معلومات الدخول";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.3.0.0_2.png"));

		System.out.println("Passed. My Page - Individual 7.3.0.0_2");

	}

	@Test(priority = 31)
	public void MyPage_HealthInstitute_Case7300_3() throws InterruptedException, IOException {

		Integer Const = 100;

		// معلومات الدخول غير مطابقة

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("مؤسسة صحية");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("200000000"); // Company-National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("2000"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "خطأ في معلومات الدخول";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.3.0.0_3.png"));

		System.out.println("Passed. My Page - Individual 7.3.0.0_3");

	}

	@Test(priority = 32)
	public void MyPage_RoyalMedicalServices_Case7300_4() throws InterruptedException, IOException {

		// معلومات الدخول غير مطابقة

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("الخدمات الطبية الملكية");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("200040000"); // Company-National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("4000"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "خطأ في معلومات الدخول";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.3.0.0_4.png"));

		System.out.println("Passed. My Page - Individual 7.3.0.0_4");

	}

	@Test(priority = 33)
	public void MyPage_RoyalMedicalServices_Case7400() throws InterruptedException, IOException {

		// معلومات الدخول غير مطابقة – نوع المستخدم خطأ

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("الخدمات الطبية الملكية");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("200000000"); // Company-National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("20000"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "خطأ في معلومات الدخول";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.4.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.4.0.0");

	}

	@Test(priority = 34)
	public void MyPage_WrongVerificationCode_Case7500() throws InterruptedException, IOException {

		// خطأ في رمز التحقق المدخل

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("أفراد");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("9882013944"); // National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("12345678"); // Card-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Search

		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:vc1:dc_it1::content")).sendKeys("0010"); // Verification-Code

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:1:vc1:dc_b2")).click(); // Next

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "خطأ في رمز التحقق المدخل";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.5.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.5.0.0");

	}

	@Test(priority = 35)
	public void ContactUs_Case8000() throws InterruptedException, IOException {

		// ارسال استفسار

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

		driver.findElement(By.id("pt1:it7::content")).sendKeys(" نص الرسالة نص الرسالة نص الرسالة نص الرسالة");

		driver.findElement(By.id("pt1:itCaptchaValue::content")).sendKeys("0000"); // Captcha

		driver.findElement(By.id("pt1:b2")).click(); // Send

		// Assert

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "تم تقديم إستفسار بنجاح، رقم المرجعية هو";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case8.0.0.0.png"));

		System.out.println("Passed. Contact Us 8.0.0.0");

	}

	@Test(priority = 36)
	public void ContactUs_Case8100() throws InterruptedException, IOException {

		// ارسال اقتراح

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

		driver.findElement(By.id("pt1:it7::content")).sendKeys("ارسال اقتراح ارسال اقتراح ارسال اقتراح ارسال اقتراح");

		driver.findElement(By.id("pt1:itCaptchaValue::content")).sendKeys("0000"); // Captcha

		driver.findElement(By.id("pt1:b2")).click(); // Send

		// Assert

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "تم تقديم إقتراح بنجاح، رقم المرجعية هو";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case8.1.0.0.png"));

		System.out.println("Passed. Contact Us 8.1.0.0");

	}

	@Test(priority = 36)
	public void ContactUs_Case8200() throws InterruptedException, IOException {

		// ارسال شكوى

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

		driver.findElement(By.id("pt1:it7::content")).sendKeys("ارسال شكوى ارسال شكوى ارسال شكوى ارسال شكوى");

		driver.findElement(By.id("pt1:itCaptchaValue::content")).sendKeys("0000"); // Captcha

		driver.findElement(By.id("pt1:b2")).click(); // Send

		// Assert

		Thread.sleep(Const * 10);

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "تم تقديم شكاوى بنجاح، رقم المرجعية";

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

		// تعديل معلومات الاتصال

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("أفراد");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("9882013944"); // National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("12345678"); // Card-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Continue

		Thread.sleep(Const * 10);

		// ---------------------------EditContactDetails--------------------
		this.EditContactDetails();

		System.out.println("Passed. Edited Jordanian Details");
	}

	@Test(priority = 39)
	public void MyPage_EditContactDetails_HealthInstitute() throws InterruptedException, IOException {

		// تعديل معلومات الاتصال

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("مؤسسة صحية");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("52317954"); // Institute-National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("41725"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Continue

		Thread.sleep(Const * 10);

		// -----------------------EditContactDeatils-----------------------
		this.EditContactDetails();

		System.out.println("Passed. Edited Health Institute Details.");
	}

	@Test(priority = 40)
	public void MyPage_EditContactDetails_RoyalMedicalServices() throws InterruptedException, IOException {

		// تعديل معلومات الاتصال

		driver.findElement(By.id("MyAppsImg")).click(); // My-Page

		Select appType = new Select(driver.findElement(By.id("pt1:r1:0:soc1::content"))); // Applicant-Type
		appType.selectByVisibleText("الخدمات الطبية الملكية");

		Thread.sleep(Const * 3);

		driver.findElement(By.id("pt1:r1:0:it1::content")).sendKeys("717144523"); // RMS-National-ID

		driver.findElement(By.id("pt1:r1:0:it2::content")).sendKeys("523317"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(By.id("pt1:r1:0:b1")).click(); // Continue

		Thread.sleep(Const * 10);

		// -------------------EditContactDetails----------------------
		this.EditContactDetails();

		System.out.println("Passed. Edited Royal Medical Services Details");

	}

	// end

}
