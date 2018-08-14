package test;

import com.forddirect.services.api.ServiceFailedException;
import com.forddirect.services.api.ServicesURL;
import com.forddirect.services.bean.Dealer;
import com.forddirect.services.bean.HTTPServiceTransport;
import com.forddirect.services.bean.VinExplodeResponse;
import com.forddirect.services.bean.request.vinexplode.VinExplodeRequest;
import com.forddirect.services.testclient.VinexplodeServiceClient;

public class TestVINExp {

	private static HTTPServiceTransport SERVICES_US_DEV = new HTTPServiceTransport(ServicesURL.US_QA, true);
	
	public static void main(String []args) throws ServiceFailedException {
		
		//SERVICES_US_DEV.setMaxConnections(20);
		SERVICES_US_DEV.setWSLCookie("W08vZ1tPvAcBAPsABHVzZXJpZD12ZWthbWJhcgBpcGFkZHI9MTkuNTUuMjQuMTg1AGFjaWdyb3VwPU5PTk9WVk0AZGVwdD0zMDk1MDAwMDAwAG9yZ2NvZGU9PwBlbXBjb2RlPU0AbXJyb2xlPU4Ab3JnPU1LUwBjb21wYW55PVRFQ0guTUFISU5EUkEuTElNSVRFRABkaXZhYmJyPUpWRkRSAHNpdGVjb2RlPTUxNTMAY2l0eT1ERUFSQk9STgBzdGF0ZT1NSQBjb3VudHJ5PVVTQQBzdWJqZWN0aWQ9dmVrYW1iYXJAZm9yZC5jb20AYXV0aHR5cGU9QQAAAENOPXdzbHY0LWludGVybmFsAHJWU8LXzWLqC9ZOuuMSPWLtKhP241ekAnOfHbntZrtXoIyDayMQ4Vx/v1VjvvpAxS4s1fqxpYll5abPMFu2igfUYa3YseweYrLVgzz2iBkhoshtXaaEZenkI4746Mv4NhrG9NNeQMzgG9YUAgAz4wfrhvptYc5cljKG4iKK8V4p");
		//HTTPServiceTransport port = new HTTPServiceTransport("http://wwwqa.servicesus.ford.com", true);
		
		VinexplodeServiceClient client = new VinexplodeServiceClient();
		client.setTransport(SERVICES_US_DEV);
		
		VinExplodeRequest req = new VinExplodeRequest();
		req.setVin("1FMCU9J92HUA01136");
		
		
		VinExplodeResponse res =  (VinExplodeResponse) client.explode(req);
		System.out.println("Dealers: " + res.getCount());
		
	}
}
