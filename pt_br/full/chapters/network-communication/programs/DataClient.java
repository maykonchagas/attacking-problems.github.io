import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class DataClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 4321);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            for (int i = 1; i <= 100; ++i) {
                out.writeInt(i*i);
            }
        } catch (IOException e) {
            System.out.println("Network error: " + e.getMessage());
        }
    }    
}
