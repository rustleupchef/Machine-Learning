import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;

public class Sender {
    public static void main(String[] args) throws Exception {
        int port;
        if(args.length == 0) {

            port = Integer.valueOf(getVal(1));
        }
        else {
            port = Integer.valueOf(args[0]);
        }
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        socket.getOutputStream().write("You got a visitor".getBytes());
        socket.close();
        server.close();
    }

    private static String getVal(int index) throws Exception{
        Scanner scanner = new Scanner(new File("Details.txt"));
        String text = "";
        while(scanner.hasNextLine()) {
            text += scanner.nextLine() + "\n";
        }
        scanner.close();
        scanner.close();
        return text.split("\n")[index];
    }
}
