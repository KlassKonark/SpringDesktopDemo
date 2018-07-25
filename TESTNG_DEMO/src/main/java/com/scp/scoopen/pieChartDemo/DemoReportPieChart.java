package com.scp.scoopen.pieChartDemo;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class DemoReportPieChart {

	public static void pieChartReport(int pass,int fail, int skipped)
	{
		// Creating a simple pie chart with 
		 DefaultPieDataset pieDataset = new DefaultPieDataset();
		 pieDataset.setValue("PASS", pass);
		 pieDataset.setValue("FAIL", fail);
		 pieDataset.setValue("SKIP", skipped);

		 JFreeChart piechart = ChartFactory.createPieChart("Test Case Execution Status", pieDataset, true, true, false);

		 try {
			ChartUtilities.saveChartAsJPEG(new File("D:\\simplePiechart.jpg"), piechart, 400, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
