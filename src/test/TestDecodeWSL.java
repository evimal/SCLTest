package test;

import com.forddirect.services.api.ServiceFailedException;
import com.forddirect.services.api.ServicesURL;
import com.forddirect.services.bean.AuthenticationDecodeWSLResponse;
import com.forddirect.services.bean.HTTPServiceTransport;
import com.forddirect.services.bean.request.authentication.DecodeWSLRequest;
import com.forddirect.services.testclient.AuthenticationServiceClient;

public class TestDecodeWSL {

	
	public static void main(String []args) throws ServiceFailedException {
		final HTTPServiceTransport SERVICES_US_DEV = new HTTPServiceTransport(ServicesURL.US_DEV, false);
		
		//SERVICES_US_DEV.setWSLCookie("Wgs+oFoLy0ABARQABHVzZXJpZD12ZWthbWJhcgBpcGFkZHI9MTkuNzYuNy4xMTBfMTkuNTUuMjQuMTY4XzE5LjEyLjY0LjE2MQBhY2lncm91cD1OT05PVlZNAGRlcHQ9MzA5NTAwMDAwMABvcmdjb2RlPT8AZW1wY29kZT1NAG1ycm9sZT1OAG9yZz1NS1MAY29tcGFueT1URUNILk1BSElORFJBLkxJTUlURUQAZGl2YWJicj1KVkZEUgBzaXRlY29kZT01MTUzAGNpdHk9REVBUkJPUk4Ac3RhdGU9TUkAY291bnRyeT1VU0EAc3ViamVjdGlkPXZla2FtYmFyQGZvcmQuY29tAGF1dGh0eXBlPUEAAABDTj13c2x2NC1pbnRlcm5hbAA6363RgqlL0BwipDydga/grWI7Edv1KtXAJy3nPNb4tkI0r7l+YFqQLtU+pIlUXF080i6oS2KvjgJ2YByGmBthOQBHbQgwdKCFL6rZiKu8QnJAVCz8k0iYRe///+lnGds36gS3Mr7YTwryBW64Cl++Idu71koNDGKTj9M4KWCn6Q==");

		/*InventoryServiceClient usClient = new InventoryServiceClient();
		usClient.setTransport(SERVICES_US_DEV);
		
		
		
		ConfirmPresenceRequest req = new ConfirmPresenceRequest();
		req.setHttpMethod(RequestMethod.GET);
		req.setVin("3FA6P0G73JR114087");
		//req.setModel("Fusion");
		req.setDealerPACode("02058");
		
		InventoryConfirmPresenceResponse res =  (InventoryConfirmPresenceResponse) usClient.ConfirmPresence(req);
		System.out.println("Present?: " + res.getInventoryConfirmation().getPresent());
		//SERVICES_US_DEV.setWSLCookie("Wgs+oFoLy0ABARQABHVzZXJpZD12ZWthbWJhcgBpcGFkZHI9MTkuNzYuNy4xMTBfMTkuNTUuMjQuMTY4XzE5LjEyLjY0LjE2MQBhY2lncm91cD1OT05PVlZNAGRlcHQ9MzA5NTAwMDAwMABvcmdjb2RlPT8AZW1wY29kZT1NAG1ycm9sZT1OAG9yZz1NS1MAY29tcGFueT1URUNILk1BSElORFJBLkxJTUlURUQAZGl2YWJicj1KVkZEUgBzaXRlY29kZT01MTUzAGNpdHk9REVBUkJPUk4Ac3RhdGU9TUkAY291bnRyeT1VU0EAc3ViamVjdGlkPXZla2FtYmFyQGZvcmQuY29tAGF1dGh0eXBlPUEAAABDTj13c2x2NC1pbnRlcm5hbAA6363RgqlL0BwipDydga/grWI7Edv1KtXAJy3nPNb4tkI0r7l+YFqQLtU+pIlUXF080i6oS2KvjgJ2YByGmBthOQBHbQgwdKCFL6rZiKu8QnJAVCz8k0iYRe///+lnGds36gS3Mr7YTwryBW64Cl++Idu71koNDGKTj9M4KWCn6Q==");
		InventoryServiceClient usClient1 = new InventoryServiceClient();
		usClient1.setTransport(SERVICES_US_DEV);
		InventoryConfirmPresenceResponse res1 =  (InventoryConfirmPresenceResponse) usClient1.ConfirmPresence(req);
		System.out.println("Present?: " + res1.getInventoryConfirmation().getPresent());
		 */
		DecodeWSLRequest request = new DecodeWSLRequest();
		request.setCookie("WgycH1vtz6ABAWcABHVzZXJpZD1mY3BsYzEAaXBhZGRyPTE5LjU5LjEwNy4xOF8xOS41OS4xMDcuMTlfMTkuNTkuMTA3LjIwXzE5LjU5LjEwNy4yMV8xOS41OS4xMDcuMjJfMTkuNTkuMTA3LjIzXzE5LjU5LjEwNy4yNF8xOS41OS4xMDcuMjVfMTkuNTkuMTA3LjI2XzE5LjU5LjEwNy4yN18xOS41OS4xMDcuMjhfMTkuNTkuMTA3LjI5XzE5LjU5LjEwNy4zMF8xOS41LjEwNy4xOF8xOS41LjEwNy4xOV8xOS41LjEwNy4yMF8xOS41LjEwNy4yMV8xOS41LjEwNy4yMl8xOS41LjEwNy4yM18xOS41LjEwNy4yNF8xOS41LjEwNy4yNV8xOS41LjEwNy4yNl8xOS41LjEwNy4yN18xOS41LjEwNy4yOF8xOS41LjEwNy4yOV8xOS41LjEwNy4zMAAAAGNuPXdzbHY0LWludGVybmFsAG/sE6+Fm95GgyJC/SXKW/jodIKc4A37b65BuQ6UGNqCVTOK4GuEY+QSUts1fqCNFW0/79ywldp7bknOOEh0FnC9nLJc7Z94G7RngcIQGIfrkHppIJ7L6r15tfDZRKZJEPtzKtc5dhythFkLGITYedgPUIwwYqB+X5RQKcjSNAjv");
		
		AuthenticationServiceClient client = new AuthenticationServiceClient();
		client.setTransport(SERVICES_US_DEV);
		
		AuthenticationDecodeWSLResponse wslResult =  (AuthenticationDecodeWSLResponse) client.DecodeWSL(request);
		System.out.println(wslResult.getWSLResult().getExpiry());
		
		System.out.println(wslResult.getWSLResult().getCookieVersion());
		
		
		
		
	}
}
