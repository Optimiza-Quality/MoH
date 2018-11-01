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
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class InternalReviewRequests extends AdminField {
	Integer Const = 500;
	WebDriver driver;
	
	@BeforeMethod()
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

		driver.findElement(EMPPassword).sendKeys(CapitalPassword2); // Password

		Thread.sleep(Const * 5);

		driver.findElement(LoginBtn).click(); // Login

	}
	

	/// View and search all Requests - View GPL 

	@Test(priority= 0 )
	public void ViewandSearchallRequests() throws InterruptedException, IOException{
	
		driver.findElement(Applications).click(); 
		driver.findElement(ViewRequestsandPermits).click(); 
		driver.findElement(requests).click();
		driver.findElement(allRequests).click();
		Thread.sleep(Const * 2); 

		driver.findElement(outofMenu).click(); 
		Thread.sleep(Const * 3); 
		
		Select Service = new Select(driver.findElement(ViewRequestNavigateOut )); //DirectorNavigateOut
		Service.selectByVisibleText(RNVL);
		Thread.sleep(Const * 2);
		Select Status = new Select(driver.findElement(RequestStatus));
		Status.selectByVisibleText(NewWaitingForHeadRNVL); 
		Thread.sleep(Const * 2);

		Status.selectByVisibleText(NewWaitingForHeadRNVL);
		Thread.sleep(Const * 2);

		driver.findElement(RequestNo).sendKeys("208"); 
		Thread.sleep(Const * 2);

		driver.findElement(SearchButton).click();
		Thread.sleep(Const * 4);
		
		driver.findElement(SearchButton).click();
		Thread.sleep(Const * 4);

		
		driver.findElement(DetailsLink).click(); // or  DetailsLink
		Thread.sleep(Const * 50);
		
		TakesScreenshot ts1=(TakesScreenshot)driver;
		File source1=ts1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source1, new File("Screenshots/ViewandSearchallRequestsRNVL.png"));
		Thread.sleep(Const * 2);

	} 
	

	
	///// view and search RNVL Requests
	@Test(priority= 1)
	public void ViewandSearchRNVLRequests() throws InterruptedException, IOException{
	
		driver.findElement(Applications).click();
		driver.findElement(ViewRequestsandPermits).click();
		driver.findElement(requests).click();
		driver.findElement(RNVLPermits).click();
		
		driver.findElement(outofMenu).click(); 
		Thread.sleep(Const * 3); 
		Select ReqStatus = new Select(driver.findElement(RequestStatus));
		ReqStatus.selectByVisibleText(RejecetedRequestDirectorRNVL); 
		driver.findElement(RequestNum).sendKeys("2"); 
		driver.findElement(SearchButton).click();
		Thread.sleep(Const * 4);
		driver.findElement(DetailsLink).click(); // or DTL
		
		Thread.sleep(Const * 70);
		
		TakesScreenshot ts3=(TakesScreenshot)driver;
		File source3=ts3.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source3, new File("Screenshots/ViewandSearchRNVLRequests.png"));
		Thread.sleep(Const * 2);

	}
	

	///////////////////////// View and search GPL Requests
    @Test(priority= 2)
	public void ViewandSearchGPLRequests() throws InterruptedException, IOException{
	
		driver.findElement(Applications).click();
		driver.findElement(ViewRequestsandPermits).click();
		driver.findElement(requests).click();
		driver.findElement(GPLRequests).click();
		Thread.sleep(Const * 2);
		Select ReqStatus1 = new Select(driver.findElement(RequestStatus));
		ReqStatus1.selectByVisibleText(UpdatedRequestAuditorGPL); 
		Thread.sleep(Const * 2);
	//	ReqStatus1.selectByVisibleText(NewWaitingforAuditorDecisionGPL); 
		Thread.sleep(Const * 2);
		driver.findElement(SearchButton).click();
		Thread.sleep(Const * 2);
	

		driver.findElement(RequestNumber).sendKeys("209");  // Submit request Number
		driver.findElement(SearchButton).click();
		driver.findElement(SearchButton).click();
		Thread.sleep(Const * 2);
		Thread.sleep(Const * 2);
		
		driver.findElement(DetailsLink).click();
		Thread.sleep(Const * 70);
		
		TakesScreenshot ts4=(TakesScreenshot)driver;
		File source4=ts4.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source4, new File("Screenshots/ViewandSearchGPLRequests.png"));
		Thread.sleep(Const * 2);

	} 
	
	
	// View and search all Permits
	@Test(priority= 3)
	public void ViewandSearchallPermits() throws InterruptedException, IOException{
	
		driver.findElement(Applications).click();
		driver.findElement(ViewRequestsandPermits).click();
		driver.findElement(permitsList).click();
		driver.findElement(allPermitsList).click();
		
		driver.findElement(outofMenu).click(); 
		Thread.sleep(Const * 3);  
		Thread.sleep(Const * 2);
		
		driver.findElement(Search).click();
		Thread.sleep(Const * 5);
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(permitNo)).click();
		action1.click();
		action1.sendKeys("3317");// Permit Number
		action1.build().perform();
		Thread.sleep(Const * 3);

	     driver.findElement(Search).click();
		Thread.sleep(Const * 5);

	    driver.findElement(DetailsLink).click();
		Thread.sleep(Const * 2);

	
	    Actions action= new Actions(driver);
	    action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB);
	    //.build();
	    //.perform();
	    Thread.sleep(Const * 10);
	    
	    this.SwitchTab();
	    Thread.sleep(Const * 10);

	    TakesScreenshot ts5=(TakesScreenshot)driver;
		File source5=ts5.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source5, new File("Screenshots/ViewandSearchallPermits.png"));
		Thread.sleep(Const * 2);

	}


	////////////////////////////////////////////////////////////////////////////Registration Management/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////// User Management////////////////////////////////////////////////////////////////////////////////////////////
	
	//New user- MOH
	
	@Test(priority= 4)    /////// Happy Scenario/////////
	public void DefineNewMOHUser() throws InterruptedException{
	
		driver.findElement(RegistrationList).click();
		driver.findElement(usersList).click();
		driver.findElement(defineUser).click();
		
		Thread.sleep(Const * 8);
		driver.findElement(outofMenu).click(); 
		Thread.sleep(Const * 12);

		
		driver.findElement(userType).click();
		Select userTypeDDL = new Select(driver.findElement(userType));
		
		userTypeDDL.selectByVisibleText(MOHuser); 
		Thread.sleep(Const * 3);
		
		
		driver.findElement(username).sendKeys(newuserNameContent);		
		
		Thread.sleep(Const * 3);
		

		driver.findElement(Directorate).click();
		Select DirectorateDDL = new Select(driver.findElement(Directorate));
		DirectorateDDL.selectByVisibleText(Balqaa); 
		Thread.sleep(Const * 3);
		
		driver.findElement(password).sendKeys(PasswordContent); 
		driver.findElement(arFirstName).sendKeys(arFirstNameContent);
		driver.findElement(arSecondName).sendKeys(arSecondNameContent);
		driver.findElement(arThirdName).sendKeys(arThirdNameContent);
		driver.findElement(arFourthName).sendKeys(arFourthNameContent);
		driver.findElement(enFirstName).sendKeys(enFirstNameContent);
		driver.findElement(enSecondName).sendKeys(enSecondNameContent);
		driver.findElement(enThirdName).sendKeys(enThirdNameContent);
		driver.findElement(enFourthName).sendKeys(enFourthNameContent);
		Thread.sleep(Const * 3);
		driver.findElement(phoneNum).sendKeys(PhoneNumContent);
		driver.findElement(CountryCode).sendKeys(CodeNo2);
		driver.findElement(email).sendKeys(emailContent);
			
		driver.findElement(AccessPolicyField).click();
		Select AccessPolicyDDL = new Select(driver.findElement(AccessPolicyField));
		AccessPolicyDDL.selectByVisibleText(DefaultPolicy); 
		Thread.sleep(Const * 3);
			
		driver.findElement(TimePolicyField).click();
		Select TimePolicyDDL = new Select(driver.findElement(TimePolicyField));
		TimePolicyDDL.selectByVisibleText(DefaultEscalationSteps); 
		TimePolicyDDL.selectByVisibleText(MOHDefualtTiming); 
		Thread.sleep(Const * 3);
			
		driver.findElement(userStatus).click();
		Select userstatusDDL = new Select(driver.findElement(userStatus));
		userstatusDDL.selectByVisibleText(activeStatus); 
		Thread.sleep(Const * 3);
			
		driver.findElement(defaultLanguage).click();
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
		LanguageDDL.selectByVisibleText(Arabic); 
		Thread.sleep(Const * 3);
			
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,750)", "");
		driver.findElement(RequiredMessagesCheckbox).click();
		driver.findElement(RequiredMailCheckbox).click();
		Thread.sleep(Const * 3);

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(Const * 3);

		driver.findElement(SelectRole).click();
		Thread.sleep(Const * 3);

		driver.findElement(moveButton).click();
		Thread.sleep(Const * 3);
		driver.findElement(CreateButton).click();
		Thread.sleep(Const * 7);
		String ActualResult = driver.findElement(successMessage).getText();
	    System.out.println(ActualResult);
		String ExpectedResult = updateSucceed;
		
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + " passed DefineNewMOHUser Test case");
		
	}
	
	
	@Test(priority= 5)    /////// Existing User Scenario/////////
	public void DefineAlreadyExistingMOHUser() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); //-- registration Menu
		driver.findElement(usersList).click();    // Users sub-Menu
		driver.findElement(defineUser).click(); // Define new user Option
		Thread.sleep(Const * 3);

		driver.findElement(userType).click(); // Applicant type -to exit the Menu 
		Select userTypeDDL = new Select(driver.findElement(userType)); // Select From DDL Applicant Type 
		userTypeDDL.selectByVisibleText(MOHuser); // MOH User
		Thread.sleep(Const * 3);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(username)).click();
		action1.click();
		action1.sendKeys(userNameContent); // Fill in username Field
		action1.build().perform();
		Thread.sleep(Const * 3);

		driver.findElement(Directorate).click();
		Select DirectorateDDL = new Select(driver.findElement(Directorate)); // Select Directorate 
		DirectorateDDL.selectByVisibleText(Balqaa); // Directorate Options  
		Thread.sleep(Const * 3);
		
		driver.findElement(password).sendKeys(PasswordContent); // Password
		driver.findElement(arFirstName).sendKeys(arFirstNameContent); // First Arabic Name
		driver.findElement(arSecondName).sendKeys(arSecondNameContent); // Second Arabic Name
		driver.findElement(arThirdName).sendKeys(arThirdNameContent); //Third Arabic Name
		driver.findElement(arFourthName).sendKeys(arFourthNameContent); // Fourth Arabic Name
		driver.findElement(enFirstName).sendKeys(enFirstNameContent); // First English Name
		driver.findElement(enSecondName).sendKeys(enSecondNameContent); // Second English Name
		driver.findElement(enThirdName).sendKeys(enThirdNameContent); // Third English Name
		driver.findElement(enFourthName).sendKeys(enFourthNameContent); // Fourth English Name
		Thread.sleep(Const * 3);
		
		driver.findElement(phoneNum).sendKeys(PhoneNumContent); // Phone Number Field
		driver.findElement(CountryCode).sendKeys(CodeNo2); // Country code Field
		driver.findElement(email).sendKeys(emailContent); // Email Field
			
		driver.findElement(AccessPolicyField).click(); // Access policy DDL 
		Select AccessPolicyDDL = new Select(driver.findElement(AccessPolicyField));
		AccessPolicyDDL.selectByVisibleText(DefaultPolicy);  // Access policy options 
		Thread.sleep(Const * 3);
			
		driver.findElement(TimePolicyField).click(); //Time Policy DDL 
		Select TimePolicyDDL = new Select(driver.findElement(TimePolicyField));
		TimePolicyDDL.selectByVisibleText(DefaultEscalationSteps); 
		TimePolicyDDL.selectByVisibleText(MOHDefualtTiming); // Time policy options
		Thread.sleep(Const * 3);
			
		driver.findElement(userStatus).click();   // User Status DDL
		Select userstatusDDL = new Select(driver.findElement(userStatus));
		userstatusDDL.selectByVisibleText(activeStatus); // User Status Options
		Thread.sleep(Const * 3);
		
		driver.findElement(defaultLanguage).click();  // Default Language DDL 
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
		LanguageDDL.selectByVisibleText(Arabic);  // Default language option 
		Thread.sleep(Const * 3);	
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver; // Scrolling Down to show hidde elements 
		js1.executeScript("window.scrollBy(0,750)", "");
		driver.findElement(RequiredMessagesCheckbox).click();// Check-box of required Messages
		driver.findElement(RequiredMailCheckbox).click(); // Check-box of Required mail
		JavascriptExecutor js2 = (JavascriptExecutor)driver; // Scrolling down to shown hidden elements 
		js2.executeScript("window.scrollBy(0,900)", "");
		
		driver.findElement(SelectRole).click(); // Selecting Role
		driver.findElement(moveButton).click();
		Thread.sleep(Const * 3);
		driver.findElement(CreateButton).click(); // Press Create Button
		// Validating the expected result
		Thread.sleep(Const * 7);
		String ActualResult = driver.findElement(successMessage).getText(); // Message that appears one the system 
	    System.out.println(ActualResult);
		String ExpectedResult = UserAlreadyExists; // Message that is expected according to the test case 
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + " passed DefineAlreadyExistingMOHUser Test case");
	}
	
	
	@Test(priority= 6)    /////// Missing Field User Definition  Scenario/////////
	public void MissingFiledofMOHUserDefinition() throws InterruptedException, IOException{
	
		driver.findElement(RegistrationList).click(); //-- registration Menu
		driver.findElement(usersList).click();    // Users sub-Menu
		driver.findElement(defineUser).click(); // Define new user Option
		
		driver.findElement(userType).click(); // Applicant type -to exit the Menu 
		Select userTypeDDL = new Select(driver.findElement(userType)); // Select From DDL Applicant Type 
		userTypeDDL.selectByVisibleText(MOHuser); // MOH User
		Thread.sleep(Const * 3);
		
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(username)).click();
		action3.click();
		action3.sendKeys(userNameContent); // Fill in username Field
		action3.build().perform();
		
		driver.findElement(Directorate).click();
		Select DirectorateDDL = new Select(driver.findElement(Directorate)); // Select Directorate 
		DirectorateDDL.selectByVisibleText(Balqaa); // Directorate Options  
		Thread.sleep(Const * 3);
		
		driver.findElement(password).sendKeys(PasswordContent); // Password
		driver.findElement(arFirstName).sendKeys(arFirstNameContent); // First Arabic Name
		driver.findElement(arSecondName).sendKeys(arSecondNameContent); // Second Arabic Name
	//	driver.findElement(arThirdName).sendKeys(arThirdNameContent); //Third Arabic Name
		driver.findElement(arFourthName).sendKeys(arFourthNameContent); // Fourth Arabic Name
		driver.findElement(enFirstName).sendKeys(enFirstNameContent); // First English Name
		driver.findElement(enSecondName).sendKeys(enSecondNameContent); // Second English Name
		driver.findElement(enThirdName).sendKeys(enThirdNameContent); // Third English Name
		driver.findElement(enFourthName).sendKeys(enFourthNameContent); // Fourth English Name
		Thread.sleep(Const * 3);
		
		driver.findElement(phoneNum).sendKeys(PhoneNumContent); // Phone Number Field
		driver.findElement(CountryCode).sendKeys(CodeNo2); // Country code Field
		driver.findElement(email).sendKeys(emailContent); // Email Field
			
		driver.findElement(AccessPolicyField).click(); // Access policy DDL 
		Select AccessPolicyDDL = new Select(driver.findElement(AccessPolicyField));
		AccessPolicyDDL.selectByVisibleText(DefaultPolicy);  // Access policy options 
		Thread.sleep(Const * 3);
			
		driver.findElement(TimePolicyField).click();// Time Policy DDL 
		Select TimePolicyDDL = new Select(driver.findElement(TimePolicyField));
		TimePolicyDDL.selectByVisibleText(DefaultEscalationSteps); 
		TimePolicyDDL.selectByVisibleText(MOHDefualtTiming); // Time policy options
		Thread.sleep(Const * 3);
			
		driver.findElement(userStatus).click();   // User Status DDL
		Select userstatusDDL = new Select(driver.findElement(userStatus));
		userstatusDDL.selectByVisibleText(activeStatus); // User Status Options
		Thread.sleep(Const * 3);
		
		driver.findElement(defaultLanguage).click();  // Default Language DDL 
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
		LanguageDDL.selectByVisibleText(Arabic);  // Default language option 
		Thread.sleep(Const * 3);	
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; // Scrolling Down to show hidde elements 
		jse.executeScript("window.scrollBy(0,750)", "");
		driver.findElement(RequiredMessagesCheckbox).click();// Check-box of required Messages
		driver.findElement(RequiredMailCheckbox).click(); // Check-box of Required mail
		JavascriptExecutor js = (JavascriptExecutor)driver; // Scrolling down to shown hidden elements 
		js.executeScript("window.scrollBy(0,900)", "");
		
		driver.findElement(SelectRole).click(); // Selecting Role
		driver.findElement(moveButton).click();
		Thread.sleep(Const * 3);
		//driver.findElement(arThirdName).clear(); // clearing the content of Third Arabic Name
		
	//	driver.findElement(arThirdName).sendKeys(Keys.TAB);
		Thread.sleep(Const);
		
		// Press Create Button
	  //  driver.findElement(CreateButton).click();

		if (driver.findElement(CreateButton).isSelected())
		{ driver.findElement(CreateButton).click();
		  System.out.println("Create button is enabled");
		}
			{
			System.out.println("Create button is disabled");
			}
			
			Thread.sleep(Const *10);

		      
		    TakesScreenshot ts5=(TakesScreenshot)driver;
			File source5=ts5.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source5, new File("Screenshots/MissingFieldofMOHUserDefinition.png"));
			Thread.sleep(Const * 2);

	}	
	
	
	@Test(priority= 7)    /////// Incorrect password Content  Scenario/////////
	public void IncorrectPasswordofMOHUserDefinition() throws InterruptedException, IOException{
	
		driver.findElement(RegistrationList).click(); //-- registration Menu
		driver.findElement(usersList).click();    // Users sub-Menu
		driver.findElement(defineUser).click(); // Define new user Option
		
		driver.findElement(userType).click(); // Applicant type -to exit the Menu 
		Select userTypeDDL = new Select(driver.findElement(userType)); // Select From DDL Applicant Type 
		userTypeDDL.selectByVisibleText(MOHuser); // MOH User
		Thread.sleep(Const * 3); 
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(username)).click();
		action1.click();
		action1.sendKeys(userNameContent); // Fill in username Field
		action1.build().perform();
		Thread.sleep(Const * 3);
		driver.findElement(Directorate).click();
		Select DirectorateDDL = new Select(driver.findElement(Directorate)); // Select Directorate 
		DirectorateDDL.selectByVisibleText(Balqaa); // Directorate Options  
		Thread.sleep(Const * 3);
		
		driver.findElement(password).sendKeys(IcorrectPasswordContent); // Password
		driver.findElement(arFirstName).sendKeys(arFirstNameContent); // First Arabic Name
		driver.findElement(arSecondName).sendKeys(arSecondNameContent); // Second Arabic Name
	    driver.findElement(arThirdName).sendKeys(arThirdNameContent); //Third Arabic Name
		driver.findElement(arFourthName).sendKeys(arFourthNameContent); // Fourth Arabic Name
		driver.findElement(enFirstName).sendKeys(enFirstNameContent); // First English Name
		driver.findElement(enSecondName).sendKeys(enSecondNameContent); // Second English Name
		driver.findElement(enThirdName).sendKeys(enThirdNameContent); // Third English Name
		driver.findElement(enFourthName).sendKeys(enFourthNameContent); // Fourth English Name
		Thread.sleep(Const * 3);
		
		driver.findElement(phoneNum).sendKeys(PhoneNumContent); // Phone Number Field
		driver.findElement(CountryCode).sendKeys(CodeNo2); // Country code Field
		driver.findElement(email).sendKeys(emailContent); // Email Field
		Thread.sleep(Const * 3);
		driver.findElement(AccessPolicyField).click(); // Access policy DDL 
		Select AccessPolicyDDL = new Select(driver.findElement(AccessPolicyField));
		AccessPolicyDDL.selectByVisibleText(DefaultPolicy);  // Access policy options 
		Thread.sleep(Const * 3);
			
		driver.findElement(TimePolicyField).click();// Time Policy DDL 
		Select TimePolicyDDL = new Select(driver.findElement(TimePolicyField));
		TimePolicyDDL.selectByVisibleText(DefaultEscalationSteps); 
		TimePolicyDDL.selectByVisibleText(MOHDefualtTiming); // Time policy options
		Thread.sleep(Const * 3);
			
		driver.findElement(userStatus).click();   // User Status DDL
		Select userstatusDDL = new Select(driver.findElement(userStatus));
		userstatusDDL.selectByVisibleText(activeStatus); // User Status Options
		Thread.sleep(Const * 3);
		
		driver.findElement(defaultLanguage).click();  // Default Language DDL 
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
		LanguageDDL.selectByVisibleText(Arabic);  // Default language option 
		Thread.sleep(Const * 3);	
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; // Scrolling Down to show hidde elements 
		jse.executeScript("window.scrollBy(0,750)", "");
		driver.findElement(RequiredMessagesCheckbox).click();// Check-box of required Messages
		driver.findElement(RequiredMailCheckbox).click(); // Check-box of Required mail
		JavascriptExecutor js = (JavascriptExecutor)driver; // Scrolling down to shown hidden elements 
		js.executeScript("window.scrollBy(0,900)", "");
		
		driver.findElement(SelectRole).click(); // Selecting Role
		driver.findElement(moveButton).click();
		Thread.sleep(Const * 3);
		driver.findElement(CreateButton).click(); // Press Create Button
	

		Thread.sleep(Const);
			
			Thread.sleep(Const * 7);
			String ActualResult = driver.findElement(successMessage).getText(); // Message that appears one the system 
		    System.out.println(ActualResult);
			String ExpectedResult = IncorrectPassword; // Message that is expected according to the test case 
			Assert.assertTrue(ActualResult.contains(ExpectedResult));
			System.out.println("Actual Message: " + ActualResult);
			System.out.println("Expected Message: " + ExpectedResult + "PASSED IncorrectPasswordofMOHUserDefinition Test case");
			
			
			
	}	
	

	@Test(priority= 8)    /////// language Content  Scenario/////////
	public void fieldARLanguageMOHUserDefinition() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); //-- registration Menu
		driver.findElement(usersList).click();    // Users sub-Menu
		driver.findElement(defineUser).click(); // Define new user Option
		
		driver.findElement(userType).click(); // Applicant type -to exit the Menu 
		Select userTypeDDL = new Select(driver.findElement(userType)); // Select From DDL Applicant Type 
		userTypeDDL.selectByVisibleText(MOHuser); // MOH User
		Thread.sleep(Const * 3);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(username)).click();
		action1.click();
		action1.sendKeys(newuserNameContent); // Fill in username Field
		action1.build().perform();
		Thread.sleep(Const * 3);

		driver.findElement(Directorate).click();
		Select DirectorateDDL = new Select(driver.findElement(Directorate)); // Select Directorate 
		DirectorateDDL.selectByVisibleText(Balqaa); // Directorate Options  
		Thread.sleep(Const * 3);
		
		driver.findElement(password).sendKeys(PasswordContent); // Password
		driver.findElement(arFirstName).sendKeys(enFirstNameContent); // First Arabic Name filled with English content
		driver.findElement(arSecondName).sendKeys(arSecondNameContent); // Second Arabic Name
	    driver.findElement(arThirdName).sendKeys(arThirdNameContent); //Third Arabic Name
		driver.findElement(arFourthName).sendKeys(arFourthNameContent); // Fourth Arabic Name
		driver.findElement(enFirstName).sendKeys(enFirstNameContent); // First English Name 
		driver.findElement(enSecondName).sendKeys(enSecondNameContent); // Second English Name
		driver.findElement(enThirdName).sendKeys(enThirdNameContent); // Third English Name
		driver.findElement(enFourthName).sendKeys(enFourthNameContent); // Fourth English Name
		Thread.sleep(Const * 3);
		
		driver.findElement(phoneNum).sendKeys(PhoneNumContent); // Phone Number Field
		driver.findElement(CountryCode).sendKeys(CodeNo2); // Country code Field
		driver.findElement(email).sendKeys(emailContent); // Email Field
			
		driver.findElement(AccessPolicyField).click(); // Access policy DDL 
		Select AccessPolicyDDL = new Select(driver.findElement(AccessPolicyField));
		AccessPolicyDDL.selectByVisibleText(DefaultPolicy);  // Access policy options 
		Thread.sleep(Const * 3);
			
		driver.findElement(TimePolicyField).click();// Time Policy DDL 
		Select TimePolicyDDL = new Select(driver.findElement(TimePolicyField));
		//TimePolicyDDL.selectByVisibleText(DefaultEscalationSteps); 
		TimePolicyDDL.selectByVisibleText(MOHDefualtTiming); // Time policy options
		Thread.sleep(Const * 3);
			
		driver.findElement(userStatus).click();   // User Status DDL
		Select userstatusDDL = new Select(driver.findElement(userStatus));
		userstatusDDL.selectByVisibleText(activeStatus); // User Status Options
		Thread.sleep(Const * 3);
		
		driver.findElement(defaultLanguage).click();  // Default Language DDL 
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
		LanguageDDL.selectByVisibleText(Arabic);  // Default language option 
		Thread.sleep(Const * 3);	
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; // Scrolling Down to show hidde elements 
		jse.executeScript("window.scrollBy(0,750)", "");
		driver.findElement(RequiredMessagesCheckbox).click();// Check-box of required Messages
		driver.findElement(RequiredMailCheckbox).click(); // Check-box of Required mail
		JavascriptExecutor js = (JavascriptExecutor)driver; // Scrolling down to shown hidden elements 
		js.executeScript("window.scrollBy(0,900)", "");
		
		driver.findElement(SelectRole).click(); // Selecting Role
		driver.findElement(moveButton).click();
		Thread.sleep(Const * 3);
		driver.findElement(CreateButton).click(); // Press Create Button

		Thread.sleep(Const);
			
			Thread.sleep(Const * 7);
			String ActualResult = driver.findElement(successMessage).getText(); // Message that appears one the system 
		    System.out.println(ActualResult);
			String ExpectedResult = ArabicContent; // Message that is expected according to the test case 
			Assert.assertTrue(ActualResult.contains(ExpectedResult));
			System.out.println("Actual Message: " + ActualResult);
			System.out.println("Expected Message: " + ExpectedResult + "PASSED fieldArLanguageMOHUserDefinition Test case");
	}	


	@Test(priority= 9)    /////// language Content  Scenario/////////
	public void fieldEnLanguageMOHUserDefinition() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); //-- registration Menu
		driver.findElement(usersList).click();    // Users sub-Menu
		driver.findElement(defineUser).click(); // Define new user Option
		
		driver.findElement(userType).click(); // Applicant type -to exit the Menu 
		Select userTypeDDL = new Select(driver.findElement(userType)); // Select From DDL Applicant Type 
		userTypeDDL.selectByVisibleText(MOHuser); // MOH User
		Thread.sleep(Const * 3);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(username)).click();
		action1.click();
		action1.sendKeys(newuserNameContent); // Fill in username Field
		action1.build().perform();
		Thread.sleep(Const * 3);

		driver.findElement(Directorate).click();
		Select DirectorateDDL = new Select(driver.findElement(Directorate)); // Select Directorate 
		DirectorateDDL.selectByVisibleText(Balqaa); // Directorate Options  
		Thread.sleep(Const * 3);
		
		driver.findElement(password).sendKeys(PasswordContent); // Password
		driver.findElement(arFirstName).sendKeys(arFirstNameContent); // First Arabic Name 
		driver.findElement(arSecondName).sendKeys(arSecondNameContent); // Second Arabic Name
	    driver.findElement(arThirdName).sendKeys(arThirdNameContent); //Third Arabic Name
		driver.findElement(arFourthName).sendKeys(arFourthNameContent); // Fourth Arabic Name
		driver.findElement(enFirstName).sendKeys(arFirstNameContent); // First English Name Filled with Arabic content
		driver.findElement(enSecondName).sendKeys(enSecondNameContent); // Second English Name
		driver.findElement(enThirdName).sendKeys(enThirdNameContent); // Third English Name
		driver.findElement(enFourthName).sendKeys(enFourthNameContent); // Fourth English Name
		Thread.sleep(Const * 3);
		
		driver.findElement(phoneNum).sendKeys(PhoneNumContent); // Phone Number Field
		driver.findElement(CountryCode).sendKeys(CodeNo2); // Country code Field
		driver.findElement(email).sendKeys(emailContent); // Email Field
		Thread.sleep(Const * 3);
	
		driver.findElement(AccessPolicyField).click(); // Access policy DDL 
		Select AccessPolicyDDL = new Select(driver.findElement(AccessPolicyField));
		AccessPolicyDDL.selectByVisibleText(DefaultPolicy);  // Access policy options 
		Thread.sleep(Const * 3);
			
		driver.findElement(TimePolicyField).click();// Time Policy DDL 
		Select TimePolicyDDL = new Select(driver.findElement(TimePolicyField));
		TimePolicyDDL.selectByVisibleText(DefaultEscalationSteps); 
		TimePolicyDDL.selectByVisibleText(MOHDefualtTiming); // Time policy options
		Thread.sleep(Const * 3);
			
		driver.findElement(userStatus).click();   // User Status DDL
		Select userstatusDDL = new Select(driver.findElement(userStatus));
		userstatusDDL.selectByVisibleText(activeStatus); // User Status Options
		Thread.sleep(Const * 3);
		
		driver.findElement(defaultLanguage).click();  // Default Language DDL 
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
		LanguageDDL.selectByVisibleText(Arabic);  // Default language option 
		Thread.sleep(Const * 3);	
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; // Scrolling Down to show hidde elements 
		jse.executeScript("window.scrollBy(0,750)", "");
		driver.findElement(RequiredMessagesCheckbox).click();// Check-box of required Messages
		driver.findElement(RequiredMailCheckbox).click(); // Check-box of Required mail
		JavascriptExecutor js = (JavascriptExecutor)driver; // Scrolling down to shown hidden elements 
		js.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(Const * 3);

		driver.findElement(SelectRole).click(); // Selecting Role
		driver.findElement(moveButton).click();
		Thread.sleep(Const * 3);
		driver.findElement(CreateButton).click(); // Press Create Button

		Thread.sleep(Const);
			
			Thread.sleep(Const * 7);
			String ActualResult = driver.findElement(successMessage).getText(); // Message that appears one the system 
		    System.out.println(ActualResult);
			String ExpectedResult = EnglishContent; // Message that is expected according to the test case 
			Assert.assertTrue(ActualResult.contains(ExpectedResult));
			System.out.println("Actual Message: " + ActualResult);
			System.out.println("Expected Message: " + ExpectedResult + " PASSED fieldEnLanguageMOHUserDefinition Test case");
	}	

	// New NCC user
	@Test(priority= 10)                                        //////////////Define New NCC User
	public void DefineNewNCCUser() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); // Registration menu
		driver.findElement(usersList).click(); // Users menu
		driver.findElement(defineUser).click(); // Define users option
		
		driver.findElement(userType).click(); // Select user type to move out  lists
		Select userTypeDDL = new Select(driver.findElement(userType)); // Select user type 
		userTypeDDL.selectByVisibleText(NCCuser);   // NCC user Type
		Thread.sleep(Const * 3);
		//// Fill in username
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(username)).click(); 
		action1.click();
		action1.sendKeys(newuserNameContent);
		action1.build().perform();
		
		Thread.sleep(Const * 3);

		driver.findElement(password).sendKeys(PasswordContent);  // Fill in Password
		Thread.sleep(Const * 3);

		driver.findElement(arFirstName).sendKeys(arFirstNameContent); // Arabic first name 
		Thread.sleep(Const * 3);

		driver.findElement(arSecondName).sendKeys(arSecondNameContent); // Arabic second name 
		Thread.sleep(Const * 3);

		driver.findElement(arThirdName).sendKeys(arThirdNameContent);  // Arabic third name
		Thread.sleep(Const * 3);

		driver.findElement(arFourthName).sendKeys(arFourthNameContent); // Arabic fourth name 
		Thread.sleep(Const * 3);

		driver.findElement(enFirstName).sendKeys(enFirstNameContent);   // English First name
		Thread.sleep(Const * 3);

		driver.findElement(enSecondName).sendKeys(enSecondNameContent); // English second name 
		Thread.sleep(Const * 3);

		driver.findElement(enThirdName).sendKeys(enThirdNameContent);  // English Third name
		Thread.sleep(Const * 3);

		driver.findElement(enFourthName).sendKeys(enFourthNameContent);  // English Fourth name 
		Thread.sleep(Const * 3);
		driver.findElement(phoneNum).sendKeys(PhoneNumContent);  // Phone number field
		Thread.sleep(Const * 3);

		driver.findElement(CountryCode).sendKeys(CodeNo2);  // Country code field 
		driver.findElement(email).sendKeys(emailContent); // email field
		driver.findElement(AccessPolicyField).click(); // Access policy 
		Select NCCAccessPolicyDDL = new Select(driver.findElement(AccessPolicyField)); 
		NCCAccessPolicyDDL.selectByVisibleText(DefaultPolicy);  // Access Policy option
		Thread.sleep(Const * 3);
		
		driver.findElement(TimePolicyField).click(); //Time policy 
		Select NCCTimePolicyDDL = new Select(driver.findElement(TimePolicyField));
		NCCTimePolicyDDL.selectByVisibleText(NCCPolicy);   // Time policy option 
		Thread.sleep(Const * 3);
		
		driver.findElement(userStatus).click(); // User status DDL
		Select userstatusDDL = new Select(driver.findElement(userStatus));
		userstatusDDL.selectByVisibleText(activeStatus);  // user status option
		Thread.sleep(Const * 3);
		
		driver.findElement(defaultLanguage).click(); // Default language DDL 
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
		LanguageDDL.selectByVisibleText(Arabic);  // Default language option 
		Thread.sleep(Const * 3);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; // Scroll down to show elements 
		jse.executeScript("window.scrollBy(0,750)", "");
	
	
		driver.findElement(Create).click(); // press Create Button 
		Thread.sleep(Const * 7);

		String ActualResult = driver.findElement(successMessage).getText(); // verify Expected Message 
		System.out.println(ActualResult);
		String ExpectedResult = updateSucceed;
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
  
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + " PASSED DefineNewNCCUser ");
	
	}


	@Test(priority= 11)                                        ////////// Define already existing NCC user //////////////////////////
	public void DefineAlreadyExistingNCCUser() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); // Registration menu 
		driver.findElement(usersList).click(); // Users menu
		driver.findElement(defineUser).click(); // Define user option
		
		driver.findElement(userType).click();  // Move out of lists 
		Select userTypeDDL = new Select(driver.findElement(userType)); // select user Type 
		userTypeDDL.selectByVisibleText(NCCuser);  // User Types option
		Thread.sleep(Const * 3);
		// Fill in user name 
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(username)).click(); 
		action1.click();
		action1.sendKeys(userNameContent);
		action1.build().perform();
		Thread.sleep(Const * 3);

		driver.findElement(password).sendKeys(PasswordContent); // Fill in password
		driver.findElement(arFirstName).sendKeys(arFirstNameContent); // Fill in Arabic name fields
		driver.findElement(arSecondName).sendKeys(arSecondNameContent);
		driver.findElement(arThirdName).sendKeys(arThirdNameContent);
		driver.findElement(arFourthName).sendKeys(arFourthNameContent);
		driver.findElement(enFirstName).sendKeys(enFirstNameContent); // Fill in English name fields
		driver.findElement(enSecondName).sendKeys(enSecondNameContent);
		driver.findElement(enThirdName).sendKeys(enThirdNameContent);
		driver.findElement(enFourthName).sendKeys(enFourthNameContent);
		Thread.sleep(Const * 3);
		driver.findElement(phoneNum).sendKeys(PhoneNumContent); // Phone number
		driver.findElement(CountryCode).sendKeys(CodeNo2); // Country code
		driver.findElement(email).sendKeys(emailContent); // Email Field 
		driver.findElement(AccessPolicyField).click();  // access policy DDL 
		Select NCCAccessPolicyDDL = new Select(driver.findElement(AccessPolicyField));
		NCCAccessPolicyDDL.selectByVisibleText(DefaultPolicy);  // options of access policy 
		Thread.sleep(Const * 3);
		
		driver.findElement(TimePolicyField).click(); // Time policy DDL
		Select NCCTimePolicyDDL = new Select(driver.findElement(TimePolicyField));
		NCCTimePolicyDDL.selectByVisibleText(NCCPolicy);  // Time policy Option
		Thread.sleep(Const * 3);
		
		driver.findElement(userStatus).click();
		Select userstatusDDL = new Select(driver.findElement(userStatus)); // User status DDL 
		userstatusDDL.selectByVisibleText(activeStatus);  // User status options
		Thread.sleep(Const * 3);
		
		driver.findElement(defaultLanguage).click(); // Default language DDL
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
		LanguageDDL.selectByVisibleText(Arabic);  // Default language options
		Thread.sleep(Const * 3);
		

		driver.findElement(CreateButton).click(); // Press Create button
		
		Thread.sleep(Const * 7); // verify Expected Result

		String ActualResult = driver.findElement(successMessage).getText();
		System.out.println(ActualResult);
		String ExpectedResult = UserAlreadyExists;
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
  
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + "PASSED DefineNewNCCUser ");
	
	}

	
	//New user- STK
	@Test(priority= 12)
	public void DefineNewSTKUser() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); // Registration menu
		driver.findElement(usersList).click(); // Users menu
		driver.findElement(defineUser).click(); // Define user Option
		
		driver.findElement(userType).click(); // Move out of lists
		Select userTypeDDL = new Select(driver.findElement(userType)); // Select User Type
		userTypeDDL.selectByVisibleText(STKuser);  // User Type option 
		Thread.sleep(Const * 3);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(username)).click(); // Fill in username 
		action1.click();
		action1.sendKeys(newuserNameContent);
		action1.build().perform();
		Thread.sleep(Const * 3);

		driver.findElement(password).sendKeys(PasswordContent);  // Password Field
		Thread.sleep(Const * 3);

		driver.findElement(arFirstName).sendKeys(arFirstNameContent); // Fill in Arabic name Fields
		driver.findElement(arSecondName).sendKeys(arSecondNameContent);
		driver.findElement(arThirdName).sendKeys(arThirdNameContent);
		driver.findElement(arFourthName).sendKeys(arFourthNameContent);
		driver.findElement(enFirstName).sendKeys(enFirstNameContent); // Fill in english name Fields
		driver.findElement(enSecondName).sendKeys(enSecondNameContent);
		driver.findElement(enThirdName).sendKeys(enThirdNameContent);
		driver.findElement(enFourthName).sendKeys(enFourthNameContent);
		Thread.sleep(Const * 3);
		driver.findElement(phoneNum).sendKeys(PhoneNumContent);// Fill in phone content
		driver.findElement(CountryCode).sendKeys(CodeNo2); // Code COUNTRY
		driver.findElement(email).sendKeys(emailContent); // Email content 
		Thread.sleep(Const * 3);

		driver.findElement(AccessPolicyField).click(); // Access Policy DDL
		Select AccessPolicyDDL = new Select(driver.findElement(AccessPolicyField)); // Select access Policy 
		AccessPolicyDDL.selectByVisibleText(DefaultPolicy);  // Access policy Options
		Thread.sleep(Const * 3);
		
		driver.findElement(TimePolicyField).click(); // Time policy DDL 
		Select TimePolicyDDL = new Select(driver.findElement(TimePolicyField)); // select Time Policy 
		TimePolicyDDL.selectByVisibleText(STKPolicy); // Time Policy option 
		Thread.sleep(Const * 3);

		driver.findElement(userStatus).click(); // User Status DDL 
		Select userstatusDDL = new Select(driver.findElement(userStatus)); // Select user status
		userstatusDDL.selectByVisibleText(activeStatus);  // user status Options
		Thread.sleep(Const * 3);
		
		driver.findElement(defaultLanguage).click(); // Default language DDL
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));// Select default language
		LanguageDDL.selectByVisibleText(Arabic);  // Default language options
		Thread.sleep(Const * 3);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; // Scroll down 
		jse.executeScript("window.scrollBy(0,750)", "");
		Thread.sleep(Const * 3);

		driver.findElement(RequiredMessagesCheckbox).click(); // Required Message check box 
		driver.findElement(RequiredMailCheckbox).click(); // Required Mail check box
		Thread.sleep(Const * 3);

		JavascriptExecutor js = (JavascriptExecutor)driver; // Scroll down 
		js.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(Const * 3);

		driver.findElement(SelectRole).click(); // Select Role 
		driver.findElement(moveButton).click();
		
		Thread.sleep(Const * 3);

		driver.findElement(CreateButton).click(); // Press on Create Button 
	
		Thread.sleep(Const * 7); // verify Expected Message 

		String ActualResult = driver.findElement(successMessage).getText();
		System.out.println(ActualResult);
		String ExpectedResult = updateSucceed;
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
  

		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + " PASSED DefineNewSTKUser");
	}

