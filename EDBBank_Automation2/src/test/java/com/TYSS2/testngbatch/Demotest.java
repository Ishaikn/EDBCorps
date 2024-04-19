package com.TYSS2.testngbatch;

import org.testng.annotations.Test;
import org.testng.annotations.*;

public class Demotest {
	@Test(groups = "smoke")
	public void Demotest1() {
		System.out.println("(smoke Testing)-DemoTestClass---> Demotest1 Method Executed");
	}
	@Test(groups = "Regression")
	public void Demotest2() {
		System.out.println("(Regression Testing)--DemoTestClass---> Demotest2 Method Executed");
	}
	@Test(groups = "Integration")
	public void Demotest3() {
		System.out.println("(Integration Testing)-DemoTestClass---> Demotest3 Method Executed");
	}
	@Test
	public void Demotest4() {
		System.out.println("--DemoTestClass---> Demotest4 Method Executed");
	}
	@Test
	public void Demotest5() {
		System.out.println("--DemoTestClass---> Demotest5a Method Executed");
	}

}
