public class TwoSmallest {

    public static void main(String[] args) {
        if (args.length >= 2) {
            double min1 = Double.MAX_VALUE, min2 = Double.MAX_VALUE, num;
            for (int i = 0; i < args.length; i++) {
                num = Double.parseDouble(args[i]);
                if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) {
                    min2 = num;
                }
            }
            System.out.println(min1);
            System.out.println(min2);
        } else {
            System.out.println("Please provide some numbers as command line arguments");
        }
    }
}
