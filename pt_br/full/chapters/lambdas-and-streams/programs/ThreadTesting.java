public class ThreadTesting {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Threaded world!"));
        thread.start();
    }
}