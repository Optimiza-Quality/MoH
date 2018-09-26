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



public class GPLInternal extends MyPageGPL {
	Integer Const = 600;
	Integer Round = 1;
		
	public void CallandLogin(String IUserName,String IPassword) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ChromeDriver);
		driver = new ChromeDriver();
		
	//	 System.setProperty("webdriver.ie.driver",IEDriver);
	//	 driver = new InternetExplorerDriver();


		driver.manage().window().maximize();
		driver.get(InternalTesting);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.findElement(EMPUsername).sendKeys(IUserName); // Username

		driver.findElement(EMPPassword).sendKeys(IPassword); // Password

		Thread.sleep(Const * 5);

		driver.findElement(LoginBtn).click(); // Login

		
	}
	
	public String Processing_ApproveByAudit_Case4100(String AppNo, String IUserName,String IPassword, Integer Round) throws InterruptedException, IOException {
		
		this.CallandLogin(IUserName,IPassword);
		
		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(GPLApps).click();

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

		System.out.println("Passed. " + KeepAppNo + " Approved by Auditor");
		
		driver.close();
		return KeepAppNo;

	}
	
	public void Processing_ApproveByJPA_Case4100_2(String KeepAppNo, String IUserName,String IPassword,Integer Round) throws InterruptedException, IOException {

		this.CallandLogin(IUserName, IPassword);
		
		System.out.println("Approve App: " + KeepAppNo);
		
		// „Ê«›ﬁ…  «·‰ﬁ«»…
		
		Thread.sleep(Const);

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(GPLApps).click();

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
		
		driver.findElement(HeadApprove).click(); // Radio-Approve

		Thread.sleep(Const * 10);

		Thread.sleep(Const * 10);

		driver.findElement(HeadProcessBtn).click(); // Process
		
		Thread.sleep(Const * 10);
		
		try{
			
			String ActualResult = driver.findElement(SuccessMessageInternal).getText();
			String ExpectedResult = " „  «·⁄„·Ì… »‰Ã«Õ";
			Assert.assertTrue(ActualResult.contains(ExpectedResult));
			
		} catch (Exception e) {

			driver.findElement(HeadProcessBtn).click(); // Process
			Thread.sleep(Const * 7);
			
		}

		System.out.println("Passed. " + KeepAppNo + " Approved by JPA");
		
		driver.close();

	}
	
	public void Processing_AppointByIC_Case4100_3(String AppNo, String IUserName,String IPassword) throws InterruptedException, IOException {
	
		this.CallandLogin(IUserName, IPassword);
		
		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(GPLApps).click();

		driver.findElement(ThirdStep).click(); // »«‰ Ÿ«— «·„Ê⁄œ

		Thread.sleep(Const * 2);
		
		Select appType = new Select(driver.findElement(HeadNavigateOut)); //HeadNavigateOut

		appType.selectByIndex(1); 

		Thread.sleep(Const * 5);

		this.TrimAppNo(AppNo);	

		System.out.println("Trimmed App No: " + KeepAppNo);

		Thread.sleep(Const * 5);

		driver.findElement(HeadSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 10);

		driver.findElement(AppointmentLink).click();

		Thread.sleep(Const * 10);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.1.0.0.png"));

		driver.findElement(Date).sendKeys("10-9-2018");

		Thread.sleep(Const * 10);

		driver.findElement(SaveBtn).click(); // Process
		
		Thread.sleep(Const * 8);
		
		try{
			
			String ActualResult = driver.findElement(SuccessMessageInternalAppoint).getText();
			String ExpectedResult = " „  «·⁄„·Ì… »‰Ã«Õ";
			Assert.assertTrue(ActualResult.contains(ExpectedResult));

			
		} catch (Exception e) {// do nothing

			driver.findElement(SaveBtn).click(); // Process
			Thread.sleep(Const * 7);
		}
		
		driver.findElement(BackButtonInternalAppoint).click();

		System.out.println("Passed. " + KeepAppNo + " Date Appointed");
		
		driver.close();

	}
	
	public void Processing_ApproveByIC_Case4100_3(String AppNo, String IUserName,String IPassword, Integer Round) throws InterruptedException, IOException {
		
		this.CallandLogin(IUserName, IPassword);
		
		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(GPLApps).click();

		driver.findElement(FourthStep).click(); // »«‰ Ÿ«— ﬁ—«— «··Ã‰…

		Thread.sleep(Const * 2);
		
		Select appType = new Select(driver.findElement(HeadNavigateOut)); 

		appType.selectByIndex(Round); 

		Thread.sleep(Const * 5);

		System.out.println("Trimmed App No: " + KeepAppNo);

		driver.findElement(HeadSearchld).sendKeys(KeepAppNo);
		
		Thread.sleep(Const * 5);

		driver.findElement(HeadSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 10);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 10);
		
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

		System.out.println("Passed. " + KeepAppNo + " Approved by Committe Member: " + IUserName);
		
		driver.close();

	}
	
	public void Processing_ApproveByDirector_Case4100_4(String KeepAppNo, String IUserName,String IPassword) throws InterruptedException, IOException {
		this.CallandLogin(IUserName, IPassword);
		// „Ê«›ﬁ…  «·„œÌ—
		
		Thread.sleep(Const * 4);

		driver.findElement(HomeMenu).click(); // Home-Page

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(GPLApps).click();

		driver.findElement(FifthStep).click(); // »«‰ Ÿ«—-ﬁ—«—-„œÌ—-«·„œÌ—Ì…
												 

		Thread.sleep(Const * 2);
		
		Select appType = new Select(driver.findElement(DirectorNavigateOut)); //DirectorNavigateOut
		appType.selectByIndex(1); 
		
		Thread.sleep(Const * 2);

		driver.findElement(DirectorSearchld).sendKeys(KeepAppNo); // SearchApp

		Thread.sleep(Const * 5);

		driver.findElement(DirectorSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 8);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 10);

		driver.findElement(DirectorProcessBtn).click(); // Process
		
		Thread.sleep(Const * 10);
		
		try{
			
			String ActualResult = driver.findElement(SuccessMessageInternalDirector).getText();
			String ExpectedResult = " „  «·⁄„·Ì… »‰Ã«Õ";
			Assert.assertTrue(ActualResult.contains(ExpectedResult));
			
		} catch (Exception e) {

			driver.findElement(DirectorProcessBtn).click(); // Process
			Thread.sleep(Const * 7);
			
		}

		System.out.println("Passed. " + KeepAppNo + " Approved by Director");
		
		driver.close();

	}
	
	public void Processing_RejectByJPA_Case4110(String KeepAppNo, String IUserName,String IPassword) throws InterruptedException, IOException {

		this.CallandLogin(IUserName, IPassword);
		
		System.out.println("Reject App: " + KeepAppNo);
		
		// —›÷  «·‰ﬁ«»…
		
		Thread.sleep(Const);

		//driver.findElement(HomeMenu).click(); // Home-Page

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(GPLApps).click();

		driver.findElement(SecondStep).click(); // »«‰ Ÿ«—-ﬁ—«—-«·‰ﬁ«»…
												 

		Thread.sleep(Const * 2);
		
		Select appType = new Select(driver.findElement(HeadNavigateOut)); //DirectorNavigateOut
		appType.selectByIndex(1); 
		
		Thread.sleep(Const * 2);

		driver.findElement(HeadSearchld).sendKeys(KeepAppNo); // SearchApp

		Thread.sleep(Const * 5);

		driver.findElement(HeadSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 8);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 10);
		
		driver.findElement(HeadReject).click(); // Radio-Reject

		Thread.sleep(Const * 10);
		
		driver.findElement(HeadMoveAll2).click();
		
		Thread.sleep(Const * 10);

		driver.findElement(HeadProcessBtn).click(); // Process
		
		Thread.sleep(Const * 10);
		
		try{
			
			String ActualResult = driver.findElement(SuccessMessageInternal).getText();
			String ExpectedResult = " „  «·⁄„·Ì… »‰Ã«Õ";
			Assert.assertTrue(ActualResult.contains(ExpectedResult));
			
		} catch (Exception e) {

			driver.findElement(HeadProcessBtn).click(); // Process
			Thread.sleep(Const * 7);
			
		}

		System.out.println("Passed. " + KeepAppNo + " Rejected by JPA");
		
		driver.close();
	}

	public void Processing_IncompleteByJPA_Case4120_2(String KeepAppNo, String IUserName,String IPassword, Integer Round) throws InterruptedException, IOException {

		this.CallandLogin(IUserName, IPassword);
		
		// «” ﬂ„«· ‰Ê«ﬁ’ ‰ﬁ«»…
		
		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(GPLApps).click();

		driver.findElement(SecondStep).click(); // »«‰ Ÿ«— ‰ﬁ«»… 
									
		Select status = new Select(driver.findElement(HeadNavigateOut)); 

		status.selectByIndex(Round); 

		Thread.sleep(Const * 2);

		driver.findElement(HeadSearchld).sendKeys(KeepAppNo); // SearchApp

		Thread.sleep(Const * 5);

		driver.findElement(HeadSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 5);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 20);

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
		
		System.out.println("Passed. " + KeepAppNo + " Incomplete by JPA");
		
		driver.close();

	}
	
	public String Processing_RejectByAudit_Case4130(String AppNo, String IUserName,String IPassword, Integer Round) throws InterruptedException, IOException {
			
		this.CallandLogin(IUserName,IPassword);
		
		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(GPLApps).click();

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
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/Case1.1.0.0.png"));

		driver.findElement(HeadReject).click(); // Radio-Reject

		Thread.sleep(Const * 10);
		
		driver.findElement(HeadMoveAll2).click();

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

		System.out.println("Passed. " + KeepAppNo + " Rejected by Auditor");
		
		driver.close();
		return KeepAppNo;

	}

	public String Processing_IncompleteByAudit_Case4140(String AppNo, String IUserName,String IPassword, Integer Round) throws InterruptedException, IOException {
	
		this.CallandLogin(IUserName,IPassword);
		// «” ﬂ„«· ‰Ê«ﬁ’ «·„œﬁﬁ

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(GPLApps).click();

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
		
		System.out.println("Passed. " + KeepAppNo + " Incomplete by Auditor");
			
		
		driver.findElement(BackButtonInternal).click();
		driver.close();
		return KeepAppNo;
		
	}
	
	public void Processing_RejectByIC_Case4100_3(String AppNo, String IUserName,String IPassword, Integer Round) throws InterruptedException, IOException {
	
	this.CallandLogin(IUserName, IPassword);
	
	driver.findElement(Applications).click();

	driver.findElement(TakeAction).click();

	driver.findElement(GPLApps).click();

	driver.findElement(FourthStep).click(); // »«‰ Ÿ«— ﬁ—«— «··Ã‰…

	Thread.sleep(Const * 2);
	
	Select appType = new Select(driver.findElement(HeadNavigateOut)); 

	appType.selectByIndex(Round); 

	Thread.sleep(Const * 5);

	System.out.println("Trimmed App No: " + KeepAppNo);

	driver.findElement(HeadSearchld).sendKeys(KeepAppNo);
	
	Thread.sleep(Const * 5);

	driver.findElement(HeadSearchBtn).click(); // Search-Button

	Thread.sleep(Const * 10);

	driver.findElement(DetailsLink).click();

	Thread.sleep(Const * 10);
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./ScreenShots/Case1.1.0.0.png"));

	driver.findElement(HeadReject).click(); // Radio-Approve

	Thread.sleep(Const * 10);

	driver.findElement(HeadMoveAll2).click();
	
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

	System.out.println("Passed. " + KeepAppNo + " Rejected by Committe Member: " + IUserName);
	

}
	
	public void Processing_IncompleteByIC_Case4100_3(String AppNo, String IUserName,String IPassword) throws InterruptedException, IOException {
	
	this.CallandLogin(IUserName, IPassword);
	
	driver.findElement(Applications).click();

	driver.findElement(TakeAction).click();

	driver.findElement(GPLApps).click();

	driver.findElement(FourthStep).click(); // »«‰ Ÿ«— ﬁ—«— «··Ã‰…

	Thread.sleep(Const * 2);
	
	Select appType = new Select(driver.findElement(HeadNavigateOut)); 

	appType.selectByIndex(1); 

	Thread.sleep(Const * 5);

	System.out.println("Trimmed App No: " + KeepAppNo);

	driver.findElement(HeadSearchld).sendKeys(KeepAppNo);
	
	Thread.sleep(Const * 5);

	driver.findElement(HeadSearchBtn).click(); // Search-Button

	Thread.sleep(Const * 10);

	driver.findElement(DetailsLink).click();

	Thread.sleep(Const * 10);
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./ScreenShots/Case1.1.0.0.png"));

	driver.findElement(HeadIncomplete).click(); // Radio-Incompelet

	Thread.sleep(Const * 10);

	driver.findElement(HeadMoveAll).click();
	
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

	System.out.println("Passed. " + KeepAppNo + " Incomplete by Committe Member: " + IUserName);
	
	driver.close();
	

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
