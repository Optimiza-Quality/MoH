package MoH;

import org.openqa.selenium.By;

public class RNVLFields extends Vars{

	// General
	By ErrorMessage = By.id("pt1:exceptionMsg");
	By ErrorMessageIDXpath = By.xpath("pt1:exceptionMsg");
	By ErrorMessageByXpath = By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div");
	By Body = By.cssSelector("body");
	By ErrorMessageHead = By.xpath("//*[@id=\"pt1:exceptionMsg\"]/table/tbody/tr/td[2]");

	// HomePage
	By ChangeLanguage = By.linkText("English");
	By Apply = By.xpath("//*[@id=\"txt19\"]");
	By ApplyCSS = By.cssSelector("#txt19");
	By ApplicantTypeDDL = By.id("pt1:r1:0:scl1:dc_smc1::content");
	By ApplicantTypeDDLCSS = By.cssSelector("#pt1\\3a r1\\3a 0\\3a scl1\\3a dc_smc1\\3a \\3a content");
	By NextToBasicInfo = By.xpath("//*[@id=\"pt1:r1:0:scl1:dc_b1\"]/a");

	// BasicInfoPage
	By NationalID = By.id("pt1:r1:1:itUserName::content");
	By IDNumber = By.id("pt1:r1:1:itCivilId::content");
	By AssociationNumber = By.id("pt1:r1:1:itAssociationNo::content");
	By Captcha = By.id("pt1:r1:1:itCaptchaValue::content");
	By VerifyButton = By.xpath("//*[@id=\"pt1:r1:1:bVerifyCaptcah\"]/a");
	By MobileNumber = By.id("pt1:r1:1:mn1:itMobileNumber::content");
	By Email = By.id("pt1:r1:1:e1:itEmail::content");
	By Address = By.id("pt1:r1:1:itAddress::content");
	By NextToVerificationCode = By.xpath("//*[@id=\"pt1:r1:1:btnBasicInfoNextButton\"]/a");
	By PrivateNo = By.id("pt1:r1:1:itPrivateNo::content");
	By MilitaryNo = By.id("pt1:r1:1:itMilitaryNo::content");
	By PersonalNumber = By.id("pt1:r1:1:itForeignerNo::content");
	By Birthdate = By.id("pt1:r1:1:idBirthDate::content");
	By ModifyContactDetails = By.linkText("تعديل معلومات الاتصال");

	// VerificationPage
	By VerificationCodeText = By.id("pt1:r1:2:vc1:dc_it1::content");
	By NextToOtherInfo = By.id("pt1:r1:2:vc1:dc_b2");

	// OtherInfoPage
	By SchoolingSysDDL = By.id("pt1:r1:3:socSecondaryStudySystemRid::content");
	By CertificateYearDDL = By.id("pt1:r1:3:socSecondaryStudyYearRid::content");
	By SemesterDDL = By.id("pt1:r1:3:socSecondaryStudyCourse::content");
	By HighSchoolCountry = By.id("pt1:r1:3:socSecondaryCountry::content");
	By StudentID = By.id("pt1:r1:3:itSecondarySessionNo::content");
	By UniversityCountryDDL = By.id("pt1:r1:3:socAcademicCountryRid::content");
	By UniversityDDL = By.id("pt1:r1:3:soc11::content");
	By GraduationYearDDL = By.id("pt1:r1:3:socAcademicGraduateYearRid::content");
	By ReGraduationYearDDL = By.id("pt1:r1:0:socAcademicGraduateYearRid::content");
	By DegreeDDL = By.id("pt1:r1:3:lastAcademicDegreeRid::content");
	By ReDegreeDDL = By.id("pt1:r1:0:lastAcademicDegreeRid::content");
	By UniversityNo = By.id("pt1:r1:3:itUniversityNo::content");
	By NCRC = By.id("pt1:r1:3:itNonjudgmentCertificateNo::content");
	By NextToReviewOrAttachments = By.id("pt1:r1:3:btnOtherDataNextButton");
	By ReNextToReviewOrAttachments = By.id("pt1:r1:0:btnOtherDataNextButton");
	By EquivalenceLetter = By.id("pt1:r1:3:itEquationNo::content");
	By AdmissionYear = By.id("pt1:r1:3:socAcademicStudyYearRid::content");
	By NCRCDocument = By.id("pt1:r1:3:itNonjudgmentDocumentNo::content");

