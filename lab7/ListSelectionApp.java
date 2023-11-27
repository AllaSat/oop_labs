import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ListSelectionApp extends JFrame {
    private DefaultListModel<String> availableListModel;
    private DefaultListModel<String> selectedListModel;
    private JList<String> availableList;
    private JList<String> selectedList;
    private JButton addButton;
    private JButton removeButton;
    private JButton saveButton;
    private JTextField fileNameField;

    public ListSelectionApp() {
        setTitle("List Selection App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        availableListModel = new DefaultListModel<>();
        availableListModel.addElement("США");
        availableListModel.addElement("Гондурас");
        availableListModel.addElement("Мадагаскар");
        availableListModel.addElement("Япония");
        availableListModel.addElement("Россия");

        selectedListModel = new DefaultListModel<>();

        availableList = new JList<>(availableListModel);
        selectedList = new JList<>(selectedListModel);

        addButton = new JButton("Перенести");
        removeButton = new JButton("Вернуть");
        saveButton = new JButton("Сохранить");
        fileNameField = new JTextField();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<String> selectedItems = availableList.getSelectedValuesList();
                for (String item : selectedItems) {
                    availableListModel.removeElement(item);
                    selectedListModel.addElement(item);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> selectedItems = selectedList.getSelectedValuesList();
                for (String item : selectedItems) {
                    selectedListModel.removeElement(item);
                    availableListModel.addElement(item);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                try {
                    FileWriter writer = new FileWriter(fileName);
                    for (int i = 0; i < selectedListModel.size(); i++) {
                        writer.write(selectedListModel.getElementAt(i) + "\n");
                    }
                    writer.close();
                    JOptionPane.showMessageDialog(ListSelectionApp.this, "Данные сохранены успешно");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(ListSelectionApp.this, "Ошибка сохранения данных");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(saveButton);

        JPanel filePanel = new JPanel();
        filePanel.setLayout(new FlowLayout());
        filePanel.add(new JLabel("Название файла:"));
        filePanel.add(fileNameField);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(1, 2));
        listPanel.add(new JScrollPane(availableList));
        listPanel.add(new JScrollPane(selectedList));

        add(listPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(filePanel, BorderLayout.NORTH);

        setVisible(true);
    }
}
