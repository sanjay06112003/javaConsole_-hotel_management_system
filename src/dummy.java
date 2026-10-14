//public class dummy {
//    Hotel hotels = new Hotel();
//
//    hotels.add(new Hotel("Taj", 30, 15, 5));
//        hotels.add(new Hotel("ITC", 30, 10, 10));
//
//
//
//        while(true) {
//
//        printHotel();
//        System.out.println();
//
//        System.out.print("Enter Hotel Name : ");
//        String hotel_name = obj.nextLine();
//        if (isHotelAvailable(hotel_name)) {
//
//            Hotel hotel = getHotel(hotel_name);
//
//            while(true){
//                System.out.println("Hotel Room Booking Management");
//                System.out.println("1. View Available Room");
//                System.out.println("2. Book Room");
//                System.out.println("3. Cancel Booking");
//                System.out.println("4. View Booking");
//                System.out.println("5. Calculate Booking");
//                System.out.println("6. Exit");
//
//                System.out.print("Enter your choice : ");
//                int choice = obj.nextInt();
//                obj.nextLine();
//
//                switch (choice) {
//                    case 1:
//                        viewAvaialbleRoom(hotel);
//                        break;
//                    case 2:
//                        bookRoom(hotel);
//                        break;
//                    case 3:
//                        cancelBooking(hotel);
//                        break;
//                    case 4:
//                        viewBooking(hotel);
//                        break;
//                    case 5:
//                        viewBooking(hotel);
//                        break;
//                    case 6:
//                        return;
//                    default:
//                        System.out.println("Invalid Choice, Try Again !");
//
//                }
//
//            }
//        }
//        else{
//            System.out.println("INvalid Hotel Name , Enter Vaild Hotel Name ");
//            System.out.println("---------------------------------------------------------------------------------------------------");
//        }
//    }
//
//
//
//
//}
//static void printHotel(){
//    if(hotels.isEmpty()){
//        System.out.println("No Hotel in the list");
//        return;
//    }
//    for(Hotel hotel : hotels){
//        System.out.println("Hotel Name : "+ hotel.name +" | Avialable Single Room : "+hotel.single_qty+" | SIngle Room Price : "+hotel.single_price+" | Available double Room : "+ hotel.double_qty+" | Double room Price : "+ hotel.double_price+" | Availble Deluxe Room : "+hotel.deluxe_qty+" | Deluxe room Price : "+hotel.deluxe_price);
//    }
//
//}
//
//static boolean isHotelAvailable(String hotel_name){
//    for(Hotel hotel : hotels){
//        if(hotel.name.equalsIgnoreCase(hotel_name)){
//            return true;
//        }
//    }
//    return false;
//}
//
//static Hotel getHotel(String name){
//    for(Hotel hotel : hotels){
//        if(hotel.name.equalsIgnoreCase(name)){
//            return hotel;
//        }
//    }
//    return null;
//}
//
//static void viewAvaialbleRoom(Hotel hotel){
//    System.out.println("Hotel Name : "+ hotel.name +" | Avialable Single Room : "+hotel.single_qty+" | SIngle Room Price : "+hotel.single_price+" | Available double Room : "+ hotel.deluxe_qty+" | Double room Price : "+ hotel.double_price+" | Availble Deluxe Room : "+hotel.deluxe_qty+" | Deluxe room Price : "+hotel.deluxe_price);
//    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//
//}
//static void bookRoom(Hotel hotel){
//    viewAvaialbleRoom(hotel);
//    System.out.print("Enter your Name : ");
//    String name = obj.nextLine();
//    System.out.print("Enter type of room : ");
//    String room_type = obj.nextLine();
//    System.out.print("Enter NO. of Rooms : ");
//    int no_of_rooms = obj.nextInt();
//    obj.nextLine();
//    System.out.print("Enter No. of days : ");
//    int no_of_days = obj.nextInt();
//    obj.nextLine();
//    customer_id++;
//    customers.add(new Customer(customer_id, name,room_type,no_of_rooms,no_of_days));
//    Customer curr_cus = customers.get(customers.getLast().customer_id-1);
//
//    if(room_type.equalsIgnoreCase("single")){
//        if(hotel.single_qty <= 0){
//            System.out.println("Single room is not available");
//            return;
//        }
//        else{
//            if(hotel.single_qty < no_of_rooms || no_of_rooms <= 0){
//                System.out.println(no_of_rooms+" not avialble");
//                return;
//            }
//            else{
//                hotel.single_qty =(hotel.single_qty - no_of_rooms);
//                curr_cus.bill = no_of_days * (hotel.single_price) * no_of_rooms;
//
//            }
//
//
//        }
//    }
//
//    if(room_type.equalsIgnoreCase("double")){
//        if(hotel.double_qty <= 0){
//            System.out.println("Double room is not available");
//            return;
//        }
//        else{
//            if(hotel.deluxe_qty < no_of_rooms || no_of_rooms <= 0){
//                System.out.println(no_of_rooms+" not avialble");
//                return;
//            }
//            else{
//                hotel.double_qty = (hotel.double_qty - no_of_rooms);
//                curr_cus.bill = no_of_days * (hotel.double_price) * no_of_rooms;
//            }
//
//
//        }
//    }
//
//    if(room_type.equalsIgnoreCase("deluxe")){
//        if(hotel.deluxe_qty <= 0){
//            System.out.println("Deluxe room is not available");
//            return;
//        }
//        else{
//            if(hotel.deluxe_qty < no_of_rooms || no_of_rooms <= 0){
//                System.out.println(no_of_rooms+" not avialble");
//                return;
//            }
//            else{
//                hotel.deluxe_qty -= no_of_rooms;
//                curr_cus.bill = no_of_days * (hotel.deluxe_price) * no_of_rooms;
//            }
//
//
//        }
//    }
//
//    System.out.println("Customer ID : "+customer_id+" Room Booked successfully");
//
//}
//
//static void cancelBooking(Hotel hotel) {
//    System.out.print("Enter customer ID : ");
//    int customer_id = obj.nextInt();
//
//    Customer customer = getCustomerById(customer_id);
//    if(customer == null ){
//        System.out.println("Customer not available");
//        return;
//    }
//    else{
//        if(customer.room_type.equalsIgnoreCase("single")){
//            hotel.single_qty+=customer.no_of_rooms;
//        }
//        if(customer.room_type.equalsIgnoreCase("double")){
//            hotel.double_qty+=customer.no_of_rooms;
//        }
//        if(customer.room_type.equalsIgnoreCase("deluxe")){
//            hotel.deluxe_qty+=customer.no_of_rooms;
//        }
//    }
//    customers.remove(customer);
//
//    System.out.println("Room cancelled successfully");
//
//
//}
//static Customer getCustomerById(int id){
//
//
//    for(Customer cus : customers){
//        if(cus.customer_id == id){
//            return cus;
//        }
//    }
//
//    return null;
//}
//static void viewBooking(Hotel hotel){
//    System.out.print("Enter customer ID : ");
//    int id = obj.nextInt();
//
//    Customer cus = getCustomerById(id);
//
//    if(cus == null){
//        System.out.println("NO customer is available");
//    }
//    else{
//        System.out.println("Customer ID : "+cus.customer_id+"\nCustomer Name : " + cus.name+"\nRoom Type : "+cus.room_type+"\nNo. Of Rooms : "+cus.no_of_rooms+"\nNo. of Days : "+cus.no_of_days+"\n Total Bill : "+cus.bill);
//    }
//}
