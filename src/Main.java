import java.sql.SQLOutput;
import java.util.*;

public class Main{
    static  Scanner obj = new Scanner(System.in);
    static List<Customer> customers = new ArrayList<>();
    static List<Hotel> hotels = new ArrayList<>();
    static int customer_id = 0;
    public static void main(String[] args){
        hotels.add(new Hotel("Taj", 30, 15, 5));
        hotels.add(new Hotel("ITC", 30, 10, 10));
        hotels.add(new Hotel("Balaji Recidency", 20, 10, 7 ));

        while(true){
            printHotel();
            System.out.print("Enter Hotel Name : ");
            String hotel_name = obj.nextLine();
            boolean bool = true;

            while(bool){
                if(getHotel(hotel_name) != null ){
                    System.out.println("Hotel Room Booking Management");
                    System.out.println("1. View Available Room");
                    System.out.println("2. Book Room");
                    System.out.println("3. Cancel Booking");
                    System.out.println("4. View Booking");
                    System.out.println("5. Calculate Bill");
                    System.out.println("6. Exit");

                    System.out.print("Enter your choice : ");
                    int choice = obj.nextInt();
                    obj.nextLine();

                    switch (choice) {
                        case 1:
                            viewHotels(hotel_name);
                            break;
                        case 2:
                            booking(hotel_name);
                            break;
                        case 3:
                            cancelBooking(hotel_name);
                            break;
                        case 4:
                            BookingDetails(hotel_name);
                            break;
                        case 5:
                            showBill(hotel_name);
                            break;
                        case 6:
                            bool = false;
                            break;
                        default:
                            System.out.println("Invalid Choice, Try Again !");

                    }

                }
                else{
                    System.out.println("No Hotel is avaiable ");
                    return;
                }

            }
        }

    }

    static void printHotel(){
        if(hotels.isEmpty()){
            System.out.println("No Hotel in the list");
            return;
        }
        for(Hotel hotel : hotels){
            System.out.println("Hotel Name : "+ hotel.name +" | Avialable Single Room : "+hotel.single_qty+" | SIngle Room Price : "+hotel.single_price+" | Available double Room : "+ hotel.double_qty+" | Double room Price : "+ hotel.double_price+" | Availble Deluxe Room : "+hotel.deluxe_qty+" | Deluxe room Price : "+hotel.deluxe_price);
        }
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________________________________");

    }

    static void viewHotels(String hotel_name){
        Hotel hotel = getHotel(hotel_name);

        if(hotels == null){
            System.out.println("NO Hotel is available");
        }
        else{
            System.out.println("_____________________________________________________________________________________________________________________________________________");
            System.out.println("Hotel Name : "+ hotel.name +"\nAvialable Single Room : "+hotel.single_qty+" | Single Room Price : "+hotel.single_price+"\nAvailable double Room : "+ hotel.double_qty+" | Double room Price : "+ hotel.double_price+"\nAvailble Deluxe Room : "+hotel.deluxe_qty+" | Deluxe room Price : "+hotel.deluxe_price);
            System.out.println("_____________________________________________________________________________________________________________________________________________");

        }



    }

    static Hotel getHotel(String hotel_name){
        if(hotels.isEmpty()){
            System.out.println("No Hotel is available");
        }
        else{
            for(Hotel hotel : hotels){
                if(hotel.name.equalsIgnoreCase(hotel_name)){
                    return hotel;
                }
            }

        }
        return  null;
    }


    static Customer getCustomer(int id){
        if(customers.isEmpty()){
            System.out.println("No customer is available");
        }
        else{
            for(Customer cus : customers){
                if(cus.customer_id == id){
                    return cus;
                }
            }
        }
        return null;
    }

