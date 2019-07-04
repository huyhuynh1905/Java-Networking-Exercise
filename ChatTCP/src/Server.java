import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket theServer = new ServerSocket(1235);
            while (true){
                Socket socket = theServer.accept();
                ReadMess rm = new ReadMess(socket);
                SendMess sm = new SendMess(socket);
                rm.start();
                sm.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//Send Mess Thread
class SendMess extends Thread{
    public Socket socket;

    public SendMess(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        PrintStream printStream = null;
        while (true){
            String mess = sc.nextLine();
            try {
                printStream = new PrintStream(socket.getOutputStream());
                printStream.println(mess);
                if (mess.equals("Goodbye")){
                    System.exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//Read Mess Thread
class ReadMess extends Thread{
    public Socket socket;

    public ReadMess(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String mess = bufferedReader.readLine();
                System.out.println("Client: "+mess);
                if (mess.equals("Goodbye")){
                    System.out.println("Exit Program!");
                    socket.close();
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
