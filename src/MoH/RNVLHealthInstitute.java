//submit an application
   @Test(priority=2,enabled=true)
public void HealthInstitute_Case2000() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
    Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
    //   //health institute
    userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("821976434"); // PersonalNumber
		driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
		Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button
		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next
		// --------------------------------Fill-Other-Info---------------------------------
		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian
		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981
		// Semester
		Thread.sleep(Const*10);
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		
		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("7822"); // StudentNumber

		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة مؤته");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2008"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("5279"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("175344"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:4:btnOtherDataNextButton")).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:link1::icon")).click(); // Rate-Happy
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:it1::content")).sendKeys("سعيد"); // Notes
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:b2")).click(); // Submit
		
	                 //	-------------------Assert-------------
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
		Thread.sleep(Const*10);
		System.out.println("Case 2.0.0.0 - Actual: " + ActualErrorMessage);
		String ExpectedErrorMessage ="تم تقديم طلبك بنجاح";
		System.out.println("Expected" + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//---------------------------------Take ScreenShot------------------------------
		Thread.sleep(Const*10);
        TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2000.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Health Institute - 2.0.0.0 test case");
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:6:fp1:dc_b1")).click(); // Home-Page
	}
//user not exists
@Test(priority=1,enabled=true)
public void HealthInstitute_Case2200() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("7567546"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("4141"); // PrivateNumber
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4278"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("987654301"); // PersonalNumber
		driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
		Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
//      -------------Assert---------------------
String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
System.out.println("Actual Message: " + ActualErrorMessage);

Thread.sleep(Const*10);
String ExpectedErrorMessage ="رقم قيد المنشأة الوطني غير موجود، لا يمكنك استكمال تقديم الطلب. يرجى مراجعة وزارة الصحة لإنشاء حساب خاص بك. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2200.png"));
        		} 
//Incorrect user's Info
@Test(priority=3,enabled=true)
public void HealthInstitute_Case2210() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
  //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("74747474"); // National-ID
		driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("7452"); // PrivateNumber
		driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4278"); // Association-Number
		driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("987654301"); // PersonalNumber
		driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
		Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);		
		
        //      -------------Assert---------------------
        String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="الرقم الخاص غير مطابق، لا يمكنك استكمال تقديم الطلب. يرجى التأكد من صحة الرقم الخاص. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
        //      ---------------ScreenShot--------------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2210.png"));
        		} 
//Open application
@Test(priority=4,enabled=true)
public void HealthInstitute_Case2300() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("821976434"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
		 //      -------------Assert---------------------
        String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="لا يمكنك استكمال تقديم الطلب لإصدار تصريح مزاولة مهنة ممرض قانوني نظرا لوجود طلب تصريح مزاولة مهنة ممرض قانوني سابق رقم لديك لايزال قيد التنفيذ، لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
        TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2300.png"));
        		} 
