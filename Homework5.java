package cop2805;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homework5 extends JFrame {
		
    private JTextField numField1;
    private JTextField numField2;
    private JComboBox<String> operationComboBox;
    private JButton calculateButton;
    private JLabel resultLabel;

    public Homework5() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 150);
        setLayout(new FlowLayout());

        
        numField1 = new JTextField(10);
        numField2 = new JTextField(10);

        operationComboBox = new JComboBox<>(new String[]{"Add", "Subtract", "Multiply", "Divide"});

        calculateButton = new JButton("Calculate");

        resultLabel = new JLabel("Answer:");

       
        add(new JLabel("Number 1: "));
        add(numField1);
        add(new JLabel("Number 2: "));
        add(numField2);
        add(new JLabel("Operation: "));
        add(operationComboBox);
        add(calculateButton);
        add(resultLabel);

        // action listener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
    }
    
    

    private void calculate() {
       
        String operation = (String) operationComboBox.getSelectedItem();

        double number1 = Double.parseDouble(numField1.getText());
        double number2 = Double.parseDouble(numField2.getText());

        double result = 0;
        switch (operation) {
            case "Add":
                result = number1 + number2;
                break;
            case "Subtract":
                result = number1 - number2;
                break;
            case "Multiply":
                result = number1 * number2;
                break;
            case "Divide":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    resultLabel.setText("Result: Error (Division by zero not accepted)");
                    return;
                }
                break;
        }

        
        resultLabel.setText("Answer: " + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Homework5 calculator = new Homework5();
                calculator.setVisible(true);
            }
        });
    }
}
