import java.time.LocalDateTime;

public enum Repeatability  {
    ONETIME("Однократная"), DAILY("Ежедневная"), WEEKLY("Еженедельная"),
    MONTHLY("Ежемесячная"), ANNUAL("Ежегодная");
    private String repeatability;

    Repeatability(String repeatability) {
        this.repeatability = repeatability;
    }

    public String getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(String repeatability) {
        this.repeatability = repeatability;
    }

    @Override
    public String toString() {
        return repeatability;
    }



    //public void takeNextTime(Task task) {
    //        if (getRepeatability().equals("Ежедневная") && LocalDateTime.now().isAfter(task.getLocalDateTime())) {
    //            task.setLocalDateTime(task.getLocalDateTime().plusDays(1));
    //        }
    //        if (getRepeatability().equals("Еженедельная") && LocalDateTime.now().isAfter(task.getLocalDateTime())) {
    //            task.setLocalDateTime(task.getLocalDateTime().plusWeeks(1));
    //        }
    //        if (getRepeatability().equals("Ежемесячная") && LocalDateTime.now().isAfter(task.getLocalDateTime())) {
    //            task.setLocalDateTime(task.getLocalDateTime().plusMonths(1));
    //        }
    //        if (getRepeatability().equals("Ежегодная") && LocalDateTime.now().isAfter(task.getLocalDateTime())) {
    //            task.setLocalDateTime(task.getLocalDateTime().plusYears(1));
    //        }
    //    }
}
//public void takeNextTime(Task task, LocalDateTime localDateTime1) {
//        if (getRepeatability().equals("Ежедневная")) {
//            while (task.getLocalDateTime().isBefore(localDateTime1)) {
//                task.setLocalDateTime(task.getLocalDateTime().plusDays(1));
//            }
//        }
//        if (getRepeatability().equals("Еженедельная")) {
//            while (task.getLocalDateTime().isBefore(localDateTime1)) {
//                task.setLocalDateTime(task.getLocalDateTime().plusWeeks(1));
//            }
//        }
//
//    }

//        if (Task.this.repeatability.equals("Ежедневная")) {
//
//            while (localDateTime.isEqual(localDateTime1)) {
//                this.localDateTime = getLocalDateTime().plusDays(1);
//            }
//
//            if (localDateTime.isEqual(localDateTime1)) {
//                setLocalDateTime(localDateTime1);
//            }
//        }
//    }