/////////////////////////////////////////////// / //Existing  user- STK/////////////////////////////////////////////////////////////
		                                                                             
	@Test(priority= 13)
	public void DefineExistingSTKUser() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); // Registration menu
		driver.findElement(usersList).click(); // Users menu
		driver.findElement(defineUser).click(); // Define user Option
		
		driver.findElement(userType).click(); // Move out of lists
		Select userTypeDDL = new Select(driver.findElement(userType)); // Select User Type
		userTypeDDL.selectByVisibleText(STKuser);  // User Type option 
		Thread.sleep(Const * 3);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(username)).click(); // Fill in username 
		action1.click();
		action1.sendKeys(userNameContent);
		action1.build().perform();
		
		driver.findElement(password).sendKeys(PasswordContent);  // Password Field
		driver.findElement(arFirstName).sendKeys(arFirstNameContent); // Fill in Arabic name Fields
		driver.findElement(arSecondName).sendKeys(arSecondNameContent);
		driver.findElement(arThirdName).sendKeys(arThirdNameContent);
		driver.findElement(arFourthName).sendKeys(arFourthNameContent);
		driver.findElement(enFirstName).sendKeys(enFirstNameContent); // Fill in English name Fields
		driver.findElement(enSecondName).sendKeys(enSecondNameContent);
		driver.findElement(enThirdName).sendKeys(enThirdNameContent);
		driver.findElement(enFourthName).sendKeys(enFourthNameContent);
		Thread.sleep(Const * 3);
		driver.findElement(phoneNum).sendKeys(PhoneNumContent);// Fill in phone content
		driver.findElement(CountryCode).sendKeys(CodeNo2); // Code COUNTRY
		driver.findElement(email).sendKeys(emailContent); // Email content 
		
		driver.findElement(AccessPolicyField).click(); // Access Policy DDL
		Select AccessPolicyDDL = new Select(driver.findElement(AccessPolicyField)); // Select access Policy 
		AccessPolicyDDL.selectByVisibleText(DefaultPolicy);  // Access policy Options
		Thread.sleep(Const * 3);
		
		driver.findElement(TimePolicyField).click(); // Time policy DDL 
		Select TimePolicyDDL = new Select(driver.findElement(TimePolicyField)); // select Time Policy 
		TimePolicyDDL.selectByVisibleText(STKPolicy); // Time Policy option 
		
		driver.findElement(userStatus).click(); // User Status DDL 
		Select userstatusDDL = new Select(driver.findElement(userStatus)); // Select user status
		userstatusDDL.selectByVisibleText(activeStatus);  // user status Options
		Thread.sleep(Const * 3);
		
		driver.findElement(defaultLanguage).click(); // Default language DDL
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));// Select default language
		LanguageDDL.selectByVisibleText(Arabic);  // Default language options
		Thread.sleep(Const * 3);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; // Scroll down 
		jse.executeScript("window.scrollBy(0,750)", "");
	
		driver.findElement(RequiredMessagesCheckbox).click(); // Required Message check box 
		driver.findElement(RequiredMailCheckbox).click(); // Required Mail check box
		
		JavascriptExecutor js = (JavascriptExecutor)driver; // Scroll down 
		js.executeScript("window.scrollBy(0,900)", "");

		driver.findElement(SelectRole).click(); // Select Role 
		driver.findElement(moveButton).click();
		
		Thread.sleep(Const * 3);

		driver.findElement(CreateButton).click(); // Press on Create Button 
	
		Thread.sleep(Const * 7); // verify Expected Message 

		String ActualResult = driver.findElement(successMessage).getText();
		System.out.println(ActualResult);
		String ExpectedResult = UserAlreadyExists;
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
  

		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + " PASSED DefineExistingSTKUser Test Case");
	}
	
