import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UnresponsiveGUI {
    private int count = 0;
        
    public UnresponsiveGUI() {
        JFrame frame = new JFrame("Unresponsive GUI");
		frame.setLayout(new GridLayout(4,1));
        JLabel answerLabel = new JLabel("Answer:");
        JLabel countLabel = new JLabel("0");

        JButton computeButton = new JButton("Compute");
        computeButton.addActionListener(e -> {
            answerLabel.setText("Computing...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ignore) {}
            answerLabel.setText("Answer: " + Math.sqrt(2.0));
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
        new UnresponsiveGUI();              
    }
}