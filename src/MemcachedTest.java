import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;

/*
 * http://code.google.com/p/spymemcached/wiki/Examples
 */

class User{
	public String userName;
	public String password;
}

public class MemcachedTest {

		public static void main(String[] args) throws IOException{
			MemcachedClient c=new MemcachedClient(new InetSocketAddress("192.168.1.106", 11211));

				// Store a value (async) for one hour
				c.set("someKey", 3600, new Integer(4));
				// Retrieve a value (synchronously).
				Object myObject=c.get("someKey");
				Integer result = (Integer)myObject;
				System.out.println(result);
		}
		
}
