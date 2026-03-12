import java.util.*;

public class VectorExample extends Thread {
    private List<String> list;

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();   // <.>
        
        Thread t1 = new VectorExample(list);     // <.>
        Thread t2 = new VectorExample(list);
        t1.start(); 
        t2.start();

		t1.join();
		t2.join();
        
        for (String text: list) {                // <.>
            System.out.println(text);
        }
    }
	
	public VectorExample(List<String> list) {
		this.list = list; 				         // <.>
	}
    
    public void run() { 
        for (int i = 0; i < 10; ++i) { 	         // <.>
            list.add(this.getName() + ": " + i); // <.>
            try { 
				Thread.sleep(1); 		         // <.>
			} catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}