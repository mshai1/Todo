import java.util.ArrayList;

public class tasklist {
    private ArrayList<task> task;

    public tasklist() {
        this.task = new ArrayList<>();
    }

    public void addTask(task task) {
        this.task.add(task);
    }

    public void removeTask(int id) {
        for (task t : task) {
            if (t.getId() == id) {
                task.remove(t);
                return;
            }
        }
    }

    public void updateTask(int id, task newTask) {
        for (task t : task) {
            if (t.getId() == id) {
                int taskIndex = task.indexOf(t);
                task.set(taskIndex, newTask);
                return;
            }
        }
    }

    public int size() {
        return task.size();
    }

    public task getTask(int id) {
        for (task t : task) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public ArrayList<task> getTasks() {
        return task;
    }

}
