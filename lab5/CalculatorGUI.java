import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;

    public CalculatorGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        JLabel num1Label = new JLabel("Число 1:");
        num1Field = new JTextField();
        JLabel num2Label = new JLabel("Число 2:");
        num2Field = new JTextField();
        JLabel operatorLabel = new JLabel("Оператор (+, -, *, /):");
        JTextField operatorField = new JTextField();
        JButton calculateButton = new JButton("Расчет");
        resultLabel = new JLabel();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    String operator = operatorField.getText();

                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 == 0) {
                                throw new ArithmeticException("Ошибка: деление на ноль");
                            }
                            result = num1 / num2;
                            break;
                        default:
                            throw new IllegalArgumentException("Неправильный оператор");
                    }

                    resultLabel.setText("Результат: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Неправильный формат числа");
                } catch (ArithmeticException ex) {
                    resultLabel.setText("Ошибка: деление на ноль");
                } catch (IllegalArgumentException ex) {
                    resultLabel.setText(ex.getMessage());
                }
            }
        });

        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(operatorLabel);
        add(operatorField);
        add(calculateButton);
        add(resultLabel);

        setVisible(true);
    }
}