////////////////////////////////////////////////////////////////////////new RMS user////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	 @Test(priority=14)
	public void DefineNewRMSUser() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); // Registration menu
		driver.findElement(usersList).click(); // Users menu
		driver.findElement(defineUser).click(); // Define user Option 
		
		driver.findElement(userType).click(); // Move out of lists
		Select userTypeDDL = new Select(driver.findElement(userType)); // User Type DDL
		userTypeDDL.selectByVisibleText(RMSUser);  // User type Option
		Thread.sleep(Const * 3);
		
		Actions action1 = new Actions(driver); 
		action1.moveToElement(driver.findElement(nationalNo)).click(); // National Number Field
		action1.click();
		action1.sendKeys(NationalNumberContent); 
		action1.build().perform();
		
		Thread.sleep(Const * 3);
		driver.findElement(password).sendKeys(PasswordContent);  // Password Field
		driver.findElement(institueName).sendKeys(Institute); // Institute Name Field

		Thread.sleep(Const * 3);
		driver.findElement(phoneNum).sendKeys(PhoneNumContent); // Phone number Content
		driver.findElement(CountryCode).sendKeys(CodeNo2); // Country code DDL
		driver.findElement(email).sendKeys(emailContent); // Email Field
		driver.findElement(address).sendKeys(AddressContent); // Address Field 
		Thread.sleep(Const * 3);

		driver.findElement(defaultLanguage).click(); // Default language DDL
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
		LanguageDDL.selectByVisibleText(Arabic);  // Default language Options
		Thread.sleep(Const * 3);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; // Scroll Down
		jse.executeScript("window.scrollBy(0,750)", "");
	
		Thread.sleep(Const * 3);

		driver.findElement(CreateButton).click(); // Press on create Button
	
		Thread.sleep(Const * 7); 
		// Verify Expected Message 

		String ActualResult = driver.findElement(successMessage).getText();
		System.out.println(ActualResult);
		String ExpectedResult = updateSucceed;
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
  
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult +" PASSED DefineNewRMSUser Test Case ");

	} 
	
