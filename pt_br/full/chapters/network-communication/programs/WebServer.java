import java.io.*; // <.>
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class WebServer {        
    private int port; // <.>
    private Path webRoot;   
    
    public WebServer(int port, Path webRoot) {
        this.port = port;
        this.webRoot = webRoot;
        System.out.println("Path: " + webRoot);
    }
    
    public static void main(String[] args) {
		WebServer server = new WebServer(80, Paths.get(".").toAbsolutePath()); // <.>
        server.start();
    }
    
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) { // <.>
            while (true) {
                try (Socket socket = serverSocket.accept(); // <.>
                    Scanner in = new Scanner(socket.getInputStream()) ;	// <.>
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
					boolean requestRead = false;
                    while (in.hasNextLine() && !requestRead) { // <.>
                        String line = in.nextLine();
                        if (line.startsWith("GET")) {
                            String path = line.substring(4, // <.>
								line.lastIndexOf("HTTP")).trim();
                            System.out.println("Received request for: " + path);
                            serve(out, getPath(path)); // <.>
                            requestRead = true; // <.>
                        }
                    }
                } catch (IOException e) {						
                    System.out.println("Error: " + e.getMessage());
                }              
            }
        } catch (IOException e) { // <.>
            System.out.println("Error: " + e.getMessage());
        }
    }   

    public Path getPath(String path) {
        if (path.endsWith("/")) {
            path += "index.html"; // <.>
        }

        if (path.startsWith("/")) {
            path = path.substring(1); // <.>
        }

        return webRoot.resolve(path);
    }
    
    public void serve(DataOutputStream out, Path path) throws IOException {
        System.out.println("Trying to serve " + path);
        if (!Files.exists(path)) { // <.>
            out.writeBytes("HTTP/1.0 404 Not Found\r\n\r\n");
            out.writeBytes("<html><head><title>404 Not Found</title></head>" +
				"<body><h1>Not Found</h1>The requested URL " + path +
				" was not found on this server.</body></html>");
            System.out.println("File not found.");
        }
        else {
            out.writeBytes("HTTP/1.0 200 OK\r\n\r\n"); // <.>
            try (DataInputStream in = 
                new DataInputStream(new FileInputStream(path.toString()))) { // <.>
                while (true) {
                    out.writeByte(in.readByte()); // <.>
                }
            } catch (EOFException e) { // <.>
				System.out.println("Request succeeded.");
			} catch (IOException e) {
                System.out.println("Error sending file: " + e.getMessage());
            }
        }
    }
}   
