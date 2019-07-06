import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket theClient = new DatagramSocket();
        DatagramPacket packetSend = null;
        DatagramPacket packetRece = null;
        byte dataRece[] = new byte[1024];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Enter b: ");
        int b = Integer.parseInt(sc.nextLine());
        //Send to Server
        String messSend = a+"-"+b;
        packetSend = new DatagramPacket(messSend.getBytes(),messSend.getBytes().length,
                InetAddress.getLocalHost(),1235);
        theClient.send(packetSend);
        //rece
        packetRece = new DatagramPacket(dataRece,dataRece.length);
        theClient.receive(packetRece);
        String messRece = new String(packetRece.getData()).trim();
        System.out.println("Multiplication: "+messRece);
    }
}
