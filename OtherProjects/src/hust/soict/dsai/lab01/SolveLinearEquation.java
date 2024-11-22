package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;

public class SolveLinearEquation{
    public static void main(String[] args) {
        String strA, strB;

        strA = JOptionPane.showInputDialog(null, "Input the value a of the equation form ax + b = 0");
        strB = JOptionPane.showInputDialog(null, "Input the value b of the equation form ax + b = 0");

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);

        if (a == 0){
            JOptionPane.showMessageDialog(null, "Invalid Equation!");
        }
        else JOptionPane.showMessageDialog(null, (-b) / a, "The only root have been solved", JOptionPane.PLAIN_MESSAGE);
    }
}