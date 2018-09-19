package MoH;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class RNVLInternal extends MyPageRNVL {
	Integer Const = 500;
		
	public void CallandLogin() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ChromeDriver);
		driver = new ChromeDriver();
		
	//	 System.setProperty("webdriver.ie.driver",IEDriver);
	//	 driver = new InternetExplorerDriver();


		driver.manage().window().maximize();
		driver.get(InternalTesting);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.findElement(EMPUsername).sendKeys(CapitalUserName1); // Username

		driver.findElement(EMPPassword).sendKeys(CapitalPassword1); // Password

		Thread.sleep(Const * 5);

		driver.findElement(LoginBtn).click(); // Login

		
	}
	
	public String Processing_ApproveByHead_Case1100(String AppNo, Integer Round) throws InterruptedException, IOException {
		
		this.CallandLogin();
		
		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(FirstStep).click(); // »«‰ Ÿ«— ﬁ—«— «·„œﬁﬁ

		Thread.sleep(Const * 2);
		
		Select appType = new Select(driver.findElement(HeadNavigateOut)); //HeadNavigateOut

		appType.selectByIndex(Round); 

		Thread.sleep(Const * 5);

		this.TrimAppNo(AppNo);	

		System.out.println("Trimmed App No: " + KeepAppNo);

		Thread.sleep(Const * 5);

		driver.findElement(HeadSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 10);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 10);
		
		try{
		String WarningMessage = driver.findElement(Warning).getText();
		System.out.println("WarningM Message: " + WarningMessage);
		}
		
		catch(Exception e){
			System.out.println("No Warning Message");
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.1.0.0.png"));

		driver.findElement(HeadApprove).click(); // Radio-Approve

		Thread.sleep(Const * 10);

		//driver.findElement(HeadNotes).sendKeys("notes", Keys.TAB);// Notes

		Thread.sleep(Const * 10);

		driver.findElement(HeadProcessBtn).click(); // Process
		
		Thread.sleep(Const * 8);
		
		try{
			
			String ActualResult = driver.findElement(SuccessMessageInternal).getText();
			String ExpectedResult = " „  «·⁄„·Ì… »‰Ã«Õ";
			Assert.assertTrue(ActualResult.contains(ExpectedResult));

			
		} catch (Exception e) {// do nothing

			driver.findElement(HeadProcessBtn).click(); // Process
			Thread.sleep(Const * 7);
		}
		
		driver.findElement(BackButtonInternal).click();

		System.out.println("Passed. " + KeepAppNo + " Approved by Head of Department");
		
		driver.close();
		
		return KeepAppNo;

	}
	
	public void Processing_ApproveByDirector_Case1100_2(String KeepAppNo, Integer Round) throws InterruptedException, IOException {
		
		// „Ê«›ﬁ… „œÌ— «·„œÌ—Ì…
		
		this.CallandLogin();

	//	driver.findElement(HomeMenu).click(); // Home-Page

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(SecondStep).click(); // »«‰ Ÿ«—-ﬁ—«—-„œÌ—-«·„œÌ—Ì…
												 

		Thread.sleep(Const * 2);
		
		Select appType = new Select(driver.findElement(HeadNavigateOut)); //DirectorNavigateOut
		appType.selectByIndex(Round); 
		
		Thread.sleep(Const * 2);

		driver.findElement(HeadSearchld).sendKeys(KeepAppNo); // SearchApp

		Thread.sleep(Const * 5);

		driver.findElement(HeadSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 8);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 10);

		try{
		String WarningMessage = driver.findElement(Warning).getText();
		System.out.println("WarningM Message: " + WarningMessage);
		}
		
		catch(Exception e){
			System.out.println("No Warning Message");
		}
		
		driver.findElement(HeadApprove).click(); // Radio-Approve

		Thread.sleep(Const * 10);

