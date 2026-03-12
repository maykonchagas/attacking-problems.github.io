import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileTester {
    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        printFileSize("full/chapters/file-io/programs/radiuses.bin");
        System.out.println();
        test4();
        System.out.println();
        //writeBaseballPlayers();
        test5();    
    }

    public static void test1() {
        Path file = Paths.get("full/chapters/file-io/programs/file.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
            while (in.hasNextInt()) {
                process(in.nextInt());
            }
        } catch (IOException e) {
            System.out.println("File " + file + " not found!");
        } finally { if (in != null) { in.close(); } }
    }

    public static void test2() {
        Path file = Paths.get("full/chapters/file-io/programs/file.txt");
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextInt()) {
                process(in.nextInt());
            }
        } catch (IOException e) {
            System.out.println("File " + file + " not found!");
        }
    }

    public static void test3() {
        Path file = Paths.get("full/chapters/file-io/programs/output.txt");
        try (PrintWriter out = new PrintWriter(file.toFile())) {            
            Random random = new Random();
            for (int i = 0; i < 100; ++i) {
                out.println(random.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + file + " not writable!");
        }
    }

    public static void test4() {
        try (DataInputStream in = new DataInputStream(new FileInputStream("full/chapters/file-io/programs/baseball.bin"))) {
            int records = in.readInt();
            int[] homeRuns = new int[records];
            int[] rbi = new int[records];
            double[] battingAverage = new double[records];
            for (int i = 0; i < records; ++i) {
                homeRuns[i] = in.readInt();
                rbi[i] = in.readInt();
                battingAverage[i] = in.readDouble();
            }
            System.out.println(Arrays.toString(homeRuns));
        } catch (IOException e) {
            System.out.println("File reading failed.");
        }
    }

    public static void writeBaseball() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("full/chapters/file-io/programs/baseball.bin"))) {
            final int records = 100;
            out.writeInt(records);
            Random random = new Random();            
            for (int i = 0; i < records; ++i) {
                out.writeInt(random.nextInt(800));
                out.writeInt(random.nextInt(2300));
                out.writeDouble(random.nextDouble() * .4);
            }
        } catch (IOException e) {
            System.out.println("File writing failed.");
        }
    }
    public static void writeBaseballPlayers() {
        BaseballPlayer[] players = new BaseballPlayer[100];
        Random random = new Random();            
        for (int i = 0; i < players.length; ++i) {
            players[i] = new BaseballPlayer(random.nextInt(800),
                random.nextInt(2300), random.nextDouble() * .4);
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("full/chapters/file-io/programs/players.bin"))) {
            out.writeInt(players.length);
            for (int i = 0; i < players.length; ++i) {
                out.writeObject(players[i]);
            }
        } catch (IOException e) {
            System.out.println("File writing failed.");
        }
    }

    public static void test5() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("full/chapters/file-io/programs/players.bin"))){
            int records = in.readInt();
            BaseballPlayer[] players = new BaseballPlayer[records];
            for (int i = 0; i < players.length; ++i) {
                players[i] = (BaseballPlayer)in.readObject();
            }
            Stream.of(players).forEach(e -> System.out.println(e.getBattingAverage()));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File reading failed.");
        }
    }


    public static void printFileSize(String fileName) {
        try (FileInputStream in = new FileInputStream(fileName)) {
            int count = 0;
            while (in.read() != -1) {
                ++count;
            }
            System.out.println("File size: " + count + " bytes");
        } catch (IOException e) {
            System.out.println("File " + fileName + " not readable!");
        }
    }


    public static void process(int value) {
        System.out.println(value);
    }
}