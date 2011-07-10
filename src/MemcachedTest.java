import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;

/*
 * http://code.google.com/p/spymemcached/wiki/Examples
 */

class User implements Serializable{
	public String userName;
	public String password;
}

public class MemcachedTest {

	public static void main(String[] args) throws IOException {
		MemcachedClient c = new MemcachedClient(new InetSocketAddress(
				"192.168.1.106", 11211));

		
		//A simple example with Integer
		
		// Store a value (async) for one hour
		c.set("someKey", 3600, new Integer(4));
		// Retrieve a value (synchronously).
		Object myObject = c.get("someKey");
		Integer result = (Integer) myObject;
		System.out.println(result);
		
		
		//Store and Retrieve an Serialized Object
		
		
		User user1 = new User();
		user1.userName = "ZhangSan";
		user1.password = "alongpasswordhere";
		c.set("user1", 3600, user1);
		User myUser1 = (User)(c.get("user1"));
		System.out.println(myUser1.userName + " " + myUser1.password);
		
	}

}
