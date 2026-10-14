public class Hotel {
    String name;
    int  single_qty;
    double single_price;
    int double_qty;
    double double_price;
    int deluxe_qty;
    double deluxe_price;
//    int single_room_no = 1;
//    int double_room_no = 101;
//    int deluxe_room_no = 1001;

    Hotel(String name, int single_qty,  int double_qty,  int deluxe_qty){
        this.name = name;
        this.single_qty = single_qty;
        this.single_price = 1500;
        this.double_qty = double_qty;
        this.double_price = 2500;
        this.deluxe_qty = deluxe_qty;
        this.deluxe_price = 4500;
    }


}