////////////////////////////////////////////////////////////////////////////////////RMS  Existing user/////////////////////////////////////////////////////////////////////////////
		@Test(priority=15)
		public void DefineExistingRMSUser() throws InterruptedException{
		
			driver.findElement(RegistrationList).click(); // Registration menu 
			driver.findElement(usersList).click();   // User Menu 
			driver.findElement(defineUser).click(); // Define user
			Thread.sleep(Const * 7); 
			driver.findElement(userType).click(); // Move out of Menu 
			Select userTypeDDL = new Select(driver.findElement(userType)); // Select User Type
			userTypeDDL.selectByVisibleText(RMSUser);  // User Type Option
			Thread.sleep(Const * 3);
			
			Actions action1 = new Actions(driver); // Fill in National Number field
			action1.moveToElement(driver.findElement(nationalNo)).click();
			action1.click();
			action1.sendKeys(Username_NationalNoContent);
			action1.build().perform();
			 
			Thread.sleep(Const * 3);  // Fill in Password Field
			driver.findElement(password).sendKeys(PasswordContent); 
			driver.findElement(institueName).sendKeys(Institute);

			Thread.sleep(Const * 3);
			driver.findElement(phoneNum).sendKeys(PhoneNumContent); // Phone number Field
			driver.findElement(CountryCode).sendKeys(CodeNo2); // Country Code DDL 
			driver.findElement(email).sendKeys(emailContent); // Email field
			driver.findElement(address).sendKeys(AddressContent); // Address Content
			Thread.sleep(Const * 7); 
			driver.findElement(defaultLanguage).click();// Default language DDL 
			Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
			LanguageDDL.selectByVisibleText(Arabic);  // Default language option
			Thread.sleep(Const * 3);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;  // Scroll down 
			jse.executeScript("window.scrollBy(0,750)", "");
					

			Thread.sleep(Const * 3);

			driver.findElement(CreateButton).click(); // Press on Create Button 
		
			Thread.sleep(Const * 7); // Verify Expected Message 

			String ActualResult = driver.findElement(successMessage).getText();
			System.out.println(ActualResult);
			String ExpectedResult = UserAlreadyExists;
			Assert.assertTrue(ActualResult.contains(ExpectedResult));
			System.out.println("Actual Message: " + ActualResult);
			System.out.println("Expected Message: " + ExpectedResult +" PASSED DefineExistingRMSUser Test Case ");

		} 
		

	// Health Institute user
	 
	 // New Health Institute User 
	@Test(priority= 16)
	public void DefineNewHealthInstituteUser() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); // Registration Menu
		driver.findElement(usersList).click(); // User Menu
		driver.findElement(defineUser).click(); // User Definition
		Thread.sleep(Const * 7); 
		driver.findElement(userType).click(); // Move out of menu
		Select userTypeDDL = new Select(driver.findElement(userType)); // User Type DDL 
		userTypeDDL.selectByVisibleText(healthInstitute);  // User Type option
		Thread.sleep(Const * 3);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(UsernameNationalNo)).click(); // Fill in username National Number 
		action1.click();
		action1.sendKeys(Username_NationalNoContent);
		action1.build().perform();
		Thread.sleep(Const * 7); 
		driver.findElement(password).sendKeys(PasswordContent);  // Fill in password Field
		Thread.sleep(Const * 3);
		driver.findElement(phoneNum).sendKeys(PhoneNumContent); // Fill in Phone number 
		driver.findElement(CountryCode).sendKeys(CodeNo2); // Country Code DDL 
		driver.findElement(email).sendKeys(emailContent); // Fill in email field 
		driver.findElement(address).sendKeys(AddressContent); // Fill in address field
		Thread.sleep(Const * 3);
	

		driver.findElement(defaultLanguage).click(); // default language DDL 
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
		LanguageDDL.selectByVisibleText(Arabic);  // Default Language DDL 
		Thread.sleep(Const * 3);
		

		driver.findElement(CreateButton).click(); //press  Create Button 
	  
	    Thread.sleep(Const * 7);  // Verify Expected Result

	    String ActualResult = driver.findElement(successMessage).getText();
	    System.out.println(ActualResult);
	    String ExpectedResult = updateSucceed;
	    Assert.assertTrue(ActualResult.contains(ExpectedResult));
  

	    System.out.println("Actual Message: " + ActualResult);
	    System.out.println("Expected Message: " + ExpectedResult + " PASSED DefineNewHealthInstituteUser");
	
	}

////////////////////// Health Institute user - not Related National Number * Validation on username (National Number)////////////////
	@Test(priority= 17)
	public void UnrelatedNationalNumberHealthInstituteUser() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); // Registration Menu
		driver.findElement(usersList).click(); // User Menu
		driver.findElement(defineUser).click(); // User Definition
		
		driver.findElement(userType).click(); // Move out of menu
		Select userTypeDDL = new Select(driver.findElement(userType)); // User Type DDL 
		userTypeDDL.selectByVisibleText(healthInstitute);  // User Type option
		Thread.sleep(Const * 3);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(UsernameNationalNo)).click(); // Fill in username National Number 
		action1.click();
		action1.sendKeys(Username_NationalNoContent);
		action1.build().perform();
		
		 Thread.sleep(Const * 7);  // Verify Expected Result

		 String ActualResult = driver.findElement(successMessage).getText();
		 System.out.println(ActualResult);
	    String ExpectedResult = NationalNumofInstitution;
	    Assert.assertTrue(ActualResult.contains(ExpectedResult));
	    System.out.println("Actual Message: " + ActualResult);
	    System.out.println("Expected Message: " + ExpectedResult + "PASSED UnrelatedNationalNumberHealthInstituteUser");
	
	}

