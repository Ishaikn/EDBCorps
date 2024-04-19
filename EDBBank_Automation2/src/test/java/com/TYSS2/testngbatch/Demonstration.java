package com.TYSS2.testngbatch;

import org.testng.annotations.Test;
import org.testng.annotations.*;

public class Demonstration {
	@Test(priority = -3)
	public void demos1() {
		System.out.println("---DemonstrationClass--> demos1 Method Executed");
	}
	@Test
	public void demos2() {
		System.out.println("---DemonstrationClass--> demos2 Method Executed");
	}
	@Test
	public void demos3() {
		System.out.println("---DemonstrationClass--> demos3 Method Executed");
	}
	@Test
	public void demos4() {
		System.out.println("---DemonstrationClass--> demos4 Method Executed");
	}
	@Test
	public void demos5() {
		System.out.println("---DemonstrationClass--> demos5 Method Executed");
	}

}
