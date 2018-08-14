package test;

import java.util.HashMap;
import java.util.Map;

import com.forddirect.services.api.ServiceFailedException;
import com.forddirect.services.bean.HTTPServiceTransport;
import com.forddirect.services.bean.InventoryConfirmPresenceResponse;
import com.forddirect.services.bean.request.inventory.ConfirmPresenceRequest;
import com.forddirect.services.testclient.InventoryServiceClient;

public class TestInventoryAEM {

	
	public static void main(String []args) throws ServiceFailedException {
		final HTTPServiceTransport SERVICES_US_DEV = new HTTPServiceTransport();
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("ngp.services.url", "http://wwwqa.servicesus.ford.com/");
		//activate is made protected. so can not be accessed from here. Change th3e API to test it.
		//SERVICES_US_DEV.activate(props);
		
		SERVICES_US_DEV.setWSLCookie("W08vZ1tPvAcBAPsABHVzZXJpZD12ZWthbWJhcgBpcGFkZHI9MTkuNTUuMjQuMTg1AGFjaWdyb3VwPU5PTk9WVk0AZGVwdD0zMDk1MDAwMDAwAG9yZ2NvZGU9PwBlbXBjb2RlPU0AbXJyb2xlPU4Ab3JnPU1LUwBjb21wYW55PVRFQ0guTUFISU5EUkEuTElNSVRFRABkaXZhYmJyPUpWRkRSAHNpdGVjb2RlPTUxNTMAY2l0eT1ERUFSQk9STgBzdGF0ZT1NSQBjb3VudHJ5PVVTQQBzdWJqZWN0aWQ9dmVrYW1iYXJAZm9yZC5jb20AYXV0aHR5cGU9QQAAAENOPXdzbHY0LWludGVybmFsAHJWU8LXzWLqC9ZOuuMSPWLtKhP241ekAnOfHbntZrtXoIyDayMQ4Vx/v1VjvvpAxS4s1fqxpYll5abPMFu2igfUYa3YseweYrLVgzz2iBkhoshtXaaEZenkI4746Mv4NhrG9NNeQMzgG9YUAgAz4wfrhvptYc5cljKG4iKK8V4p");
		//SERVICES_US_DEV.setWSLV2Cookie("Wg8VLFoPocwBAQgABHVzZXJpZD12ZWthbWJhcgBpcGFkZHI9MTkuMTIuNjQuMTgwXzE5LjU1LjI0LjE2OABhY2lncm91cD1OT05PVlZNAGRlcHQ9MzA5NTAwMDAwMABvcmdjb2RlPT8AZW1wY29kZT1NAG1ycm9sZT1OAG9yZz1NS1MAY29tcGFueT1URUNILk1BSElORFJBLkxJTUlURUQAZGl2YWJicj1KVkZEUgBzaXRlY29kZT01MTUzAGNpdHk9REVBUkJPUk4Ac3RhdGU9TUkAY291bnRyeT1VU0EAc3ViamVjdGlkPXZla2FtYmFyQGZvcmQuY29tAGF1dGh0eXBlPVAAAABDTj13c2x2NS1pbnRlcm5hbABvOJnRxw7QrEw2NyphtpkoudcPXc8zFiOj4If7AgiaB/7b1JZv4Sbn6+DjYOzqUbUG84BD9t+oqIf04dgWgury+dkxzk5gEbrixSJbhltBku5XG2GZcFGwGaqDQ/sMqtn6IouwJhgZkeLRobrmVSf2vk47O16xjCkdSgMBa0IibT4A2uaz5jyBjlNtn88/BNwIuCa2gJUqN9/xN6FI7FZqSGwt2+x4QlzYAQXD/71414WrFzBcMebGgOydl1flAcflqtDiu8EmABwNi3Iqx2tY8dYUNTY8mY2rOlU4/WIsz76cYZMjH5eQJeLlHQVgnGzGe6zoN64cWbuTPaN9Bj9O");

		InventoryServiceClient usClient = new InventoryServiceClient();
		usClient.setTransport(SERVICES_US_DEV);
		
		
		
		ConfirmPresenceRequest req = new ConfirmPresenceRequest();		
		req.setVin("3FA6P0G73JR114087");
		//req.setModel("Fusion");
		req.setDealerPACode("02058");
		
		InventoryConfirmPresenceResponse res =  (InventoryConfirmPresenceResponse) usClient.ConfirmPresence(req);
		System.out.println("Present?: " + res.getInventoryConfirmation().getPresent());
	}
}
