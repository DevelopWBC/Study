package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author Wangzhiwen
 * @ClassName InetAddressTest
 * @Description：InetAddress代表IP的类
 * @Date 2019/7/19 16:38
 * @Version 1.0
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        String canonicalHostName = address.getCanonicalHostName();
        byte[] address1 = address.getAddress();
        System.out.println(canonicalHostName);
        System.out.println(address1.toString());
    }
}
