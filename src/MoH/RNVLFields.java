package MoH;

import org.openqa.selenium.By;

public class RNVLFields extends CommonFields{

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
	
	//CheckList
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
	


}
