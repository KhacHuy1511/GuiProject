
// Class đại diện cho một công việc (Task)
class Task {
    private String name;
    private boolean isCompleted;

    public Task(String name) {
        this.name = name;
        this.isCompleted = false; // Mặc định công việc chưa hoàn thành
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void toggleCompleted() {
        isCompleted = !isCompleted; // Đổi trạng thái hoàn thành
    }

    @Override
    public String toString() {
        return (isCompleted ? "[Done] " : "[Pending] ") + name;
    }
}