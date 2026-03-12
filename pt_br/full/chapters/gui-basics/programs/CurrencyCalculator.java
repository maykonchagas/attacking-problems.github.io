import java.awt.*;
import javax.swing.*;

public class CurrencyCalculator extends JFrame {
    JTextField euroField = new JTextField ();
	JTextField dollarField = new JTextField ();
	JButton eurosToDollarsButton = new JButton("Convert to Dollars");
	JButton dollarsToEurosButton = new JButton("Convert to Euros");    
    final double DOLLAR_TO_EURO_RATE = 0.69319; // 1 US$ = 0.69319 Euros
    final double EURO_TO_DOLLAR_RATE = 1/DOLLAR_TO_EURO_RATE;
    
    public CurrencyCalculator(){
		super("Currency Calculator");      
		setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));        
		panel.add(new JLabel("Euros"));
		panel.add(new JLabel("Dollars"));		
        panel.add(euroField);
        panel.add(dollarField);
        panel.add(eurosToDollarsButton);
        panel.add(dollarsToEurosButton);         
		add(panel);
		
        eurosToDollarsButton.addActionListener(e -> eurosToDollars());
        dollarsToEurosButton.addActionListener(e -> dollarsToEuros());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
		pack();
    }
    
    private void eurosToDollars() {        
        try {
            double value = Double.parseDouble(euroField.getText());
            dollarField.setText("" + value*EURO_TO_DOLLAR_RATE);            
        } catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Euro value is incorrect.", "Format Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void dollarsToEuros() {        
        try {
            double value = Double.parseDouble(dollarField.getText());
            euroField.setText("" + value*DOLLAR_TO_EURO_RATE);
        } catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Dollar value is incorrect.", "Format Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public static void main(String [] args){        
        new CurrencyCalculator();
    }   
}