//Nurse has an active license for the same health institute 
@Test(priority=4,enabled=true)
public void HealthInstitute_Case2400() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID
			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber
			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("175869324"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("31/12/1996"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
		 //      -------------Assert---------------------
        String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="لا يمكنك استكمال تقديم الطلب لإصدار تصريح مزاولة مهنة ممرض قانوني نظرا لوجود تصريح مزاولة مهنة ممرض قانوني سابق فعال لدى المؤسسة الصحية المقدمة للطلب. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
        TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2400.png"));
        		} 
//nurse has an active license with different health institute 
@Test(priority=4,enabled=true)
public void HealthInstitute_Case2410() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID
			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber
			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("714582347"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("31/12/1996"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button
		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next
		// --------------------------------Fill-Other-Info---------------------------------
		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian
		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981
		// Semester
		Thread.sleep(Const*10);
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		
		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("7822"); // StudentNumber

		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة مؤته");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2008"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("5279"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("175344"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);

		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const*10);
//		-------------------Assert-------------
			
		driver.findElement(By.id("pt1:r1:4:btnOtherDataNextButton")).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:link1::icon")).click(); // Rate-Happy

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:it1::content")).sendKeys("سعيد"); // Notes
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:b2")).click(); // Submit
		
	                 
		//---------------------------------Take ScreenShot------------------------------
		Thread.sleep(Const*10);
        TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2410.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Health Institute - 2.0.0.0 test case");
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:6:fp1:dc_b1")).click(); // Home-Page
	
        		} 
//nurse has an inactive license
@Test(priority=4,enabled=true)
public void HealthInstitute_Case2420() throws InterruptedException, IOException {
//click on submit application button 
  driver.findElement(By.cssSelector("#txt19")).click();
  //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID
			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber
			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("782114553"); // PersonalNumber //LicenseIssueDate 2015
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("31/12/1996"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button
		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next
		// --------------------------------Fill-Other-Info---------------------------------
		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian
		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981
		// Semester
		Thread.sleep(Const*10);
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		
		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("7822"); // StudentNumber

		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة مؤته");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2008"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("5279"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("175344"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);

		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:4:btnOtherDataNextButton")).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:link1::icon")).click(); // Rate-Happy

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:it1::content")).sendKeys("سعيد"); // Notes
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:b2")).click(); // Submit
		
	                 //	-------------------Assert-------------
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
		Thread.sleep(Const*10);
		System.out.println("Case 2.0.0.0 - Actual: " + ActualErrorMessage);
		String ExpectedErrorMessage ="تم تقديم طلبك بنجاح";
		System.out.println("Expected" + ExpectedErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//---------------------------------Take ScreenShot------------------------------
		Thread.sleep(Const*10);
        TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2420.png"));

		// -----------------------------------------------------------------------------------------------
		System.out.println("Health Institute - 2.0.0.0 test case");
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:6:fp1:dc_b1")).click(); // Home-Page
	
        		} 
//Incorrect Personal Number
@Test(priority=5,enabled=true)
public void HealthInstitute_Case2500() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
  //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("7144525"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
		 //      -------------Assert---------------------
        String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="الرقم الشخصي المدخل غير صحيح، لا يمكنك استكمال تقديم الطلب. يرجى التأكد من صحة الرقم الشخصي. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2500.png"));
        		} 
//not Related Birthdate
@Test(priority=6,enabled=true)
public void HealthInstitute_Case2510() throws InterruptedException, IOException {
//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID
			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber
			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("821976434"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		    driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		    Thread.sleep(Const*10);
		 //      -------------Assert---------------------
        String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="تاريخ الميلاد غير مطابق، لا يمكنك استكمال تقديم الطلب. يرجى التأكد من صحة تاريخ الميلاد. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2510.png"));
        		} 
