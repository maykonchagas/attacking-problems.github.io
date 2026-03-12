import java.io.*;

public class AreaFromRadiusBinary {
    public static void main(String[] args) {
        try (var in = new DataInputStream(new FileInputStream("radiuses.bin"));  // <.>
            var out = new DataOutputStream(new FileOutputStream("areas.bin"))) { // <.>
            while (true) {                                                       // <.>
                double radius = in.readDouble();
                out.writeDouble(Math.PI*radius*radius);              
            }           
        } catch (EOFException e) { // End of file reached <.>
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
