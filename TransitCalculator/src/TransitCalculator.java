import java.lang.reflect.Array;

public class TransitCalculator {
    public static int daysUsingTransitSystem = 10 ;
    public static int numberOfIndividualRides = 10;


    //The NYC transit system has three regular fare options
    public static double perRidePrice = 2.75;
    public static double sevenDayPrice = 33.00;
    public static double thirtyDayPrice = 127.00;


    //Build a class constructor for TransitCalculator that accepts the number of days and rides...
    // and sets the values for the corresponding fields
    public TransitCalculator(int days, int rides) {
        daysUsingTransitSystem = days;
        numberOfIndividualRides = rides;
    }


    //Create a method unlimited7Price() with a double return type. The method should return
    // the overall price per ride of using the 7-day Unlimited option
    public static double unlimited7Price() {

        //calculating how many seven day tickets someone needs. So you can see if 3 x 7-days is cheaper as 1 x 30-days
        double numOfSevenDayTickets = Math.ceil(((double)daysUsingTransitSystem / 7));

        //calculating total ticket price
        double totalPriceOfSevenDayTickets = sevenDayPrice * numOfSevenDayTickets;

        return totalPriceOfSevenDayTickets / numberOfIndividualRides;
    }

//Build a method getRidePrices() that will return an array of doubles. Inside the method, you’ll need to calculate
// the price per ride for each fare option.Like did in unlimited7Price
    public static double[] getRidePrice() {
        // calculating the cost per ride of the ThirtyDayRidePrice
        double numOfThirtyDayTickets = Math.ceil(((double)daysUsingTransitSystem / 30));
        double totalPriceOfSevenDayTickets = thirtyDayPrice * numOfThirtyDayTickets;
        double unlimited30Price = totalPriceOfSevenDayTickets / numberOfIndividualRides;

        double[] ridePrice = new double[3];
        ridePrice[0] = perRidePrice;
        ridePrice[1] = unlimited7Price();
        ridePrice[2] = unlimited30Price;
        // above could use some consistency...

       return ridePrice;
    }

    public static String getBestFare(){

        double[] bestPrice = Array.get(getRidePrice(),0);

        for(int i = 0; i < getRidePrice().length; i++){

        }

        return bestPrice;
    }
*/

//creating a toString-method to test array functionality
    public String toString(){

        return null;
    }



    public static void main(String[] args) {
        TransitCalculator touristA = new TransitCalculator(15, 20);
        touristA.unlimited7Price();

        System.out.println(unlimited7Price());

    }
}