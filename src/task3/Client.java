package task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws Exception
    {
        System.out.println("Current Time is: ");
        DatagramSocket server=new DatagramSocket();
        InetAddress ip=InetAddress.getByName("localhost");
        byte[] receives=new byte[100];
        byte[] sends=new byte[100];
        DatagramPacket inPacket = new DatagramPacket(sends,sends.length,ip,22000);
        DatagramPacket outPacket = new DatagramPacket(receives,receives.length);
        server.send(inPacket);
        server.receive(outPacket);
        String time = new String(outPacket.getData());
        System.out.println(time);
        server.close();
    }
}
