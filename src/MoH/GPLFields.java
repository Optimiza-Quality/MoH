package MoH;

import org.openqa.selenium.By;

public class GPLFields extends Vars{
	
	By ErrorMessage = By.id("pt1:exceptionMsg");
	By SuccessMessageMyPage = By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div");
	
	//HomePage
	By Apply = By.id("txt14");
	By ChangeLanguage = By.linkText("English");
	
	//Applicant
	By AppType = By.id("pt1:r1:0:scl1:dc_smc1::content");
	By NextToBasicInfo = By.id("pt1:r1:0:scl1:dc_b1");
		
	//BasicInfo
	By PharmNationalID = By.id("pt1:r1:1:it1::content");
	By PharmIDNumber = By.id("pt1:r1:1:it3::content");
	By CoNationalNumber = By.id("pt1:r1:1:it2::content"); 
	By CoNationalNumber2 = By.id("pt1:r1:1:it10::content"); 
	By CoNumber = By.id("pt1:r1:1:it11::content"); 

	By Captcha2 = By.id("pt1:r1:1:it12::content");
	By CoVerify = By.id("pt1:r1:1:btnCheckCompany");
	
	By Captcha = By.id("pt1:r1:1:j_idt33::content");
	By VerifyBtn = By.id("pt1:r1:1:btnCheck");
	By MobileNo = By.id("pt1:r1:1:mn1:itMobileNumber::content");
	By CoMobileNo = By.id("pt1:r1:1:mn2:itMobileNumber::content");
	By Email = By.id("pt1:r1:1:e1:itEmail::content");
	By CoEmail = By.id("pt1:r1:1:e2:itEmail::content");
	By NextToVerificationCode = By.id("pt1:r1:1:b2");
	
	By ModifyContactDetails = By.linkText(" ⁄œÌ· „⁄·Ê„«  «·« ’«·");
	By CompanyNumber = By.id("pt1:r1:1:it11");
	By VerificationCode = By.id("pt1:r1:2:vc1:dc_it1::content"); 
	By NextToOtherInfo = By.id("pt1:r1:2:vc1:dc_b2");
	
	//OtherInfo
	By PropertyNumber = By.id("pt1:r1:3:it10::content");
	By SocialSecurityNo = By.id("pt1:r1:3:it9::content");
	By PharmCoordinates = By.id("pt1:r1:3:it1::content");
	By PharmAddress = By.id("pt1:r1:3:it13::content");
	By Hoiday = By.id("pt1:r1:3:soc1::content");
	By CheckBox = By.id("pt1:r1:3:sbc1::content");
	By RadioButton = By.xpath("//*[@id=\"pt1:r1:3:t1:0:sbr1::content\"]");
	By RadioButton2 = By.xpath("//*[@id=\"pt1:r1:3:t1:1:sbr1::content\"]");
	By RadioButton3 = By.xpath("//*[@id=\"pt1:r1:3:t1:2:sbr1::content\"]");
	By RadioButton4 = By.xpath("//*[@id=\"pt1:r1:3:t1:3:sbr1::content\"]");
	By EnterSSN = By.id("pt1:r1:3:t1:1:it2::content");
	
	By NextToAttachemnts = By.id("pt1:r1:3:b2");
	By CoNextToAttachemnts = By.id("pt1:r1:3:b4");
	
	//Attachments
	By Resignation = By.id("pt1:r1:4:it2:0:cif1:bButtonFile");
	By Sketch = By.id("pt1:r1:4:it2:1:cif1:bButtonFile");
	By GAM = By.id("pt1:r1:4:it2:2:cif1:bButtonFile");
	By COSketch = By.id("pt1:r1:4:it2:3:cif1:bButtonFile");
	By Lease = By.id("pt1:r1:4:it2:4:cif1:bButtonFile");
	
	By NextToReview = By.id("pt1:r1:5:b2");
	By NextToReviewChain = By.id("pt1:r1:4:b2");
	
	//Review
	By NextToRating = By.id("pt1:r1:5:b2"); 
	By CoNextToReview = By.id("pt1:r1:4:b2");
	
	By RateHappyAttachmentCases = By.id("pt1:r1:6:rs1:link1::icon");
	By RateNeutralAttachmentCases = By.id("pt1:r1:6:rs1:link2::icon");
	By RateSadAttachmentCases = By.id("pt1:r1:6:rs1:link3::icon");
	By NotesAttachmentCases = By.id("pt1:r1:6:rs1:it1::content");
	By SubmitAttachmentCases = By.id("pt1:r1:6:rs1:b2");
	
