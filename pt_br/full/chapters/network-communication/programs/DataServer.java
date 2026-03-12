import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(4321);
            Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream())) {
            int sum = 0;
            for (int i = 0; i < 100; ++i) {
                sum += in.readInt();
            }
            System.out.println("Sum: " + sum);
        } catch (IOException e) {
            System.out.println("Network error: " + e.getMessage());
        }
    }    
}
