package MoH;

import org.openqa.selenium.By;

public class AdminField extends Vars{

	// Internal-Login
	By EMPUsername = By.id("pt1:lid1:dc_it1::content");
	By EMPPassword = By.id("pt1:lid1:dc_it2::content");
	By LoginBtn = By.id("pt1:lid1:dc_b1");

// view Request list
	By Applications = By.id("icon3");
	By ViewRequestsandPermits= By.id("icon10");
	By requests= By.id("icon38");
	By allRequests= By.id("icon147");
	By RNVLRequests= By.id("icon148");
	By GPLRequests= By.id("icon149");
	By Permits= By.id("icon39");
	By allPermits=By.id("icon151");
	By RNVLPermits= By.id("icon148");
	By GPLPermits= By.id("icon149");
	

//All Requests
	By RequestNo = By.id("pt1:r1:2:requestNo::content");
	By RequestYear = By.id("pt1:r1:20:requestYear::content");
	By serviceDDL= By.id("pt1:r1:2:serviceType::content");
	By fromDate = By.id("pt1:r1:0:fromDate::content");
	By toDate = By.id("pt1:r1:0:toDate::content");
	By RequestStatus= By.id("pt1:r1:2:requestStatus::content");
	By SearchButton= By.id("pt1:r1:2:b1");
	By ResetButton= By.id("pt1:r1:0:b2");
	By BackButton =By.id("pt1:r1:2:b1");
	By ViewRequestNavigateOut=By.id("pt1:r1:2:serviceType::content");
	By detailsBtn=By.id("pt1:r1:2:pc1:t1:2:l1"); 
	By DetailsLink= By.linkText("تفاصيل");
//RNVL Requests
	By RequestNum= By.id("pt1:r1:2:requestNo::content");
	By yearOfRequest= By.id("pt1:r1:2:requestYear::content");
	By dateFrom= By.id("pt1:r1:4:fromDate::content");
	By dateTo= By.id("pt1:r1:2:toDate::content");
	By Status= By.id("pt1:r1:2:requestStatus::content");
	By Search=By.id("pt1:r1:2:b1"); 		
	By reset=By.id("pt1:r1:0:b2");
	By Details= By.id("pt1:r1:2:pc1:t1:0:l1");
	By Back = By.id("pt1:r1:3:b1");
	By DTL=By.id("pt1:r1:2:pc1:t1:1:l1"); 
	
	
//GPL Requests
 By	RequestNumber= By.id("pt1:r1:2:requestNo::content");
 By year = By.id("pt1:r1:7:requestYear::content");
 By dateFrom1= By.id("pt1:r1:7:fromDate::content");
 By dateTo1=By.id("pt1:r1:7:toDate::content");
 By statusofReq= By.id("pt1:r1:7:requestStatus::content");
 By Search1=By.id("pt1:r1:7:b1");
 By Reset1= By.id("pt1:r1:7:b2");
 By RequestDetails= By.id("pt1:r1:2:pc1:t1:6:l1");
 By back= By.id("pt1:r1:11:r1:0:b2");
 By details=By.id("pt1:r1:2:pc1:t1:3:l1"); // pt1:r1:2:pc1:t1:1:l1
 
 
 // View Permits list 
 By permitsList= By.id("icon39");
 By allPermitsList=By.id("icon151");
 By PermitsRNVLList= By.id("icon152");
 By PermitsGPLList= By.id("icon153");
 By permitsDetails=By.id("pt1:r1:2:pc1:t1:0:l1::text");
 