	// ReviewPage-WithoutAttachemnts
	By NextToSubmitGeneralCases = By.id("pt1:r1:4:btnOtherDataNextButton");
	By NextToSubmitGeneralCasesXpath = By.xpath("//*[@id=\"pt1:r1:4:btnOtherDataNextButton\"]");
	By ReNextToSubmitGeneralCases = By.id("pt1:r1:1:btnOtherDataNextButton");
	By WarningMessageGeneralCases = By.id("pt1:r1:4:m2");

	// RatingPage-WithoutAttachemnts
	By RateHappyGeneralCases = By.id("pt1:r1:5:rs1:link1::icon");
	By RateNeutralGeneralCases = By.id("pt1:r1:5:rs1:link2::icon");
	By RateSadGeneralCases = By.id("pt1:r1:5:rs1:link3::icon");
	By NotesGeneralCases = By.id("pt1:r1:5:rs1:it1::content");
	By SubmitGeneralCases = By.id("pt1:r1:5:rs1:b2");

	// SubmissionPage-WithoutAttachemnts
	By SuccessMessageGeneralCases = By.id("pt1:r1:6:fp1:dc_pgl1");
	By ApplicationNumberGeneralCases = By.id("pt1:r1:6:fp1:dc_ol5");
	By BackToHomeGeneralCases = By.id("pt1:r1:6:fp1:dc_b1");
	By BackToHomeAnother = By.id("pt1:r1:6:fp1:dc_pgl2");
	// AttachmentsPage
	By UploadSchoolCertificate = By.id("pt1:r1:4:it2hh:0:cif1:bButtonFile");
	By ReUploadSchoolCertificate = By.id("pt1:r1:1:it2hh:0:cif1:bButtonFile");
	By NextToReviewAttachmentCases = By.id("pt1:r1:4:bAttamentNext");
	By ReNextToReviewAttachmentCases = By.id("pt1:r1:1:bAttamentNext");
	By UploadPassport = By.id("pt1:r1:4:it2hh:0:cif1:bButtonFile");
	By UploadPersonalPhoto = By.id("pt1:r1:4:it2hh:2:cif1:bButtonFile");
	By UploadSchoolCertificateHealthInstitute = By.id("pt1:r1:4:it2hh:1:cif1:bButtonFile");

	// ReviewPage-Attachments
	By NextToSubmitAttachmentCases = By.id("pt1:r1:5:btnOtherDataNextButton");
	By ReNextToSubmitAttachmentCases = By.id("pt1:r1:2:btnOtherDataNextButton");

	// RatingPage-Attachments
	By RateHappyAttachmentCases = By.id("pt1:r1:6:rs1:link1::icon");
	By RateNeutralAttachmentCases = By.id("pt1:r1:6:rs1:link2::icon");
	By RateSadAttachmentCases = By.id("pt1:r1:6:rs1:link3::icon");
	By ReRateSadAttachmentCases = By.id("pt1:r1:3:rs1:link3::icon");
	By NotesAttachmentCases = By.id("pt1:r1:6:rs1:it1::content");
	By ReNotesAttachmentCases = By.id("pt1:r1:3:rs1:it1::content");
	By SubmitAttachmentCases = By.id("pt1:r1:6:rs1:b2");
	By ReSubmitAttachmentCases = By.id("pt1:r1:3:rs1:b2");

	// SubmissionPage-Attachments
	By SuccessMessageAttachmentCases = By.id("pt1:r1:7:fp1:dc_pgl1");
	By ReSuccessMessageAttachmentCases = By.id("pt1:r1:4:fp1:dc_pgl1");
	By ApplicationNumberAttachmentCases = By.id("pt1:r1:7:fp1:dc_ol5");
	By ReApplicationNumberAttachmentCases = By.id("pt1:r1:4:fp1:dc_ol5");
	By BackToHomeAttachmentCases = By.id("pt1:r1:7:fp1:dc_b1");
	By ReBackToHomeAttachmentCases = By.id("pt1:r1:4:fp1:dc_b1");

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
	By MyLicenseTab = By.id("pt1:r1:2:myPermits::ti");
	By SearchForLicense = By.id("pt1:r1:2:r3:0:qryId1:val00::content");
	By LicenseDate = By.id("pt1:r1:2:r3:0:qryId1:val30::content");
	By LicenseDetails = By.linkText("تفاصيل");