/// Health Institute User Verification on National Number 
	@Test(priority= 18)
	public void NationalNumberVerificationHealthInstituteUser() throws InterruptedException, IOException{
	
		driver.findElement(RegistrationList).click(); // Registration Menu
		driver.findElement(usersList).click(); // User Menu
		driver.findElement(defineUser).click(); // User Definition
		
		driver.findElement(userType).click(); // Move out of menu
		Select userTypeDDL = new Select(driver.findElement(userType)); // User Type DDL 
		userTypeDDL.selectByVisibleText(healthInstitute);  // User Type option
		Thread.sleep(Const * 3);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(UsernameNationalNo)).click(); // Fill in username National Number 
		action1.click();
		action1.sendKeys(NationalNumberContent);
		action1.build().perform();
		
		Thread.sleep(Const * 3);
		driver.findElement(password).sendKeys(PasswordContent);  // Fill in password Field
		Thread.sleep(Const * 3); 
		
	if(	driver.findElement(institueName).getAttribute("value").isEmpty()) 
	{
		System.out.println("institue name is empty"); // if national number is not Related to institute the field of InstituteName will be empty 
	}
	else 
		System.out.println("institue name field has Content"); /// Here if national number is related to health institute the field of InstituteName will be filled  
	Thread.sleep(Const * 3); 
 
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("Screenshots/NationalNumberVerificationHealthInstituteUser.png"));
	
		Thread.sleep(Const * 3);
		driver.findElement(phoneNum).sendKeys(PhoneNumContent); // Fill in Phone number 
		driver.findElement(CountryCode).sendKeys(CodeNo2); // Country Code DDL 
		driver.findElement(email).sendKeys(emailContent); // Fill in email field 
		driver.findElement(address).sendKeys(AddressContent); // Fill in address field
		Thread.sleep(Const * 3);
		
		driver.findElement(defaultLanguage).click(); // default language DDL 
		Select LanguageDDL = new Select(driver.findElement(defaultLanguage));
		LanguageDDL.selectByVisibleText(Arabic);  // Default Language DDL 
		Thread.sleep(Const * 3);
	
		driver.findElement(CreateButton).click(); //press  Create Button 
	  
	    Thread.sleep(Const * 7);  // Verify Expected Result

	    String ActualResult = driver.findElement(successMessage).getText();
	    System.out.println(ActualResult);
	    String ExpectedResult = UserAlreadyExists;
	    Assert.assertTrue(ActualResult.contains(ExpectedResult));
  
	    System.out.println("Actual Message: " + ActualResult);
	    System.out.println("Expected Message: " + ExpectedResult + "Passed NationalNumberVerificationHealthInstituteUser Test case");
	
	}

	
   /////////////////////////////////////defineCommittee//////////////////////////
   //////////// ////////////////////Happy Scenario //////////////////////////////////

	@Test(priority= 19)
	public void defineCommittee() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); // Registration menu
		driver.findElement(usersList).click();   // Users Menu
		driver.findElement(defineCommittee).click(); //Define committee Option
	
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(ArCommitteeName)).click(); // Fill in Arabic Committee name
		action3.click();
		action3.sendKeys(ArCommitteeNameContent); // The content of Arabic Committee name
		action3.build().perform();
		
		Thread.sleep(Const *4);
		driver.findElement(EnCommitteeName).sendKeys(EnCommitteeNameContent);
		driver.findElement(EnCommitteeName).sendKeys(EnCommitteeNameContent); //Fill in English Committee Name
		Thread.sleep(Const *3);
		
		Select DirectorateDDL2 = new Select(driver.findElement(directorate));
		DirectorateDDL2.selectByVisibleText(Parliament); 
		Thread.sleep(Const *6);
  
		 // select directorate 
		Select DirectorateDDL3 = new Select(driver.findElement(directorate));
		DirectorateDDL3.selectByVisibleText(Balqaa); 
		Thread.sleep(Const *6);
	

		driver.findElement(defaultCommittee).click(); // Check or uncheck Default Committee 
		Thread.sleep(Const *3);
		
		driver.findElement(selectMember1).click(); // select committee Member 1
		driver.findElement(MoveButton).click();
		Thread.sleep(Const *3);
		
		driver.findElement(selectMember2).click(); // Select Commitee Member 2
		driver.findElement(MoveButton).click();
		Thread.sleep(Const *3);

		driver.findElement(CreateButton).click(); // Press on Update button 
		
		Thread.sleep(Const * 7); // Verify Expected Message 

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed; 
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
    	System.out.println("Actual Message: " + ActualResult);
    	System.out.println("Expected Message: " + ExpectedResult+ "Passed defineCommittee test case");
	}


	@Test(priority= 20)
	public void ExistingCommitteeName() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); // Registration menu
		driver.findElement(usersList).click();   // Users Menu
		driver.findElement(defineCommittee).click(); //Define committee Option
	
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(ArCommitteeName)).click(); // Fill in Arabic Committee name
		action3.click();
		action3.sendKeys(ArCommitteeNameContent); // The content of Arabic Committee name
		action3.build().perform();
		
		Thread.sleep(Const *3);
		driver.findElement(EnCommitteeName).sendKeys(EnCommitteeNameContent); //Fill in English Committee Name
		driver.findElement(EnCommitteeName).sendKeys(EnCommitteeNameContent); 
		Thread.sleep(Const *6);
		
		Select DirectorateDDL2 = new Select(driver.findElement(directorate));
		DirectorateDDL2.selectByVisibleText(Parliament); 
		Thread.sleep(Const *6);
  
		 // select directorate 
		Select DirectorateDDL3 = new Select(driver.findElement(directorate));
		DirectorateDDL3.selectByVisibleText(Balqaa); 
		Thread.sleep(Const *6);

		Thread.sleep(Const *3);
		
		//driver.findElement(defaultCommittee).click(); // Check or uncheck Default Committee 
	//	Thread.sleep(Const *3);
		
		driver.findElement(selectMember1).click(); // select committee Member 1
		driver.findElement(MoveButton).click();
		Thread.sleep(Const *3);
		
		driver.findElement(selectMember2).click(); // Select Commitee Member 2
		driver.findElement(MoveButton).click();
		Thread.sleep(Const *3);

		driver.findElement(CreateButton).click(); // Press on Update button 
		
		Thread.sleep(Const * 7); // Verify Expected Message 

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = ExistingCommitteeName; 
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
    	System.out.println("Actual Message: " + ActualResult);
    	System.out.println("Expected Message: " + ExpectedResult+ "Passed ExistingCommitteeName");
	}


	////////////////////////////////////////////////DefineDefaultCommittee/////////////////////////////////
	 ////// Existing Default Committee 
	@Test(priority= 21)
	public void DefineDefaultCommittee() throws InterruptedException{
	
		driver.findElement(RegistrationList).click();
		driver.findElement(usersList).click();
		driver.findElement(defineCommittee).click();
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(ArCommitteeName)).click();
		action3.click();
		action3.sendKeys(ArCommitteeNameContent);
		action3.build().perform();
		
		Thread.sleep(Const *3);
		driver.findElement(EnCommitteeName).sendKeys(EnCommitteeNameContent);
		Thread.sleep(Const *3);
		
		driver.findElement(EnCommitteeName).sendKeys(EnCommitteeNameContent);
		Thread.sleep(Const *3);
	
		Thread.sleep(Const *6);
		
	    driver.findElement(directorate).click();
		Thread.sleep(Const *3);

		Select DirectorateDDL2 = new Select(driver.findElement(directorate));
		DirectorateDDL2.selectByVisibleText(Balqaa); 

		Thread.sleep(Const *6);
		
		driver.findElement(defaultCommittee).click(); // Check or uncheck Default Committee 
		Thread.sleep(Const *3);
		
		driver.findElement(selectMember1).click(); // Select Member 1 of a committee
		driver.findElement(MoveButton).click();
		Thread.sleep(Const *5);
		
		driver.findElement(selectMember2).click(); // Select Member 2 of a committee
		driver.findElement(MoveButton).click();
		Thread.sleep(Const *3);

		driver.findElement(CreateButton).click(); // Press on Create Button 
		
		Thread.sleep(Const * 7); // Verify the Expected Message 

    	String ActualResult = driver.findElement(successMessage).getText();  
        System.out.println(ActualResult);
    	String ExpectedResult = alreadyHaveDefaultCommitee;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
    	System.out.println("Actual Message: " + ActualResult);
    	System.out.println("Expected Message: " + ExpectedResult+ "Passed ExistingCommitteeName");
	}
	
	
	
	@Test(priority= 22)
	public void CommitteeMemebersLessthan3orMore () throws InterruptedException{
	
		driver.findElement(RegistrationList).click();
		driver.findElement(usersList).click();
		driver.findElement(defineCommittee).click();
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(ArCommitteeName)).click();
		action3.click();
		action3.sendKeys(ArCommitteeNameContent);
		action3.build().perform();
		
		Thread.sleep(Const *3);
		driver.findElement(EnCommitteeName).sendKeys(EnCommitteeNameContent);
		Thread.sleep(Const *3);
		
		driver.findElement(EnCommitteeName).sendKeys(EnCommitteeNameContent);
		Thread.sleep(Const *3);
	
		Thread.sleep(Const *6);
		
	    driver.findElement(directorate).click();
		Thread.sleep(Const *3);

		Select DirectorateDDL2 = new Select(driver.findElement(directorate));
		DirectorateDDL2.selectByVisibleText(Balqaa); 

		Thread.sleep(Const *6);
		
		//driver.findElement(defaultCommittee).click(); // Check or uncheck Default Committee 
	//	Thread.sleep(Const *3);
		
		driver.findElement(selectMember1).click(); // Select Member 1 of a committee
		driver.findElement(MoveButton).click();
		Thread.sleep(Const *3);
		
		driver.findElement(selectMember2).click(); // Select Member 2 of a committee
		driver.findElement(MoveButton).click();
		Thread.sleep(Const *3);
		
		driver.findElement(selectMember1).click(); // Select Member 1 of a committee
		driver.findElement(MoveButton).click();
		Thread.sleep(Const *3);
		
		driver.findElement(selectMember1).click(); // Select Member 1 of a committee
		driver.findElement(MoveButton).click();
		Thread.sleep(Const *3);

		driver.findElement(CreateButton).click(); // Press on Create Button 
		
		Thread.sleep(Const * 7); // Verify the Expected Message 

    	String ActualResult = driver.findElement(successMessage).getText();  
        System.out.println(ActualResult);
    	String ExpectedResult = NumberOfCommitteeMember;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
    	System.out.println("Actual Message: " + ActualResult);
    	System.out.println("Expected Message: " + ExpectedResult+ "Passed CommitteeMemebersLessthan3orMore");
	}

	   //////////////////////////////////// Committees Management///////////////////////////////
	/////////////////////////////////////////////////////////// Happy Scenario /////////////////////////////////////
    @Test(priority= 22)
	public void CommitteesManagement() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); // registration Menu
		driver.findElement(usersList).click(); // User menu
		driver.findElement(committeesMangement).click(); // Committees Management
		
		Thread.sleep(Const *3);

	//	driver.findElement(CommitteeDir).click(); // Select Directory of Committees
	// DirectorateDDL5 = new Select(driver.findElement(CommitteeDir));
	//	DirectorateDDL5.selectByVisibleText(MainCenter);  // Directory Option
		
		
	    //driver.findElement(CommiteeARname).sendKeys(ArCommitteeNameContent);  // Fill Arabic Committee Name 
		//driver.findElement(Searchbtn).click(); // Press on Search button
		Thread.sleep(Const *3);

		driver.findElement(detailsLink).click(); // Press on Details Link
		Thread.sleep(Const *3);

		driver.findElement(updatebtn).click(); // Press Update Button

		Thread.sleep(Const *3);
        
        // Update
		driver.findElement(updtArcommittee).clear(); // Clear the content Of arabic Commitee Name
		Thread.sleep(Const *3);
		driver.findElement(updtArcommittee).sendKeys(ArCommitteeNameContentUpdate); // Fill in the Field of arabic Committee Name 
		Thread.sleep(Const *3);
	
		driver.findElement(updtENcommittee).clear(); // clear English Committee Name
		Thread.sleep(Const *5);

		driver.findElement(updtENcommittee).clear(); // WORK ARROUND ISSUE WITH clearing the field content 
		Thread.sleep(Const *5);

		driver.findElement(updtENcommittee).sendKeys(EnCommitteeNameContentUpdate); // Fill in the field with new value 
		Thread.sleep(Const *5);
		
		driver.findElement(directorateDDL).click();   //  Directory DDL 
		Select DirectorateDDL1 = new Select(driver.findElement(directorateDDL));
		DirectorateDDL1.selectByVisibleText(Balqaa);  // Directory Options 
		Thread.sleep(Const *3);
		
		driver.findElement(defaultCheckbox).click(); // Check or incheck Default checkbox 
		Thread.sleep(Const *3);

		//driver.findElement(DirectorateMember1).click(); // Select Committee Member
		//driver.findElement(move).click();
		//Thread.sleep(Const *3);

	//	driver.findElement(DirectorateMember2).click();  // Select Committee Member
	//	driver.findElement(move).click();
		
	//	Thread.sleep(Const *3);

		driver.findElement(savebtn).click(); // Click on Save Button 
		Thread.sleep(Const * 7);  // Expected Message verification 
    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
    	System.out.println("Actual Message: " + ActualResult);
	  	System.out.println("Expected Message: " + ExpectedResult + "Passed CommitteesManagement");
			
	} 
	