 // allPermits 
 By permitNo=By.className("xvo");
 By PermitsService= By.xpath("//*[@id=\"pt1:r1:4:serviceName::content\"]");
 By PermitStatus= By.xpath("//*[@id=\"pt1:r1:4:permitStatus::content\"]");
 
 
// Registration management
 By RegistrationList=By.id("icon4");
 By usersList=By.id("icon12");
 By defineUser= By.id("icon42");
 By defineCommittee= By.id("icon43");
 By committeesMangement= By.id("icon45");
 By usersManagement=By.id("icon307");
 By employeesList=By.id("icon46");
 By STKList=By.id("icon47");
 By NCCList=By.id("icon48");
 By RolesList=By.id("icon13");
 By defineRole= By.id("icon49");
 By rolesManagement= By.id("icon50");
 By privilegesList=By.id("icon14");
 By definePrivilege=By.id("icon51");
 By privilegeManagement=By.id("icon52");
 By accessPoliciesList= By.id("icon15");
 By defineAccessPolicy= By.id("icon54");
 By accessPoliciesManagement= By.id("icon55");
 
 
 // Define User Screen 
 By userType= By.id("pt1:r1:2:soc1::content"); 
 By username= By.id("pt1:r1:2:it1::content");  
 By Directorate= By.id("pt1:r1:2:soc2::content");   
 By password= By.id("pt1:r1:2:p1:dc_it1::content");  
 By arFirstName= By.id("pt1:r1:2:it2::content");  
 By arSecondName= By.id("pt1:r1:2:it3::content"); 
 By arThirdName= By.id("pt1:r1:2:it4::content");
 By arFourthName= By.id("pt1:r1:2:it5::content");
 By enFirstName= By.id("pt1:r1:2:it6::content");
 By enSecondName= By.id("pt1:r1:2:it7::content");
 By enThirdName= By.id("pt1:r1:2:it8::content");
 By enFourthName= By.id("pt1:r1:2:it9::content");
 By phoneNum=By.id("pt1:r1:2:mn1:itMobileNumber::content");
 By CountryCode= By.id("pt1:r1:2:mn1:dc_soc1::content");       
 By email=By.id("pt1:r1:2:e1:itEmail::content");  
 By AccessPolicyField= By.id("pt1:r1:2:soc3::content");
 By TimePolicyField= By.id("pt1:r1:2:soc4::content"); 
 By defaultLanguage=By.id("pt1:r1:2:soc8::content");
 By userStatus= By.id("pt1:r1:2:soc5::content");
 By RequiredMessagesCheckbox= By.id("pt1:r1:2:sbc1::content");
 By RequiredMailCheckbox=By.id("pt1:r1:2:sbc2::content");
 By SelectRole= By.xpath("//*[@id=\"pt1:r1:2:sms2::leadUl\"]/li[1]");
 By moveButton= By.className("x11y");
 By CreateButton=By.id("pt1:r1:2:b1");  
 By Create=By.xpath("//*[@id=\"pt1:r1:2:b1\"]/a/span");
 
