package MoH;

import org.openqa.selenium.By;

public class RNVLFields {

	// General
	By ErrorMessage = By.id("pt1:exceptionMsg");
	By ErrorMessageByXpath = By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]/div");
	By ErrorMessageBefore2001 = By.id("pt1:r1:4:m2");

	// HomePage
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

	// VerificationPage
	By VerificationCodeText = By.id("pt1:r1:2:vc1:dc_it1::content");
	By NextToOtherInfo = By.id("pt1:r1:2:vc1:dc_b2");

	// OtherInfoPage
	By SchoolingSysDDL = By.id("pt1:r1:3:socSecondaryStudySystemRid::content");
	By CertificateYearDDL = By.id("pt1:r1:3:socSecondaryStudyYearRid::content");
	By SemesterDDL = By.id("pt1:r1:3:socSecondaryStudyCourse::content");
	By StudentID = By.id("pt1:r1:3:itSecondarySessionNo::content");
	By UniversityCountryDDL = By.id("pt1:r1:3:socAcademicCountryRid::content");
	By UniversityDDL = By.id("pt1:r1:3:soc11::content");
	By GraduationYearDDL = By.id("pt1:r1:3:socAcademicGraduateYearRid::content");
	By DegreeDDL = By.id("pt1:r1:3:lastAcademicDegreeRid::content");
	By UniversityNo = By.id("pt1:r1:3:itUniversityNo::content");
	By NCRC = By.id("pt1:r1:3:itNonjudgmentCertificateNo::content");
	By NextToReviewOrAttachments = By.id("pt1:r1:3:btnOtherDataNextButton");
	By EquivalenceLetter = By.id("pt1:r1:3:itEquationNo::content");
	By AdmissionYear = By.id("pt1:r1:3:socAcademicStudyYearRid::content");
	By NCRCDocument = By.id("pt1:r1:3:itNonjudgmentDocumentNo::content");

	// ReviewPage-WithoutAttachemnts
	By NextToSubmitGeneralCases = By.id("pt1:r1:4:btnOtherDataNextButton");

	// RatingPage-WithoutAttachemnts
	By RateHappyGeneralCases = By.id("pt1:r1:5:rs1:link1::icon");
	By RateNeutralGeneralCases = By.id("pt1:r1:5:rs1:link2::icon");
	By RateSadGeneralCases = By.id("pt1:r1:5:rs1:link3::icon");
	By NotesGeneralCases = By.id("pt1:r1:5:rs1:it1::content");
	By SubmitGeneralCases = By.id("pt1:r1:5:rs1:b2");

	// SubmissionPage-WithoutAttachemnts
	By SuccessMessageGeneralCases = By.id("pt1:r1:6:fp1:dc_ol7");
	By ApplicationNumberGeneralCases = By.id("pt1:r1:6:fp1:dc_ol5");
	By BackToHomeGeneralCases = By.id("pt1:r1:6:fp1:dc_b1");

	// AttachmentsPage
	By UploadSchoolCertificate = By.id("pt1:r1:4:it2hh:0:cif1:bButtonFile");
	By NextToReviewAttachmentCases = By.id("pt1:r1:4:bAttamentNext");
	By UploadPassport = By.id("pt1:r1:4:it2hh:0:cif1:bButtonFile");
	By UploadPersonalPhoto = By.id("pt1:r1:4:it2hh:2:cif1:bButtonFile");
	By UploadSchoolCertificateHealthInstitute = By.id("pt1:r1:4:it2hh:1:cif1:bButtonFile");

	// ReviewPage-Attachments
	By NextToSubmitAttachmentCases = By.id("pt1:r1:5:btnOtherDataNextButton");

	// RatingPage-Attachments
	By RateHappyAttachmentCases = By.id("pt1:r1:6:rs1:link1::icon");
	By RateNeutralAttachmentCases = By.id("pt1:r1:6:rs1:link2::icon");
	By RateSadAttachmentCases = By.id("pt1:r1:6:rs1:link3::icon");
	By NotesAttachmentCases = By.id("pt1:r1:6:rs1:it1::content");
	By SubmitAttachmentCases = By.id("pt1:r1:6:rs1:b2");

	// SubmissionPage-Attachments
	By SuccessMessageAttachmentCases = By.id("pt1:r1:7:fp1:dc_ol7");
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
	// Internal-Login

		By EMPUsername = By.id("pt1:lid1:dc_it1::content");

		By EMPPassword = By.id("pt1:lid1:dc_it2::content");

		By LoginBtn = By.id("pt1:lid1:dc_b1");



		// Internal-Menus

		By Applications = By.id("icon3");

		By TakeAction = By.id("icon8");

		By RNVLApps = By.id("icon32");

		By FirstStep = By.id("icon58");

		By HomeMenu = By.id("icon1");

		By SecondStep = By.id("icon59");



		// Internal-TakeAction-Head

		By HeadNavigateOut = By.id("pt1:r1:1:requestStatus::content");

		By HeadSearchld = By.id("pt1:r1:1:requestNo::content");

		By HeadSearchBtn = By.id("pt1:r1:1:b1");

		

		By HeadNotes = By.id("pt1:r1:2:itNotes::content");

		By HeadProcessBtn = By.id("pt1:r1:2:b2");

		By HeadApprove = By.xpath("//*[@id=\"pt1:r1:2:sor1:_0\"]");

		By HeadReject = By.xpath("//*[@id=\"pt1:r1:2:sor1:_2\"]");

		By HeadIncomplete = By.xpath("//*[@id=\"pt1:r1:2:sor1:_1\"]");

		By HeadMoveAll = By.id("pt1:r1:2:smsShuttle::moveall");

		By DetailsLink = By.linkText("تفاصيل");



		By SuccessMessageInternal = By.id("pt1:r1:3:m1");

		By BackButtonInternal = By.id("pt1:r1:3:b1");

			
	
	// Internal-TakeAction-Director

		By DirectorNavigateOut = By.id("pt1:r1:5:requestStatus::content");

		By DirectorSearchld = By.id("pt1:r1:5:requestNo::content");

		By DirectorSearchBtn = By.id("pt1:r1:5:b1");

		

		By DirectorNotes = By.id("pt1:r1:6:itNotes::content");

		By DirectorProcessBtn = By.id("pt1:r1:6:b4");

		By DirectorApprove = By.xpath("//*[@id=\"pt1:r1:6:sor1:_0\"]");

		By DirectorReject = By.xpath("//*[@id=\"pt1:r1:6:sor1:_2\"]");

		By DirectorMoveAll = By.id("pt1:r1:6:smsShuttle::moveall");

		By DirectorIncomplete = By.xpath("//*[@id=\"pt1:r1:6:sor1:_1\"]");
}
