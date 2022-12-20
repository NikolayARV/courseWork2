import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Diary   {
    private HashMap<Integer, Task> diary = new HashMap<>();

    public void addTask(Task task) {
        diary.put(task.getId(), task);
    }

    public void delTask(Integer id) {
        diary.remove(id);
    }

    public void getDayTasks(LocalDate localDate1) {
        for (Task date : diary.values())  {
            date.compareDay(localDate1);
            if (date.getLocalDate().equals(localDate1)) {
                System.out.println(date);
            }
        }
            }


    @Override
    public String toString() {
        return "Diary" +
                 diary +
                '}';
    }


}