 By UsernameNationalNo=By.id("pt1:r1:2:it11::content"); 
 By nationalNo=By.id("pt1:r1:2:it12::content");
 By address=By.id("pt1:r1:2:it13::content");
 By institueName=By.id("pt1:r1:2:it10::content");

		 
 //Define Committee screen 
By ArCommitteeName= By.id("pt1:r1:2:it1::content"); 

By EnCommitteeName= By.id("pt1:r1:2:it2::content");
By directorate= By.id("pt1:r1:2:soc1::content");    
By defaultCommittee=By.id("pt1:r1:2:sbc1::content");
By selectMember1=By.xpath("//*[@id=\"pt1:r1:2:sms1::leadUl\"]/li[1]");
By selectMember2=By.xpath("//*[@id=\"pt1:r1:2:sms1::leadUl\"]/li[2]");
By MoveButton=By.id("pt1:r1:2:sms1::move"); //pt1:r1:3:sms1::move


// Committees Management screen 
By CommitteeDir=By.id("pt1:r1:2:qryId1:val20::content");
By CommiteeARname=By.id("pt1:r1:2:qryId1:val10::content");   
By detailsLink= By.xpath("//*[@id=\"pt1:r1:2:t1:0:l1::text\"]"); 
By Searchbtn=By.id("pt1:r1:2:qryId1:_search");  
By updatebtn= By.id("pt1:r1:3:b2");  
By updtArcommittee= By.xpath("//*[@id=\"pt1:r1:3:it1::content\"]");
By updtENcommittee= By.xpath("//*[@id=\"pt1:r1:3:it2::content\"]");
By directorateDDL=By.xpath("//*[@id=\"pt1:r1:3:soc1::content\"]");
By defaultCheckbox=By.xpath("//*[@id=\"pt1:r1:3:sbc1::content\"]");
By DirectorateMember1=By.xpath("//*[@id=\"pt1:r1:3:sms2::leadUl\"]/li[1]");
By DirectorateMember2=By.xpath("//*[@id=\"pt1:r1:3:sms2::leadUl\"]/li[2]/label");
By move=By.xpath("//*[@id=\"pt1:r1:3:sms2::move\"]");
By savebtn=By.id("pt1:r1:3:b3"); 			


// users management -Employees screen 
By empDirectorate=By.id("pt1:r1:2:qryId1:val00::content");
By EmpPhoneNum=By.id("pt1:r1:2:qryId1:val20::content");
By EmpEmail= By.id("pt1:r1:2:qryId1:val10::content"); 
By EmpUsername=By.id("pt1:r1:2:qryId1:val30::content");
By empdtl=By.id("pt1:r1:2:t1:10:l1::text");
By empUpdtbtn= By.id("pt1:r1:3:b3");
By updateDir= By.xpath("//*[@id=\"pt1:r1:3:soc2::content\"]");
By ARfirstNameUpdt=By.xpath("//*[@id=\"pt1:r1:3:it2::content\"]");  
By ARsecondNameupdt=By.xpath("//*[@id=\"pt1:r1:3:it3::content\"]");
By ARthirdNameupdt=By.xpath("//*[@id=\"pt1:r1:3:it4::content\"]");
By ARfourthNameupdt=By.xpath("//*[@id=\"pt1:r1:3:it5::content\"]");
By EnfirstNameupdt=By.xpath("//*[@id=\"pt1:r1:3:it6::content\"]");
By EnsecondNameupdt= By.xpath("//*[@id=\"pt1:r1:3:it7::content\"]");
By EnthirdNameupdt=By.xpath("//*[@id=\"pt1:r1:3:it8::content\"]");
By EnfourthNameupdt= By.id("pt1:r1:3:it9::content");
By phoneNumupdt=By.id("pt1:r1:3:mn1:itMobileNumber::content");
By countryCodeupdt=By.xpath("//*[@id=\"pt1:r1:3:mn1:dc_soc1::content\"]");
By updateEmail=By.id("pt1:r1:3:e1:itEmail::content");
By updtAccessPolicy=By.id("pt1:r1:3:soc3::content");
By updtTimePolicy= By.id("pt1:r1:3:soc4::content");
By updtUserStatus=By.id("pt1:r1:3:soc5::content");
By updtDefaultLanguage=By.id("pt1:r1:3:soc8::content");
By updateRequiredEmail= By.id("pt1:r1:3:sbc1::content");
By updarteRequiredSMS= By.id("pt1:r1:3:sbc2::content");
By updateRole= By.xpath("//*[@id=\"pt1:r1:3:sms1::leadUl\"]/li[1]");
By movebtn=By.id("pt1:r1:3:sms1::move");  
By saveBtnafterUpdate = By.id("pt1:r1:3:b4");
By Reset=By.id("pt1:r1:4:qryId1:_reset");  


// User management stk
By emailField= By.id("pt1:r1:2:qryId1:val00::content");
By userNameField= By.id("pt1:r1:2:qryId1:val20::content");
By PhoneNumField=By.id("pt1:r1:2:qryId1:val10::content");   
By searchButton=By.id("pt1:r1:2:qryId1:_search"); 
By Detail= By.xpath("//*[@id=\"pt1:r1:2:t1:0:l1::text\"]"); 
By updtbutton = By.id("pt1:r1:3:b3"); 
By saveButton= By.id("pt1:r1:3:b4"); 
By backBtn= By.id("pt1:r1:3:b2");
By activeRadioButton=By.id("pt1:r1:2:sorIsActive:_0");
By Procedure=By.xpath("//*[@id=\"pt1:r1:3:sms3::leadUl\"]/li[1]");
By SelectProcedure=By.id("pt1:r1:3:sms3::move");



By successMessage=By.xpath("//*[@id=\"pt1:exceptionMsg\"]/div/table/tbody/tr/td/table/tbody/tr/td[2]");


// User management NCC
By NCCusername= By.id("pt1:r1:2:qryId1:val00::content");
By NCCPhone= By.id("pt1:r1:2:qryId1:val20::content");
By NCCUpdatedPhone=By.xpath("//*[@id=\"pt1:r1:3:mn1:itMobileNumber::content\"]");
By LinkDetails=By.id("pt1:r1:2:t1:2:l1::text");

//roles definition
By ArabicRoleName= By.id("pt1:r1:2:it2::content");
By EnglishRoleName=By.id("pt1:r1:2:it3::content");
By RoleUserType= By.id("pt1:r1:2:soc1::content");  
By activeRole=By.id("pt1:r1:2:sbc2::content");
By pagesItem= By.xpath("//*[@id=\"pt1:r1:2:sms1::leadUl\"]/li[1]/label");
By MoveItem= By.id("pt1:r1:2:sms1::move");
By selectedPages= By.xpath("//*[@id=\"pt1:r1:2:sms1::trailUl\"]/li/label");
By remove=By.id("pt1:r1:2:sms1::remove");
By TasksItem=By.xpath("//*[@id=\"pt1:r1:2:sms2::leadUl\"]/li[2]/label");
By moveTask=By.xpath("//*[@id=\"pt1:r1:2:sms2::move\"]");
By CreateRoleBtn=By.id("pt1:r1:2:b1");

// Role Management
By MOVEOUT=By.id("pt1:r1:22:qryId1:val00::content");
By page4=By.id("pt1:r1:22:t1:4:l1::text");
By RolesDetails=By.id("pt1:r1:2:t1:0:l1::text");
By uptBtnRole=By.id("pt1:r1:3:b3"); //
By updtUserType= By.id("pt1:r1:3:soc1::content");
By ProcedureArabicName=By.id("pt1:r1:2:qryId1:val00::content");
By SearchRole=By.id("pt1:r1:2:qryId1:_search");
By RolepagesItem=By.xpath("//*[@id=\"pt1:r1:3:sms4::leadUl\"]/li[2]/label");
By MoveRole=By.id("pt1:r1:3:sms4::move");


// privilege Definition'
By privilegeType=By.id("pt1:r1:2:socPrivType::content");
By pageDescription= By.id("pt1:r1:2:soc2::content");
By savePrivilege= By.id("pt1:r1:2:b1");  


// Privilege Management

By pageDesc=By.id("pt1:r1:2:qryId1:val00::content");
By save=By.id("pt1:r1:2:qryId1:_search");
By PrivilegeDetails=By.id("pt1:r1:2:t1:0:l1::text"); 
By checkbox=By.id("pt1:r1:3:sbc1::content");


// Policies 
By policyType=By.id("pt1:r1:2:soc1::content");
By userTypeDDl=By.id("pt1:r1:2:soc2::content");
By arPolicyName=By.id("pt1:r1:2:it3::content");
By enPolicyName=By.id("pt1:r1:2:it4::content");
By activePolicy=By.id("pt1:r1:2:sbc1::content");
By MinimumtrialTime=By.id("pt1:r1:2:ins1::content");
By MaximumTrials=By.id("pt1:r1:2:ins2::content");
By ValidationCodeSimulation=By.id("pt1:r1:2:it1::content");
By ValidationCodeExpiry=By.id("pt1:r1:2:it5::content");
By ValidationCodeLength=By.id("pt1:r1:2:ins3::content");
By CodesendingTimes=By.id("pt1:r1:2:ins4::content");
By minimumPasswordlength=By.id("pt1:r1:2:it6::content");
By maximumPasswordLength=By.id("pt1:r1:2:it7::content");
By CapitalLetters=By.id("pt1:r1:2:sbc5::content");


