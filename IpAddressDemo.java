import java.net.*;


public class IpAddressDemo {

public static void main(String[] args) throws Exception {


InetAddress ip = InetAddress.getByName("www.google.com");

System.out.println("can get through or not: " + ip.isReachable(2000));

System.out.println(ip.getHostAddress());

}
}