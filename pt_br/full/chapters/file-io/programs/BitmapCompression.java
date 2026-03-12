import java.io.*;

public class BitmapCompression {
    public static void main(String[] args) {        
		if (args.length != 2) { // <.>
			System.out.println("Usage: java BitmapCompression (-c|-d) file");
		} else {
			try (var in = new DataInputStream(new FileInputStream(args[1]))) { // <.>
				if (args[0].equals("-c")) { // <.>
					compress(in, args[1]);
				} else if (args[0].equals("-d")) {
					decompress(in, args[1]);          
				}
			} catch (IOException e) { // <.>
				System.out.println("File not found: " + e.getMessage());
			}
		}
    }
    
    public static void compress(DataInputStream in, String file) {
        String compressed = file + ".compress";
		
        try (var out = new DataOutputStream(new FileOutputStream(compressed))) { // <.>
			byte current = 0;
			int count = 1;
			try {
				current = in.readByte(); // <.>
				while (true) {
					byte temp = in.readByte(); // <.>
					if (temp == current && count < 127) {
						++count; // <.>
					} else { // <.>
						out.writeByte(count);
						out.writeByte(current);               
						count = 1;
						current = temp;
					}
				}
			} catch (EOFException e) { // Last bytes <.>
				out.writeByte(count);
				out.writeByte(current);
			}			
        } catch (IOException e) { // <.>
			System.out.println("Compression failed: " + e.getMessage());
        }
    }
    
    public static void decompress(DataInputStream in, String file) {
        String original = file.substring(0, file.lastIndexOf(".compress")); // <.>

        try (var out = new DataOutputStream(new FileOutputStream(original))){ // <.>
            while (true) {            
				int count = in.readByte(); // <.>
                byte temp = in.readByte();           
                for (int i = 0; i < count; ++i) {
                    out.writeByte(temp);
				}                 
            }
        } catch (EOFException e) { // Input finished <.>
		} catch (IOException e) { // <.>
			System.out.println("Decompression failed: " + e.getMessage());
        }
    }
}