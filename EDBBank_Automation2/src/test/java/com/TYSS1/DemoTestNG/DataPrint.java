package com.TYSS1.DemoTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.GenericUtilities.ExcelUtility;

public class DataPrint {
	@Test(dataProviderClass=DataImplemention_Excel.class, dataProvider="exceldata")
public void Spiders(String Branch, String Place, String Subject, String Tutor ) {
	System.out.println("Branch Name is: "+Branch+"Location of the Branch is: "+Place+"Subjects to be Trained: "+Subject+"Instructor Name is: "+Tutor);
System.out.println("Git check");
	System.out.println("Git pull");
	}

}
