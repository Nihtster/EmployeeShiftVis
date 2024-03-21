package employeeshiftvis;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class InteractionPanel extends JPanel {

    private JList<String> peopleList;
    private JList<String> routeList;

    private DefaultListModel<String> peopleListModel;
    private DefaultListModel<String> routeListModel;
    private DefaultListModel<String> scheduleListModel;

    private Map<String, EmployeeOptionsPanel> personPanelMap;

    private JPanel schedulePanel;

    private DummyData dData = new DummyData();

    public InteractionPanel() {
        setLayout(new BorderLayout());

        // Initialize components
        peopleListModel = new DefaultListModel<>();
        routeListModel = new DefaultListModel<>();
        scheduleListModel = new DefaultListModel<>();
        personPanelMap = new HashMap<>();

        peopleList = new JList<>(peopleListModel);
        routeList = new JList<>(routeListModel);

        for (String person : dData.getPeopleData()) {
            peopleListModel.addElement(person);
        }

        for (String route : dData.getRouteData()) {
            routeListModel.addElement(route);
        }

        // Creation of Routes List and Employees List
        JScrollPane routeScrollPane = new JScrollPane(routeList);
        JScrollPane peopleScrollPane = new JScrollPane(peopleList);

        peopleList.setFont(new Font(null, Font.PLAIN, 20));
        routeList.setFont(new Font(null, Font.PLAIN, 20));

        // Creation and setup of the schedule Panel
        schedulePanel = new JPanel();
        JScrollPane scheduleScrollPane = new JScrollPane(schedulePanel);
        schedulePanel.setLayout(new BoxLayout(schedulePanel, BoxLayout.Y_AXIS));
        scheduleScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Adding Panels into SplitPlanes for organization
        JSplitPane splitPaneLeft = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, routeScrollPane, peopleScrollPane);
        splitPaneLeft.setResizeWeight(0.5);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPaneLeft, scheduleScrollPane);
        splitPane.setResizeWeight(0.5);

        // Button Creation to go into the interaction panel.
        JButton clearButton = new JButton("Clear");
        JButton generateButton = new JButton("Generate Schedule");

        add(splitPane, BorderLayout.CENTER);
        add(clearButton, BorderLayout.SOUTH);
        add(generateButton, BorderLayout.EAST);

        setVisible(true);

        // Add action listeners
        peopleList.addListSelectionListener(e -> handleSelection());
        clearButton.addActionListener(e -> clearSelection());
        generateButton.addActionListener(e -> generateSchedule());

    }

    private void handleSelection() {
        if (!peopleList.getValueIsAdjusting()) {
            String selectedPerson = peopleList.getSelectedValue();
            if (selectedPerson != null && !scheduleListModel.contains(selectedPerson)) {
                scheduleListModel.addElement(selectedPerson);
                EmployeeOptionsPanel personPanel = new EmployeeOptionsPanel(selectedPerson);
                personPanelMap.put(selectedPerson, personPanel);
                schedulePanel.add(personPanel);
                // schedulePanel.add(Box.createVerticalStrut(5));
                schedulePanel.revalidate();
                schedulePanel.repaint();
            }
        }
    }

    private void clearSelection() {
        scheduleListModel.removeAllElements();
        schedulePanel.removeAll();
        personPanelMap.clear();
        schedulePanel.revalidate();
        schedulePanel.repaint();
    }

    private void generateSchedule() {
        JOptionPane.showMessageDialog(schedulePanel, "Feature not Implemented",
                "Swing Tester", JOptionPane.ERROR_MESSAGE);
    }
}
