import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MovingObjects extends JFrame {
    private JPanel panel;
    private JLabel object1;
    private JLabel object2;
    private JLabel object3;

    public MovingObjects() {
        setTitle("Moving Objects");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(null);

        object1 = new JLabel("Object 1");
        object1.setBounds(50, 50, 100, 20);
        panel.add(object1);

        object2 = new JLabel("Object 2");
        object2.setBounds(50, 100, 100, 20);
        panel.add(object2);

        object3 = new JLabel("Object 3");
        object3.setBounds(50, 150, 100, 20);
        panel.add(object3);

        add(panel, BorderLayout.CENTER);

        setVisible(true);

        moveObject(object1);
        moveObject(object2);
        moveObject(object3);
    }

    private void moveObject(JLabel object) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                int x = object.getX();
                int y = object.getY();

                while (true) {
                    int dx = random.nextInt(5) - 2;
                    int dy = random.nextInt(5) - 2;

                    x += dx;
                    y += dy;

                    int finalX = x;
                    int finalY = y;
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            object.setLocation(finalX, finalY);
                        }
                    });

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
