import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class userInterface {
    private tasklist taskList;
    private Scanner scanner;
    public String choice;

    public userInterface() {
        this.taskList = new tasklist();
        this.scanner = new Scanner(System.in);
    }

    public String welcomeMessage() {
        return "Welcome to the Task Manager!";
    }

    public String menu() {
        return "1: Add a task\n2: Remove a task\n3: Update a task\n4: List all tasks\n0: Exit";
    }

    public void userOption() {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.print("Enter your choice: ");
        choice = scanner.nextLine();
        scanner.nextLine();
    }

    public void addTask(String choice) {
        if (choice.equals("1")) {
            System.out.print("Enter task title: ");
            String title = scanner.nextLine();

            System.out.print("Enter task description: ");
            String description = scanner.nextLine();

            System.out.println("Would you like to set a due date? (y/n)");
            String setDueDate = scanner.nextLine();
            if (setDueDate.equalsIgnoreCase("y")) {
                System.out.println("Enter due date (dd/MM/yyyy): ");
                String dateString = scanner.nextLine();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dueDate = null;

                try {
                    dueDate = dateFormat.parse(dateString);
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Due date not set.");
                }

                System.out.println("Enter task status (NOTSTARTED, INPROGRESS, COMPLETED): ");
                String statusString = scanner.nextLine();
                Status status = null;

                try {
                    status = Status.valueOf(statusString.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid status. Task status set to NOTSTARTED.");
                    status = Status.NOTSTARTED;
                }

                task task = new task(title, description, dueDate, status);
                taskList.addTask(task);
            }

            else {
                task task = new task(title, description);
                taskList.addTask(task);

            }
            System.out.println("Task added successfully.\n");
        }
    }

    public void removeTask(String choice) {
        if (choice.equals("2")) {
            System.out.print("Enter task ID to remove: ");
            int id = scanner.nextInt();
            taskList.removeTask(id);
            System.out.println("Task removed successfully.\n");
        }
    }

    public void updateTask(String choice) {
        if (choice.equals("3")) {
            System.out.print("Enter task ID to update: ");
            int id = scanner.nextInt();
            task updatedTask = taskList.getTask(id);
            scanner.nextLine();

            System.out.print("Enter new task title: ");
            updatedTask.setTitle(scanner.nextLine());

            System.out.print("Enter new task description: ");
            updatedTask.setDescription(scanner.nextLine());

            System.out.println("Would you like to set a new due date? (y/n)");
            String setDueDate = scanner.nextLine();
            if (setDueDate.equalsIgnoreCase("y")) {
                System.out.println("Enter new due date (dd/MM/yyyy): ");
                String dateString = scanner.nextLine();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dueDate = null;

                try {
                    dueDate = dateFormat.parse(dateString);
                    updatedTask.setDueDate(dueDate);
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Due date not set.");
                }

                System.out.println("Enter new task status (NOTSTARTED, INPROGRESS, COMPLETED): ");
                String statusString = scanner.nextLine();
                Status status = null;

                try {
                    status = Status.valueOf(statusString.toUpperCase());
                    updatedTask.setStatus(status);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid status. Task status set to NOTSTARTED.");
                    status = Status.NOTSTARTED;
                }

                // task newTask = new task(title, description, dueDate, status);
                taskList.updateTask(id, updatedTask);
            }

            else {
                // task newTask = new task(title, description);
                taskList.updateTask(id, updatedTask);
            }
            System.out.println("Task updated successfully.\n");
        }
    }

    public void displayTasks(String choice) {
        if (choice.equals("4")) {
            if (taskList.size() == 0) {
                System.out.println("No tasks to display.\n");
                return;
            } else {
                System.out.println("All tasks:");
                taskList.getTasks().forEach(task -> {
                    System.out.println(task);
                });
                System.out.println();
            }
        }
    }

    public void endProgram(String choice) {
        if (choice.equals("0")) {
            System.out.println(goodbyeMessage());
            System.exit(0);
        }

    }

    public String goodbyeMessage() {
        return "Goodbye!";
    }

}
