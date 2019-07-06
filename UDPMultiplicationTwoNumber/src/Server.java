import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket theServer = new DatagramSocket(1235);
        DatagramPacket packetRece = null;
        DatagramPacket packetSend = null;
        byte[] dataRece = new byte[1024];
        //from client
        packetRece = new DatagramPacket(dataRece,dataRece.length);
        theServer.receive(packetRece);
        //
        String messRece = new String(packetRece.getData()).trim();
        String[] arrNum = new String[2];
        arrNum = messRece.split("-");
        int a = Integer.parseInt(arrNum[0].trim());
        int b = Integer.parseInt(arrNum[1].trim());
        int c = a*b;
        //send client
        String messSend = String.valueOf(c);
        packetSend = new DatagramPacket(messSend.getBytes(),messSend.getBytes().length,
                packetRece.getAddress(),packetRece.getPort());
        theServer.send(packetSend);


    }
}
