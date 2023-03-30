import java.io.File;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(Integer.valueOf(getVal(1)));
        Socket socket = server.accept();
        socket.getOutputStream().write(args[0].getBytes());
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
