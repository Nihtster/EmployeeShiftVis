package employeeshiftvis;

import java.awt.*;
import javax.swing.*;

public class EmployeeOptionsPanel extends JPanel {
    private JLabel nameLabel;
    private JComboBox<String> startTimeComboBox;
    private JComboBox<String> endTimeComboBox;
    private JComboBox<String> routeComboBox;

    public EmployeeOptionsPanel(String personName) {
        // setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, 100));
        setMaximumSize(new Dimension(300, 100));

        JPanel nameAndTimePanel = new JPanel();
        nameAndTimePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        nameLabel = new JLabel(personName);
        nameLabel.setFont(new Font(null, Font.PLAIN, 16));
        startTimeComboBox = new JComboBox<>(new String[] { "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM" });
        endTimeComboBox = new JComboBox<>(new String[] { "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM" });
        nameAndTimePanel.add(nameLabel);
        nameAndTimePanel.add(startTimeComboBox);
        nameAndTimePanel.add(endTimeComboBox);

        JPanel routePanel = new JPanel();
        routePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        routeComboBox = new JComboBox<>(new String[] { "Route 1", "Route 2", "Route 3", "Route 4" });
        JLabel routeLabel = new JLabel("Route");
        routeLabel.setFont(new Font(null, Font.PLAIN, 16));
        routePanel.add(routeLabel);
        routePanel.add(routeComboBox);

        add(nameAndTimePanel);
        add(routePanel);
    }
}
