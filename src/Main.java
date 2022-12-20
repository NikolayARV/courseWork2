import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Diary diary = new Diary();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:

                            diary.addTask(inputTask(scanner));


                            break;
                        case 2:
                            diary.delTask(deleteTask(scanner));

                            break;
                        case 3:
                            diary.getDayTasks(findDay(scanner));
                            break;
                        case 4:

                            System.out.println(diary);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }

    }

    private static Task inputTask(Scanner scanner) {
        Task task = new Task();
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        task.setTaskName(taskName);
        System.out.print("Введите описание задачи: ");
        String description = scanner.next();
        task.setDescription(description);
        System.out.print("Выберите тип задачи: a - Личная задача, b - Рабочая задача: ");
        String type = scanner.next();
        if (type.equals("a")) {
            task.setType(Type.PERSONAL);
        } else if (type.equals("b")) {
            task.setType(Type.WORKTASK);
        } else throw new RuntimeException("Введите корректное значение");
        System.out.print("Введите дату задачи в формате YYYY-MM-DD: ");
        String date = scanner.next();
        task.setLocalDate(LocalDate.parse(date));
        System.out.print("Введите время задачи в формате HH:MM: ");
        String time = scanner.next();
        task.setLocalTime(LocalTime.parse(time));
        System.out.print("Выберете повторяемость: a - однократная, b - ежедневная, c - еженедельная," +
                "d - ежемесячная, e - ежегодная: ");
        String repeatability = scanner.next();
        if (repeatability.equals("a")) {
            task.setRepeatability(Repeatability.ONETIME);
        } else if (repeatability.equals("b")) {
            task.setRepeatability(Repeatability.DAILY);
        } else if (repeatability.equals("c")) {
            task.setRepeatability(Repeatability.WEEKLY);
        } else if (repeatability.equals("d")) {
            task.setRepeatability(Repeatability.MONTHLY);
        } else if (repeatability.equals("e")) {
            task.setRepeatability(Repeatability.ANNUAL);
        } else throw new RuntimeException("Введите корректное значение");
        return task;
    }

    private static int deleteTask(Scanner scanner) {
        System.out.print("Введите id задачи для удаления: ");
        int id = Integer.parseInt(scanner.next());
        return id;
    }

    private static LocalDate findDay(Scanner scanner) {
        System.out.print("Введите день в формате YYYY-MM-DD: ");
        LocalDate date = LocalDate.parse(scanner.next());
        return date;
    }

    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанный день
                        0. Выход
                        """
        );
    }
}