//		driver.findElement(DirectorNotes).sendKeys("notes", Keys.TAB);// Notes

		Thread.sleep(Const * 10);

		driver.findElement(HeadProcessBtn2).click(); // Process
		
		Thread.sleep(Const * 10);
		
		try{
			
			String ActualResult = driver.findElement(SuccessMessageInternal).getText();
			String ExpectedResult = " „  «·⁄„·Ì… »‰Ã«Õ";
			Assert.assertTrue(ActualResult.contains(ExpectedResult));
			
		} catch (Exception e) {

			driver.findElement(HeadProcessBtn2).click(); // Process
			Thread.sleep(Const * 7);
			
		}

		System.out.println("Passed. " + KeepAppNo + " Approved by Departemnt Director");

		driver.close();
	}

	public void Processing_RejectByDirector_Case1110(String KeepAppNo, Integer Round) throws InterruptedException, IOException {

		// —›÷ „œÌ— «·„œÌ—Ì…

		this.CallandLogin();
		
		//driver.findElement(HomeMenu).click(); // Home-Page

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(SecondStep).click(); // »«‰ Ÿ«—-ﬁ—«—-„œÌ—-«·„œÌ—Ì…  
												
		Select appType = new Select(driver.findElement(HeadNavigateOut)); //DirectorNavigateOut

		appType.selectByIndex(Round); 
		
		Thread.sleep(Const * 2);

		driver.findElement(HeadSearchld).sendKeys(KeepAppNo); // SearchApp

		Thread.sleep(Const * 5);

		driver.findElement(HeadSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 8);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 10);

		try{
		String WarningMessage = driver.findElement(Warning).getText();
		System.out.println("WarningM Message: " + WarningMessage);
		}
		
		catch(Exception e){
			System.out.println("No Warning Message");
		}
		
		driver.findElement(HeadReject).click(); // Radio-Reject

		Thread.sleep(Const * 10);

		driver.findElement(HeadMoveAll).click(); // Move-All

		Thread.sleep(Const * 10);

		driver.findElement(HeadProcessBtn).click(); // Process
		
		Thread.sleep(Const * 10);
		
		try{
			
			String ActualResult = driver.findElement(SuccessMessageInternal).getText();
			String ExpectedResult = " „  «·⁄„·Ì… »‰Ã«Õ";
			Assert.assertTrue(ActualResult.contains(ExpectedResult));
		}

		catch(Exception e){
			
			driver.findElement(HeadProcessBtn).click(); // Process
			Thread.sleep(Const * 7);
			}
		
		System.out.println("Passed. " + KeepAppNo + " Rejected by Departemnt Director");
		
		driver.close();

	}

	public void Processing_IncompleteByDirector_Case1120(String KeepAppNo, Integer Round) throws InterruptedException, IOException {

		// «” ﬂ„«· ‰Ê«ﬁ’ „œÌ— «·„œÌ—Ì…

		this.CallandLogin();
	//	driver.findElement(HomeMenu).click(); // Home-Page

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(SecondStep).click(); // »«‰ Ÿ«— ﬁ—«— „œÌ—
									
		Select appType = new Select(driver.findElement(HeadNavigateOut)); //DirectorNavigateOut

		appType.selectByIndex(Round); // Jordanian// «·„œÌ—Ì…

		Thread.sleep(Const * 2);

		driver.findElement(HeadSearchld).sendKeys(KeepAppNo); // SearchApp

		Thread.sleep(Const * 5);

		driver.findElement(HeadSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 5);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 20);
		
		try{
		String WarningMessage = driver.findElement(Warning).getText();
		System.out.println("WarningM Message: " + WarningMessage);
		}
		
		catch(Exception e){
			System.out.println("No Warning Message");
		}

		driver.findElement(HeadIncomplete).click(); // Radio-Incomplete

		Thread.sleep(Const * 10);

		Thread.sleep(Const);

		driver.findElement(HeadMoveAll).click(); // Move-All

		Thread.sleep(Const * 8);

		driver.findElement(HeadProcessBtn).click(); // Process
		
		Thread.sleep(Const * 10);
		
		try{
			
			String ActualResult = driver.findElement(SuccessMessageInternal).getText();
			String ExpectedResult = " „  «·⁄„·Ì… »‰Ã«Õ";
			Assert.assertTrue(ActualResult.contains(ExpectedResult));
			
		}
		catch(Exception e){
	
			driver.findElement(HeadProcessBtn).click(); // Process
			Thread.sleep(Const * 7);
		}
		
		System.out.println("Passed. " + KeepAppNo + " Incomplete by Departemnt Director");
		
		driver.close();

	}

	public String Processing_RejectByHead_Case1130(String AppNo) throws InterruptedException, IOException {
			
		this.CallandLogin();
		
		// —›÷ —∆Ì” «·ﬁ”„

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(FirstStep).click(); // »«‰ Ÿ«— ﬁ—«— «·„œﬁﬁ

		Select appType = new Select(driver.findElement(HeadNavigateOut)); //HeadNavigateOut
		appType.selectByIndex(1); 
		
		Thread.sleep(Const * 5);

		this.TrimAppNo(AppNo);

		System.out.println("Trimmed App No: " + KeepAppNo);

		Thread.sleep(Const * 8);

		driver.findElement(HeadSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 10);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 10);
		
		try{
		String WarningMessage = driver.findElement(Warning).getText();
		System.out.println("WarningM Message: " + WarningMessage);
		}
		
		catch(Exception e){
			System.out.println("No Warning Message");
		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.1.0.0.png"));

		driver.findElement(HeadReject).click(); // Radio-Reject

		Thread.sleep(Const * 10);

		driver.findElement(HeadMoveAll).click(); // Move-all

		Thread.sleep(Const * 10);

		driver.findElement(HeadProcessBtn).click(); // Process

		Thread.sleep(Const * 10);
		
		try{
			
			String ActualResult = driver.findElement(SuccessMessageInternal).getText();
			String ExpectedResult = " „  «·⁄„·Ì… »‰Ã«Õ";
			Assert.assertTrue(ActualResult.contains(ExpectedResult));

		}
		catch (Exception e){
			
			driver.findElement(HeadProcessBtn).click(); // Process

			Thread.sleep(Const * 7);

		}
		
		System.out.println("Passed. " + KeepAppNo + " Rejected by Head of Departemnt");
		
		driver.findElement(BackButtonInternal).click();
		driver.close();
		return KeepAppNo;
		
		

	}

	public String Processing_IncompleteByHead_Case1140(String AppNo, Integer Round) throws InterruptedException, IOException {
	
		this.CallandLogin();
		// «” ﬂ„«· ‰Ê«ﬁ’ —∆Ì” «·ﬁ”„

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(FirstStep).click(); // »«‰ Ÿ«— ﬁ—«— «·„œﬁﬁ

		Select appType = new Select(driver.findElement(HeadNavigateOut)); //HeadNavigateOut
		appType.selectByIndex(Round); 
	
		Thread.sleep(Const * 5);

		this.TrimAppNo(AppNo);

		System.out.println("Trimmed App No: " + KeepAppNo);

		Thread.sleep(Const * 8);

		driver.findElement(HeadSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 10);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 10);
		
		try{
		String WarningMessage = driver.findElement(Warning).getText();
		System.out.println("WarningM Message: " + WarningMessage);
		}
		
		catch(Exception e){
			System.out.println("No Warning Message");
		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.1.0.0.png"));

		driver.findElement(HeadIncomplete).click(); // Radio-Incomplete

		Thread.sleep(Const * 10);

		driver.findElement(HeadMoveAll).click(); // Move-all

		Thread.sleep(Const * 10);

		driver.findElement(HeadProcessBtn).click(); // Process

		Thread.sleep(Const * 10);

		try{
			
			String ActualResult = driver.findElement(SuccessMessageInternal).getText();
			String ExpectedResult = "»‰Ã«Õ";
			Assert.assertTrue(ActualResult.contains(ExpectedResult));
					
		}
		catch (Exception e){
			driver.findElement(HeadProcessBtn).click(); // Process

			Thread.sleep(Const * 7);
		}
		
		System.out.println("Passed. " + KeepAppNo + " Incomplete by Head of Departemnt");
			
		
		driver.findElement(BackButtonInternal).click();
		driver.close();
		return KeepAppNo;
		
	}

	public void TrimAppNo(String AppNo)
	{
		
		String[] TrimmedAppNo = AppNo.split(" ");

		for (String str : TrimmedAppNo) {
			driver.findElement(HeadSearchld).sendKeys(str); // SearchApp

			break;
		}
		
		KeepAppNo = driver.findElement(HeadSearchld).getAttribute("value");
	}
	
	
}
