package defaultpacket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket theServer = new DatagramSocket(1235);
        DatagramPacket packetSend = null;
        DatagramPacket packetRece = null;
        byte dataRece[] = new byte[1024];

        //Rece from client
        packetRece = new DatagramPacket(dataRece, dataRece.length);
        theServer.receive(packetRece);

        String messRece = new String(packetRece.getData()).trim();
        String messSend = messRece.toUpperCase();
        //send to client
        packetSend = new DatagramPacket(messSend.getBytes(),messSend.getBytes().length,
                packetRece.getAddress(),packetRece.getPort());
        theServer.send(packetSend);

    }
}
