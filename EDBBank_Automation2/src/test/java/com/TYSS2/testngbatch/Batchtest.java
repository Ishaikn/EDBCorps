package com.TYSS2.testngbatch;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

import org.testng.annotations.*;

public class Batchtest extends BaseClass {

	@Test(groups = "smoke")
	public void batch1() {
		System.out.println("(smoke Testing): --BatchtestClass-->Batch1 Method Executed");
	}

	@Test(groups = "Regression")
	public void batch2() {
		System.out.println("(Regression Testing): --BatchtestClass-->Batch2 Method Executed");
	}

	@Test(groups = "Integration")
	public void batch3() {
		System.out.println("(Integration Testing): --BatchtestClass-->Batch3 Method Executed");
	}

	@Test
	public void batch4() {
		System.out.println("--BatchtestClass-->Batch4 Method Executed");
	}

	@Test
	public void batch5() {
		System.out.println("--BatchtestClass-->Batch5 Method Executed");
	}

}
