import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost",1235);
            System.out.println("Connected!");
            ReadMessClient rmClient = new ReadMessClient(clientSocket);
            SendMessClient smClient = new SendMessClient(clientSocket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//Send Mess Thread
class SendMessClient extends Thread{
    public Socket socket;

    public SendMessClient(Socket socket) {
        this.socket = socket;
        this.start();
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
class ReadMessClient extends Thread{
    public Socket socket;

    public ReadMessClient(Socket socket) {
        this.socket = socket;
        this.start();
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String mess = bufferedReader.readLine();
                System.out.println("Server: "+mess);
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
