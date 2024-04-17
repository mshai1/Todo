import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class TodoGUI {
    private JFrame frame;
    private JButton addButton;
    private JButton removeButton;
    private JButton updateButton;
    private JButton displayButton;
    private tasklist tasklist = new tasklist();

    public TodoGUI() {
        // Set up the main frame
        frame = new JFrame("Todo List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create GUI components
        addButton = new JButton("Add Task");
        removeButton = new JButton("Remove Task");
        updateButton = new JButton("Update Task");
        displayButton = new JButton("Display All Tasks");

        // Add components to content pane
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(addButton);
        contentPane.add(removeButton);
        contentPane.add(updateButton);
        contentPane.add(displayButton);

        // Set up event handling
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter task title:");
                String description = JOptionPane.showInputDialog("Enter task description:");
                // Create a panel to hold the radio buttons
                JPanel radioPanel = new JPanel();
                radioPanel.setLayout(new FlowLayout());

                // Create the radio buttons
                JRadioButton defaultButton = new JRadioButton("Default");
                JRadioButton customButton = new JRadioButton("Custom");

                // Add the radio buttons to the panel
                radioPanel.add(defaultButton);
                radioPanel.add(customButton);

                // Add the panel to the frame
                frame.getContentPane().add(radioPanel);

                // Create a button group to ensure only one radio button can be selected
                ButtonGroup buttonGroup = new ButtonGroup();
                buttonGroup.add(defaultButton);
                buttonGroup.add(customButton);

                // Set up event handling for the radio buttons
                defaultButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        task newTask = new task(title, description);
                        tasklist.addTask(newTask);
                        // Handle default button selection
                        // Implement your logic here
                    }
                });

                customButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String dueDateString = JOptionPane.showInputDialog("Enter due date (dd/MM/yyyy):");
                        String statusString = JOptionPane.showInputDialog("Enter task status (NOTSTARTED, INPROGRESS, COMPLETED):");
                        Status[] statusOptions = Status.values();
                        JComboBox<Status> statusComboBox = new JComboBox<>(statusOptions);
                        statusComboBox.setSelectedIndex(0); // Set the default selected option

                        // Add the statusComboBox to the frame
                        frame.getContentPane().add(statusComboBox);

                        // Handle custom button selection
                        customButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String dueDateString = JOptionPane.showInputDialog("Enter due date (dd/MM/yyyy):");
                                Date date = Date.valueOf(dueDateString);
                                Status selectedStatus = (Status) statusComboBox.getSelectedItem();
                                // Handle custom button selection
                                // Implement your logic here
                                task newTask = new task(title, description, date, selectedStatus);
                                tasklist.addTask(newTask);
                            }
                        });
                    }
                });
                

            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle remove task button click
                // Implement your logic here
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle update task button click
                // Implement your logic here
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle display all tasks button click
                // Implement your logic here
            }
        });
    }

    public void display() {
        // Make the GUI visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create and display the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TodoGUI todoGUI = new TodoGUI();
                todoGUI.display();
            }
        });
    }
}
