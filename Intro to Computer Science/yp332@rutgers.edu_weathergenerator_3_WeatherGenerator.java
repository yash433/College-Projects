


public class WeatherGenerator {

    static final int WET = 1; // Use this value for a wet day
    static final int DRY = 2; // Use this value for a dry day

    // Number of days in each month, January is index 0, February is index 1
    static final int[] numberOfDaysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    public static int[] oneMonthGenerator(double longitute, double latitude,
    int month, double[][] drywet, double[][] wetwet) {



		           int numberOfDays = numberOfDaysInMonth[month-2];
		           int[] forecast = new int[numberOfDays];
		           double random = StdRandom.uniform();

		           if (random < 0.5)
		           {
		               forecast[0] = WET;
		           }
		           else
		           {
		               forecast[0] = DRY;
		           }

		           double wetWetProbab = -1;
		           double dryWetProbab = -1;

		           for(int i = 0 ; i<wetwet.length; i++)
		           {   boolean found = false;
		                   for(int j = 0; j<wetwet[i].length; j++)
		                   {
		                       if(wetwet[i][0]==longitute && wetwet[i][1]==latitude && drywet[i][0]==longitute && drywet[i][1]==latitude)
		                       {


		                           found = true;
		                           wetWetProbab = wetwet[i][month];
		                           dryWetProbab = drywet[i][month];
		                       }

		                   }
		                   if(found)
		                   {
		                       break;
		                   }
		           }


		                       for(int k = 1; k<forecast.length; k++)
		                       {
		                           if(forecast[k-1]== WET)
		                       {
		                           double random1 = StdRandom.uniform();
		                           if(random1<= wetWetProbab)
		                       {
		                           forecast[k] = WET;
		                       }
		                       else
		                       {
		                           forecast[k] = DRY;
		                       }
		                       }
		                       else
		                       {
		                           double random2 = StdRandom.uniform();
		                           if(random2<= dryWetProbab)
		                       {
		                           forecast[k] = WET;
		                       }
		                       else
		                       {
		                           forecast[k] = DRY;
		                       }

		           }
		           }



		           return forecast;



    }

    /*
     * Returns the number of mode (WET or DRY) days in forecast.
     */
    public static int numberOfWetDryDays (int[] forecast, int mode) {
		int days = 0;
		for (int i = 0; i < forecast.length; i ++){
			if(forecast[i] == mode){
				days++;
			}
		}
			return days;


    }

    /*
     * Returns the longest number of consecutive mode (WET or DRY) days in forecast.
     */

        // WRITE YOUR CODE HERE
   public static int lengthOfLongestSpell (int[] forecast, int mode)
   {
	   int count = 0;
	   for (int i = 0; i <forecast.length; i++){
		   int currentCount = 1;
		   for (int j = i+1; j < forecast.length; j++){
			   if (forecast[i] == mode && forecast[j] == mode){
				   currentCount++;
			   }
			   else {
				   break;
			   }
		   }
		   if (currentCount > count){
			   count = currentCount;
		   }
	   }
	   return count;


	   }


    public static void readTransitionProbabilities ( double[][] arrayToFill,
    int numberOfLocations ) {
        int row = 0;
        while (row < numberOfLocations) {
            arrayToFill[row][0] = StdIn.readDouble();  // Longitute
            arrayToFill[row][1] = StdIn.readDouble();  // Latitude
            arrayToFill[row][2] = StdIn.readDouble();  // January
            arrayToFill[row][3] = StdIn.readDouble();  // February
            arrayToFill[row][4] = StdIn.readDouble();  // March
            arrayToFill[row][5] = StdIn.readDouble();  // April
            arrayToFill[row][6] = StdIn.readDouble();  // May
            arrayToFill[row][7] = StdIn.readDouble();  // June
            arrayToFill[row][8] = StdIn.readDouble();  // July
            arrayToFill[row][9] = StdIn.readDouble();  // August
            arrayToFill[row][10] = StdIn.readDouble(); // Septmber
            arrayToFill[row][11] = StdIn.readDouble(); // October
            arrayToFill[row][12] = StdIn.readDouble(); // November
            arrayToFill[row][13] = StdIn.readDouble(); // December
            row += 1;
        }
    }


    public static void populateTransitionProbabilitiesArrays(double[][] drywet,
    double[][] wetwet, int numberOfLocations) {

        // Read transition probabilities that reflects how often the weather
        // changes from wet to dry into 2D array drywet.
        // The first line on the file has number of locations (lines)
        StdIn.setFile("drywet.txt");
        readTransitionProbabilities(drywet, numberOfLocations);

        // Read transition probabilities that reflects that the weather remains
        // wet from one day to the next into 2D array wetwet.
        // The first line on the file has number of locations (lines)
        StdIn.setFile("wetwet.txt");
        readTransitionProbabilities(wetwet, numberOfLocations);
    }

    /*
     *
     * Reads the files containing the transition probabilities for US locations.
     *
     * To find
     *
     * Execution:
     *   java WeatherGenerator -97.58 26.02 3
     *
     *
     */

    public static void main (String[] args) {

        int numberOfRows    = 4001; // Total number of locations
        int numberOfColumns = 14;   // Total number of 14 columns in file
                                    // File format: longitude, latitude, 12 months of transition probabilities

        // Allocate and populate arrays that hold the transition probabilities
        double[][] drywet = new double[numberOfRows][numberOfColumns];
        double[][] wetwet = new double[numberOfRows][numberOfColumns];
        populateTransitionProbabilitiesArrays(drywet, wetwet, numberOfRows);

        /*** WRITE YOUR CODE BELLOW THIS LINE. DO NOT erase any of the lines above. ***/

        // Read command line inputs
        double longitute = Double.parseDouble(args[0]);
        double latitude  = Double.parseDouble(args[1]);
        int    month     = Integer.parseInt(args[2]);

        int[] forecast = oneMonthGenerator(longitute, latitude, month, drywet, wetwet);
        int drySpell = lengthOfLongestSpell(forecast, DRY);
        int wetSpell = lengthOfLongestSpell(forecast, WET);

        StdOut.println("There are " + forecast.length + " days in the forecast for month " + month);
        StdOut.println(drySpell + " days of dry spell.");

        for ( int i = 0; i < forecast.length; i++ ) {

            // This is the ternary operator. (conditional) ? executed if true : executed if false
            String weather = (forecast[i] == WET) ? "Wet" : "Dry";
            StdOut.println("Day " + (i+1) + " is forecasted to be " + weather);
        }
    }
}