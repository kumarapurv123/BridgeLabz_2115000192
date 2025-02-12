class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskList {
    private Task head;
    private Task current;

    public CircularTaskList() {
        this.head = null;
        this.current = null;
    }

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
            current = head;
        } else {
            Task tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
            current = head;
        } else {
            Task tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newTask;
            newTask.next = head;
        }
    }

    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position == 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task current = head;
        int i = 0;
        while (i < position - 1 && current.next != head) {
            current = current.next;
            i++;
        }
        if (i == position - 1) {
            newTask.next = current.next;
            current.next = newTask;
        }
    }

    public void removeByTaskId(int taskId) {
        if (head == null) {
            return;
        }
        if (head.taskId == taskId) {
            if (head.next == head) {
                head = null;
                current = null;
            } else {
                Task tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                head = head.next;
                tail.next = head;
                current = head;
            }
            return;
        }
        Task current = head;
        while (current.next != head && current.next.taskId != taskId) {
            current = current.next;
        }
        if (current.next.taskId == taskId) {
            current.next = current.next.next;
        }
    }

    public Task viewCurrentTask() {
        Task task = current;
        if (current != null) {
            current = current.next;
        }
        return task;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        Task current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    public Task searchByPriority(int priority) {
        if (head == null) {
            return null;
        }
        Task current = head;
        do {
            if (current.priority == priority) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        CircularTaskList taskList = new CircularTaskList();
        taskList.addAtEnd(1, "Task One", 2, "2025-02-15");
        taskList.addAtEnd(2, "Task Two", 1, "2025-02-16");
        taskList.addAtBeginning(3, "Task Three", 3, "2025-02-14");

        System.out.println("All Tasks:");
        taskList.displayAll();

        Task currentTask = taskList.viewCurrentTask();
        if (currentTask != null) {
            System.out.println("Task ID: " + currentTask.taskId + ", Task Name: " + currentTask.taskName);
        }

        taskList.removeByTaskId(1);

        taskList.displayAll();

        Task priorityTask = taskList.searchByPriority(1);
        if (priorityTask != null) {
            System.out.println("Found Task: " + priorityTask.taskName);
        } else {
            System.out.println("Task not found.");
        }
    }
}
