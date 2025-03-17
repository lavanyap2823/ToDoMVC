package com.extentreports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class ExtentReport {

    private ExtentReport() {
    }

    public static ExtentReports extent;
    public static ExtentTest test;
    static ExtentSparkReporter spark;

    public static void initReport() throws IOException {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation  Report");
        spark.config().setReportName("ToDo Report");
        spark.loadXMLConfig("src/test/resources/extent-config.xml");
        extent.attachReporter(spark);
    }


    public static void flushReports() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("index.html").toURI());
    }

    public static void createTest(String testName){
        test = extent.createTest(testName);
        ExtentManager.setExtentTest(test);
    }


}
