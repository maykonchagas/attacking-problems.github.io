import javax.swing.JFileChooser; // <.>
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileChooserExample {
	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser(); // <.>
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png");
		chooser.setFileFilter(filter); // <.>
		
		int result = chooser.showOpenDialog(null);          // <.>
		if (result == JFileChooser.APPROVE_OPTION) { 		// <.>
			Path file = chooser.getSelectedFile().toPath(); // <.>
			if (Files.exists(file)) {						// <.>
				try {
					long size = Files.size(file);
					System.out.println("The file contains " + size + " bytes.");
				} catch (IOException e) {
					System.out.println("There was a problem accessing the file.");
				}
			} else {
				System.out.println("The file doesn't exist.");
			}
		} else {
			System.out.println("The user probably canceled.");
		}
	}
}