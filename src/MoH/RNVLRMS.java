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
	public static final String AppNo = null;
	WebDriver driver = new ChromeDriver();
	Integer Const = 200;

	@BeforeMethod
//	@Parameters("browsers")
//	public void CrossBrowser(String browsername) throws Exception {
//		// Check if parameter passed from TestNG is 'Chrome'
//		if (browsername.equalsIgnoreCase("Chrome")) {
//			// create Chrome instance
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nftaiha\\Desktop\\RNVL-MoH\\chromedriver.exe");
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.get("https://172.16.0.254:4443/public/index.html");
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		} else
//		// Check if parameter passed from TestNG is 'firefox'
//		if (browsername.equalsIgnoreCase("Firefox")) {
//			// create firefox instance
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\nftaiha\\Desktop\\RNVL-MoH\\geckodriver.exe");
//			driver = new FirefoxDriver();
//			driver.manage().window().maximize();
//			driver.get("https://172.16.0.254:4443/public/index.html");
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
//			System.setProperty("webdriver.ie.driver", "C:\\Users\\nftaiha\\Desktop\\RNVL-MoH\\IEDriverServer.exe");
//			WebDriver driver = new InternetExplorerDriver();
//			driver.manage().window().maximize();
//			// driver.get("https://172.16.0.254:4443/public/index.html");
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
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nftaiha\\Desktop\\RNVL-MoH\\chromedriver.exe");
		driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\emasoud\\Desktop\\geckodriver.exe");
		// driver = new FirefoxDriver();
		driver.get("https://172.16.0.254:4443/public/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	// submit successfully
	@Test(priority = 1, enabled = true, retryAnalyzer = MoH.RetryAnalyzer.class)
	public void SubmitNursingApp_RMS_Case3000() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID

		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number
		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("2005"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9671027235"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		Thread.sleep(Const * 20);
		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 20);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("الجامعة الاردنية");
		Thread.sleep(Const * 20);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:4:btnOtherDataNextButton")).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:link1::icon")).click(); // Rate-Happy
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:it1::content")).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:b2")).click(); // Submit
		
	
//----------------------------------------Assert-------------------------
		String ActualResult = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol7")).getText();
		System.out.println("Actual " + ActualResult);
		String ExpectedResult ="تم تقديم طلبك بنجاح. سيتم مراجعته من قبل المعنيين وموافاتك بالتطورات خلال () عبر الرسائل القصيرة والبريد الإلكتروني. كما ويمكنك استخدام خيار صفحتي الموجود في الصفحة الرئيسية لمتابعة طلبك";
		System.out.println("Expected " + ExpectedResult);
		String AppNo = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol5")).getText();
		System.out.println("Application Number: " + AppNo);
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		// ---------------------------------TakeScreenSHot------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3000-ApplicationNoRMS.png"));
		System.out.println("RMS 3.0.0.0" + ActualResult);
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:6:fp1:dc_pgl2")).click(); // Home-Page
//----Internal-------------
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("71445826"); // National-ID

		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("71445"); // Private Number

		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("10224"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9671027235"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		// --------------------Assert---------------------

		Thread.sleep(Const * 10);
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "رقم قيد المنشأة الوطني غير موجود، يرجى مراجعة وزارة الصحة لإنشاء حساب خاص بك. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID

		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("71445"); // Private Number

		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("10224"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9671027235"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 10);
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "الرقم الخاص غير صحيح، يرجى التأكد من صحة الرقم المدخل. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("2005"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9671027235"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 30);
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
		Thread.sleep(Const * 20);

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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// RMS
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID

		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number

		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("1009"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9612004436"); // Military ID-No
		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 10);
		// -------------Assert---------------------
		String ActualErrorMessage = driver
				.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div"))
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لوجود تصريح مزاولة مهنة ممرض قانوني سابق. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID

		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number

		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("1009"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9882773822"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code

		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		// ----------------------Assert-----------------------
		Thread.sleep(Const * 20);
		String ActualErrorMessage = driver.findElement(By.xpath("pt1:exceptionMsg")).getText();

		System.out.println("Actual Message: " + ActualErrorMessage);

		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "الرقم الوطني المدخل غير صحيح، يرجى التأكد من صحة الرقم الوطني. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID

		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number

		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("5882628"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9652023349"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton

		// ----------------------Assert-----------------------
		String ActualErrorMessage = driver
				.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div"))
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage ="الرقم الوطني المدخل لشخص متوفي. لا يمكنك استكمال تقديم الطلب. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID

		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number

		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4344"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9741013295"); // Military ID-No
		//Database 123456789
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("الجامعة الاردنية");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2014"); // Graduation-Year

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button

		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 10);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3600-HighScholInfoNotRetrieved.png"));

		// -------------------------------Attachments-Section-----------------------
		// -----------------Assert for warning message --------------------
		// String ActualErrorMessage =
		// driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
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

		driver.findElement(By.id("pt1:r1:4:it2hh:0:cif1:bButtonFile")).click(); // Choose File
		Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		Thread.sleep(Const * 20);
		driver.findElement(By.id("pt1:r1:4:bAttamentNext")).click(); // Next-Button
		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 20);
		driver.findElement(By.id("pt1:r1:5:btnOtherDataNextButton")).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:6:rs1:link1::icon")).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:it1::content")).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:b2")).click(); // Submit

		//----------------------------------------Assert-------------------------
				String ActualResult = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol7")).getText();
				System.out.println("Actual " + ActualResult);
				String ExpectedResult ="تم تقديم طلبك بنجاح. سيتم مراجعته من قبل المعنيين وموافاتك بالتطورات خلال () عبر الرسائل القصيرة والبريد الإلكتروني. كما ويمكنك استخدام خيار صفحتي الموجود في الصفحة الرئيسية لمتابعة طلبك";
				System.out.println("Expected " + ExpectedResult);
				String AppNo = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol5")).getText();
				System.out.println("Application Number: " + AppNo);
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
		driver.findElement(By.id("pt1:r1:6:fp1:dc_b1")).click(); // Home-Page
	}

	// Bachelor's degree info not retrieved in MOHE table
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3700() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID

		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number

		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("19728"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9872003176"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة مؤته");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2016"); // Graduation-Year

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("14374"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9831038134"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 20);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 20);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 20);

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 20);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 30);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("كلية الاميرة منى للتمريض");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("1998"); // Graduation-Year
//		// Equivelant document number field
//		Thread.sleep(Const * 10);
//		driver.findElement(By.id("pt1:r1:3:itEquationNo::content")).sendKeys("142544");
		// Degree
		Thread.sleep(Const * 20);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:4:btnOtherDataNextButton")).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:link1::icon")).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:it1::content")).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:b2")).click(); // Submit
		//----------------------------------------Assert-------------------------
				String ActualResult = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol7")).getText();
				System.out.println("Actual " + ActualResult);
				String ExpectedResult ="تم تقديم طلبك بنجاح. سيتم مراجعته من قبل المعنيين وموافاتك بالتطورات خلال () عبر الرسائل القصيرة والبريد الإلكتروني. كما ويمكنك استخدام خيار صفحتي الموجود في الصفحة الرئيسية لمتابعة طلبك";
				System.out.println("Expected " + ExpectedResult);
				String AppNo = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol5")).getText();
				System.out.println("Application Number: " + AppNo);
				Assert.assertTrue(ActualResult.contains(ExpectedResult));
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("14741"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9702025986"); // Military ID-No 
		//DB was 12345688 in MOHE
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian
		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 10);
		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		// -----Bachelor-Degree-Frame-----
		Thread.sleep(Const * 10);
		// University-Country
		Thread.sleep(Const * 20);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الكويت");
		Thread.sleep(Const * 10);
		// University
		Thread.sleep(Const * 30);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة الكويت");
		Thread.sleep(Const * 20);
		Thread.sleep(Const * 10);
		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2016"); // Graduation-Year
		Thread.sleep(Const * 20);
		// Equivelant document number field
		Thread.sleep(Const * 20);
		driver.findElement(By.id("pt1:r1:3:itEquationNo::content")).sendKeys("14242");
		// Degree
		Thread.sleep(Const * 20);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor
		Thread.sleep(Const * 20);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button
		Thread.sleep(Const * 50);
		// ----------------------Assert-----------------------
		Thread.sleep(Const * 20);
		String ActualErrorMessage = driver.findElement(By.xpath("pt1:exceptionMsg")).getText();

		System.out.println("Actual Message: " + ActualErrorMessage);

		Thread.sleep(Const * 20);
		String ExpectedErrorMessage = "معلومات البكالوريوس المدخلة غير صحيحة. لا يمكنك استكمال تقديم الطلب. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
		System.out.println("ExpectedErrorMessage: " + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		// ---------------------------------Take
		// ScreenShot------------------------------
		Thread.sleep(Const * 30);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots-RMS/Case3721-IncorrectEq.No.png"));

	}

	// Studied university outside Jordan
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3720() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("6133"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9761018598"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 20);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 20);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 20);

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 20);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("فرنسا");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 20);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("Centre International de Recontre Mathematiques");
		Thread.sleep(Const * 20);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2005"); // Graduation-Year
		Thread.sleep(Const * 20);

		// Equivalent document number field
		Thread.sleep(Const * 20);
		driver.findElement(By.id("pt1:r1:3:itEquationNo::content")).sendKeys("12344");
		// Degree
		Thread.sleep(Const * 20);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:4:btnOtherDataNextButton")).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:link1::icon")).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:it1::content")).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:b2")).click(); // Submit

		//----------------------------------------Assert-------------------------
				String ActualResult = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol7")).getText();
				System.out.println("Actual " + ActualResult);
				String ExpectedResult ="تم تقديم طلبك بنجاح. سيتم مراجعته من قبل المعنيين وموافاتك بالتطورات خلال () عبر الرسائل القصيرة والبريد الإلكتروني. كما ويمكنك استخدام خيار صفحتي الموجود في الصفحة الرئيسية لمتابعة طلبك";
				System.out.println("Expected " + ExpectedResult);
				String AppNo = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol5")).getText();
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

		driver.findElement(By.id("pt1:r1:6:fp1:dc_b1")).click(); // Home-Page
	}

	// Governmental outside , before 2001
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3730() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 20);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID
		Thread.sleep(Const * 20);

		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number
		Thread.sleep(Const * 20);

		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("1709"); // Association-Number
		Thread.sleep(Const * 20);

		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9652023349"); // Military ID-No
		//174147441 DB MoHE 
		//9652023124
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code

		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------
		Thread.sleep(Const * 20);

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 20);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Thread.sleep(Const * 20);
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		// ---------------------------------Bachelor-Degree-Frame----------------
		Thread.sleep(Const * 20);

		// University-Country
		Thread.sleep(Const * 20);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("مصر");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 50);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة القاهرة");
		// Admission date
		Thread.sleep(Const * 50);
		Select Admission = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicStudyYearRid::content")));
		Admission.selectByVisibleText("1998"); // Graduation-Year
		Thread.sleep(Const * 50);

		// Degree
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor
		Thread.sleep(Const * 20);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2016"); // Graduation-Year
		Thread.sleep(Const * 20);

		// Equivalent document number field
		// Thread.sleep(Const*10);
		// driver.findElement(By.id("pt1:r1:3:itEquationNo::content")).sendKeys("142544");
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		//---Assert Warning----
		
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:4:btnOtherDataNextButton")).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:link1::icon")).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:it1::content")).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:b2")).click(); // Submit

		//----------------------------------------Assert-------------------------
				String ActualResult = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol7")).getText();
				System.out.println("Actual " + ActualResult);
				String ExpectedResult ="تم تقديم طلبك بنجاح. سيتم مراجعته من قبل المعنيين وموافاتك بالتطورات خلال () عبر الرسائل القصيرة والبريد الإلكتروني. كما ويمكنك استخدام خيار صفحتي الموجود في الصفحة الرئيسية لمتابعة طلبك";
				System.out.println("Expected " + ExpectedResult);
				String AppNo = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol5")).getText();
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
		driver.findElement(By.id("pt1:r1:6:fp1:dc_pgl2")).click(); // Home-Page
	}

	// Governmental outside , After 2001
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3731() throws InterruptedException, IOException {
		// click on submit application button
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID

		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number

		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("10124"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9831051441"); // Military ID-No
		//DB MOHE 1238897452
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code

		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const * 50);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("العراق");
		// UniversityCountry.selectByIndex(139); // Jordan

		// University
		Thread.sleep(Const * 50);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة تكريت");
		// Admission date
		Thread.sleep(Const * 50);
		Select Admission = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicStudyYearRid::content")));
		Admission.selectByVisibleText("2002");
		Thread.sleep(Const * 50);

		// Degree
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor
		Thread.sleep(Const * 50);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2016"); // Graduation-Year
		Thread.sleep(Const * 50);

		// Equivalent document number field
		Thread.sleep(Const * 20);
		driver.findElement(By.id("pt1:r1:3:itEquationNo::content")).sendKeys("99999");

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:4:btnOtherDataNextButton")).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:link1::icon")).click(); // Rate-Happy

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:it1::content")).sendKeys("سعيد"); // Notes
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:5:rs1:b2")).click(); // Submit
		Thread.sleep(Const * 50);

		//----------------------------------------Assert-------------------------
				String ActualResult = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol7")).getText();
				System.out.println("Actual " + ActualResult);
				String ExpectedResult ="تم تقديم طلبك بنجاح. سيتم مراجعته من قبل المعنيين وموافاتك بالتطورات خلال () عبر الرسائل القصيرة والبريد الإلكتروني. كما ويمكنك استخدام خيار صفحتي الموجود في الصفحة الرئيسية لمتابعة طلبك";
				System.out.println("Expected " + ExpectedResult);
				String AppNo = driver.findElement(By.id("pt1:r1:6:fp1:dc_ol5")).getText();
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
		driver.findElement(By.id("pt1:r1:6:fp1:dc_pgl2")).click(); // Home-Page
	}

	// Not graduated user
	@Test(priority = 7, enabled = true)
	public void SubmitNursingApp_RMS_Case3740() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nftaiha\\eclipse-MoH-UAT\\MoH-UAT\\src\\chromedriver.exe");
		// click on submit application button
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);

		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID

		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number

		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("2639"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9671008411"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code

		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 10);

		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const * 10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 10);

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter

		// -----Bachelor-Degree-Frame-----
		Thread.sleep(Const * 50);

		// University-Country
		Thread.sleep(Const * 50);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan
		Thread.sleep(Const * 50);

		// University
		Thread.sleep(Const * 50);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("الجامعة الاردنية");
		Thread.sleep(Const * 10);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2013"); // Graduation-Year
		Thread.sleep(Const * 10);

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button
		Thread.sleep(Const * 10);

		// --------------------------Assert----------------------------
		String ActualErrorMessage = driver
				.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div"))
				.getText();
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("7057"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9791048710"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const * 20);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian
		Thread.sleep(Const * 20);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 20);
		Thread.sleep(Const * 20);

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		Thread.sleep(Const * 20);

		// ------------------------Bachelor-Degree-Frame--------------------
		// University-Country
		Thread.sleep(Const * 20);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan
		Thread.sleep(Const * 20);

		// University
		Thread.sleep(Const * 20);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة العلوم والتكنولوجيا الأردنية");
		Thread.sleep(Const * 20);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2016"); // Graduation-Year
		Thread.sleep(Const * 20);

		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button
		Thread.sleep(Const * 20);

		// --------------------------Assert----------------------------
		String ActualErrorMessage = driver
				.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div"))
				.getText();
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("10145"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9831010395"); // Military ID-No
		//DB MOHE 123877221
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const * 20);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		
		// Schooling-System
		Thread.sleep(Const * 30);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian
		Thread.sleep(Const * 20);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const * 20);

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		Thread.sleep(Const * 20);

		// ------------------------Bachelor-Degree-Frame--------------------
		// University-Country
		Thread.sleep(Const * 10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الكويت");
		// UniversityCountry.selectByIndex(139); // Jordan
		Thread.sleep(Const * 20);

		// University
		Thread.sleep(Const * 10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة الكويت");
		Thread.sleep(Const * 20);

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2016"); // Graduation-Year
		Thread.sleep(Const * 20);

		// Equivelant document number field
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:3:itEquationNo::content")).sendKeys("741224");
		// Degree
		Thread.sleep(Const * 10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button
		// ----------------------Assert-----------------------
		String ActualErrorMessage = driver
				.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div"))
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لأن حالة شهادة البكالوريوس \"غير معادلة\"، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("7412"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9791048710"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton

		// ----------------------Assert-----------------------
		String ActualErrorMessage = driver
				.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div"))
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لأن الممرض غير منتسب للنقابة، يرجى الانتساب للنقابة ومن ثم تقديم  طلب تصريح مزاولة مهنة ممرض قانوني. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 06500454";
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("5867"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9772009853"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton

		// ----------------------Assert-----------------------
		String ActualErrorMessage = driver
				.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div"))
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);
		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لأن الممرض غير مسدد للرسوم المترتبة عليه في النقابة، يرجى تسديد رسوم النقابة ومن ثم تقديم طلب تصريح مزاولة مهنة ممرض قانوني. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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
		driver.findElement(By.cssSelector("#txt19")).click();
		// user type ddl
		Select userType = new Select(
				driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
		// //health institute
		userType.selectByIndex(3);
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
		Thread.sleep(Const * 10);
		// --------------------------------Fill-Basic-Info---------------------------------
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("717144523"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("523317"); // Private Number
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("60982"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itMilitaryNo::content")).sendKeys("9592009582"); // Military ID-No
		Thread.sleep(Const * 10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000"); // Captcha code
		Thread.sleep(Const * 10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		// -------------Assert---------------------
		String ActualErrorMessage = driver
				.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div"))
				.getText();
		System.out.println("Actual Message: " + ActualErrorMessage);

		Thread.sleep(Const * 10);
		String ExpectedErrorMessage = "لا يمكنك استكمال تقديم الطلب نظرا لحدوث خطأ في إسترجاع معلومات الممرض من نقابة الممرضين، يرجى مراجعة نقابة الممرضين للتأكد من الإنتساب وصحة البيانات. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
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

