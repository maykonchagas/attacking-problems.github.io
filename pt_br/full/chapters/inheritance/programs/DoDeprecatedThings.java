import java.util.Date;

public class DoDeprecatedThings {
    public static void main(String[] args) {
        doDeprecatedThings();
    }

    @SuppressWarnings("deprecation")
    public static void doDeprecatedThings() {
        Date today = new Date();
        System.out.println(today.getYear() + 1900);
    }
}
