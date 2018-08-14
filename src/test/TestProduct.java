package test;

import com.forddirect.services.api.ServiceFailedException;
import com.forddirect.services.api.ServicesURL;
import com.forddirect.services.bean.HTTPServiceTransport;
import com.forddirect.services.bean.Model;
import com.forddirect.services.bean.ModelSlicesResponse;
import com.forddirect.services.bean.request.products.ModelSlicesRequest;
import com.forddirect.services.testclient.ProductsServiceClient;

public class TestProduct {

	private static HTTPServiceTransport SERVICES_US = new HTTPServiceTransport(ServicesURL.US_QA, true);
	
	public static void main(String []args) throws ServiceFailedException {
		
		SERVICES_US.setMaxConnections(20);
		
		ProductsServiceClient usClient = new ProductsServiceClient();
		usClient.setTransport(SERVICES_US);
		
		
		ModelSlicesRequest req = new ModelSlicesRequest();
		req.setMake("Ford");
		/*req.setYear("2017");
		req.setModel("Fusion");
		req.setPostalCode("48126");*/
		
		req.setModelAttributes("NGP_ModelInfo_ModelAliases;NGP_ModelInfo_VehicleType;ISP_Search.*;NGB_Specifications_MPG.*");
		req.setFilters("SI2_Is_Enabled:True");
		
		ModelSlicesResponse res =  (ModelSlicesResponse) usClient.ModelSlices(req);
		System.out.println("Models: " + res.getModel().size());
		Model d = res.getModel().get(0);
		System.out.println( d.getModelName());
	}
}
