package com.listeners;

import com.extentreports.ExtentReport;
import driver.Driver;
import org.testng.*;

public class Listeners implements ITestListener, ISuiteListener {

    public Listeners(){

    }

    @Override
    public void onStart(ISuite suite) {
        try{
            ExtentReport.initReport();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        try{
            ExtentReport.flushReports();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
       ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport.test.pass("Test Passed");
        Driver.getdriver.quit();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReport.test.fail(result.getThrowable());
        Driver.getdriver.quit();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReport.test.skip("Test Skipped");
        Driver.getdriver.quit();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