//High School Info Not Retrieved
@Test(priority=7,enabled=true)
public void HealthInstitute_Case2600() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("55221144"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41223"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4278"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("412236698"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981
		Thread.sleep(Const*10);

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("7822"); // StudentNumber

		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة مؤته");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2008"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("8523"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------
		Thread.sleep(Const*10);

		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("1472583"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("131313"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button
		//          ----------------------Assert-warning message -------------------------
		
		//                            -------------Screenshot---------------
		Thread.sleep(Const*10);
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2600-AttachmentSection.png"));
        
      //  -----------------------------------Upload Attachments--------------------------
        driver.findElement(By.id("pt1:r1:4:it2hh:0:cif1:bButtonFile")).click(); // Choose File
        Thread.sleep(Const*10);
		Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		// Give path where the au3 is saved.
		Thread.sleep(Const*10);
	    driver.findElement(By.id("pt1:r1:4:it2hh:2:cif1:bButtonFile")).click(); // Choose File
			Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		Thread.sleep(Const*10);
        driver.findElement(By.id("pt1:r1:4:it2hh:1:cif1:bButtonFile")).click(); // Choose File
		Thread.sleep(Const*10);
		Runtime.getRuntime().exec("C:\\Users\\nftaiha\\Desktop\\attachemnts\\Uploader.exe");
		
		
		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:4:btnOtherDataNextButton")).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:link1::icon")).click(); // Rate-Happy

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:it1::content")).sendKeys("سعيد"); // Notes
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:b2")).click(); // Submit

        //	-------------------Assert-------------
String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
Thread.sleep(Const*10);
System.out.println("Case 2.0.0.0 - Actual: " + ActualErrorMessage);
String ExpectedErrorMessage ="تم تقديم طلبك بنجاح";
System.out.println("Expected" + ExpectedErrorMessage);
Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
//---------------------------------Take ScreenShot------------------------------
		Thread.sleep(Const*10);
		TakesScreenshot ts2= (TakesScreenshot)driver; 
        File source2 = ts2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source2, new File("./ScreenShots/Case2600.png"));
		// -----------------------------------------------------------------------------------------------
		System.out.println("Health Institute 2.6.0.0 test case");
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:6:fp1:dc_b1")).click(); // Home-Page
		Thread.sleep(Const*10);
		
        		} 
//Incorrect Student Number
@Test(priority=8,enabled=true)
public void HealthInstitute_Case2700() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID
			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber
			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("555444455"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("7822"); // StudentNumber

		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة مؤته");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2008"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("2415"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("175344"); // NCRC DocumentNumber
		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button		
		Thread.sleep(Const*10);
		 //      -------------Assert---------------------
        String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="لا يمكنك استكمال تقديم الطلب نظرا لأن معلومات البكالوريوس المدخلة غير صحيحة , لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2700.png"));
}
//Graduated from Muna university
@Test(priority=8,enabled=true)
public void HealthInstitute_Case2710() throws InterruptedException, IOException {
	//click on submit application button 
  driver.findElement(By.cssSelector("#txt19")).click();
  //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
// //health institute
userType.selectByIndex(2);
  Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
//--------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID
			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber
			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("2487932154"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("7822"); // StudentNumber

		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("كلية الاميرة منى للتمريض");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("1998"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("2415"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("175344"); // NCRC DocumentNumber
		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button		
		Thread.sleep(Const*10);
		 //      -------------Assert---------------------
      String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
      System.out.println("Actual Message: " + ActualErrorMessage);
      Thread.sleep(Const*10);
      String ExpectedErrorMessage ="لا يمكنك استكمال تقديم الطلب نظرا لأن معلومات البكالوريوس المدخلة غير صحيحة , لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
      System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
      Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
      File source = ts.getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(source, new File("./ScreenShots/Case2710.png"));
}
//Bachelor's certificate from outside Jordan country
@Test(priority=9,enabled=true)
public void HealthInstitute_Case2720() throws InterruptedException, IOException {
	//click on submit application button 
   driver.findElement(By.cssSelector("#txt19")).click();
   //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//  //health institute
userType.selectByIndex(2);
   Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
//--------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("712236985"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		
       //Student Number (Jolos)
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("2711"); // StudentNumber ra8am jolos 

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("فرنسا");
		// UniversityCountry.selectByIndex(139); // Jordan


		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("Centre International de Recontre Mathematiques");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2005"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("7122"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("175344"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button		
		Thread.sleep(Const*10);

        //	-------------------Assert-------------
String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
Thread.sleep(Const*10);
System.out.println("Case 2.0.0.0 - Actual: " + ActualErrorMessage);
String ExpectedErrorMessage ="تم تقديم طلبك بنجاح";
System.out.println("Expected" + ExpectedErrorMessage);
Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
       File source = ts.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(source, new File("./ScreenShots/Case2720.png"));
}
//incorrect Equivalent number
@Test(priority=9,enabled=true)
public void HealthInstitute_Case2721() throws InterruptedException, IOException {
	//click on submit application button 
   driver.findElement(By.cssSelector("#txt19")).click();
   //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//  //health institute
userType.selectByIndex(2);
   Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
//--------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("712236985"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		
       //Student Number (Jolos)
		Thread.sleep(Const*10);
		//correct number 
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("7412"); // StudentNumber ra8am jolos 

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("فرنسا");
		// UniversityCountry.selectByIndex(139); // Jordan


		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("Centre International de Recontre Mathematiques");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2005"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		//correct number 7122
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("7412"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("175344"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button		
		Thread.sleep(Const*10);
		
//      -------------Assert---------------------
        String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="لا يمكنك استمال تقديم الطلب نظرا لأن معلومات البكالوريوس المدخلة غير صحيحة , لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
       File source = ts.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(source, new File("./ScreenShots/Case2721.png"));
}
//Not Graduated User
@Test(priority=9,enabled=true)
 public void HealthInstitute_Case2730() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("987654333"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		
        //Student Number (Jolos)
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("2711"); // StudentNumber ra8am jolos 

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan


		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة مؤته");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2008"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("7822"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("175344"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button		
		Thread.sleep(Const*10);
		 //      -------------Assert---------------------
        String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="لا يمكنك استكمال تقديم الطلب، نظرا لعدم إسترجاع معلومات البكالوريوس ، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2730.png"));
}
//not equivalent 
@Test(priority=10,enabled=true)
public void HealthInstitute_Case2740() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID
			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber
			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("715871237"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button
		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("فرنسا");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("7822"); // StudentNumber ra8am jolos 

		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("Centre International de Recontre Mathematiques");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2005"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("1745"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("175344"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button		
		Thread.sleep(Const*10);
		 //      -------------Assert---------------------
        String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="لا يمكنك استكمال تقديم الطلب نظرا لأن تخصصك ليس تابع لكلية التمريض، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2740.png"));
}
//Not Nursing major
@Test(priority=10,enabled=true)
public void HealthInstitute_Case2750() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("987654333"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian

		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981

		// Semester
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		

		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("7822"); // StudentNumber ra8am jolos 

		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة مؤته");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2008"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("7799"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("175344"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button		
		Thread.sleep(Const*10);
		 //      -------------Assert---------------------
        String ActualErrorMessage = driver.findElement(By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="لا يمكنك استكمال تقديم الطلب نظرا لأن تخصصك ليس تابع لكلية التمريض، يرجى مراجعة وزارة التعليم العالي والبحث العلمي لتصويب الأوضاع لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2750.png"));
}
// Incorrect NCRC No
@Test(priority=11,enabled=true)
public void HealthInstitute_Case2800() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("987654333"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// -----------NCRC-------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("23927"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out
	
		Thread.sleep(Const*10);
		 //      -------------Assert---------------------
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="لا يمكنك استكمال تقديم الطلب، لإصدار تصريح مزاولة مهنة ممرض قانوني يرجى إصدار شهادة عدم محكومية باستخدام الرابط التالي: إصدار شهادة عدم محكومية. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2800.png"));
}
//Convicted User
@Test(priority=12,enabled=true)
public void HealthInstitute_Case2810() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("987654333"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// -----------NCRC-------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7946135"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("852197"); // NCRC DocumentNumber
		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out	
		Thread.sleep(Const*10);
		TakesScreenshot ts= (TakesScreenshot)driver; 
		 //      -------------Assert---------------------
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="لا يمكنك استكمال تقديم طلب إصدار تصريح مزاولة مهنة ممرض قانوني لوجود خطأ في المعلومات المسترجعة لشهادة عدم المحكومية. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
		//     ------------------ScreenShot---------------
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2810.png"));
}
//Certificate Exceeds 3 months
@Test(priority=13,enabled=true)
public void HealthInstitute_Case2820() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("4173"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("987654333"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button

		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code

		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next

		// --------------------------------Fill-Other-Info---------------------------------

		// -----------NCRC-------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("1234579"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("121212"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out
	
		Thread.sleep(Const*10);
		 //      -------------Assert---------------------
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
        System.out.println("Actual Message: " + ActualErrorMessage);
        Thread.sleep(Const*10);
        String ExpectedErrorMessage ="لا يمكنك استكمال تقديم الطلب لإصدار تصريح مزاولة مهنة ممرض قانوني نظرا لأن شهادة عدم المحكومية الصادرة قد تجاوزت الثلاث أشهر من تاريخ إصدارها، يرجى إصدار شهادة عدم محكومية حديثة باستخدام الرابط التالي: إصدار شهادة عدم محكومية. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);

		//     ------------------ScreenShot---------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2820.png"));
}
//not a member in Jordanian Pharmacists Association
@Test(priority=14,enabled=true)
public void HealthInstitute_Case2900() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("7741"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("987654333"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
			
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
		//                       ----------------Assert--------------------
		String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
        String ExpectedErrorMessage="لا يمكنك استكمال تقديم الطلب نظرا لأنك غير منتسب للنقابة يرجى الانتساب للنقابة ومن ثم تقديم طلب تصريح مزاولة مهنة ممرض قانوني. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 06500454";
		System.out.println("Actual Message: " + ActualErrorMessage);
		Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
        System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
        //                         ------------ScreenShot---------------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2900.png"));
		
}
//Membership Fees Not Paid
@Test(priority=15,enabled=true)
public void HealthInstitute_Case2910() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("5370"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("987654333"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
//      ----------------Assert--------------------
String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
String ExpectedErrorMessage="لا يمكنك استكمال تقديم الطلب نظرا لأنك غير مسدد للرسوم المترتبة عليك في النقابة يرجى تسديد رسوم النقابة ومن ثم تقديم طلب تصريح مزاولة مهنة ممرض قانوني. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
System.out.println("Actual Message: " + ActualErrorMessage);
Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
//                         ------------ScreenShot---------------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2910.png"));
		
}
//JNMC Data corrupted
@Test(priority=16,enabled=true)
public void HealthInstitute_Case2920() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("668"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("987654333"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
//      ----------------Assert--------------------
String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
String ExpectedErrorMessage="لا يمكنك استكمال تقديم الطلب نظرا لحدوث خطأ في إسترجاع معلوماتك من نقابة الممرضين، يرجى مراجعة نقابة الممرضين للتأكد من الإنتساب ولتأكد من صحة بياناتك، لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
System.out.println("Actual Message: " + ActualErrorMessage);
Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
//                         ------------ScreenShot---------------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case2920.png"));
		
}
//user has a previous rejection within the last 3 months
@Test(priority=17,enabled=false) 
public void HealthInstitute_Case21000() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
  //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("1447"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("12378954"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
//      ----------------Assert--------------------
String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
String ExpectedErrorMessage="لا يمكنك استكمال تقديم الطلب لإصدار تصريح مزاولة مهنة ممرض قانوني نظرا لأنه قد تم رفض طلبك من أقل من 3 شهور. لمزيد من المعلومات يرجى الإتصال على الخط الساخن لوزارة الصحة 065004545";
System.out.println("Actual Message: " + ActualErrorMessage);
Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
System.out.println("ExpectedErrorMessage: "+ ExpectedErrorMessage);
//                         ------------ScreenShot---------------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case21000.png"));
		
}
//previous Rejection more than 3mths ago
@Test(priority=18,enabled=true) 
public void HealthInstitute_Case21010() throws InterruptedException, IOException {
	//click on submit application button 
    driver.findElement(By.cssSelector("#txt19")).click();
    //user type ddl
Select userType = new Select (driver.findElement(By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content")));
//   //health institute
userType.selectByIndex(2);
    Thread.sleep(Const*10);
	driver.findElement(By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a")).click(); // Next
	Thread.sleep(Const*10);
// --------------------------------Fill-Basic-Info---------------------------------
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itUserName::content")).sendKeys("52317954"); // National-ID

			driver.findElement(By.id("pt1:r1:1:itPrivateNo::content")).sendKeys("41725"); // PrivateNumber

			driver.findElement(By.id("pt1:r1:1:itAssociationNo::content")).sendKeys("1332"); // Association-Number
			driver.findElement(By.id("pt1:r1:1:itForeignerNo::content")).sendKeys("14788523"); // PersonalNumber
			driver.findElement(By.id("pt1:r1:1:idBirthDate::content")).sendKeys("29/11/2016"); // Birthdate
			Thread.sleep(Const*10);
			driver.findElement(By.id("pt1:r1:1:itCaptchaValue::content")).sendKeys("0000");  //Captcha code 
			Thread.sleep(Const*10);
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a")).click(); // VerifyButton
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:1:btnBasicInfoNextButton")).click(); // Next-Button
		// --------------------------------Verification-Code---------------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_it1::content")).sendKeys("0000"); // Verification-Code
		driver.findElement(By.xpath("//*[@id=\"pt1:r1:2:vc1:dc_pgl3\"]/div[2]")).click(); // click-anywhere-to-navigate-out
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:2:vc1:dc_b2")).click(); // Next
		// --------------------------------Fill-Other-Info---------------------------------
		// Schooling-System
		Thread.sleep(Const*10);
		Select SchoolingSystem = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudySystemRid::content")));
		SchoolingSystem.selectByIndex(1); // Jordanian
		Thread.sleep(Const*10);
		// Certificate-Year
		Select CertificateYear = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyYearRid::content")));
		CertificateYear.selectByIndex(1); // 1981
		// Semester
		Thread.sleep(Const*10);
		Select Semester = new Select(driver.findElement(By.id("pt1:r1:3:socSecondaryStudyCourse::content")));
		Semester.selectByIndex(1); // Winter
		
		// -----Bachelor-Degree-Frame-----

		// University-Country
		Thread.sleep(Const*10);
		Select UniversityCountry = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicCountryRid::content")));
		UniversityCountry.selectByVisibleText("الأردن");
		// UniversityCountry.selectByIndex(139); // Jordan

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itSecondarySessionNo::content")).sendKeys("7822"); // StudentNumber

		// University
		Thread.sleep(Const*10);
		Select University = new Select(driver.findElement(By.id("pt1:r1:3:soc11::content")));
		University.selectByVisibleText("جامعة مؤته");

		// Graduation-Year
		Select Graduation = new Select(driver.findElement(By.id("pt1:r1:3:socAcademicGraduateYearRid::content")));
		Graduation.selectByVisibleText("2008"); // Graduation-Year
		
		//Student-UniversityNumber
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:3:itUniversityNo::content")).sendKeys("5279"); // University-StudentNumber

		// Degree
		Thread.sleep(Const*10);
		Select Degree = new Select(driver.findElement(By.id("pt1:r1:3:lastAcademicDegreeRid::content")));
		Degree.selectByIndex(1); // Bachelor

		// -----------NCRC-------

		driver.findElement(By.id("pt1:r1:3:itNonjudgmentCertificateNo::content")).sendKeys("7182935"); // NCRC
		driver.findElement(By.id("pt1:r1:3:itNonjudgmentDocumentNo::content")).sendKeys("175344"); // NCRC DocumentNumber


		driver.findElement(By.id("pt1:dc_pgl5")).click(); // click-anywhere-to-navigate-out

		Thread.sleep(Const*10);

		driver.findElement(By.id("pt1:r1:3:btnOtherDataNextButton")).click(); // Next-Button

		// ---------------------------------Review-Section----------------------------
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:4:btnOtherDataNextButton")).click(); // Next-Button

		// ------------------------------Rate and Submit---------------------

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:link1::icon")).click(); // Rate-Happy

		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:it1::content")).sendKeys("سعيد"); // Notes
		Thread.sleep(Const*10);
		driver.findElement(By.id("pt1:r1:5:rs1:b2")).click(); // Submit
		
		   //	-------------------Assert-------------
				String ActualErrorMessage = driver.findElement(By.id("pt1:exceptionMsg")).getText();
				Thread.sleep(Const*10);
				System.out.println("Case 2.0.0.0 - Actual: " + ActualErrorMessage);
				String ExpectedErrorMessage ="تم تقديم طلبك بنجاح";
				System.out.println("Expected" + ExpectedErrorMessage);
				Assert.assertTrue(ActualErrorMessage.contains(ExpectedErrorMessage));
				//---------------------------------Take ScreenShot------------------------------
		TakesScreenshot ts= (TakesScreenshot)driver; 
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/Case21010.png"));
		
}
}