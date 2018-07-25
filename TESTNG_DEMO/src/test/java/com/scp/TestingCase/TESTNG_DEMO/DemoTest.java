package com.scp.TestingCase.TESTNG_DEMO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scp.Entitiy.UserData;
import com.scp.Util.utilityMethods;
import com.scp.scoopen.pieChartDemo.TestReport;
import com.scp.serviceImplementation.serviceImplementation;
@Listeners(TestReport.class)
public class DemoTest {

	//List<UserData> lob ;
	
	DemoTest obj = null;
	
	@Test(dataProvider = "userValues")
	public void methodOne(String usname, String pwd, String status){
		
		
		System.out.println("The Username = "+usname+ "Password = "+pwd+"The status ="+status );
		
		//serviceImplementation userService = new serviceImplementation();
		
		//String result = userService.AuthenticateUser(usname, pwd);
		
		//System.out.println("The contents are = "+ result);
		
		/*if(usname.equals(result.contains(usname)) && pwd.equals(result.contains(pwd))){
			
			System.out.println("User Authetication Success!!");
		}*/
		
		//String actop =Authenticate.authenticate(username, password);
		
		//System.out.println("*** method op = " + actop + " for uname "+username+ " password "+ password );
		
		//Assert.assertEquals(actop, op);
		//	System.out.println("Hello !!" + values);	

	}
	
	@Test 
	public void methodTwo(){
		
		System.out.println("Inside method Two !!");
	}
	
	@Test
	public void methodThree(){
		
		System.out.println("Inside method Three !!");
	}
	
	
	@DataProvider(name = "userValues")
	public Object[][] getData() throws IOException{ //displayUser(List<UserData> ob)
		
		
		File file = new File("G:/TestCase.xlsx");
		
		FileInputStream fi = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		
        Object [][] obarr = new Object [sheet.getPhysicalNumberOfRows()][3];
		
		
		for (int i = 0 ; i<sheet.getPhysicalNumberOfRows(); i++ ){
			
			for (int j = 0 ; j<3 ; j++){
				
				
				try {
				obarr[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
				catch (NullPointerException e){
					obarr[i][j]="";
				}
				
				
			}
		
		/* serviceImplementation obj = new serviceImplementation();
		
		Object[] data =  new Object[4];
		
		 obj.displayUser(lob);
		
		Iterator<UserData> itr = lob.iterator();
		while(itr.hasNext()){
			for(int i=0;i<4;i++){
				data[i] = itr.next();
			}
		}*/
		
		
		/*data[0] = "Konark";
		data[1] = "Sanjay";
		data[2] = "Modi";
		data[3] = "Surat";
		*/	
		
		
	}
		return obarr;
	
	
	}	
	
}
