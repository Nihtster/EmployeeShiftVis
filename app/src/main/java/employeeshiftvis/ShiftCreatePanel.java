package employeeshiftvis;

import javax.swing.*;
import java.awt.*;

public class ShiftCreatePanel extends JPanel {

    public ShiftCreatePanel() {
        setPreferredSize(new Dimension(1100, 800));
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0; // Allow horizontal resizing
        constraints.weighty = 1.0; // Allow vertical resizing

        JPanel graphPanel = new JPanel(new GridBagLayout());
        JLabel graphJLabel = new JLabel("Shift Graph Vis here");
        graphPanel.add(graphJLabel);
        JPanel mapPanel = new JPanel(new GridBagLayout());
        JLabel routeJLabel = new JLabel("Workday route Vis here");
        mapPanel.add(routeJLabel);

        JSplitPane visSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, graphPanel, mapPanel);
        visSplitPane.setResizeWeight(0.5);

        // mainPanel.add(shiftPanel);

        // Middle row
        // constraints.gridy = 1;
        InteractionPanel driverPanel = new InteractionPanel();
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, visSplitPane, driverPanel);
        splitPane.setResizeWeight(0.8); // Equal sizing

        add(splitPane, constraints);
        // mainFrame.add(splitPane);
        // mainFrame.pack();
        // mainFrame.setVisible(true);

    }
}
