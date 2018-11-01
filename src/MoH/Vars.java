package MoH;

import org.openqa.selenium.JavascriptExecutor;

public class Vars extends Msgs{
	public static String AppNo, NationalIDValue, IDNumberValue, year, KeepAppNo;
	//Internal Users
	String CapitalUserName1 = "MOH-ESRAA";
	String CapitalPassword1 = "12345";
	String CapitalUserName2 = "MOH-ADMIN";
	String CapitalPassword2 = "Aa@123";
	
	String IrbidUserName1 = "MOH-Razan";
	String IrbidPassword1 = "12345";
	String IrbidUserName2 = "MOH-MOE1";
	String IrbidPassword2 = "12345";
	String IrbidUserName3 = "MOH-FERAS";
	String IrbidPassword3 = "12345";
	
	String JPAUserName = "STK-ESS";
	String JPAPassword = "Ee@123";
	Integer Round;
	String DecisionStep;
	
	//Drivers
	String ChromeDriver = "C:\\Users\\hrasheed\\Downloads\\chromedriver.exe";
	String IEDriver = "C:\\Users\\hrasheed\\Desktop\\IEDriverServer.exe";
	String MyFirefoxDriver = "C:\\Users\\hrasheed\\Desktop\\geckodriver.exe";
	
	//Attachments
	String JPGAtt = "C:\\Users\\hrasheed\\Desktop\\attachemnts\\Uploader.exe";
	String JPEG18Att = "C:\\Users\\hrasheed\\Desktop\\attachemnts\\1.6.0.0_2 - jpeg\\Uploader2.exe";
	String PNGAtt = "C:\\Users\\hrasheed\\Desktop\\attachemnts\\1.6.0.0_3-PNG\\Uploader.exe";
	String JPG199Att = "C:\\Users\\hrasheed\\Desktop\\attachemnts\\1.6.0.0_5-jpg\\Uploader.exe";
	String DocAtt = "C:\\Users\\hrasheed\\Desktop\\attachemnts\\1.6.0.0_8-doc\\Uploader.exe";
	String ZipAtt = "C:\\Users\\hrasheed\\Desktop\\attachemnts\\1.6.0.0_9-zip\\Uploader.exe";
	String ExeAtt = "C:\\Users\\hrasheed\\Desktop\\attachemnts\\1.6.0.0_10-exe\\Uploader.exe";
	String GIFAtt = "C:\\Users\\hrasheed\\Desktop\\attachemnts\\1.6.0.0_11-gif\\Uploader.exe";
	String JPGLarge = "C:\\Users\\hrasheed\\Desktop\\attachemnts\\1.6.0.0_12-JPG - large\\Uploader.exe";
	
	//URLS-Staging
//	String ExternalTesting = "http://test-soa:7003/public/index.html";
//String InternalTesting = "http://test-soa:7003/internal/faces/index.jsf";
	
	//URLS-Testing
	//String ExternalTesting = "http://soa-vip:7003/public/index.html";
	//String InternalTesting = "http://soa-vip:7003/internal/faces/index.jsf";

// URLS- Production 
String ExternalTesting = "http://10.160.95.35:7003/public/";
String InternalTesting = "http://10.160.95.35:7003/internal/faces/index.jsf";
	
  

	String ComplainText = "ارسال شكوى ارسال شكوى ارسال شكوى ارسال شكوى";
	String RMS = "الخدمات الطبية الملكية";
	String HealthCare = "مؤسسة صحية";
	String Individual = "أفراد";
	String Compnay = "شركة";
	
	String RateSad = "حزين";
	String RateHappy = "سعيد";
	String RateNeutral = "محايد";

