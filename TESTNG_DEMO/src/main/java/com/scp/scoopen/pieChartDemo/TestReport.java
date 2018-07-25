package com.scp.scoopen.pieChartDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestReport implements ITestListener {
	
	int apass =0;
	int afail =0;
	int askipped =0;

	public void onFinish(ITestContext arg0) {
		
		System.out.println("Passed cases ="+ apass);
		System.out.println("Fail cases =" + afail);
		System.out.println("skipped cases =" + askipped);
		DemoReportPieChart.pieChartReport(apass, afail, askipped);
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		afail++ ;
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		askipped++;
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		apass++;
	}

}
