import java.util.Date;

public class task {
    private static int nextId = 0;
    private int id;
    private String title;
    private String description;
    private Date dueDate;
    private Status status;

    public task(String title, String description, Date dueDate, Status status) {
        this.id = nextId++;
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        if (description != null && !description.isEmpty()) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Description cannot be empty");
        }

        this.dueDate = dueDate;
        this.status = status;
    }

    public task(String title, String description) {
        this.id = nextId++;
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        if (description != null && !description.isEmpty()) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        this.dueDate = new Date(); // Set dueDate to today's date
        this.status = Status.NOTSTARTED; // Set status to NOTSTARTED
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }

    public void setDescription(String description) {

        if (description != null && !description.isEmpty()) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Description cannot be empty");
        }
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
                "\nTitle: " + title +
                "\nDescription: " + description +
                "\nDue Date: " + dueDate +
                "\nStatus: " + status
                + "\n";
    }
}
