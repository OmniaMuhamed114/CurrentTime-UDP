package task3;

import java.io.DataOutputStream;
import java.net.*;
import java.util.Date;

public class Server {
    public static void main(String args[]) throws Exception
    {
        DatagramSocket server=new DatagramSocket(22000);
        while(true){
            System.out.println("Server is connected....");
            byte[] receives=new byte[100];
            byte[] sends;
            DatagramPacket outPacket=new DatagramPacket(receives,receives.length);
            server.receive(outPacket);
            InetAddress ip= outPacket.getAddress();
            int port=outPacket.getPort();
            Date date = new Date();
            String time= date + "";
            sends=time.getBytes();
            DatagramPacket inPacket=new DatagramPacket(sends,sends.length,ip,port);
            server.send(inPacket);
            System.out.println("finish.");
        }
    }
}
