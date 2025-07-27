import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdvancedToDoList extends Frame {
    private ArrayList<Task> tasks = new ArrayList<>(); // List to store tasks
    private Panel taskPanel;

    public AdvancedToDoList() {
        // Set up the main frame
        setTitle("Advanced To-Do List");
        setSize(500, 600);
        setLayout(new BorderLayout());
        setVisible(true);

        // Header
        Label header = new Label("Advanced To-Do List", Label.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setBackground(Color.CYAN);
        header.setAlignment(Label.CENTER);
        add(header, BorderLayout.NORTH);

        // Input Panel
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new FlowLayout());
        TextField taskInput = new TextField(30);
        Button addButton = new Button("Add Task");
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.SOUTH);

        // Task Display Panel
        taskPanel = new Panel();
        taskPanel.setLayout(new GridLayout(0, 1)); // Dynamically adjust rows
        ScrollPane scrollPane = new ScrollPane();  // ScrollPane to wrap the taskPanel
        scrollPane.add(taskPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Add Task Button Action
        addButton.addActionListener(e -> {
            String taskText = taskInput.getText().trim();
            if (!taskText.isEmpty()) {
                addTask(taskText);
                taskInput.setText(""); // Clear input
            }
        });

        // Window Closing Event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Add a task to the list
    private void addTask(String taskText) {
        Task task = new Task(taskText);
        tasks.add(task);
        taskPanel.add(task.getTaskPanel());
        taskPanel.revalidate();
    }

    // Task Inner Class
    class Task {
        private String taskText;
        private boolean isCompleted = false;
        private Panel taskPanel;
        private Label taskLabel;

        public Task(String taskText) {
            this.taskText = taskText;

            taskPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
            taskLabel = new Label(taskText);
            taskLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            taskLabel.setBackground(Color.LIGHT_GRAY);
            taskLabel.setPreferredSize(new Dimension(300, 30));

            Button completeButton = new Button("Complete");
            Button removeButton = new Button("Remove");

            completeButton.addActionListener(e -> toggleComplete());
            removeButton.addActionListener(e -> removeTask());

            taskPanel.add(taskLabel);
            taskPanel.add(completeButton);
            taskPanel.add(removeButton);
        }

        // Toggle task completion
        private void toggleComplete() {
            isCompleted = !isCompleted;
            if (isCompleted) {
                taskLabel.setBackground(Color.GREEN);
                taskLabel.setText(taskText + " (Completed)");
            } else {
                taskLabel.setBackground(Color.LIGHT_GRAY);
                taskLabel.setText(taskText);
            }
        }

        // Remove task
        private void removeTask() {
            taskPanel.setVisible(false);
            taskPanel.getParent().remove(taskPanel);
            tasks.remove(this);
            taskPanel.getParent().revalidate();
        }

        // Get the task panel
        public Panel getTaskPanel() {
            return taskPanel;
        }
    }

    public static void main(String[] args) {
        new AdvancedToDoList();
    }
}