	String DDLJordan = "الأردن";
	String DDLJordanUni = "الجامعة الاردنية";
	String DDLMoutaUni = "جامعة مؤته";
	String DDLFrance = "فرنسا";
	String DDLMuna = "كلية الاميرة منى للتمريض";
	String DDLFrenchUni ="Centre International de Recontre Mathematiques";
	String DDLTunisia = "تونس";
	String DDLSousaUni = "جامعة سوسة";
	String DDLIraq = "العراق";
	String TakreetUni = "جامعة تكريت";
	String DDLKuwait = "الكويت";
	String DDLKuwaitUni = "جامعة الكويت";
	String DDLJust = "جامعة العلوم والتكنولوجيا الأردنية";
	String DDLEgypt = "مصر";
	String CairoUni = "جامعة القاهرة";
	String QueryText = "نص الرسالة نص الرسالة نص الرسالة نص الرسالة";
	String SuggestionText = "ارسال اقتراح ارسال اقتراح ارسال اقتراح ارسال اقتراح";
	String FillMobileNumber = "797352297";
	String FillEmailAddress = "hrasheed@optimizasolutions.com";
	String FillAddress = "Optimiza Solutions";
	
//RNVL Request status
	String NewWaitingForHeadRNVL="جديد بإنتظار قرار رئيس القسم";
	String IncompleteHeadRNVL="إستكمال نواقص رئيس القسم";
	String UpdatedRequestHeadRNVL="طلب معدل رئيس القسم";
	String RejectedRequestHeadRNVL="مرفوض من رئيس القسم";
	String AuditedRequestWaitingforDirectorDecisionRNVL="مدقق بإنتظار قرار مدير المديرية";
	String IncompleteRequestDirectorRNVL="إستكمال نواقص مدير المديرية";
	String UpdatedRequestDirectorRNVL="طلب معدل مدير المديرية";
	String RejecetedRequestDirectorRNVL="مرفوض من مدير المديرية";
	String RequestWaitingforMOIDecisionRNVL="موافقة مدير المديرية بانتظار قرار الداخلية";
	String IncompleteRequestMOIRNVL="إستكمال نواقص الداخلية";
	String UpdatedRequestMOIRNVL= "طلب معدل الداخلية";
	String RejectedByMOIRequestRNVL="مرفوض من وزارة الداخلية";
	String contactMOIRNVL="مراجعة وزارة الداخلية";
	String FinalApprovalRNVL="موافقة نهائية";
	String IssuedPermitsRNVL= "تم أصدار الرخصة";
	
//GPL Request Status 
	String NewWaitingforAuditorDecisionGPL= "جديد بإنتظار قرار المدقق";
	String IncompleteRequestAuditorGPL= "إستكمال نواقص المدقق";
	String UpdatedRequestAuditorGPL= "طلب معدل المدقق";
	String RejectedRequestByAuditorGPL="مرفوض من المدقق";
	String AuditedRequestWaitingforJPAGPL ="مدقق بإنتظار قرار النقابة";
	String IncompleteRequestJPAGPL="إستكمال نواقص النقابة";
	String UpdatedRequestJPLGPA="طلب معدل النقابة";
	String RejectedByJPAGPL="مرفوض من النقابة";
	String WaithingforInspectionCommitteeGPL="موافقة مجلس النقابة بانتظار قرار لجنة الكشف";
    String RejectedbyInspectionCommitteeGPL= "إستكمال نواقص لجنة الكشف";
    String updatedRequestInspectionCommitteeGPL="طلب معدل لجنة الكشف";
    String AppointmentForInspectionCommitteeGPL="تحديد موعد الكشف الميداني";
    String RejectedByInspectionCommitteewithRejectionGPL="مرفوض من لجنة الكشف مع إمكانية الإعتراض";
    String WaitingForDirectorDecisionGPL= "موافقة لجنة الكشف بانتظار قرار مدير المديرية";
    String WaitingForPaymentGPL="بانتظار الدفع";
    String canceledRequestJPAGPL ="ملغي بعد تأخر النقابة و اعلام مقدم الطلب";
    String canceledRequestApplicantGPL="ملغي بعد تأخر مقدم الطلب و اعلامه";
    String FinalApprovalGPL="موافقة نهائية";
    String issuedPermitsGPL="تم اصدار الرخصة";
    String RejectedByInspectionCommitteeGPL= "مرفوض من لجنة الكشف";
    
    
	//Services 
	String RNVL="مزاولة مهنة ممرض قانوني";
	String GPL= "ترخيص صيدلية عامة";
	
	// Permits statuses 
	String ActivePermit="فعالة";
	String UnactivePermit ="ملغاة";
	
	
	// User Types
	String MOHuser="موظف صحة";
	String healthInstitute="مؤسسة صحية";
	String STKuser="شريك خدمة - نقابة الصيادلة";
	String NCCuser="مركز الاتصال الوطني";
	String RMSUser="الخدمات الطبية الملكية";
	
	//Applicant types
	String individualPharamcist="صيدلاني واحد";
	String multiplePharmacists="أكثر من صيدلاني واحد";
	String BranchofPharamacies="فرع لسلسلة صيدليات";
	String Jordanian="أردني";
	
	//// Comment 
	
	// Directorates
	String MainCenter= "المركز الرئيسي";
	String Capital="العاصمة";
	String IrbidDirectory="اربد";
	String Balqaa="البلقاء";
	String RoyalCourt="الديوان الملكي";
	String PrimeMinister= "رئاسة الوزراء";
	String Parliament="مجلس الأمه";
	
	// Country Codes
	String Codeno1="+1";
	String CodeNo2="+962";
	String CodeNo3="+90";
	
	// Access Policies DDL 
	String DefaultPolicy= "السياسة الإفتراضية للوصل الى النظام";
	String ViewOnlyPolicy= "الاطلاع على الطلبات ";
	
	// Time Policy DDL
	String MOHDefualtTiming= "الجدول الإفتراضي للمستخدمين من نوع داخلي موظف صحة";
	String DefaultEscalationSteps="الجدول الإفتراضي لتصعيدات خطوات الخدمات الإلكترونية";
	String policyA = "سياسة أ";
	String STKPolicy= "الجدول الإفتراضي للمستخدمين من نوع نقابة الصيادلة";
	String NCCPolicy="الجدول الإفتراضي للمستخدمين من نوع مركز الإتصال الوطني";
	
	// Langauges
	String Arabic="العربية";
	String English="الإنجليزية";
	
