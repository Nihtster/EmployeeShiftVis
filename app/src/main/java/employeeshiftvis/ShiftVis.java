package employeeshiftvis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShiftVis extends JPanel {

    static Button b[][] = new Button[1][18];
    private static int startTime = 0;
    private static int endTime = 0;
    private static boolean startSet = false;
    private static boolean endSet = false;

    public ShiftVis(String driverName) {
        setLayout(new BorderLayout());

        JLabel driverLabel = new JLabel(driverName);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 18));

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 18; j++) {
                b[i][j] = new Button(String.valueOf(j));
                b[i][j].setSize(86, 86);
                buttonPanel.add(b[i][j]); // Add button to panel
                b[i][j].addMouseListener(new MyMouseListener()); // Add mouse listener
            }
        }

        add(driverLabel, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.EAST);
    }

    static class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            Button button = (Button) e.getSource();
            if (button.getBackground().equals(Color.RED)) {
                button.setBackground(UIManager.getColor("Button.background")); // Restore original color when
            } else {
                button.setBackground(Color.RED); // Change color when selected
                if (startSet == false) {
                    startTime = Integer.parseInt(button.getLabel());
                    System.out.println("Start time: " + startTime);
                    startSet = true;
                } else {
                    endTime = Integer.parseInt(button.getLabel());
                    if (endTime < startTime) {
                        endSet = false;
                    } else {
                        System.out.println("End time: " + endTime);
                        endSet = true;
                    }
                }
            }
        }
    }

    protected static void resetButtons() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 18; j++) {
                b[i][j].setBackground(UIManager.getColor("Button.background"));
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
