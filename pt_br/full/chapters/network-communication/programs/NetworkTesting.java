import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NetworkTesting {    
    public static void main(String[] args) throws UnknownHostException, IOException {
        try (Socket socket = new Socket("google.com", 80);
             Scanner in = new Scanner(socket.getInputStream());
             PrintWriter out = new PrintWriter(socket.getOutputStream())) {            
            out.println("GET / HTTP/1.0");
            out.println();
            out.flush();
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        }
    }
}