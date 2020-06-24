package model;

import java.util.HashMap;
import java.util.Map;

public class HelloMessage {
	private Map<String, String> msgs;
	public HelloMessage() {
		msgs = new HashMap<String, String>();
		msgs.put("John", "Hello");
		msgs.put("Ray", "Welcome");
		msgs.put("Vincent", "Hi");
	}
	
	public String sayHello(String user) {
		String msg = msgs.get(user);
		return msg + "," + user + "!";
	}
}
