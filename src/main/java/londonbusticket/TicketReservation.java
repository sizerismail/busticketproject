package londonbusticket;
import java.util.Scanner;

public class TicketReservation {

    public static void main(String[] args) {

        Bus bus = new Bus("Baker Street, 74");
//        System.out.println("bus.seats = " + bus.seats);
        Ticket ticket = new Ticket();

        start(bus, ticket);


    }

    // To get the input from the user

    public static void start(Bus bus, Ticket ticket) {
        Scanner scan = new Scanner(System.in);

        int select;

        do {
            System.out.println("*** Welcome to our Ticket Reservation System ***");
            System.out.println("Enter the distance in KM");
            double distance = scan.nextDouble();

            System.out.println("Enter the journey type");
            System.out.println("1- One way \n2- Round Trip");
            int type = scan.nextInt();



            System.out.println("Enter your age");
            int age = scan.nextInt();

            System.out.println("Choose the seat number");
            System.out.println("Single seats is 20% more expensive");
            System.out.println("Available seats: " + bus.seats);  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32]

            // Conditions
            boolean check = type == 1 || type ==2;

            for (int i = 0; i <3; i++) {

                int seat = scan.nextInt();

                // Conditions


                if (distance>0 && age>0 && check){

                    if(bus.seats.contains(String.valueOf(seat))){
                        // remove the seat from the available seat list
                        bus.seats.remove(String.valueOf(seat));
                        ticket.distance = distance;
                        ticket.journeyType = type;
                        ticket.seatNo = seat;
                        ticket.price = calculatePrice(ticket, age);  // method call to calculate the price
                        ticket.printTicket(bus);
                        break;
                    }else{
                        if(i==2){
                            System.out.println("You have failed 3 attempts, please start the process again");
                            break;
                        }else{
                            System.out.println("The seat number is not available" +
                                    "\nChoose the seat number" +
                                    "\nSingle seats is 20% more expensive" +
                                    "\nAvailable seats: " + bus.seats);
                        }
                    }

                }else {
                    System.out.println("You Have Entered Wrong Data!");
                    break;
                }

            }


            // To give a second chance to the user in case of any invalid value
            System.out.println("Press any number to Restart or 0 to quit");
            select = scan.nextInt();


        } while (select !=0);


    }


    // Create a method to calculate the price

    public static double calculatePrice(Ticket ticket, int age) {
        double dis = ticket.distance;
        int type = ticket.journeyType;
        int seat = ticket.seatNo;

        // journeyType (Single or Round Trip) and seat (Single or not) condition

        double totalPrice = 0;

        switch (type) {
            case 1:  // One way
                if (seat % 3 == 0) { // single seat
                    totalPrice = dis * 1.2;
                    System.out.println("Total price for Single seat:" + totalPrice);
                } else {
                    totalPrice = dis * 1;
                    System.out.println("Total price for Regular seat:" + totalPrice);
                }
                break;
            case 2:  // Round Trip
                if (seat % 3 == 0) {
                    totalPrice = dis * 2.4;
                    System.out.println("Total price for Single seat on a Round Trip:" + totalPrice);
                } else {
                    totalPrice = dis * 2;
                    System.out.println("Total price for Regular seat on a Round Trip:" + totalPrice);
                }

                totalPrice = totalPrice * 0.8;
                System.out.println("Total price after Round-Trip discount:" + totalPrice);
                break;
        }

        // age discount

        if (age < 12) {
            totalPrice = totalPrice * 0.5; // 50% discount for children
            System.out.println("Total price after child discount: " + totalPrice);
        } else if (age < 25) {
            totalPrice = totalPrice * 0.9; // 10% discount for student
            System.out.println("Total price after student discount: " + totalPrice);
        } else if (age > 65 && age < 150) {
            totalPrice = totalPrice * 0.7; // 30% discount for senior citizens
            System.out.println("Total price after seniors discount: " + totalPrice);
        }

        return totalPrice;
    }



}
