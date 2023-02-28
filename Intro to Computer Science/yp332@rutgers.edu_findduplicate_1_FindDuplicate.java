public class FindDuplicate {
    public static void main (String[]args) {

      int a = Integer.parseInt(args[0]);
      boolean duplicate = false;
     
      for (int i = 0; i < args.length; i++) {
       for (int j = i+1; j < args.length; j++){

        if (Integer.parseInt(args[i]) == Integer.parseInt(args[j])){
          duplicate = true;
          break;

        }
        
        
       }
   }
System.out.println(duplicate);

    }
}