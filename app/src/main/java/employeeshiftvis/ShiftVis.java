package employeeshiftvis;

import javax.swing.*;

import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.awt.event.*;

public class ShiftVis extends JPanel {

    static JButton b[][] = new JButton[1][18];
    private static int startTime = 0;
    private static int endTime = 0;
    private static boolean startSet = false;
    private static boolean endSet = false;

    public ShiftVis(String driverName) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBorder(BorderFactory.createLineBorder(Color.black));

        Dimension dim = new Dimension(990, 100);
        setPreferredSize(dim); // Set preferred size

        JLabel driverLabel = new JLabel(driverName);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 18));
        buttonPanel.setPreferredSize(dim);

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 18; j++) {
                b[i][j] = new JButton(String.valueOf(j));
                b[i][j].setSize(10, 10);
                b[i][j].setOpaque(false);
                b[i][j].setContentAreaFilled(false);
                b[i][j].setBorderPainted(false);
                buttonPanel.add(b[i][j]); // Add button to panel
                b[i][j].addActionListener(new MyMouseListener()); // Add mouse listener
            }
        }

        add(driverLabel);
        add(buttonPanel);
    }

    static class MyMouseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setContentAreaFilled(true);
            button.setOpaque(true);
            if (button.getBackground().equals(Color.RED)) {
                button.setBackground(UIManager.getColor("Button.background")); // Restore original color when
            } else {
                button.setBackground(Color.RED); // Change color when selected
                if (startSet == false) {
                    startTime = Integer.parseInt(button.getText());
                    System.out.println("Start time: " + startTime);
                    startSet = true;
                } else {
                    endTime = Integer.parseInt(button.getText());
                    if (endTime < startTime) {
                        JOptionPane.showMessageDialog(null, "ERR: End time cannot be before the end time.",
                                "Swing Tester", JOptionPane.ERROR_MESSAGE);
                        endSet = false;
                    } else if (startSet && !endSet) {
                        System.out.println("End time: " + endTime);
                        for (int i = startTime; i < endTime; i++) {
                            b[0][i].setContentAreaFilled(true);
                            b[0][i].setOpaque(true);
                            b[0][i].setBackground(Color.RED);
                        }
                        endSet = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "ERR: Extra click not allowed",
                                "Swing Tester", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    protected static void resetButtons() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 18; j++) {
                b[i][j].setBackground(UIManager.getColor("Button.background"));
                b[i][j].setOpaque(false);
                b[i][j].setContentAreaFilled(false);
                b[i][j].setBorderPainted(false);
            }
        }
    }

    protected int getStartTime() {
        return startTime;
    }

    protected int getEndTime() {
        return endTime;
    }

    protected void resetStart() {
        startTime = 0;
        startSet = false;
    }

    protected void resetEnd() {
        endTime = 0;
        endSet = false;
    }

}
