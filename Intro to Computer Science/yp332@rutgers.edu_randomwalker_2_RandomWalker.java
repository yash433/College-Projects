public class RandomWalker {
    public static void main(String[]args){

        int size = Integer.parseInt(args[0]);
        int xPos = 0;
        int yPos = 0;

        int[] a = new int[size];
        //System.out.println(a.length);
        System.out.println("(0,0)");
        for (int i = 0; i < a.length; i++){
            int dir = (int)(Math.random()*4)+1;
            
            if (dir == 1)
                yPos++;
            if (dir == 2)
                yPos--;
            if (dir == 3)
                xPos++;
            if (dir == 4)
                xPos--;

            System.out.println("("+xPos+","+yPos+")");
            //System.out.println("direction: "+dir);
            
        }
        double s = ((xPos*xPos) + (yPos*yPos));
        System.out.println("Squared distance = "+s);
    }
}