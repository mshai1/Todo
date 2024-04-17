import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        userInterface ui = new userInterface();
        ui.welcomeMessage();
        System.out.println("Do you want to use the terminal interface or GUI?");
        System.out.println("1. Terminal");
        System.out.println("2. GUI");

        Scanner scanner = new Scanner(System.in);

        int view = scanner.nextInt();
        scanner.nextLine(); // Consume newline character


        if (view == 1){
        while (true) {
            System.out.println(ui.menu());
            ui.userOption();

            switch (ui.choice) {
                case "1":
                    ui.addTask(ui.choice);
                    break;
                case "2":
                    ui.removeTask(ui.choice);
                    break;
                case "3":
                    ui.updateTask(ui.choice);
                    break;
                case "4":
                    ui.displayTasks(ui.choice);
                    break;
                case "0":
                    ui.endProgram(ui.choice);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    else if (view == 2) {
        // Start GUI interface
        TodoGUI gui = new TodoGUI();
        gui.display(); // Make the GUI visible
        
    } else {
        System.out.println("Invalid choice. Exiting...");
    }


    }
}
