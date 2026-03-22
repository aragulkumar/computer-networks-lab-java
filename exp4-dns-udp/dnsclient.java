import java.net.*;
import java.io.*;

public class dnsclient {
    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket ds = new DatagramSocket();

            System.out.print("Enter the hostname: ");
            String host = br.readLine();

            byte b1[] = host.getBytes();

            InetAddress ia = InetAddress.getByName("localhost");

            DatagramPacket dp = new DatagramPacket(b1, b1.length, ia, 2100);
            ds.send(dp);

            byte b2[] = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(b2, b2.length);

            ds.receive(dp1);

            String ip = new String(dp1.getData(), 0, dp1.getLength());
            System.out.println("IP Address: " + ip);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
