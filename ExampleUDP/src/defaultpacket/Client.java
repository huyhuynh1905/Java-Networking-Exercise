package defaultpacket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket theClient = new DatagramSocket();
        DatagramPacket packetSend = null;
        DatagramPacket packetRece = null;
        byte dataRece[] = new byte[1024];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your mess: ");
        String mess = sc.nextLine();
        //Send
        packetSend = new DatagramPacket(mess.getBytes(),mess.getBytes().length, InetAddress.getLocalHost(),
                1235);
        theClient.send(packetSend);

        //Rece
        packetRece = new DatagramPacket(dataRece,dataRece.length);
        theClient.receive(packetRece);

        String messRece = new String(packetRece.getData()).trim();
        System.out.println("ReceStr: "+messRece);

    }
}
