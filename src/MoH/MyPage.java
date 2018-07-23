package MoH;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.testng.annotations.Test;


public class MyPage extends RNVLFields{

	WebDriver driver;
	Integer Const = 800;
	
	
	public void ViewApplicationAndLicense_Jordanain_Case1101(String KeepAppNo, String NationalIDValue, String IDNumberVlaue ) throws InterruptedException, IOException {

		// «·«” ⁄·«„ ⁄‰ «·ÿ·» Ê⁄—÷ —Œ’… «·„“«Ê·…
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://ohs-vip:4443/public/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("√›—«œ");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys(NationalIDValue); // National-ID

		driver.findElement(MyPageCardNo).sendKeys(IDNumberVlaue); // Card-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		driver.findElement(LoginVerificationCode).sendKeys("0000"); // Verification-Code

		Thread.sleep(Const * 2);

		driver.findElement(NextToMyPage).click(); // Next

		// -------------------------------View-App----------------------------------

		driver.findElement(MyAppTab).click(); // My-Applications-Tab

		Thread.sleep(Const * 10);

		driver.findElement(SearchForApp).sendKeys(KeepAppNo); // Search-For-App-Number

		Thread.sleep(Const);

		driver.findElement(SearchForApp).sendKeys(Keys.ENTER); // Search

		Thread.sleep(Const * 2);

		driver.findElement(DetailsLink).click(); // Details

		Thread.sleep(Const * 10);

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.1.0.1_AppDetails.png"));
		
		driver.findElement(PreviousToApps).click(); // Previous

		// -------------------------------View-License----------------------------------
		driver.findElement(MyLicenseTab).click(); // License-Tab

		Thread.sleep(Const * 10);

//		driver.findElement(LicenseDate).sendKeys(date1);
//		
//		Thread.sleep(Const);
//
//		driver.findElement(SearchForLicense).sendKeys(Keys.ENTER);// Search
//
//		Thread.sleep(Const * 5);
//		
//		driver.findElement(DetailsLink).click();
//
//		Thread.sleep(Const * 10);
		
		// capture screenshot

		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source1, new File("./ScreenShots/LicenseDetailsCase1.1.0.1.png"));

		// -------------------------------Clear----------------------------------

		
		driver.findElement(By.id("GoToHomePage")).click(); // Home-Page

