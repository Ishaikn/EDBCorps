package com.TYSS2.testngbatch;

import org.testng.annotations.Test;
import org.testng.annotations.*;

public class Sample {
	@Test(priority = -2)
	public void samples1() {
		System.out.println("--SampleClass--> Samples1 Method Executed");
	}
	@Test
	public void samples2() {
		System.out.println("--SampleClass--> Samples2 Method Executed");
	}
	@Test
	public void samples3() {
		System.out.println("--SampleClass--> Samples3 Method Executed");
	}
	@Test
	public void samples4() {
		System.out.println("--SampleClass--> Samples4 Method Executed");
	}
	@Test
	public void samples5() {
		System.out.println("--SampleClass--> Samples5 Method Executed");
	}

}
