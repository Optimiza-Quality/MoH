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
	String ChromeDriver = "C:\\Users\\emasoud\\Desktop\\chromedriver2.35.exe";
	String IEDriver = "C:\\Users\\emasoud\\Desktop\\IEDriverServer.exe";
	String MyFirefoxDriver = "C:\\Users\\emasoud\\Desktop\\geckodriver.exe";
	
	//Attachments
	String JPGAtt = "C:\\Users\\emasoud\\Desktop\\attachemnts\\Uploader.exe";
	String JPEG18Att = "C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_2 - jpeg\\Uploader2.exe";
	String PNGAtt = "C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_3-PNG\\Uploader.exe";
	String JPG199Att = "C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_5-jpg\\Uploader.exe";
	String DocAtt = "C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_8-doc\\Uploader.exe";
	String ZipAtt = "C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_9-zip\\Uploader.exe";
	String ExeAtt = "C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_10-exe\\Uploader.exe";
	String GIFAtt = "C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_11-gif\\Uploader.exe";
	String JPGLarge = "C:\\Users\\emasoud\\Desktop\\attachemnts\\1.6.0.0_12-JPG - large\\Uploader.exe";
	
	//URLS-Staging
	//String ExternalTesting = "http://test-soa:7003/public/index.html";
	//String InternalTesting = "http://test-soa:7003/internal/faces/index.jsf";
	
	//URLS-Testing
	String ExternalTesting = "http://soa-vip:7003/public/index.html";
	String InternalTesting = "http://soa-vip:7003/internal/faces/index.jsf";
	
  

	String ComplainText = "����� ���� ����� ���� ����� ���� ����� ����";
	String RMS = "������� ������ �������";
	String HealthCare = "����� ����";
	String Individual = "�����";

	String RateSad = "����";
	String RateHappy = "����";
	String RateNeutral = "�����";

	String DDLJordan = "������";
	String DDLJordanUni = "������� ��������";
	String DDLMoutaUni = "����� ����";
	String DDLFrance = "�����";
	String DDLMuna = "���� ������� ��� �������";
	String DDLFrenchUni ="Centre International de Recontre Mathematiques";
	String DDLTunisia = "����";
	String DDLSousaUni = "����� ����";
	String DDLIraq = "������";
	String TakreetUni = "����� �����";
	String DDLKuwait = "������";
	String DDLKuwaitUni = "����� ������";
	String DDLJust = "����� ������ ������������ ��������";
	String DDLEgypt = "���";
	String CairoUni = "����� �������";
	String QueryText = "�� ������� �� ������� �� ������� �� �������";
	String SuggestionText = "����� ������ ����� ������ ����� ������ ����� ������";
	String FillMobileNumber = "797352297";
	String FillEmailAddress = "emasoud@optimizasolutions.com";
	String FillAddress = "Optimiza Solutions";

	
	
}
