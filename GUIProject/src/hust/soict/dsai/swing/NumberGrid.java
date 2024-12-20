package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10]; // Number buttons (0-9)
    private JButton btnDelete, btnReset;            // Additional buttons
    private JTextField tfDisplay;                   // Display field

    public NumberGrid() {
        // Initialize display field
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // Right-aligned text

        // Panel to hold buttons
        JPanel panelButtons = new JPanel(new GridLayout(4, 3)); // 4 rows, 3 columns
        addButtons(panelButtons); // Add buttons to panel

        // Set up the content pane
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH); // Add display to the top
        cp.add(panelButtons, BorderLayout.CENTER); // Add buttons to the center

        // Frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        setTitle("Number Grid"); // Set title
        setSize(200, 200);       // Set frame size
        setVisible(true);        // Make the frame visible
    }

    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();
    
        for(int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(""+i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }
    
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);
    
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);
    
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
    
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if (button.equals("DEL")) {
                // handles the "DEL" case
            } else {
                // handles the "C" case
            }
        }
    }

}