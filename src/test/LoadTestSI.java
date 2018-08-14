package test;

import com.forddirect.services.api.ServicesURL;
import com.forddirect.services.bean.HTTPServiceTransport;

public class LoadTestSI {

	public static void main(String[] args) {
		//TestSIUS us = new TestSIUS();
		//TestSIFoC foc = new TestSIFoC();
		HTTPServiceTransport SERVICES_US_QA = new HTTPServiceTransport(ServicesURL.US_DEV, true);
		//SERVICES_US_QA.setConnectionTimeOut(5000);
		//SERVICES_US_QA.setReadTimeOut(5000);
		
		HTTPServiceTransport SERVICES_CA_QA = new HTTPServiceTransport(ServicesURL.CA_DEV, true);
		SERVICES_CA_QA.setConnectionTimeOut(5000);
		SERVICES_CA_QA.setReadTimeOut(1000);
		
		for(int i=0; i<2; i++) {
			new Thread(new TestSIUS(i+1, SERVICES_US_QA)).start();			
			new Thread(new TestSIFoC(i+1, SERVICES_CA_QA)).start();			
		}
		System.out.println("*****************");
		System.out.println("*****************");
		System.out.println("All Threads started and running");
		System.out.println("*****************");
		System.out.println("*****************");
	}
}