    static void booking(String hotel_name){
        viewHotels(hotel_name);
        Hotel hotel = getHotel(hotel_name);

        System.out.print("Enter your Name : ");
        String name = obj.nextLine();
        System.out.print("Enter Room Type : ");
        String room_type = obj.nextLine();
        System.out.print("Enter No.of rooms : ");
        int no_of_rooms = obj.nextInt();
        obj.nextLine();
        System.out.print("Enter No. of Days : ");
        int no_of_days = obj.nextInt();

        if(room_type.equalsIgnoreCase("Single")){
            if( no_of_rooms > hotel.single_qty || no_of_rooms <= 0){
                System.out.println(no_of_rooms+" "+room_type+" Room not available ");
                System.out.println(room_type+" room availablity : "+hotel.single_qty);
                return;
            }
            else{
                if(no_of_days <= 0){
                    System.out.println("No of days Must be greater than 0 ");
                }
                else{
                    double bill = (no_of_rooms * hotel.single_price)*no_of_days;
                    hotel.single_qty -= no_of_rooms;
                    customers.add(new Customer(++customer_id, name, room_type,no_of_rooms,no_of_days, bill));
                }
            }

        }
        else if(room_type.equalsIgnoreCase("double")){
            if(no_of_rooms > hotel.double_qty || no_of_rooms <= 0){
                System.out.println(no_of_rooms+" "+room_type+" Room not available ");
                System.out.println(room_type+" availablity : "+hotel.double_qty);
                return;
            }
            else{
                if(no_of_days <= 0){
                    System.out.println("No of days Must be greater than 0 ");
                }
                else{
                    double bill = (no_of_rooms * hotel.double_price)* no_of_days;
                    hotel.double_qty -= no_of_rooms;
                    customers.add(new Customer(++customer_id, name, room_type,no_of_rooms,no_of_days, bill));
                }
            }
        }
        else if(room_type.equalsIgnoreCase("deluxe")){
            if(no_of_days <= 0 || no_of_rooms > hotel.deluxe_qty || no_of_rooms <= 0){
                System.out.println(no_of_rooms+" "+room_type+" Room not available ");
                System.out.println(room_type+" availablity : "+hotel.deluxe_qty);
                return;
            }
            else{
                if(no_of_days <= 0){
                    System.out.println("No of days Must be greater than 0 ");
                }
                else{
                    double bill = (no_of_rooms * hotel.deluxe_price)* no_of_days;
                    hotel.deluxe_qty -= no_of_rooms;
                    customers.add(new Customer(++customer_id, name, room_type,no_of_rooms,no_of_days, bill));
                }


            }
        }
        else{
            System.out.println("Invalid Room Type ....!");
        }

        System.out.println("Room Booked successfully with Customer ID : "+customer_id);
    }

    public static void cancelBooking(String hotel_name){
        Hotel hotel = getHotel(hotel_name);

        System.out.print("Enter Customer ID : ");
        int id = obj.nextInt();
        obj.nextLine();
        Customer customer = getCustomer(id);
        if(customer == null){
            System.out.println("Customer is not available");
            return;
        }
        else{
            if(customer.room_type.equalsIgnoreCase("Single")){
                hotel.single_qty += customer.no_of_rooms;
            }
            else if(customer.room_type.equalsIgnoreCase("DOuble")){
                hotel.double_qty += customer.no_of_rooms;
            }
            else if(customer.room_type.equalsIgnoreCase("Deluxe")){
                hotel.deluxe_qty += customer.no_of_rooms;
            }

        }
        System.out.println("Booking cancelled for Customer ID "+ customer.customer_id);

    }

    static void BookingDetails(String hotel_name){
        Hotel hotel = getHotel(hotel_name);

        System.out.print("Enter Customer ID : ");
        int id = obj.nextInt();

        Customer cus = getCustomer(id);

        if(cus == null){
            System.out.println("Customer not available");
        }
        else{
            System.out.println("___________________________________________________________________________________________");
            System.out.println("Customer ID : "+ cus.customer_id);
            System.out.println("Customer Name : "+ cus.name);
            System.out.println("Room Type : "+ cus.room_type);
            System.out.println("No.of Rooms : "+ cus.no_of_rooms);
            System.out.println("No. of Days : "+ cus.no_of_days);
            System.out.println("___________________________________________________________________________________________");


        }
    }

    static void  showBill(String hotel_name){
        Hotel hotel = getHotel(hotel_name);

        System.out.print("Enter Customer ID : ");
        int id = obj.nextInt();

        Customer cus = getCustomer(id);

        if(cus == null){
            System.out.println("Customer not available");
        }
        else{
            System.out.println("___________________________________________________________________________________________");
            System.out.println("Customer ID : "+ cus.customer_id);
            System.out.println("Customer Name : "+ cus.name);
            System.out.println("Bill : "+ cus.bill);
            System.out.println("___________________________________________________________________________________________");


        }

    }


}