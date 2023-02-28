
public class CheckDigit{
    public static void main(String[]args)
    {
        long num = Long.parseLong(args[0]);
        long sum = 0;
        long count = 0;
        long sum1 = 0;


        while(num >0)
        {
            count++;
            long digit = (int)(num%10);
            if (count % 2 == 1)
                sum = sum + digit;
            if (count % 2 == 0)
                sum1 = sum1 + digit;
        
        num = num/10;

        }
        sum = sum%10;
        sum1 = sum1%10;
        sum1 = sum1 * 3;
        long totalSum = sum+sum1;
        totalSum = totalSum%10;
        System.out.println(totalSum);
        
        
        


    }
}