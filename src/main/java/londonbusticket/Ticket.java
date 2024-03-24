package londonbusticket;

public class Ticket {

    // distance, seatNo, price, journey type

    public double distance;
    public int journeyType;
    public double price;
    public int seatNo;
//    public int age;

    public void printTicket(Bus bus){

        System.out.println("---- Ticket Details ----");
        System.out.println("Bus no: " + bus.busNo);
        System.out.println("Journey type: "+ (this.journeyType == 1 ? "One Way" : "Round Trip"));
        System.out.println("Distance: "+ this.distance + "km");
        System.out.println("Seat no: "+ this.seatNo);
        System.out.println("Total price: $" + this.price);
        System.out.println("Have a nice trip!");

    }

}
