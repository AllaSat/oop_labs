import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class DepositCalculatorGUI extends JFrame {
    private JTextField amountField;
    private JTextField interestRateField;
    private JTextField yearsField;
    private JLabel totalAmountLabel;
    private JLabel interestLabel;

    public DepositCalculatorGUI() {
        setTitle("Deposit Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        JLabel amountLabel = new JLabel("Сумма вклада:");
        amountField = new JTextField();
        JLabel interestRateLabel = new JLabel("Процентная ставка:");
        interestRateField = new JTextField();
        JLabel yearsLabel = new JLabel("Срок вклада (в годах):");
        yearsField = new JTextField();
        JLabel emptyLabel = new JLabel();
        JButton calculateButton = new JButton("Рассчитать");
        totalAmountLabel = new JLabel();
        interestLabel = new JLabel();

        calculateButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            double interestRate = Double.parseDouble(interestRateField.getText());
            int years = Integer.parseInt(yearsField.getText());

            double totalAmount = amount * Math.pow(1 + (interestRate / 100), years);
            double interest = totalAmount - amount;

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            totalAmountLabel.setText("Итоговая сумма: " + decimalFormat.format(totalAmount));
            interestLabel.setText("Доход: " + decimalFormat.format(interest));
        });

        add(amountLabel);
        add(amountField);
        add(interestRateLabel);
        add(interestRateField);
        add(yearsLabel);
        add(yearsField);
        add(emptyLabel);
        add(calculateButton);
        add(totalAmountLabel);
        add(interestLabel);

        setVisible(true);
    }
}