 //System management List 
By SystemManagementList=By.id("icon5");
By services= By.id("icon16");
By servicesManagement=By.id("icon56");
By serviceFees= By.id("icon228");  
By addFeestoaService=By.id("icon232");
By manageServiceFeees=By.id("icon233");
By ServiceAttachments=By.id("icon229");
By AddServiceAttachment=By.id("icon234");
By serviceAttachmentManagement=By.id("icon236");
By systemLists=By.id("icon17");
By Notifications=By.id("icon18");
By systemSettings=By.id("icon19");
By systemEscalations=By.id("icon167");
By EscalationsManagement=By.id("icon186");
By ExecuteServices= By.id("icon308");
By ExecuteServicesManagement= By.id("icon57");
By ReasonofRejectionandIncompleteRequests=By.id("icon227");
By addReasonsofRejectionandIncompleteRequests=By.id("icon230");
By rejectionandIncompleteRequestsManagement=By.id("icon231");

// add fees
By FeesType=By.id("pt1:r1:2:soc2::content");
By ServiceDDL=By.id("pt1:r1:2:soc1::content");
By accountNumber=By.id("pt1:r1:2:it3::content");
By internationlAccountNumber=By.id("pt1:r1:2:it4::content");
By value=By.id("pt1:r1:2:it2::content");
By DateFrom= By.id("pt1:r1:2:id1::content");
By DateTo=By.id("pt1:r1:2:id2::content");

//Fees Magament
By FeeType=By.id("pt1:r1:2:qryId1:val00::content");
By FeeDetails=By.id("pt1:r1:2:resId1:0:l1::text");
By updatedValue=By.id("pt1:r1:3:it2::content");
By SaveFeesUpdate=By.id("pt1:r1:3:b1");
By updateEndingDate= By.id("pt1:r1:3:id2::content");

// Attachment
By attachmentType=By.xpath("//*[@id=\"pt1:r1:2:soc1::content\"]");  	
By applicantType=By.id("pt1:r1:2:soc2::content");
By serviceType=By.id("pt1:r1:2:soc3::content");
By activeAttachment=By.id("pt1:r1:2:sbc1::content");
By requiredAttachemnt=By.id("pt1:r1:2:sbc2::content");


// Attachment Management
By attachmentSelection=By.id("pt1:r1:3:soc1::content");
By ResetRolesField=By.id("pt1:r1:2:qryId1:_reset");
By AttachmentDetails=By.id("pt1:r1:2:resId1:0:l1::text");
By outofMenu=By.xpath("//*[@id=\"pt1:ol1\"]/label");
By applicantTypeUpdt=By.id("pt1:r1:3:soc2::content");
By checkboxActive=By.id("pt1:r1:3:sbc1::content");
By Required=By.id("pt1:r1:3:sbc2::content"); 
By serviceUpdt=By.id("pt1:r1:3:b2");
By updtAttachmentType=By.id("pt1:r1:3:soc1::content");
By updtApplicantType=By.id("pt1:r1:3:soc2::content");
By updtServiceType=By.id("pt1:r1:3:soc3::content");
By saveUpdates=By.id("pt1:r1:3:b1");



// Notifications 
By NotificationDetails=By.xpath("//*[@id=\"pt1:r1:2:t1:1:l1::text\"]");

// System settings
By SettingName= By.id("pt1:r1:2:qryId1:val00::content");
By SettingDetails=By.id("pt1:r1:2:resId1:3:l1::text");
By SettingARDescription=By.id("pt1:r1:3:it2::content");
By SettingENDescription=By.id("pt1:r1:3:it3::content");
By SettingsValue=By.id("pt1:r1:3:it4::content");

// Services Execution management
By ExecutionDetails=By.id("pt1:r1:2:resId1:0:l1::text");

//add Reasons of Rejection and Incomplete Requests
By serviceName= By.id("pt1:r1:2:soc1::content");
By step=By.id("pt1:r1:2:soc2::content");
By Reason=By.id("pt1:r1:2:soc3::content");

//Content Management
By ContentManagementList= By.id("icon6");
By serviceCardList= By.id("icon21");
By FAQsList=By.id("icon23");
By addNewFAQ=By.id("icon122");
By FAQManagement=By.id("icon123");
By Evaluations=By.id("icon24");
By SystemMessages=By.id("icon25");
By ValidationServicesMenues=By.id("icon26");
By Generalizations=By.id("icon106");
By GeneralizationsManagements=By.id("icon125");
By addNewGeneralization=By.id("icon126");

// Service cards
By service=By.id("pt1:r1:2:soc1::content");
By ContentDetails=By.id("pt1:r1:2:t1:3:l1::text");
By OrdrOfCard=By.id("pt1:r1:3:ins1::content");
By CardARtitle=By.id("pt1:r1:3:it10::content");
By ARDescriptionTextArea=By.xpath("//*[@id=\"pt1:r1:3:of1::_cic\"]");
By Text=By.xpath("/html/body/table/tbody/tr/td");

// Add new FAQ
By QuestionOrder=By.id("pt1:r1:2:ins1::content");
By QuestionUserType=By.id("pt1:r1:2:soc1::content");
By ArQuestion=By.id("pt1:r1:2:of1::_cic");
By ARAnswer=By.id("pt1:r1:2:of3::_cic");
By ENQuestion=By.id("pt1:r1:2:rte1::_cic");
By EnAnswer=By.id("pt1:r1:2:rte2::_cic");
By saveFAQ=By.id("pt1:r1:2:b3");

// FAQ Management

//ServicesValidationMenues
By ListDetails=By.id("pt1:r1:2:resId1:0:l1::text");
By item=By.id("pt1:r1:2:resId1:0:resId1c5");
By recordNumOfService=By.id("pt1:r1:3:ins1::content");

// Generalization 
By generalizationARTitle=By.id("pt1:r1:3:it5::content");
By generalizationARDesc=By.id("pt1:r1:3:it3::content");
By generalizationENTitle=By.id("pt1:r1:3:it6::content");
By generalizationENDesc=By.id("pt1:r1:3:it4::content");

// Add Generalizations 
By arTitle=By.id("pt1:r1:2:it5::content");
By arDesc=By.id("pt1:r1:2:it3::content");
By enTitle=By.id("pt1:r1:2:it6::content");
By enDesc=By.id("pt1:r1:2:it4::content");
By generalizationDate=By.id("pt1:r1:2:id1::content");
By activeGeneralizations=By.id("pt1:r1:2:sbc1::content");

// System Messages Management
By msgCode=By.xpath("//*[@id=\"pt1:r1:2:resId1:0:resId1c1\"]");
By Dtl= By.xpath("//*[@id=\"pt1:r1:2:resId1:0:l1::text\"]");
By TextArea=By.id("pt1:r1:3:it5::content");

}
