package MoH;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class RNVLInternal extends MyPage {
	Integer Const = 300;
		
	public String KeepAppNo;
	
	public String Processing_ApproveByHead_Case1100(String AppNo) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://soa-vip:7003/internal/faces/index.jsf");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		// ������ ���� �����

		driver.findElement(EMPUsername).sendKeys("ESRAA"); // Username

		driver.findElement(EMPPassword).sendKeys("12345"); // Password

		Thread.sleep(Const * 5);

		driver.findElement(LoginBtn).click(); // Login

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(FirstStep).click(); // ������� ���� ������

		Thread.sleep(Const * 2);
		
		Select appType = new Select(driver.findElement(HeadNavigateOut)); //HeadNavigateOut

		appType.selectByIndex(1); 

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

		driver.findElement(HeadNotes).sendKeys("notes", Keys.TAB);// Notes

		Thread.sleep(Const * 10);

		driver.findElement(HeadProcessBtn).click(); // Process
		
		Thread.sleep(Const * 10);
		
		try{
			
			driver.findElement(HeadProcessBtn).click(); // Process
			
		} catch (Exception e) {// do nothing

		
		}

		Thread.sleep(Const * 7);

		System.out.println("Passed. " + KeepAppNo + " Approved by Head of Department");
		
		String ActualResult = driver.findElement(SuccessMessageInternal).getText();
		String ExpectedResult = "��� ������� �����";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		
		driver.findElement(BackButtonInternal).click();
		
		return KeepAppNo;

	}

	public void Processing_ApproveByDirector_Case1100_2(String KeepAppNo) throws InterruptedException, IOException {

		System.out.println("director method " + KeepAppNo);
		
		// ������ ���� ��������

		driver.findElement(HomeMenu).click(); // Home-Page

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(SecondStep).click(); // �������-����-����-��������
												 

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

		driver.findElement(DirectorApprove).click(); // Radio-Approve

		Thread.sleep(Const * 10);

		driver.findElement(DirectorNotes).sendKeys("notes", Keys.TAB);// Notes

		Thread.sleep(Const * 10);

		driver.findElement(DirectorProcessBtn).click(); // Process
		
		Thread.sleep(Const * 10);
		
		try{
			
			driver.findElement(DirectorProcessBtn).click(); // Process
			
		} catch (Exception e) {// do nothing

		
		}

		System.out.println("Passed. " + KeepAppNo + " Approved by Departemnt Director");

		driver.close();
	}

	public void Processing_RejectByDirector_Case1110(String KeepAppNo) throws InterruptedException, IOException {

		// ��� ���� ��������

		driver.findElement(HomeMenu).click(); // Home-Page

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(SecondStep).click(); // �������-����-����-��������  
												
		Select appType = new Select(driver.findElement(DirectorNavigateOut)); //DirectorNavigateOut

		appType.selectByIndex(1); 
		
		Thread.sleep(Const * 2);

		driver.findElement(DirectorSearchld).sendKeys(KeepAppNo); // SearchApp

		Thread.sleep(Const * 5);

		driver.findElement(DirectorSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 8);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 10);

		driver.findElement(DirectorReject).click(); // Radio-Reject

		Thread.sleep(Const * 10);

		driver.findElement(DirectorMoveAll).click(); // Move-All

		Thread.sleep(Const * 10);

		driver.findElement(DirectorProcessBtn).click(); // Process
		
		try{
			driver.findElement(DirectorProcessBtn).click(); // Process
		}

		catch(Exception e){//Do nothing
			}
		
		System.out.println("Passed. " + KeepAppNo + " Rejected by Departemnt Director");
		
		driver.close();

	}

	public void Processing_IncompleteByDirector_Case1120(String KeepAppNo) throws InterruptedException, IOException {

		// ������� ����� ���� ��������

		driver.findElement(HomeMenu).click(); // Home-Page

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(SecondStep).click(); // ������� ���� ����
									
		Select appType = new Select(driver.findElement(DirectorNavigateOut)); //DirectorNavigateOut

		appType.selectByIndex(1); // Jordanian// ��������

		Thread.sleep(Const * 2);

		driver.findElement(DirectorSearchld).sendKeys(KeepAppNo); // SearchApp

		Thread.sleep(Const * 5);

		driver.findElement(DirectorSearchBtn).click(); // Search-Button

		Thread.sleep(Const * 5);

		driver.findElement(DetailsLink).click();

		Thread.sleep(Const * 20);

		driver.findElement(DirectorIncomplete).click(); // Radio-Incomplete

		Thread.sleep(Const * 10);

		// driver.findElement(By.xpath("//*[@id=\"pt1:r1:6:smsShuttle::leadUl\"]/li[1]/label")).click();//Rejection-Reasons

		Thread.sleep(Const);

		// driver.findElement(By.id("pt1:r1:6:smsShuttle::move")).click();
		// //Move

		driver.findElement(DirectorMoveAll).click(); // Move-All

		Thread.sleep(Const * 8);

		driver.findElement(DirectorProcessBtn).click(); // Process
		
		Thread.sleep(Const * 10);
		
		try{
			driver.findElement(DirectorProcessBtn).click(); // Process
			
			Thread.sleep(Const * 7);
		}
		catch(Exception e){//nothing
	
		}
		
		System.out.println("Passed. " + KeepAppNo + " Incomplete by Departemnt Director");
		
		driver.close();

	}

	public String Processing_RejectByHead_Case1130(String AppNo) throws InterruptedException, IOException {
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://soa-vip:7003/internal/faces/index.jsf");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		// ��� ���� �����

		driver.findElement(EMPUsername).sendKeys("ESRAA"); // Username

		driver.findElement(EMPPassword).sendKeys("12345"); // Password

		Thread.sleep(Const * 5);

		driver.findElement(LoginBtn).click(); // Login

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(FirstStep).click(); // ������� ���� ������

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
			
			driver.findElement(HeadProcessBtn).click(); // Process

			Thread.sleep(Const * 7);
		}
		catch (Exception e){//nothing
		}
		
		System.out.println("Passed. " + KeepAppNo + " Rejected by Head of Departemnt");
		
		String ActualResult = driver.findElement(SuccessMessageInternal).getText();
		String ExpectedResult = "��� ������� �����";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		
		driver.findElement(BackButtonInternal).click();
		driver.close();
		return KeepAppNo;
		
		

	}

	public String Processing_IncompleteByHead_Case1140(String AppNo) throws InterruptedException, IOException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://soa-vip:7003/internal/faces/index.jsf");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// ������� ����� ���� �����

		driver.findElement(EMPUsername).sendKeys("ESRAA"); // Username

		driver.findElement(EMPPassword).sendKeys("12345"); // Password

		Thread.sleep(Const * 5);

		driver.findElement(LoginBtn).click(); // Login

		driver.findElement(Applications).click();

		driver.findElement(TakeAction).click();

		driver.findElement(RNVLApps).click();

		driver.findElement(FirstStep).click(); // ������� ���� ������

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
			driver.findElement(HeadProcessBtn).click(); // Process

			Thread.sleep(Const * 7);		
		}
		catch (Exception e){//noth
		}
		
		System.out.println("Passed. " + KeepAppNo + " Incomplete by Head of Departemnt");
	
		String ActualResult = driver.findElement(SuccessMessageInternal).getText();
		String ExpectedResult = "�����";
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		
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
