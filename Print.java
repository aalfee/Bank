import java.util.*;

public class Print {
    // Total print function
    public static int totalDollars = 0; 
    public static int totalCents = 0;

    public static String Total(ArrayList<Money> m){
        for(Money i : m){
            totalDollars += i.getDollars();
            totalCents += i.getCents();
            if(totalCents > 99){
                totalDollars++;
                totalCents-=100; 
            }
        }
        return ("Total is: $"+getTotalDollars()+centsToString(getTotalCents()));
    }
    public static int getTotalDollars(){
        return totalDollars;
    }

    public static int getTotalCents(){
        return totalCents;
    }

    public static void clearTotal(){
        totalDollars = 0;
        totalCents = 0;
    }

    // Mean print function
    public static double getTotalAsDouble(){
        double avg = 0; 
        avg += getTotalCents();
        avg = avg/100;
        avg += getTotalDollars();
        avg = avg/Entry.getLogCount();
        return avg;
    }

    public static String Mean(){
        int c = (int)Math.round((getTotalAsDouble()*100)%100);
        int d = (int) getTotalAsDouble();
        
        
        return ("Mean is: $"+d+centsToString(c));
        
    }

    // Median print function
    public static String Median(ArrayList<Money> m) {
        ArrayList<Double> doubleList = new ArrayList<>();

        for (Money i : m) {
            // Using the getValueAsDouble method from Money class to get the value as a double
            double value = i.getValueAsDouble();
            doubleList.add(value);
        }

        Collections.sort(doubleList);

        int size = doubleList.size();

        // Calculate the median for both odd and even ArrayList size
        double median;
        if (size % 2 == 0) {
            // For even size, take the average of the two middle values
            median = (doubleList.get((size - 1) / 2) + doubleList.get(size / 2)) / 2;
        } else {
            // For odd size, directly take the middle value
            median = doubleList.get(size / 2);
        }

        // Round the median value to the nearest cent
        double roundedMedian = Math.round(median * 100.0) / 100.0;

        return ( "Median is: $"+roundedMedian);
    }

    // Mode print function
    public static String Mode(ArrayList<Money> m ){
        Map<Double, Integer> frequencyMap = new HashMap<>();    // Create a hashmap to store the frequency of each unique value
        double currentMode = Double.MIN_VALUE;    // GIve the current mode the lowest possible integer value for comparisson
        int maxFrequency = 0;

        for(Money i : m){                       // Loop through each Money object in the array
            double value = i.getValueAsDouble();    // Get the double value of the money object 
            int frequency = frequencyMap.getOrDefault(value, 0) + 1;    // Get the current frequency of the value from the map (0 if not present) 
            frequencyMap.put(value,frequency);      // Update the frequency map with the incremented frequency


            if (frequency > maxFrequency) {        // Check if the current value has a higher frequency than the current mode
                maxFrequency = frequency;          // Update current mode and its frequency
                currentMode = value;
            }
        }
        return ("Mode is: $"+currentMode);
    }


    // Cents printing
    public static String centsToString(int cents){
        if (cents < 10) {
            return (".0" + cents);
        }
        return ("."+cents);
    }

    public static String toString(ArrayList<Money> m){
        return (Total(m)+"\n"+Mean()+"\n"+Median(m)+"\n"+Mode(m));
    }

}
