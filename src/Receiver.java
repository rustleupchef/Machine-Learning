import java.io.File;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Receiver {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        while(true) {
            try {
                Socket socket = new Socket(getVal(0), Integer.valueOf(getVal(1)));
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int bufferint = inputStream.read(buffer);
                String write = new String(buffer, 0, bufferint);
                JOptionPane.showMessageDialog(null, write);
                socket.close();
                
            } catch(Exception e){}
        }
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
