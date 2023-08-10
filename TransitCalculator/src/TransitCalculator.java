// CodeCademy excercise to build a transit calculator.

import java.util.Scanner;

public class TransitCalculator {
    public static int daysUsingTransitSystem;
    public static int numberOfIndividualRides;


    //The NYC transit system has three regular fare options
    public static double perRidePrice = 2.75;
    public static double sevenDayPrice = 32.00;
    public static double thirtyDayPrice = 115.00;


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

    //Create a String method called getBestFare().
    // Inside the method, you should use the array of ride prices calculated with getRidePrices() and at least one loop to determine:
    //  1 the lowest price
    //  2 the best (corresponding) fare method
    public static String getBestFare(){
        //creating a corresponding array for the ticket possibilities
        String[] tickets = new String[3];
        tickets[0] = "pay-per-ride";
        tickets[1] = "7-day-unlimited";
        tickets[2] = "30-day-unlimited";

        double[] price = getRidePrice();
        double bestPricePerRide = price[0];
        String bestTicket = tickets[0];


        for(int i = 0; i < price.length; i++){
            if(price[i]<bestPricePerRide){
                bestPricePerRide = price[i];
                bestTicket = tickets[i];
            }
        }
        String bestChoise = "The best ticket for you is the " + bestTicket + " option. With this ticket the average ride" +
                " price will be $ " + bestPricePerRide + ",-.";

        return bestChoise;
    }



    public static void main(String[] args) {
        Scanner daysInRotterdam = new Scanner(System.in);
        System.out.println("How many days do you stay in Rotterdam?");
        int days = daysInRotterdam.nextInt();

        Scanner expectedRides = new Scanner(System.in);
        System.out.println("How many train & metro rides do you expect taking during your Stay?");
        int rides = expectedRides.nextInt();


        TransitCalculator input = new TransitCalculator(days, rides);

        System.out.println(getBestFare());



    }
}