	// SubmissionPag
	By SuccessMessageAttachmentCases = By.id("pt1:r1:7:fp1:dc_pgl1");
	By ApplicationNumberAttachmentCases = By.id("pt1:r1:7:fp1:dc_ol5");
	By BackToHomeAttachmentCases = By.id("pt1:r1:7:fp1:dc_b1");
	
	
	// MyPage
		By LoginVerificationCode = By
				.xpath("//*[@id=\"pt1:r1:1:vc1:dc_it1::content\" or @id=\"pt1:r1:0:vc1:dc_it1::content\"]");
		By NextToMyPage = By.xpath("//*[@id=\"pt1:r1:1:vc1:dc_b2\" or @id=\"pt1:r1:0:vc1:dc_b2\"]");
		By MyMobileNumber = By.xpath(
				"//*[@id=\"pt1:r1:2:r4:0:mn1:itMobileNumber::content\" or @id=\"pt1:r1:1:r4:0:mn1:itMobileNumber::content\"]");
		By MyEmail = By
				.xpath("//*[@id=\"pt1:r1:2:r4:0:e1:itEmail::content\" or @id=\"pt1:r1:1:r4:0:e1:itEmail::content\"]");
		By MyAddress = By.xpath("//*[@id=\"pt1:r1:2:r4:0:it4::content\" or @id=\"pt1:r1:1:r4:0:it4::content\"]");
		By SaveEditedInfo = By.xpath("//*[@id=\"pt1:r1:2:r4:0:b1\" or @id=\"pt1:r1:1:r4:0:b1\"]");
		By GoToHomePage = By.xpath("//*[@id=\"pt1:r1:2:b1\" or @id=\"pt1:l1::icon\"]");
		By GoToMyPage = By.id("MyAppsImg");
		By MyPageApplicantType = By.id("pt1:r1:0:soc1::content");
		By MyPageNationalNumber = By.id("pt1:r1:0:it1::content");
		By MyPageCardNo = By.id("pt1:r1:0:p1:dc_it1::content");
		By MyPageSearch = By.id("pt1:r1:0:b1");
		By VerificationCodeMyPage = By.id("pt1:r1:0:vc1:dc_it1::content");
		By MyAppTab = By.id("pt1:r1:2:myRequests::ti");
		By SearchForApp = By.id("pt1:r1:2:r1:0:qryId1:val00::content");
		By AppDetails = By.id("pt1:r1:2:r1:0:t1:0:l1::text");
		By IncompleteApp = By.linkText("«” ﬂ„«· ‰Ê«ﬁ’");
		By PreviousToApps = By.id("pt1:r1:2:r1:1:b3");
		By MyLicenseTab = By.id("pt1:r1:2:myPermits::ti");
		By SearchForLicense = By.id("pt1:r1:2:r3:0:qryId1:val00::content");
		By LicenseDate = By.id("pt1:r1:2:r3:0:qryId1:val30::content");
		By LicenseDetails = By.linkText(" ›«’Ì·");
		By MyPaymentsTab = By.id("pt1:r1:2:myPayments::body");
		By PaymentNumber = By.id("pt1:r1:2:r2:0:t1:0:c1");
		

		By IncompleteButton = By.id("pt1:r1:2:r1:1:b2");
		//Review Screen Incomplete
		By ModifyOtherInc = By.linkText(" ⁄œÌ·");
		By ModifyAttachmentInc = By.xpath("//*[@id=\"pt1:r1:2:r1:2:l3\"]");
		//By ModifyAttachmentInc = By.id("pt1:r1:2:r1:2:l4::text");
		
		By NextButtonIncRev = By.id("pt1:r1:2:r1:2:b2");
		//OtherInfo Screen Incomplete
		By SSYIncOther = By.id("pt1:r1:2:r1:3:socSecondaryStudyYearRid::content");
		By NextButtonIncOther = By.id("pt1:r1:2:r1:3:btnOtherDataNextButton");
		//Attachment Screen Incomplete
		By UploadFileInc = By.id("pt1:r1:2:r1:3:it2:0:cif1:bButtonFile");
		
		By NextButtonInc = By.id("pt1:r1:2:r1:3:b2");
		//Rating Screen Inc
		By RateInc = By.id("pt1:r1:2:r1:4:rs1:link1::icon");
		By SubmitInc = By.id("pt1:r1:2:r1:4:rs1:b2");
		//Success
		By SuccessInc = By.id("pt1:r1:2:r1:5:fp1:dc_pgl2");
		By BackToHomeInc = By.id("pt1:r1:2:r1:5:fp1:dc_b1");
		
		By RejectionReasons = By.linkText("√”»«» «·—›÷");
		
		// Internal-Login
		By EMPUsername = By.id("pt1:lid1:dc_it1::content");
		By EMPPassword = By.id("pt1:lid1:dc_it2::content");
		By LoginBtn = By.id("pt1:lid1:dc_b1");

