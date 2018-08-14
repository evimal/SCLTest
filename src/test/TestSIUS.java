package test;

import java.util.Calendar;

import com.forddirect.services.bean.HTTPServiceTransport;
import com.forddirect.services.bean.InventorySearchResponse;
import com.forddirect.services.bean.InventoryVehicle;
import com.forddirect.services.bean.request.inventory.VehicleSearchRequest;
import com.forddirect.services.testclient.InventoryServiceClient;
//import com.forddirect.services.testclient.UserServiceClient;


public class TestSIUS implements Runnable {

	String runnerName = null;
	HTTPServiceTransport transport;
	public TestSIUS(int index, HTTPServiceTransport transport) {
		runnerName = "SIUS" + index;
		this.transport = transport;
	}

	@Override
	public void run() {
		try {
			testInventorySearch();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void testInventorySearch() throws Exception {
		System.out.println("------------------------------" + this.runnerName+ " started-------------------------------------");
		
		InventoryServiceClient nonAkamaiInvClient = new InventoryServiceClient();
		nonAkamaiInvClient.setTransport(this.transport);

		try {

			 VehicleSearchRequest req = new VehicleSearchRequest();
			req.setVin("3FA6P0G73JR114087");
			req.setPostalCode("45245");
			req.setDealerPACode("02058");
			req.showPaymentEstimatorV2(true);
			req.setVehicleStageFilter("inproduction;onlot;intransit");
			req.setAppContext("si2");
			/*req.setMake("Ford");
			req.setModel("SuperDuty");
			req.setYear("2018");*/
			req.setDREPricing("true");
			 InventorySearchResponse v = null;
			long start = Calendar.getInstance().getTimeInMillis();
			v = (InventorySearchResponse) nonAkamaiInvClient.search(req);
			long timetaken = Calendar.getInstance().getTimeInMillis() - start;
			InventoryVehicle veh = v.getVehicleSearch().getVehicles().getVehicle().get(0);
			System.out.println(timetaken + "ms - " + runnerName + "---" + veh.getDealerPACode());
			
		} catch (Exception e) {
			System.err.println("Error US:"+e.getMessage());
		}
	}
	
}
