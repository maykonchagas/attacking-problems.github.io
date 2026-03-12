import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WorkerGUI {
    private int count = 0;  
       
    public WorkerGUI() {
        JFrame frame = new JFrame("Unresponsive GUI");
        frame.setLayout(new GridLayout(4,1));
        JLabel answerLabel = new JLabel("Answer:");
        JLabel countLabel = new JLabel("0");

        JButton computeButton = new JButton("Compute");
        computeButton.addActionListener(e -> {
            SwingWorker<String,Void> worker = new SwingWorker<>() { // <.>
                public String doInBackground() { // <.>
                    try {
                        Thread.sleep(5000);
                    } catch (Exception ignore) {}
                    return "Answer: " + Math.sqrt(2.0); // <.>
                }

                public void done() { // <.>
                    try {
                        answerLabel.setText(get());
                    } catch (Exception ignore) {}
                }
            };
            worker.execute(); // <.>
            answerLabel.setText("Computing...");
        });

        JButton incrementButton = new JButton("Increment");
        incrementButton.addActionListener(e -> countLabel.setText("" + ++count));

        frame.add(answerLabel);
        frame.add(computeButton);
        frame.add(countLabel);
        frame.add(incrementButton);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,150);
        frame.setVisible(true);
    }
	
	public static void main(String[] args) {
		new WorkerGUI();
    }
}
