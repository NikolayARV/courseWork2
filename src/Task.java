import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Task implements Rhythm {
    private String taskName;
    private String description;
    private Type type;
    private LocalDate localDate;
    private LocalTime localTime;
    private Repeatability repeatability;
    private final int id;
    public static int count = 1;

    public Task(String taskName, String description, Type type, LocalDate localDate, LocalTime localTime, Repeatability repeatability) {
        this.taskName = ValidUtils.validateValues(taskName);
        this.description = ValidUtils.validateValues(description);
        this.type = type;
        this.localDate = localDate;
        this.localTime = localTime;
        this.repeatability = repeatability;
        this.id = count++;
    }

    public Task() {
        this.id = count++;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskName() {
        return taskName;
    }

    public Type getType() {
        return type;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setRepeatability(Repeatability repeatability) {
        this.repeatability = repeatability;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public int getId() {
        return id;
    }

    @Override
    public void compareDay(LocalDate localDate1) {
        switch (getRepeatability()) {
            case ONETIME:
                if (getLocalDate().isEqual(localDate1))
                    setLocalDate(getLocalDate());
                break;
            case DAILY:
                while (getLocalDate().isBefore(localDate1))
                    setLocalDate(getLocalDate().plusDays(1));
                break;
            case WEEKLY:
                while (getLocalDate().isBefore(localDate1))
                    setLocalDate(getLocalDate().plusWeeks(1));
                break;
            case MONTHLY:
                while (getLocalDate().isBefore(localDate1))
                    setLocalDate(getLocalDate().plusMonths(1));
                break;
            case ANNUAL:
                while (getLocalDate().isBefore(localDate1))
                    setLocalDate(getLocalDate().plusYears(1));
                break;
        }

    }

    @Override
    public void takeNextDate() {
        switch (getRepeatability()) {
            case DAILY:
                setLocalDate(getLocalDate().plusDays(1));
                break;
            case WEEKLY:
                setLocalDate(getLocalDate().plusWeeks(1));
                break;
            case MONTHLY:
                setLocalDate(getLocalDate().plusMonths(1));
                break;
            case ANNUAL:
                setLocalDate(getLocalDate().plusYears(1));
                break;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id && taskName.equals(task.taskName) && description.equals(task.description) && type == task.type && localDate.equals(task.localDate) && repeatability == task.repeatability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName, description, type, localDate, repeatability, id);
    }

    @Override
    public String toString() {
        return "Задача: " + taskName +
                ", описание: " + description +
                ", тип: " + getType() +
                ", дата и время начала выполнения: " + localDate + " " + localTime +
                ", повторяемость " + getRepeatability() +
                ", id: " + id;
    }
}

