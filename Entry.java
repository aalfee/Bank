public class Entry {
    private static int logCount = 0;
    public int count;

    public Entry (int n){
        logCount++;
        count = n;
    }

    public static int getLogCount(){
        return logCount;
    }
    public static void clearLogCount(){
        logCount = 0;
    }

    public String toString(){
        return "Entry "+count+" of "+logCount+": ";
    }
}