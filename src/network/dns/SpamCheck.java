package network.dns;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class SpamCheck {
	public static final String BLACKHOLE = "www.baidu.com";

	public static void main(String[] args) {
		
		String[] ips = {"202.108.22.5"};
		for (String arg : ips) {
			if (isSpammer(arg)) {
				System.out.println(arg + "is a known spammer.");
			} else {
				System.out.println(arg + " appears legitimate.");
			}
		}
	}
	public static boolean isSpammer(String arg) {
		try {
			Inet4Address address = (Inet4Address) Inet4Address.getByName(arg);
			byte[] quad = address.getAddress();
			System.out.println("quad:" + quad.toString());
			String query = BLACKHOLE;
			for (byte octet : quad) {
				int unsignedByte = octet < 0 ? octet + 256 : octet;
				query = unsignedByte + "." + query;
			}
			Inet4Address address2 = (Inet4Address) Inet4Address.getByName(query);
			System.out.println("address2:" + address2.toString());
			return true;
		} catch (UnknownHostException e) {
			return false;
		}
	}
}