	By IncompleteButton = By.id("pt1:r1:2:r1:1:b2");
	//Review Screen Incomplete
	By ModifyOtherInc = By.linkText("تعديل");
	By ModifyAttachmentInc = By.xpath("//*[@id=\"pt1:r1:2:r1:2:l4\"]");
	//By ModifyAttachmentInc = By.id("pt1:r1:2:r1:2:l4::text");
	
	By NextButtonIncRev = By.xpath("//*[@id=\"pt1:r1:2:r1:2:btnOtherDataNextButton\"]");
	//OtherInfo Screen Incomplete
	By SSYIncOther = By.id("pt1:r1:2:r1:3:socSecondaryStudyYearRid::content");
	By NextButtonIncOther = By.id("pt1:r1:2:r1:3:btnOtherDataNextButton");
	//Attachment Screen Incomplete
	By UploadFileInc = By.id("pt1:r1:2:r1:3:it2hh:0:cif1:bButtonFile");
	By NextButtonInc = By.id("pt1:r1:2:r1:3:bAttamentNext");
	//Rating Screen Inc
	By SubmitInc = By.id("pt1:r1:2:r1:4:rs1:b2");
	//Success
	By SuccessInc = By.id("pt1:r1:2:r1:5:fp1:dc_pgl2");
	By BackToHomeInc = By.id("pt1:r1:2:r1:5:fp1:dc_b1");
	
	
	// Internal-Login
	By EMPUsername = By.id("pt1:lid1:dc_it1::content");
	By EMPPassword = By.id("pt1:lid1:dc_it2::content");
	By LoginBtn = By.id("pt1:lid1:dc_b1");

	// Internal-Menus
	By Applications = By.id("icon3");
	By TakeAction = By.id("icon8");
	By RNVLApps = By.id("icon32");
	By HomeMenu = By.id("icon1");
	By FirstStep = By.id("icon58");
	By SecondStep = By.id("icon59");

	// Internal-TakeAction-Head
	By Warning = By.id("pt1:r1:2:m2");
	By HeadNavigateOut = By.id("pt1:r1:2:requestStatus::content");
//	By HeadNavigateOut = By.id("pt1:r1:2:serviceType::content");
	By HeadSearchld = By.id("pt1:r1:2:requestNo::content");
	By HeadSearchBtn = By.id("pt1:r1:2:b1");
	
	By HeadNotes = By.id("pt1:r1:2:itNotes::content");
	By HeadApprove = By.xpath("//*[@id=\"pt1:r1:3:sor1:_0\"]");

	By HeadReject = By.xpath("//*[@id=\"pt1:r1:3:sor1:_2\"]");
	By HeadIncomplete = By.xpath("//*[@id=\"pt1:r1:3:sor1:_1\"]");
	By HeadProcessBtn = By.id("pt1:r1:3:b2");
	By HeadProcessBtn2 = By.id("pt1:r1:3:b4");
	By HeadMoveAll = By.id("pt1:r1:3:smsShuttle::moveall");
	By DetailsLink = By.linkText("تفاصيل");

	By SuccessMessageInternal = By.id("pt1:r1:4:m1");
	By BackButtonInternal = By.id("pt1:r1:4:b1");
		
	
	// Internal-TakeAction-Director
	By DirectorWarning = By.id("pt1:r1:6:m2");
	By DirectorNavigateOut = By.id("pt1:r1:6:requestStatus::content");
	By DirectorSearchld = By.id("pt1:r1:6:requestNo::content");
	By DirectorSearchBtn = By.id("pt1:r1:6:b1");
	
	By DirectorNotes = By.id("pt1:r1:7:itNotes::content");
	By DirectorApprove = By.xpath("//*[@id=\"pt1:r1:7:sor1:_0\"]");
	By DirectorReject = By.xpath("//*[@id=\"pt1:r1:7:sor1:_2\"]");
	By DirectorMoveAll = By.id("pt1:r1:7:smsShuttle::moveall");
	By DirectorIncomplete = By.xpath("//*[@id=\"pt1:r1:7:sor1:_1\"]");
	By DirectorProcessBtn = By.id("pt1:r1:7:b4");
	By DirectorProcessBtn2 = By.id("pt1:r1:2:b4");
	
	By SuccessMessageInternalDirector = By.id("pt1:r1:8:m1");
	By BackButtonInternalDirector = By.id("pt1:r1:8:b1");
	
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