package test;

import com.forddirect.services.api.ServiceFailedException;
import com.forddirect.services.api.ServicesURL;
import com.forddirect.services.bean.Dealer;
import com.forddirect.services.bean.DealersServiceResponse;
import com.forddirect.services.bean.HTTPServiceTransport;
import com.forddirect.services.bean.request.dealer.DealersRequest;
import com.forddirect.services.testclient.DealerServiceClient;

public class TestDealer {

	private static HTTPServiceTransport SERVICES_US_DEV = new HTTPServiceTransport(ServicesURL.US_QA, true);
	
	public static void main(String []args) throws ServiceFailedException {
		
		SERVICES_US_DEV.setMaxConnections(20);
		//HTTPServiceTransport port = new HTTPServiceTransport("http://wwwqa.servicesus.ford.com", true);
		DealerServiceClient usClient = new DealerServiceClient();
		usClient.setTransport(SERVICES_US_DEV);
		
		
		DealersRequest req = new DealersRequest();
		req.setMake("Ford");
		req.setYear("2017");
		req.setModel("Fusion");
		req.setPostalCode("48126");
		
		DealersServiceResponse res =  (DealersServiceResponse) usClient.Dealers(req);
		System.out.println("Dealers: " + res.getDealer().size());
		Dealer d = res.getDealer().get(0);
		System.out.println(String.format("%s,%s,%s,%s,%s" , d.getDlrcalltrkBnp(), d.getDlrcalltrkLad(), d.getDlrcalltrkSing(), d.getLctextoptin(), d.getTextnumber()));
	}
}
