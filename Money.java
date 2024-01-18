public class Money extends Entry{
    
    private int dollars;
    private int cents;
    public static int count = 1;

    public Money(){
        super(0);
        dollars = 0;
        cents = 0;
    }

    public Money (int d, int c){
        super(1);
        dollars = d;
        cents = c;
    }
    
    public Money(int n, int d, int c){
        super(n);
        dollars = d;
        cents = c;
    }

    public Money(String s){
        super(count++); 

        for(int i = 0; i < s.length(); i++){
        dollars = (int) Double.parseDouble(s)/1;
        cents = (int)(Double.parseDouble(s)*100)%100;
        }
        
    }

    public Money(double d){
        super(count++);
        dollars = (int)d/1;
        cents = (int)(d*100)%100;
    }

    public int getDollars(){
        return dollars;
    }
    public int getCents(){
        return cents;
    }
    public static void clearCount(){
        count = 1;
    }

    public String dollarsToString(){
        if(getDollars() < 1000){
            return String.valueOf(getDollars());
        }
       if(getDollars() < 1000000) {
        return +getDollars()/1000+","+getDollars()%1000;
       }
       if(getDollars() < 1000000000){
        return +getDollars()/1000000+","+(getDollars()%1000000)/1000+","+getDollars()%1000;
       }
       return +getDollars()/1000000+","+(getDollars()%1000000)/1000+","+getDollars()%1000;
    }

    public String centsToString(){
        if (getCents() < 10) {
            return (".0" + getCents());
        }
        return ("."+getCents());
    }

     public double getValueAsDouble(){
        double value = 0; 
        value += (double)cents;
        value = value/100;
        value += (double)dollars;
        return value;
    }

    public String toString(){ 

        return super.toString()+"$"+dollarsToString()+centsToString();
    }
}
