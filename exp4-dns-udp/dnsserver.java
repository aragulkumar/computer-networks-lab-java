import java.net.*;
import java.io.*;

public class dnsserver {
    public static void main(String args[]) {
        try {
            DatagramSocket ds = new DatagramSocket(2100);
            byte b1[] = new byte[1024];
            System.out.println("DNS Server is running...");
            
            while (true) {
                DatagramPacket dp = new DatagramPacket(b1, b1.length);
                ds.receive(dp);

                String host = new String(dp.getData(), 0, dp.getLength());
                System.out.println("Request for host " + host);

                InetAddress ia = InetAddress.getByName(host);
                String ip = ia.getHostAddress();

                byte b2[] = ip.getBytes();

                DatagramPacket dp1 = new DatagramPacket(
                        b2, b2.length,
                        dp.getAddress(),
                        dp.getPort()
                );

                ds.send(dp1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
