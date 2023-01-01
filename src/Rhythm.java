import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Rhythm {
    void takeNextDate();
    void compareDay(LocalDate localDate);
}
