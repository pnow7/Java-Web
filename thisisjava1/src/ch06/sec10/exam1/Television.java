package ch06.sec10.exam1;

public class Television {
	//static
	static String company = "MyCompany";
	static String model = "LCD";
	static String info;
	
	static {
		info = company + "-" + model;
	}
}
