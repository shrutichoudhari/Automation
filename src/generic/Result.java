package generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Result  extends BaseTest  implements ITestListener,IAutoConst  {
	public static int passCount = 0,failCount = 0;
	public void onTestSuccess(ITestResult result) {
		passCount++;
	}
	public void onTestFailure(ITestResult result) {
		failCount++;
		String P = Utility.getphoto(driver, PHOTO_PATH);
		Reporter.log("Photo:"+P, true);
		}
	@Override
	public void onFinish(ITestContext arg0) {}
	
	@Override
	public void onStart(ITestContext arg0) {}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {}
	
	@Override
	public void onTestSkipped(ITestResult arg0) {}

	@Override
	public void onTestStart(ITestResult arg0) {}
	
	

}
