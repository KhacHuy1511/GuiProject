import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
// Ứng dụng Task Manager chính
public class TaskManagerApp {
    private JFrame frame;
    private DefaultListModel<Task> taskListModel; // Model chứa danh sách các Task
    private JList<Task> taskList;

    public TaskManagerApp() {
        // Tạo JFrame chính
        frame = new JFrame("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Danh sách công việc hiển thị trong giao diện
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Thêm các nút chức năng
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Task");
        JButton toggleButton = new JButton("Toggle Status");

        // Panel chứa các nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(toggleButton);

        // Chức năng của nút "Add Task"
        addButton.addActionListener(e -> {
            String taskName = JOptionPane.showInputDialog(frame, "Enter Task Name:", "Add Task", JOptionPane.PLAIN_MESSAGE);
            if (taskName != null && !taskName.trim().isEmpty()) {
                taskListModel.addElement(new Task(taskName.trim()));
            } else {
                JOptionPane.showMessageDialog(frame, "Task name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Chức năng của nút "Remove Task"
        removeButton.addActionListener(e -> {
            Task selectedTask = taskList.getSelectedValue();
            if (selectedTask != null) {
                taskListModel.removeElement(selectedTask);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to remove.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Chức năng của nút "Toggle Status"
        toggleButton.addActionListener(e -> {
            Task selectedTask = taskList.getSelectedValue();
            if (selectedTask != null) {
                selectedTask.toggleCompleted();
                taskList.repaint(); // Cập nhật giao diện hiển thị trạng thái mới của Task
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to toggle status.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Thêm các thành phần vào JFrame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Hiển thị giao diện
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Chạy ứng dụng
        SwingUtilities.invokeLater(TaskManagerApp::new);
    }
}
