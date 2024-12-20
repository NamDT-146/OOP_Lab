package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;  
    private JTextField tfOutput;
    private int sum = 0;       

    // Constructor to setup the GUI components and event handlers
    public SwingAccumulator() {
        Container cp = getContentPane(); // Get content pane
        cp.setLayout(new GridLayout(2, 2)); // Set grid layout: 2 rows, 2 columns

        cp.add(new JLabel("Enter an Integer: "));
        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener()); // Add action listener

        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false); // Make output field non-editable
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120); // Window size
        setVisible(true);  // Show window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window on exit
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText()); // Get input number
            sum += numberIn; // Update sum
            tfInput.setText(""); // Clear input field
            tfOutput.setText(sum + ""); // Display updated sum
        }
    }
}
