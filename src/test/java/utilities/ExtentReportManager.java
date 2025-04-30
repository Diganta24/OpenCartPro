package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String rName;
	public void onStart(ITestContext textContext) {
		String tiemStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		rName="Test-Report"+tiemStamp+".html";
		sparkReporter =new ExtentSparkReporter(".\\reports\\"+rName);
		sparkReporter.config().setDocumentTitle("opencart Automation Report");
		sparkReporter.config().setReportName("opencart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application","opencart" );
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Sub Module","Customers");
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt","QA");
		String os=textContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System",os);
		String br=textContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser",br);
		List<String> includedGroups=textContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups",includedGroups.toString());
		}
		}
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"got Successfully executed");
	}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+" got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		try {
			String ImgPath=new BaseClass().captuerScreen(result.getName());
			test.addScreenCaptureFromPath(ImgPath);
		}
		catch(IOException e1) {
			e1.printStackTrace();
		}
	 			
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+" got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	public void onFinish(ITestContext textContext)
	{
		extent.flush();
		String pathOfExtReport =System.getProperty("user.dir")+"\\reports\\"+rName;
		File extentReport=new File(pathOfExtReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	

}
