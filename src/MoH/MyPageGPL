package MoH;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class MyPageGPL extends GPLFields{

		WebDriver driver;
		Integer Const = 900;
		
		public void CallBrowser() throws InterruptedException{
				
			System.setProperty("webdriver.chrome.driver", ChromeDriver);
			driver = new ChromeDriver();
			
		//	 System.setProperty("webdriver.ie.driver",IEDriver);
		//	 driver = new InternetExplorerDriver();

			driver.manage().window().maximize();
	
			driver.get(ExternalTesting);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
		//	driver.findElement(By.id("overridelink")).click();
			
			Thread.sleep(Const * 5);
			
			driver.findElement(GoToMyPage).click(); // My-Page
					
		}
		
		public void ViewApplication_Jordanain_Case4101(String KeepAppNo, String NationalIDValue, String IDNumberValue ) throws InterruptedException, IOException {

			// الاستعلام عن الطلب  
			
			this.CallBrowser();

			Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
			appType.selectByVisibleText(Individual);

			Thread.sleep(Const * 3);

			driver.findElement(MyPageNationalNumber).sendKeys(NationalIDValue); // National-ID

			driver.findElement(MyPageCardNo).sendKeys(IDNumberValue); // Card-No

			Thread.sleep(Const * 2);

			driver.findElement(MyPageSearch).click(); // Search

			Thread.sleep(Const * 4);

			driver.findElement(LoginVerificationCode).sendKeys("0000", Keys.TAB); // Verification-Code

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
			FileUtils.copyFile(source, new File("./GPL-Individual-Screenshots/" + "App " + KeepAppNo + ".png"));
			
			System.out.println("Passed " + KeepAppNo + " App Details Viewed");
			
			driver.findElement(BackToApps).click(); // Previous

			System.out.println("Passed. Jordanian - View Application And License 4.1.0.1 " + KeepAppNo);
						
			System.out.println("Pay For: " + NationalIDValue + IDNumberValue );
			
			driver.close();
		
		}
		
		public void ViewApplicationAndRejection_Jordanain_Case4111(String KeepAppNo, String NationalIDValue, String IDNumberValue ) throws InterruptedException, IOException {

			// الاستعلام عن الطلب وعرض اسباب الرفض
			
			this.CallBrowser();

			Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
			appType.selectByVisibleText(Individual);

			Thread.sleep(Const * 3);

			driver.findElement(MyPageNationalNumber).sendKeys(NationalIDValue); // National-ID

			driver.findElement(MyPageCardNo).sendKeys(IDNumberValue); // Card-No

			Thread.sleep(Const * 2);

			driver.findElement(MyPageSearch).click(); // Search

			Thread.sleep(Const * 4);

			driver.findElement(LoginVerificationCode).sendKeys("0000", Keys.TAB); // Verification-Code

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
			FileUtils.copyFile(source, new File("./GPL-Individual-Screenshots/Case4.1.1.1_AppDetails.png"));
			
			System.out.println("Passed " + KeepAppNo + " App Details Viewed");
			
			driver.findElement(BackToApps).click(); // Previous

			// -------------------------------View-License----------------------------------
			
			Thread.sleep(Const * 2);
			
			driver.findElement(RejectionReasons).click(); // rejection

			Thread.sleep(Const * 10);



			TakesScreenshot ts1 = (TakesScreenshot) driver;
			File source1 = ts1.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source1, new File("./GPL-Individual-Screenshots/Case4.1.1.1_RejectionReasons.png"));

			// -------------------------------Clear----------------------------------

			
			//driver.findElement(By.id("GoToHomePage")).click(); // Home-Page

			System.out.println("Passed. Jordanian - View Application And Rejection Reasons 4.1.1.1");

			driver.close();
		
		}
		
		public void ViewApplicationAndModifyApp_Jordanain_Case4121(String KeepAppNo, String NationalIDValue, String IDNumberValue ) throws InterruptedException, IOException {

			// استكمال نواقص
			this.CallBrowser();

			Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
			appType.selectByVisibleText(Individual);

			Thread.sleep(Const * 3);

			driver.findElement(MyPageNationalNumber).sendKeys(NationalIDValue); // National-ID

			driver.findElement(MyPageCardNo).sendKeys(IDNumberValue); // Card-No

			Thread.sleep(Const * 2);

			driver.findElement(MyPageSearch).click(); // Search

			Thread.sleep(Const * 4);

			driver.findElement(LoginVerificationCode).sendKeys("0000", Keys.TAB); // Verification-Code

			Thread.sleep(Const * 2);

			driver.findElement(NextToMyPage).click(); // Next

			// -------------------------------View-App----------------------------------

			driver.findElement(MyAppTab).click(); // My-Applications-Tab

			Thread.sleep(Const * 10);

			driver.findElement(SearchForApp).sendKeys(KeepAppNo); // Search-For-App-Number

			Thread.sleep(Const);

			driver.findElement(SearchForApp).sendKeys(Keys.ENTER); // Search

			Thread.sleep(Const * 2);

			driver.findElement(IncompleteApp).click(); // Complete

			Thread.sleep(Const * 10);

			driver.findElement(IncompleteButton).click();
			
			Thread.sleep(Const * 4);
			
			driver.findElement(ModifyAttachmentIncPha).click();
			
			Thread.sleep(Const * 2);
			
			driver.findElement(UploadFileIncPHA).click();
			
			Thread.sleep(Const * 20);
			Runtime.getRuntime().exec(PNGAtt);
			// Give path where the au3 is saved.

			Thread.sleep(Const * 10);
			
			driver.findElement(NextButtonIncPHA).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;  js.executeScript("window.scrollBy(0,1200)");
			
			driver.findElement(NextButtonIncRevPha).click();
			
			driver.findElement(SubmitInc).click();
			
			
			Thread.sleep(Const * 10);
			
			String ActualMessage = driver.findElement(SuccessInc).getText();
			String ExpectedMessage = SuccessMsg;
			
			System.out.println("Actual Message: " + ActualMessage);
			System.out.println("Expected Message: " + ExpectedMessage);
			
			Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
			
			Thread.sleep(Const * 2);
			driver.findElement(BackToHomeInc).click();

			
			driver.close();
		
		}
		
		public void ViewApplicationAndModifyAppOther_Jordanain_Case4121_1(String KeepAppNo, String NationalIDValue, String IDNumberValue ) throws InterruptedException, IOException {

			// استكمال نواقص - بيانات اخرى
			
			this.CallBrowser();
			Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
			appType.selectByVisibleText(Individual);

			Thread.sleep(Const * 3);

			driver.findElement(MyPageNationalNumber).sendKeys(NationalIDValue); // National-ID

			driver.findElement(MyPageCardNo).sendKeys(IDNumberValue); // Card-No

			Thread.sleep(Const * 2);

			driver.findElement(MyPageSearch).click(); // Search

			Thread.sleep(Const * 4);

			driver.findElement(LoginVerificationCode).sendKeys("0000", Keys.TAB); // Verification-Code

			Thread.sleep(Const * 2);

			driver.findElement(NextToMyPage).click(); // Next

			// -------------------------------View-App----------------------------------

			driver.findElement(MyAppTab).click(); // My-Applications-Tab

			Thread.sleep(Const * 10);

			driver.findElement(SearchForApp).sendKeys(KeepAppNo); // Search-For-App-Number

			Thread.sleep(Const);

			driver.findElement(SearchForApp).sendKeys(Keys.ENTER); // Search

			Thread.sleep(Const * 2);

			driver.findElement(IncompleteApp).click(); // Complete

			Thread.sleep(Const * 10);

			driver.findElement(IncompleteButton).click();
			
			Thread.sleep(Const * 2);
			driver.findElement(ModifyOtherInc).click();
			
			Thread.sleep(Const * 2);
			
			Select CertificateYear = new Select(driver.findElement(SSYIncOther)); // Certificate-Year

			CertificateYear.selectByIndex(10);
			
			Thread.sleep(Const);
			
			driver.findElement(NextButtonIncOther).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;  js.executeScript("window.scrollBy(0,1000)");
			driver.findElement(NextButtonIncRevPha).click();
			
			driver.findElement(SubmitInc).click();
			
			
			Thread.sleep(Const * 10);
			
			String ActualMessage = driver.findElement(SuccessInc).getText();
			String ExpectedMessage = SuccessMsg;
			
			System.out.println("Actual Message: " + ActualMessage);
			System.out.println("Expected Message: " + ExpectedMessage);
			
			Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
			
			Thread.sleep(Const * 2);
			driver.findElement(BackToHomeInc).click();

			
			driver.close();
		
		}
		
		public void ViewApplication_Chain_Case6101(String KeepAppNo, String NationalIDValue, String IDNumberValue ) throws InterruptedException, IOException {

			// الاستعلام عن الطلب وعرض رخصة المزاولة
			
			this.CallBrowser();

			Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
			appType.selectByVisibleText(Compnay);

			Thread.sleep(Const * 3);

			driver.findElement(MyPageNationalNumber).sendKeys(NationalIDValue); // National-ID

			driver.findElement(MyPageCardNo).sendKeys(IDNumberValue); // Card-No

			Thread.sleep(Const * 2);

			driver.findElement(MyPageSearch).click(); // Search

			Thread.sleep(Const * 4);

			driver.findElement(LoginVerificationCode).sendKeys("0000", Keys.TAB); // Verification-Code

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
			FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/" + "App " + KeepAppNo + ".png"));
			
			System.out.println("Passed " + KeepAppNo + " App Details Viewed");
			
			driver.findElement(BackToApps).click(); // Previous

			System.out.println("Passed. Chain - View Application 46.1.0.1 " + KeepAppNo);
			
			System.out.println("Pay For: " + KeepAppNo);

			driver.close();
		
		}

		public void ViewApplicationAndRejection_Chain_Case6111(String KeepAppNo, String NationalIDValue, String IDNumberValue ) throws InterruptedException, IOException {

			// الاستعلام عن الطلب وعرض اسباب الرفض
			
			this.CallBrowser();

			Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
			appType.selectByVisibleText(Compnay);

			Thread.sleep(Const * 3);

			driver.findElement(MyPageNationalNumber).sendKeys(NationalIDValue); // National-ID

			driver.findElement(MyPageCardNo).sendKeys(IDNumberValue); // Card-No

			Thread.sleep(Const * 2);

			driver.findElement(MyPageSearch).click(); // Search

			Thread.sleep(Const * 4);

			driver.findElement(LoginVerificationCode).sendKeys("0000", Keys.TAB); // Verification-Code

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
			FileUtils.copyFile(source, new File("./GPL-Chain-Screenshots/Case6.1.1.1_AppDetails.png"));
			
			System.out.println("Passed " + KeepAppNo + " App Details Viewed");
			
			driver.findElement(BackToApps).click(); // Previous

			// -------------------------------View-License----------------------------------
			
			Thread.sleep(Const * 2);
			
			driver.findElement(RejectionReasons).click(); // License-Tab

			Thread.sleep(Const * 10);



			TakesScreenshot ts1 = (TakesScreenshot) driver;
			File source1 = ts1.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source1, new File("./GPL-Chain-Screenshots/Case6.1.1.1_RejectionReasons.png"));

			// -------------------------------Clear----------------------------------

			
			//driver.findElement(By.id("GoToHomePage")).click(); // Home-Page

			System.out.println("Passed. Chain - View Application And Rejection Reasons 6.1.1.1");

			driver.close();
		
		}
		
		public void ViewApplicationAndModifyApp_Chain_Case6121(String KeepAppNo, String NationalIDValue, String IDNumberValue ) throws InterruptedException, IOException {

			// استكمال نواقص
			this.CallBrowser();

			Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
			appType.selectByVisibleText(Compnay);

			Thread.sleep(Const * 3);

			driver.findElement(MyPageNationalNumber).sendKeys(NationalIDValue); // National-ID

			driver.findElement(MyPageCardNo).sendKeys(IDNumberValue); // Card-No

			Thread.sleep(Const * 2);

			driver.findElement(MyPageSearch).click(); // Search

			Thread.sleep(Const * 4);

			driver.findElement(LoginVerificationCode).sendKeys("0000", Keys.TAB); // Verification-Code

			Thread.sleep(Const * 2);

			driver.findElement(NextToMyPage).click(); // Next

			// -------------------------------View-App----------------------------------

			driver.findElement(MyAppTab).click(); // My-Applications-Tab

			Thread.sleep(Const * 10);

			driver.findElement(SearchForApp).sendKeys(KeepAppNo); // Search-For-App-Number

			Thread.sleep(Const);

			driver.findElement(SearchForApp).sendKeys(Keys.ENTER); // Search

			Thread.sleep(Const * 2);

			driver.findElement(IncompleteApp).click(); // Complete

			Thread.sleep(Const * 10);

			driver.findElement(IncompleteButton).click();
			
			Thread.sleep(Const * 4);
			
			driver.findElement(ModifyAttachmentIncPha).click();
			
			Thread.sleep(Const * 2);
			
			driver.findElement(UploadFileIncPHA).click();
			
			Thread.sleep(Const * 20);
			Runtime.getRuntime().exec(PNGAtt);
			// Give path where the au3 is saved.

			Thread.sleep(Const * 10);
			
			driver.findElement(NextButtonIncPHA).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;  js.executeScript("window.scrollBy(0,1200)");
			
			driver.findElement(NextButtonIncRevPha).click();
			
			Thread.sleep(Const * 5);
			driver.findElement(RateInc).click();
			
			Thread.sleep(Const * 5);
			driver.findElement(SubmitInc).click();
			
			
			Thread.sleep(Const * 10);
			
			String ActualMessage = driver.findElement(SuccessInc).getText();
			String ExpectedMessage = SuccessMsg;
			
			System.out.println("Actual Message: " + ActualMessage);
			System.out.println("Expected Message: " + ExpectedMessage);
			
			Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
			
			Thread.sleep(Const * 2);
			driver.findElement(BackToHomeInc).click();

			
			driver.close();
		
		}
		
		public void ViewApplicationAndModifyAppOther_Cahin_Case6121_1(String KeepAppNo, String NationalIDValue, String IDNumberValue ) throws InterruptedException, IOException {

			// استكمال نواقص - بيانات اخرى
			
			this.CallBrowser();
			Select appType = new Select(driver.findElement(MyPageApplicantType)); // Applicant-Type
			appType.selectByVisibleText(Compnay);

			Thread.sleep(Const * 3);

			driver.findElement(MyPageNationalNumber).sendKeys(NationalIDValue); // National-ID

			driver.findElement(MyPageCardNo).sendKeys(IDNumberValue); // Card-No

			Thread.sleep(Const * 2);

			driver.findElement(MyPageSearch).click(); // Search

			Thread.sleep(Const * 3);

			driver.findElement(LoginVerificationCode).sendKeys("0000", Keys.TAB); // Verification-Code

			Thread.sleep(Const * 2);

			driver.findElement(NextToMyPage).click(); // Next

			// -------------------------------View-App----------------------------------

			driver.findElement(MyAppTab).click(); // My-Applications-Tab

			Thread.sleep(Const * 10);

			driver.findElement(SearchForApp).sendKeys(KeepAppNo); // Search-For-App-Number

			Thread.sleep(Const);

			driver.findElement(SearchForApp).sendKeys(Keys.ENTER); // Search

			Thread.sleep(Const * 2);

			driver.findElement(IncompleteApp).click(); // Complete

			Thread.sleep(Const * 10);

			driver.findElement(IncompleteButton).click();
			
			Thread.sleep(Const * 2);
			driver.findElement(ModifyOtherInc).click();
			
			Thread.sleep(Const * 2);
			
			Select CertificateYear = new Select(driver.findElement(SSYIncOther)); // Certificate-Year

			CertificateYear.selectByIndex(10);
			
			Thread.sleep(Const);
			
			driver.findElement(NextButtonIncOther).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;  js.executeScript("window.scrollBy(0,1000)");
			driver.findElement(NextButtonIncRevPha).click();
			
			driver.findElement(SubmitInc).click();
			
			
			Thread.sleep(Const * 10);
			
			String ActualMessage = driver.findElement(SuccessInc).getText();
			String ExpectedMessage = SuccessMsg;
			
			System.out.println("Actual Message: " + ActualMessage);
			System.out.println("Expected Message: " + ExpectedMessage);
			
			Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
			
			Thread.sleep(Const * 2);
			driver.findElement(BackToHomeInc).click();

			
			driver.close();
		
		}
