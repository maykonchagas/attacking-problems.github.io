public class SwitchMonth {
    public static void main(String[] args) {
        String month = args[0];

        boolean validMonth = true;
        switch (month) {
            case "Jan", "Mar", "May", "Jul", "Aug", "Oct", "Dec" -> System.out.println("There are 31 days in " + month);
            case "Apr", "Jun", "Sep", "Nov" -> System.out.println("There are 30 days in " + month);
            case "Feb" -> System.out.println("There are 28 days in " + month);
            default -> {
                System.out.println("Unrecognized month: " + month);
                validMonth = false;
            }
        };
        
        if (!validMonth) {
            return;
        }

        int length = switch (month) {
            case "Jan", "Mar", "May", "Jul", "Aug", "Oct", "Dec" -> 31;
            case "Apr", "Jun", "Sep", "Nov" -> 30;
            case "Feb" -> 28;
            default -> 0;
        };

        if (length > 0) {
            System.out.println(month + " has " + length + " days");
        } else {
            System.out.println("Unrecognized month: " + month);
        }
    }
}
