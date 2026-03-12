import java.io.IOException;
import java.nio.file.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.stream.Stream;

public class Directory {    
    public static void main(String[] args) {
        Path directory = Paths.get("."); // <.>
        try (Stream<Path> files = Files.list(directory)) { // <.>
            files.forEach(file -> printFile(file));         
        } catch (IOException e) {
            System.out.println("Files in the directory could not be listed.");
        }
    }

    public static void printFile(Path file) {
        try {
            long milliseconds = Files.getLastModifiedTime(file).toMillis(); // <.>
            String date = DateFormat.getDateInstance().format(new Date(milliseconds));
            System.out.print(date + "\t");	                                
            if (Files.isDirectory(file)) { // <.>
                System.out.print("directory");			
            } else {
                System.out.print("\t");
            }
            System.out.println("\t" +  file.getFileName()); // <.>
        } catch (IOException e) {
            System.out.println("Could not get last modified time from " + file);
        }
    }
}
