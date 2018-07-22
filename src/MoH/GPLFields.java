package MoH;

import org.openqa.selenium.By;

public class GPLFields {
	
	By ErrorMessage = By.id("pt1:exceptionMsg");
	
	//HomePage
	By Apply = By.id("txt14");
	
	//Applicant
	By AppType = By.id("pt1:r1:0:scl1:dc_smc1::content");
	By NextToBasicInfo = By.id("pt1:r1:0:scl1:dc_b1");
		
	//BasicInfo
	By PharmNationalID = By.id("pt1:r1:1:it1::content");
	By PharmIDNumber = By.id("pt1:r1:1:it3::content");
	By CoNationalNumber = By.id("pt1:r1:1:it2::content");
	By Captcha = By.id("pt1:r1:1:j_idt29::content");
	By VerifyBtn = By.id("pt1:r1:1:btnCheck");
	By MobileNo = By.id("pt1:r1:1:mn1:itMobileNumber::content");
	By Email = By.id("pt1:r1:1:e1:itEmail::content");
	By NextToVerificationCode = By.id("pt1:r1:1:b2");
	By ModifyContactDetails = By.linkText(" ⁄œÌ· „⁄·Ê„«  «·« ’«·");
	
	//VerificationCode
	By VerificationCode = By.id("pt1:r1:2:vc1:dc_it1::content");
	By NextToOtherInfo = By.id("pt1:r1:2:vc1:dc_b2");
	
	//OtherInfo
	By PropertyNumber = By.id("pt1:r1:3:it10::content");
	By SocialSecurityNo = By.id("pt1:r1:3:it9::content");
	By PharmCoordinates = By.id("pt1:r1:3:it1::content");
	By PharmAddress = By.id("pt1:r1:3:it13::content");
	By Hoiday = By.id("pt1:r1:3:soc1::content");
	By CheckBox = By.id("pt1:r1:3:sbc1::content");
	By NextToAttachemnts = By.id("pt1:r1:3:b2");
	
	//Attachments
	By Sketch = By.id("pt1:r1:4:it2:0:cif1:bButtonFile");
	By Lease = By.id("pt1:r1:4:it2:1:cif1:bButtonFile");
	By NextToReview = By.id("pt1:r1:4:b2");
	
	//Review
	By NextToRating = By.id("pt1:r1:5:b2");
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
		By MyAppTab = By.id("pt1:r1:2:myRequests::ti");
		By SearchForApp = By.id("pt1:r1:2:r1:0:qryId1:val00::content");
		By AppDetails = By.id("pt1:r1:2:r1:0:t1:0:l1::text");
		By PreviousToApps = By.id("pt1:r1:2:r1:1:b1");
		By MyLicenseTab = By.id("pt1:r1:2:myPermits::ti");
		By SearchForLicense = By.id("pt1:r1:2:r3:0:qryId1:val00::content");
		By LicenseDate = By.id("pt1:r1:2:r3:0:qryId1:val30::content");

}
