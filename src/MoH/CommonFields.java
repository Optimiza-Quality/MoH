package MoH;

import org.openqa.selenium.By;
import org.openqa.selenium.By;

public class CommonFields extends Vars{

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
	By MyPageCardNo = By.id("pt1:r1:0:it2::content");
	By MyPageSearch = By.id("pt1:r1:0:b1");
	By MyAppTab = By.id("pt1:r1:2:myRequests::ti");
	By SearchForApp = By.id("pt1:r1:2:r1:0:qyrmp:val00::content");
	By AppDetails = By.id("pt1:r1:2:r1:0:t1:0:l1::text");
	By IncompleteApp = By.linkText("استكمال نواقص");
	By RejectionReasons = By.linkText("أسباب الرفض");
	By PreviousToApps = By.id("pt1:r1:2:r1:1:b1");
	By BackToApps = By.id("pt1:r1:2:r1:1:b3");
	By MyLicenseTab = By.id("pt1:r1:2:myPermits::ti");
	By SearchForLicense = By.id("pt1:r1:2:r3:0:qryId1:val00::content");
	By LicenseDate = By.id("pt1:r1:2:r3:0:qryId1:val30::content");
	By LicenseDetails = By.linkText("تفاصيل");

	By IncompleteButton = By.id("pt1:r1:2:r1:1:b2");
	//Review Screen Incomplete
	By ModifyOtherInc = By.linkText("تعديل");
	By ModifyAttachmentInc = By.xpath("//*[@id=\"pt1:r1:2:r1:2:l4\"]");
	By ModifyAttachmentIncPha = By.xpath("//*[@id=\"pt1:r1:2:r1:2:l3\"]");
	//By ModifyAttachmentInc = By.id("pt1:r1:2:r1:2:l4::text");
	
	By NextButtonIncRev = By.xpath("//*[@id=\"pt1:r1:2:r1:2:btnOtherDataNextButton\"]");
	
	
	By NextButtonIncRevPha = By.xpath("//*[@id=\"pt1:r1:2:r1:2:b2\"]");
	
	
	//OtherInfo Screen Incomplete
	By SSYIncOther = By.id("pt1:r1:2:r1:3:socSecondaryStudyYearRid::content");
	By NextButtonIncOther = By.id("pt1:r1:2:r1:3:btnOtherDataNextButton");
	//Attachment Screen Incomplete
	By UploadFileInc = By.id("pt1:r1:2:r1:3:it2hh:0:cif1:bButtonFile");
	By UploadFileIncPHA = By.id("pt1:r1:2:r1:3:it2:0:cif1:bButtonFile");
	By NextButtonInc = By.id("pt1:r1:2:r1:3:bAttamentNext");
	By NextButtonIncPHA = By.id("pt1:r1:2:r1:3:b2");
	//Rating Screen Inc
	By RateInc = By.id("pt1:r1:2:r1:4:rs1:link1::icon");
	By SubmitInc = By.id("pt1:r1:2:r1:4:rs1:b2");
	//Success
	By SuccessInc = By.id("pt1:r1:2:r1:5:fp1:dc_pgl2");
	By BackToHomeInc = By.id("pt1:r1:2:r1:5:fp1:dc_b1");
	
	//Contact-Us
	By EmailSend = By.id("pt1:e1:itEmail::content");
	By MsgText = By.id("pt1:it7::content");
	By CaptchaContact = By.id("pt1:itCaptchaValue::content");
	By MobileSend = By.id("pt1:mn1:itMobileNumber::content");
	By CountryCodeContact = By.id("pt1:mn1:dc_soc1::content");
	By NameSend = By.id("pt1:it3::content");
	By MsgType = By.id("pt1:soc2::content");
	By SelectSerivce = By.id("pt1:soc3::content");
	By BtnSend = By.id("pt1:b2");
	
}
