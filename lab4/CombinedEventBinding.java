import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CombinedEventBinding extends JFrame {
    private JComboBox<String> comboBox;
    private JCheckBox checkBox;
    private JTextField textField;
    private JLabel selectionLabel;
    private JLabel resultLabel;

    public CombinedEventBinding() {
        setTitle("Combined Event Binding");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        comboBox = new JComboBox<>(new String[]{"Россия", "США", "Гондурас"});
        checkBox = new JCheckBox("Проверь меня");
        textField = new JTextField(10);
        selectionLabel = new JLabel("Выбранная опция: ");
        resultLabel = new JLabel("Результат: ");

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                selectionLabel.setText("Выбранная опция: " + selectedOption);
            }
        });

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selectionLabel.setText("Выбран: Проверен");
                } else {
                    selectionLabel.setText("Выбран: Не проверен");
                }
            }
        });

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = textField.getText();
                resultLabel.setText("Результат: " + text);
            }
        });

        add(new JLabel("ComboBox:"));
        add(comboBox);
        add(new JLabel("CheckBox:"));
        add(checkBox);
        add(new JLabel("TextField:"));
        add(textField);
        add(new JLabel());
        add(new JLabel());
        add(selectionLabel);
        add(resultLabel);

        setVisible(true);
    }
}