	// Create User -   MOH Fields contents
	String userNameContent="user";
	String newuserNameContent="user";
	String PasswordContent="Aa@123";
	String IcorrectPasswordContent="aaa";
	String arFirstNameContent= "مستخدم";
	String arSecondNameContent="نظام";
	String arThirdNameContent="الصحة";
	String arFourthNameContent="تجربة";
	
	String enFirstNameContent="TEST";
	String enSecondNameContent="health";
	String enThirdNameContent="Mininstry";
	String enFourthNameContent= "USER";
	String PhoneNumContent="0797078728"; 
	String emailContent="hrasheed@optimizasolutions.com";
	
	// Create NCC User Fields content 
	//User status DDL
	String unactiveStatus="غير فعال";
	String activeStatus="فعال";
	String DisabledStatus="معلق";
	
	// Create user Health Institute
	String Username_NationalNoContent="200368859";	
		
	String AddressContent="Amman , Jordan";
	
	
// RMS 
	String Institute= "مؤسسة أ";
	String NationalNumberContent="208888555";

// Define new Committee & Committees managements
String	ArCommitteeNameContent="لجنة ي";
String  EnCommitteeNameContent= "D Committee";

String ArCommitteeNameContentUpdate= "لجنة عاصمة عمان";
String  EnCommitteeNameContentUpdate= "Amman Capital Committee";

// 	Users management 
String EmpPhoneNumContent="79999999999999";
String EmpEmailContent="a@b.com";
String EmpUsernameContent="xyz";
String updtPhonenum="0790999099";
String updtEmail="d@e.com";


// NCC user management 

String NCCusernameContent="NCC-KJL";

	
// Define new Role
String ArabicRoleNameContent="اتخاذ اجراءات";
String EnglishRoleNameContent="Procedures Execution";

// Privilege type
String Page="الصفحة";
String Procedure="إجراء";

// Policies 
String accessPolicy="سياسة الوصول";
String timePolicy="سياسة الوقت";
String PolicyArName="سياسة ب";
String PolicyEnName="Policy B";

// Page selection list options
String description1 ="إتخاذ الإجراء - ترخيص صيدلية عامة - المرفوضة من لجنة الكشف";
String description2="إدارة مرفقات الخدمة";
String description3="الطلبات المتعطلة - مزاولة مهنة ممرض قانوني - من قبل متلقي الخدمة";

// Fees screen
String LicenseFees="رسوم ترخيص";
String AssociationFees="رسوم نقابة";
String accountNumberContent="4475221070148777";
String internationlAccountNumberContent="4475";
String valueContent="10000"; 
String StartingDate="7-10-2018";
String EndingDate="7-10-2019";


// Attachment types
String Passportcopy="صورة عن جواز السفر";
String  PersonalPhoto="صورة شخصية";
String SecondaryCertificatecopy="صورة عن شهادة الثانوية العامة";
String RentContractPhoto="صورة عن عقد إيجار";

// System settings 
String SettingArName="Ghassan Code";
String SettingARDescriptionContent="GhassanCode";
String SettingENDescriptionContent="GhassanCode";
String SettingsValueContent="12345";

//Rejection Reasons
String NationalityReason="الجنسية لا تسمح";
String UnauthorizedUniversity="الجامعة غير معترف بها";
String MissingSecondaryCertificate ="تحميل شهادة الثانوية العامة";
String MissingBAcertificate="تحميل شهادة البكالوريوس";
String MustAttend="حضور شخصي";
String InvalidNCRC="شهادة عدم المحكومية غير صحيحة";
String lowResolutionofPersonalPic="تحميل صورة شخصية اوضح";
String ExpiredPasspport="جواز السفر منتهي الصلاحية";
String CardARtitleContent="معلومات عامة";
String ARDescriptionTextAreaContent="تستهدف هذه الخدمة الحاصلين على شهادة البكالوريوس في التمريض الراغبين في\r\n" + 
		"الحصول على تصريح مزاولة مهنة ممرض قانوني";
String AddARDescriptionTextAreaContent="\b بطاقة معلومات عامة\n";

String Order="4";
String OutOfOrder="6";

// QUESTIONS user type
String internalUser="داخلي"; 
String ExternalUser="خارجي";
String stakeholder="شريك خدمة";
String ArQuestionContent="من أي قائمة يتم تعريف الصلاحيات";
String ARAnswerContent="يتم تعريف الصلاحيات من قائمة ادارة التسجيل";
String ENQuestionContent="From which menu privileges are defined";
String EnAnswerContent="Privileges are defined from Registration menu";
String frameID="afr::PushIframe";
String generalizationARTitleContent="تعميم عطلة";
String generalizationARDescContent="نوفمبر 20الثلاثاء المولد النبوي الشريف";
String generalizationENTitleContent="Eid Vacation";
String generalizationENDescContent="November 30th Tuesday prophit Birth";
String Date="1-11-2018";

// validation Lists of system 
String noOfRecord="1";
String Content="تم اصدار رخصة صيدلية عامة للطلب رقم ([REQUEST_NO] / [REQUEST_YEAR]). يمكنك استعراض الرخصة من خلال البوابة الإلكترونية لوزارة الصحة.";


}