import java.lang.*;               //for using Math.cos() and Math.sin() and Math.toRadians() funcitons in rotate method
public class PolygonTransform
{
   public static double[] copy(double[] array)
   {
       double[] newArray = new double[array.length];
       for(int i=0;i<array.length;i++)
       {
           newArray[i] = array[i];

       }return newArray;
   }

   public static void scale(double[]x,double[]y,double alpha)
   {
       for(int i=0;i<x.length;i++)
       {
           x[i] *= alpha;
           y[i] *= alpha;
       }
   }

   public static void translate(double[]x,double[]y,double dx,double dy)
   {
       for(int i=0;i<x.length;i++)
       {
           x[i] += dx;
           y[i] += dy;
       }
   }

   public static void rotate(double[] x, double[]y,double theta)
   {
       double rad = Math.toRadians(theta);
       double temp;
       for(int i=0;i<x.length;i++)
       {
           temp = x[i];                           //For storing temporarily the previous value of x before changing so tha it can be used in changing y
           x[i] = x[i]*Math.cos(rad) - y[i]*Math.sin(rad);
           y[i] = y[i]*Math.cos(rad) + temp*Math.sin(rad);

       }
   }

   public static void main(String args[])
   {
       // Scales polygon by the factor 2.
	   StdDraw.setScale(-5.0, +5.0);
	   double[] x = { 0, 1, 1, 0 };
	   double[] y = { 0, 0, 2, 1 };
	   double alpha = 2.0;
	   StdDraw.setPenColor(StdDraw.RED);
	   StdDraw.polygon(x, y);
	   scale(x, y, alpha);
	   StdDraw.setPenColor(StdDraw.BLUE);
       StdDraw.polygon(x, y);


       // Translates polygon by (2, 1).
	   StdDraw.setScale(-5.0, +5.0);
	   double[] xx = { 0, 1, 1, 0 };
	   double[] yy= { 0, 0, 2, 1 };
	   double dx = 2.0, dy = 1.0;
	   StdDraw.setPenColor(StdDraw.RED);
	   StdDraw.polygon(xx, yy);
	   translate(xx, yy, dx, dy);
	   StdDraw.setPenColor(StdDraw.BLUE);
	   StdDraw.polygon(xx, yy);

	   // Rotates polygon 45 degrees.
	   StdDraw.setScale(-5.0, +5.0);
	   double[] xxx = { 0, 1, 1, 0 };
	   double[] yyy = { 0, 0, 2, 1 };
	   double theta = 45.0;
	   StdDraw.setPenColor(StdDraw.RED);
	   StdDraw.polygon(xxx, yyy);
	   rotate(xxx, yyy, theta);
	   StdDraw.setPenColor(StdDraw.BLUE);
StdDraw.polygon(xxx, yyy);
   }
}