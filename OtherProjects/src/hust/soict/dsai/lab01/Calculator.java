package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please enter first number!", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please enter first number!", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        JOptionPane.showMessageDialog(null, sum, "Sum has been calculated", JOptionPane.PLAIN_MESSAGE);

        double diff = num1 - num2;
        JOptionPane.showMessageDialog(null, diff, "Difference has been calculated", JOptionPane.PLAIN_MESSAGE);

        double product = num1 * num2;
        JOptionPane.showMessageDialog(null, product, "Product has been calculated", JOptionPane.PLAIN_MESSAGE);

        if (num2 == 0){
            JOptionPane.showMessageDialog(null, "Divided by 0 error occured!");
        }
        else{
            double quotient = num1 / num2;
            JOptionPane.showMessageDialog(null, quotient, "Quotient has been calculated", JOptionPane.PLAIN_MESSAGE);
        }


        System.exit(0);
    }
}
