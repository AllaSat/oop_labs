import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogicalOperationsGUI extends JFrame {
    private JTextField operand1Field;
    private JTextField operand2Field;
    private JComboBox<String> operationComboBox;
    private JLabel resultLabel;

    public LogicalOperationsGUI() {
        setTitle("Logical Operations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        JLabel operand1Label = new JLabel("Операнд 1:");
        operand1Field = new JTextField();
        JLabel operand2Label = new JLabel("Операнд 2:");
        operand2Field = new JTextField();
        JLabel operationLabel = new JLabel("Операция:");
        String[] operations = {"Сумма", "Разность", "Произведение", "Max", "Min"};
        operationComboBox = new JComboBox<>(operations);
        JLabel emptyLabel = new JLabel();
        JButton calculateButton = new JButton("Расчет");
        JLabel resultTextLabel = new JLabel("Результат:");
        resultLabel = new JLabel();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int operand1 = Integer.parseInt(operand1Field.getText());
                int operand2 = Integer.parseInt(operand2Field.getText());
                String selectedOperation = (String) operationComboBox.getSelectedItem();

                BinaryOperation operation;

                switch (selectedOperation) {
                    case "Сумма":
                        operation = new AdditionOperation();
                        break;
                    case "Разность":
                        operation = new SubtractionOperation();
                        break;
                    case "Произведение":
                        operation = new MultiplicationOperation();
                        break;
                    case "Max":
                        operation = new MaxOperation();
                        break;
                    case "Min":
                        operation = new MinOperation();
                        break;
                    default:
                        operation = null;
                        break;
                }

                if (operation != null) {
                    operation.printOperationName();
                    operation.printOperationSign();
                    int result = operation.performOperation(operand1, operand2);
                    resultLabel.setText("Результат: " + result);
                } else {
                    resultLabel.setText("Ошибка выбора операции");
                }
            }
        });

        add(operand1Label);
        add(operand1Field);
        add(operand2Label);
        add(operand2Field);
        add(operationLabel);
        add(operationComboBox);
        add(emptyLabel);
        add(calculateButton);
        add(resultTextLabel);
        add(resultLabel);

        setVisible(true);
    }
}
