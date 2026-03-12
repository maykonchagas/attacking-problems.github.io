import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AreaFromRadiusText {
    public static void main(String[] args) {
        Path inFile = Paths.get("radiuses.txt");
        Path outFile = Paths.get("areas.txt");

        try (var in = new Scanner(inFile);		             // <.>
            var out = new PrintWriter(outFile.toFile())) {   // <.>
            while (in.hasNextDouble()) {		             // <.>
                double radius = in.nextDouble();	         // <.>
                out.format("%.3f%n", Math.PI*radius*radius); // <.>
            }
        } catch (IOException e) { 	                         // <.>
            System.out.println(e.getMessage());
        }
    }
}