//////////////////////////////////// Employees Management////////////////////////////////////
	@Test(priority= 23) 
	public void employeesaManagement() throws InterruptedException{
	
		driver.findElement(RegistrationList).click();  // Registration Menu
		driver.findElement(usersList).click(); // Users Menu
		driver.findElement(usersManagement).click(); // Users Management list 
		driver.findElement(employeesList).click(); // Employees Option
		
		driver.findElement(empDirectorate).click();
		Select DirectorateDDL6 = new Select(driver.findElement(empDirectorate));
		DirectorateDDL6.selectByVisibleText(Balqaa); 
		Thread.sleep(Const *3);
		
		
	//	driver.findElement(EmpPhoneNum).sendKeys(EmpPhoneNumContent); 
	//	driver.findElement(EmpEmail).sendKeys(EmpEmailContent);
	//	driver.findElement(EmpUsername).sendKeys(EmpUsernameContent);
	//	Thread.sleep(Const *3);
	
	
		driver.findElement(Searchbtn).click();
		Thread.sleep(Const *3);

		driver.findElement(DetailsLink).click();
		Thread.sleep(Const *3);
	 
	 
		driver.findElement(empUpdtbtn).click();
	    Thread.sleep(Const *3);

		driver.findElement(updateDir).click();
		Select DirectorateDDL5 = new Select(driver.findElement(updateDir));
		DirectorateDDL5.selectByVisibleText(PrimeMinister); 
		
		Thread.sleep(Const *3);

	//	driver.findElement(ARfirstNameUpdt).clear();
	//	driver.findElement(ARfirstNameUpdt).sendKeys(arFirstNameContent); 
	//	Thread.sleep(Const *3);
	
		
	//	driver.findElement(ARsecondNameupdt).clear();
	//	driver.findElement(ARsecondNameupdt).sendKeys(arSecondNameContent); 
		Thread.sleep(Const *3);
		
	//	driver.findElement(ARthirdNameupdt).clear();
	//	driver.findElement(ARthirdNameupdt).sendKeys(arThirdNameContent); 
	//	Thread.sleep(Const *3);
		
	//	driver.findElement(ARfourthNameupdt).clear();
	//	driver.findElement(ARfourthNameupdt).sendKeys(arFourthNameContent); 
	//	Thread.sleep(Const *3);
		
	//	driver.findElement(EnfirstNameupdt).clear();
	//	driver.findElement(EnfirstNameupdt).sendKeys(enFirstNameContent); 
	//	Thread.sleep(Const *2);
		
	//	driver.findElement(EnsecondNameupdt).clear();
	//	driver.findElement(EnsecondNameupdt).sendKeys(enSecondNameContent); 
		Thread.sleep(Const *2);
		
	//	driver.findElement(EnthirdNameupdt).clear();
	//	driver.findElement(EnthirdNameupdt).sendKeys(enThirdNameContent); 
	//	Thread.sleep(Const *2);
		
	//	driver.findElement(EnfourthNameupdt).clear();
	//	driver.findElement(EnfourthNameupdt).sendKeys(enFourthNameContent); 
	//	Thread.sleep(Const *2);
		
		
		driver.findElement(phoneNumupdt).clear();
		driver.findElement(phoneNumupdt).sendKeys(updtPhonenum); 
		Thread.sleep(Const *2);
		
		driver.findElement(countryCodeupdt).click();
		Select countrycodeDDL1 = new Select(driver.findElement(countryCodeupdt));
		countrycodeDDL1.selectByVisibleText(CodeNo2); 
		
		
		driver.findElement(updateEmail).clear();
		driver.findElement(updateEmail).sendKeys(updtEmail); 
		Thread.sleep(Const *2);
		
		
		driver.findElement(updtAccessPolicy).click();
		Select updtAccessPolicyDDL = new Select(driver.findElement(updtAccessPolicy));
		updtAccessPolicyDDL.selectByVisibleText(DefaultPolicy); 
		Thread.sleep(Const *2);

		driver.findElement(updtTimePolicy).click();
		Select updtTimePolicyDDL = new Select(driver.findElement(updtTimePolicy));
		updtTimePolicyDDL.selectByVisibleText(DefaultEscalationSteps); 
		Thread.sleep(Const *2);
		
		driver.findElement(updtUserStatus).click();
		Select updtUserStatusDDL = new Select(driver.findElement(updtUserStatus));
		updtUserStatusDDL.selectByVisibleText(activeStatus); 
		Thread.sleep(Const *2);

		driver.findElement(updtDefaultLanguage).click();
		Select updtDefaultLanguageDDL = new Select(driver.findElement(updtDefaultLanguage));
		updtDefaultLanguageDDL.selectByVisibleText(English); 
		Thread.sleep(Const *2);
		

		driver.findElement(updateRequiredEmail).click();
		driver.findElement(updarteRequiredSMS).click();
		Thread.sleep(Const *2);

		driver.findElement(updateRole).click();
		
		driver.findElement(movebtn).click();
		driver.findElement(saveBtnafterUpdate).click();
		
		

		Thread.sleep(Const * 7);

	    	String ActualResult = driver.findElement(successMessage).getText();
	        System.out.println(ActualResult);
	    	String ExpectedResult = updateSucceed;
	    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
	    	System.out.println("Actual Message: " + ActualResult);
	    	System.out.println("Expected Message: " + ExpectedResult + "Passed employeesaManagement");
			
	}

	// STK Management happy Scenario 
	@Test(priority= 24)
	public void STKManagement() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); //Registration Menu
		driver.findElement(usersList).click();  // User Menu
		driver.findElement(usersManagement).click(); // User Management Menu
		driver.findElement(STKList).click(); // STK Option
		Thread.sleep(Const *2);
		driver.findElement(emailField).click();  // Move out of menus
		driver.findElement(emailField).sendKeys(EmpEmailContent); // Fill in email Search Field
		Thread.sleep(Const *2);
	//	driver.findElement(userNameField).sendKeys(userNameContent); // Fill in username Search Filed
	//	driver.findElement(PhoneNumField).sendKeys(EmpPhoneNumContent); // Fill in Phone number Field
	//	Thread.sleep(Const *2);
	//	driver.findElement(searchButton).click(); // Press on search 
	//	Thread.sleep(Const *3);
	//	driver.findElement(ResetRolesField).click(); // Reset fields when no result is found 
	//	Thread.sleep(Const *2);

		driver.findElement(DetailsLink).click();   // Press on Details link
		Thread.sleep(Const *5);

		driver.findElement(updtbutton).click(); // Press on Update button
		Thread.sleep(Const *3);

		 driver.findElement(ARfirstNameUpdt).clear(); // Clear the content of a field to update it
	    driver.findElement(ARfirstNameUpdt).sendKeys(arFirstNameContent); // Fill in Arabic First name 
	
			
	    driver.findElement(ARsecondNameupdt).clear(); //  Clear the content of a field to update it
	    driver.findElement(ARsecondNameupdt).sendKeys(arSecondNameContent); // Fill in Arabic second name
	    
	    driver.findElement(ARthirdNameupdt).clear(); //Clear the content of a to update it 
	    driver.findElement(ARthirdNameupdt).sendKeys(arThirdNameContent); // Fill in Arabic third name
	    
	    driver.findElement(ARfourthNameupdt).clear(); //Clear the content of a to update it 
	    driver.findElement(ARfourthNameupdt).sendKeys(arFourthNameContent); // Fill in Arabic fourth name
	    
	    Thread.sleep(Const *3);
	    
	    driver.findElement(EnfirstNameupdt).clear();  //Clear the content of a to update it 
	    driver.findElement(EnfirstNameupdt).sendKeys(enFirstNameContent);  // Fill in English First name
	    
	    driver.findElement(EnsecondNameupdt).clear(); //Clear the content of a to update it 
	    driver.findElement(EnsecondNameupdt).sendKeys(enSecondNameContent); // Fill in English Second name
	    
	    
	    driver.findElement(EnthirdNameupdt).clear(); //Clear the content of a to update it 
	    driver.findElement(EnthirdNameupdt).sendKeys(enThirdNameContent); // Fill in English third name
	    
	    
	    driver.findElement(EnfourthNameupdt).clear(); //Clear the content of a to update it 
	    driver.findElement(EnfourthNameupdt).sendKeys(enFourthNameContent); // Fill in English fourth name
	    
	    Thread.sleep(Const *3);
	    
	    driver.findElement(phoneNumupdt).clear(); //Clear the content of a to update it 
	    driver.findElement(phoneNumupdt).sendKeys(updtPhonenum); // Fill in phone number 
	    
	    Thread.sleep(Const *3);
	
		driver.findElement(countryCodeupdt).click(); 
		Select countrycodeDDLupdt = new Select(driver.findElement(countryCodeupdt)); // Country code DDL
		countrycodeDDLupdt.selectByVisibleText(CodeNo3);  // Select country code option 
		
		Thread.sleep(Const *3);
			
		driver.findElement(updateEmail).clear(); // Clear the content of email Field
	    driver.findElement(updateEmail).sendKeys(updtEmail);	// Fill in email Field 
	    
	    driver.findElement(updtUserStatus).click(); // Click update button
	    
		Select  UserStatusDDL= new Select(driver.findElement(updtUserStatus)); // User status DDL
		UserStatusDDL.selectByVisibleText(activeStatus); 
		UserStatusDDL.selectByVisibleText(DisabledStatus); // Select option Disabled 
		
		Select  languageDDL= new Select(driver.findElement(updtDefaultLanguage)); // Default language DDL
		languageDDL.selectByVisibleText(Arabic); // Default language option 
		
	    driver.findElement(updateRequiredEmail).click(); // checkbox Required email
	    
	    driver.findElement(updarteRequiredSMS).click(); // checkbox Required SMS 
	    
		Thread.sleep(Const *3);
		
		
driver.findElement(updateRole).click();
		
		driver.findElement(movebtn).click();
		
	
	    driver.findElement(saveButton).click();  // Press on Save 
	 //   driver.findElement(backBtn).click(); 
	  
	    // Verify expected Message 
		Thread.sleep(Const * 7);
	
	    String ActualResult = driver.findElement(successMessage).getText();
    	System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult+ "Passed STKManagement");
	
	}
	
	
	// NCC Management
	@Test(priority= 25)
	public void nccManagement() throws InterruptedException{
	
		driver.findElement(RegistrationList).click(); // Registration Menu
		driver.findElement(usersList).click(); // User menu
		driver.findElement(usersManagement).click(); // User Management
		driver.findElement(NCCList).click(); // NCC option
		Thread.sleep(Const *2);
		
		driver.findElement(NCCusername).click(); // Move out of menu
		driver.findElement(NCCusername).sendKeys(NCCusernameContent);// Fill in User name
		
		driver.findElement(searchButton).click(); // Click on search button
		Thread.sleep(Const *3);

		driver.findElement(DetailsLink).click(); // Press link Details
		Thread.sleep(Const *3);

		driver.findElement(updtbutton).click(); // Press Update Button
		Thread.sleep(Const *3);

		driver.findElement(NCCUpdatedPhone).clear(); // clear Field to update its Content 
		driver.findElement(NCCUpdatedPhone).sendKeys(updtPhonenum); // Fill in phone number 
		
		Thread.sleep(Const *3);
	
		
		Select  NCCUserStatusDDL= new Select(driver.findElement(updtUserStatus)); // User status DDL
		NCCUserStatusDDL.selectByVisibleText(activeStatus); // User status option 
		NCCUserStatusDDL.selectByVisibleText(DisabledStatus);  // User status option 
		Thread.sleep(Const *3);

		driver.findElement(saveButton).click(); // Press on Save button
		
		// Verify Expected Message
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText(); 
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
	
    	System.out.println("Actual Message: " + ActualResult);
    	System.out.println("Expected Message: " + ExpectedResult+ "Passed nccManagement");
	} 
	

	@Test(priority= 26)
	public void Roles() throws InterruptedException{
	
		driver.findElement(RegistrationList).click();
		driver.findElement(usersList).click();
		driver.findElement(RolesList).click();
		driver.findElement(defineRole).click();
		driver.findElement(ArabicRoleName).click();
		driver.findElement(ArabicRoleName).sendKeys(ArabicRoleNameContent);
		Thread.sleep(Const * 3);
		driver.findElement(EnglishRoleName).click();
		driver.findElement(EnglishRoleName).sendKeys(EnglishRoleNameContent);

		Thread.sleep(Const * 3);

		
		Select  RoleUserTypeDDL= new Select(driver.findElement(RoleUserType));
		RoleUserTypeDDL.selectByVisibleText(MOHuser); 
		Thread.sleep(Const * 3);

		driver.findElement(activeRadioButton).click();
		driver.findElement(pagesItem).click();
		Thread.sleep(Const * 3);
		driver.findElement(MoveItem).click();
		Thread.sleep(Const * 3);

		
	    //driver.findElement(selectedPages).click();
		//driver.findElement(remove).click();

		driver.findElement(TasksItem).click();
		Thread.sleep(Const * 3);
		
		driver.findElement(moveTask).click();
		Thread.sleep(Const * 3);

		driver.findElement(CreateRoleBtn).click();
		Thread.sleep(Const * 3);
		

		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
    	System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + "passed Roles");
		
	}

	@Test(priority= 27)
	public void RolesManagement() throws InterruptedException{
	
		driver.findElement(RegistrationList).click();
		driver.findElement(usersList).click();
		driver.findElement(RolesList).click();
		driver.findElement(rolesManagement).click();
		Thread.sleep(Const * 3);
		driver.findElement(SearchRole).click();
		Thread.sleep(Const * 3);

		driver.findElement(ProcedureArabicName).click();
		Thread.sleep(Const * 3);

		driver.findElement(DetailsLink).click();
		Thread.sleep(Const * 3);

		driver.findElement(uptBtnRole).click();
		Thread.sleep(Const * 3);

		driver.findElement(RolepagesItem).click();
		driver.findElement(RolepagesItem).click();
		Thread.sleep(Const * 3);
        
		driver.findElement(MoveRole).click();
		
		Thread.sleep(Const * 3);
		driver.findElement(Procedure).click();
		Thread.sleep(Const * 3);

		driver.findElement(SelectProcedure).click();
		
		Thread.sleep(Const * 3);
		
		
		driver.findElement(saveButton).click();
		Thread.sleep(Const * 3);
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
    	System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + "passed RolesManagement");	
	}


	@Test(priority= 28)
	public void definePrivilege() throws InterruptedException{
	
		driver.findElement(RegistrationList).click();
		driver.findElement(usersList).click();
		driver.findElement(privilegesList).click();
		driver.findElement(definePrivilege).click();
		Thread.sleep(Const * 3);
		Select  PrivilegeTypeDDL= new Select(driver.findElement(privilegeType));
		PrivilegeTypeDDL.selectByVisibleText(Page); 
		Thread.sleep(Const * 3);
		
		Select  pageDescriptionDDL= new Select(driver.findElement(pageDescription));
		pageDescriptionDDL.selectByVisibleText(description3); 
		Thread.sleep(Const * 3);
		driver.findElement(savePrivilege).click();
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
    	System.out.println("Actual Message: " + ActualResult);
    	System.out.println("Expected Message: " + ExpectedResult + "passed definePrivilege");
		
	}
	
