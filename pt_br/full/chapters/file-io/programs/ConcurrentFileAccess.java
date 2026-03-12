import java.io.*;
import java.nio.file.Paths;

public class ConcurrentFileAccess implements Runnable {
    private boolean even;
    
    public static void main(String[] args) {
        Thread writer1 = new Thread(new ConcurrentFileAccess(true)); // <.>
        Thread writer2 = new Thread(new ConcurrentFileAccess(false));     
        writer1.start(); // <.>
        writer2.start();
    }
    
    public ConcurrentFileAccess(boolean even) {
        this.even = even;
    }
    
    public void run() {
        int start = even ? 0 : 1; // <.>
        try (var out = new PrintWriter(Paths.get("concurrent.out").toFile())) { // <.>
            for (int i = start; i < 10000; i += 2) { // <.>
                out.println(i);
            }				
        } catch (FileNotFoundException e) {
            System.out.println("concurrent.out not accessible!");
        }
    }   
}