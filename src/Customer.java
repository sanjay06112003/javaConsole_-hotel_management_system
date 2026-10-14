public class Customer {

    int customer_id;
    String name;
    String room_type;
    int no_of_rooms;
    int no_of_days;
    double bill;

    Customer(int customer_id, String name, String room_type, int no_of_rooms, int no_of_days, double bill){
        this.customer_id = customer_id;
        this.name = name;
        this.room_type = room_type;
        this.no_of_rooms = no_of_rooms;
        this.no_of_days = no_of_days;
        this.bill = bill;
    }
}