/*	
	@Test(priority= 29)
	public void PrivilegeManagement() throws InterruptedException, IOException{
	
		driver.findElement(RegistrationList).click();
		driver.findElement(usersList).click();
		driver.findElement(privilegesList).click();
		driver.findElement(privilegeManagement).click();
		Thread.sleep(Const * 3);
		
	
		Select  PrivilegeTypeDDL= new Select(driver.findElement(privilegeType));
		PrivilegeTypeDDL.selectByVisibleText(Page); 
		Thread.sleep(Const * 3);
		
		
		driver.findElement(DetailsLink).click();
		Thread.sleep(Const * 3);

		Thread.sleep(Const * 7);
		
		TakesScreenshot ts1=(TakesScreenshot)driver;
		File source4=ts1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source4, new File("Screenshots/Privileges.png"));
		Thread.sleep(Const * 2);
		
	
    	System.out.println("passed PrivilegeManagement");

    	

	}
	*/

	
	//////////////////////////////DefinePrivacyPolicy///////////
	
	@Test(priority= 30)
	 public void DefinePrivacyPolicy() throws InterruptedException{
	
		driver.findElement(RegistrationList).click();
		driver.findElement(usersList).click();
		driver.findElement(accessPoliciesList).click();
		driver.findElement(defineAccessPolicy).click();
		Thread.sleep(Const * 3);
 
		driver.findElement(outofMenu).click(); 
		Thread.sleep(Const * 3); 
		
		driver.findElement(policyType).click(); 
		Select  policyDDL= new Select(driver.findElement(policyType));
		policyDDL.selectByVisibleText(accessPolicy); 
		Thread.sleep(Const * 3);
		
		driver.findElement(userTypeDDl).click(); 
		Select  userTypeDDL= new Select(driver.findElement(userTypeDDl));
		userTypeDDL.selectByVisibleText(MOHuser); 
		Thread.sleep(Const * 3);
		
		driver.findElement(arPolicyName).sendKeys(PolicyArName);
		Thread.sleep(Const * 3);

		driver.findElement(enPolicyName).sendKeys(PolicyEnName);
		Thread.sleep(Const * 3);

		driver.findElement(activePolicy).click(); 
		Thread.sleep(Const * 3);

		driver.findElement(MinimumtrialTime).sendKeys("6"); 
		Thread.sleep(Const * 3);
		
		driver.findElement(MaximumTrials).sendKeys("5"); 
		Thread.sleep(Const * 3);
		

		driver.findElement(ValidationCodeSimulation).sendKeys("0000"); 
		Thread.sleep(Const * 3);
		
		driver.findElement(ValidationCodeExpiry).sendKeys("10"); 
		Thread.sleep(Const * 3);
		
		driver.findElement(ValidationCodeLength).sendKeys("4"); 
		Thread.sleep(Const * 3);
		
		driver.findElement(CodesendingTimes).sendKeys("2"); 
		Thread.sleep(Const * 3);
		
		driver.findElement(minimumPasswordlength).sendKeys("3"); 
		Thread.sleep(Const * 3);
		
		driver.findElement(maximumPasswordLength).sendKeys("6"); 
		Thread.sleep(Const * 3);
		
		driver.findElement(CapitalLetters).click();
		Thread.sleep(Const * 3);

		driver.findElement(SearchButton).click();
		
		Thread.sleep(Const * 7);

		String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
    	System.out.println("Actual Message: " + ActualResult);
    	System.out.println("Expected Message: " + ExpectedResult + "passed DefinePrivacyPolicy");

		
	}	
	
	
	@Test(priority= 31)   //////////////////////////// Has validation message with reference Number///////////////////////////////////////////////////////////
	public void AddServiceFees() throws InterruptedException{
	
		driver.findElement(SystemManagementList).click();
		driver.findElement(services).click();
		driver.findElement(serviceFees).click();
		driver.findElement(addFeestoaService).click();
		
		driver.findElement(outofMenu).click(); 
		Thread.sleep(Const * 3); 

		
		Select  FeesTypeDDL= new Select(driver.findElement(FeesType));
		FeesTypeDDL.selectByVisibleText(LicenseFees); 
		Thread.sleep(Const * 3);
		
		Select  pageDescriptionDDL= new Select(driver.findElement(ServiceDDL));
		pageDescriptionDDL.selectByVisibleText(RNVL); 
		Thread.sleep(Const * 3);
		
		driver.findElement(accountNumber).sendKeys(accountNumberContent);
		Thread.sleep(Const * 3);

		driver.findElement(internationlAccountNumber).sendKeys(internationlAccountNumberContent);
		Thread.sleep(Const * 3);

		driver.findElement(value).sendKeys(valueContent);
		Thread.sleep(Const * 3);
	
		driver.findElement(RequiredMessagesCheckbox).click(); // checkbox Active
		Thread.sleep(Const * 5);

		driver.findElement(DateFrom).sendKeys(StartingDate);
		driver.findElement(DateTo).sendKeys(EndingDate);
		
		driver.findElement(SearchButton).click(); // Save button 
		
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
	
	System.out.println("Actual Message: " + ActualResult);
	System.out.println("Expected Message: " + ExpectedResult +" PASSED AddServiceFees");
	

	} 
	
	@Test(priority= 32)
	public void FeesManagement() throws InterruptedException{
	
		driver.findElement(SystemManagementList).click();
		driver.findElement(services).click();
		driver.findElement(serviceFees).click();
		driver.findElement(manageServiceFeees).click();
		Thread.sleep(Const * 3);
		
		Select  FeeTypeDDL= new Select(driver.findElement(FeeType));
		FeeTypeDDL.selectByVisibleText(LicenseFees); 
		Thread.sleep(Const * 3);
		
		driver.findElement(Searchbtn).click();

		Thread.sleep(Const * 3);
		driver.findElement(FeeDetails).click();
		Thread.sleep(Const * 3);

		driver.findElement(updatebtn).click();
		Thread.sleep(Const * 3);

		driver.findElement(updatedValue).clear();
		driver.findElement(updatedValue).sendKeys(valueContent);

		Thread.sleep(Const * 3);
		
		driver.findElement(updateEndingDate).clear();
		driver.findElement(updateEndingDate).sendKeys(EndingDate);

		driver.findElement(SaveFeesUpdate).click();
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
	
	System.out.println("Actual Message: " + ActualResult);
	System.out.println("Expected Message: " + ExpectedResult + " PASSED FeesManagement");
			
	}
	
	@Test(priority= 33)
	public void AddServiceAttachments() throws InterruptedException{
	
		driver.findElement(SystemManagementList).click();
		driver.findElement(services).click();
		driver.findElement(ServiceAttachments).click();
		driver.findElement(AddServiceAttachment).click();
		Thread.sleep(Const * 3);

		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);

		Select  attachmentTypeDDL= new Select(driver.findElement(attachmentType));
		attachmentTypeDDL.selectByVisibleText(Passportcopy); 
		Thread.sleep(Const * 3);
		
		Select  applicantTypeDDL= new Select(driver.findElement(applicantType));
		applicantTypeDDL.selectByVisibleText(individualPharamcist); 
		Thread.sleep(Const * 3);
		
		Select  serviceTypeDDL= new Select(driver.findElement(serviceType));
		serviceTypeDDL.selectByVisibleText(RNVL); 
		Thread.sleep(Const * 3);
		driver.findElement(activeAttachment).click();
		driver.findElement(requiredAttachemnt).click();
		Thread.sleep(Const * 3);

		driver.findElement(Search).click();
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
	
	System.out.println("Actual Message: " + ActualResult);
	System.out.println("Expected Message: " + ExpectedResult + " PASSED AddServiceAttachments");
			
	
	}


	@Test(priority= 34)
	public void ServiceAttachmentsManagement() throws InterruptedException{
	
		driver.findElement(SystemManagementList).click();
		driver.findElement(services).click();
		driver.findElement(ServiceAttachments).click();
		driver.findElement(serviceAttachmentManagement).click();
		Thread.sleep(Const * 3);

		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);

		driver.findElement(AttachmentDetails).click();
		Thread.sleep(Const * 3);
		driver.findElement(serviceUpdt).click();
		
		Thread.sleep(Const * 3);
		Select  updtAttachmentTypeDDL= new Select(driver.findElement(updtAttachmentType));
		updtAttachmentTypeDDL.selectByVisibleText(PersonalPhoto); 
		Thread.sleep(Const * 3);
		
		Select  updtApplicantTypeDDL= new Select(driver.findElement(updtApplicantType));
		updtApplicantTypeDDL.selectByVisibleText(Jordanian); 
		Thread.sleep(Const * 3);
		
		Select  updtServiceTypeDDL= new Select(driver.findElement(updtServiceType));
		updtServiceTypeDDL.selectByVisibleText(RNVL); 
		Thread.sleep(Const * 3);
		
		driver.findElement(checkboxActive).click();
		driver.findElement(Required).click();
		Thread.sleep(Const * 3);

		driver.findElement(saveUpdates).click();

		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
	
	System.out.println("Actual Message: " + ActualResult);
	System.out.println("Expected Message: " + ExpectedResult +"PASSED ServiceAttachmentsManagement");
	
	}
	
	
	@Test(priority= 35)
	public void NotificationsManagement() throws InterruptedException{
	
		driver.findElement(SystemManagementList).click();
		driver.findElement(Notifications).click();
		Thread.sleep(Const * 3);
		
		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);

		driver.findElement(NotificationDetails).click();
		driver.findElement(NotificationDetails).click();
		Thread.sleep(Const * 3);

		driver.findElement(Back).click();
		System.out.println("PASSED ServiceAttachmentsManagement");
		
	
	}
	

	@Test(priority= 36)
	public void SystemSettings() throws InterruptedException{
	
		driver.findElement(SystemManagementList).click();
		driver.findElement(systemSettings).click();
		Thread.sleep(Const * 3);
		
		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		
		//driver.findElement(SettingName).click();

		Select  updtServiceTypeDDL= new Select(driver.findElement(SettingName));
		updtServiceTypeDDL.selectByVisibleText(SettingArName); 
		Thread.sleep(Const * 3);
		
		driver.findElement(Searchbtn).click();
		Thread.sleep(Const * 3);

		driver.findElement(DetailsLink).click();
		Thread.sleep(Const * 3);

		driver.findElement(updatebtn).click();
		
		Thread.sleep(Const * 3);
		driver.findElement(SettingARDescription).clear();
		driver.findElement(SettingARDescription).sendKeys(SettingARDescriptionContent);
		Thread.sleep(Const * 3);
		
		driver.findElement(SettingENDescription).clear();
		driver.findElement(SettingENDescription).sendKeys(SettingENDescriptionContent);
		Thread.sleep(Const * 3);

		driver.findElement(SettingsValue).clear();
		driver.findElement(SettingsValue).sendKeys(SettingsValueContent);
		Thread.sleep(Const * 3);

		driver.findElement(saveUpdates).click();
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
      
	
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult +" PASSED SystemSettings");
	} 
	
	@Test(priority= 37)
	public void ExecuteServicesManagements() throws InterruptedException{
	
		driver.findElement(SystemManagementList).click();
		driver.findElement(ExecuteServices).click();
		driver.findElement(ExecuteServicesManagement).click();

		Thread.sleep(Const * 3);
		
		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		
		
		driver.findElement(ExecutionDetails).click();
		Thread.sleep(Const * 3);
		driver.findElement(updatebtn).click();
		Thread.sleep(Const * 3);

		driver.findElement(saveUpdates).click();
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + " PASSED ExecuteServicesManagements");
		
	}
	
	@Test(priority= 38)
	public void RejectionandIncompleteReasons() throws InterruptedException{
	
		driver.findElement(SystemManagementList).click();
		driver.findElement(ExecuteServices).click();
		driver.findElement(ReasonofRejectionandIncompleteRequests).click();
		driver.findElement(addReasonsofRejectionandIncompleteRequests).click();


		Thread.sleep(Const * 3);
		
		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		
		Select serviceNameDDL= new Select(driver.findElement(serviceName));
		serviceNameDDL.selectByVisibleText(GPL); 
		Thread.sleep(Const * 3);
		
		Select stepDDL= new Select(driver.findElement(step));
		stepDDL.selectByVisibleText(NewWaitingforAuditorDecisionGPL); 
		Thread.sleep(Const * 3);
		
		Select ReasonDDL= new Select(driver.findElement(Reason));
		ReasonDDL.selectByVisibleText(NationalityReason); 
		Thread.sleep(Const * 3);
		
		driver.findElement(activeAttachment).click();
		driver.findElement(Search).click(); // save 
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + " PASSED RejectionandIncompleteReasons");

		
	}
		
	@Test(priority= 39)              //////////////////////////////////////////////Incomplete
	public void RejectionandIncompleteReasonsManagement() throws InterruptedException{
	
		driver.findElement(SystemManagementList).click();
		driver.findElement(ExecuteServices).click();
		driver.findElement(ReasonofRejectionandIncompleteRequests).click();
		driver.findElement(addReasonsofRejectionandIncompleteRequests).click();


		Thread.sleep(Const * 3);
		
		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		
	}
	
	
	@Test(priority= 40)           // has issue with content language    
	public void serviceCard() throws InterruptedException{
	
		driver.findElement(ContentManagementList).click();
		driver.findElement(serviceCardList).click();
		Thread.sleep(Const * 3);

		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		Select serviceDDL= new Select(driver.findElement(service));
		serviceDDL.selectByVisibleText(RNVL); 
		Thread.sleep(Const * 3);
		driver.findElement(DetailsLink).click();
		Thread.sleep(Const * 3);
		driver.findElement(saveUpdates).click();// Update Button
		Thread.sleep(Const * 3);

		
		driver.findElement(OrdrOfCard).clear();
		driver.findElement(OrdrOfCard).sendKeys(Order);
		Thread.sleep(Const * 3);

		driver.findElement(CardARtitle).clear();
		driver.findElement(CardARtitle).sendKeys(CardARtitleContent);
		Thread.sleep(Const * 3);
		
	//	driver.findElement(ARDescriptionTextArea).click();
	//	driver.findElement(ARDescriptionTextArea).click();
		Thread.sleep(Const * 3);
		
		Actions action7 = new Actions(driver);
		action7.moveToElement(driver.findElement(ARDescriptionTextArea)).click();
		action7.click();
		action7.sendKeys(AddARDescriptionTextAreaContent);
		action7.build().perform();
		Thread.sleep(Const * 3);

		driver.findElement(savebtn).click();
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + " PASSED  serviceCard");	
	}
	
	
	
	@Test(priority= 41)           // has issue with content language    
	public void serviceCardOrder() throws InterruptedException{
	
		driver.findElement(ContentManagementList).click();
		driver.findElement(serviceCardList).click();
		Thread.sleep(Const * 3);

		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		Select serviceDDL= new Select(driver.findElement(service));
		serviceDDL.selectByVisibleText(RNVL); 
		Thread.sleep(Const * 3);
		driver.findElement(DetailsLink).click();
		Thread.sleep(Const * 3);
		driver.findElement(saveUpdates).click();// Update Button
		Thread.sleep(Const * 3);

		
		driver.findElement(OrdrOfCard).clear();
		driver.findElement(OrdrOfCard).sendKeys(OutOfOrder);
		Thread.sleep(Const * 3);

		driver.findElement(CardARtitle).clear();
		driver.findElement(CardARtitle).sendKeys(CardARtitleContent);
		Thread.sleep(Const * 3);
		
	//	driver.findElement(ARDescriptionTextArea).click();
	//	driver.findElement(ARDescriptionTextArea).click();
		Thread.sleep(Const * 3);
		
		Actions action7 = new Actions(driver);
		action7.moveToElement(driver.findElement(ARDescriptionTextArea)).click();
		action7.click();
		action7.sendKeys(AddARDescriptionTextAreaContent);
		action7.build().perform();
		Thread.sleep(Const * 3);

		driver.findElement(savebtn).click();
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = outofOrderMessage;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + " PASSED serviceCardOrder");	
	}
	
	
	@Test(priority= 42)        
	public void AddFAQ() throws InterruptedException{
	
		driver.findElement(ContentManagementList).click();
		driver.findElement(FAQsList).click();
		driver.findElement(addNewFAQ).click();

		Thread.sleep(Const * 3);

		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		
		driver.findElement(QuestionOrder).sendKeys(Order);
		
		
		
		Select QuestionUserTypeDDL= new Select(driver.findElement(QuestionUserType));
		QuestionUserTypeDDL.selectByVisibleText(internalUser); 
		Thread.sleep(Const * 3);
		
		Actions action8 = new Actions(driver);
		action8.moveToElement(driver.findElement(ArQuestion)).click();
		action8.click();
		action8.sendKeys(ArQuestionContent);
		action8.build().perform();
		Thread.sleep(Const * 3);
		
		Actions action9 = new Actions(driver);
		action9.moveToElement(driver.findElement(ARAnswer)).click();
		action9.click();
		action9.sendKeys(ARAnswerContent);
		action9.build().perform();
		Thread.sleep(Const * 3);
		
		Actions action10 = new Actions(driver);
		action10.moveToElement(driver.findElement(ENQuestion)).click();
		action10.click();
		action10.sendKeys(ENQuestionContent);
		action10.build().perform();
		Thread.sleep(Const * 3);
		
		Actions action11 = new Actions(driver);
		action11.moveToElement(driver.findElement(EnAnswer)).click();
		action11.click();
		action11.sendKeys(EnAnswerContent);
		action11.build().perform();
		Thread.sleep(Const * 3);
		
		driver.findElement(saveFAQ).click();

		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = MessageSuccessfullyAdded;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult + " PASSED AddFAQ");	
		
	}
	
	
	@Test(priority= 43)      // Error ( No validation message )
	public void FAQManagement() throws InterruptedException{
	
		driver.findElement(ContentManagementList).click();
		driver.findElement(FAQsList).click();
		driver.findElement(FAQManagement).click();

		Thread.sleep(Const * 3);

		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		
		
		driver.findElement(DetailsLink).click();
		Thread.sleep(Const * 3);
		
		driver.findElement(updatebtn).click(); 
		Thread.sleep(Const * 3);
				
		driver.findElement(OrdrOfCard).clear();  // Question order

		driver.findElement(OrdrOfCard).sendKeys(Order); // Question order

		driver.findElement(savebtn).click();
		
			
		
	}
	
	
	@Test(priority= 44)      // has issues with update
	public void Ratings () throws InterruptedException{
	
		driver.findElement(ContentManagementList).click();
		driver.findElement(Evaluations).click();
	

		Thread.sleep(Const * 3);

		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		driver.findElement(ServiceDDL).click();
		Select serviceDDL= new Select(driver.findElement(ServiceDDL));
		serviceDDL.selectByVisibleText(RNVL); 
		Thread.sleep(Const * 3);
		driver.findElement(outofMenu).click();
		
		driver.findElement(ServiceDDL).click();
		Select serviceDDL1= new Select(driver.findElement(ServiceDDL));
		serviceDDL1.selectByVisibleText(GPL); 
		Thread.sleep(Const * 3);

		
	}

	
	@Test(priority= 45)     
	public void SystemMessages () throws InterruptedException{
	
		driver.findElement(ContentManagementList).click();
		driver.findElement(SystemMessages).click();
	

		Thread.sleep(Const * 3);

		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 5);
		
		driver.findElement(msgCode).click();
		driver.findElement(msgCode).click();
		Thread.sleep(Const * 3);

	driver.findElement(msgCode).sendKeys(Keys.TAB);

	Thread.sleep(Const * 3);

	driver.findElement(DetailsLink).click();
	Thread.sleep(Const * 3);
	driver.findElement(updatebtn).click();
	
	Thread.sleep(Const * 3);

	driver.findElement(TextArea).clear();
	driver.findElement(TextArea).sendKeys(Content);
	
	Thread.sleep(Const * 3);

	driver.findElement(saveUpdates).click();	
	Thread.sleep(Const * 7);

	String ActualResult = driver.findElement(successMessage).getText();
    System.out.println(ActualResult);
	String ExpectedResult = updateSucceed;
	Assert.assertTrue(ActualResult.contains(ExpectedResult));
	System.out.println("Actual Message: " + ActualResult);
	System.out.println("Expected Message: " + ExpectedResult);	
	}
	
	@Test(priority= 46)      
	public void ServicesValidationMenues () throws InterruptedException{
	
		driver.findElement(ContentManagementList).click();
		driver.findElement(ValidationServicesMenues).click();
	

		Thread.sleep(Const * 3);

		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		
		driver.findElement(item).click();
		driver.findElement(item).click();
		
		driver.findElement(item).sendKeys(Keys.TAB);
		Thread.sleep(Const * 3);
		driver.findElement(ListDetails).click();
		driver.findElement(updtbutton).click();
		Thread.sleep(Const * 3);
		driver.findElement(recordNumOfService).clear();
		driver.findElement(recordNumOfService).sendKeys(noOfRecord);
		driver.findElement(updatebtn).click();

		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult);	

	}
	
	@Test(priority= 47)      
	public void GeneralizationManagement () throws InterruptedException{
	
		driver.findElement(ContentManagementList).click();
		driver.findElement(Generalizations).click();
		driver.findElement(GeneralizationsManagements).click();

		Thread.sleep(Const * 6);

		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		
		driver.findElement(DetailsLink).click(); // Generalization Details
		Thread.sleep(Const * 3);

		driver.findElement(updatebtn).click();
		Thread.sleep(Const * 3);
		driver.findElement(generalizationARTitle).clear();
		Thread.sleep(Const * 3);

		driver.findElement(generalizationARTitle).sendKeys(generalizationARTitleContent);
		Thread.sleep(Const * 3);
		driver.findElement(generalizationARDesc).clear();
		Thread.sleep(Const * 3);
		driver.findElement(generalizationARDesc).sendKeys(generalizationARDescContent);
		Thread.sleep(Const * 3);
		driver.findElement(generalizationENTitle).clear();
		Thread.sleep(Const * 3);

		driver.findElement(generalizationENTitle).sendKeys(generalizationENTitleContent);
		Thread.sleep(Const * 3);
		
		driver.findElement(generalizationENDesc).clear();
		
		Thread.sleep(Const * 3);
		driver.findElement(generalizationENDesc).sendKeys(generalizationENDescContent);
		Thread.sleep(Const * 3);
		driver.findElement(SaveFeesUpdate).click(); // save Updates 
		
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult);	


	}

	
	@Test(priority= 48)    
	public void GenerlaizationAddition () throws InterruptedException{
	
		driver.findElement(ContentManagementList).click();
		driver.findElement(Generalizations).click();
		driver.findElement(addNewGeneralization).click();

		Thread.sleep(Const * 3);

		driver.findElement(outofMenu).click();
		Thread.sleep(Const * 3);
		driver.findElement(arTitle).sendKeys(generalizationARTitleContent);
		Thread.sleep(Const * 3);
		driver.findElement(arDesc).sendKeys(generalizationARDescContent);
		Thread.sleep(Const * 3);
		driver.findElement(enTitle).sendKeys(generalizationENTitleContent);
		Thread.sleep(Const * 3);
		driver.findElement(enDesc).sendKeys(generalizationENDescContent);
		Thread.sleep(Const * 3);
		driver.findElement(generalizationDate).sendKeys(Date);
		Thread.sleep(Const * 3);
		driver.findElement(activeGeneralizations).click();
		Thread.sleep(Const * 3);

		driver.findElement(SearchButton).click(); // Save button
		
		Thread.sleep(Const * 7);

    	String ActualResult = driver.findElement(successMessage).getText();
        System.out.println(ActualResult);
    	String ExpectedResult = updateSucceed;
    	Assert.assertTrue(ActualResult.contains(ExpectedResult));
		System.out.println("Actual Message: " + ActualResult);
		System.out.println("Expected Message: " + ExpectedResult);	

	}
	

	public void SwitchTab () {
		

		  String windowHandle = driver.getWindowHandle();
		    ArrayList tabs = new ArrayList (driver.getWindowHandles());
		   
		    driver.switchTo().window((String) tabs.get(1)); 
  
//  Actions action= new Actions(driver);
//  action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
//  driver.navigate().refresh();
	
}	
	@AfterMethod(enabled =false, groups = {"StartRNVL"})
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

}