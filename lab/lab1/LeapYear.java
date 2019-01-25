public class LeapYear{
    /**
     * check if the year is a leap year
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year){
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        if (args.length < 1){
            System.out.println("Please enter years!");
        }
        for (int i = 0; i < args.length; i++){
            try {
                int year = Integer.parseInt(args[i]);
                if (isLeapYear(year)){
                    System.out.println(year + " is a leap year.");
                } else {
                    System.out.println(year + " is not a leap year.");
                }
            } catch (NumberFormatException e) {
                System.out.println(args[i] + " is not a valid year.");
            }
        }

    }
}