		System.out.println("Passed. Jordanian - View Application And License 1.1.0.1");

	}

	
	public void ViewApplicationAndLicense_HealthInstitute_Case2101(String KeepAppNo) throws InterruptedException, IOException {

		// «·«” ⁄·«„ ⁄‰ «·ÿ·» Ê⁄—÷ —Œ’… «·„“«Ê·…
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://ohs-vip:4443/public/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("„ƒ””… ’ÕÌ…");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("52317954"); // Institute-National-ID

		driver.findElement(MyPageCardNo).sendKeys("41725"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		driver.findElement(LoginVerificationCode).sendKeys("0000"); // Verification-Code

		Thread.sleep(Const * 2);

		driver.findElement(NextToMyPage).click(); // Next

		// -------------------------------View-App----------------------------------

		driver.findElement(MyAppTab).click(); // My-Applications-Tab

		Thread.sleep(Const * 10);

		driver.findElement(SearchForApp).sendKeys(KeepAppNo); // Search-For-App-Number

		Thread.sleep(Const);

		driver.findElement(SearchForApp).sendKeys(Keys.ENTER); // Search

		// driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:_search")).click();
		// //
		// Search

		Thread.sleep(Const * 10);

		driver.findElement(DetailsLink).click(); // Details

		Thread.sleep(Const * 10);

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case2.1.0.1_AppDetails.png"));

		driver.findElement(PreviousToApps).click(); // Previous

		// driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:_reset")).click();
		// //
		// Clear-Search

		// -------------------------------View-License----------------------------------
		driver.findElement(MyLicenseTab).click(); // License-Tab

		Thread.sleep(Const * 10);

		driver.findElement(SearchForLicense).sendKeys(KeepAppNo);// Search-For-License

		Thread.sleep(Const);

		driver.findElement(SearchForLicense).sendKeys(Keys.ENTER);// Search

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

		driver.findElement(By.id("GoToHomePage")).click(); // Home-Page

		System.out.println("Passed. Health Institute - View Application And License 2.1.0.1");

	}

	
	public void ViewApplicationAndLicense_RoyalMedicalServices_Case3101(String KeepAppNo) throws InterruptedException, IOException {

		// «·«” ⁄·«„ ⁄‰ «·ÿ·» Ê⁄—÷ —Œ’… «·„“«Ê·…
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://ohs-vip:4443/public/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("«·Œœ„«  «·ÿ»Ì… «·„·ﬂÌ…");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("717144523"); // RMS-National-ID

		driver.findElement(MyPageCardNo).sendKeys("523317"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		driver.findElement(LoginVerificationCode).sendKeys("0000"); // Verification-Code

		Thread.sleep(Const * 2);

		driver.findElement(NextToMyPage).click(); // Next

		// -------------------------------View-App----------------------------------

		driver.findElement(MyAppTab).click(); // My-Applications-Tab

		Thread.sleep(Const * 10);

		driver.findElement(SearchForApp).sendKeys(KeepAppNo); // Search-For-App-Number

		Thread.sleep(Const);

		driver.findElement(SearchForApp).sendKeys(Keys.ENTER); // Search

		// driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:_search")).click();
		// //
		// Search

		Thread.sleep(Const * 10);

		driver.findElement(DetailsLink).click(); // Details

		Thread.sleep(Const * 10);

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case3.1.0.1_AppDetails.png"));

		driver.findElement(PreviousToApps).click(); // Previous

		// driver.findElement(By.id("pt1:r1:2:r1:0:qryId1:_reset")).click();
		// //
		// Clear-Search

		// -------------------------------View-License----------------------------------
		driver.findElement(MyLicenseTab).click(); // License-Tab

		Thread.sleep(Const * 10);

		driver.findElement(SearchForLicense).sendKeys(KeepAppNo);// Search-For-License

		Thread.sleep(Const);

		driver.findElement(SearchForLicense).sendKeys(Keys.ENTER);// Search

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

		driver.findElement(By.id("GoToHomePage")).click(); // Home-Page

		System.out.println("Passed. Royal Medical Service - View Application And License 3.1.0.1");

	}

	
	public void MyPage_Individuals_Case7000() throws InterruptedException, IOException {

		// «·„” Œœ„ €Ì— „”Ã· ›Ì «·‰Ÿ«„
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://ohs-vip:4443/public/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("√›—«œ");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("98526488"); // National-ID

		driver.findElement(MyPageCardNo).sendKeys("9813944"); // Card-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "Œÿ√ ›Ì „⁄·Ê„«  «·œŒÊ·";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.0.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.0.0.0");

	}

	
	public void MyPage_Companies_Case7100() throws InterruptedException, IOException {

		// «·„” Œœ„ €Ì— „”Ã· ›Ì «·‰Ÿ«„
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://ohs-vip:4443/public/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("‘—ﬂ…");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("200012345"); // Company-National-ID

		driver.findElement(MyPageCardNo).sendKeys("981944"); // Company-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "Œÿ√ ›Ì „⁄·Ê„«  «·œŒÊ·";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.1.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.1.0.0");

	}

	
	public void MyPage_HealthInstitute_Case7200() throws InterruptedException, IOException {

		// «·„” Œœ„ €Ì— „”Ã· ›Ì «·‰Ÿ«„
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://ohs-vip:4443/public/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("„ƒ””… ’ÕÌ…");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("9882013944"); // Company-National-ID

		driver.findElement(MyPageCardNo).sendKeys("981944"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "·« ÌÊÃœ Õ”«»";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.2.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.2.0.0");

	}

	
	public void MyPage_RoyalMedicalServices_Case7200_2() throws InterruptedException, IOException {

		// «·„” Œœ„ €Ì— „”Ã· ›Ì «·‰Ÿ«„
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://ohs-vip:4443/public/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("«·Œœ„«  «·ÿ»Ì… «·„·ﬂÌ…");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("205646454"); // Company-National-ID

		driver.findElement(MyPageCardNo).sendKeys("981944"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "·« ÌÊÃœ Õ”«»";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.2.0.0_2.png"));

		System.out.println("Passed. My Page - Individual 7.2.0.0_2");

	}

	
	public void MyPage_Individuals_Case7300() throws InterruptedException, IOException {

		// «·„⁄·Ê„«  €Ì— „ÿ«»ﬁ…
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://ohs-vip:4443/public/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("√›—«œ");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("9882013944"); // National-ID

		driver.findElement(MyPageCardNo).sendKeys("9813944"); // Card-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "Œÿ√ ›Ì „⁄·Ê„«  «·œŒÊ·";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.3.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.3.0.0");

	}

	
	public void MyPage_Companies_Case7300_2() throws InterruptedException, IOException {

		// „⁄·Ê„«  «·œŒÊ· €Ì— „ÿ«»ﬁ…

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("‘—ﬂ…");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("200012345"); // Company-National-ID

		driver.findElement(MyPageCardNo).sendKeys("981944"); // Company-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "Œÿ√ ›Ì „⁄·Ê„«  «·œŒÊ·";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.3.0.0_2.png"));

		System.out.println("Passed. My Page - Individual 7.3.0.0_2");

	}

	
	public void MyPage_HealthInstitute_Case7300_3() throws InterruptedException, IOException {

		Integer Const = 100;

		// „⁄·Ê„«  «·œŒÊ· €Ì— „ÿ«»ﬁ…

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("„ƒ””… ’ÕÌ…");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("200000000"); // Company-National-ID

		driver.findElement(MyPageCardNo).sendKeys("2000"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "Œÿ√ ›Ì „⁄·Ê„«  «·œŒÊ·";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.3.0.0_3.png"));

		System.out.println("Passed. My Page - Individual 7.3.0.0_3");

	}

	
	public void MyPage_RoyalMedicalServices_Case7300_4() throws InterruptedException, IOException {

		// „⁄·Ê„«  «·œŒÊ· €Ì— „ÿ«»ﬁ…

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("«·Œœ„«  «·ÿ»Ì… «·„·ﬂÌ…");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("200040000"); // Company-National-ID

		driver.findElement(MyPageCardNo).sendKeys("4000"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "Œÿ√ ›Ì „⁄·Ê„«  «·œŒÊ·";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.3.0.0_4.png"));

		System.out.println("Passed. My Page - Individual 7.3.0.0_4");

	}

	
	public void MyPage_RoyalMedicalServices_Case7400() throws InterruptedException, IOException {

		// „⁄·Ê„«  «·œŒÊ· €Ì— „ÿ«»ﬁ… ñ ‰Ê⁄ «·„” Œœ„ Œÿ√

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("«·Œœ„«  «·ÿ»Ì… «·„·ﬂÌ…");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("200000000"); // Company-National-ID

		driver.findElement(MyPageCardNo).sendKeys("20000"); // Private-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "Œÿ√ ›Ì „⁄·Ê„«  «·œŒÊ·";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.4.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.4.0.0");

	}

	
	public void MyPage_WrongVerificationCode_Case7500() throws InterruptedException, IOException {

		// Œÿ√ ›Ì —„“ «· Õﬁﬁ «·„œŒ·

		driver.findElement(GoToMyPage).click(); // My-Page

		Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
		appType.selectByVisibleText("√›—«œ");

		Thread.sleep(Const * 3);

		driver.findElement(MyPageNationalNumber).sendKeys("9882013944"); // National-ID

		driver.findElement(MyPageCardNo).sendKeys("12345678"); // Card-No

		Thread.sleep(Const * 2);

		driver.findElement(MyPageSearch).click(); // Search

		Thread.sleep(Const * 10);

		driver.findElement(LoginVerificationCode).sendKeys("0010"); // Verification-Code

		Thread.sleep(Const * 2);

		driver.findElement(NextToMyPage).click(); // Next

		Thread.sleep(Const * 10);

		// Assert

		String ActualResult = driver.findElement(ErrorMessage).getText();

		System.out.println("Actual Message: " + ActualResult);

		String ExpectedResult = "Œÿ√ ›Ì —„“ «· Õﬁﬁ «·„œŒ·";

		System.out.println("Expected Message: " + ExpectedResult);

		Assert.assertTrue(ActualResult.contains(ExpectedResult));

		// capture screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case7.5.0.0.png"));

		System.out.println("Passed. My Page - Individual 7.5.0.0");

	}


//	 public static String Date(String[] args) {
//		 
//		 // Create object of SimpleDateFormat class and decide the format
//		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
//		 
//		 //get current date time with Date()
//		 Date date = new Date();
//		 
//		 // Now format the date
//		 String date1= dateFormat.format(date);
//		 
//		 // Print the Date
//		return date1;
//		 
//		 }

	
}
