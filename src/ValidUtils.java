public class ValidUtils {
    public static String validateValues(String value) {
        if (value == null || value.isBlank() || value.isEmpty()) {
            throw new RuntimeException("Необходимо указать данные");
        } else {
            return value;
        }
    }
}

