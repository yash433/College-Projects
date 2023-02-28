public class LargestOfFive {
    public static void main (String[]args)
    {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);
        int e = Integer.parseInt(args[4]);
        if (a > b && a > c && a > d && a > e)
            System.out.println(a);
        if (b > a && b > c && b > d && b > e)
            System.out.println(b);
        if (c > a && c > b && c > d && c > e)
            System.out.println(c);
        if (d > a && d > c && d > b && d > e)
            System.out.println(d);
        if (e > a && e > c && e > d && e > a)
            System.out.println(e);

    }
}