		// Internal-Menus
		By HomeMenu = By.id("icon1");
		By Applications = By.id("icon3");
		By TakeAction = By.id("icon8");
		By GPLApps = By.id("icon34");
		By FirstStep = By.id("icon63");
		By SecondStep = By.id("icon64");
		By ThirdStep = By.id("icon145");
		By FourthStep = By.id("icon65");
		By FifthStep = By.id("icon66");
		By SixthStep = By.id("icon156");
		

		// Internal-TakeAction-audit
		By Warning = By.id("pt1:r1:2:m2");
		By HeadNavigateOut = By.id("pt1:r1:2:requestStatus::content");
		By HeadSearchld = By.id("pt1:r1:2:requestNo::content");
		By HeadSearchBtn = By.id("pt1:r1:2:b1");
		By DetailsLink = By.linkText(" ›«’Ì·");
		
		By HeadNotes = By.id("pt1:r1:3:itNotes::content");
		By HeadApprove = By.xpath("//*[@id=\"pt1:r1:3:r1:0:sorRidDecision:_0\"]");
		By HeadReject = By.xpath("//*[@id=\"pt1:r1:3:r1:0:sorRidDecision:_2\"]");
		By HeadIncomplete = By.xpath("//*[@id=\"pt1:r1:3:r1:0:sorRidDecision:_1\"]");
		By HeadProcessBtn = By.id("pt1:r1:3:r1:0:b1");
		By HeadMoveAll = By.id("pt1:r1:3:r1:0:sms2::moveall");
		By HeadMoveAll2 = By.id("pt1:r1:3:r1:0:sms1::moveall");
		

		By SuccessMessageInternal = By.id("pt1:r1:3:r1:1:m1");
		By BackButtonInternal = By.id("pt1:r1:3:r1:1:b2");
			
		
		// Internal-TakeAction-jpa
		By DirectorNavigateOut = By.id("pt1:r1:4:requestStatus::content");
		By DirectorSearchld = By.id("pt1:r1:4:requestNo::content");
		By DirectorSearchBtn = By.id("pt1:r1:4:b1");
		
		By DirectorApprove = By.xpath("//*[@id=\"pt1:r1:5:r1:0:sorRidDecision:_0\"]");
		By DirectorReject = By.xpath("//*[@id=\"pt1:r1:5:r1:0:sorRidDecision:_2\"]");
		By DirectorMoveAll = By.id("pt1:r1:5:r1:0:sms1::moveall");
		By DirectorIncomplete = By.xpath("//*[@id=\"pt1:r1:5:r1:0:sorRidDecision:_1\"]");
		By DirectorProcessBtn = By.id("pt1:r1:5:r1:0:b1");
		By DirectorProcessBtn2 = By.id("pt1:r1:2:b4");
		
		By SuccessMessageInternalDirector = By.id("pt1:r1:5:r1:1:m1");
		By BackButtonInternalDirector = By.id("pt1:r1:5:r1:1:b2");
		
		//Internal-TakeAction - Appointment
		By ICAPPNavigateOut = By.id("pt1:r1:7:requestStatus::content");
		By ICAPPSearchld = By.id("pt1:r1:7:requestNo::content");
		By ICAPPSearchBtn = By.id("pt1:r1:7:b1");
		By AppointmentLink = By.linkText(" ÕœÌœ „Ê⁄œ ·Ã‰…");
		By Date = By.id("pt1:r1:3:id1::content");
		By TempBtn = By.id("pt1:r1:3:b1");
		By SaveBtn = By.id("pt1:r1:3:b2");
		By SuccessMessageInternalAppoint = By.id("pt1:r1:4:m1");
		By BackButtonInternalAppoint = By.id("pt1:r1:4:b1");
		
		// Internal-TakeAction-IC
		By ICWarning = By.id("pt1:r1:5:m2");
		By ICNavigateOut = By.id("pt1:r1:4:requestStatus::content");
		By ICSearchld = By.id("pt1:r1:4:requestNo::content");
		By ICSearchBtn = By.id("pt1:r1:4:b1");
		
		By ICApprove = By.xpath("//*[@id=\"pt1:r1:5:r1:0:sorRidDecision:_0\"]");
		By ICReject = By.xpath("//*[@id=\"pt1:r1:5:r1:0:sorRidDecision:_3\"]");
		By ICMoveAll = By.id("pt1:r1:5:r1:0:sms1::moveall");
		By ICIncomplete = By.xpath("//*[@id=\"pt1:r1:5:r1:0:sorRidDecision:_1\"]");
		By ICProcessBtn = By.id("pt1:r1:5:r1:0:b1");
		By ICProcessBtn2 = By.id("pt1:r1:2:b4");
		
		By SuccessMessageInternalIC = By.id("pt1:r1:5:r1:1:m1");
		By BackButtonInternalIC = By.id("pt1:r1:5:r1:1:b2");

	}
